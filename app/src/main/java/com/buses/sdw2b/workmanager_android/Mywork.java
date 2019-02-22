package com.buses.sdw2b.workmanager_android;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class Mywork extends Worker {
    public Mywork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        return Result.success();
    }


    private void dowork() {


        NotificationManager notificationManager=(NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        Vibrator v = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(5000);
        }


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {


            NotificationChannel notificationChannel=new NotificationChannel("1","suneel",NotificationManager.IMPORTANCE_HIGH);


            notificationManager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),"1");



        builder.setContentTitle("syguv");


        builder.setSmallIcon(R.drawable.ic_launcher_background);


        notificationManager.notify(1,builder.build());





    }
}
