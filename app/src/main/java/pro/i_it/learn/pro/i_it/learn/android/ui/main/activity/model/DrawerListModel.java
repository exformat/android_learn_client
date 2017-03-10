package pro.i_it.learn.pro.i_it.learn.android.ui.main.activity.model;

import java.sql.Driver;

/**
 * Created by syn on 08.03.17.
 */

public class DrawerListModel {
    private String title;
    private Driver image;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Driver getImage() {
        return image;
    }

    public void setImage(Driver image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
