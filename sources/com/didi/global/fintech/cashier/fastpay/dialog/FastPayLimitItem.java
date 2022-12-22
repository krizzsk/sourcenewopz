package com.didi.global.fintech.cashier.fastpay.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItem;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "cb", "Landroid/widget/CheckBox;", "rootViewHolder", "Landroid/view/View;", "title", "Landroid/widget/TextView;", "bind", "", "content", "select", "", "click", "listener", "Landroid/view/View$OnClickListener;", "getRootView", "selected", "Companion", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayLimitDrawer.kt */
public final class FastPayLimitItem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final View f21545a;

    /* renamed from: b */
    private final TextView f21546b;

    /* renamed from: c */
    private final CheckBox f21547c;

    /* renamed from: d */
    private String f21548d;

    public FastPayLimitItem(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_holder_limit_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…imit_item, parent, false)");
        this.f21545a = inflate;
        View findViewById = inflate.findViewById(R.id.tv_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootViewHolder.findViewById(R.id.tv_item_title)");
        this.f21546b = (TextView) findViewById;
        View findViewById2 = this.f21545a.findViewById(R.id.cb_item_check);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootViewHolder.findViewById(R.id.cb_item_check)");
        this.f21547c = (CheckBox) findViewById2;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItem$Companion;", "", "()V", "newIns", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItem;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayLimitDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayLimitItem newIns(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new FastPayLimitItem(context, viewGroup);
        }
    }

    public final String getAmount() {
        return this.f21548d;
    }

    public final void setAmount(String str) {
        this.f21548d = str;
    }

    public final View getRootView() {
        return this.f21545a;
    }

    public final void bind(String str, String str2, boolean z) {
        ViewKtxKt.content(this.f21546b, str);
        this.f21548d = str2;
        selected(z);
    }

    public final void click(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.f21545a.setOnClickListener(onClickListener);
        this.f21547c.setOnClickListener(onClickListener);
    }

    public final void selected(boolean z) {
        FastPayLimitItem fastPayLimitItem = this;
        fastPayLimitItem.f21547c.setChecked(z);
        fastPayLimitItem.f21547c.setEnabled(!z);
    }
}
