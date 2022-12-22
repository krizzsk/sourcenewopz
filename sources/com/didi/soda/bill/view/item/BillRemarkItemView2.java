package com.didi.soda.bill.view.item;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillRemarkItemView2;", "Lcom/didi/soda/bill/view/item/BillSimpleItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRemarkItemView2.kt */
public final class BillRemarkItemView2 extends BillSimpleItemView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillRemarkItemView2(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillRemarkItemView2(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillRemarkItemView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        super.initView();
        updateIcon(CustomerExtentionKt.getString(R.string.rf_icon_v3_outlined_feedback));
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        super.setData(componentModel);
        String content = componentModel.getContent();
        CharSequence charSequence = content;
        if (!(charSequence == null || charSequence.length() == 0) && (Intrinsics.areEqual((Object) charSequence, (Object) "null") ^ true)) {
            Intrinsics.checkNotNull(content);
            updateTitle(content);
            activeSelf(true);
            return;
        }
        activeSelf(false);
    }
}
