package pro.i_it.learn.pro.i_it.learn.android.ui.main.activity;

import android.database.Observable;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.ArrayList;

import pro.i_it.learn.pro.i_it.learn.android.ui.main.activity.model.DrawerListModel;

/**
 * Created by syn on 08.03.17.
 */

public interface IMainActivity {
    void setFragment(Fragment fragment);

    Observable<View> getDrawerClickObservable();

    void setDrawerListMenu(ArrayList<DrawerListModel> models);
}
