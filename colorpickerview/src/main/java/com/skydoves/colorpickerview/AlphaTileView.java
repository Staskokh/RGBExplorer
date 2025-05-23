

package com.skydoves.colorpickerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.skydoves.colorpickerview.sliders.AlphaTileDrawable;

/** AlphaTileView visualizes ARGB color on the canvas using {@link AlphaTileDrawable}. */
@SuppressWarnings("unused")
public class AlphaTileView extends View {

  private Paint colorPaint;
  private Bitmap backgroundBitmap;
  private final AlphaTileDrawable.Builder builder = new AlphaTileDrawable.Builder();

  public AlphaTileView(Context context) {
    super(context);
    onCreate();
  }

  public AlphaTileView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    onCreate();
    getAttrs(attrs);
  }

  public AlphaTileView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    onCreate();
    getAttrs(attrs);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public AlphaTileView(
      Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    onCreate();
    getAttrs(attrs);
  }

  private void onCreate() {
    this.colorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    this.setBackgroundColor(Color.WHITE);
  }

  private void getAttrs(AttributeSet attrs) {
    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.AlphaTileView);
    try {
      if (a.hasValue(R.styleable.AlphaTileView_tileSize)) {
        builder.setTileSize(a.getInt(R.styleable.AlphaTileView_tileSize, builder.getTileSize()));
      }
      if (a.hasValue(R.styleable.AlphaTileView_tileOddColor)) {
        builder.setTileOddColor(
            a.getInt(R.styleable.AlphaTileView_tileOddColor, builder.getTileOddColor()));
      }
      if (a.hasValue(R.styleable.AlphaTileView_tileEvenColor)) {
        builder.setTileEvenColor(
            a.getInt(R.styleable.AlphaTileView_tileEvenColor, builder.getTileEvenColor()));
      }
    } finally {
      a.recycle();
    }
  }

  @Override
  protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
    super.onSizeChanged(width, height, oldWidth, oldHeight);
    AlphaTileDrawable drawable = builder.build();
    backgroundBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    if (backgroundBitmap != null && !backgroundBitmap.isRecycled()) {
      Canvas backgroundCanvas = new Canvas(backgroundBitmap);
      drawable.setBounds(0, 0, backgroundCanvas.getWidth(), backgroundCanvas.getHeight());
      drawable.draw(backgroundCanvas);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawBitmap(backgroundBitmap, 0, 0, null);
    canvas.drawRect(0, 0, getWidth(), getMeasuredHeight(), colorPaint);
  }

  public void setPaintColor(int color) {
    colorPaint.setColor(color);
    invalidate();
  }

  @Override
  public void setBackgroundColor(int color) {
    setPaintColor(color);
  }
}
