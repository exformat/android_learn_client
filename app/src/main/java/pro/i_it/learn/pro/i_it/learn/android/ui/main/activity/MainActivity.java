package pro.i_it.learn.pro.i_it.learn.android.ui.main.activity;

import android.content.Context;
import android.database.Observable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.i_it.learn.R;
import pro.i_it.learn.pro.i_it.learn.android.ui.Drawer.NameModel;
import pro.i_it.learn.pro.i_it.learn.android.ui.main.activity.model.DrawerListModel;

/**
 * Created by syn on 08.03.17.
 */

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private IManiActivityPresenter presenter;
    @BindView(R.id.activity_main_frame)
    protected FrameLayout frameLayout;

//======================================================================
    Button   btn_input_name;
    EditText input_name;
    TextView name;
//======================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        presenter = new MainActivityPresenter();
        ButterKnife.bind(this);
        presenter.init(this);

//======================================================================
        btn_input_name = (Button)  findViewById(R.id.btn_input_name);
        input_name     = (EditText)findViewById(R.id.input_name);
        name           = (TextView)findViewById(R.id.text_view_name);

        NameModel nameModel = new NameModel();

        btn_input_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameModel.setInputName(input_name.getText().toString());
                name.setText(nameModel.getInputName());
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btn_input_name.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
//======================================================================

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
