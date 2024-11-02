
package com.skydoves.colorpickerviewdemo;

import android.content.Context;
import android.widget.TextView;

import com.skydoves.colorpickerview.AlphaTileView;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.flag.FlagView;

public class CustomFlagView extends FlagView {

  private TextView textView;
  private AlphaTileView alphaTileView;

  public CustomFlagView(Context context, int layout) {
    super(context, layout);
    textView = findViewById(R.id.flag_color_code);
    alphaTileView = findViewById(R.id.flag_color_layout);
  }

  @Override
  public void onRefresh(ColorEnvelope colorEnvelope) {
    textView.setText("#" + colorEnvelope.getHexCode());
    alphaTileView.setPaintColor(colorEnvelope.getColor());
  }

  @Override
  public void onFlipped(Boolean isFlipped) {
    if (isFlipped) {
      textView.setRotation(180f);
    } else {
      textView.setRotation(0f);
    }
  }
}
