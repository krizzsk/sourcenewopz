package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.ResourceStateData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.FreezeInterceptor;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/ResourceStateData;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivBanner", "Landroid/widget/ImageView;", "tvDesc", "Landroid/widget/TextView;", "tvTitle", "getViewType", "", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.BannerViewHolder */
/* compiled from: BannerViewHolder.kt */
public final class BannerViewHolder extends RecyclerView.ViewHolder implements IHomeViewHolder<ResourceStateData> {

    /* renamed from: a */
    private final TextView f32686a;

    /* renamed from: b */
    private final TextView f32687b;

    /* renamed from: c */
    private final ImageView f32688c;

    public int getViewType() {
        return 4;
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_title)");
        this.f32686a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_desc)");
        this.f32687b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_banner)");
        this.f32688c = (ImageView) findViewById3;
    }

    public void onBindViewHolder(WalletHomeHolderData<ResourceStateData> walletHomeHolderData) {
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        ResourceStateData contentObj = walletHomeHolderData.getContentObj();
        if (contentObj != null) {
            this.f32686a.setText(contentObj.getTitle());
            this.f32687b.setText(contentObj.getSubTitle());
            String color = contentObj.getColor();
            boolean areEqual = Intrinsics.areEqual((Object) color, (Object) "dark");
            int i = R.color.wallet_color_FFFFFF;
            if (areEqual) {
                i = R.color.wallet_color_000000;
            } else {
                boolean areEqual2 = Intrinsics.areEqual((Object) color, (Object) "light");
            }
            int color2 = ContextCompat.getColor(this.itemView.getContext(), i);
            this.f32686a.setTextColor(color2);
            this.f32687b.setTextColor(color2);
            String image = contentObj.getImage();
            if (image != null) {
                GlideUtils.loadRoundImage(this.itemView.getContext(), image, 15, this.f32688c);
            }
            this.itemView.setOnClickListener(new View.OnClickListener(contentObj) {
                public final /* synthetic */ ResourceStateData f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BannerViewHolder.m23123a(BannerViewHolder.this, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23123a(BannerViewHolder bannerViewHolder, ResourceStateData resourceStateData, View view) {
        Intrinsics.checkNotNullParameter(bannerViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(resourceStateData, "$this_apply");
        FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, bannerViewHolder.itemView.getContext(), 2, false, new BannerViewHolder$onBindViewHolder$1$2$1(resourceStateData, bannerViewHolder), 4, (Object) null);
    }
}
