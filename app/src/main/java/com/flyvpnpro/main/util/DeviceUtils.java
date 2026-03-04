package com.flyvpnpro.main.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.*;

public class DeviceUtils {

  public Boolean isDeviceRooted(Context context) {
    boolean isRooted =
        isrooted1() || isrooted2() || isrooted4() || isrooted3() || isroot5() || isroot6();
    return isRooted;
  }

  private boolean isrooted1() {

    File file = new File("/system/app/Superuser.apk");
    if (file.exists()) {
      return true;
    }
    return false;
  }

  // try executing commands
  private boolean isrooted2() {
    String[] paths = {
      "/system/app/Superuser.apk",
      "/sbin/su",
      "/system/bin/su",
      "/system/xbin/su",
      "/data/local/xbin/su",
      "/data/local/bin/su",
      "/system/sd/xbin/su",
      "/system/bin/failsafe/su",
      "/data/local/su",
      "/su/bin/su"
    };
    for (String path : paths) {
      if (new File(path).exists()) return true;
    }
    return false;
  }

  private boolean isrooted3() {
    Process process = null;
    try {
      process = Runtime.getRuntime().exec(new String[] {"/system/xbin/which", "su"});
      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
      if (in.readLine() != null) return true;
      return false;
    } catch (Throwable t) {
      return false;
    } finally {
      if (process != null) process.destroy();
    }
  }

  private boolean isrooted4() {
    String buildTags = android.os.Build.TAGS;
    return buildTags != null && buildTags.contains("test-keys");
  }

  public boolean isRootAvailable() {
    for (String pathDir : System.getenv("PATH").split(":")) {
      if (new File(pathDir, "su").exists()) {
        return true;
      }
    }
    return false;
  }

  public boolean isroot5() {
    if (isRootAvailable()) {
      Process process = null;
      try {
        process = Runtime.getRuntime().exec(new String[] {"su", "-c", "id"});
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String output = in.readLine();
        if (output != null && output.toLowerCase().contains("uid=0")) return true;
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (process != null) process.destroy();
      }
    }

    return false;
  }

  public boolean isroot6() {

    String buildTags = android.os.Build.TAGS;

    if (buildTags != null && buildTags.contains("test-keys")) {

      return true;
    }

    return false;
  }
}
