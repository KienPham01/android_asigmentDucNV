<?php
require "dbConfig.php";
$id = $_POST['id'];
$query = "DELETE FROM sinhvien WHERE id = '$id'";
if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "error";
}
?>