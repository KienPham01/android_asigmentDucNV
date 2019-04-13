<?php
require 'dbConfig.php' ;
$query = "SELECT * FROM diem WHERE diemTB>8 ORDER BY diemTB DESC LIMIT 1";
 if($data=mysqli_query($connect,$query)){
	 	$mangSV = array();
 //thêm phần tử vào mảng
 while ($row =mysqli_fetch_assoc($data)) {
 	array_push($mangSV, new SinhVien($row['id'],  $row['maSV'], $row['HoTen'],$row['diemTB'] ));
 }
// //Chuyển sang định dạng mảng json
 echo json_encode($mangSV);
}
 class SinhVien{
 	function SinhVien($id, $maSV , $HoTen, $diemTB){
 		$this->id = $id;
 		$this->maSV = $maSV;
		$this->HoTen = $HoTen;
 		$this->diemTB = $diemTB;
 	}
 }
  ?>