package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.alarmapp.alarm.AlarmClockBuilder;
import com.teamproject.plastikproject.alarmapp.alarm.AlarmClockLab;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Denys on 27.01.2017.
 */
public class DayActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.monday)
    TextView monday;
    @BindView(R.id.tuesday)
    TextView tuesday;
    @BindView(R.id.wednesday)
    TextView wednesday;
    @BindView(R.id.thursday)
    TextView thursday;
    @BindView(R.id.friday)
    TextView friday;
    @BindView(R.id.saturday)
    TextView saturday;
    @BindView(R.id.sunday)
    TextView sunday;
    private AlarmClockLab alarmClockLab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        ButterKnife.bind(this);

        monday.setOnClickListener(this);
        tuesday.setOnClickListener(this);
        wednesday.setOnClickListener(this);
        thursday.setOnClickListener(this);
        friday.setOnClickListener(this);
 saturday.setOnClickListener(this);
 sunday.setOnClickListener(this);

        alarmClockLab = new AlarmClockBuilder().builderLab(0);
//        String remind = alarmClockLab.desc;
//        switch (remind) {
//            case "monday":
//                sunday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            case "tuesday":
//                tuesday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            case "wednesday":
//                wednesday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            case "thursday":
//                thursday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            case "friday":
//                friday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            case "saturday":
//                saturday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            case "sunday":
//                sunday.setTextColor(ContextCompat.getColor(this, R.color.colorRed_500));
//                break;
//            default:
//                break;
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.monday:
                alarmClockLab.setDesc("monday");
                break;
            case R.id.tuesday:
                alarmClockLab.setDesc("tuesday");
                break;
            case R.id.wednesday:
                alarmClockLab.setDesc("wednesday");
                break;
            case R.id.thursday:
                alarmClockLab.setDesc("thursday");
                break;
            case R.id.friday:
                alarmClockLab.setDesc("friday");
                break;
                case R.id.saturday:
                alarmClockLab.setDesc("saturday");
                break;
            case R.id.sunday:
                alarmClockLab.setDesc("sunday");
                break;
            default:
                break;
        }
        finish();
    }
}
