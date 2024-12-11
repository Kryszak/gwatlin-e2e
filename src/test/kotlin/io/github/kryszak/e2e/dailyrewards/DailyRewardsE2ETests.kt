package io.github.kryszak.e2e.dailyrewards

import io.github.kryszak.gwatlin.api.dailyrewards.GWDailyRewardsClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder

class DailyRewardsE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWDailyRewardsClient()

    init {
        context("Daily rewards") {
            expect("Daily crafting recipes id fetch") {
                shouldNotThrowAny { client.getDailyCraftingRecipesIds() }
            }
            expect("Daily map chest id fetch") {
                shouldNotThrowAny { client.getMapChestsIds() }
            }
            expect("Daily bosses id fetch") {
                shouldNotThrowAny { client.getWorldBossesIds() }
            }
        }
    }
}