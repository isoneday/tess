package com.teamproject.plastikproject;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.teamproject.plastikproject.adapters.PurchaseListAdapter;
import com.teamproject.plastikproject.helpers.ContentHelper;
import com.teamproject.plastikproject.model.PurchaseListModelbar;
import com.teamproject.plastikproject.modeldataskedule.ResponseDataSkeduleuser;
import com.teamproject.plastikproject.modeldataskedule.Responsedaske;
import com.teamproject.plastikproject.plastik.helper.SessionManager;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.RestApi;
import com.teamproject.plastikproject.utils.AlarmUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rage on 5/15/15.
 */
public class WritePurchaseListService extends IntentService {
    public static final String LIST_EXTRA = "PurchaseList";
    PurchaseListModelbar purchaseList ;
    private SessionManager manager;
    private int hasil;
    List<Responsedaske> responsedaskes;

    private PurchaseListAdapter adapter;

    public WritePurchaseListService() {
        super("WritePurchaseListService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        manager = new SessionManager(getApplicationContext());
       purchaseList = (PurchaseListModelbar) intent.getExtras().getSerializable(LIST_EXTRA);

        if (purchaseList != null) {
            if (purchaseList.getIdUser() < 0) {
                ContentHelper.updatePurchaseList(getApplicationContext(), purchaseList);
            } else {
                method();
                //if(sekarang == set) {
                startTimer();
               // }
             //   }
            }
        }

    }

    private void method() {

        Uri uri = ContentHelper.insertPurchaseList(getApplicationContext(), purchaseList);
//                purchaseList.getIdUser(uri.getLastPathSegment());
        purchaseList.getIdUser();
    //    getdatabaru();
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
//        System.out.println("Milliseconds to Date using Calendar:"
//                + df.format(cal.getTime()));

        Timestamp sq = new Timestamp(cal.getTime().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        Log.d("currentdatetimestampe",sdf.format(sq)); //this will print wit
        // desc =listNameEdit.getText().toString();
        String  waktusekarang = sdf.format(sq);
        String waktuset =manager.getTime();
        Date currentDate1 = new Date(purchaseList.getTime());
        DateFormat df1 = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");

        //formatted value of current Date
        System.out.println("Milliseconds to Date: " + df1.format(currentDate1));

        //Converting milliseconds to Date using Calendar
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(purchaseList.getTime());
        Timestamp sq1 = new Timestamp(cal1.getTime().getTime());
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        String waktuser =sdf1.format(sq1);



        Log.d("apaaja","dsdsds");
        String day = manager.getDay();
//  int hasil;
        if (day.equals("sunday")) {
            hasil = 1;
        } else if (day.equals("monday")) {
            hasil = 2;
        } else if (day.equals("tuesday")) {
            hasil = 3;
        } else if (day.equals("wednesday")) {
            hasil = 4;
        } else if (day.equals("thursday")) {
            hasil = 5;
        } else if (day.equals("friday")) {
            hasil = 6;
        } else if (day.equals("saturday")) {
            hasil = 7;
        } else {
            hasil = 0;
        }
        Calendar calendar = Calendar.getInstance();
        int days = calendar.get(Calendar.DAY_OF_WEEK);
        Log.d("jalanwaktu",waktuser);
        if(hasil==days && waktuser.equals(waktusekarang)){
//            getApplicationContext().startService(new Intent(getApplicationContext(), AlarmUtils.class)
//                    .putExtra(AlarmUtils.LIST_EXTRA1, purchaseList)
//            );
            AlarmUtils alarmUtils = new AlarmUtils(getApplicationContext());
            alarmUtils.setListAlarm(purchaseList);

            Log.d("jalan","dsdsds");

        }else{
            Log.d("jalangagal","dsdsds");

        }
//
//                long sekarang = Long.parseLong(waktusekarang);
//                long set =Long.parseLong(waktuset);
//         //       if (set > System.currentTimeMillis()
//           //             && purchaseList.getIdUser() > 0) {
//

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
        timer.schedule(timerTask,1000, 1000); //
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {

                method();
             //   Log.i("in timer", "in timer ++++  "+ (counter++));
            }
        };
    }

//    @Override
//    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
//        return START_STICKY;
//    }



}
