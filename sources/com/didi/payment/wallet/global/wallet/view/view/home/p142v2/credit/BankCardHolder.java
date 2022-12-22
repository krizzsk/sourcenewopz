package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "tvCard", "Landroid/widget/TextView;", "getTvCard", "()Landroid/widget/TextView;", "tvDesc", "getTvDesc", "tvExpired", "getTvExpired", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardHolder */
/* compiled from: BankCardAdapter.kt */
public final class BankCardHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final ImageView f32671a;

    /* renamed from: b */
    private final TextView f32672b;

    /* renamed from: c */
    private final TextView f32673c;

    /* renamed from: d */
    private final TextView f32674d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankCardHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_icon)");
        this.f32671a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_card);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_card)");
        this.f32672b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_desc)");
        this.f32673c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_expired);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_expired)");
        this.f32674d = (TextView) findViewById4;
    }

    public final ImageView getIvIcon() {
        return this.f32671a;
    }

    public final TextView getTvCard() {
        return this.f32672b;
    }

    public final TextView getTvDesc() {
        return this.f32673c;
    }

    public final TextView getTvExpired() {
        return this.f32674d;
    }
}
