package com.didi.sdk.view.picker;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.view.picker.IPickerData;
import com.taxis99.R;
import java.util.List;

public class FreePicker<T extends IPickerData> extends C13247a<T> {

    /* renamed from: a */
    private FrameLayout f37998a;

    /* renamed from: b */
    private FrameLayout f37999b;

    /* renamed from: c */
    private View f38000c;

    /* renamed from: d */
    private View f38001d;

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

    public /* bridge */ /* synthetic */ void setPickerData(IPickerDataInject[] iPickerDataInjectArr) {
        super.setPickerData((IPickerDataInject<T>[]) iPickerDataInjectArr);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f37998a = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_top);
        this.f37999b = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_bottom);
        View view = this.f38000c;
        if (view != null) {
            this.f37998a.addView(view);
        }
        View view2 = this.f38001d;
        if (view2 != null) {
            this.f37999b.addView(view2);
        }
        ((FrameLayout) this.mRootView.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    public void setHeadView(View view) {
        this.f38000c = view;
    }

    public void setBottomView(View view) {
        this.f38001d = view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f37998a.removeAllViews();
        this.f37999b.removeAllViews();
    }
}
