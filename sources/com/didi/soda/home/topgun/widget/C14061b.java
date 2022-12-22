package com.didi.soda.home.topgun.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.home.topgun.model.FilterModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeFilterResetHolder;", "Lcom/didi/soda/home/topgun/widget/FilterListHolder;", "root", "Landroid/view/ViewGroup;", "resId", "", "(Landroid/view/ViewGroup;I)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "bindData", "", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.widget.b */
/* compiled from: HomeFilterLayout.kt */
final class C14061b extends FilterListHolder {

    /* renamed from: a */
    private final TextView f43208a;

    /* renamed from: b */
    private final ImageView f43209b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C14061b(ViewGroup viewGroup, int i) {
        super(viewGroup, i);
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        View findViewById = this.itemView.findViewById(R.id.customer_home_reset_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.customer_home_reset_tv)");
        this.f43208a = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.customer_home_reset_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…customer_home_reset_icon)");
        this.f43209b = (ImageView) findViewById2;
    }

    /* renamed from: a */
    public final TextView mo108144a() {
        return this.f43208a;
    }

    /* renamed from: b */
    public final ImageView mo108145b() {
        return this.f43209b;
    }

    public void bindData(FilterModel filterModel) {
        Intrinsics.checkNotNullParameter(filterModel, "filterModel");
        this.f43208a.setText(filterModel.getCurrentHeaderLine());
        FlyImageLoader.loadImage1x1(this.itemView.getContext(), filterModel.mSelectedImage).fitCenter().dontAnimate().into(this.f43209b);
    }
}
