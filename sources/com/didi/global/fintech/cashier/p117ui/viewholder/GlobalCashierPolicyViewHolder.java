package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0016JN\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0016\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001bH\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPolicyViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "checkBox", "Landroid/widget/CheckBox;", "info", "Landroid/widget/TextView;", "link", "logo", "Landroid/widget/ImageView;", "title", "initView", "", "layout", "", "updateBrandLogo", "", "updateContent", "updatePolicy", "selected", "", "cbListener", "Lkotlin/Function1;", "contents", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/AcceptContent;", "linkListener", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPolicyViewHolder */
/* compiled from: GlobalCashierPolicyViewHolder.kt */
public final class GlobalCashierPolicyViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierPolicyViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f21798a;

    /* renamed from: b */
    private TextView f21799b;

    /* renamed from: c */
    private CheckBox f21800c;

    /* renamed from: d */
    private TextView f21801d;

    /* renamed from: e */
    private TextView f21802e;

    public int layout() {
        return R.layout.viewholder_global_cashier_policy;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPolicyViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPolicyViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPolicyViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPolicyViewHolder$Companion */
    /* compiled from: GlobalCashierPolicyViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierPolicyViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierPolicyViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        super.initView();
        this.f21798a = (ImageView) getView(R.id.iv_logo);
        this.f21799b = (TextView) getView(R.id.tv_content);
        this.f21800c = (CheckBox) getView(R.id.cb_policy);
        this.f21801d = (TextView) getView(R.id.tv_policy_info);
        this.f21802e = (TextView) getView(R.id.tv_policy_link);
    }

    public void updateBrandLogo(String str) {
        ImageView imageView = this.f21798a;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logo");
            imageView = null;
        }
        ViewKtxKt.load(imageView, str);
    }

    public void updateContent(String str) {
        TextView textView = this.f21799b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r11 = r12.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updatePolicy(boolean r10, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r11, java.util.List<com.didi.global.fintech.cashier.p117ui.viewholder.AcceptContent> r12, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r13) {
        /*
            r9 = this;
            android.widget.CheckBox r0 = r9.f21800c
            java.lang.String r1 = "checkBox"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            r0.setChecked(r10)
            android.widget.CheckBox r10 = r9.f21800c
            if (r10 != 0) goto L_0x0016
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r10 = r2
        L_0x0016:
            com.didi.global.fintech.cashier.ui.viewholder.-$$Lambda$GlobalCashierPolicyViewHolder$BPihUYiD1gjXZ8S8YOVZ2NwFXPg r0 = new com.didi.global.fintech.cashier.ui.viewholder.-$$Lambda$GlobalCashierPolicyViewHolder$BPihUYiD1gjXZ8S8YOVZ2NwFXPg
            r0.<init>()
            r10.setOnCheckedChangeListener(r0)
            android.widget.TextView r10 = r9.f21801d
            if (r10 != 0) goto L_0x0028
            java.lang.String r10 = "info"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = r2
        L_0x0028:
            if (r12 != 0) goto L_0x002c
        L_0x002a:
            r11 = r2
            goto L_0x003a
        L_0x002c:
            r11 = 0
            java.lang.Object r11 = r12.get(r11)
            com.didi.global.fintech.cashier.ui.viewholder.AcceptContent r11 = (com.didi.global.fintech.cashier.p117ui.viewholder.AcceptContent) r11
            if (r11 != 0) goto L_0x0036
            goto L_0x002a
        L_0x0036:
            java.lang.String r11 = r11.getMessage()
        L_0x003a:
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(r10, r11)
            android.widget.TextView r10 = r9.f21802e
            java.lang.String r11 = "link"
            if (r10 != 0) goto L_0x0047
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r10 = r2
        L_0x0047:
            if (r12 != 0) goto L_0x004b
        L_0x0049:
            r0 = r2
            goto L_0x0059
        L_0x004b:
            r0 = 1
            java.lang.Object r0 = r12.get(r0)
            com.didi.global.fintech.cashier.ui.viewholder.AcceptContent r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.AcceptContent) r0
            if (r0 != 0) goto L_0x0055
            goto L_0x0049
        L_0x0055:
            java.lang.String r0 = r0.getMessage()
        L_0x0059:
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(r10, r0)
            android.widget.TextView r10 = r9.f21802e
            if (r10 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0065
        L_0x0064:
            r2 = r10
        L_0x0065:
            r3 = r2
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPolicyViewHolder$updatePolicy$2 r10 = new com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPolicyViewHolder$updatePolicy$2
            r10.<init>(r13, r12)
            r6 = r10
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = 1
            r8 = 0
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.click$default(r3, r4, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.GlobalCashierPolicyViewHolder.updatePolicy(boolean, kotlin.jvm.functions.Function1, java.util.List, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15829a(Function1 function1, CompoundButton compoundButton, boolean z) {
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }
}
