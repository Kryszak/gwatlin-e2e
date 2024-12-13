package io.github.kryszak.e2e.pvp

import io.github.kryszak.gwatlin.api.pvp.GWPvPClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder
import io.github.kryszak.e2e.randomElements

class PvPE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

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