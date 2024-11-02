

package com.skydoves.colorpickerview.listeners;

import androidx.annotation.ColorInt;

/**
 * ColorListener is invoked whenever {@link com.skydoves.colorpickerview.ColorPickerView} is
 * triggered.
 */
public interface ColorListener extends ColorPickerViewListener {
  /**
   * invoked by {@link com.skydoves.colorpickerview.ColorPickerView}.
   *
   * @param color the last selected color.
   * @param fromUser triggered by the user(true) or not(false).
   */
  void onColorSelected(@ColorInt int color, boolean fromUser);
}
