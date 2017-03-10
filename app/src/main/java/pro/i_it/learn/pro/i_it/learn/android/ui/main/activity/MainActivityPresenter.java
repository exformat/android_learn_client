package pro.i_it.learn.pro.i_it.learn.android.ui.main.activity;

import pro.i_it.learn.pro.i_it.learn.android.ui.chat.single.SingleChatFragment;

/**
 * Created by syn on 08.03.17.
 */

public class MainActivityPresenter implements IManiActivityPresenter {
    private IMainActivity view;


    private void initFragments() {

    }

    @Override
    public void init(IMainActivity view) {
        this.view = view;
        view.setFragment(new SingleChatFragment());
    }
}
