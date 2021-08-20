package edu.adichandra.mapnesiaapp;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import edu.adichandra.mapnesiaapp.Activity.SplashActivity;

public class NotificationReceiver extends BroadcastReceiver {
    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_TYPE = "type";

    // Siapkan 2 id untuk 2 macam alarm, onetime dan repeating
    private final static int ID_REPEATING = 101;

    @Override
    public void onReceive(Context context, Intent intent) {
        String type = intent.getStringExtra(EXTRA_TYPE);
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        showAlarmNotification(context, 101);
    }

    // Metode ini digunakan untuk menjalankan alarm repeating
    public void setRepeatingAlarm(Context context) {

        Intent intent = new Intent(context, NotificationReceiver.class);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 16);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ID_REPEATING, intent, 0);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
        }
    }


    public void showAlarmNotification(Context context, int notifId) {
        String CHANNEL_ID = "Channel_1";
        String CHANNEL_NAME = "AlarmManager channel";

        //triggered when user clicks on notification(StopScript.class in this case)
        Intent resultIntent = new Intent(context.getApplicationContext(),SplashActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context.getApplicationContext(), 0,
                resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setContentTitle("Hallo Semuanya");
        builder.setContentText("Yuk mengenal para pahlawan indonesia !!!");
        builder.setSmallIcon(R.drawable.mapnesia);
        builder.setAutoCancel(true);
        builder.setContentIntent(contentIntent);

        /*
        Untuk android Oreo ke atas perlu menambahkan notification channel
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            /* Create or update. */
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.enableVibration(true);
            builder.setChannelId(CHANNEL_ID);

            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(channel);
            }
        }

        Notification notification = builder.build();

        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(notifId, notification);
        }
    }


}