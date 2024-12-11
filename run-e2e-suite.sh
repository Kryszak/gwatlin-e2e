#!/bin/zsh

# Achievement endpoints
./gradlew test --tests  io.github.kryszak.e2e.achievement.AchievementE2ETests
#sleep 60

# API info endpoints
./gradlew test --tests io.github.kryszak.e2e.apiinfo.ApiInfoE2ETests