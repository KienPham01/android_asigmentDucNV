<?php
require "dbConfig.php";
$maSV = $_POST['maSV'];
$HoTen = $_POST['HoTen'];
$GioiTinh = $_POST['GioiTinh'];
$Lop = $_POST['Lop'];
$HinhAnh = $_POST['HinhAnh'];
$NamSinh = $_POST['NamSinh'];
$query = "INSERT INTO sinhvien VALUES(null,'$maSV' ,'$HoTen' , '$GioiTinh', '$Lop', '$HinhAnh' , '$NamSinh')";
if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "error";
}
?>