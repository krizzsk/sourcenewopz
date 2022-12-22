package com.didi.sdk.view.picker;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.TimePickerMode;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.picker.IPickerData;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.taxis99.R;
import java.util.List;

public class SimplePickerV1<T extends IPickerData> extends PickerBaseTree<T> {

    /* renamed from: a */
    private CommonPopupTitleBar f38116a;

    /* renamed from: b */
    private CharSequence f38117b;

    /* renamed from: c */
    private String f38118c;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.picker_local_global;
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
        m26950a(this.mRootView);
    }

    public void setTitle(CharSequence charSequence) {
        CommonPopupTitleBar commonPopupTitleBar = this.f38116a;
        if (commonPopupTitleBar == null || charSequence == null) {
            this.f38117b = charSequence;
        } else {
            commonPopupTitleBar.setTitle(charSequence.toString());
        }
    }

    public void setMessage(String str) {
        if (this.f38116a == null || TextUtils.isEmpty(str)) {
            this.f38118c = str;
        } else {
            this.f38116a.setMessage(str);
        }
    }

    /* renamed from: a */
    private void m26950a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV1.this.dismiss();
            }
        });
        this.f38116a = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        TextView textView = (TextView) view.findViewById(R.id.title_bar2);
        View findViewById = view.findViewById(R.id.rl_root);
        View findViewById2 = view.findViewById(R.id.containertitle_bar);
        CharSequence charSequence = this.f38117b;
        if (charSequence != null) {
            this.f38116a.setTitle(charSequence.toString());
            textView.setText(this.f38117b.toString());
        }
        if (!TextUtils.isEmpty(this.f38118c)) {
            this.f38116a.setMessage(this.f38118c);
        }
        this.f38116a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV1.this.m26949a();
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.tv_confirm2);
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getTimePickerMode() == TimePickerMode.Global) {
            this.f38116a.setVisibility(8);
            textView2.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        } else {
            this.f38116a.setVisibility(0);
            textView2.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById.setBackgroundResource(R.drawable.common_dialog_bg);
        }
        view.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV1.this.m26949a();
            }
        });
        this.f38116a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV1.this.dismiss();
            }
        });
        ((FrameLayout) view.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26949a() {
        confirmSelectAndCallback();
        dismiss();
    }
}
