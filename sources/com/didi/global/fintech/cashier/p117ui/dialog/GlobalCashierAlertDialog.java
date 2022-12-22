package com.didi.global.fintech.cashier.p117ui.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R@\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR@\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierAlertDialog;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseAlertDialog;", "()V", "button1", "Landroid/widget/TextView;", "button2", "value", "", "", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierAlertDialog$OnBtnClickListener;", "negBtn", "getNegBtn", "()Ljava/util/Map;", "setNegBtn", "(Ljava/util/Map;)V", "posBtn", "getPosBtn", "setPosBtn", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "subTitleTV", "title", "getTitle", "setTitle", "titleTV", "getTheme", "", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "OnBtnClickListener", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierAlertDialog */
/* compiled from: GlobalCashierAlertDialog.kt */
public final class GlobalCashierAlertDialog extends GlobalCashierBaseAlertDialog {

    /* renamed from: a */
    private TextView f21700a;

    /* renamed from: b */
    private TextView f21701b;

    /* renamed from: c */
    private TextView f21702c;

    /* renamed from: d */
    private TextView f21703d;

    /* renamed from: e */
    private String f21704e = "";

    /* renamed from: f */
    private String f21705f = "";

    /* renamed from: g */
    private Map<String, ? extends OnBtnClickListener> f21706g;

    /* renamed from: h */
    private Map<String, ? extends OnBtnClickListener> f21707h;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierAlertDialog$OnBtnClickListener;", "", "onBtnClick", "", "fragment", "Landroidx/fragment/app/DialogFragment;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierAlertDialog$OnBtnClickListener */
    /* compiled from: GlobalCashierAlertDialog.kt */
    public interface OnBtnClickListener {
        void onBtnClick(DialogFragment dialogFragment);
    }

    public int getTheme() {
        return 2132018402;
    }

    public int layout() {
        return R.layout.dialog_global_cashier_alert;
    }

    public final String getTitle() {
        return this.f21704e;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f21704e = str;
        TextView textView = this.f21700a;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f21700a;
        if (textView2 != null) {
            View view = textView2;
            int i = 0;
            if (!(str.length() > 0)) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public final String getSubTitle() {
        return this.f21705f;
    }

    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f21705f = str;
        TextView textView = this.f21701b;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f21701b;
        if (textView2 != null) {
            View view = textView2;
            int i = 0;
            if (!(str.length() > 0)) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public final Map<String, OnBtnClickListener> getPosBtn() {
        return this.f21706g;
    }

    public final void setPosBtn(Map<String, ? extends OnBtnClickListener> map) {
        this.f21706g = map;
        TextView textView = this.f21702c;
        boolean z = false;
        if (textView != null) {
            textView.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                TextView textView2 = this.f21702c;
                if (textView2 != null) {
                    textView2.setText((CharSequence) next.getKey());
                }
                TextView textView3 = this.f21702c;
                if (textView3 != null) {
                    ViewKtxKt.click$default(textView3, 0, new GlobalCashierAlertDialog$posBtn$1$1(next, this), 1, (Object) null);
                }
            }
        }
    }

    public final Map<String, OnBtnClickListener> getNegBtn() {
        return this.f21707h;
    }

    public final void setNegBtn(Map<String, ? extends OnBtnClickListener> map) {
        this.f21707h = map;
        TextView textView = this.f21703d;
        boolean z = false;
        if (textView != null) {
            textView.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                TextView textView2 = this.f21703d;
                if (textView2 != null) {
                    textView2.setText((CharSequence) next.getKey());
                }
                TextView textView3 = this.f21703d;
                if (textView3 != null) {
                    ViewKtxKt.click$default(textView3, 0, new GlobalCashierAlertDialog$negBtn$1$1(next, this), 1, (Object) null);
                }
            }
        }
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f21700a = (TextView) view.findViewById(R.id.text_title);
        this.f21701b = (TextView) view.findViewById(R.id.text_message);
        this.f21702c = (TextView) view.findViewById(R.id.button_top_bottom_1);
        this.f21703d = (TextView) view.findViewById(R.id.button_top_bottom_2);
    }

    public void initData() {
        setTitle(this.f21704e);
        setSubTitle(this.f21705f);
        setNegBtn(this.f21707h);
        setPosBtn(this.f21706g);
    }
}
