<?php
$PRG=$argv[0];
$DIR=dirname($PRG);
include_once( $DIR.'/utils/DbUtils.php' );
include_once( $DIR.'/queries/notifier_queries.php' );
include_once( $DIR.'/constants/Constants.php' );

define("NOTIFIER_INTERVAL_MIN",5);
define("NOTIFIER_INTERVAL_MAX",15);

//global $insert_new_notifications,
$dbUtil = new DbUtils();
$conn=$dbUtil->getDbConnection();
while(1)
{
	$notifIndex = array_rand($randomMessages,1);
	$notification=$randomMessages[$notifIndex];
	$query=str_replace("#USER_ID",$defaultUserId,$insert_new_notifications);
	$query=str_replace("#FROM_USER_ID",$defaultFromUserId,$query);
	$query=str_replace("#NOTIFICATION",$notification,$query);
	$dbUtil->insertRecords($query,$conn);
	sleep(mt_rand($notifier_interval_min,$notifier_interval_min));
}

$dbUtil->closeConnection($conn);
?>
