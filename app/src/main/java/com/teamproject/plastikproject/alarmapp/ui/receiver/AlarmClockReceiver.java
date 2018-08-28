package com.teamproject.plastikproject.alarmapp.ui.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


import com.teamproject.plastikproject.alarmapp.models.ModelAddTropy;
import com.teamproject.plastikproject.alarmapp.ui.activity.BootAlarmActivity;
import com.teamproject.plastikproject.plastik.helper.SessionManager;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient2;
import com.teamproject.plastikproject.plastik.network.RestApi;
import com.teamproject.plastikproject.plastik.notif.AddGeofenceFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Denys on 24.01.2017.
 */

public class AlarmClockReceiver extends BroadcastReceiver {


    public static final String ALARM_CLOCK = "alarm_clock";

    public AlarmClockReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent bootIntent = new Intent(context, BootAlarmActivity.class);
        bootIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        bootIntent.putExtra(ALARM_CLOCK, intent.getSerializableExtra(ALARM_CLOCK));
        Log.d("TAG", "receiver");
        context.startActivity(bootIntent);


    }

}
