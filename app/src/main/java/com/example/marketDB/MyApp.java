package com.example.marketDB;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyApp extends Application {

    private static Context context;
    private static int counter = 0;

    public static Context getContext() {
        return context;
    }

    public static boolean isApplResumed() {
        return counter > 0;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                counter++;
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                counter--;
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
            }
        });
    }
}
