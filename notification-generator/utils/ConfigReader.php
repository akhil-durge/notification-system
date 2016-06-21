<?php
$PRG=$argv[0];
$DIR=dirname($PRG);
define("CONFIG_FILE",$DIR."/config/db.ini");

class ConfigReader {
	private $configArray=array();	
	 
	public function __construct(){
		$this->configArray=parse_ini_file( CONFIG_FILE, 1 ) or die("can't parse config file :".CONFIG_FILE."\n");
	}
	 
	function get_section_element($sectionName,$elementName) {
		return $this->configArray[$sectionName][$elementName];
	}
}
?>
