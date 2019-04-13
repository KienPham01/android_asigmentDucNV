<?php
require "dbConfig.php";
$query = "SELECT * FROM diem";
$data = mysqli_query($connect,$query);
//tạo class sinhvien
class Diem{
	function Diem($id, $maSV , $HoTen , $monThuNhat , $monThuHai , $monThuBa , $diemMonThuNhat, $diemMonThuHai , $diemMonThuBa , $diemTB , $linkanh){
		$this->id = $id;
		$this->maSV = $maSV;
		$this->HoTen = $HoTen;
		$this->monThuNhat = $monThuNhat;
		$this->monThuHai = $monThuHai;
		$this->monThuBa = $monThuBa;
		$this->diemMonThuNhat = $diemMonThuNhat;
		$this->diemMonThuHai = $diemMonThuHai;
		$this->diemMonThuBa = $diemMonThuBa;
		$this->diemTB = $diemTB;
		$this->linkanh = $linkanh;
	}
}
//tạo mảng
$mangDSV = array();
//thêm phần tử vào mảng
while ($row =mysqli_fetch_assoc($data)) {
	array_push($mangDSV, new Diem($row['id'],  $row['maSV'], $row['HoTen'], $row['monThuNhat'], $row['monThuHai'] ,$row['monThuBa'],$row['diemMonThuNhat'] ,
$row['diemMonThuHai'],$row['diemMonThuBa'],$row['diemTB'],$row['linkanh']));
}
//Chuyển sang định dạng mảng json
echo json_encode($mangDSV);
?>