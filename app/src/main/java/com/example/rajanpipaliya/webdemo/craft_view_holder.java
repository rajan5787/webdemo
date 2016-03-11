package com.example.rajanpipaliya.webdemo;

import android.widget.TextView;

/**
 * Created by rajan pipaliya on 7/8/2015.
 */
public class craft_view_holder {

    TextView name;

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public craft_view_holder(TextView name) {

        this.name = name;
    }
}
