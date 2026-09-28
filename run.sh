#!/usr/bin/env bash
# Practical Runner Script for SRM-IST Java Full Stack Calculator

# 1. Check if JAVA_HOME is set; if not, look for installed JDK or scratch JDK
if [ -z "$JAVA_HOME" ]; then
    if [ -d "/Users/ompandat/.gemini/antigravity/brain/d4c9a46b-a45c-4b32-8707-e6d313102acb/scratch/tools/jdk-17.0.20.1+1/Contents/Home" ]; then
        export JAVA_HOME="/Users/ompandat/.gemini/antigravity/brain/d4c9a46b-a45c-4b32-8707-e6d313102acb/scratch/tools/jdk-17.0.20.1+1/Contents/Home"
        export PATH="$JAVA_HOME/bin:/Users/ompandat/.gemini/antigravity/brain/d4c9a46b-a45c-4b32-8707-e6d313102acb/scratch/tools/apache-maven-3.9.6/bin:$PATH"
    fi
fi

echo "=========================================================="
echo " Running SRM-IST Calculator (Maven Project)"
echo " Java version: $(java -version 2>&1 | head -n 1)"
echo "=========================================================="

# Build if jar does not exist
if [ ! -f "target/calculator-executable-jar-1.0-SNAPSHOT.jar" ]; then
    echo "Building project with Maven..."
    mvn clean package -Dmaven.repo.local="/Users/ompandat/.gemini/antigravity/brain/d4c9a46b-a45c-4b32-8707-e6d313102acb/scratch/m2_repo"
fi

echo "Launching application..."
java -jar target/calculator-executable-jar-1.0-SNAPSHOT.jar
