#!/bin/ksh
BRANCH=$1
CHANGE_FILES=`git st|grep "both modified"|awk '{print $4}'| paste -s -d " "`
git co $BRANCH $CHANGE_FILES