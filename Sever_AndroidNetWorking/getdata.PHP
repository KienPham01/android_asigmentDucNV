<?php
require "dbConfig.php";
$query = "SELECT * FROM sinhvien";
$data = mysqli_query($connect,$query);
//tạo class sinhvien
class SinhVien{
	function SinhVien($id, $maSV , $HoTen , $GioiTinh , $Lop , $HinhAnh , $NamSinh){
		$this->id = $id;
		$this->maSV = $maSV;
		$this->HoTen = $HoTen;
		$this->GioiTinh = $GioiTinh;
		$this->Lop = $Lop;
		$this->HinhAnh = $HinhAnh;
		$this->NamSinh = $NamSinh;
	}
}
//tạo mảng
$mangSV = array();
//thêm phần tử vào mảng
while ($row =mysqli_fetch_assoc($data)) {
	array_push($mangSV, new SinhVien($row['id'],  $row['maSV'], $row['HoTen'], $row['GioiTinh'], $row['Lop'] ,$row['HinhAnh'],$row['NamSinh'] ));
}
//Chuyển sang định dạng mảng json
echo json_encode($mangSV);
?>