package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.BannerViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.BottomIconHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.ProtocolViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.ThreeInLineViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TitleViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TwoInLineViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.WalletHomeEmptyHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletViewHolderFactory;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletViewHolderFactory */
/* compiled from: WalletViewHolderFactory.kt */
public final class WalletViewHolderFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletViewHolderFactory$Companion;", "", "()V", "findViewHolderByType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "inflaterView", "Landroid/view/View;", "context", "Landroid/content/Context;", "layoutId", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletViewHolderFactory$Companion */
    /* compiled from: WalletViewHolderFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecyclerView.ViewHolder findViewHolderByType(ViewGroup viewGroup, int i, WalletHomeContract.V2Listener v2Listener) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            switch (i) {
                case 1:
                    Context context = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                    return new TopCardViewHolder(inflaterView(context, viewGroup, R.layout.item_home_top_card_view), v2Listener);
                case 2:
                    Context context2 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                    return new ThreeInLineViewHolder(inflaterView(context2, viewGroup, R.layout.item_home_three_in_line_view), v2Listener);
                case 3:
                    Context context3 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
                    return new TwoInLineViewHolder(inflaterView(context3, viewGroup, R.layout.item_home_two_in_line_view));
                case 4:
                    Context context4 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
                    return new BannerViewHolder(inflaterView(context4, viewGroup, R.layout.item_home_banner_view));
                case 5:
                    Context context5 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
                    return new TitleViewHolder(inflaterView(context5, viewGroup, R.layout.item_home_title_view));
                case 6:
                    Context context6 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context6, "parent.context");
                    return new ProtocolViewHolder(inflaterView(context6, viewGroup, R.layout.item_home_protocol));
                case 7:
                    Context context7 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context7, "parent.context");
                    return new WalletHomeEmptyHolder(inflaterView(context7, viewGroup, R.layout.item_home_empty), v2Listener);
                case 8:
                    Context context8 = viewGroup.getContext();
                    Intrinsics.checkNotNullExpressionValue(context8, "parent.context");
                    return new BottomIconHolder(inflaterView(context8, viewGroup, R.layout.item_home_bottom_icon));
                default:
                    return new WalletViewHolderFactory$Companion$findViewHolderByType$1(new View(viewGroup.getContext()));
            }
        }

        private final View inflaterView(Context context, ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(layoutId, parent, false)");
            return inflate;
        }
    }
}
