package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter.KhenThuongAdapter;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter.SinhVienAdapter;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.KhenThuong;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Url.UrlSever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class XepLoai extends AppCompatActivity {
    Toolbar toolbarxeploai;
    ListView listxuatsac , listgioi ;
    TextView txtname_ov , txtmasv_ov , txtdtb_ov ;
    String urlxeploai = UrlSever.xeploai;
    String urlxeploaigioi = UrlSever.xeploaigioi;
    String urlxeploaikha = UrlSever.xeploaikha;
    ArrayList<KhenThuong> khenThuongArrayList;
    ArrayList<KhenThuong> khenThuongs;
     KhenThuongAdapter khenThuongAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xep_loai);
        toolbarxeploai = (Toolbar) findViewById(R.id.trangxeploai);
        listxuatsac = (ListView) findViewById(R.id.listview_sv_xuatsac);
        listgioi = (ListView) findViewById(R.id.listview_sv_gioi);
        txtname_ov = (TextView) findViewById(R.id.tenongvangpolytxt);
        txtmasv_ov = (TextView) findViewById(R.id.masvongvang);
        txtdtb_ov = (TextView) findViewById(R.id.dtbongvang);
        khenThuongArrayList = new ArrayList<>();
        khenThuongs = new ArrayList<>();
        ChayToolBar();
        getOngvang(urlxeploai);
        getGioi(urlxeploaigioi);
        getKha(urlxeploaikha);
    }
    private void ChayToolBar() {
        setSupportActionBar(toolbarxeploai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarxeploai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void getOngvang(String url)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(XepLoai.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        txtname_ov.setText(jsonObject.getString("HoTen"));
                        txtmasv_ov.setText(jsonObject.getString("maSV"));
                        txtdtb_ov.setText(jsonObject.getString("diemTB"));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                Log.d("AAA","lỖI!\n"+error.toString());
            }
        });
        requestQueue.add(stringRequest);

    }
    private void getGioi(String url)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(XepLoai.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                khenThuongArrayList.clear();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        khenThuongArrayList.add(new KhenThuong(
                                jsonObject.getInt("id"),
                                jsonObject.getString("HoTen"),
                                jsonObject.getString("maSV"),
                                Double.parseDouble(jsonObject.getString("diemTB"))
                        ));
                        Log.d("AAA","lỖI!\n"+jsonObject.getString("HoTen"));
                    }
                    khenThuongAdapter = new KhenThuongAdapter(XepLoai.this, khenThuongArrayList);
                    listxuatsac.setAdapter(khenThuongAdapter);
                    khenThuongAdapter.notifyDataSetChanged();
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                Log.d("AAA","lỖI!\n"+error.toString());
            }
        });
        requestQueue.add(stringRequest);

    }
    private void getKha(String url)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(XepLoai.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                khenThuongs.clear();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        khenThuongs.add(new KhenThuong(
                                jsonObject.getInt("id"),
                                jsonObject.getString("HoTen"),
                                jsonObject.getString("maSV"),
                                Double.parseDouble(jsonObject.getString("diemTB"))
                        ));
                        Log.d("AAA","lỖI!\n"+jsonObject.getString("HoTen"));
                    }
                    khenThuongAdapter = new KhenThuongAdapter(XepLoai.this, khenThuongs);
                    listgioi.setAdapter(khenThuongAdapter);
                    khenThuongAdapter.notifyDataSetChanged();
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Xẩy ra lỗi!", Toast.LENGTH_SHORT).show();
                Log.d("AAA","lỖI!\n"+error.toString());
            }
        });
        requestQueue.add(stringRequest);

    }
}
