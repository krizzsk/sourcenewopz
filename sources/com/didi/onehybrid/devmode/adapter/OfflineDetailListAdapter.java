package com.didi.onehybrid.devmode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.onehybrid.devmode.view.OfflineCacheItemView;
import java.util.ArrayList;

public class OfflineDetailListAdapter extends CustomBaseAdapter {

    public static class CacheItemInfo {
        public String mFileName;
        public String mFilePath;
        public String mFileSize;
        public String mFileUrl;
        public String mModifyTime;
    }

    public OfflineDetailListAdapter(Context context, ArrayList<CacheItemInfo> arrayList) {
        super(context);
        this.list = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            viewHolder = new ViewHolder();
            OfflineCacheItemView offlineCacheItemView = new OfflineCacheItemView(this.context);
            view2 = offlineCacheItemView.getRoot();
            view2.setTag(viewHolder);
            viewHolder.view = offlineCacheItemView;
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.view.setFileSize(((CacheItemInfo) this.list.get(i)).mFileSize);
        viewHolder.view.setModifyTime(((CacheItemInfo) this.list.get(i)).mModifyTime);
        viewHolder.view.setFileUrl(((CacheItemInfo) this.list.get(i)).mFileUrl);
        viewHolder.view.setFileName(((CacheItemInfo) this.list.get(i)).mFileName);
        viewHolder.view.setFilePath(((CacheItemInfo) this.list.get(i)).mFilePath);
        return view2;
    }

    class ViewHolder {
        OfflineCacheItemView view;

        ViewHolder() {
        }
    }
}
