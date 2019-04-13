<?php
require "dbConfig.php";
$maSV = $_POST['maSV'];
$query = "SELECT * FROM sinhvien WHERE maSV LIKE '$maSV'";
// if($data=mysqli_query($connect,$query)){
if($data=mysqli_query($connect,$query)){
 	$mangSV = array();
// //thêm phần tử vào mảng
 while ($row =mysqli_fetch_assoc($data)) {
	array_push($mangSV, new SinhVien($row['id'],  $row['maSV'], $row['HoTen'],$row['HinhAnh'] ));
 }
}
// //Chuyển sang định dạng mảng json
 echo json_encode($mangSV);
 class SinhVien{
	function SinhVien($id, $maSV , $HoTen, $HinhAnh){
 		$this->id = $id;
 		$this->maSV = $maSV;
 		$this->HoTen = $HoTen;
 		$this->HinhAnh = $HinhAnh;
 	}
 }
?>