package com.ctr.template.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;

import com.ctr.template.R;

public class BlockUI {

    Context context;
    Builder builder;
    AlertDialog alertdialog;

    public BlockUI(Context context) {
        this.context = context;
        builder = new Builder(this.context);

        builder.setMessage("Load...");
        builder.setIcon(R.drawable.osm_ic_follow_me_on);
        builder.setCancelable(false);

    }

    public void esperar(){
        this.alertdialog = builder.create();
        alertdialog.show();

    }

    public void finalizar(){
        this.alertdialog.cancel();
    }

}
