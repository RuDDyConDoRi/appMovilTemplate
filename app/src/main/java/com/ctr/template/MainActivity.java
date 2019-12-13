package com.ctr.template;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import com.github.moduth.blockcanary.BlockCanaryContext;

//import dodola.blockindigo.BlockIndigo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //BlockIndigo.install(this, new BlockCanaryContext());
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        Intent menu = new Intent(context,MenuActivity.class);
        menu.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(menu);

    }
}
