package com.example.knuplate;

import android.widget.ProgressBar;

public class MenuData {
    private String menu_item_name;
    private int menu_item_pg;

    public MenuData(String menu_item_name, int menu_item_pg) {
        this.menu_item_name = menu_item_name;
        this.menu_item_pg = menu_item_pg;
    }

    public String getMenu_item_name() {
        return menu_item_name;
    }

    public void setMenu_item_name(String menu_item_name) {
        this.menu_item_name = menu_item_name;
    }

    public int getMenu_item_pg() {
        return menu_item_pg;
    }

    public void setMenu_item_pg(int menu_item_pg) {
        this.menu_item_pg = menu_item_pg;
    }
}