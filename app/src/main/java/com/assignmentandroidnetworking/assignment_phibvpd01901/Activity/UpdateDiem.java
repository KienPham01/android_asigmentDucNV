package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Diem;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.UrlSever;

import java.util.HashMap;
import java.util.Map;

public class UpdateDiem extends AppCompatActivity {
    Toolbar toolbarcapnhatdiemsv;
    EditText editthemdiemmasv,editthemdiemtensv,editmonthunhat,editmonthuhai,editmonthuba,
            editdiemmonthunhat,editdiemmonthuhai,editdiemmonthuba,editdiemtb,editlinkanh;
    Button bntcapnhat,bntthoat;
    int id =0;
    String urlcapnhatdiem = UrlSever.capnhatdiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_diem);
        toolbarcapnhatdiemsv = (Toolbar) findViewById(R.id.trangcapnhatdiemsinhvien);
        editthemdiemmasv = (EditText) findViewById(R.id.editThemdiemMaSV);
        editthemdiemtensv = (EditText) findViewById(R.id.editthemdiemhoTen);
        editmonthunhat = (EditText) findViewById(R.id.editmonthunhat);
        editmonthuhai = (EditText) findViewById(R.id.editmonthuhai);
        editmonthuba = (EditText) findViewById(R.id.editmonthuba);
        editdiemmonthunhat = (EditText) findViewById(R.id.editdiemmonthunhat);
        editdiemmonthuhai = (EditText) findViewById(R.id.editdiemmonthuhai);
        editdiemmonthuba = (EditText) findViewById(R.id.editdiemmonthuba);
        editdiemtb = (EditText) findViewById(R.id.editdiemtrungbinh);
        editlinkanh = (EditText) findViewById(R.id.editthemdiemlinkanh);
        bntcapnhat = (Button) findViewById(R.id.bntcapnhatdiemthem);
        bntthoat = (Button) findViewById(R.id.bntcapnhatdiemthoat);
        Intent intent = getIntent();
        Diem diem = (Diem) intent.getSerializableExtra("dataDiemSinhVien");
        id = diem.getId();
        editthemdiemmasv.setText(diem.getMaSV());
        editthemdiemtensv.setText(diem.getHoTen());
        editmonthunhat.setText(diem.getMonTN());
        editmonthuhai.setText(diem.getMonTH());
        editmonthuba.setText(diem.getMonTB());
        editdiemmonthunhat.setText(Double.toString(diem.getDiemMonTN()));
        editdiemmonthuhai.setText(Double.toString(diem.getDiemMonTh()));
        editdiemmonthuba.setText(Double.toString(diem.getDiemMonTB()));
        editdiemtb.setText(Double.toString(diem.getDiemTB()));
        editlinkanh.setText(diem.getLinkanh());
        bntthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bntcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = editthemdiemmasv.getText().toString().trim();
                String hoten = editthemdiemtensv.getText().toString().trim();
                String monthunhat = editmonthunhat.getText().toString().trim();
                String monthuhai = editmonthuhai.getText().toString().trim();
                String monthuba = editmonthuba.getText().toString().trim();
                double diemmonthunhat =Double.parseDouble(editdiemmonthunhat.getText().toString().trim());
                double diemmonthuhai =Double.parseDouble(editdiemmonthuhai.getText().toString().trim());
                double diemmonthuba = Double.parseDouble(editdiemmonthuba.getText().toString().trim());
                String linkanh = editlinkanh.getText().toString().trim();
                double diemtb;
                diemtb = (diemmonthunhat + diemmonthuhai + diemmonthuba)/3;
                editdiemtb.setText(""+diemtb);
                diemtb = Double.parseDouble(editdiemtb.getText().toString().trim());
                if(maSV.equals("") || hoten.equals("") || monthunhat.equals("") || monthuhai.equals("") || linkanh.equals("") ||monthuba.equals("")
                        || editdiemmonthunhat.equals("") || editdiemmonthuhai.equals("") || editdiemmonthuba.equals("") ||editdiemtb.equals("")
                        || linkanh.isEmpty()){
                    Toast.makeText(UpdateDiem.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    capnhatdiemsv(urlcapnhatdiem);
                }
            }
        });
        ChayToolBar();
    }
    private void ChayToolBar() {
        setSupportActionBar(toolbarcapnhatdiemsv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarcapnhatdiemsv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void capnhatdiemsv(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(UpdateDiem.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(ThemSinhVien.this,SinhVien.class));
                    finish();
                }else {
                    Toast.makeText(UpdateDiem.this, "Cập nhật không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateDiem.this, "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","lỖI!\n"+error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id",String.valueOf(id));
                params.put("maSV",editthemdiemmasv.getText().toString().trim());
                params.put("HoTen",editthemdiemtensv.getText().toString().trim());
                params.put("monThuNhat",editmonthunhat.getText().toString().trim());
                params.put("monThuHai",editmonthuhai.getText().toString().trim());
                params.put("monThuBa",editmonthuba.getText().toString().trim());
                params.put("diemMonThuNhat",editdiemmonthunhat.getText().toString().trim());
                params.put("diemMonThuHai",editdiemmonthuhai.getText().toString().trim());
                params.put("diemMonThuBa",editdiemmonthuba.getText().toString().trim());
                params.put("diemTB",editdiemtb.getText().toString().trim());
                params.put("linkanh",editlinkanh.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
