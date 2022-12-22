package com.didi.global.fintech.cashier.p117ui.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016R@\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R(\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u0006*"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierPaySuccessDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "()V", "value", "", "", "Landroid/view/View$OnClickListener;", "btn", "getBtn", "()Ljava/util/Map;", "setBtn", "(Ljava/util/Map;)V", "button", "Landroid/widget/Button;", "priceStr", "getPriceStr", "()Ljava/lang/String;", "setPriceStr", "(Ljava/lang/String;)V", "priceTV", "Landroid/widget/TextView;", "statusIV", "Landroid/widget/ImageView;", "statusStr", "getStatusStr", "setStatusStr", "statusTV", "symbolStr", "getSymbolStr", "setSymbolStr", "symbolTV", "tipContentTV", "tipStr", "getTipStr", "setTipStr", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierPaySuccessDrawer */
/* compiled from: GlobalCashierPaySuccessDrawer.kt */
public final class GlobalCashierPaySuccessDrawer extends GlobalCashierBaseDrawer {

    /* renamed from: a */
    private ImageView f21740a;

    /* renamed from: b */
    private TextView f21741b;

    /* renamed from: c */
    private TextView f21742c;

    /* renamed from: d */
    private TextView f21743d;

    /* renamed from: e */
    private TextView f21744e;

    /* renamed from: f */
    private Button f21745f;

    /* renamed from: g */
    private String f21746g;

    /* renamed from: h */
    private String f21747h;

    /* renamed from: i */
    private String f21748i;

    /* renamed from: j */
    private String f21749j;

    /* renamed from: k */
    private Map<String, ? extends View.OnClickListener> f21750k;

    public int layout() {
        return R.layout.dialog_pay_result;
    }

    public final String getStatusStr() {
        return this.f21746g;
    }

    public final void setStatusStr(String str) {
        this.f21746g = str;
        TextView textView = this.f21741b;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getSymbolStr() {
        return this.f21747h;
    }

    public final void setSymbolStr(String str) {
        this.f21747h = str;
        TextView textView = this.f21742c;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getPriceStr() {
        return this.f21748i;
    }

    public final void setPriceStr(String str) {
        this.f21748i = str;
        TextView textView = this.f21743d;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getTipStr() {
        return this.f21749j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        if ((r4.length() == 0) == true) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTipStr(java.lang.String r4) {
        /*
            r3 = this;
            r3.f21749j = r4
            android.widget.TextView r0 = r3.f21744e
            if (r0 != 0) goto L_0x0007
            goto L_0x000a
        L_0x0007:
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(r0, r4)
        L_0x000a:
            android.widget.TextView r0 = r3.f21744e
            if (r0 != 0) goto L_0x000f
            goto L_0x0029
        L_0x000f:
            r1 = 1
            r2 = 0
            if (r4 != 0) goto L_0x0015
        L_0x0013:
            r1 = 0
            goto L_0x0022
        L_0x0015:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            if (r4 != r1) goto L_0x0013
        L_0x0022:
            if (r1 == 0) goto L_0x0026
            r2 = 8
        L_0x0026:
            r0.setVisibility(r2)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierPaySuccessDrawer.setTipStr(java.lang.String):void");
    }

    public final Map<String, View.OnClickListener> getBtn() {
        return this.f21750k;
    }

    public final void setBtn(Map<String, ? extends View.OnClickListener> map) {
        this.f21750k = map;
        Button button = this.f21745f;
        boolean z = false;
        if (button != null) {
            button.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                Button button2 = this.f21745f;
                if (button2 != null) {
                    button2.setText((CharSequence) next.getKey());
                }
                Button button3 = this.f21745f;
                if (button3 != null) {
                    ViewKtxKt.click$default(button3, 0, new GlobalCashierPaySuccessDrawer$btn$1$1(next, this), 1, (Object) null);
                }
            }
        }
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f21740a = (ImageView) view.findViewById(R.id.iv_pay_status);
        this.f21741b = (TextView) view.findViewById(R.id.tv_pay_status);
        this.f21742c = (TextView) view.findViewById(R.id.tv_symbol);
        this.f21743d = (TextView) view.findViewById(R.id.tv_price);
        this.f21744e = (TextView) view.findViewById(R.id.tv_tip_content);
        this.f21745f = (Button) view.findViewById(R.id.btn_ok);
    }

    public void initData() {
        setStatusStr(this.f21746g);
        setSymbolStr(this.f21747h);
        setPriceStr(this.f21748i);
        setTipStr(this.f21749j);
        setBtn(this.f21750k);
    }
}
