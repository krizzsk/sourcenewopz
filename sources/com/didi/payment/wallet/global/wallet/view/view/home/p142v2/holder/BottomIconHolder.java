package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.StringWrapperSection;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/BottomIconHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/StringWrapperSection;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconImage", "Landroid/widget/ImageView;", "getViewType", "", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.BottomIconHolder */
/* compiled from: BottomIconHolder.kt */
public final class BottomIconHolder extends RecyclerView.ViewHolder implements IHomeViewHolder<StringWrapperSection> {

    /* renamed from: a */
    private final ImageView f32689a;

    public int getViewType() {
        return 8;
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomIconHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.iv_bottom_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_bottom_icon)");
        this.f32689a = (ImageView) findViewById;
    }

    public void onBindViewHolder(WalletHomeHolderData<StringWrapperSection> walletHomeHolderData) {
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        StringWrapperSection contentObj = walletHomeHolderData.getContentObj();
        boolean z = false;
        if (contentObj != null && contentObj.isTcExists()) {
            z = true;
        }
        if (!z) {
            ViewGroup.LayoutParams layoutParams = this.f32689a.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                Context context = this.itemView.getContext();
                if (context != null) {
                    layoutParams2.topMargin = UIUtil.dip2px(((ContextThemeWrapper) context).getBaseContext(), 42.0f);
                    this.f32689a.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
        Context context2 = this.itemView.getContext();
        if (context2 != null) {
            Context baseContext = ((ContextThemeWrapper) context2).getBaseContext();
            StringWrapperSection contentObj2 = walletHomeHolderData.getContentObj();
            GlideUtils.with2load2into(baseContext, contentObj2 == null ? null : contentObj2.getString(), this.f32689a);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }
}
