package com.didi.global.fintech.cashier.threeds.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerImagesItem;", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerBaseItem;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "container", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "bind", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$LineData;", "initView", "layout", "", "type", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVDrawer.kt */
public final class CVVDrawerImagesItem extends CVVDrawerBaseItem {

    /* renamed from: a */
    private ViewGroup f21674a;

    public int layout() {
        return R.layout.item_images_dialog_cashier_cvv;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CVVDrawerImagesItem(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    public CVVDrawerItemType type() {
        return CVVDrawerItemType.Images;
    }

    public final ViewGroup getContainer() {
        return this.f21674a;
    }

    public final void setContainer(ViewGroup viewGroup) {
        this.f21674a = viewGroup;
    }

    public void initView() {
        super.initView();
        View rootViewHolder = getRootViewHolder();
        this.f21674a = rootViewHolder == null ? null : (ViewGroup) rootViewHolder.findViewById(R.id.ll_nsv_center);
    }

    public void bind(CVVDrawerData.LineData lineData) {
        Intrinsics.checkNotNullParameter(lineData, "data");
        List<CVVDrawerData.ImageData> images = lineData.getImages();
        if (images != null) {
            for (CVVDrawerData.ImageData imageData : images) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_image_dialog_cashier_cvv, getContainer(), false);
                if (inflate != null) {
                    ImageView imageView = (ImageView) inflate;
                    size(imageView, lineData.getImageStyle());
                    ViewKtxKt.load(imageView, imageData.getImg());
                    ViewGroup container = getContainer();
                    if (container != null) {
                        container.addView(imageView);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
            }
        }
    }
}
