package com.didi.sdk.view.picker;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.view.picker.IPickerData;
import com.taxis99.R;
import java.util.List;

public class TreePicker<T extends IPickerData> extends PickerBaseTree<T> {

    /* renamed from: a */
    private FrameLayout f38146a;

    /* renamed from: b */
    private FrameLayout f38147b;

    /* renamed from: c */
    private View f38148c;

    /* renamed from: d */
    private View f38149d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.picker_free;
    }

    public /* bridge */ /* synthetic */ void setInitialSelect(int[] iArr) {
        super.setInitialSelect(iArr);
    }

    public /* bridge */ /* synthetic */ void setInitialSelect(IPickerData[] iPickerDataArr) {
        super.setInitialSelect((T[]) iPickerDataArr);
    }

    public /* bridge */ /* synthetic */ void setPickerData(List list) {
        super.setPickerData(list);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f38146a = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_top);
        this.f38147b = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_bottom);
        View view = this.f38148c;
        if (view != null) {
            this.f38146a.addView(view);
        }
        View view2 = this.f38149d;
        if (view2 != null) {
            this.f38147b.addView(view2);
        }
        ((FrameLayout) this.mRootView.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    public void setHeadView(View view) {
        this.f38148c = view;
    }

    public void setBottomView(View view) {
        this.f38149d = view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f38146a.removeAllViews();
        this.f38147b.removeAllViews();
    }
}
