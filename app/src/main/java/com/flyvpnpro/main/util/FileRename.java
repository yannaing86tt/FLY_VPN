package com.flyvpnpro.main.util;

import android.content.*;
import android.content.pm.*;
import android.util.*;
import java.io.*;
import java.security.*;
import java.security.cert.*;

import android.content.pm.Signature;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;


public class FileRename {
    private Context context;
    private String cer = null;
    private String realCer = null;
    private static final String TAG = "SignCheck";
    private List<String> signatures = Arrays.asList();
    public FileRename(Context context) {
        this.context = context;
        this.cer = getCertificateSHA1Fingerprint();
    }

    public FileRename(Context context, String realCer) {
        this.context = context;
        this.realCer = realCer;
        this.cer = getCertificateSHA1Fingerprint();
    }

    public String getRealCer() {
        return realCer;
    }


    public void setRealCer(String realCer) {
        this.realCer = realCer;
    }


    public String getCertificateSHA1Fingerprint() {

        PackageManager pm = context.getPackageManager();


        String packageName = context.getPackageName();


        int flags = PackageManager.GET_SIGNATURES;

        PackageInfo packageInfo = null;

        try {

            packageInfo = pm.getPackageInfo(packageName, flags);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();


        InputStream input = new ByteArrayInputStream(cert);


        CertificateFactory cf = null;

        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (Exception e) {
            e.printStackTrace();
        }


        X509Certificate c = null;

        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String hexString = null;

        try {

            MessageDigest md = MessageDigest.getInstance("SHA1");


            byte[] publicKey = md.digest(c.getEncoded());


            hexString = byte2HexFormatted(publicKey);

        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        }
        return hexString;
    }

    @NonNull
    public static String[] getSignatures(@NonNull Context context) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);

        if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
            return new String[]{};
        }

        String[] md5Signatures = new String[packageInfo.signatures.length];

        for (int i = 0; i < packageInfo.signatures.length; i++) {
            Signature signature = packageInfo.signatures[i];
            if (signature == null) continue;

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(signature.toByteArray());
            byte[] digits = md.digest();

            char[] hexArray = "0123456789ABCDEF".toCharArray();
            String md5String = "";
            for (byte digit : digits) {
                int pos = digit & 0xFF;
                md5String += "" + hexArray[pos >> 4] + hexArray[pos & 0x0f] + ":";
            }
            if (md5String.length() > 0) {
                md5String = md5String.substring(0, md5String.length() - 1);
            }

            md5Signatures[i] = md5String;
        }


        return md5Signatures;
    }



    public void setAcceptedSignatures(String... signatures) {
        this.signatures = Arrays.asList(signatures);
    }


    public boolean validateAll() {
        try {
            validateAllOrThrowException();
            return true;
        } catch (ValidationException exception) {
            return false;
        }
    }


    public void validateAllOrThrowException() throws ValidationException {  
        validateSignature();


    }


    private void validateSignature() throws ValidationException {
        if (signatures == null || signatures.size() <= 0)
            return;
        try {
            String[] md5Signatures = getSignatures(context);

            if (md5Signatures == null || md5Signatures.length <= 0) {
                throw new ValidationException(ValidationException.ERROR_CODE_SIGNATURE_IS_EMPTY, "No signatures found.");
            }

            for (String md5Signature : md5Signatures) {
                for (String allowedSignature : signatures) {
                    if (md5Signature.equalsIgnoreCase(allowedSignature))
                        return;// validation success
                }
            }
            throw new ValidationException(ValidationException.ERROR_CODE_SIGNATURE_NOT_VALID, "Not valid signature: CurrentSignatures=" + md5Signatures + ";  validSignatures=" + signatures.toString() + ";");
        } catch (PackageManager.NameNotFoundException exception) {
            throw new ValidationException(ValidationException.ERROR_CODE_SIGNATURE_UNKNOWN_EXCEPTION, "Exception on signature validation.", exception);
        } catch (NoSuchAlgorithmException exception) {
            throw new ValidationException(ValidationException.ERROR_CODE_SIGNATURE_UNKNOWN_EXCEPTION, "Exception on signature validation.", exception);
        }

    }


    public static final class ValidationException extends Exception {
        public static final int ERROR_CODE_UNKNOWN_EXCEPTION = 1;
        public static final int ERROR_CODE_DEBUG_MODE = 2;
        public static final int ERROR_CODE_RUN_ON_EMULATOR = 3;
        public static final int ERROR_CODE_PACKAGE_NAME_IS_EMPTY = 4;
        public static final int ERROR_CODE_PACKAGE_NAME_NOT_VALID = 5;
        public static final int ERROR_CODE_STORE_IS_EMPTY = 6;
        public static final int ERROR_CODE_STORE_NOT_VALID = 7;
        public static final int ERROR_CODE_SIGNATURE_IS_EMPTY = 8;
        public static final int ERROR_CODE_SIGNATURE_MULTIPLE = 9;
        public static final int ERROR_CODE_SIGNATURE_NOT_VALID = 10;
        public static final int ERROR_CODE_SIGNATURE_UNKNOWN_EXCEPTION = 11;
        public static final int ERROR_CODE_CRC_NOT_VALID = 12;
        public static final int ERROR_CODE_CRC_UNKNOWN_EXCEPTION = 13;
        private final int code;

        public ValidationException(int code, String message) {
            super(message);
            this.code = code;
        }

        public ValidationException(int code, String message, Throwable cause) {
            super(message, cause);
            this.code = code;
        }


        public int getErrorCode() {
            return code;
        }
    }

    private String byte2HexFormatted(byte[] arr) {

        StringBuilder str = new StringBuilder(arr.length * 2);

        for (int i = 0; i <arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l =h.length();
            if (l == 1)
                h = "0" + h;
            if (l > 2)
                h = h.substring(l - 2, l);
            str.append(h.toUpperCase());
            if (i < (arr.length - 1))
                str.append(':');
        }
        return str.toString();
    }


    public boolean check() {

        if (this.realCer != null) {
            cer = cer.trim();
            realCer = realCer.trim();
            if (this.cer.equals(this.realCer)) {
                return true;
            }
        }else {
            Log.e(TAG, "FlyCheck");
        }
        return false;
    }
}

