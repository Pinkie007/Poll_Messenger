package com.example.hsuser4.poll_messenger.Activities.Activities.Application;

import android.app.Application;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;



public class MyApplication extends Application {
    public void onCreate()
    {
        super.onCreate();


        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(6)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
