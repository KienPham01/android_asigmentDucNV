package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.app.ProgressDialog;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter.SinhVienAdapter;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Diem;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.UrlSever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThemDiem extends AppCompatActivity {
    String urltimkiem = UrlSever.timkiemmasv;
    String urlthemdiem = UrlSever.themdiem;
    Toolbar toolbarthemdiemsv;
    EditText edittimkiemmasv,editthemdiemmasv,editthemdiemtensv,editmonthunhat,editmonthuhai,editmonthuba,
    editdiemmonthunhat,editdiemmonthuhai,editdiemmonthuba,editdiemtb,editlinkanh;
    Button bntthem,bntthoat,bnttimkiemmasv;
    String urlgetdata = UrlSever.getdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_diem);
        toolbarthemdiemsv = (Toolbar) findViewById(R.id.trangthemdiemsinhvien);
        edittimkiemmasv = (EditText) findViewById(R.id.edittimkiemmasv);
        editthemdiemmasv = (EditText) findViewById(R.id.editThemdiemMaSV);
        editthemdiemmasv.setEnabled(false);
        editthemdiemtensv = (EditText) findViewById(R.id.editthemdiemhoTen);
        editthemdiemtensv.setEnabled(false);
        editmonthunhat = (EditText) findViewById(R.id.editmonthunhat);
        editmonthuhai = (EditText) findViewById(R.id.editmonthuhai);
        editmonthuba = (EditText) findViewById(R.id.editmonthuba);
        editdiemmonthunhat = (EditText) findViewById(R.id.editdiemmonthunhat);
        editdiemmonthuhai = (EditText) findViewById(R.id.editdiemmonthuhai);
        editdiemmonthuba = (EditText) findViewById(R.id.editdiemmonthuba);
        editdiemtb = (EditText) findViewById(R.id.editdiemtrungbinh);
        editdiemtb.setEnabled(false);
        editlinkanh = (EditText) findViewById(R.id.editthemdiemlinkanh);
        editlinkanh.setEnabled(false);
        bntthem = (Button) findViewById(R.id.bntdiemthem);
        bntthoat = (Button) findViewById(R.id.bntdiemthoat);
        bnttimkiemmasv = (Button) findViewById(R.id.bnttiemkiemmasv);
        ChayToolBar();
        bntthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bnttimkiemmasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = edittimkiemmasv.getText().toString().trim();
                if (maSV.isEmpty()) {
                    Toast.makeText(ThemDiem.this, "Vui lòng nhập mã SV cần tìm", Toast.LENGTH_SHORT).show();
                } else {
                    timkiem(urltimkiem);
                }
            }
        });
        bntthem.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(ThemDiem.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    themdiemsinhvien(urlthemdiem);
                }
            }
        });
    }
    private void ChayToolBar() {
        setSupportActionBar(toolbarthemdiemsv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarthemdiemsv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void timkiem(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            editthemdiemmasv.setText(jsonObject.getString("maSV"));
                            editthemdiemtensv.setText(jsonObject.getString("HoTen"));
                            editlinkanh.setText(jsonObject.getString("HinhAnh"));
                            Log.d("AAA","iM RA CAU LENH!"+jsonObject.getString("maSV"));
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
//                    startActivity(new Intent(ThemSinhVien.this,SinhVien.class));
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThemDiem.this, "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","lỖI!\n"+error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("maSV",edittimkiemmasv.getText().toString().trim());
                Log.d("AAA","MaSV!"+edittimkiemmasv.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void themdiemsinhvien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(ThemDiem.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(ThemSinhVien.this,SinhVien.class));
                    finish();
                }else {
                    Toast.makeText(ThemDiem.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThemDiem.this, "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","lỖI!\n"+error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
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
