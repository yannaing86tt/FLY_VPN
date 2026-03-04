package com.sdsmdg.tastytoast;

import android.content.Context;
import android.widget.Toast;

/**
 * Local fallback shim for missing tastytoast dependency.
 */
public final class TastyToast {
  public static final int SUCCESS = 1;
  public static final int WARNING = 2;
  public static final int ERROR = 3;
  public static final int INFO = 4;
  public static final int DEFAULT = 5;
  public static final int CONFUSING = 6;

  public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
  public static final int LENGTH_LONG = Toast.LENGTH_LONG;

  private TastyToast() {}

  public static Toast makeText(Context context, CharSequence text, int duration, int type) {
    // Keep behavior simple: regular Android toast.
    return Toast.makeText(context, text, duration);
  }
}
