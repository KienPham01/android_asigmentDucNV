package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.UrlSever;

import java.util.HashMap;
import java.util.Map;

public class UpdateSinhVien extends AppCompatActivity {
    String urlcapnhatsv = UrlSever.capnhatsv;
    Toolbar toolbartcapnhatsv;
    EditText editmaSV,editHoTen,editGioTinh,editLop,editHinhAnh,editNgaySinh;
    Button set,bntCapNhat,bntThoat;
    Dialog picker;
    DatePicker datep;
    Integer month, day, year;
    int id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);
        toolbartcapnhatsv = (Toolbar) findViewById(R.id.trangcapnhatsinhvien);
        editmaSV = (EditText) findViewById(R.id.editTextMaSV);
        editHoTen = (EditText) findViewById(R.id.edithoTen);
        editGioTinh = (EditText) findViewById(R.id.edigioitinh);
        editLop = (EditText) findViewById(R.id.editlop);
        editHinhAnh = (EditText) findViewById(R.id.editlinkanh);
        editNgaySinh = (EditText) findViewById(R.id.editngaysinh);
        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("dataSinhVien");
        id = student.getId();
        editmaSV.setText(student.getMaSV());
        editHoTen.setText(student.getHoTen());
        editGioTinh.setText(student.getGioTinh());
        editLop.setText(student.getLop());
        editHinhAnh.setText(student.getLinkanh());
        editNgaySinh.setText(student.getNamsinh());
        bntCapNhat = (Button)findViewById(R.id.bntcapnhat);
        bntThoat = (Button)findViewById(R.id.bntthoat);
        ChayToolBar();
        bntThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bntCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = editmaSV.getText().toString().trim();
                String hoten = editHoTen.getText().toString().trim();
                String gioitinh = editGioTinh.getText().toString().trim();
                String lop = editLop.getText().toString().trim();
                String linkanh = editHinhAnh.getText().toString().trim();
                String ngaysinh = editNgaySinh.getText().toString().trim();
                if(maSV.isEmpty() || hoten.isEmpty() || gioitinh.isEmpty() || lop.isEmpty() || linkanh.isEmpty() ||ngaysinh.isEmpty()){
                    Toast.makeText(UpdateSinhVien.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    capnhatsinhvien(urlcapnhatsv);
                }
            }
        });
        editNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker = new Dialog(UpdateSinhVien.this);
                picker.setContentView(R.layout.ngaygio);
                picker.setTitle("Chọn ngày tháng năm sinh");
                datep = (DatePicker) picker.findViewById(R.id.datePicker);
                set = (Button) picker.findViewById(R.id.btnSet);
                //picker thời gian
                set.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Auto-generated method stub
                        month = datep.getMonth();
                        day = datep.getDayOfMonth();
                        year = datep.getYear();
                        editNgaySinh.setText(day + "/" + month + "/"
                                + year);
                        picker.dismiss();
                    }
                });
                picker.show();
            }
        });
    }
    private void ChayToolBar() {
        setSupportActionBar(toolbartcapnhatsv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartcapnhatsv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void capnhatsinhvien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(UpdateSinhVien.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(SuaSinhVien.this,SinhVien.class));
                    finish();
                }else {
                    Toast.makeText(UpdateSinhVien.this, "Cập nhât không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateSinhVien.this, "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","lỖI!\n"+error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id",String.valueOf(id));
                params.put("maSV",editmaSV.getText().toString().trim());
                params.put("HoTen",editHoTen.getText().toString().trim());
                params.put("GioiTinh",editGioTinh.getText().toString().trim());
                params.put("Lop",editLop.getText().toString().trim());
                params.put("HinhAnh",editHinhAnh.getText().toString().trim());
                params.put("NamSinh",editNgaySinh.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
