package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
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
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.UrlSever;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddSinhVien extends AppCompatActivity {
    String urlthemsv = UrlSever.themsv;
    Toolbar toolbartsv;
    EditText editmaSV,editHoTen,editGioTinh,editLop,editHinhAnh,editNgaySinh;
    Button set,bntThem,bntThoat;
    Dialog picker;
    DatePicker datep;
    Integer month, day, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        toolbartsv = (Toolbar) findViewById(R.id.trangthemsinhvien);
        editmaSV = (EditText) findViewById(R.id.editTextMaSV);
        editHoTen = (EditText) findViewById(R.id.edithoTen);
        editGioTinh = (EditText) findViewById(R.id.edigioitinh);
        editLop = (EditText) findViewById(R.id.editlop);
        editHinhAnh = (EditText) findViewById(R.id.editlinkanh);
        editNgaySinh = (EditText) findViewById(R.id.editngaysinh);
        bntThem = (Button)findViewById(R.id.bntthem);
        bntThoat = (Button)findViewById(R.id.bntthoat);
        ChayToolBar();
        editNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker = new Dialog(AddSinhVien.this);
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
        bntThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bntThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = editmaSV.getText().toString().trim();
                String hoten = editHoTen.getText().toString().trim();
                String gioitinh = editGioTinh.getText().toString().trim();
                String lop = editLop.getText().toString().trim();
                String linkanh = editHinhAnh.getText().toString().trim();
                String ngaysinh = editNgaySinh.getText().toString().trim();
                if(maSV.isEmpty() || hoten.isEmpty() || gioitinh.isEmpty() || lop.isEmpty() || linkanh.isEmpty() ||ngaysinh.isEmpty()){
                    Toast.makeText(AddSinhVien.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    themsinhvien(urlthemsv);
                }
            }
        });
    }
    private void ChayToolBar() {
        setSupportActionBar(toolbartsv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartsv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void themsinhvien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(AddSinhVien.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(ThemSinhVien.this,SinhVien.class));
                    finish();
                }else {
                    Toast.makeText(AddSinhVien.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddSinhVien.this, "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","lỖI!\n"+error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
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
