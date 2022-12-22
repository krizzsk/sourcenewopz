package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.sdk.view.popup.PopupSelectRecyclerView;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.List;

public class RideOptionSelectView extends FrameLayout {

    /* renamed from: a */
    private Context f49832a;

    /* renamed from: b */
    private TextView f49833b;

    /* renamed from: c */
    private PopupSelectRecyclerView f49834c;

    /* renamed from: d */
    private List<PopupSelectModel> f49835d;

    /* renamed from: e */
    private RideOptionNewUiAdapter f49836e;

    /* renamed from: f */
    private PopupSelectView.OnPopupSelectListClickListener f49837f;

    public RideOptionSelectView(Context context) {
        super(context);
        this.f49832a = context;
        m35933a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49832a = context;
        m35933a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49832a = context;
        m35933a();
    }

    /* renamed from: a */
    private void m35933a() {
        View inflate = LayoutInflater.from(this.f49832a).inflate(R.layout.car_model_ride_option_list_layout, (ViewGroup) null);
        this.f49834c = (PopupSelectRecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f49833b = (TextView) inflate.findViewById(R.id.title);
        addView(inflate);
        this.f49836e = new RideOptionNewUiAdapter(this.f49832a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f49832a);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.f49834c.setLayoutManager(linearLayoutManager);
        this.f49834c.setAdapter(this.f49836e);
    }

    public void setTitle(String str) {
        TextView textView = this.f49833b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.f49833b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f49835d = list;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f49836e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.updateItems(list);
        }
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f49837f = onPopupSelectListClickListener;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f49836e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
        }
    }

    public void setSelectedPosition(int i) {
        List<PopupSelectModel> list;
        if (this.f49836e != null && (list = this.f49835d) != null && list.size() > i) {
            this.f49836e.setSelectItem(this.f49835d.get(i).f38171id);
        }
    }

    public void setSelectedId(String str) {
        if (this.f49836e != null && this.f49835d != null && !TextUtils.isEmpty(str)) {
            this.f49836e.setSelectItem(str);
        }
    }

    public void setMaxHeight(int i) {
        PopupSelectRecyclerView popupSelectRecyclerView = this.f49834c;
        if (popupSelectRecyclerView != null) {
            popupSelectRecyclerView.setMaxHeight(i);
        }
    }

    public void notifyDataSetChanged() {
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f49836e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.notifyDataSetChanged();
        }
    }
}
