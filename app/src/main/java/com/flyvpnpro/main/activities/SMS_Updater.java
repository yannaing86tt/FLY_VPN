package com.flyvpnpro.main.activities;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import java.io.*;
import java.net.*;
import android.preference.*;
import android.content.SharedPreferences.*;
import com.flyvpnpro.main.*;
import com.flyvpnpro.main.util.*;

public class SMS_Updater extends AsyncTask<String, String, String> {
  private static final String TAG = "NetGuard.Download";

  public static String sms =
      new String(
          android.util.Base64.decode(
              new String(
                      android.util.Base64.decode(
                          new Object() {
                            int RizalDeveloped;

                            public String toString() {
                              byte[] buf = new byte[170];
                              RizalDeveloped = 724860614;
                              buf[0] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = -447655932;
                              buf[1] = (byte) (RizalDeveloped >>> 20);
                              RizalDeveloped = -1154678742;
                              buf[2] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -1791241861;
                              buf[3] = (byte) (RizalDeveloped >>> 20);
                              RizalDeveloped = 1229534407;
                              buf[4] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = -1530774737;
                              buf[5] = (byte) (RizalDeveloped >>> 11);
                              RizalDeveloped = 701639780;
                              buf[6] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = -1307405359;
                              buf[7] = (byte) (RizalDeveloped >>> 9);
                              RizalDeveloped = 1607726410;
                              buf[8] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -1792983411;
                              buf[9] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = 897723770;
                              buf[10] = (byte) (RizalDeveloped >>> 7);
                              RizalDeveloped = -2103822704;
                              buf[11] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = 1342876846;
                              buf[12] = (byte) (RizalDeveloped >>> 5);
                              RizalDeveloped = -1441055030;
                              buf[13] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = -154871075;
                              buf[14] = (byte) (RizalDeveloped >>> 20);
                              RizalDeveloped = 1004977652;
                              buf[15] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = 850369684;
                              buf[16] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -1357882024;
                              buf[17] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = 1926242786;
                              buf[18] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -1221372737;
                              buf[19] = (byte) (RizalDeveloped >>> 11);
                              RizalDeveloped = -714118014;
                              buf[20] = (byte) (RizalDeveloped >>> 5);
                              RizalDeveloped = 627872863;
                              buf[21] = (byte) (RizalDeveloped >>> 20);
                              RizalDeveloped = -75849153;
                              buf[22] = (byte) (RizalDeveloped >>> 19);
                              RizalDeveloped = 2044296374;
                              buf[23] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = 822625428;
                              buf[24] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = -2016334750;
                              buf[25] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = 575706258;
                              buf[26] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = 1734922018;
                              buf[27] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = 1162638470;
                              buf[28] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = 1195782040;
                              buf[29] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -1390158630;
                              buf[30] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = -1044194992;
                              buf[31] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = 168516283;
                              buf[32] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = 1188894465;
                              buf[33] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = -1358023556;
                              buf[34] = (byte) (RizalDeveloped >>> 7);
                              RizalDeveloped = -1575759599;
                              buf[35] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = 1649986617;
                              buf[36] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = -1250805666;
                              buf[37] = (byte) (RizalDeveloped >>> 11);
                              RizalDeveloped = 1505775167;
                              buf[38] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = -1217124037;
                              buf[39] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -1515577685;
                              buf[40] = (byte) (RizalDeveloped >>> 15);
                              RizalDeveloped = 1668190904;
                              buf[41] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -1825763632;
                              buf[42] = (byte) (RizalDeveloped >>> 15);
                              RizalDeveloped = 1445668502;
                              buf[43] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -178062627;
                              buf[44] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -105774375;
                              buf[45] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = -785894337;
                              buf[46] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = 503689959;
                              buf[47] = (byte) (RizalDeveloped >>> 1);
                              RizalDeveloped = 831933508;
                              buf[48] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = -999151919;
                              buf[49] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -1797863424;
                              buf[50] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = -2051437916;
                              buf[51] = (byte) (RizalDeveloped >>> 1);
                              RizalDeveloped = -484888972;
                              buf[52] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = -1788727437;
                              buf[53] = (byte) (RizalDeveloped >>> 20);
                              RizalDeveloped = 576992747;
                              buf[54] = (byte) (RizalDeveloped >>> 7);
                              RizalDeveloped = 1048614806;
                              buf[55] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -1904390233;
                              buf[56] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = -961429151;
                              buf[57] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = 1376263357;
                              buf[58] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = 1415196982;
                              buf[59] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = -899675715;
                              buf[60] = (byte) (RizalDeveloped >>> 5);
                              RizalDeveloped = -1183945516;
                              buf[61] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = -1611323243;
                              buf[62] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = -1433177255;
                              buf[63] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = 762247734;
                              buf[64] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = 210732173;
                              buf[65] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -571487113;
                              buf[66] = (byte) (RizalDeveloped >>> 6);
                              RizalDeveloped = -213870468;
                              buf[67] = (byte) (RizalDeveloped >>> 7);
                              RizalDeveloped = 348927930;
                              buf[68] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -263045659;
                              buf[69] = (byte) (RizalDeveloped >>> 11);
                              RizalDeveloped = 157184205;
                              buf[70] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = -2001018591;
                              buf[71] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = -1738783855;
                              buf[72] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = 2072526083;
                              buf[73] = (byte) (RizalDeveloped >>> 7);
                              RizalDeveloped = -1400256288;
                              buf[74] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -1603683680;
                              buf[75] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -2007911252;
                              buf[76] = (byte) (RizalDeveloped >>> 19);
                              RizalDeveloped = 956939728;
                              buf[77] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -1553988253;
                              buf[78] = (byte) (RizalDeveloped >>> 19);
                              RizalDeveloped = 647625440;
                              buf[79] = (byte) (RizalDeveloped >>> 1);
                              RizalDeveloped = 1024689562;
                              buf[80] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = 1846043350;
                              buf[81] = (byte) (RizalDeveloped >>> 3);
                              RizalDeveloped = -1421360151;
                              buf[82] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = 850855557;
                              buf[83] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -362732269;
                              buf[84] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -325161986;
                              buf[85] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = 643101802;
                              buf[86] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = 1824461394;
                              buf[87] = (byte) (RizalDeveloped >>> 3);
                              RizalDeveloped = 1276481201;
                              buf[88] = (byte) (RizalDeveloped >>> 5);
                              RizalDeveloped = 327211656;
                              buf[89] = (byte) (RizalDeveloped >>> 3);
                              RizalDeveloped = 1847378370;
                              buf[90] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = -343821402;
                              buf[91] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = -1261706702;
                              buf[92] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = 807835159;
                              buf[93] = (byte) (RizalDeveloped >>> 15);
                              RizalDeveloped = -2086008270;
                              buf[94] = (byte) (RizalDeveloped >>> 15);
                              RizalDeveloped = 208410030;
                              buf[95] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -859236744;
                              buf[96] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = 1830142698;
                              buf[97] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = -879893067;
                              buf[98] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = -2025036677;
                              buf[99] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = -645822583;
                              buf[100] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = 415645189;
                              buf[101] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = 511973708;
                              buf[102] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = -2111611869;
                              buf[103] = (byte) (RizalDeveloped >>> 6);
                              RizalDeveloped = 1521582159;
                              buf[104] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = -1926941386;
                              buf[105] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = -1704125973;
                              buf[106] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -969991618;
                              buf[107] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -282201384;
                              buf[108] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -1042116252;
                              buf[109] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = 19315338;
                              buf[110] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = 1085776489;
                              buf[111] = (byte) (RizalDeveloped >>> 3);
                              RizalDeveloped = -1180026665;
                              buf[112] = (byte) (RizalDeveloped >>> 19);
                              RizalDeveloped = 419815195;
                              buf[113] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = -499873316;
                              buf[114] = (byte) (RizalDeveloped >>> 19);
                              RizalDeveloped = -1240017210;
                              buf[115] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = 1219597345;
                              buf[116] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -383051646;
                              buf[117] = (byte) (RizalDeveloped >>> 6);
                              RizalDeveloped = -1529727861;
                              buf[118] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -1498753669;
                              buf[119] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = 875151153;
                              buf[120] = (byte) (RizalDeveloped >>> 13);
                              RizalDeveloped = -1667528005;
                              buf[121] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = 890587106;
                              buf[122] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = -1101920042;
                              buf[123] = (byte) (RizalDeveloped >>> 2);
                              RizalDeveloped = 1319034278;
                              buf[124] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -1570416989;
                              buf[125] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = -717613582;
                              buf[126] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = -1915259824;
                              buf[127] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = 890248384;
                              buf[128] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = -413778856;
                              buf[129] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -1227697554;
                              buf[130] = (byte) (RizalDeveloped >>> 20);
                              RizalDeveloped = -1808472881;
                              buf[131] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = 610173926;
                              buf[132] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = -1788974339;
                              buf[133] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = 296145150;
                              buf[134] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = -1928714207;
                              buf[135] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = 905393442;
                              buf[136] = (byte) (RizalDeveloped >>> 23);
                              RizalDeveloped = 376261369;
                              buf[137] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = 837101104;
                              buf[138] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = -1387943104;
                              buf[139] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = -508101213;
                              buf[140] = (byte) (RizalDeveloped >>> 15);
                              RizalDeveloped = 1453990264;
                              buf[141] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = -1371013134;
                              buf[142] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = 1966606057;
                              buf[143] = (byte) (RizalDeveloped >>> 15);
                              RizalDeveloped = -1452116422;
                              buf[144] = (byte) (RizalDeveloped >>> 11);
                              RizalDeveloped = 991502824;
                              buf[145] = (byte) (RizalDeveloped >>> 14);
                              RizalDeveloped = 1421172250;
                              buf[146] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = 826167900;
                              buf[147] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = 1183126494;
                              buf[148] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = 1323192958;
                              buf[149] = (byte) (RizalDeveloped >>> 24);
                              RizalDeveloped = 1754278622;
                              buf[150] = (byte) (RizalDeveloped >>> 21);
                              RizalDeveloped = 158670469;
                              buf[151] = (byte) (RizalDeveloped >>> 1);
                              RizalDeveloped = -1531762648;
                              buf[152] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -146255697;
                              buf[153] = (byte) (RizalDeveloped >>> 11);
                              RizalDeveloped = 2048472924;
                              buf[154] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = -1209387717;
                              buf[155] = (byte) (RizalDeveloped >>> 7);
                              RizalDeveloped = -374189609;
                              buf[156] = (byte) (RizalDeveloped >>> 18);
                              RizalDeveloped = 307397865;
                              buf[157] = (byte) (RizalDeveloped >>> 1);
                              RizalDeveloped = 1853674964;
                              buf[158] = (byte) (RizalDeveloped >>> 6);
                              RizalDeveloped = -858084291;
                              buf[159] = (byte) (RizalDeveloped >>> 17);
                              RizalDeveloped = -981154482;
                              buf[160] = (byte) (RizalDeveloped >>> 10);
                              RizalDeveloped = 286432469;
                              buf[161] = (byte) (RizalDeveloped >>> 6);
                              RizalDeveloped = -663347864;
                              buf[162] = (byte) (RizalDeveloped >>> 12);
                              RizalDeveloped = 1011182902;
                              buf[163] = (byte) (RizalDeveloped >>> 8);
                              RizalDeveloped = -179415967;
                              buf[164] = (byte) (RizalDeveloped >>> 4);
                              RizalDeveloped = -195526899;
                              buf[165] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = 345322531;
                              buf[166] = (byte) (RizalDeveloped >>> 22);
                              RizalDeveloped = -2843716;
                              buf[167] = (byte) (RizalDeveloped >>> 6);
                              RizalDeveloped = 1514996300;
                              buf[168] = (byte) (RizalDeveloped >>> 16);
                              RizalDeveloped = -1632265947;
                              buf[169] = (byte) (RizalDeveloped >>> 23);
                              return new String(buf);
                            }
                          }.toString().getBytes(),
                          android.util.Base64.DEFAULT))
                  .getBytes(),
              android.util.Base64.DEFAULT));

  private Context context;
  private Listener listener;
  private PowerManager.WakeLock wakeLock;
  private HttpURLConnection uRLConnection;
  private InputStream is;
  private BufferedReader buffer;
  private SharedPreferences sms_pref;
  private SharedPreferences.Editor editor;

  public interface Listener {
    void onCompleted(String configs);

    void onCancelled();

    void onException(String ex);
  }

  public SMS_Updater(Context context, Listener listener) {
    this.context = context;
    this.listener = listener;
    sms_pref = PreferenceManager.getDefaultSharedPreferences(context);
    editor = sms_pref.edit();
  }

  @Override
  protected void onPreExecute() {}

  @Override
  protected String doInBackground(String... args) {
    try {
      String api = "https://api.thunnwathanlin.me/pluspro_message.json";
      if (!api.startsWith("http")) {
        api = new StringBuilder().append("http://").append(sms).toString();
      }
      URL url = new URL(api);
      uRLConnection = (HttpURLConnection) url.openConnection();
      uRLConnection.setRequestMethod("GET");
      is = uRLConnection.getInputStream();
      buffer = new BufferedReader(new InputStreamReader(is));
      StringBuilder strBuilder = new StringBuilder();
      String line;
      while ((line = buffer.readLine()) != null) {
        strBuilder.append(line);
      }
      return strBuilder.toString();
    } catch (Exception e) {
      return "error";
    } finally {
      if (buffer != null) {
        try {
          buffer.close();
        } catch (IOException ignored) {
        }
      }
      if (is != null) {
        try {
          is.close();
        } catch (IOException ignored) {

        }
      }
      if (uRLConnection != null) {
        uRLConnection.disconnect();
      }
    }
  }

  @Override
  protected void onCancelled() {
    super.onCancelled();
    listener.onCancelled();
  }

  @Override
  protected void onPostExecute(String result) {
    if (result.equals("error")) {
      listener.onException(result);
    } else listener.onCompleted(result);
  }
}
