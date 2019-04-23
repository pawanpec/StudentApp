
.DEFAULT_GOAL := build

SHELL := /bin/bash

# load ENV vars from .env.local if it exists
ifneq ("$(wildcard .env.local)","")
include .env.local
export $(shell sed 's/=.*//' .env.local)
endif

SKIP_TESTS := -Dmaven.test.skip=true -DskipTests=true
SPRING_PROFILE := dev
JAVA_OPTS ?=

clean:
	./mvnw clean

build:
	./mvnw $(SKIP_TESTS) install

test:
	./mvnw test

run:
	./mvnw $(JAVA_OPTS) -Dspring-boot.run.profiles=$(SPRING_PROFILE) spring-boot:run

spring: run

# it's all a dream
# egrep ':$' Makefile | tr -d : | tr '\n' ' '
.PHONY: clean build test run

