package com.hi.baidu.learnandroidfromzero.adapter;

import java.util.ArrayList;
import java.util.List;

import com.hi.baidu.learnandroidfromzero.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by liuguanli on 16/9/17.
 */
public class MainAdapter<T> extends BaseAdapter {

    private List<T> mList;
    private LayoutInflater mInflater = null;

    public List<T> getDateResc() {
        if (mList == null) {
            return new ArrayList<>();
        }
        return mList;
    }

    public MainAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public MainAdapter(List<T> list, Context context) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    public void changeDate(List<T> list) {
        if (mList != null) {
            mList.clear();
            mList.addAll(list);
        } else {
            mList = list;
        }
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        if (mList != null) {
            return mList.get(i);
        } else {
            return null;
        }
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param i
     *
     * @return
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.listview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String s = (String) mList.get(i);
        viewHolder.tv.setText(s);
        return view;
    }

    private static class ViewHolder {
        TextView tv;
    }
}
