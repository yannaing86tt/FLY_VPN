package com.flyvpnpro.second.tunnel;

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

    public final class HSCryptD {

    private static final String TAG = "HSCryptD";

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
              byte[] buf = new byte[164];
              HSDevTeam = 218103829;
              buf[0] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 59244601;
              buf[1] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 4390974;
              buf[2] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -774183;
              buf[3] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -831583;
              buf[4] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -4653147;
              buf[5] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -754;
              buf[6] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -24185;
              buf[7] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -3255;
              buf[8] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 29622333;
              buf[9] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 8781936;
              buf[10] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -6127722;
              buf[11] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 3407965;
              buf[12] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 1912602584;
              buf[13] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 68626;
              buf[14] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 578814008;
              buf[15] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -52049;
              buf[16] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -4572;
              buf[17] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -385114;
              buf[18] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 4485;
              buf[19] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -415846;
              buf[20] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -36386;
              buf[21] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 2195485;
              buf[22] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -369;
              buf[23] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -106430503;
              buf[24] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 1912602542;
              buf[25] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -12320784;
              buf[26] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 75497481;
              buf[27] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -1663056;
              buf[28] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 455;
              buf[29] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -1505;
              buf[30] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = -186483;
              buf[31] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -851443813;
              buf[32] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 7405580;
              buf[33] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -24149;
              buf[34] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 1258291168;
              buf[35] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 218103898;
              buf[36] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -571;
              buf[37] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -394264671;
              buf[38] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 4817;
              buf[39] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 889192366;
              buf[40] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 57933;
              buf[41] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -377;
              buf[42] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -375390212;
              buf[43] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -52045;
              buf[44] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -2326613;
              buf[45] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 2195460;
              buf[46] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 39541;
              buf[47] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -1630;
              buf[48] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 947912831;
              buf[49] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 1097760;
              buf[50] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 2555918;
              buf[51] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -53215356;
              buf[52] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 115713;
              buf[53] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 17204;
              buf[54] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 1342177237;
              buf[55] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 3367;
              buf[56] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 1912602622;
              buf[57] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 8580;
              buf[58] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 1294;
              buf[59] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -425721955;
              buf[60] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -74448997;
              buf[61] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -24641580;
              buf[62] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 5308518;
              buf[63] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 27262997;
              buf[64] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 3702841;
              buf[65] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 2174;
              buf[66] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -44327;
              buf[67] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -104031;
              buf[68] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -581723;
              buf[69] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -385074;
              buf[70] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -2761;
              buf[71] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -207895;
              buf[72] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = 227;
              buf[73] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 17264;
              buf[74] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -21994;
              buf[75] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 13405;
              buf[76] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -572;
              buf[77] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 8594;
              buf[78] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 340;
              buf[79] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -415825;
              buf[80] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -290844;
              buf[81] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -48218;
              buf[82] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 704581;
              buf[83] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -408;
              buf[84] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -290850;
              buf[85] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 1085;
              buf[86] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -1409286225;
              buf[87] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -3325991;
              buf[88] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -37224530;
              buf[89] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -3080208;
              buf[90] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 5767177;
              buf[91] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -3326032;
              buf[92] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 29622335;
              buf[93] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -98566185;
              buf[94] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -5331;
              buf[95] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -6501;
              buf[96] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 28940;
              buf[97] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -49283157;
              buf[98] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -173015072;
              buf[99] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 852058;
              buf[100] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -148897863;
              buf[101] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -6047;
              buf[102] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 50856017;
              buf[103] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 889192366;
              buf[104] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 118489165;
              buf[105] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -12043;
              buf[106] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -5028;
              buf[107] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -813;
              buf[108] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -4565;
              buf[109] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 17563652;
              buf[110] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 405621;
              buf[111] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 889192394;
              buf[112] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 29622399;
              buf[113] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 8781856;
              buf[114] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 12814;
              buf[115] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -816;
              buf[116] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 29622273;
              buf[117] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 35127348;
              buf[118] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -322961451;
              buf[119] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 839;
              buf[120] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -4546;
              buf[121] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 137220;
              buf[122] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 6684734;
              buf[123] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 889192349;
              buf[124] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -18277;
              buf[125] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -12320812;
              buf[126] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 830;
              buf[127] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 426005;
              buf[128] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 1817;
              buf[129] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 2195518;
              buf[130] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -158335015;
              buf[131] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -415839;
              buf[132] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -72795;
              buf[133] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -96306;
              buf[134] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -35389561;
              buf[135] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -212860951;
              buf[136] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 227;
              buf[137] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 35127408;
              buf[138] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -1124073578;
              buf[139] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 54526045;
              buf[140] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -4552;
              buf[141] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 1124073490;
              buf[142] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 7864;
              buf[143] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -813;
              buf[144] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -572;
              buf[145] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -24641626;
              buf[146] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 100663365;
              buf[147] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -557158;
              buf[148] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -4620322;
              buf[149] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 811037;
              buf[150] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -2241;
              buf[151] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -3325991;
              buf[152] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -75497554;
              buf[153] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -48144;
              buf[154] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 233481;
              buf[155] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -360528;
              buf[156] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 215103;
              buf[157] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 1728053207;
              buf[158] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -19660915;
              buf[159] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -39845989;
              buf[160] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 152;
              buf[161] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -47710293;
              buf[162] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -49696;
              buf[163] = (byte) (HSDevTeam >>> 8);
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