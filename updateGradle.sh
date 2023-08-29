#!/bin/bash

if [ -z "$1" ]
  then
    echo "No version supplied"
    exit 1
fi

declare -a StringArray=(
"file-diff-plugin"
"file-diff-task"
"theme-park-api"
"theme-park-manager"
"theme-park-manager-refactored"
"theme-park-rides"
"theme-park-rides-status"
"theme-park-rides-with-zip"
"theme-park-rides-with-zip-fixed"
 )
for directory in ${StringArray[@]}; do
  echo "Updating $directory Gradle version to $1"
  cd $directory > /dev/null
  ./gradlew wrapper -q --gradle-version $1 && ./gradlew -q > /dev/null
  cd - > /dev/null
done
