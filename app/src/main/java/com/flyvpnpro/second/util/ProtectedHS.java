package com.flyvpnpro.second.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.util.Log;
import android.widget.Toast;
import com.flyvpnpro.official.BuildConfig;
import com.flyvpnpro.official.R;

/**
 * @author Skank3r
 */

public class ProtectedHS {

  private static final String TAG = ProtectedHS.class.getSimpleName();

  private static final String APP_BASE =
      new Object() {
   int MDevz;
   public String toString() {
      byte[] buf = new byte[22];
      MDevz = -327155759;
      buf[0] = (byte) (MDevz >>> 21);
      MDevz = -295027;
      buf[1] = (byte) (MDevz >>> 11);
      MDevz = 14057;
      buf[2] = (byte) (MDevz >>> 7);
      MDevz = 385876054;
      buf[3] = (byte) (MDevz >>> 23);
      MDevz = -39207;
      buf[4] = (byte) (MDevz >>> 8);
      MDevz = -2358;
      buf[5] = (byte) (MDevz >>> 4);
      MDevz = -8616;
      buf[6] = (byte) (MDevz >>> 6);
      MDevz = 120879;
      buf[7] = (byte) (MDevz >>> 10);
      MDevz = 469762139;
      buf[8] = (byte) (MDevz >>> 22);
      MDevz = 886;
      buf[9] = (byte) (MDevz >>> 3);
      MDevz = -18376;
      buf[10] = (byte) (MDevz >>> 7);
      MDevz = 912;
      buf[11] = (byte) (MDevz >>> 3);
      MDevz = 28467;
      buf[12] = (byte) (MDevz >>> 8);
      MDevz = 3014742;
      buf[13] = (byte) (MDevz >>> 16);
      MDevz = -18874453;
      buf[14] = (byte) (MDevz >>> 17);
      MDevz = -20054095;
      buf[15] = (byte) (MDevz >>> 17);
      MDevz = 6542;
      buf[16] = (byte) (MDevz >>> 6);
      MDevz = 55050272;
      buf[17] = (byte) (MDevz >>> 19);
      MDevz = -39988;
      buf[18] = (byte) (MDevz >>> 8);
      MDevz = 13490;
      buf[19] = (byte) (MDevz >>> 7);
      MDevz = 6241;
      buf[20] = (byte) (MDevz >>> 6);
      MDevz = -18870;
      buf[21] = (byte) (MDevz >>> 7);
 return new String(buf);
   }
}.toString();

  private static final String APP_NAME =
      new Object() {
   int MDevz;
   public String toString() {
      byte[] buf = new byte[11];
      MDevz = 3266;
      buf[0] = (byte) (MDevz >>> 5);
      MDevz = 1739;
      buf[1] = (byte) (MDevz >>> 4);
      MDevz = 126877816;
      buf[2] = (byte) (MDevz >>> 20);
      MDevz = 8388721;
      buf[3] = (byte) (MDevz >>> 18);
      MDevz = 1903;
      buf[4] = (byte) (MDevz >>> 4);
      MDevz = 1879048254;
      buf[5] = (byte) (MDevz >>> 24);
      MDevz = 112733;
      buf[6] = (byte) (MDevz >>> 10);
      MDevz = -467665003;
      buf[7] = (byte) (MDevz >>> 21);
      MDevz = -1199570946;
      buf[8] = (byte) (MDevz >>> 23);
      MDevz = 3672;
      buf[9] = (byte) (MDevz >>> 5);
      MDevz = -1207959676;
      buf[10] = (byte) (MDevz >>> 23);
 return new String(buf);
   }
}.toString();

  // Assinatura da Google Play
  // private static final String APP_SIGNATURE = "XbhYZ4Bz/9F4cWLIDMg0wl/+jl8=\n";

  private static ProtectedHS mInstance;

  private Context mContext;

  public static void init(Context context) {
    if (mInstance == null) {
      mInstance = new ProtectedHS(context);

      // This method will print your certificate signature to the logcat.
      // AndroidTamperingProtectionUtils.getCertificateSignature(context);
    }
  }

  private ProtectedHS(Context context) {
    mContext = context;
  }

  /*public void tamperProtect() {
  AndroidTamperingProtection androidTamperingProtection = new AndroidTamperingProtection.Builder(mContext, APP_SIGNATURE)
  .installOnlyFromPlayStore(false) // By default is set to false.
  .build();

  if (!androidTamperingProtection.validate()) {
  throw new RuntimeException();
  }
  }*/

  public void simpleProtect() {
    if (!APP_BASE.equals(mContext.getPackageName().toLowerCase())
        || !mContext.getString(R.string.app_name).toLowerCase().equals(APP_NAME)) {
      throw new RuntimeException();
    }
  }

  public static void CharlieProtect() {
    if (mInstance == null) return;

    mInstance.simpleProtect();

    // ative apenas ao enviar pra PlayStore
    // mInstance.tamperProtect();
  }
}
