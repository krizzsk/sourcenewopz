package com.didi.onehybrid.devmode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.onehybrid.devmode.view.BundleDetailItemView;
import com.taxis99.R;
import java.util.ArrayList;

public class AllOfflineItemAdapter extends CustomBaseAdapter {

    public static class AllOfflineItemInfo {
        public String mBundleName;
        public String mSize;
    }

    public AllOfflineItemAdapter(Context context, ArrayList<AllOfflineItemInfo> arrayList) {
        super(context);
        this.list = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            viewHolder = new ViewHolder();
            BundleDetailItemView bundleDetailItemView = new BundleDetailItemView(this.context);
            view2 = bundleDetailItemView.getRoot();
            view2.setTag(viewHolder);
            viewHolder.view = bundleDetailItemView;
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        BundleDetailItemView bundleDetailItemView2 = viewHolder.view;
        bundleDetailItemView2.setBundleSize(this.context.getString(R.string.offline_size) + " :  " + ((AllOfflineItemInfo) this.list.get(i)).mSize);
        BundleDetailItemView bundleDetailItemView3 = viewHolder.view;
        bundleDetailItemView3.setBundleName(this.context.getString(R.string.offline_name) + " :  " + ((AllOfflineItemInfo) this.list.get(i)).mBundleName);
        return view2;
    }

    class ViewHolder {
        BundleDetailItemView view;

        ViewHolder() {
        }
    }
}
