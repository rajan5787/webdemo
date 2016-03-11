package com.example.rajanpipaliya.webdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rajan pipaliya on 7/8/2015.
 */
public class craft_adapter extends BaseAdapter
{
    Context mContext;
    ArrayList<craft_class> marraylist=new ArrayList<craft_class>();
    LayoutInflater inflater;

    public craft_adapter(Context mContext, ArrayList<craft_class> marraylist) {
        this.mContext = mContext;
        this.marraylist = marraylist;
        this.inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return marraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return marraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        craft_view_holder holder=null;
        if(holder==null){
            convertView=inflater.inflate(R.layout.craft_view,null);
            holder=new craft_view_holder((TextView)convertView.findViewById(R.id.name));
        }
        else{
            holder=(craft_view_holder)convertView.getTag();
        }
        holder.getName().setText(marraylist.get(position).getName());
        return convertView;
    }
}
