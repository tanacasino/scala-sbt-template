#!/usr/bin/env bash

sbt clean update scalafmtCheckAll scalafmtSbtCheck compile test:compile coverage test coverageReport

