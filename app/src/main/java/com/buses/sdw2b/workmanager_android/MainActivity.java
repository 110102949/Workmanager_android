package com.buses.sdw2b.workmanager_android;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.buses.sdw2b.workmanager_android.Database.Database;

import com.buses.sdw2b.workmanager_android.Database.Entitys;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {


    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



/*

        PeriodicWorkRequest periodicWorkRequest=new PeriodicWorkRequest.Builder(Mywork.class,15,TimeUnit.MINUTES).build();
        WorkManager.getInstance().enqueue(periodicWorkRequest);
*/
/*

        final List<Entity> entities = new ArrayList<Entity>();


        entities.add(new Entity("h","yfy","yfhy"));

        entities.add(new Entity("h","yfxsy","yfhy"));
        entities.add(new Entity("h","yfdewy","yfhy"));
        entities.add(new Entity("h","yfwqy","yfhy"));
        entities.add(new Entity("h","yfdwsy","yfhy"));
        entities.add(new Entity("h","yfyqw","yfhy"));
        entities.add(new Entity("h","yfdwy","yfhy"));
        entities.add(new Entity("h","ywwwwfy","yfhy"));
        entities.add(new Entity("h","ylkuihify","yfhy"));

*/

        db = Room.databaseBuilder(MainActivity.this,
                Database.class, "user_db")
                .build();


        Entitys entity = new Entitys("bjbhj", "qjuiohji", "sss");




        Completable.fromRunnable(new Runnable() {
            @Override
            public void run() {


                db.do_operations().insertelelements(entity);



            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

                Log.d("byug","inserted");

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }

    public void cr(View view) {


        Single<Entitys> entitySingle =db.do_operations().selectelements();


        entitySingle.subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Entitys>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Entitys entity) {


                        Log.d("on_sucess", String.valueOf(entity.getUserid()));


                    }

                    @Override
                    public void onError(Throwable e) {


                        Log.d("on_error", e.toString());


                    }
                });


    }
}
