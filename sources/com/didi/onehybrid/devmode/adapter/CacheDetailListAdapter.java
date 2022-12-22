package com.didi.onehybrid.devmode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.onehybrid.devmode.view.CacheDetailItemView;
import java.util.ArrayList;

public class CacheDetailListAdapter extends CustomBaseAdapter {

    public static class CacheItemDetailInfo {
        public String mCacheMd5;
        public String mCacheSize;
    }

    public CacheDetailListAdapter(Context context, ArrayList<CacheItemDetailInfo> arrayList) {
        super(context);
        this.list = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            viewHolder = new ViewHolder();
            CacheDetailItemView cacheDetailItemView = new CacheDetailItemView(this.context);
            view2 = cacheDetailItemView.getRoot();
            view2.setTag(viewHolder);
            viewHolder.view = cacheDetailItemView;
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        CacheDetailItemView cacheDetailItemView2 = viewHolder.view;
        cacheDetailItemView2.setCacheSize("File Size :  " + ((CacheItemDetailInfo) this.list.get(i)).mCacheSize);
        CacheDetailItemView cacheDetailItemView3 = viewHolder.view;
        cacheDetailItemView3.setCacheMd5("File MD5 :  " + ((CacheItemDetailInfo) this.list.get(i)).mCacheMd5);
        return view2;
    }

    class ViewHolder {
        CacheDetailItemView view;

        ViewHolder() {
        }
    }
}
