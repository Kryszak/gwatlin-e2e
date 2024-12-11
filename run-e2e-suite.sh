#!/bin/bash

# Achievement endpoints
./gradlew test --tests  io.github.kryszak.e2e.achievement.AchievementE2ETests
#sleep 60

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