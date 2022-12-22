package com.didi.component.safetoolkit.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class MonitorInterceptPopup extends SimplePopupBase {

    /* renamed from: a */
    private TextView f15429a;

    /* renamed from: b */
    private Button f15430b;

    /* renamed from: c */
    private Button f15431c;

    /* renamed from: d */
    private View.OnClickListener f15432d;

    /* renamed from: e */
    private String f15433e;

    /* renamed from: f */
    private String f15434f;

    /* renamed from: g */
    private String f15435g;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.sf_safe_toolkit_risk_dialog_layout;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(false);
        return onCreateDialog;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        if (this.mRootView != null) {
            this.f15429a = (TextView) this.mRootView.findViewById(R.id.risk_dialog_content_tv);
            this.f15430b = (Button) this.mRootView.findViewById(R.id.risk_dialog_ok_btn);
            this.f15431c = (Button) this.mRootView.findViewById(R.id.risk_dialog_danger_btn);
            this.f15430b.setOnClickListener(this.f15432d);
            this.f15431c.setOnClickListener(this.f15432d);
            this.f15429a.setText(this.f15433e);
            this.f15430b.setText(this.f15434f);
            this.f15431c.setText(this.f15435g);
        }
    }

    public static MonitorInterceptPopup newInstance() {
        MonitorInterceptPopup monitorInterceptPopup = new MonitorInterceptPopup();
        monitorInterceptPopup.setArguments(new Bundle());
        return monitorInterceptPopup;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f15432d = onClickListener;
    }

    public void setContent(String str) {
        this.f15433e = str;
    }

    public void setOkText(String str) {
        this.f15434f = str;
    }

    public void setDangerText(String str) {
        this.f15435g = str;
    }

    public void updateContent(SafeToolkitBean safeToolkitBean) {
        TextView textView;
        if (safeToolkitBean != null && safeToolkitBean.monitorMenuModel != null && (textView = this.f15429a) != null && this.f15430b != null && this.f15431c != null) {
            textView.setText(safeToolkitBean.monitorMenuModel.alertTile);
            this.f15430b.setText(safeToolkitBean.monitorMenuModel.btnOkText);
            this.f15431c.setText(safeToolkitBean.monitorMenuModel.btnJumpText);
        }
    }
}
