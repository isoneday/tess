package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.alarmapp.alarm.AlarmClockBuilder;
import com.teamproject.plastikproject.alarmapp.alarm.AlarmClockLab;
import com.teamproject.plastikproject.alarmapp.alarm.AlarmManagerHelper;
import com.teamproject.plastikproject.alarmapp.alarm.db.AlarmDBUtils;
import com.teamproject.plastikproject.alarmapp.models.alarm.AlarmModel;
import com.teamproject.plastikproject.plastik.helper.SessionManager;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.RestApi;
import com.teamproject.plastikproject.plastik.notif.modeladdlokasi.ModelAddlokasi;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Denys on 21.01.2017.
 */
public class AddAlarmActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.alarm_cv_repeat)
    CardView cvRepeat;
    @BindView(R.id.repeat_content)
    TextView tvRepeat;
    @BindView(R.id.alarm_cv_ring)
    CardView cvRing;
    @BindView(R.id.ringtones_content)
    TextView tvRingtones;
    @BindView(R.id.alarm_cv_remind)
    CardView cvRemind;
    @BindView(R.id.remind_content)
    TextView tvRemind;
    @BindView(R.id.switch_vibration)
    SwitchCompat switchVibration;
    @BindView(R.id.switch_weather)
    SwitchCompat switchWeather;

    public static TextView tvHours;
    public static TextView tvMin;

    private static AlarmClockLab alarmClockLab;
    @BindView(R.id.edtdesc)
    EditText edtdesc;
    @BindView(R.id.txtday)
    TextView txtday;
    @BindView(R.id.txtselectday)
    TextView txtselectday;
    @BindView(R.id.dayform)
    CardView cvdayform;

    public static Intent newIntent(Context context) {
        return new Intent(context, AddAlarmActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);

        tvHours = (TextView) findViewById(R.id.alarm_time_hours);
        tvMin = (TextView) findViewById(R.id.alarm_time_min);

        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(R.string.addAlarmActivityTitle);

        int[] currentTime = getCurrentTime();
        alarmClockLab = new AlarmClockBuilder().builderLab(0);
        alarmClockLab.setEnable(true);
        alarmClockLab.setHour(currentTime[0]);
        alarmClockLab.setMinute(currentTime[1]);
//        alarmClockLab.setRepeat(getString(R.string.repeatWeekDay));
        alarmClockLab.setDesc(edtdesc.getText().toString());
//        alarmClockLab.setSunday(false);
//        alarmClockLab.setMonday(true);
//        alarmClockLab.setTuesday(true);
//        alarmClockLab.setWednesday(true);
//        alarmClockLab.setThursday(true);
//        alarmClockLab.setFriday(true);
//        alarmClockLab.setSaturday(false);
        alarmClockLab.setRingPosition(0);
        alarmClockLab.setRing(firstRing(this));
        alarmClockLab.setVolume(10);
        alarmClockLab.setVibrate(false);
        alarmClockLab.setRemind(3);
        alarmClockLab.setWeather(false);

        tvRingtones.setText(alarmClockLab.ring);
        switchVibration.setChecked(alarmClockLab.vibrate);
        cvRepeat.setOnClickListener(this);
        cvRing.setOnClickListener(this);
        cvRemind.setOnClickListener(this);
        cvdayform.setOnClickListener(this);
        switchWeather.setChecked(alarmClockLab.weather);

        int hour = alarmClockLab.hour;
        int minute = alarmClockLab.minute;

        String h = String.valueOf(hour);
        String m = String.valueOf(minute);

        if (minute < 10) {
            m = "0" + minute;
        }
        if (hour < 10) {
            h = "0" + hour;
        }
        tvHours.setText(h);
        tvMin.setText(m);
        txtselectday.setText("monday");
        switchVibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                alarmClockLab.setVibrate(isChecked);
            }
        });

        switchWeather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                alarmClockLab.setWeather(isChecked);
            }
        });
    }

    @OnClick(R.id.alarm_cv_time)
    public void OnTimeClick() {
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @OnClick(R.id.floating_action_btn2)
    public void OnFAB2Click() {

        SessionManager manager = new SessionManager(AddAlarmActivity.this);

        String iduesr = manager.getIdUser();
        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        String waktu = tvHours.getText().toString() + ":" + tvMin.getText().toString();
        String day =txtselectday.getText().toString();
        if (day.equals("")){
            txtday.setError("day cannot empty");
            Toast.makeText(AddAlarmActivity.this, "day cannot empty", Toast.LENGTH_SHORT).show();
        }else {
            AlarmDBUtils.insertAlarmClock(AddAlarmActivity.this, alarmClockLab);
            AlarmModel alarm = AlarmDBUtils.queryAlarmClock(AddAlarmActivity.this).get(0);
            if (alarm.enable) {
                AlarmManagerHelper.startAlarmClock(AddAlarmActivity.this, alarm);
            }

            Call<ModelAddlokasi> addlokasiCall = api.insertskedule(iduesr, day, waktu, "true");
            addlokasiCall.enqueue(new Callback<ModelAddlokasi>() {
                @Override
                public void onResponse(Call<ModelAddlokasi> call, Response<ModelAddlokasi> response) {
                    if (response.isSuccessful()) {
//                     Toast.makeText(AddAlarmActivity.this, "success", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<ModelAddlokasi> call, Throwable t) {

                }
            });

            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvRingtones.setText(alarmClockLab.ring);
        tvRemind.setText(getRemindString(alarmClockLab.remind));
        txtselectday.setText(alarmClockLab.desc);
        String hari =txtselectday.getText().toString();
        if (hari.equals("monday")) {
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            boolean monday = !alarmClockLab.monday;
            alarmClockLab.setMonday(monday);
            alarmClockLab.setSunday(false);
            alarmClockLab.setTuesday(false);
            alarmClockLab.setSaturday(false);
            alarmClockLab.setWednesday(false);
            alarmClockLab.setThursday(false);
            alarmClockLab.setFriday(false);
            tvRepeat.setText(alarmClockLab.repeat);

        }else if (hari.equals("tuesday")){
            // alarmClockLab.setRepeat("Tue");
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            boolean tuesday = !alarmClockLab.tuesday;
            alarmClockLab.setTuesday(true);
            alarmClockLab.setSunday(false);
            alarmClockLab.setMonday(false);
            alarmClockLab.setSaturday(false);
            alarmClockLab.setWednesday(false);
            alarmClockLab.setThursday(false);
            alarmClockLab.setFriday(false);
            tvRepeat.setText(alarmClockLab.repeat);
        }else if (hari.equals("wednesday")){
            // alarmClockLab.setRepeat("Tue");
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            boolean tuesday = !alarmClockLab.tuesday;
            alarmClockLab.setTuesday(false);
            alarmClockLab.setSunday(false);
            alarmClockLab.setMonday(false);
            alarmClockLab.setSaturday(false);
            alarmClockLab.setWednesday(true);
            alarmClockLab.setThursday(false);
            alarmClockLab.setFriday(false);
            tvRepeat.setText(alarmClockLab.repeat);
        }else if (hari.equals("thursday")){
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            alarmClockLab.setTuesday(false);
            alarmClockLab.setSunday(false);
            alarmClockLab.setMonday(false);
            alarmClockLab.setSaturday(false);
            alarmClockLab.setWednesday(false);
            alarmClockLab.setThursday(true);
            alarmClockLab.setFriday(false);
            tvRepeat.setText(alarmClockLab.repeat);
        }else if (hari.equals("friday")){
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            alarmClockLab.setTuesday(false);
            alarmClockLab.setSunday(false);
            alarmClockLab.setMonday(false);
            alarmClockLab.setSaturday(false);
            alarmClockLab.setWednesday(false);
            alarmClockLab.setThursday(false);
            alarmClockLab.setFriday(true);
            tvRepeat.setText(alarmClockLab.repeat);
        }else if (hari.equals("saturday")){
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            alarmClockLab.setTuesday(false);
            alarmClockLab.setSunday(false);
            alarmClockLab.setMonday(false);
            alarmClockLab.setSaturday(true);
            alarmClockLab.setWednesday(false);
            alarmClockLab.setThursday(false);
            alarmClockLab.setFriday(false);
            tvRepeat.setText(alarmClockLab.repeat);
        }else if (hari.equals("sunday")){
            alarmClockLab.setRepeat(getString(R.string.repeatChoice));
            alarmClockLab.setTuesday(false);
            alarmClockLab.setSunday(true);
            alarmClockLab.setMonday(false);
            alarmClockLab.setSaturday(false);
            alarmClockLab.setWednesday(false);
            alarmClockLab.setThursday(false);
            alarmClockLab.setFriday(false);
            tvRepeat.setText(alarmClockLab.repeat);
        }
//        if (txtselectday.equals("monday")){
//
//           }
    }

    private String getRemindString(int remind) {
        String remindString = "";
        if (remind == 3) {
            remindString = getString(R.string.remindThreeMinutes);
        } else if (remind == 5) {
            remindString = getString(R.string.remindFiveMinutes);
        } else if (remind == 10) {
            remindString = getString(R.string.remindTenMinutes);
        } else if (remind == 20) {
            remindString = getString(R.string.remindTwentyMinutes);
        } else if (remind == 30) {
            remindString = getString(R.string.remindHalfHour);
        }
        return remindString;
    }

    private String firstRing(Context context) {
        RingtoneManager ringtoneManager = new RingtoneManager(context);
        ringtoneManager.setType(RingtoneManager.TYPE_ALARM);
        Cursor cursor = ringtoneManager.getCursor();
        String ringName = null;
        while (cursor.moveToNext()) {
            ringName = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);
            if (ringName != null) {
                break;
            }
        }
        cursor.close();
        return ringName;
    }

    private int[] getCurrentTime() {
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int minute = time.get(Calendar.MINUTE);
        return new int[]{hour, minute};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alarm_cv_repeat:
                startActivity(new Intent(RepeatActivity.newIntent(this)));
                break;
            case R.id.alarm_cv_ring:
                startActivity(RingActivity.newIntent(this));
                break;
            case R.id.alarm_cv_remind:
                startActivity(new Intent(this, RemindActivity.class));
                break;
            case R.id.dayform:
                startActivity(new Intent(this, DayActivity.class));
                break;
            default:
                break;
        }
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        public TimePickerFragment() {
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String min = String.valueOf(minute);
            String hour = String.valueOf(hourOfDay);

            tvHours.setText(hour);
            tvMin.setText(min);
            alarmClockLab.setMinute(minute);
            alarmClockLab.setHour(hourOfDay);


        }
    }
}
