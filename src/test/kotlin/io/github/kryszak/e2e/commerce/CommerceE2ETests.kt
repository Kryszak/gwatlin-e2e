package io.github.kryszak.e2e.commerce

import io.github.kryszak.gwatlin.api.commerce.GWCommerceClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder
import io.melements.integrator.io.github.kryszak.e2e.randomElements

class CommerceE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWCommerceClient()

    init {
        context("Commerce") {
            expect("Should fetch random prices") {
                val priceIds = client.getPriceIds().randomElements(100)
                shouldNotThrowAny {
                    client.getPrices(priceIds)
                }
            }
            expect("Should fetch random listings") {
                val listingIds = client.getCommerceListingsIds().randomElements(100)
                shouldNotThrowAny {
                    client.getCommerceListings(listingIds)
                }
            }
            expect("Should fetch coin to gem exchange") {
                shouldNotThrowAny {
                    client.getCoinToGemExchange(100000)
                }
            }
            expect("Should fetch gem to coin exchange") {
                shouldNotThrowAny {
                    client.getGemToCoinExchange(1000)
                }
            }
        }
    }
}