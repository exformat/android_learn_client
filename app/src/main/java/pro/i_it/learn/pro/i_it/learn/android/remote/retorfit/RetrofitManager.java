package pro.i_it.learn.pro.i_it.learn.android.remote.retorfit;

import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces.ILearnServer;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces.IRetrofitManager;

import static pro.i_it.learn.BuildConfig.DEBUG;
import static pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces.ILearnServerConstants.MAIN_URL_DEV;
import static pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces.ILearnServerConstants.MAIN_URL_RELEASE;

/**
 * Created by syn on 09.03.17.
 */

public class RetrofitManager implements IRetrofitManager {
    private ILearnServer learnServer;

    public RetrofitManager() {
        learnServer = RetrofitProvider
                .getDefaultRetrofit(DEBUG ? MAIN_URL_DEV : MAIN_URL_RELEASE)
                .create(ILearnServer.class);
    }

    @Override
    public ILearnServer getLearnServer() {
        return learnServer;
    }
}
