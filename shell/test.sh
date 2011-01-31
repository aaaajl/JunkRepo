#!/bin/ksh
GREP_DATE=`date +%Y-%m-%d`
LOG_FILE="changLog$GREP_DATE.log"
revision=` git log --committer=lj04482 -2 | grep commit | awk '{print $2}'` 
echo "----------------------------Change Files----------------------------" > $LOG_FILE
git diff $revision --name-only >> $LOG_FILE
echo "----------------------------Change Detail----------------------------" >> $LOG_FILE
LIST=`git diff $revision --name-only`
for f in $LIST
do
echo "$f Begin:" >>$LOG_FILE
git blame $f|grep $GREP_DATE >>$LOG_FILE
echo "End" >>$LOG_FILE
done

more $LOG_FILE