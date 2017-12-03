#!/bin/bash
nginx
java -cp ./:/codefolio/operation/ \
    -Xms4096m -Xmx4096m \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:HeapDumpPath=/platform/operation/ \
    -XX:+UseG1GC \
    -XX:+PrintGCDetails \
    -XX:+PrintGCTimeStamps \
    -Xloggc:./gc-was1.log \
    -XX:+UseGCLogFileRotation \
    -XX:NumberOfGCLogFiles=10 \
    -XX:GCLogFileSize=5M \
    -jar /codefolio/*.jar \
    --server.port=8080 "$@"
