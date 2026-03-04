package com.flyvpnpro.main.util;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.flyvpnpro.main.MainApp;

public class AndroidUtilities {
    public static float density;
    public static Point displaySize = new Point();

    static {
        density = (float) 1;
        density = MainApp.getApp().getResources().getDisplayMetrics().density;
        checkDisplaySize();
    }

    public static int dp(float f) {
        return (int) Math.ceil((double) (density * f));
    }

    public static float dpf2(float f) {
        return density * f;
    }

    public static void checkDisplaySize() {
        try {
            WindowManager windowManager = (WindowManager) MainApp.getApp().getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                if (defaultDisplay != null) {
                    if (VERSION.SDK_INT < 13) {
                        displaySize.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                    } else {
                        defaultDisplay.getSize(displaySize);
                    }
                    Log.e("tmessages", new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("display size = ").append(displaySize.x).toString()).append(" ").toString()).append(displaySize.y).toString());
                }
            }
        } catch (Exception e) {
            Log.e("tmessages", e.toString());
        }
    }
}
