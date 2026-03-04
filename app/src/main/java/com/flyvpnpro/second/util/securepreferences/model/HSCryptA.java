package com.flyvpnpro.second.util.securepreferences.model;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.crypto.Cipher;
import java.util.Arrays;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*╭━─━─━─≪  H - S   ≫─━─━─━╮

   ☮▁▂▃▄☾ ♛ HlaMyoMin ♛ ☽▄▃▂▁☮

  ╰━─━─━─≪ DEV-TEAM ≫─━─━─━╯ 

 Developed by HSDevTeam | HSVPNPRO_OFFICIAL     */

public final class HSCryptA {

    private static final String TAG = "HSCryptA";

    private static final String AES_MODE = "AES/CBC/PKCS7Padding";

    private static final String CHARSET = "UTF-8";

    private static final String HASH_ALGORITHM = "SHA-256";

    public static boolean DEBUG_LOG_ENABLED = false;

    private static final byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    private static SecretKeySpec generateKey(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] bytes = password.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        log("SHA-256 key ", key);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return secretKeySpec;
    }

    public static String encrypt(final String password, String message)
    throws GeneralSecurityException {
        try {
            String hs = HSkey(password);
            SecretKeySpec generateKey = generateKey(hs);
            log("message", message);
            String encodeToString = Base64.encodeToString(encrypt(generateKey, ivBytes, message.getBytes(CHARSET)), 2);
            log("Base64.NO_WRAP", encodeToString);
            return HScodes(encodeToString);
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                Log.e(TAG, "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] encrypt(final SecretKeySpec key, final byte[] iv, final byte[] message)
    throws GeneralSecurityException {
        final Cipher cipher = Cipher.getInstance(AES_MODE);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] cipherText = cipher.doFinal(message);
        log("cipherText", cipherText);
        return cipherText;
    }

    public static String decrypt(final String password, String base64EncodedCipherText)
    throws GeneralSecurityException {
        String hs1 = genString(base64EncodedCipherText);
        try {
            String hs = HSkey(password);
            final SecretKeySpec key = generateKey(hs);
            log("base64EncodedCipherText", hs1);
            byte[] decodedCipherText = Base64.decode(hs1, Base64.NO_WRAP);
            log("decodedCipherText", decodedCipherText);
            byte[] decryptedBytes = decrypt(key, ivBytes, decodedCipherText);
            log("decryptedBytes", decryptedBytes);
            String message = new String(decryptedBytes, CHARSET);
            log("message", message);
            return message;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED)
                Log.e(TAG, "UnsupportedEncodingException ", e);
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] decrypt(final SecretKeySpec key, final byte[] iv, final byte[] decodedCipherText)
    throws GeneralSecurityException {
        final Cipher cipher = Cipher.getInstance(AES_MODE);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(decodedCipherText);
        log("decryptedBytes", decryptedBytes);
        return decryptedBytes;
    }

    private static void log(String what, byte[] bytes) {
        if (DEBUG_LOG_ENABLED)
            Log.d(TAG, what + "[" + bytes.length + "] [" + bytesToHex(bytes) + "]");
    }

    private static void log(String what, String value) {
        if (DEBUG_LOG_ENABLED)
            Log.d(TAG, what + "[" + value.length() + "] [" + value + "]");
    }

  private static final String FuckYourMother =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[72];
              HSDevTeam = 922746792;
              buf[0] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 922746884;
              buf[1] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 26214425;
              buf[2] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -5559;
              buf[3] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -105381902;
              buf[4] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 441;
              buf[5] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 409625;
              buf[6] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 11210;
              buf[7] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -843055214;
              buf[8] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -409652;
              buf[9] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -107479159;
              buf[10] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -23514;
              buf[11] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -1686110316;
              buf[12] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 28835925;
              buf[13] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -823;
              buf[14] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -6193213;
              buf[15] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 870;
              buf[16] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 3604546;
              buf[17] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -13151;
              buf[18] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -5603431;
              buf[19] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 13841;
              buf[20] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -838860820;
              buf[21] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 104857658;
              buf[22] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 326;
              buf[23] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 922746829;
              buf[24] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -51322;
              buf[25] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 6553623;
              buf[26] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -3047529;
              buf[27] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -1686110325;
              buf[28] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -25722;
              buf[29] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -839762;
              buf[30] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -86573;
              buf[31] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -51523;
              buf[32] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -1677721674;
              buf[33] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 26214522;
              buf[34] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 1196135;
              buf[35] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 55297;
              buf[36] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -6553694;
              buf[37] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 805;
              buf[38] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 25089;
              buf[39] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 217;
              buf[40] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -1677721705;
              buf[41] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 51200;
              buf[42] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 1427;
              buf[43] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -25768;
              buf[44] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 28187;
              buf[45] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -859832438;
              buf[46] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 1509949461;
              buf[47] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -3293203;
              buf[48] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -803;
              buf[49] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -429916173;
              buf[50] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 1493172199;
              buf[51] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 867;
              buf[52] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -25612;
              buf[53] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -859832436;
              buf[54] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -331350106;
              buf[55] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 479;
              buf[56] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -144504;
              buf[57] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -40894562;
              buf[58] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 7390;
              buf[59] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 872415248;
              buf[60] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 3552;
              buf[61] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 274440;
              buf[62] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 115;
              buf[63] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -184549464;
              buf[64] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 110100484;
              buf[65] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 13369369;
              buf[66] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -4915255;
              buf[67] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -19922958;
              buf[68] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 79691897;
              buf[69] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 612368409;
              buf[70] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 499786;
              buf[71] = (byte) (HSDevTeam >>> 13);
              return new String(buf);
            }
          }.toString());

    private static String bytesToHex(byte[] bytes) {
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String HSkey(String str) {
        Objects.requireNonNull(str);
        return HSHex(str.getBytes());
    }

    private static String HSHex(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(charArray[(b & 240) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString();
    }

    public static String HScodes(String str) {
        Objects.requireNonNull(str);
        return hsgen(str.getBytes());
    }

    private static String hsgen(byte[] bArr) {
        char[] charArray = HSTest(FuckYourMother).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(charArray[(b & 240) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString();
    }

    public static String HSTest(String str) {
        return new String(Base64.decode(str, Base64.NO_WRAP));
    }

    public static String genString(String str) {
        String var = HSTest(FuckYourMother);
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((var.indexOf(charArray[i2]) * 16) + var.indexOf(charArray[i2 + 1])) & 255);
        }
        return new String(bArr);
    }

}