package com.didi.global.fintech.cashier.threeds.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerTitleItem;", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerBaseItem;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "bind", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData$LineData;", "initView", "layout", "", "type", "Lcom/didi/global/fintech/cashier/threeds/dialog/CVVDrawerItemType;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVDrawer.kt */
public final class CVVDrawerTitleItem extends CVVDrawerBaseItem {

    /* renamed from: a */
    private TextView f21675a;

    public int layout() {
        return R.layout.item_title_dialog_cashier_cvv;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CVVDrawerTitleItem(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    public CVVDrawerItemType type() {
        return CVVDrawerItemType.Title;
    }

    public final TextView getTitle() {
        return this.f21675a;
    }

    public final void setTitle(TextView textView) {
        this.f21675a = textView;
    }

    public void initView() {
        super.initView();
        View rootViewHolder = getRootViewHolder();
        this.f21675a = rootViewHolder == null ? null : (TextView) rootViewHolder.findViewById(R.id.tv_content);
    }

    public void bind(CVVDrawerData.LineData lineData) {
        Intrinsics.checkNotNullParameter(lineData, "data");
        TextView textView = this.f21675a;
        if (textView != null) {
            ViewKtxKt.content(textView, lineData.getContent());
        }
        TextView textView2 = this.f21675a;
        if (textView2 != null) {
            color(textView2, lineData.getTextStyle());
        }
    }
}
