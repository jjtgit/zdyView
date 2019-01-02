package com.example.diyizzk190102.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diyizzk190102.R;
import com.example.diyizzk190102.entity.User;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends BaseAdapter {

    private Context context;
    private List<User.DataBean.TuijianBean.ListBeanX> list;

    public Adapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<User.DataBean.TuijianBean.ListBeanX> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
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
        return null;
    }
    class ViewHolder{
        ImageView img;
        TextView title;
        TextView price;
        public ViewHolder(View view){
            this.img=view.findViewById(R.id.img);
            this.title=view.findViewById(R.id.title);
            this.price=view.findViewById(R.id.price);
            view.setTag(this);
        }
    }
}
