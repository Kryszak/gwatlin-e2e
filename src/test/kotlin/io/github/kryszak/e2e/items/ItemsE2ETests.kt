package io.github.kryszak.e2e.items

import io.github.kryszak.gwatlin.api.items.*
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder
import io.melements.integrator.io.github.kryszak.e2e.randomElements

class ItemsE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    init {
        context("Finishers") {
            val client = GWFinishersClient()
            expect("Fetch finishers") {
                val finisherIds = client.getFinisherIds()
                shouldNotThrowAny { client.getFinishers(finisherIds) }
            }
        }
        context("Item stats") {
            val client = GWItemStatsClient()
            expect("Fetch item stats") {
                val itemStatIds = client.getItemStatsIds().randomElements(100)
                shouldNotThrowAny { client.getItemStats(itemStatIds) }
            }
        }
        context("Items") {
            val client = GWItemsClient()
            expect("Fetch random items") {
                val itemIds = client.getItemIds().randomElements(100)
                shouldNotThrowAny { client.getItems(itemIds) }
            }
        }
        context("Materials") {
            val client = GWMaterialsClient()
            expect("Fetch materials") {
                val materialIds = client.getMaterialIds()
                shouldNotThrowAny { client.getMaterials(materialIds) }
            }
        }
        context("Pvp Amulets") {
            val client = GWPvpAmuletsClient()
            expect("Fetch pvp amulets") {
                val pvpAmuletIds = client.getPvpAmuletIds()
                shouldNotThrowAny { client.getPvpAmulets(pvpAmuletIds) }
            }
        }
        context("Recipes") {
            val client = GWRecipesClient()
            expect("Fetch recipes") {
                val recipeIds = client.getRecipeIds().randomElements(100)
                shouldNotThrowAny { client.getRecipes(recipeIds) }
            }
        }
        context("Skins") {
            val client = GWSkinsClient()
            expect("Fetch skins") {
                val skinIds = client.getSkinIds().randomElements(100)
                shouldNotThrowAny { client.getSkins(skinIds) }
            }
        }
    }
}