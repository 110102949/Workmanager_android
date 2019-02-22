package com.buses.sdw2b.workmanager_android.Database;


import android.arch.persistence.room.RoomDatabase;




@android.arch.persistence.room.Database(entities = Entitys.class,version = 1)
public abstract class Database extends RoomDatabase {



    public abstract Dao do_operations();








}
