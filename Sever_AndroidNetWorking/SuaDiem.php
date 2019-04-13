<?php
require "dbConfig.php";
$id = $_POST['id'];
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
$query = "UPDATE diem SET maSV = '$maSV', HoTen = '$HoTen', monThuNhat = '$monThuNhat',monThuHai = '$monThuHai' , monThuBa = '$monThuBa' , diemMonThuNhat = '$diemMonThuNhat', diemMonThuHai='$diemMonThuHai',diemMonThuBa = '$diemMonThuBa',
diemTB = '$diemTB' ,linkanh = '$linkanh' WHERE id = '$id'";
if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "error";
}
?>