package io.github.kryszak.e2e.gamemechanics

import io.github.kryszak.e2e.BaseE2ESpec
import io.github.kryszak.e2e.randomElements
import io.github.kryszak.gwatlin.api.ApiLanguage
import io.github.kryszak.gwatlin.api.gamemechanics.*
import io.kotest.assertions.throwables.shouldNotThrowAny

class GameMechanicsE2ETests : BaseE2ESpec() {
    init {
        context("Legends") {
            val client = GWLegendsClient()
            expect("Fetching legends list") {
                val legendIds = client.getLegendIds()
                shouldNotThrowAny {
                    client.getLegends(legendIds)
                }
            }
        }
        context("Masteries") {
            val client = GWMasteriesClient()
            expect("Fetching random masteries") {
                val masteryIds = client.getMasteriesIds()
                shouldNotThrowAny {
                    client.getMasteries(masteryIds)
                }
            }
            expect("Fetching all masteries in german language") {
                shouldNotThrowAny { client.getAllMasteries(ApiLanguage.DE) }
            }
        }
        context("Mounts") {
            val client = GWMountsClient()
            expect("Fetching all mount types") {
                shouldNotThrowAny { client.getAllMountTypes() }
            }
            expect("Fetching all mount skins") {
                shouldNotThrowAny { client.getAllMountSkins() }
            }
        }
        context("Outfits") {
            val client = GWOutfitsClient()
            expect("Fetching random outfits") {
                val outfitIds = client.getOutfitsIds().randomElements(100)
                shouldNotThrowAny { client.getOutfits(outfitIds) }
            }
        }
        context("Pets") {
            val client = GWPetsClient()
            expect("Fetching pets") {
                shouldNotThrowAny { client.getAllPets() }
            }
        }
        context("Professions") {
            val client = GWProfessionsClient()
            expect("Fetching professions") {
                shouldNotThrowAny { client.getAllProfessions() }
            }
        }
        context("Races") {
            val client = GWRacesClient()
            expect("Fetching races") {
                val raceIds = client.getRaceIds()
                shouldNotThrowAny { client.getRaces(raceIds) }
            }
        }
        context("Skills") {
            val client = GWSkillsClient()
            expect("Fetching random skills") {
                val skillIds = client.getSkillIds().randomElements(100)
                shouldNotThrowAny { client.getSkills(skillIds) }
            }
        }
        context("Specializations") {
            val client = GWSpecializationClient()
            expect("Fetching specializations") {
                val specializationIds = client.getSpecializationIds()
                shouldNotThrowAny { client.getSpecializations(specializationIds) }
            }
        }
        context("Traits") {
            val client = GWTraitsClient()
            expect("Fetching random traits") {
                val traitIds = client.getTraitIds().randomElements(100)
                shouldNotThrowAny { client.getTraits(traitIds) }
            }
        }
    }
}