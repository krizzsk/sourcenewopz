package com.didi.sdk.view.picker;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.picker.IPickerData;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.taxis99.R;
import java.util.List;

public class SimplePickerV2<T extends IPickerData> extends PickerBaseTree<T> {

    /* renamed from: a */
    private CommonPopupTitleBar f38119a;

    /* renamed from: b */
    private CharSequence f38120b;

    /* renamed from: c */
    private String f38121c;

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
        m26953a(this.mRootView);
    }

    public void setTitle(CharSequence charSequence) {
        CommonPopupTitleBar commonPopupTitleBar = this.f38119a;
        if (commonPopupTitleBar == null || charSequence == null) {
            this.f38120b = charSequence;
        } else {
            commonPopupTitleBar.setTitle(charSequence.toString());
        }
    }

    public void setMessage(String str) {
        if (this.f38119a == null || TextUtils.isEmpty(str)) {
            this.f38121c = str;
        } else {
            this.f38119a.setMessage(str);
        }
    }

    /* renamed from: a */
    private void m26953a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.dismiss();
            }
        });
        this.f38119a = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        TextView textView = (TextView) view.findViewById(R.id.title_bar2);
        View findViewById = view.findViewById(R.id.rl_root);
        View findViewById2 = view.findViewById(R.id.containertitle_bar);
        CharSequence charSequence = this.f38120b;
        if (charSequence != null) {
            this.f38119a.setTitle(charSequence.toString());
            textView.setText(this.f38120b.toString());
        }
        if (!TextUtils.isEmpty(this.f38121c)) {
            this.f38119a.setMessage(this.f38121c);
        }
        this.f38119a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.m26952a();
            }
        });
        this.f38119a.setVisibility(8);
        ((TextView) view.findViewById(R.id.tv_confirm2)).setVisibility(0);
        findViewById2.setVisibility(0);
        findViewById.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        view.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.m26952a();
            }
        });
        this.f38119a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.dismiss();
            }
        });
        ((FrameLayout) view.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26952a() {
        confirmSelectAndCallback();
        dismiss();
    }
}
