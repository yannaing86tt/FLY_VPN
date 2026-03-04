package com.flyvpnpro.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.appcompat.app.AlertDialog;
import com.flyvpnpro.second.MainService;
import com.flyvpnpro.official.R;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TorrentDetection{
    private Context context;
    private String[] items;
    private TorrentDetection.TorrentListener listener;
    private Timer timer;
    private Handler handler;

    public interface TorrentListener {
        public void detected(ArrayList pkg);
    }

    public TorrentDetection(Context c, String[] i, TorrentListener listener) {
        context = c;
        items = i;
        this.listener = listener;
    }

    private boolean check(String uri)
    {
        PackageManager pm = context.getPackageManager();
        boolean app_installed = false;
        try
        {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            app_installed = false;
        }
        return app_installed;
    }

    void check() {
        ArrayList arrayList2 = new ArrayList();
        for (String pack : items)
        {
            if(check(pack)){
                arrayList2.add(pack);
            }
        }
        if (arrayList2.size() > 0)
        {

            listener.detected(arrayList2);
            stop();
        }
    }

    public void start() {
        handler = new Handler();
        timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run()
            {
                handler.post(new Runnable() {
                        public void run()
                        {
                            check();
                        }
                    });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 3000);
    }

    public void stop() {
        if(timer != null){
            timer.cancel();
            timer = null;
        }
        if(handler != null){
            handler = null;
        }
    }
}
