
package com.skydoves.colorpickerview.listeners;

import com.skydoves.colorpickerview.ColorEnvelope;

/**
 * ColorEnvelopeListener is invoked whenever {@link com.skydoves.colorpickerview.ColorPickerView} is
 * triggered.
 */
public interface ColorEnvelopeListener extends ColorPickerViewListener {
  /**
   * invoked by {@link com.skydoves.colorpickerview.ColorPickerView}.
   *
   * @param envelope {@link ColorEnvelope}
   * @param fromUser triggered by the user(true) or not(false).
   */
  void onColorSelected(ColorEnvelope envelope, boolean fromUser);
}
