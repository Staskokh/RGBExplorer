

package com.skydoves.colorpickerview.benchmark

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import org.junit.Rule
import org.junit.Test

@RequiresApi(Build.VERSION_CODES.P)
class BaselineProfileGenerator {
  @get:Rule
  val baselineProfileRule = BaselineProfileRule()

  @Test
  fun startup() = baselineProfileRule.collect(
    packageName = packageName,
    stableIterations = 2,
    maxIterations = 8,
  ) {
    pressHome()

    startActivityAndWait()
    device.waitForIdle()
  }
}

private const val packageName = "com.skydoves.colorpickerviewdemo"
