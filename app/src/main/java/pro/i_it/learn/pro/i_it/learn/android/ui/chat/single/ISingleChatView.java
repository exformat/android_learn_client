package pro.i_it.learn.pro.i_it.learn.android.ui.chat.single;

import android.content.Context;

import java.util.ArrayList;

import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;

/**
 * Created by syn on 08.03.17.
 */

public interface ISingleChatView {
    void updateChats(ArrayList<MessageModel> messageModels);

    String getInputMessage();

    void clearInputMessage();

    void showErrorFromInputMessage(String errorMessage);


    Context getContext();
}
