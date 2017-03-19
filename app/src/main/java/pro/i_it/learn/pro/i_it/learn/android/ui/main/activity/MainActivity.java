package pro.i_it.learn.pro.i_it.learn.android.ui.main.activity;

import android.database.Observable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.i_it.learn.R;
import pro.i_it.learn.pro.i_it.learn.android.ui.main.activity.model.DrawerListModel;

/**
 * Created by syn on 08.03.17.
 */

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private IManiActivityPresenter presenter;
    @BindView(R.id.activity_main_frame)
    protected FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        presenter = new MainActivityPresenter();
        ButterKnife.bind(this);
        presenter.init(this);
    }

    @Override
    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame,fragment).commit();
    }

    @Override
    public Observable<View> getDrawerClickObservable() {
        return null;
    }

    @Override
    public void setDrawerListMenu(ArrayList<DrawerListModel> models) {

    }
}
