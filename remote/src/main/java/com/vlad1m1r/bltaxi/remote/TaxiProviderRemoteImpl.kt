package com.vlad1m1r.bltaxi.remote

import com.vlad1m1r.bltaxi.domain.Language
import com.vlad1m1r.bltaxi.domain.model.ItemTaxi

internal class TaxiProviderRemoteImpl(private val taxiService: TaxiService) :
    TaxiProviderRemote {
    override suspend fun getTaxis(language: Language): List<ItemTaxi> =
        taxiService.taxis(language.code).map { it.toItemTaxi() }
}
