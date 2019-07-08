package com.ctr.template;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        Intent menu = new Intent(context,MenuActivity.class);
        menu.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(menu);

    }
}
