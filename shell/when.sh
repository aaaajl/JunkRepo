#!/bin/ksh
# /usr/local/bin/when
# usage "when 7" to go back 7 days, "when 14" to go back 14, etc.
# useless to go back more than a month
BACK=$1
THEN=(`date +%d` - $BACK)
MONTH=`date +%m`
YEAR=`date +%Y`
if [ $THEN -le "0" ]
then
	MONTH=$((MONTH-1))
	if [ $MONTH -le "9" ]
	then
		MONTH=0$MONTH
	fi
	if [ $MONTH -eq "0" ]
	then
		MONTH=12
		YEAR=$((YEAR-1))
	fi
set `cal $MONTH $YEAR`
SHIFT=$(( $THEN * -1 + 1 ))
shift $(($# - $SHIFT))
THEN=$1 
fi
if [ $THEN -le "9" ]
then
	THEN=0$THEN
fi
echo $YEAR-$MONTH-$THEN