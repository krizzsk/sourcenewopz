package com.didi.dimina.container.p106ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.dimina.container.p106ui.dialog.ActionSheetItemView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.dialog.BaseActionSheet */
public class BaseActionSheet extends Dialog {

    /* renamed from: a */
    private final Context f17536a;

    /* renamed from: b */
    private final OnDismissListener f17537b;

    /* renamed from: c */
    private View f17538c;

    /* renamed from: d */
    private String f17539d;

    /* renamed from: e */
    private int f17540e = -1;
    protected LinearLayout mContentContainer;

    /* renamed from: com.didi.dimina.container.ui.dialog.BaseActionSheet$OnDismissListener */
    public interface OnDismissListener {
        void onDismiss(int i);
    }

    public BaseActionSheet(Context context, OnDismissListener onDismissListener) {
        super(context, R.style.BottomDialog);
        this.f17536a = context;
        this.f17537b = onDismissListener;
        m13053a();
    }

    /* renamed from: a */
    private void m13053a() {
        View inflate = LayoutInflater.from(this.f17536a).inflate(R.layout.dimina_action_sheet, (ViewGroup) null);
        this.f17538c = inflate;
        this.mContentContainer = (LinearLayout) inflate.findViewById(R.id.action_sheet_content_container);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f17538c);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = m13056b();
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
        getWindow().setWindowAnimations(2132017442);
    }

    /* renamed from: b */
    private int m13056b() {
        DisplayMetrics displayMetrics;
        if (getContext() == null || (displayMetrics = getContext().getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public void refresh(List<String> list) {
        this.mContentContainer.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                m13055a(i, str, Color.parseColor(this.f17539d));
                m13054a(1);
            }
        }
        m13054a(20);
        m13055a(-1, "取消", Color.parseColor("#000000"));
    }

    /* renamed from: a */
    private void m13054a(int i) {
        View view = new View(this.f17536a);
        view.setBackgroundColor(Color.parseColor("#F5F5F5"));
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        this.mContentContainer.addView(view);
    }

    /* renamed from: a */
    private void m13055a(int i, String str, int i2) {
        ActionSheetItemView actionSheetItemView = new ActionSheetItemView(this.f17536a);
        actionSheetItemView.setTextValue(str, i2);
        actionSheetItemView.setActionSheetItemClick(new ActionSheetItemView.ActionSheetItemClick(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick() {
                BaseActionSheet.this.m13057b(this.f$1);
            }
        });
        this.mContentContainer.addView(actionSheetItemView);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m13057b(int i) {
        this.f17540e = i;
        dismiss();
    }

    public void setTitle(String str) {
        if (this.f17536a != null && !TextUtils.isEmpty(str)) {
            TextView textView = (TextView) LayoutInflater.from(this.f17536a).inflate(R.layout.dimina_action_sheet, (ViewGroup) null).findViewById(R.id.alert_title);
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public void setItemColor(String str) {
        this.f17539d = str;
    }

    public void show() {
        super.show();
    }

    public void dismiss() {
        super.dismiss();
        LinearLayout linearLayout = this.mContentContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            OnDismissListener onDismissListener = this.f17537b;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this.f17540e);
            }
        }
    }
}
