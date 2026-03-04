package com.flyvpnpro.main.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/** Created by: KervzCodes Date Crated: 08/10/2020 Project: SocksHttp-master (ENGLISH) */

public class ConfigUtil {

  Context context;

  public static final String PASSWORD =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[25];
              HSDevTeam = 224395278;
              buf[0] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 1627390026;
              buf[1] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 1740;
              buf[2] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 1686;
              buf[3] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 218103870;
              buf[4] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -383;
              buf[5] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 99;
              buf[6] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -1602224154;
              buf[7] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -412;
              buf[8] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -450626;
              buf[9] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 13107;
              buf[10] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 9437195;
              buf[11] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 75865;
              buf[12] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -37486596;
              buf[13] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 14639;
              buf[14] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -36869;
              buf[15] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 290;
              buf[16] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 87031869;
              buf[17] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -6127702;
              buf[18] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -617;
              buf[19] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 60535;
              buf[20] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 43090;
              buf[21] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -10092614;
              buf[22] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -10127;
              buf[23] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -587;
              buf[24] = (byte) (HSDevTeam >>> 2);
              return new String(buf);
            }
          }.toString());

  public static final String HWIDPASS =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[11];
              HSDevTeam = 603979869;
              buf[0] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 1459617855;
              buf[1] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 1224736865;
              buf[2] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -12007;
              buf[3] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -177209413;
              buf[4] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 74855;
              buf[5] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 1289;
              buf[6] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 210;
              buf[7] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -47363;
              buf[8] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -183404;
              buf[9] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -170067;
              buf[10] = (byte) (HSDevTeam >>> 10);
              return new String(buf);
            }
          }.toString());

  public ConfigUtil(Context context) {
    this.context = context;
  }

  public String geNote() {
    try {
      String releaseNote = getJSONConfig().getString("ReleaseNotes");
      return releaseNote;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getVersion() {
    try {
      String version = getJSONConfig().getString("Version");
      return version;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public JSONArray getServersArray() {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Servers");
        return array;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList getNetworkSSLArray(ArrayList arraylist) {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Networks");
        JSONArray jarr2 = array.getJSONObject(0).getJSONArray("SSL");
        for (int i = 0; i < jarr2.length(); i++) {
          JSONObject obj = jarr2.getJSONObject(i);
          arraylist.add(obj.getString("Name"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList getNetworkSSHArray(ArrayList arraylist) {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Networks");
        JSONArray jarr2 = array.getJSONObject(0).getJSONArray("SSH");
        for (int i = 0; i < jarr2.length(); i++) {
          JSONObject obj = jarr2.getJSONObject(i);
          arraylist.add(obj.getString("Name"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public JSONArray getNetworksArray() {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Networks");
        return array;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public boolean versionCompare(String NewVersion, String OldVersion) {
    String[] vals1 = NewVersion.split("\\.");
    String[] vals2 = OldVersion.split("\\.");
    int i = 0;

    // set index to first non-equal ordinal or length of shortest version string
    while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
      i++;
    }
    // compare first non-equal ordinal number
    if (i < vals1.length && i < vals2.length) {
      int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
      return Integer.signum(diff) > 0;
    }

    // the strings are equal or one string is a substring of the other
    // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
    return Integer.signum(vals1.length - vals2.length) > 0;
  }

  private JSONObject getJSONConfig() {
    try {
      File file = new File(context.getFilesDir(), "flyvpnpro.json");
      if (file.exists()) {
        String json_file = readStream(new FileInputStream(file));
        try {
          String json = AESCrypt.decrypt(PASSWORD, json_file);
          return new JSONObject(json);
        } catch (Exception ignored) {
          // plain JSON fallback
          return new JSONObject(json_file);
        }
      } else {
        InputStream inputStream = context.getAssets().open("flyvpnpro/flyvpnpro.json");
        String raw = readStream(inputStream);
        try {
          String json = AESCrypt.decrypt(PASSWORD, raw);
          return new JSONObject(json);
        } catch (Exception ignored) {
          // plain JSON fallback
          return new JSONObject(raw);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private String readStream(InputStream in) {
    StringBuilder sb = new StringBuilder();
    try {
      Reader reader = new BufferedReader(new InputStreamReader(in));
      char[] buff = new char[1024];
      while (true) {
        int read = reader.read(buff, 0, buff.length);
        if (read <= 0) {
          break;
        }
        sb.append(buff, 0, read);
      }
    } catch (Exception e) {

    }
    return sb.toString();
  }
}
