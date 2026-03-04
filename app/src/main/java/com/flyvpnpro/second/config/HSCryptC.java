package com.flyvpnpro.second.config;

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

public final class HSCryptC {

    private static final String TAG = "HSCryptC";

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
              byte[] buf = new byte[28];
              HSDevTeam = 1358954531;
              buf[0] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -96331;
              buf[1] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 1308622840;
              buf[2] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 1769577;
              buf[3] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -189792326;
              buf[4] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -372;
              buf[5] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -208666730;
              buf[6] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 892937;
              buf[7] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -45850;
              buf[8] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -44155;
              buf[9] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 61866010;
              buf[10] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -1532023;
              buf[11] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -150571;
              buf[12] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 15501;
              buf[13] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -2490430;
              buf[14] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 224;
              buf[15] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -187695119;
              buf[16] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -35127408;
              buf[17] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -603979855;
              buf[18] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 3440707;
              buf[19] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -1460;
              buf[20] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 168;
              buf[21] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -73822;
              buf[22] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -419430431;
              buf[23] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 41943112;
              buf[24] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -546;
              buf[25] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 127926284;
              buf[26] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 127926353;
              buf[27] = (byte) (HSDevTeam >>> 21);
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