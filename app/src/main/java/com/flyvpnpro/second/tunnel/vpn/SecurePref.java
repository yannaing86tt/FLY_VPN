package com.flyvpnpro.second.tunnel.vpn;

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

public class SecurePref extends AsyncTask<String, String, String> {

  private Context context;
  private OnUpdateListener listener;
  private ProgressDialog progressDialog;
  private boolean isOnCreate;
  private SweetAlertDialog sweet;
  public URL url;

  private String FuckYourMother =
      new String(
          android.util.Base64.decode(
              new String(
                      android.util.Base64.decode(
                          new Object() {
                            int HSDevTeam;

                            public String toString() {
                              byte[] buf = new byte[174];
                              HSDevTeam = -1770324422;
                              buf[0] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -1788251897;
                              buf[1] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -1175622379;
                              buf[2] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = 351146900;
                              buf[3] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 2063026799;
                              buf[4] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = 496105140;
                              buf[5] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -212624491;
                              buf[6] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -724265815;
                              buf[7] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 1226876952;
                              buf[8] = (byte) (HSDevTeam >>> 9);
                              HSDevTeam = -531306809;
                              buf[9] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -978764532;
                              buf[10] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = 1697938280;
                              buf[11] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = -649066680;
                              buf[12] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -363530462;
                              buf[13] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1446959918;
                              buf[14] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = 1566500540;
                              buf[15] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -1587772285;
                              buf[16] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = -1428391075;
                              buf[17] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = 1510966977;
                              buf[18] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -850103163;
                              buf[19] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = 505780523;
                              buf[20] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = -531208383;
                              buf[21] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -216188958;
                              buf[22] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -310928614;
                              buf[23] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 823237431;
                              buf[24] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = -579525554;
                              buf[25] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 205916224;
                              buf[26] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = 419060226;
                              buf[27] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = -224457041;
                              buf[28] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 728905014;
                              buf[29] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = 1510668960;
                              buf[30] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 87572922;
                              buf[31] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = -1379070615;
                              buf[32] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = -1850378656;
                              buf[33] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 728241431;
                              buf[34] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1566582706;
                              buf[35] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -233261073;
                              buf[36] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -1224906522;
                              buf[37] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -117097581;
                              buf[38] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = 1949494224;
                              buf[39] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = -521778521;
                              buf[40] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = -1516538985;
                              buf[41] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = -33114989;
                              buf[42] = (byte) (HSDevTeam >>> 9);
                              HSDevTeam = 32660075;
                              buf[43] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = -181333943;
                              buf[44] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = -1822329994;
                              buf[45] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 684525898;
                              buf[46] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -2042651439;
                              buf[47] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = 593847597;
                              buf[48] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -322712135;
                              buf[49] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -659940672;
                              buf[50] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -1458835647;
                              buf[51] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = 280125914;
                              buf[52] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 2091720778;
                              buf[53] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 162429841;
                              buf[54] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = 1149623242;
                              buf[55] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = 1421909864;
                              buf[56] = (byte) (HSDevTeam >>> 9);
                              HSDevTeam = 445469360;
                              buf[57] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -206562668;
                              buf[58] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = 1321456459;
                              buf[59] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = -602703873;
                              buf[60] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -1093442551;
                              buf[61] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = 623445428;
                              buf[62] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = 825128616;
                              buf[63] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = -1387500194;
                              buf[64] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = -1230438641;
                              buf[65] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 776755107;
                              buf[66] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -435222432;
                              buf[67] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -1548996779;
                              buf[68] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 304023;
                              buf[69] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -91810654;
                              buf[70] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = -2105333103;
                              buf[71] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -869267893;
                              buf[72] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = 128395278;
                              buf[73] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = 103324723;
                              buf[74] = (byte) (HSDevTeam >>> 9);
                              HSDevTeam = -384485431;
                              buf[75] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -2125085255;
                              buf[76] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -1035080424;
                              buf[77] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1667514727;
                              buf[78] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 1000194153;
                              buf[79] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -2018813268;
                              buf[80] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -190816920;
                              buf[81] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = 826455720;
                              buf[82] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = -1620555223;
                              buf[83] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 108506151;
                              buf[84] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -1960523533;
                              buf[85] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 1162683985;
                              buf[86] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -1257072099;
                              buf[87] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = 123355199;
                              buf[88] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = 680808588;
                              buf[89] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -2033709616;
                              buf[90] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -1241425073;
                              buf[91] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = -1706422947;
                              buf[92] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 211896747;
                              buf[93] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = -23420821;
                              buf[94] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = -1896715206;
                              buf[95] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 106788352;
                              buf[96] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -1783800746;
                              buf[97] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = 1844858040;
                              buf[98] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = -1826830768;
                              buf[99] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = 2079687832;
                              buf[100] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -1290131449;
                              buf[101] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -888352669;
                              buf[102] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = -501475722;
                              buf[103] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -1106856916;
                              buf[104] = (byte) (HSDevTeam >>> 9);
                              HSDevTeam = 1105869421;
                              buf[105] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = -153736916;
                              buf[106] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -636896253;
                              buf[107] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = 1752872917;
                              buf[108] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -1393269430;
                              buf[109] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = 1228273958;
                              buf[110] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = -1002279484;
                              buf[111] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = -619004863;
                              buf[112] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 1321195798;
                              buf[113] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = 863312186;
                              buf[114] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -987909509;
                              buf[115] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -111627215;
                              buf[116] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -2138938757;
                              buf[117] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = -200146014;
                              buf[118] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = 1978319451;
                              buf[119] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 609036538;
                              buf[120] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 72192983;
                              buf[121] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 424950382;
                              buf[122] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = 448282126;
                              buf[123] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = 1368866312;
                              buf[124] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = -727358275;
                              buf[125] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -242170366;
                              buf[126] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -854844753;
                              buf[127] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -852642281;
                              buf[128] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = -976996828;
                              buf[129] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 1780776854;
                              buf[130] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = -512432048;
                              buf[131] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = -1952843016;
                              buf[132] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 206546038;
                              buf[133] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -1202302027;
                              buf[134] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -1388268426;
                              buf[135] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = 1645112658;
                              buf[136] = (byte) (HSDevTeam >>> 5);
                              HSDevTeam = 108352242;
                              buf[137] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 1387054270;
                              buf[138] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -1860916072;
                              buf[139] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = -1214205218;
                              buf[140] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = 1829379253;
                              buf[141] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = 1973613102;
                              buf[142] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = 1694098595;
                              buf[143] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 22847786;
                              buf[144] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = -1168463976;
                              buf[145] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1728501460;
                              buf[146] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 1106236713;
                              buf[147] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = -1200496937;
                              buf[148] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1802906146;
                              buf[149] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = 744864004;
                              buf[150] = (byte) (HSDevTeam >>> 23);
                              HSDevTeam = -1940474003;
                              buf[151] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -766913316;
                              buf[152] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = -807400728;
                              buf[153] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 1524136099;
                              buf[154] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -337872184;
                              buf[155] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 1754560832;
                              buf[156] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = 913778974;
                              buf[157] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 983742907;
                              buf[158] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = -2001167088;
                              buf[159] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = -1456202333;
                              buf[160] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -1442403927;
                              buf[161] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 1517139501;
                              buf[162] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 1076499868;
                              buf[163] = (byte) (HSDevTeam >>> 6);
                              HSDevTeam = -1412841034;
                              buf[164] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -485395291;
                              buf[165] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 879321848;
                              buf[166] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 1919187433;
                              buf[167] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 1983921030;
                              buf[168] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = -1292564849;
                              buf[169] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 895279794;
                              buf[170] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = -899638712;
                              buf[171] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = -1458878187;
                              buf[172] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 73901660;
                              buf[173] = (byte) (HSDevTeam >>> 12);
                              return new String(buf);
                            }
                          }.toString().getBytes(),
                          android.util.Base64.DEFAULT))
                  .getBytes(),
              android.util.Base64.DEFAULT));

  public SecurePref(Context context, OnUpdateListener listener) {
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
