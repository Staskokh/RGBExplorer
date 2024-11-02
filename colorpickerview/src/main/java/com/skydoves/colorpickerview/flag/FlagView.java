
package com.skydoves.colorpickerview.flag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.FadeUtils;


@SuppressWarnings("unused")
public abstract class FlagView extends RelativeLayout {

  private FlagMode flagMode = FlagMode.ALWAYS;
  private boolean flipAble = true;

  public FlagView(Context context, int layout) {
    super(context);
    initializeLayout(layout);
  }


  public abstract void onRefresh(ColorEnvelope colorEnvelope);


  public abstract void onFlipped(Boolean isFlipped);

  public void receiveOnTouchEvent(MotionEvent event) {
    switch (event.getActionMasked()) {
      case MotionEvent.ACTION_DOWN:
        if (getFlagMode() == FlagMode.LAST) gone();
        else if (getFlagMode() == FlagMode.FADE) FadeUtils.fadeIn(this);
        break;
      case MotionEvent.ACTION_MOVE:
        if (getFlagMode() == FlagMode.LAST) gone();
        break;
      case MotionEvent.ACTION_UP:
        if (getFlagMode() == FlagMode.LAST) visible();
        else if (getFlagMode() == FlagMode.FADE) FadeUtils.fadeOut(this);
      default:
        visible();
    }
  }

  private void initializeLayout(int layout) {
    View inflated = LayoutInflater.from(getContext()).inflate(layout, this);
    inflated.setLayoutParams(
      new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    inflated.measure(
      MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
      MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
    inflated.layout(0, 0, inflated.getWidth(), inflated.getMeasuredHeight());
  }


  public void visible() {
    setVisibility(View.VISIBLE);
  }


  public void gone() {
    setVisibility(View.GONE);
  }


  public FlagMode getFlagMode() {
    return flagMode;
  }

  public void setFlagMode(FlagMode flagMode) {
    this.flagMode = flagMode;
  }


  public boolean isFlipAble() {
    return flipAble;
  }


  public void setFlipAble(boolean flipAble) {
    this.flipAble = flipAble;
  }
}
