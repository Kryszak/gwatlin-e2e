package io.github.kryszak.e2e.mapinfo

import io.github.kryszak.gwatlin.api.mapinfo.GWMapInfoClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder
import io.github.kryszak.e2e.randomElements

class MapInfoE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWMapInfoClient()

    init {
        context("Map info") {
            expect("Fetch random maps") {
                val mapInfoIds = client.getMapIds().randomElements(100)
                shouldNotThrowAny { client.getMaps(mapInfoIds) }
            }
            expect("Fetch continents") {
                val continentId = client.getContinentIds().random()
                shouldNotThrowAny { client.getContinent(continentId) }
            }
            expect("Fetch region") {
                val continentId = client.getContinentIds().random()
                val floorId = client.getFloorIds(continentId).random()
                val regionId = client.getRegionIds(continentId, floorId).random()
                shouldNotThrowAny { client.getRegion(continentId, floorId, regionId) }
            }
            context("Map details") {
                val continentId = client.getContinentIds().random()
                val floorId = client.getFloorIds(continentId).random()
                val regionId = client.getRegionIds(continentId, floorId).random()
                val mapId = client.getMaps(continentId, floorId, regionId).random()
                expect("Fetch POI") {
                    shouldNotThrowAny { client.getPointsOfInterestIds(continentId, floorId, regionId, mapId) }
                }
                expect("Fetch task") {
                    shouldNotThrowAny { client.getTaskIds(continentId, floorId, regionId, mapId) }
                }
            }
        }
    }
}