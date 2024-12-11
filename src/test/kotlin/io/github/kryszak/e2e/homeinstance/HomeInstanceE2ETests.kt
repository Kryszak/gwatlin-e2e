package io.github.kryszak.e2e.homeinstance

import io.github.kryszak.gwatlin.api.homeinstance.GWHomeInstanceClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder

class HomeInstanceE2ETests: ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWHomeInstanceClient()

    init {
        context("Home instance") {
            expect("Fetch cats") {
                val catIds = client.getCatIds()
                shouldNotThrowAny { client.getCats(catIds) }
            }
            expect("Fetch nodes") {
                shouldNotThrowAny { client.getNodeIds() }
            }
        }
    }
}