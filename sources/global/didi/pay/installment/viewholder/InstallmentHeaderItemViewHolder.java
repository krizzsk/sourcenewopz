package global.didi.pay.installment.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lglobal/didi/pay/installment/viewholder/InstallmentHeaderItemViewHolder;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "getContext", "()Landroid/content/Context;", "price", "Landroid/widget/TextView;", "rootViewHolder", "Landroid/view/View;", "title", "getRootView", "setPrice", "", "content", "setTitle", "setVisible", "", "visible", "", "Companion", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InstallmentHeaderItemViewHolder.kt */
public final class InstallmentHeaderItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;
    private final TextView price;
    private final View rootViewHolder;
    private final TextView title;

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lglobal/didi/pay/installment/viewholder/InstallmentHeaderItemViewHolder$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/installment/viewholder/InstallmentHeaderItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InstallmentHeaderItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InstallmentHeaderItemViewHolder newIns(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new InstallmentHeaderItemViewHolder(context, viewGroup);
        }
    }

    public InstallmentHeaderItemViewHolder(Context context2, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.context = context2;
        View inflate = LayoutInflater.from(context2).inflate(R.layout.g_payment_activity_installment_header_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.layout.g_payment_activity_installment_header_item, parent, false)");
        this.rootViewHolder = inflate;
        View findViewById = inflate.findViewById(R.id.tv_installment_item_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootViewHolder.findViewById(R.id.tv_installment_item_tip)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.rootViewHolder.findViewById(R.id.tv_installment_item_price);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootViewHolder.findViewById(R.id.tv_installment_item_price)");
        this.price = (TextView) findViewById2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final View getRootView() {
        return this.rootViewHolder;
    }

    public final String setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.title.setText(str);
        return str;
    }

    public final String setPrice(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.price.setText(str);
        return str;
    }

    public final int setVisible(boolean z) {
        int i = z ? 0 : 4;
        this.rootViewHolder.setVisibility(i);
        return i;
    }
}
