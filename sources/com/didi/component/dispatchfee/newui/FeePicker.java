package com.didi.component.dispatchfee.newui;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.view.picker.IPickerData;
import com.taxis99.R;

public class FeePicker<T extends IPickerData> extends FeeBasePicker<T> {

    /* renamed from: a */
    private FrameLayout f12803a;

    /* renamed from: b */
    private FrameLayout f12804b;

    /* renamed from: c */
    private View f12805c;

    /* renamed from: d */
    private View f12806d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_dispatchfee_picker_free;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f12803a = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_top);
        this.f12804b = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_bottom);
        View view = this.f12805c;
        if (view != null) {
            this.f12803a.addView(view);
        }
        View view2 = this.f12806d;
        if (view2 != null) {
            this.f12804b.addView(view2);
        }
        ((FrameLayout) this.mRootView.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    public void setHeadView(View view) {
        this.f12805c = view;
    }

    public void setBottomView(View view) {
        this.f12806d = view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f12803a.removeAllViews();
        this.f12804b.removeAllViews();
    }
}
