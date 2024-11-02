
package com.skydoves.colorpickerview.flag;

import android.content.Context;
import android.content.res.ColorStateList;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.R;

public class BubbleFlag extends FlagView {

  private final AppCompatImageView bubble;

  public BubbleFlag(Context context) {
    super(context, R.layout.colorpickerview_flag_bubble);
    this.bubble = findViewById(R.id.bubble);
  }


  @Override
  public void onRefresh(ColorEnvelope colorEnvelope) {
    ImageViewCompat.setImageTintList(bubble, ColorStateList.valueOf(colorEnvelope.getColor()));
  }

  @Override
  public void onFlipped(Boolean isFlipped) {
  }
}
