<?php
require "dbConfig.php";
$id = $_POST['id'];
$maSV = $_POST['maSV'];
$HoTen = $_POST['HoTen'];
$GioiTinh = $_POST['GioiTinh'];
$Lop = $_POST['Lop'];
$HinhAnh = $_POST['HinhAnh'];
$NamSinh = $_POST['NamSinh'];
$query = "UPDATE sinhvien SET maSV = '$maSV', HoTen = '$HoTen', GioiTinh = '$GioiTinh',
Lop = '$Lop' , HinhAnh = '$HinhAnh' , NamSinh = '$NamSinh' WHERE id = '$id'";
if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "error";
}
?>