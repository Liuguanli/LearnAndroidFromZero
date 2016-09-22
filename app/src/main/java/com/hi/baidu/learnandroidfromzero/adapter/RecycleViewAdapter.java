package com.hi.baidu.learnandroidfromzero.adapter;

import java.util.List;

import com.hi.baidu.learnandroidfromzero.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by liuguanli on 16/9/22.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter {

    private List<String> data;

    public RecycleViewAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String item = data.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
