
 package com.ngxu.videoplayer;
 import android.os.Build;

 import android.app.Activity;
 import java.lang.ref.WeakReference;
 import android.view.View;

import android.view.WindowManager;
import android.view.Window;

public class SetAppBrightness {

    private static WeakReference<Activity> mActivity;
    public static void goSetAppBrightness(Activity activity, final float brightnessPercent)
    {

        mActivity=new WeakReference<Activity>(activity);

        if (activity == null) {
            if (mActivity == null) {
                return;
            }
            activity = mActivity.get();
        }

        if (activity == null) return;

        final Activity _activity = activity;

        _activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Window window =  _activity.getWindow();
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                if (brightnessPercent < 0) {
                    layoutParams.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
                } else {
                    layoutParams.screenBrightness = brightnessPercent;
                }
                window.setAttributes(layoutParams);
            }
        });
    }

}



