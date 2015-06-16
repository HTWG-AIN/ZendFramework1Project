#!/bin/sh
for s in notenspiegel.c liste.c fachnote.c ; do
    compile_command="gcc -g -W -Wall -ansi -pedantic  -c $s"
    echo $compile_command
    eval $compile_command
    if [ $? -ne 0 ] ; then
        echo build failed
        exit 1
    fi
done
static_command="ar rs libaufgabe5.a fachnote.o liste.o"
echo $static_command
eval $static_command
if [ $? -ne 0 ] ; then
    echo build failed
    exit 1
fi

st_command="gcc  notenspiegel.o libaufgabe5.a -o notenspiegel"
echo $st_command
eval $st_command
if [ $? -ne 0 ] ; then
    echo build failed
    exit 1
fi

echo build successful
