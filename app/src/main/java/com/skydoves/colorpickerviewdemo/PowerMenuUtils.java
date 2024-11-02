

package com.skydoves.colorpickerviewdemo;

import android.content.Context;
import android.graphics.Color;
import androidx.lifecycle.LifecycleOwner;
import com.skydoves.powermenu.CircularEffect;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

public class PowerMenuUtils {
  public static PowerMenu getPowerMenu(
      Context context,
      LifecycleOwner lifecycleOwner,
      OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener) {
    return new PowerMenu.Builder(context)
        .setHeaderView(R.layout.layout_header)
        .addItem(new PowerMenuItem("Палитра", false))
        .addItem(new PowerMenuItem("Палитра(Галерея)", false))
        .addItem(new PowerMenuItem("Указатель", false))
        .addItem(new PowerMenuItem("Диалоговой выбор цвета", false))
        .setLifecycleOwner(lifecycleOwner)
        .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT)
        .setCircularEffect(CircularEffect.BODY)
        .setMenuRadius(10f)
        .setMenuShadow(10f)
        .setTextColor(context.getResources().getColor(R.color.md_grey_800))
        .setSelectedEffect(false)
        .setShowBackground(false)
        .setMenuColor(Color.WHITE)
        .setOnMenuItemClickListener(onMenuItemClickListener)
        .build();
  }
}
