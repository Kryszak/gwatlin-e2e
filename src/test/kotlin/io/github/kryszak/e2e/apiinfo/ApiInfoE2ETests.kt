package io.github.kryszak.e2e.apiinfo

import io.github.kryszak.e2e.BaseE2ESpec
import io.github.kryszak.gwatlin.api.apiinfo.GWApiInfoClient
import io.kotest.assertions.throwables.shouldNotThrowAny

class ApiInfoE2ETests : BaseE2ESpec() {
    private val client = GWApiInfoClient()

    init {
        expect("Api information is fetched") {
            shouldNotThrowAny { client.getSchemaVersions() }
        }
    }
}