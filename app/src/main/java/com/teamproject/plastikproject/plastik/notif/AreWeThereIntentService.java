package com.teamproject.plastikproject.plastik.notif;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.gson.Gson;
import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.alarmapp.models.ModelAddTropy;
import com.teamproject.plastikproject.modeldataskedule.ResponseDataSkeduleuser;
import com.teamproject.plastikproject.modeldataskedule.Responsedaske;
import com.teamproject.plastikproject.plastik.helper.SessionManager;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient2;
import com.teamproject.plastikproject.plastik.network.RestApi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AreWeThereIntentService extends IntentService {

  // region Properties

  private final String TAG = AreWeThereIntentService.class.getName();

  private SharedPreferences prefs;
  private Gson gson;
  private GeofencingEvent event;
  private int hasil;
  private SessionManager manager;
  private String id;

  // endregion

  // region Constructors

  public AreWeThereIntentService() {
    super("AreWeThereIntentService");
  }

  // endregion

  // region Overrides

  @Override
  protected void onHandleIntent(Intent intent) {

    Log.d("servicelagi","lagijalan");
   // startTimer();

    event = GeofencingEvent.fromIntent(intent);
    if (event != null) {
      if (event.hasError()) {
        onError(event.getErrorCode());
      } else {
        manager = new SessionManager(getApplicationContext());
        id = manager.getIdUser();

        method(event);

      }
    }
  }

  private void method(GeofencingEvent event) {
    prefs = getApplicationContext().getSharedPreferences(Constants.SharedPrefs.Geofences, Context.MODE_PRIVATE);
    gson = new Gson();
    Log.d("servicelagi","terusjalan");
    int transition = event.getGeofenceTransition();
    if (transition == Geofence.GEOFENCE_TRANSITION_ENTER || transition == Geofence.GEOFENCE_TRANSITION_DWELL || transition == Geofence.GEOFENCE_TRANSITION_EXIT) {
      final List<String> geofenceIds = new ArrayList<>();
      for (Geofence geofence : event.getTriggeringGeofences()) {
        geofenceIds.add(geofence.getRequestId());
        Log.d("cekdata",geofence.getRequestId());
        Log.d("cekdata","service jalan");

      }
      if (transition == Geofence.GEOFENCE_TRANSITION_ENTER || transition == Geofence.GEOFENCE_TRANSITION_DWELL) {
        Log.d("servicelagi","berhasil");
        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        Call<ResponseDataSkeduleuser> skeduleuserCall =api.getdataskeduleuser(id);
        skeduleuserCall.enqueue(new Callback<ResponseDataSkeduleuser>() {
          @Override
          public void onResponse(Call<ResponseDataSkeduleuser> call, Response<ResponseDataSkeduleuser> response) {
            List<Responsedaske> responsedaskes = response.body().getResponse();
            String[] hari = new String[responsedaskes.size()];
            for (int i = 0; i < responsedaskes.size(); i++) {
              hari[i] = responsedaskes.get(i).getDay().toString();
              String haridata = hari[i];
              if (haridata.equals("sunday")) {
                hasil = 1;
              } else if (haridata.equals("monday")) {
                hasil = 2;
              } else if (haridata.equals("tuesday")) {
                hasil = 3;
              } else if (haridata.equals("wednesday")) {
                hasil = 4;
              } else if (haridata.equals("thursday")) {
                hasil = 5;
              } else if (haridata.equals("friday")) {
                hasil = 6;
              } else if (haridata.equals("saturday")) {
                hasil = 7;
              } else {
                hasil = 0;
              }
              Calendar calendar = Calendar.getInstance();
              int days = calendar.get(Calendar.DAY_OF_WEEK);
              if (days==hasil) {
                onEnteredGeofences(geofenceIds);
                addtropy();
              }else{
//            Toast.makeText(this, "beda hari", Toast.LENGTH_SHORT).show();

              }
            }



          }

          @Override
          public void onFailure(Call<ResponseDataSkeduleuser> call, Throwable t) {

          }
        });


      }

    }
  }

  private void addtropy() {
    RestApi api = MyRetrofitClient2.getInstaceRetrofit();

    Call<ModelAddTropy> addTropyCall =api.addtropy(id);
    addTropyCall.enqueue(new Callback<ModelAddTropy>() {
      @Override
      public void onResponse(Call<ModelAddTropy> call, Response<ModelAddTropy> response) {
        if (response.isSuccessful()){
          Log.d("informasinya","berhasil");
          //  getdatalagibaru.getdatalagiya();

        }else{
          Log.d("informasinya","gagal");

        }
      }

      @Override
      public void onFailure(Call<ModelAddTropy> call, Throwable t) {
        Log.d("informasinya","masalah koneksi");

      }
    });

  }

  // endregion

  // region Private

  private void onEnteredGeofences(List<String> geofenceIds) {
    for (String geofenceId : geofenceIds) {
      String geofenceName = "";

      // Loop over all geofence keys in prefs and retrieve NamedGeofence from SharedPreference
      Map<String, ?> keys = prefs.getAll();
      for (Map.Entry<String, ?> entry : keys.entrySet()) {
        String jsonString = prefs.getString(entry.getKey(), null);
        NamedGeofence namedGeofence = gson.fromJson(jsonString, NamedGeofence.class);
        if (namedGeofence.id.equals(geofenceId)) {
          geofenceName = namedGeofence.name;
          break;
        }
      }

      // Set the notification text and send the notification
      String contextText = String.format(this.getResources().getString(R.string.Notification_Text), geofenceName);

      NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
      Intent intent = new Intent(this, AllGeofencesActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
      PendingIntent pendingNotificationIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

      Notification notification = new NotificationCompat.Builder(this)
              .setSmallIcon(R.mipmap.ic_launcher)
              .setContentTitle(this.getResources().getString(R.string.Notification_Title))
              .setContentText(contextText)
              .setContentIntent(pendingNotificationIntent)
              .setStyle(new NotificationCompat.BigTextStyle().bigText(contextText))
              .setPriority(NotificationCompat.PRIORITY_HIGH)
              .setAutoCancel(true)
              .build();
      notificationManager.notify(0, notification);

    }
  }

  private void onError(int i) {
    Log.e("errorgeo", "Geofencing Error: " + i);
  }
  private Timer timer;
  private TimerTask timerTask;
  long oldTime=0;
  public void startTimer() {
    //set a new Timer
    timer = new Timer();

    //initialize the TimerTask's job
    initializeTimerTask();

    //schedule the timer, to wake up every 1 second
    timer.schedule(timerTask, 1000, 300000); //
  }

  /**
   * it sets the timer to print the counter every x seconds
   */
  public void initializeTimerTask() {
    timerTask = new TimerTask() {
      public void run() {
     //   Log.i("in timer", "in timer ++++  "+ (counter++));
      method(event);
      }
    };
  }
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    super.onStartCommand(intent, flags, startId);
    startTimer();
    return START_STICKY;
  }

// endregion
}

