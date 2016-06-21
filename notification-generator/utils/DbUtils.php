<?php
$PRG=$argv[0];
$DIR=dirname($PRG);

include_once( $DIR.'/utils/ConfigReader.php' );

define("NOTIFIER","notifier");
define("DB_SERVER","db_server");
define("DB_USER","db_user");
define("DB_PASSWORD","db_password");
define("DB_NAME","db_name");

class DbUtils
{
	public function getDbConnection()
	{
		$configReader=new ConfigReader();
		$conn = new mysqli($configReader->get_section_element(NOTIFIER,DB_SERVER), $configReader->get_section_element(NOTIFIER,DB_USER), $configReader->get_section_element(NOTIFIER,DB_PASSWORD), $configReader->get_section_element(NOTIFIER,DB_NAME));
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		return $conn;
	}
	
	public function closeConnection($conn)
	{
		$conn->close();
	}
	
	public function getRecords($query,$conn)
	{
		$result = $conn->query($query);
		if ($result->num_rows <= 0) {
			echo "\nNo results found in DB\n";
		}
		return $result;
	}
	
	public function insertRecords($query,$conn)
	{
		if ($conn->query($query) === TRUE) {
			echo "New record created successfully\n";
		} else {
			echo "Error: " . $query . "\nError message: " . $conn->error."\n";
		}
	}
}
