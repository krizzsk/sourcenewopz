package com.didi.addressnew.view.enhance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.addressnew.view.AddressAdapter;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;

public class WaittingAdapter extends AddressAdapter {

    /* renamed from: a */
    private static final int f7599a = 66;

    /* renamed from: b */
    private int f7600b = 0;

    public RpcPoi getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public WaittingAdapter(int i) {
        this.f7600b = i;
    }

    public int getCount() {
        return this.f7600b;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.loading_empty_item, viewGroup, false);
    }
}
