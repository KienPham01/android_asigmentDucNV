<?php
require "dbConfig.php";
$maSV = $_POST['maSV'];
$HoTen = $_POST['HoTen'];
$monThuNhat = $_POST['monThuNhat'];
$monThuHai = $_POST['monThuHai'];
$monThuBa = $_POST['monThuBa'];
$diemMonThuNhat = $_POST['diemMonThuNhat'];
$diemMonThuHai = $_POST['diemMonThuHai'];
$diemMonThuBa = $_POST['diemMonThuBa'];
$diemTB = $_POST['diemTB'];
$linkanh = $_POST['linkanh'];
$query = "INSERT INTO diem VALUES(null,'$maSV' ,'$HoTen' , '$monThuNhat', '$monThuHai', '$monThuBa' , '$diemMonThuNhat' , '$diemMonThuHai' , '$diemMonThuBa' , '$diemTB','$linkanh')";
if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "error";
}
?>