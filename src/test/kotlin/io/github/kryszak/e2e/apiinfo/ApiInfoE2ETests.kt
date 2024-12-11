package io.github.kryszak.e2e.apiinfo

import io.github.kryszak.gwatlin.api.apiinfo.GWApiInfoClient
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder

class ApiInfoE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWApiInfoClient()

    init {
        // FIXME
        expect("Api information fails due to invalid url") {
            shouldThrowAny { client.getAchievementIdsList() }
        }
    }
}