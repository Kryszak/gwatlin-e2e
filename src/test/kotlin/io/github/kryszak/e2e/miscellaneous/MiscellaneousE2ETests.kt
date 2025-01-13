package io.github.kryszak.e2e.miscellaneous

import io.github.kryszak.e2e.BaseE2ESpec
import io.github.kryszak.gwatlin.api.miscellaneous.GWMiscellaneousClient
import io.kotest.assertions.throwables.shouldNotThrowAny

class MiscellaneousE2ETests : BaseE2ESpec() {
    private val client = GWMiscellaneousClient()

    init {
        context("Miscellaneous") {
            expect("Fetch build id") {
                shouldNotThrowAny { client.getBuildId() }
            }
            expect("Fetch icons") {
                shouldNotThrowAny { client.getIcons() }
            }
            expect("Fetch quaggans") {
                shouldNotThrowAny { client.getQuaggans() }
            }
            expect("Fetch dye colors") {
                shouldNotThrowAny { client.getDyeColors() }
            }
            expect("Fetch currencies") {
                shouldNotThrowAny { client.getCurrencies() }
            }
            expect("Fetch dungeons") {
                shouldNotThrowAny { client.getDungeons() }
            }
            expect("Fetch minis") {
                shouldNotThrowAny { client.getMinis() }
            }
            expect("Fetch novelties") {
                shouldNotThrowAny { client.getNovelties() }
            }
            expect("Fetch raids") {
                shouldNotThrowAny { client.getRaids() }
            }
            expect("Fetch titles") {
                shouldNotThrowAny { client.getTitles() }
            }
            expect("Fetch worlds") {
                shouldNotThrowAny { client.getWorlds() }
            }
        }
    }
}