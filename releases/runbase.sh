#!/bin/sh

COMMAND=$1
VERSION=$2
JAR_NAME="bos-server.jar"
STORE_FILE="./runbase.store.txt"

kill_old_jar() {
  if [ -f "$STORE_FILE" ]; then
    OLD_JAR_PID=$(sed -n '1p' $STORE_FILE)
    if [ ! -z $OLD_JAR_PID ]; then
      echo "Killing old jar pid: $OLD_JAR_PID"
      kill $OLD_JAR_PID
    else
      echo "Nothing to kill"
    fi
  fi
}

run_new_jar() {
  echo "Running jar $JAR_NAME"
  nohup java -jar $JAR_NAME >log.txt 2>&1 &
  JAR_PID=$!
  echo "New pid is $JAR_PID"
  echo "Saving pid to $STORE_FILE"
  echo "$JAR_PID" >"$STORE_FILE"
  echo "$JAR_NAME" >>"$STORE_FILE"
}

run_old_jar() {

  OLD_JAR_NAME=$(sed -n '2p' $STORE_FILE)
  echo "Running jar $OLD_JAR_NAME"
  nohup java -jar $OLD_JAR_NAME >log.txt 2>&1 &
  JAR_PID=$!
  echo "New pid is $JAR_PID"
  echo "Saving pid to $STORE_FILE"
  echo "$JAR_PID" >"$STORE_FILE"
  echo "$OLD_JAR_NAME" >>"$STORE_FILE"
}

deploy_new() {

  unzip "./$VERSION.zip"
  echo "./$VERSION.zip"
  kill_old_jar
  rm -r ./public $JAR_NAME
  mv "./$VERSION/"* ./
  run_new_jar

}

case $COMMAND in
run)
  if [ -z $JAR_NAME ]; then
    echo "Usage: ./runbase.sh run FILE"
    exit
  fi
  if [ ! -f $JAR_NAME ]; then
    echo "File not found: $JAR_NAME"
    exit
  fi
  kill_old_jar
  run_new_jar
  ;;
kill)
  kill_old_jar
  echo "" >"$STORE_FILE"

  ;;
restart)
  kill_old_jar
  run_old_jar
  ;;

deploy)
  deploy_new
  ;;
*)
  echo "Usage: ./runbase.sh COMMAND FILE"
  echo "COMMAND should be run or kill"
  exit
  ;;
esac
