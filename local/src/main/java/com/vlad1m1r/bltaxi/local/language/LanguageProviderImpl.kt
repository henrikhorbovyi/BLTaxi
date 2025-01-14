package com.vlad1m1r.bltaxi.local.language

import android.content.Context
import android.os.Build
import com.vlad1m1r.bltaxi.domain.Language
import com.vlad1m1r.bltaxi.domain.Language.Companion.fromCode
import java.util.*

internal class LanguageProviderImpl(private val context: Context) : LanguageProvider {

    override fun getLanguage(): Language {
        val defaultLanguage = context.getLocale().language
        return fromCode(defaultLanguage)
    }
}

private fun Context.getLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales.get(0)
    } else {
        resources.configuration.locale
    }
}
