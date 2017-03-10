package pro.i_it.learn.pro.i_it.learn.android.local;

import android.content.Context;

import pro.i_it.learn.pro.i_it.learn.android.local.interfaces.ILocalManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.interfaces.IRemoteManager;

/**
 * Created by syn on 09.03.17.
 */

public interface IModuleManager {
    ILocalManager getLocalManager();

    IRemoteManager getRemoteManager();

    Context getAppContext();
}
