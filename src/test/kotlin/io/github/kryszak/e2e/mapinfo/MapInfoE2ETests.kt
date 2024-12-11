package io.github.kryszak.e2e.mapinfo

import io.github.kryszak.gwatlin.api.mapinfo.GWMapInfoClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder
import io.melements.integrator.io.github.kryszak.e2e.randomElements

class MapInfoE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWMapInfoClient()

    init {
        context("Map info") {
            // FIXME
            expect("Fetch random maps") {
                val mapInfoIds = client.getMaps().randomElements(100)
                shouldThrowAny { client.getMaps(mapInfoIds) }
            }
            expect("Fetch continents") {
                val continentId = client.getContinents().random()
                shouldNotThrowAny { client.getContinent(continentId) }
            }
            expect("Fetch region") {
                val continentId = client.getContinents().random()
                val floorId = client.getFloors(continentId).random()
                val regionId = client.getRegions(continentId, floorId).random()
                shouldNotThrowAny { client.getRegion(continentId, floorId, regionId) }
            }
            context("Map details") {
                val continentId = client.getContinents().random()
                val floorId = client.getFloors(continentId).random()
                val regionId = client.getRegions(continentId, floorId).random()
                val mapId = client.getMaps(continentId, floorId, regionId).random()
                expect("Fetch POI") {
                    shouldNotThrowAny { client.getPointsOfInterest(continentId, floorId, regionId, mapId) }
                }
                expect("Fetch task") {
                    shouldNotThrowAny { client.getTasks(continentId, floorId, regionId, mapId) }
                }
            }
        }
    }
}