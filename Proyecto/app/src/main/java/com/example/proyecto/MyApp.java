package com.example.proyecto;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        Realm.deleteRealm(Realm.getDefaultConfiguration());

    }
}
