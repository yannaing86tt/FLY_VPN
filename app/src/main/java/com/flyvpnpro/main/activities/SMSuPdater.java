package com.flyvpnpro.main.activities;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import cn.pedant.SweetAlert.widget.SweetAlertDialog;
import com.flyvpnpro.main.MainActivity;
import com.flyvpnpro.main.util.Utils;
import com.flyvpnpro.official.R;
import org.json.JSONObject;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.view.Gravity;

public class SMSuPdater
{
	private SharedPreferences pref;
	private SweetAlertDialog sweetDialog;



	public SMSuPdater(final MainActivity h){
		pref = PreferenceManager.getDefaultSharedPreferences(h);
		new SMS_Updater(h, new SMS_Updater.Listener() {
				@Override
				public void onCompleted(final String SMS)
				{

					try
					{
						JSONObject sms_js = new JSONObject(SMS);
						if (sms_js.getInt("SendMessage") == pref.getInt(Utils.CurrentSMSVersion, 0))
						{
						}
						else
						{
							pref.edit().putBoolean("firstStartSMS", true).commit();
							if (new Boolean(pref.getBoolean("firstStartSMS", true)).booleanValue())
							{
								StringBuffer sb = new StringBuffer();
								sb.append(sms_js.getString("MyMessage"));

								NotificationManager notificationManager = (NotificationManager) h.getSystemService(Context.NOTIFICATION_SERVICE); 
								Notification.Builder notification = new Notification.Builder(h);
								if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
									notification.setChannelId(h.getPackageName() + ".smsupdater");
									createNotificationChannel(notificationManager, h.getPackageName() + ".smsupdater");
								}
						         	notification.setStyle(new Notification.BigTextStyle(notification)
						           .bigText(sb.toString())
						           .setBigContentTitle("New Message From Admin")
						           .setSummaryText("Announcements"))
							       .setContentTitle("New Message From Admin")
								   .setContentText(sb.toString())
								   .setDefaults(Notification.DEFAULT_ALL)
								   .setPriority(Notification.PRIORITY_HIGH)
								   .setSmallIcon(R.drawable.admin_sms);
								    notificationManager.notify(4129,notification.getNotification());


								LayoutInflater inflater = (LayoutInflater) h.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View inflate = inflater.inflate(R.layout.help, (ViewGroup) null);
                                AlertDialog.Builder builer = new AlertDialog.Builder(h);
                                builer.setView(inflate);
                                ImageView iv = inflate.findViewById(R.id.icon);
                                TextView title = inflate.findViewById(R.id.title);
                                TextView ms = inflate.findViewById(R.id.message);
                                TextView ok = inflate.findViewById(R.id.confirm);
                                iv.setImageResource(R.drawable.admin_sms);
                                title.setText("NEW MESSAGE FROM ADMIN");
                                ms.setText(sb.toString());
                                ok.setText("OK");
                                final AlertDialog alert = builer.create(); 
                                alert.setCanceledOnTouchOutside(true);
                                alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                alert.getWindow().setGravity(Gravity.CENTER); 
                                alert.show();
                                ok.setOnClickListener(new View.OnClickListener() { 
                                        @Override 
                                        public void onClick(View v) {    

                                            try
                                            {
                                                JSONObject sms_obj = new JSONObject(SMS);
                                                pref.edit().putInt(Utils.CurrentSMSVersion, sms_obj.getInt("SendMessage")).commit();
                                                pref.edit().putBoolean("firstStartSMS", false).commit();
                                            }
                                            catch (Exception e){
                                            }
                                            alert.dismiss();
                                        }
                                    });
								alert.show();
							}
						}
					}
					catch (Exception e)
					{
					}
				}



				@Override
				public void onCancelled()
				{

				}

				@Override
				public void onException(String ex)
				{

				}
			}).execute();
	}

	private void createNotificationChannel(NotificationManager notificationManager, String id)
	{
		NotificationChannel mChannel = new NotificationChannel(id, "SMSuUpdater Notification", NotificationManager.IMPORTANCE_HIGH);
		mChannel.setShowBadge(true);
		notificationManager.createNotificationChannel(mChannel);
		// TODO: Implement this method
	}
}

