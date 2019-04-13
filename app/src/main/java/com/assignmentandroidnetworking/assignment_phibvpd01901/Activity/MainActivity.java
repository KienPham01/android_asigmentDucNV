package com.assignmentandroidnetworking.assignment_phibvpd01901.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter.CustomView;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Item;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.SesionLogin.SQLiteHandler;
import com.assignmentandroidnetworking.assignment_phibvpd01901.SesionLogin.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<>();
    CustomView customView;
    Bitmap sinhvienIcon,diemIcon,xeploaiIcon,monhocIcon;
     TextView txtName;
     TextView txtEmail;
    Button btnLogout;
    private SQLiteHandler db;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.trangchinh);
        setSupportActionBar(toolbar);
        sinhvienIcon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.sinhvien);
        diemIcon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.diem);
        xeploaiIcon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.xeploai);
        monhocIcon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.monhoc);
        gridArray.add(new Item(sinhvienIcon, "Sinh Viên"));
        gridArray.add(new Item(diemIcon, "Điểm"));
        gridArray.add(new Item(xeploaiIcon, "Xếp Loại"));
        gridArray.add(new Item(monhocIcon, "Họp Thư Hỗ Trợ"));
        gridView = (GridView) findViewById(R.id.gridView);
        customView = new CustomView(this,
                R.layout.row_img, gridArray);
        gridView.setAdapter(customView);
        gridView.setOnItemClickListener(this);
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());
/*        if (!session.isLoggedIn()) {
           logoutUser();
       }*/

        // Fetching user details from sqlite
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.thongtin) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            // set title
            alertDialogBuilder.setTitle("Thông tin");
            alertDialogBuilder.setIcon(R.drawable.thongtinhienthi);
            LayoutInflater inflater = getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.dialoghienthi, null);
            alertDialogBuilder.setView(dialogView);
             txtName = (TextView)dialogView.findViewById(R.id.namedangnhap);
              txtEmail = (TextView) dialogView.findViewById(R.id.emaildangnhap);
              btnLogout = (Button) dialogView.findViewById(R.id.btnLogout);
            final AlertDialog b = alertDialogBuilder.create();
            // SqLite database handler
            b.show();
            HashMap<String, String> user = db.getUserDetails();
            String name = user.get("name");
             String email = user.get("email");
            txtName.setText(name);
            txtEmail.setText(email);
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    logoutUser();
                }
            });

        }
        return super.onOptionsItemSelected(item);
    }
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                Intent intent = new Intent(MainActivity.this, SinhVien.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(MainActivity.this, DiemSV.class);
                startActivity(intent2);
                break;
            case 2:
                Intent intent3 = new Intent(MainActivity.this, XepLoai.class);
                startActivity(intent3);
                break;
            case 3:
                   /* Intent intent9 = new Intent(ChemGioActiviti.this, BanBe.class);
                    startActivity(intent9);
                    break;*/
        }
    }
}
