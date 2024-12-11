package io.github.kryszak.e2e.achievement

import io.github.kryszak.gwatlin.api.achievement.GWAchievementsClient
import io.github.kryszak.gwatlin.api.exception.ApiRequestException
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder
import io.kotest.matchers.string.shouldContain
import io.melements.integrator.io.github.kryszak.e2e.randomElements

class AchievementE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    private val client = GWAchievementsClient()

    init {
        context("Achievements") {
            expect("Random achievements are fetched correctly") {
                val achievementIds = client.getAchievementIdsList().randomElements(100)
                shouldNotThrowAny {
                    client.getAchievementsByIds(achievementIds)
                }
            }
            // FIX ME
            expect("Daily achievements returns api not active") {
                val dailyAchievementException =
                    shouldThrowExactly<ApiRequestException> { client.getDailyAchievements() }
                dailyAchievementException.message shouldContain "API not active"
                val tomorrowDailyAchievementException =
                    shouldThrowExactly<ApiRequestException> { client.getDailyTomorrowAchievements() }
                tomorrowDailyAchievementException.message shouldContain "API not active"
            }
            expect("Achievement category is fetched correctly") {
                val categoryIds = client.getAchievementCategoryIds()
                shouldNotThrowAny {
                    client.getAchievementCategory(categoryIds.random())
                }
            }
            expect("Achievement group is fetched correctly") {
                val groupIds = client.getAchievementGroupIds()
                shouldNotThrowAny {
                    client.getAchievementGroup(groupIds.random())
                }
            }
        }
    }
}
