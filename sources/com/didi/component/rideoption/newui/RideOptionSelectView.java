package com.didi.component.rideoption.newui;

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
    private Context f15321a;

    /* renamed from: b */
    private TextView f15322b;

    /* renamed from: c */
    private PopupSelectRecyclerView f15323c;

    /* renamed from: d */
    private List<PopupSelectModel> f15324d;

    /* renamed from: e */
    private RideOptionNewUiAdapter f15325e;

    /* renamed from: f */
    private PopupSelectView.OnPopupSelectListClickListener f15326f;

    public RideOptionSelectView(Context context) {
        super(context);
        this.f15321a = context;
        m10989a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15321a = context;
        m10989a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15321a = context;
        m10989a();
    }

    /* renamed from: a */
    private void m10989a() {
        View inflate = LayoutInflater.from(this.f15321a).inflate(R.layout.global_ride_option_new_ui_list_layout, (ViewGroup) null);
        this.f15323c = (PopupSelectRecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f15322b = (TextView) inflate.findViewById(R.id.title);
        addView(inflate);
        this.f15325e = new RideOptionNewUiAdapter(this.f15321a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f15321a);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.f15323c.setLayoutManager(linearLayoutManager);
        this.f15323c.setAdapter(this.f15325e);
    }

    public void setTitle(String str) {
        TextView textView = this.f15322b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.f15322b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f15324d = list;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f15325e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.updateItems(list);
        }
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f15326f = onPopupSelectListClickListener;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f15325e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
        }
    }

    public void setSelectedPosition(int i) {
        List<PopupSelectModel> list;
        if (this.f15325e != null && (list = this.f15324d) != null && list.size() > i) {
            this.f15325e.setSelectItem(this.f15324d.get(i).f38171id);
        }
    }

    public void setSelectedId(String str) {
        if (this.f15325e != null && this.f15324d != null && !TextUtils.isEmpty(str)) {
            this.f15325e.setSelectItem(str);
        }
    }

    public void setMaxHeight(int i) {
        PopupSelectRecyclerView popupSelectRecyclerView = this.f15323c;
        if (popupSelectRecyclerView != null) {
            popupSelectRecyclerView.setMaxHeight(i);
        }
    }

    public void notifyDataSetChanged() {
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f15325e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.notifyDataSetChanged();
        }
    }
}
