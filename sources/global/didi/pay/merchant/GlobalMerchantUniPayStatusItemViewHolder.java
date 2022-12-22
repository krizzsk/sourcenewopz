package global.didi.pay.merchant;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lglobal/didi/pay/merchant/GlobalMerchantUniPayStatusItemViewHolder;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "getContext", "()Landroid/content/Context;", "icon", "Landroid/widget/ImageView;", "price", "Landroid/widget/TextView;", "rootViewHolder", "Landroid/view/View;", "title", "setIcon", "", "url", "", "setPrice", "content", "green", "", "setTitle", "Companion", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantUniPayStatusActivity.kt */
public final class GlobalMerchantUniPayStatusItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;
    private ImageView icon;
    private TextView price;
    private View rootViewHolder;
    private TextView title;

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lglobal/didi/pay/merchant/GlobalMerchantUniPayStatusItemViewHolder$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/merchant/GlobalMerchantUniPayStatusItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalMerchantUniPayStatusActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalMerchantUniPayStatusItemViewHolder newIns(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalMerchantUniPayStatusItemViewHolder(context, viewGroup);
        }
    }

    /* JADX WARNING: type inference failed for: r3v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GlobalMerchantUniPayStatusItemViewHolder(android.content.Context r3, android.view.ViewGroup r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r2.<init>()
            r2.context = r3
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r0 = 2131624043(0x7f0e006b, float:1.8875255E38)
            r1 = 0
            android.view.View r3 = r3.inflate(r0, r4, r1)
            r2.rootViewHolder = r3
            r4.addView(r3)
            android.view.View r3 = r2.rootViewHolder
            r4 = 0
            if (r3 != 0) goto L_0x0027
            r3 = r4
            goto L_0x0030
        L_0x0027:
            r0 = 2131435354(0x7f0b1f5a, float:1.8492548E38)
            android.view.View r3 = r3.findViewById(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0030:
            r2.title = r3
            android.view.View r3 = r2.rootViewHolder
            if (r3 != 0) goto L_0x0038
            r3 = r4
            goto L_0x0041
        L_0x0038:
            r0 = 2131435355(0x7f0b1f5b, float:1.849255E38)
            android.view.View r3 = r3.findViewById(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0041:
            r2.price = r3
            android.view.View r3 = r2.rootViewHolder
            if (r3 != 0) goto L_0x0048
            goto L_0x0052
        L_0x0048:
            r4 = 2131431964(0x7f0b121c, float:1.8485672E38)
            android.view.View r3 = r3.findViewById(r4)
            r4 = r3
            android.widget.ImageView r4 = (android.widget.ImageView) r4
        L_0x0052:
            r2.icon = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.merchant.GlobalMerchantUniPayStatusItemViewHolder.<init>(android.content.Context, android.view.ViewGroup):void");
    }

    public final Context getContext() {
        return this.context;
    }

    public final String setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        TextView textView = this.title;
        if (textView != null) {
            textView.setText(str);
        }
        return str;
    }

    public final String setPrice(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        TextView textView = this.price;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.price;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getResources().getColor(z ? R.color.oc_color_00ccaa : R.color.black));
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if ((r4.length() == 0) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setIcon(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x0006
        L_0x0004:
            r0 = 0
            goto L_0x0014
        L_0x0006:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0011
            r2 = 1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            if (r2 != 0) goto L_0x0004
        L_0x0014:
            if (r0 != 0) goto L_0x0021
            android.widget.ImageView r4 = r3.icon
            if (r4 != 0) goto L_0x001b
            goto L_0x0030
        L_0x001b:
            r0 = 8
            r4.setVisibility(r0)
            goto L_0x0030
        L_0x0021:
            android.widget.ImageView r0 = r3.icon
            if (r0 != 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r0.setVisibility(r1)
        L_0x0029:
            android.content.Context r0 = r3.context
            android.widget.ImageView r1 = r3.icon
            com.didi.payment.base.utils.GlideUtils.with2load2into(r0, r4, r1)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.merchant.GlobalMerchantUniPayStatusItemViewHolder.setIcon(java.lang.String):void");
    }
}
