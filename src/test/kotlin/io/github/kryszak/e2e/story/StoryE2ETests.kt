package io.github.kryszak.e2e.story

import io.github.kryszak.gwatlin.api.story.GWBackstoryClient
import io.github.kryszak.gwatlin.api.story.GWStoryClient
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.test.TestCaseOrder

class StoryE2ETests : ExpectSpec() {
    override fun testCaseOrder(): TestCaseOrder = TestCaseOrder.Sequential

    init {
        context("Backstory") {
            val client = GWBackstoryClient()
            expect("Fetch answers") {
                shouldNotThrowAny { client.getBackstoryAnswers() }
            }
            expect("Fetch questions") {
                shouldNotThrowAny { client.getBackstoryQuestions() }
            }
        }
        context("Story") {
            val client = GWStoryClient()
            expect("Fetch stories") {
                shouldNotThrowAny { client.getStories() }
            }
            expect("Fetch seasons") {
                shouldNotThrowAny { client.getStorySeasons() }
            }
        }
    }
}