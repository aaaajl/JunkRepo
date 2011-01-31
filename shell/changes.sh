#!/bin/ksh
GREPDATE=$1
REVISION=$2
echo "Date: $GREPDATE ,Revision:$REVISION"
BRANCHNAME=`git br | grep "*" | awk '{print $2}'`
LOG_FILE="c/tmp/$BRANCHNAME-$REVISION-$GREPDATE.log"
echo "Log write to $LOG_FILE"
git svn rebase
echo "----------------------------Change Files----------------------------" > $LOG_FILE
git diff $REVISION --name-only >> $LOG_FILE
echo "----------------------------Change Detail----------------------------" >> $LOG_FILE
LIST=`git diff $REVISION --name-only`
for f in $LIST
do
echo "$f " >>$LOG_FILE
echo "Begin:" >>$LOG_FILE
git blame $f | grep $GREPDATE >>$LOG_FILE
echo "End" >>$LOG_FILE
done

more $LOG_FILE