package com.flyvpnpro.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.flyvpnpro.official.R;

public class CustomAdapter extends BaseAdapter 
{
    Context context;
    int flags[];
    String[] countryNames;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] flags, String[] countryNames) {
        this.context = applicationContext;
        this.flags = flags;
        this.countryNames = countryNames;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        TextView textView2 = (TextView) view.findViewById(R.id.method);
        icon.setImageResource(flags[i]);
        names.setText(countryNames[i]);
        if (countryNames[i].contains("Custom Payload")) {
            textView2.setText("HTTP Mode");
        } else if (countryNames[i].contains("Custom SNI")) {
            textView2.setText("SSL/TLS Mode");
        } else if (countryNames[i].contains("Imported Config")) {
            textView2.setText(".JADev File");
        }
        return view;
    }
}