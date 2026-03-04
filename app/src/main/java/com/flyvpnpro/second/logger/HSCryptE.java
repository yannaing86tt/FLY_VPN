package com.flyvpnpro.second.logger;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Objects;

/*╭━─━─━─≪  H - S   ≫─━─━─━╮

   ☮▁▂▃▄☾ ♛ HlaMyoMin ♛ ☽▄▃▂▁☮

  ╰━─━─━─≪ DEV-TEAM ≫─━─━─━╯ 

 Developed by HSDevTeam | HSVPNPRO_OFFICIAL     */

public final class  HSCryptE {

    private static final String TAG = " HSCryptE";

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
              byte[] buf = new byte[80];
              HSDevTeam = 436207643;
              buf[0] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 113674;
              buf[1] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -98566241;
              buf[2] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 261;
              buf[3] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 106539;
              buf[4] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -301989903;
              buf[5] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -1577058396;
              buf[6] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -387172;
              buf[7] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -415783;
              buf[8] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -75497555;
              buf[9] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 269;
              buf[10] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -1540222;
              buf[11] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 212993;
              buf[12] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -294988;
              buf[13] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -96327;
              buf[14] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 557145;
              buf[15] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -13303876;
              buf[16] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 1862271073;
              buf[17] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 135;
              buf[18] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 279;
              buf[19] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -831601;
              buf[20] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 1791;
              buf[21] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -197132321;
              buf[22] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 73400350;
              buf[23] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 419;
              buf[24] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 7116;
              buf[25] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -192590;
              buf[26] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -1543503951;
              buf[27] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 109051971;
              buf[28] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -9225;
              buf[29] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -192522;
              buf[30] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 1224736724;
              buf[31] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 213012;
              buf[32] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 7111;
              buf[33] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 1140850623;
              buf[34] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -745481;
              buf[35] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 106593;
              buf[36] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 28425;
              buf[37] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -3080284;
              buf[38] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -5794;
              buf[39] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 1704012;
              buf[40] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -150995045;
              buf[41] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 2145;
              buf[42] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -754974811;
              buf[43] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 3407919;
              buf[44] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 1879048175;
              buf[45] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 17563768;
              buf[46] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 311378;
              buf[47] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -851443802;
              buf[48] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -36979;
              buf[49] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -197132350;
              buf[50] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 161480726;
              buf[51] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 109051973;
              buf[52] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 909355;
              buf[53] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 34329;
              buf[54] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 313;
              buf[55] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -415862;
              buf[56] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -18492;
              buf[57] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -3080293;
              buf[58] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 5081;
              buf[59] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -1702887527;
              buf[60] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 1818693;
              buf[61] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -3080207;
              buf[62] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 655432;
              buf[63] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 6815771;
              buf[64] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 29097994;
              buf[65] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -6160481;
              buf[66] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 5046301;
              buf[67] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 1703979;
              buf[68] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -36879;
              buf[69] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -49283164;
              buf[70] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -742391908;
              buf[71] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -106430503;
              buf[72] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -1179731;
              buf[73] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 17563657;
              buf[74] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -180350;
              buf[75] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 436207617;
              buf[76] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -37748812;
              buf[77] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -377;
              buf[78] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 161;
              buf[79] = (byte) (HSDevTeam >>> 1);
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