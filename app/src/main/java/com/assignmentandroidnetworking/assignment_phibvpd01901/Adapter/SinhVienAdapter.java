package com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.UpdateSinhVien;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.SinhVien;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 8/6/2018.
 */

public class SinhVienAdapter extends BaseAdapter {
    private SinhVien context;
    private int layout;
    private List<Student> studentList;
    public SinhVienAdapter(SinhVien context, ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }
    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView txtmaSV,txthoTen,txtgioiTinh,txtlop,txtnamsinh;
        ImageView img ;
        Button bntxoa,bntsua;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.doc_sinhvien,null);
            viewHolder.img = (ImageView) view.findViewById(R.id.imghinhanh);
            viewHolder.txtmaSV = (TextView) view.findViewById(R.id.txtmasinhvien);
            viewHolder.txthoTen = (TextView) view.findViewById(R.id.txttensinhvien);
            viewHolder.txtgioiTinh = (TextView) view.findViewById(R.id.txtgioitinh);
            viewHolder.txtlop = (TextView) view.findViewById(R.id.txtlop);
            viewHolder.txtnamsinh = (TextView) view.findViewById(R.id.txtnamsinh);
            viewHolder.bntxoa = (Button) view.findViewById(R.id.bntxoa);
            viewHolder.bntsua = (Button) view.findViewById(R.id.bntsua);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i % 2==0){
            view.setBackgroundColor(Color.parseColor("#99ff99"));
        }else {
            view.setBackgroundColor(Color.parseColor("#9999ff"));
        }
        final Student student = studentList.get(i);
        new AsyncTaskLoadImage(viewHolder.img).execute(student.getLinkanh());
        viewHolder.txtmaSV.setText("Mã SV: "+student.getMaSV());
        viewHolder.txthoTen.setText("Họ & Tên: "+student.getHoTen());
        viewHolder.txtgioiTinh.setText("Giới Tính: "+student.getGioTinh());
        viewHolder.txtlop.setText("Mã Lớp & Lớp: "+student.getLop());
        viewHolder.txtnamsinh.setText("Năm sinh: "+student.getNamsinh());
        viewHolder.bntsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , UpdateSinhVien.class);
                intent.putExtra("dataSinhVien", student);
                context.startActivity(intent);
            }
        });
        viewHolder.bntxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xatnhanxoa(student.getHoTen(),student.getId());
            }
        });
        return view;
    }
    public class AsyncTaskLoadImage  extends AsyncTask<String, String, Bitmap> {
        private final static String TAG = "AsyncTaskLoadImage";
        private ImageView imageView;
        public AsyncTaskLoadImage(ImageView imageView) {
            this.imageView = imageView;
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
    private void xatnhanxoa(String hoten ,final int id){
        AlertDialog.Builder dialogxoa = new AlertDialog.Builder(context);
        dialogxoa.setTitle("Xóa Sinh Viên");
        dialogxoa.setIcon(R.drawable.dete);
        dialogxoa.setMessage("Bạn có muốn xóa sinh viên "+hoten+" không");
        dialogxoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.XoaSinhVien(id);
            }
        });
        dialogxoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogxoa.show();
    }
}
