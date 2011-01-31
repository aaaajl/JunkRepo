#!/bin/ksh
LOG_FILE="c/tmp/conflicts.log"
echo "----------------------------Change Files----------------------------" > $LOG_FILE
git st|grep "both modified:" >> $LOG_FILE
echo "----------------------------Change Detail----------------------------" >> $LOG_FILE
LIST=`git st|grep "both modified:" |awk '{print $4}'`
for f in $LIST
do
echo "$f " >>$LOG_FILE
echo "Begin:" >>$LOG_FILE
git blame $f|grep "Not Committed Yet" >>$LOG_FILE
echo "End" >>$LOG_FILE
done

more $LOG_FILE