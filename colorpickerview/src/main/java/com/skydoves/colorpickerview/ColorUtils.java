

package com.skydoves.colorpickerview;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import java.util.Locale;

/** ColorUtils a util class for changing the form of colors. */
class ColorUtils {
  /** changes color to string hex code. */
  public static String getHexCode(@ColorInt int color) {
    int a = Color.alpha(color);
    int r = Color.red(color);
    int g = Color.green(color);
    int b = Color.blue(color);
    return String.format(Locale.getDefault(), "%02X%02X%02X%02X", a, r, g, b);
  }

  /** changes color to argb integer array. */
  public static int[] getColorARGB(@ColorInt int color) {
    int[] argb = new int[4];
    argb[0] = Color.alpha(color);
    argb[1] = Color.red(color);
    argb[2] = Color.green(color);
    argb[3] = Color.blue(color);
    return argb;
  }
}
