package global.didi.pay.installment.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lglobal/didi/pay/installment/viewholder/InstallmentListItemViewHolder;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "cb", "Landroid/widget/CheckBox;", "rootViewHolder", "Landroid/view/View;", "subtitle", "Landroid/widget/TextView;", "tips", "title", "bind", "", "model", "Lcom/didi/unifiedPay/sdk/model/InstallmentModel;", "select", "", "click", "listener", "Landroid/view/View$OnClickListener;", "getRootView", "selected", "Companion", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InstallmentListItemViewHolder.kt */
public final class InstallmentListItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: cb */
    private final CheckBox f57257cb;
    private final View rootViewHolder;
    private final TextView subtitle;
    private final TextView tips;
    private final TextView title;

    public InstallmentListItemViewHolder(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_payment_activity_installment_list_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.layout.g_payment_activity_installment_list_item, parent, false)");
        this.rootViewHolder = inflate;
        View findViewById = inflate.findViewById(R.id.g_payment_activity_installment_list_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_subtitle)");
        this.subtitle = (TextView) findViewById2;
        View findViewById3 = this.rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_tips);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_tips)");
        this.tips = (TextView) findViewById3;
        View findViewById4 = this.rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_cb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootViewHolder.findViewById(R.id.g_payment_activity_installment_list_item_cb)");
        this.f57257cb = (CheckBox) findViewById4;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lglobal/didi/pay/installment/viewholder/InstallmentListItemViewHolder$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/installment/viewholder/InstallmentListItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InstallmentListItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InstallmentListItemViewHolder newIns(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new InstallmentListItemViewHolder(context, viewGroup);
        }
    }

    public final View getRootView() {
        return this.rootViewHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f7, code lost:
        if (kotlin.text.StringsKt.equals$default(r11 == null ? null : r11.getNumber(), "1", false, 2, (java.lang.Object) null) != false) goto L_0x00f9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bind(com.didi.unifiedPay.sdk.model.InstallmentModel r11, boolean r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0009
        L_0x0005:
            java.lang.String r1 = r11.getNumber()
        L_0x0009:
            java.lang.String r2 = "1"
            r3 = 0
            r4 = 2
            boolean r1 = kotlin.text.StringsKt.equals$default(r1, r2, r3, r4, r0)
            r5 = 1
            if (r1 == 0) goto L_0x0039
            android.widget.TextView r1 = r10.title
            android.view.View r6 = r10.rootViewHolder
            android.content.Context r6 = r6.getContext()
            if (r6 != 0) goto L_0x0020
            r6 = r0
            goto L_0x0033
        L_0x0020:
            r7 = 2131952718(0x7f13044e, float:1.9541887E38)
            java.lang.Object[] r8 = new java.lang.Object[r5]
            if (r11 != 0) goto L_0x0029
            r9 = r0
            goto L_0x002d
        L_0x0029:
            java.lang.String r9 = r11.getEachAmount()
        L_0x002d:
            r8[r3] = r9
            java.lang.String r6 = r6.getString(r7, r8)
        L_0x0033:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
            goto L_0x006b
        L_0x0039:
            android.widget.TextView r1 = r10.title
            android.view.View r6 = r10.rootViewHolder
            android.content.Context r6 = r6.getContext()
            if (r6 != 0) goto L_0x0045
            r6 = r0
            goto L_0x0066
        L_0x0045:
            r7 = 2131952728(0x7f130458, float:1.9541907E38)
            java.lang.Object[] r8 = new java.lang.Object[r4]
            if (r11 != 0) goto L_0x004e
            r9 = r0
            goto L_0x0052
        L_0x004e:
            java.lang.String r9 = r11.getNumber()
        L_0x0052:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8[r3] = r9
            if (r11 != 0) goto L_0x005c
            r9 = r0
            goto L_0x0060
        L_0x005c:
            java.lang.String r9 = r11.getEachAmount()
        L_0x0060:
            r8[r5] = r9
            java.lang.String r6 = r6.getString(r7, r8)
        L_0x0066:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
        L_0x006b:
            android.widget.TextView r1 = r10.subtitle
            android.view.View r6 = r10.rootViewHolder
            android.content.Context r6 = r6.getContext()
            if (r6 != 0) goto L_0x0077
            r5 = r0
            goto L_0x008a
        L_0x0077:
            r7 = 2131952727(0x7f130457, float:1.9541905E38)
            java.lang.Object[] r5 = new java.lang.Object[r5]
            if (r11 != 0) goto L_0x0080
            r8 = r0
            goto L_0x0084
        L_0x0080:
            java.lang.String r8 = r11.getTotalAmount()
        L_0x0084:
            r5[r3] = r8
            java.lang.String r5 = r6.getString(r7, r5)
        L_0x008a:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.TextView r1 = r10.tips
            java.lang.String r5 = ""
            if (r11 != 0) goto L_0x0098
        L_0x0095:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            goto L_0x00a2
        L_0x0098:
            java.lang.String r6 = r11.getInfo()
            if (r6 != 0) goto L_0x009f
            goto L_0x0095
        L_0x009f:
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
        L_0x00a2:
            r1.setText(r5)
            android.widget.TextView r1 = r10.title
            if (r11 != 0) goto L_0x00ab
            r5 = r0
            goto L_0x00af
        L_0x00ab:
            java.lang.String r5 = r11.getEachAmount()
        L_0x00af:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 8
            if (r5 == 0) goto L_0x00bc
            r5 = 8
            goto L_0x00bd
        L_0x00bc:
            r5 = 0
        L_0x00bd:
            r1.setVisibility(r5)
            android.widget.TextView r1 = r10.subtitle
            if (r11 != 0) goto L_0x00c6
            r5 = r0
            goto L_0x00ca
        L_0x00c6:
            java.lang.String r5 = r11.getTotalAmount()
        L_0x00ca:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00d5
            r5 = 8
            goto L_0x00d6
        L_0x00d5:
            r5 = 0
        L_0x00d6:
            r1.setVisibility(r5)
            android.widget.TextView r1 = r10.tips
            if (r11 != 0) goto L_0x00df
            r5 = r0
            goto L_0x00e3
        L_0x00df:
            java.lang.String r5 = r11.getInfo()
        L_0x00e3:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00f9
            if (r11 != 0) goto L_0x00ef
            r11 = r0
            goto L_0x00f3
        L_0x00ef:
            java.lang.String r11 = r11.getNumber()
        L_0x00f3:
            boolean r11 = kotlin.text.StringsKt.equals$default(r11, r2, r3, r4, r0)
            if (r11 == 0) goto L_0x00fb
        L_0x00f9:
            r3 = 8
        L_0x00fb:
            r1.setVisibility(r3)
            android.widget.CheckBox r11 = r10.f57257cb
            r11.setChecked(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.installment.viewholder.InstallmentListItemViewHolder.bind(com.didi.unifiedPay.sdk.model.InstallmentModel, boolean):void");
    }

    public final void click(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.rootViewHolder.setOnClickListener(onClickListener);
        this.f57257cb.setOnClickListener(onClickListener);
    }

    public final void selected(boolean z) {
        this.f57257cb.setChecked(z);
    }
}
