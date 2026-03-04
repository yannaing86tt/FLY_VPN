package com.flyvpnpro.main.util;

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

    public final class AESCrypt {

    private static final String TAG = "AESCrypt";

    private static final String AES_MODE = "AES/CBC/PKCS7Padding";

    private static final String CHARSET = "UTF-8";

    private static final String HASH_ALGORITHM = "SHA-256";

    public static boolean DEBUG_LOG_ENABLED = false;

    private static final byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

  private static final String FuckYouMother =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[165];
              HSDevTeam = -117440630;
              buf[0] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -262143954;
              buf[1] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -1140850805;
              buf[2] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -1795;
              buf[3] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -65535918;
              buf[4] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -36175771;
              buf[5] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -14750;
              buf[6] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -499;
              buf[7] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -17825848;
              buf[8] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -57;
              buf[9] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -2031620;
              buf[10] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -8796;
              buf[11] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -3632;
              buf[12] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -7952;
              buf[13] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -278540;
              buf[14] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -237509;
              buf[15] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -32000;
              buf[16] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -17825803;
              buf[17] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -245;
              buf[18] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -153091970;
              buf[19] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -58720291;
              buf[20] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -1040187515;
              buf[21] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -2228285;
              buf[22] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -14371;
              buf[23] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -2031738;
              buf[24] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -35261;
              buf[25] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -458779;
              buf[26] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -15968;
              buf[27] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -4456554;
              buf[28] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -520093640;
              buf[29] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -2336;
              buf[30] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -3672;
              buf[31] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -2080374815;
              buf[32] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -578813952;
              buf[33] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -31693;
              buf[34] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -18618;
              buf[35] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -229449;
              buf[36] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -1023882;
              buf[37] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -551;
              buf[38] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = -3930;
              buf[39] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -292;
              buf[40] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -29360134;
              buf[41] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -262143896;
              buf[42] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -578813857;
              buf[43] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -124;
              buf[44] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -18874439;
              buf[45] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -60817296;
              buf[46] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -8126559;
              buf[47] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -1157627877;
              buf[48] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -1023410255;
              buf[49] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -36896;
              buf[50] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -118739;
              buf[51] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -4063319;
              buf[52] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -4521976;
              buf[53] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -3932068;
              buf[54] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -1048546;
              buf[55] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -25271;
              buf[56] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -463470662;
              buf[57] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -486539213;
              buf[58] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -8191946;
              buf[59] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -2208;
              buf[60] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -130023361;
              buf[61] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -37748833;
              buf[62] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -245746;
              buf[63] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -4086;
              buf[64] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -23855058;
              buf[65] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -3701;
              buf[66] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -260046915;
              buf[67] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -17582;
              buf[68] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 933;
              buf[69] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -278430;
              buf[70] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -271;
              buf[71] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -3256;
              buf[72] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = 973078633;
              buf[73] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -492;
              buf[74] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = -9437276;
              buf[75] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -116;
              buf[76] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -511888;
              buf[77] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -34828;
              buf[78] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -4456389;
              buf[79] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -71303168;
              buf[80] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -12939;
              buf[81] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -25265;
              buf[82] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 2238;
              buf[83] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -115;
              buf[84] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -1015931;
              buf[85] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -285212733;
              buf[86] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -1048611;
              buf[87] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -4346;
              buf[88] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -52157;
              buf[89] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -1023410203;
              buf[90] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -589920;
              buf[91] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -403562;
              buf[92] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -124;
              buf[93] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -584;
              buf[94] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = -15204312;
              buf[95] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -15903;
              buf[96] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -2208;
              buf[97] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -30408653;
              buf[98] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -1023930;
              buf[99] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -17825865;
              buf[100] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -1040187274;
              buf[101] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -76545999;
              buf[102] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -986;
              buf[103] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -2308;
              buf[104] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -1958;
              buf[105] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -306184088;
              buf[106] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -982945;
              buf[107] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -520262;
              buf[108] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -92231;
              buf[109] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -1808;
              buf[110] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -130023519;
              buf[111] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -282597;
              buf[112] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -15695;
              buf[113] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -584;
              buf[114] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 237613;
              buf[115] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -58720343;
              buf[116] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -32248;
              buf[117] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -827300;
              buf[118] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -17378;
              buf[119] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -4456375;
              buf[120] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -12998;
              buf[121] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -243269581;
              buf[122] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -131071946;
              buf[123] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -8912992;
              buf[124] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 139;
              buf[125] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -499809;
              buf[126] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -1224736754;
              buf[127] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -1613942;
              buf[128] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -17362;
              buf[129] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -562036853;
              buf[130] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -6619203;
              buf[131] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -139182;
              buf[132] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -135;
              buf[133] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -1630;
              buf[134] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -71303151;
              buf[135] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -136;
              buf[136] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -53477271;
              buf[137] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -3588;
              buf[138] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -2097152092;
              buf[139] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -6448;
              buf[140] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -1040;
              buf[141] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -136314892;
              buf[142] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -102760389;
              buf[143] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -285212672;
              buf[144] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -135;
              buf[145] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -1617;
              buf[146] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -450;
              buf[147] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -16035;
              buf[148] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -1677721723;
              buf[149] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -262205;
              buf[150] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -137251;
              buf[151] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -423624826;
              buf[152] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -541;
              buf[153] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -137243;
              buf[154] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -423624800;
              buf[155] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -134217834;
              buf[156] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -16840;
              buf[157] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -100352;
              buf[158] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -17825752;
              buf[159] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -545259551;
              buf[160] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -1644167168;
              buf[161] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -1114061;
              buf[162] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -1114042;
              buf[163] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -25929;
              buf[164] = (byte) (HSDevTeam >>> 8);
              return new String(buf);
            }
          }.toString());

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
  // 4qCB4qCC4qCD4qCE4qCF4qCG4qCH4qCI4qCJ4qCK4qCL4qCM4qCN4qCO4qCP4qCQ4qCR4qCS4qCT4qCU4qCV4qCW4qCX4qCY4qCZ4qCa4qCb4qCc4qCd4qCe4qCf4qCg4qCh4qCi4qCj4qCk4qCl4qCm4qCn4qCo4qCp4qCq4qCr4qCs4qCt4qCu4qCv4qCw4qCx4qCy4qCz4qC0wrcs4oC9OifigLI=
  private static final String FuckYourMother =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[140];
              HSDevTeam = -106430537;
              buf[0] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 213097;
              buf[1] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 981467262;
              buf[2] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 327;
              buf[3] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 109051928;
              buf[4] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 1704040;
              buf[5] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -144703541;
              buf[6] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 84045;
              buf[7] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -1702887548;
              buf[8] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -53215326;
              buf[9] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -35449;
              buf[10] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = -90177574;
              buf[11] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 436207699;
              buf[12] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 54525995;
              buf[13] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 1979711382;
              buf[14] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 1354;
              buf[15] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -814;
              buf[16] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 426108;
              buf[17] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -1108;
              buf[18] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 87162;
              buf[19] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -407;
              buf[20] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -53215290;
              buf[21] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -282706;
              buf[22] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 360710219;
              buf[23] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -3325972;
              buf[24] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -25987;
              buf[25] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -144703594;
              buf[26] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 1459617886;
              buf[27] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -1702887505;
              buf[28] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 27263101;
              buf[29] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 1873;
              buf[30] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -1400897595;
              buf[31] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -814;
              buf[32] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -26102;
              buf[33] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -277;
              buf[34] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -10648;
              buf[35] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -6652003;
              buf[36] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -26028;
              buf[37] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -4442;
              buf[38] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -21626982;
              buf[39] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -408;
              buf[40] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -3326044;
              buf[41] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 3751;
              buf[42] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -1261581;
              buf[43] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -3251;
              buf[44] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -13008;
              buf[45] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -4426;
              buf[46] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -82837526;
              buf[47] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = 872415310;
              buf[48] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = -851443826;
              buf[49] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -289406979;
              buf[50] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 110100511;
              buf[51] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -3260;
              buf[52] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -26607641;
              buf[53] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -2261098;
              buf[54] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -633339905;
              buf[55] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 418;
              buf[56] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 426028;
              buf[57] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 958492;
              buf[58] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -1196072;
              buf[59] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -207957;
              buf[60] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -51975;
              buf[61] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 981467165;
              buf[62] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 27000936;
              buf[63] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -6651977;
              buf[64] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = 109052009;
              buf[65] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 239742;
              buf[66] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 13691;
              buf[67] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 416;
              buf[68] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 109052008;
              buf[69] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -282677;
              buf[70] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 14417997;
              buf[71] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -408;
              buf[72] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -13022;
              buf[73] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -141433;
              buf[74] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -2262;
              buf[75] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 213075;
              buf[76] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 6699;
              buf[77] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -578814058;
              buf[78] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 30933098;
              buf[79] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -3250;
              buf[80] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = 26748;
              buf[81] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -1157628020;
              buf[82] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 1882;
              buf[83] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -26607635;
              buf[84] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -6651962;
              buf[85] = (byte) (HSDevTeam >>> 15);
              HSDevTeam = -578814034;
              buf[86] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 482345035;
              buf[87] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -851443732;
              buf[88] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -12995;
              buf[89] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -578814058;
              buf[90] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = 973078622;
              buf[91] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -1702887505;
              buf[92] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 426109;
              buf[93] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = 490733569;
              buf[94] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -557842491;
              buf[95] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -814;
              buf[96] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -3326070;
              buf[97] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -4441;
              buf[98] = (byte) (HSDevTeam >>> 5);
              HSDevTeam = -3391576;
              buf[99] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = -104035;
              buf[100] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -415788;
              buf[101] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -2218;
              buf[102] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -210022;
              buf[103] = (byte) (HSDevTeam >>> 10);
              HSDevTeam = -851443832;
              buf[104] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -26607708;
              buf[105] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 15079;
              buf[106] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -413;
              buf[107] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -851443715;
              buf[108] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -1702887504;
              buf[109] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -144703562;
              buf[110] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -35651606;
              buf[111] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 218103886;
              buf[112] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -1702887538;
              buf[113] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -18087939;
              buf[114] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = 5636127;
              buf[115] = (byte) (HSDevTeam >>> 17);
              HSDevTeam = -13303932;
              buf[116] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -831513;
              buf[117] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -70762;
              buf[118] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 956301311;
              buf[119] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 6698;
              buf[120] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = 208;
              buf[121] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 7667740;
              buf[122] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = -12712;
              buf[123] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -285212757;
              buf[124] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -283;
              buf[125] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 397;
              buf[126] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 60293224;
              buf[127] = (byte) (HSDevTeam >>> 19);
              HSDevTeam = -212861001;
              buf[128] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 29098089;
              buf[129] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 562036862;
              buf[130] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 115;
              buf[131] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = 316;
              buf[132] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = 13544;
              buf[133] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -40108085;
              buf[134] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 1693;
              buf[135] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -612;
              buf[136] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -1501560926;
              buf[137] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = -2921;
              buf[138] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -198694;
              buf[139] = (byte) (HSDevTeam >>> 10);
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
    
    private static String hsgen2(byte[] bArr) {
        char[] charArray = HSTest2(FuckYouMother).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(charArray[(b & 240) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString();
    }

    public static String HSTest2(String str) {
        return new String(Base64.decode(str, Base64.NO_WRAP));
    }
    
    public static String genString2(String str) {
        String var = HSTest2(FuckYouMother);
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