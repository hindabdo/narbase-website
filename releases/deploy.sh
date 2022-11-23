#!/bin/sh

VERSION=$1

if [ -z "$VERSION" ]; then
  echo "Usage: deploy <version>"
  exit
fi

if [ ! -d "$VERSION" ]; then
  echo "Directory $VERSION does not exist. Exiting."
  exit
fi

echo "Zipping to ./$VERSION.zip"
zip -rq "./$VERSION.zip" "./$VERSION/"
echo "Uploading"
scp -C ./runbase.sh  balsam@balsam.narbase.com:~/bos/
scp -C ./$VERSION.zip  balsam@balsam.narbase.com:~/bos/
#script -c "scp -C ./runbase.sh  balsam@balsam.narbase.com:~/bos/"
#script -c "scp -C ./$VERSION.zip  balsam@balsam.narbase.com:~/bos/"
echo "Running"
ssh balsam@balsam.narbase.com "cd ./bos/ && ./runbase.sh deploy $VERSION"
