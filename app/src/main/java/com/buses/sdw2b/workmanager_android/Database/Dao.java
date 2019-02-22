package com.buses.sdw2b.workmanager_android.Database;


import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import io.reactivex.Completable;
import io.reactivex.Single;

@android.arch.persistence.room.Dao
public interface Dao  {


    @Insert
    void insertelelements(final Entitys...entities);



    @Query("SELECT * FROM user")
    Single<Entitys> selectelements();











}
