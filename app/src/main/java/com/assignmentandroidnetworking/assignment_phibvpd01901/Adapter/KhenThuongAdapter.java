package com.assignmentandroidnetworking.assignment_phibvpd01901.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.SinhVien;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Activity.XepLoai;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.KhenThuong;
import com.assignmentandroidnetworking.assignment_phibvpd01901.Model.Student;
import com.assignmentandroidnetworking.assignment_phibvpd01901.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 8/10/2018.
 */

public class KhenThuongAdapter extends BaseAdapter{
    private XepLoai context;
    private int layout;
    private List<KhenThuong> khenThuongList;

    public KhenThuongAdapter(XepLoai context, ArrayList<KhenThuong> khenThuongList) {
        this.context = context;
        this.khenThuongList = khenThuongList;
    }

    @Override
    public int getCount() {
        return khenThuongList.size();
    }

    @Override
    public Object getItem(int i) {
        return khenThuongList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    private class ViewHolder{
        TextView txtmaSV,txthoTen,txtdiemTB;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dockhenthuong, null);
            viewHolder.txthoTen = (TextView) view.findViewById(R.id.tenxl);
            viewHolder.txtmaSV = (TextView) view.findViewById(R.id.masvxl);
            viewHolder.txtdiemTB = (TextView) view.findViewById(R.id.dtbxl);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final KhenThuong khenThuong = khenThuongList.get(i);
        viewHolder.txthoTen.setText(khenThuong.getHoTen());
        viewHolder.txtmaSV.setText(khenThuong.getMaSV());
        viewHolder.txtdiemTB.setText(Double.toString(khenThuong.getDiemTB()));
        return view;
    }
}
