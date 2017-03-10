package pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces;

import java.util.ArrayList;

import io.reactivex.Observable;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;
import retrofit2.http.GET;

/**
 * Created by syn on 09.03.17.
 */

public interface ILearnServer {
    @GET(ILearnServerConstants.Chat.HISTORY_PATH)
    Observable<ArrayList<MessageModel>> getHistoryMessage();
}
