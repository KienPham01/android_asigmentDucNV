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

import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.DiemSV;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.SinhVien;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.UpdateDiem;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.UpdateSinhVien;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Diem;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 8/7/2018.
 */

public class DiemAdapter extends BaseAdapter {
    private DiemSV context;
    private int layout;
    private List<Diem> diemList;

    public DiemAdapter(DiemSV context, ArrayList<Diem> diemList) {
        this.context = context;
        this.diemList = diemList;
    }

    @Override
    public int getCount() {
        return diemList.size();
    }

    @Override
    public Object getItem(int i) {
        return diemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView txtmaSV,txthoTen,txtmonTN,txtmonTH,txtmonTB,txtdiemMonTN,txtdiemMonTH,txtdiemMonTB,txtdiemTB;
        ImageView img ;
        Button bntxoa,bntsua;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.docdiemsv,null);
            viewHolder.img = (ImageView) view.findViewById(R.id.imghinhanh);
            viewHolder.txtmaSV = (TextView) view.findViewById(R.id.txtdiemMasv);
            viewHolder.txthoTen = (TextView) view.findViewById(R.id.txtdiemtensinhvien);
            viewHolder.txtmonTN = (TextView) view.findViewById(R.id.txtmonthunhat);
            viewHolder.txtmonTH = (TextView) view.findViewById(R.id.txtmonthuhai);
            viewHolder.txtmonTB = (TextView) view.findViewById(R.id.txtmonthuba);
            viewHolder.txtdiemMonTN = (TextView) view.findViewById(R.id.txtdiemmonthunhat);
            viewHolder.txtdiemMonTH = (TextView) view.findViewById(R.id.txtdiemmonthuhai);
            viewHolder.txtdiemMonTB = (TextView) view.findViewById(R.id.txtdiemmonthuba);
            viewHolder.txtdiemTB = (TextView) view.findViewById(R.id.txtdiemtrungbinh);
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
        final Diem diem = diemList.get(i);
        new AsyncTaskLoadImage(viewHolder.img).execute(diem.getLinkanh());
        viewHolder.txtmaSV.setText("Mã SV: "+diem.getMaSV());
        viewHolder.txthoTen.setText("Họ & Tên: "+diem.getHoTen());
        viewHolder.txtmonTN.setText(diem.getMonTN());
        viewHolder.txtmonTH.setText(diem.getMonTH());
        viewHolder.txtmonTB.setText(diem.getMonTB());
        viewHolder.txtdiemMonTN.setText(Double.toString(diem.getDiemMonTN()));
        viewHolder.txtdiemMonTH.setText(Double.toString(diem.getDiemMonTh()));
        viewHolder.txtdiemMonTB.setText(Double.toString(diem.getDiemMonTB()));
        viewHolder.txtdiemTB.setText("Điểm Trung Bình : "+Double.toString(diem.getDiemTB()));
        viewHolder.bntsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , UpdateDiem.class);
                intent.putExtra("dataDiemSinhVien", diem);
                context.startActivity(intent);
            }
        });
        viewHolder.bntxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xatnhanxoa(diem.getHoTen(),diem.getId());
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
