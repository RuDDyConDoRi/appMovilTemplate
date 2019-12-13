package com.ctr.template;

import android.app.Application;

//import com.github.moduth.blockcanary.BlockCanaryContext;

//import dodola.blockindigo.BlockIndigo;

public class WatcherApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //BlockIndigo.install(this, new BlockCanaryContext());
    }
}