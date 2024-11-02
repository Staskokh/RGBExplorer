

package com.skydoves.colorpickerview;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.RestrictTo;

@RestrictTo(LIBRARY_GROUP)
public class FadeUtils {

  public static void fadeIn(View view) {
    Animation fadeIn =
        AnimationUtils.loadAnimation(view.getContext(), R.anim.colorpickerview_fade_in);
    fadeIn.setFillAfter(true);
    view.startAnimation(fadeIn);
  }

  public static void fadeOut(View view) {
    Animation fadeOut =
        AnimationUtils.loadAnimation(view.getContext(), R.anim.colorpickerview_fade_out);
    fadeOut.setFillAfter(true);
    view.startAnimation(fadeOut);
  }
}
