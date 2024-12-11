#!/bin/bash

set -euo pipefail

# Achievement endpoints
./gradlew test --tests  io.github.kryszak.e2e.achievement.AchievementE2ETests

# API info endpoints
./gradlew test --tests io.github.kryszak.e2e.apiinfo.ApiInfoE2ETests

# Commerce endpoints
./gradlew test --tests io.github.kryszak.e2e.commerce.CommerceE2ETests

# Daily rewards endpoints
./gradlew test --tests io.github.kryszak.e2e.dailyrewards.DailyRewardsE2ETests

# Game mechanics endpoints
./gradlew test --tests io.github.kryszak.e2e.gamemechanics.GameMechanicsE2ETests

# Guild public endpoints
./gradlew test --tests io.github.kryszak.e2e.guild.GuildE2ETests

# Home instance endpoints
./gradlew test --tests io.github.kryszak.e2e.homeinstance.HomeInstanceE2ETests

# Item endpoints
./gradlew test --tests io.github.kryszak.e2e.items.ItemsE2ETests

# Map info endpoints
./gradlew test --tests io.github.kryszak.e2e.mapinfo.MapInfoE2ETests

# Miscellaneous endpoints
./gradlew test --tests io.github.kryszak.e2e.miscellaneous.MiscellaneousE2ETests

# Miscellaneous endpoints
./gradlew test --tests io.github.kryszak.e2e.pvp.PvPE2ETests

# Story endpoints
./gradlew test --tests io.github.kryszak.e2e.story.StoryE2ETests