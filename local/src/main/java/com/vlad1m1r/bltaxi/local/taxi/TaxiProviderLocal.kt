package com.vlad1m1r.bltaxi.local.taxi

import com.vlad1m1r.bltaxi.domain.Language
import com.vlad1m1r.bltaxi.domain.model.ItemTaxi

interface TaxiProviderLocal {
    suspend fun getTaxis(language: Language): List<ItemTaxi>
    suspend fun saveTaxis(taxis: List<ItemTaxi>, language: Language)
}
