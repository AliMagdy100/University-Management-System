#!/bin/bash

# Set the limit disk space (in percentage)
limit=40
# Get current timestamp
timestamp=$(date +"%Y-%m-%d %H:%M:%S")
# Check disk space usage
disk_usage=$(df -h / | awk 'NR==2 {print $6}' | tr -d '%' | cut -d'G' -f1)

# Compare with the limit
if [ "$disk_usage" -ge "$limit" ]; then
    # Send alert/notification 
    echo "$timestamp - ALERT: Disk space usage is above $limit%. Please take action to free up space." >> /E/ITI/Projects/CaseStudy/Space_Log.txt
else
    echo "$timestamp - INFO: Disk space usage is within acceptable limits." >> /E/ITI/Projects/CaseStudy/Space_Log.txt
fi
