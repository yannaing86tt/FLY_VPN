package com.flyvpnpro.main.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.graphics.SweepGradient;
import cn.pedant.SweetAlert.widget.SweetAlertDialog;
import android.app.AlertDialog;
import android.graphics.Color;

/** Created by: KervzCodes Date Crated: 08/10/2020 Project: SocksHttp-master (ENGLISH) */

public class ConfigUpdate extends AsyncTask<String, String, String> {

  private Context context;
  private OnUpdateListener listener;
  private ProgressDialog progressDialog;
  private boolean isOnCreate;
  private SweetAlertDialog sweet;
  public URL url;

  private String FuckYourMother =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[62];
              HSDevTeam = 436207716;
              buf[0] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -36438061;
              buf[1] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -583008310;
              buf[2] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -36613;
              buf[3] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -562;
              buf[4] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 237631;
              buf[5] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -54525969;
              buf[6] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 1540104;
              buf[7] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -318767142;
              buf[8] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 430133;
              buf[9] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -560;
              buf[10] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -39583748;
              buf[11] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 245366843;
              buf[12] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -164626448;
              buf[13] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -13425;
              buf[14] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 103809143;
              buf[15] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -1154;
              buf[16] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 223239;
              buf[17] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 1533;
              buf[18] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 6409;
              buf[19] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 25970;
              buf[20] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 241664;
              buf[21] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 219151;
              buf[22] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -80950;
              buf[23] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 1828716444;
              buf[24] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -314572881;
              buf[25] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -12845;
              buf[26] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -27262995;
              buf[27] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 52279;
              buf[28] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -18910;
              buf[29] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 247864;
              buf[30] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -280583;
              buf[31] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -585844;
              buf[32] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 461373497;
              buf[33] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -4589;
              buf[34] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 956301422;
              buf[35] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -75497546;
              buf[36] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -1653;
              buf[37] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = -872415355;
              buf[38] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 6315;
              buf[39] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 55336;
              buf[40] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 29098032;
              buf[41] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -2519;
              buf[42] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -852009;
              buf[43] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -1196047;
              buf[44] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 6226;
              buf[45] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -314572811;
              buf[46] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 1802279;
              buf[47] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 770145;
              buf[48] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -2293770;
              buf[49] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -620;
              buf[50] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -4518;
              buf[51] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -1149239335;
              buf[52] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -80740376;
              buf[53] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -1182793808;
              buf[54] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -321;
              buf[55] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 122683495;
              buf[56] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 3670017;
              buf[57] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -312;
              buf[58] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 813695064;
              buf[59] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 60817521;
              buf[60] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 6515;
              buf[61] = (byte) (HSDevTeam >>> 6);
              return new String(buf);
            }
          }.toString());

  public ConfigUpdate(Context context, OnUpdateListener listener) {
    this.context = context;
    this.listener = listener;
  }

  public void start(boolean isOnCreate) {
    this.isOnCreate = isOnCreate;
    execute();
  }

  public interface OnUpdateListener {
    void onUpdateListener(String result);
  }

  @Override
  protected String doInBackground(String... strings) {
    try {
      StringBuilder sb = new StringBuilder();
      // PLUS channel only (separate update stream from old APKs)
      url = new URL("https://raw.githubusercontent.com/plusprovpn/PLUS_PRO/refs/heads/main/server.json");

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String response;

      while ((response = br.readLine()) != null) {
        sb.append(response);
      }
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return "Error on getting data: " + e.getMessage();
    }
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    if (!isOnCreate) {
      sweet = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
      sweet.getProgressHelper().setBarColor(Color.parseColor("#452CAC"));
      sweet.setTitleText("Checking Update...");
      sweet.setContentText("Please wait white loading");
      sweet.show();
      sweet.setCancelable(true);
    }
  }

  /*   progressDialog = new ProgressDialog(context);
  progressDialog.setMessage("Please wait while loading");
  progressDialog.setTitle("Checking Update");
  progressDialog.show(); */

  @Override
  protected void onPostExecute(String s) {
    super.onPostExecute(s);
    if (!isOnCreate && sweet != null) {
      sweet.dismiss();
    }
    if (listener != null) {
      listener.onUpdateListener(s);
    }
  }
}
