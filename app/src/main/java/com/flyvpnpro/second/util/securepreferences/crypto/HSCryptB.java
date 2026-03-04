package com.flyvpnpro.second.util.securepreferences.crypto;

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

public final class HSCryptB {

    private static final String TAG = "HSCryptB";

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
              byte[] buf = new byte[56];
              HSDevTeam = -827515;
              buf[0] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -1294398;
              buf[1] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 696254507;
              buf[2] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -18617;
              buf[3] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 1736766;
              buf[4] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 1275068481;
              buf[5] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -302;
              buf[6] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 1962934209;
              buf[7] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -105381943;
              buf[8] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -1359902;
              buf[9] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -10092557;
              buf[10] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 330;
              buf[11] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -809;
              buf[12] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -74973305;
              buf[13] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -80740420;
              buf[14] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 434;
              buf[15] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -13238341;
              buf[16] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 459;
              buf[17] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -385121;
              buf[18] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -13282;
              buf[19] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -1616;
              buf[20] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 94371887;
              buf[21] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -141425;
              buf[22] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -78119039;
              buf[23] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 108581;
              buf[24] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 218103928;
              buf[25] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 2292;
              buf[26] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 467065;
              buf[27] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 27151;
              buf[28] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 3574;
              buf[29] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -153092118;
              buf[30] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -733244;
              buf[31] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -26476602;
              buf[32] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 217091;
              buf[33] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -2818176;
              buf[34] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 1996488816;
              buf[35] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 106;
              buf[36] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 100434;
              buf[37] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -12058690;
              buf[38] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 3932252;
              buf[39] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 31195159;
              buf[40] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 1867895;
              buf[41] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -2500;
              buf[42] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -286830;
              buf[43] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -831594;
              buf[44] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 3571;
              buf[45] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 543;
              buf[46] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 973078486;
              buf[47] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -1413;
              buf[48] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = -4915253;
              buf[49] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 427819036;
              buf[50] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -602;
              buf[51] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -9773;
              buf[52] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -1501560940;
              buf[53] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 4715;
              buf[54] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -12714047;
              buf[55] = (byte) (HSDevTeam >>> 16);
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