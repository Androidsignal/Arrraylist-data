package com.example.akshar.largejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akshar on 8/31/2017.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Mybean>arrayList;
    Context context;

    public MyAdapter(Context context,ArrayList<Mybean> arrayList ) {
        this.arrayList = arrayList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.my_layout,null);
        TextView txtname,txtid,txtmobile,txthome;

        txtname=(TextView)convertView.findViewById(R.id.txtname);
        txtid=(TextView)convertView.findViewById(R.id.id122);
        txtmobile=(TextView)convertView.findViewById(R.id.txtmobile);
        txthome=(TextView)convertView.findViewById(R.id.txthome);

        Mybean mybean  =arrayList.get(position);
        txthome.setText("home"+mybean.getHome());
        txtname.setText("mobile"+mybean.getName());
        txtid.setText("id"+mybean.getId());
        txtmobile.setText("mobile"+mybean.getMobile());
        return convertView;
    }
}
