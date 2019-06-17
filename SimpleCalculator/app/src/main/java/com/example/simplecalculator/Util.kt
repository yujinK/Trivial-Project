package com.example.simplecalculator

import android.content.Context
import android.os.Build
import java.text.NumberFormat
import java.util.*

class Util {
    companion object {
        //Number Format with Comma
        @JvmStatic fun setNumberFormat(s: String, context: Context): String {
            var currentLocale: Locale = getCurrentLocales(context)
            var nf: NumberFormat = NumberFormat.getInstance(currentLocale)
            nf.maximumFractionDigits = Integer.MAX_VALUE    //소수점 자리수
            return nf.format(s.toDouble())
        }

        @JvmStatic fun getCurrentLocales(context: Context): Locale {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return context.resources.configuration.locales.get(0)
            } else {
                return context.resources.configuration.locale
            }
        }
    }
}