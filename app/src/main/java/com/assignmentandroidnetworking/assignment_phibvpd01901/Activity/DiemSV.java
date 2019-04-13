package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter.DiemAdapter;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter.SinhVienAdapter;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Diem;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.KiemtraKetNoi;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.UrlSever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiemSV extends AppCompatActivity {
    Toolbar toolbartdsv;
    String urlgetdata = UrlSever.getdiemdata;
    String urlxoadiem = UrlSever.xoadiem;
    ProgressDialog pDialog;
    ListView lssdieminhvien;
    ArrayList<Diem>diemArrayList;
    DiemAdapter diemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_sv);
        toolbartdsv = (Toolbar) findViewById(R.id.trangdiemsinhvien);
        lssdieminhvien = (ListView) findViewById(R.id.listViewdiemSinhVien);
        diemArrayList = new ArrayList<>();
        diemAdapter = new DiemAdapter(DiemSV.this, diemArrayList);
        lssdieminhvien.setAdapter(diemAdapter);
        FloatingActionButton fababc = (FloatingActionButton) findViewById(R.id.fababc);
        fababc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiemSV.this,ThemDiem.class);
                startActivity(intent);
            }
        });
        if (KiemtraKetNoi.haveNetworkConnection(this)){
            GetData(urlgetdata);
            ChayToolBar();
        }else {
            KiemtraKetNoi.ThongBao(this,"Vui lòng kết nối internet");
        }
    }
    private void ChayToolBar() {
        setSupportActionBar(toolbartdsv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartdsv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void GetData(String url){
        pDialog = new ProgressDialog(DiemSV.this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Đang tải dữ liệu...");
        pDialog.show();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        diemArrayList.clear();
                        for (int i = 0; i < response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                diemArrayList.add(new Diem(
                                        object.getInt("id"),
                                        object.getString("maSV"),
                                        object.getString("HoTen"),
                                        object.getString("monThuNhat"),
                                        object.getString("monThuHai"),
                                        object.getString("monThuBa"),
                                        Double.parseDouble(object.getString("diemMonThuNhat")),
                                        Double.parseDouble(object.getString("diemMonThuHai")),
                                        Double.parseDouble(object.getString("diemMonThuBa")),
                                        Double.parseDouble(object.getString("diemTB")),
                                        object.getString("linkanh")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        diemAdapter.notifyDataSetChanged();
                        pDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DiemSV.this, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public void XoaSinhVien(final int idsv){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlxoadiem, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(getApplicationContext(), "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    GetData(urlgetdata);
                }else {
                    Toast.makeText(getApplicationContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","lỖI!\n"+error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id",String.valueOf(idsv));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
