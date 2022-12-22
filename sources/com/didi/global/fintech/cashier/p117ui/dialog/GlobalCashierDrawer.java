package com.didi.global.fintech.cashier.p117ui.dialog;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR@\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R@\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR(\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u0010\u0010(\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u00063"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "()V", "closeBtn", "Landroid/widget/ImageView;", "h1Btn", "Landroid/widget/Button;", "h2Btn", "horizontalLayout", "Landroid/widget/LinearLayout;", "value", "", "isHorizontal", "()Z", "setHorizontal", "(Z)V", "", "", "Landroid/view/View$OnClickListener;", "negativeBtn", "getNegativeBtn", "()Ljava/util/Map;", "setNegativeBtn", "(Ljava/util/Map;)V", "positiveBtn", "getPositiveBtn", "setPositiveBtn", "showCloseBtn", "getShowCloseBtn", "setShowCloseBtn", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "subTitleTV", "Landroid/widget/TextView;", "title", "getTitle", "setTitle", "titleTV", "v1Btn", "v2Btn", "verticalLayout", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDrawer */
/* compiled from: GlobalCashierDrawer.kt */
public final class GlobalCashierDrawer extends GlobalCashierBaseDrawer {

    /* renamed from: a */
    private ImageView f21725a;

    /* renamed from: b */
    private TextView f21726b;

    /* renamed from: c */
    private TextView f21727c;

    /* renamed from: d */
    private Button f21728d;

    /* renamed from: e */
    private Button f21729e;

    /* renamed from: f */
    private Button f21730f;

    /* renamed from: g */
    private Button f21731g;

    /* renamed from: h */
    private LinearLayout f21732h;

    /* renamed from: i */
    private LinearLayout f21733i;

    /* renamed from: j */
    private boolean f21734j;

    /* renamed from: k */
    private boolean f21735k = true;

    /* renamed from: l */
    private String f21736l;

    /* renamed from: m */
    private String f21737m;

    /* renamed from: n */
    private Map<String, ? extends View.OnClickListener> f21738n;

    /* renamed from: o */
    private Map<String, ? extends View.OnClickListener> f21739o;

    public int layout() {
        return R.layout.dialog_global_cashier_drawer;
    }

    public final boolean getShowCloseBtn() {
        return this.f21734j;
    }

    public final void setShowCloseBtn(boolean z) {
        this.f21734j = z;
        ImageView imageView = this.f21725a;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final boolean isHorizontal() {
        return this.f21735k;
    }

    public final void setHorizontal(boolean z) {
        this.f21735k = z;
        LinearLayout linearLayout = this.f21732h;
        int i = 0;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ^ true ? 0 : 8);
        }
        LinearLayout linearLayout2 = this.f21733i;
        if (linearLayout2 != null) {
            View view = linearLayout2;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public final String getTitle() {
        return this.f21736l;
    }

    public final void setTitle(String str) {
        this.f21736l = str;
        TextView textView = this.f21726b;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getSubTitle() {
        return this.f21737m;
    }

    public final void setSubTitle(String str) {
        this.f21737m = str;
        TextView textView = this.f21727c;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final Map<String, View.OnClickListener> getPositiveBtn() {
        return this.f21738n;
    }

    public final void setPositiveBtn(Map<String, ? extends View.OnClickListener> map) {
        this.f21738n = map;
        Button button = this.f21730f;
        int i = 8;
        boolean z = false;
        if (button != null) {
            button.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        Button button2 = this.f21728d;
        if (button2 != null) {
            View view = button2;
            if (!(map == null || map.isEmpty())) {
                i = 0;
            }
            view.setVisibility(i);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                Button button3 = this.f21730f;
                if (button3 != null) {
                    button3.setText((CharSequence) next.getKey());
                }
                Button button4 = this.f21730f;
                if (button4 != null) {
                    ViewKtxKt.click$default(button4, 0, new GlobalCashierDrawer$positiveBtn$1$1(next, this), 1, (Object) null);
                }
                Button button5 = this.f21728d;
                if (button5 != null) {
                    button5.setText((CharSequence) next.getKey());
                }
                Button button6 = this.f21728d;
                if (button6 != null) {
                    ViewKtxKt.click$default(button6, 0, new GlobalCashierDrawer$positiveBtn$1$2(next, this), 1, (Object) null);
                }
            }
        }
    }

    public final Map<String, View.OnClickListener> getNegativeBtn() {
        return this.f21739o;
    }

    public final void setNegativeBtn(Map<String, ? extends View.OnClickListener> map) {
        this.f21739o = map;
        Button button = this.f21731g;
        int i = 8;
        boolean z = false;
        if (button != null) {
            button.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        Button button2 = this.f21729e;
        if (button2 != null) {
            View view = button2;
            if (!(map == null || map.isEmpty())) {
                i = 0;
            }
            view.setVisibility(i);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                Button button3 = this.f21731g;
                if (button3 != null) {
                    button3.setText((CharSequence) next.getKey());
                }
                Button button4 = this.f21731g;
                if (button4 != null) {
                    ViewKtxKt.click$default(button4, 0, new GlobalCashierDrawer$negativeBtn$1$1(next, this), 1, (Object) null);
                }
                Button button5 = this.f21729e;
                if (button5 != null) {
                    button5.setText((CharSequence) next.getKey());
                }
                Button button6 = this.f21729e;
                if (button6 != null) {
                    ViewKtxKt.click$default(button6, 0, new GlobalCashierDrawer$negativeBtn$1$2(next, this), 1, (Object) null);
                }
            }
        }
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f21725a = (ImageView) view.findViewById(R.id.drawer_close_img);
        this.f21726b = (TextView) view.findViewById(R.id.drawer_title);
        TextView textView = (TextView) view.findViewById(R.id.drawer_sub_title);
        this.f21727c = textView;
        if (textView != null) {
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        this.f21728d = (Button) view.findViewById(R.id.drawer_btn_ok);
        this.f21729e = (Button) view.findViewById(R.id.drawer_btn_cancel);
        this.f21730f = (Button) view.findViewById(R.id.drawer_btn_v1);
        this.f21731g = (Button) view.findViewById(R.id.drawer_btn_v2);
        this.f21732h = (LinearLayout) view.findViewById(R.id.drawer_btn_vertical);
        this.f21733i = (LinearLayout) view.findViewById(R.id.drawer_btn_horizontal);
        ImageView imageView = this.f21725a;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    GlobalCashierDrawer.m15815a(GlobalCashierDrawer.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15815a(GlobalCashierDrawer globalCashierDrawer, View view) {
        Intrinsics.checkNotNullParameter(globalCashierDrawer, "this$0");
        globalCashierDrawer.dismiss();
    }

    public void initData() {
        setShowCloseBtn(this.f21734j);
        setTitle(this.f21736l);
        setSubTitle(this.f21737m);
        setHorizontal(this.f21735k);
        setPositiveBtn(this.f21738n);
        setNegativeBtn(this.f21739o);
    }
}
