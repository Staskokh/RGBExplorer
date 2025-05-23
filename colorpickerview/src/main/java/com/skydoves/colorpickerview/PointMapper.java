

package com.skydoves.colorpickerview;

import android.graphics.Color;
import android.graphics.Point;

class PointMapper {
  private PointMapper() {}

  protected static Point getColorPoint(ColorPickerView colorPickerView, Point point) {
    Point center =
        new Point(colorPickerView.getWidth() / 2, colorPickerView.getMeasuredHeight() / 2);
    if (colorPickerView.isHuePalette()) return getHuePoint(colorPickerView, point);
    return approximatedPoint(colorPickerView, point, center);
  }

  private static Point approximatedPoint(ColorPickerView colorPickerView, Point start, Point end) {
    if (getDistance(start, end) <= 3) return end;
    Point center = getCenterPoint(start, end);
    int color = colorPickerView.getColorFromBitmap(center.x, center.y);
    if (color == Color.TRANSPARENT) {
      return approximatedPoint(colorPickerView, center, end);
    } else {
      return approximatedPoint(colorPickerView, start, center);
    }
  }

  private static Point getHuePoint(ColorPickerView colorPickerView, Point point) {
    float centerX = colorPickerView.getWidth() * 0.5f;
    float centerY = colorPickerView.getHeight() * 0.5f;
    float x = point.x - centerX;
    float y = point.y - centerY;
    float radius = Math.min(centerX, centerY);
    double r = Math.sqrt(x * x + y * y);
    if (r > radius) {
      x *= radius / r;
      y *= radius / r;
    }
    return new Point((int) (x + centerX), (int) (y + centerY));
  }

  private static Point getCenterPoint(Point start, Point end) {
    return new Point((end.x + start.x) / 2, (end.y + start.y) / 2);
  }

  private static int getDistance(Point start, Point end) {
    return (int)
        Math.sqrt(
            Math.abs(end.x - start.x) * Math.abs(end.x - start.x)
                + Math.abs(end.y - start.y) * Math.abs(end.y - start.y));
  }
}
