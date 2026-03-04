package com.flyvpnpro.main.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flyvpnpro.official.R;
import com.flyvpnpro.second.config.Settings;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class SpinnerAdapter extends ArrayAdapter<JSONObject> {

    private int spinner_id;

    public SpinnerAdapter(Context context, int spinner_id, ArrayList<JSONObject> list) {
        super(context, R.layout.spinner_item, list);
        this.spinner_id = spinner_id;
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        
    }

    @Override
    public JSONObject getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return view(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return view(position, convertView, parent);
    }

    private View view(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);
        ImageView im = v.findViewById(R.id.itemImage);
        TextView tv = v.findViewById(R.id.itemName);
        TextView extra = v.findViewById(R.id.textExtra);
        TextView info = v.findViewById(R.id.info);
        LinearLayout ok  = (LinearLayout) v.findViewById(R.id.ok);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.luh);      
        
           try {
            String name = getItem(position).getString("FLYName");
            tv. setText(name);
               
            if (spinner_id == R.id.serverSpinner) {
                getServerIcon(position, im, info);
                info.setText(getItem(position).getString("FLYInfo")); 
                                         
            } else if (spinner_id == R.id.payloadSpinner) {
                getPayloadIcon(position, im, extra, info);
                
                info.setText(getItem(position).getString("pInfo"));
                extra.setText("direct");
//                  
				   boolean sslType = getItem(position).getBoolean("isSSL");
				   boolean payload = getItem(position).getBoolean("isPayloadSSL");
				   if (sslType) {
					   extra.setText("SSL/TLS");
				   } else if(payload) {
					   extra.setText("SSL/Proxy");
				   } else {
					   extra.setText("SSH/Proxy");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    private void getPayloadIcon(int position, ImageView im, TextView extra, TextView info) throws JSONException {
       
        String name = getItem(position).getString("FLYName").toLowerCase();
        String string = getItem(position).getString("pInfo");
        info.setText(string);
        
        if (name.contains("globe")) {
            im.setImageResource(R.drawable.sg);
       
        }
    }

    private void getServerIcon(int position, ImageView im, TextView info ) throws Exception {
        InputStream inputStream = getContext().getAssets().open("flags/" + getItem(position).getString("FLYFLAG"));
        im.setImageDrawable(Drawable.createFromStream(inputStream, getItem(position).getString("FLYFLAG")));
        if (inputStream != null) {
            inputStream.close();
            
        } 
        
    }

}
