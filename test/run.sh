#!/bin/sh
cd $(dirname $0)

cd ../complete

chmod +x gradlew

./gradlew test --rerun-tasks --stacktrace

ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

exit
