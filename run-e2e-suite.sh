#!/bin/bash

set -euo pipefail

# In case of hitting rate limit errors split running tests
# per test class and add 1 minute delay between runs
# https://wiki.guildwars2.com/wiki/API:Best_practices#Rate_Limit
./gradlew test
