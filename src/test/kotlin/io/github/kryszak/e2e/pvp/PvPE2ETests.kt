package io.github.kryszak.e2e.pvp

import io.github.kryszak.e2e.BaseE2ESpec
import io.github.kryszak.e2e.randomElements
import io.github.kryszak.gwatlin.api.pvp.GWPvPClient
import io.kotest.assertions.throwables.shouldNotThrowAny

class PvPE2ETests : BaseE2ESpec() {
    private val client = GWPvPClient()

    init {
        context("PvP Unauthenticated") {
            expect("Fetch ranks") {
                val rankIds = client.getPvpRankIds()
                shouldNotThrowAny { client.getPvpRanks(rankIds) }
            }
            expect("Fetch seasons") {
                val seasonIds = client.getPvpSeasonIds().randomElements(10)
                shouldNotThrowAny { client.getPvpSeasons(seasonIds) }
            }
        }
    }
}