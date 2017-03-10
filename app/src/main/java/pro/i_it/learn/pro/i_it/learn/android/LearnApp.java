package pro.i_it.learn.pro.i_it.learn.android;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import pro.i_it.learn.pro.i_it.learn.android.local.IModuleManager;
import pro.i_it.learn.pro.i_it.learn.android.local.ModuleManager;

/**
 * Created by syn on 09.03.17.
 */

public class LearnApp extends Application {
    private static IModuleManager moduleManager;

    @Override
    public void onCreate() {
        super.onCreate();
        moduleManager = new ModuleManager(this);
    }

    public static IModuleManager getModuleManager() {
        return moduleManager;
    }
}
