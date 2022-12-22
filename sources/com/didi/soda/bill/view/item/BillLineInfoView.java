package com.didi.soda.bill.view.item;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.BillLineModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillLineInfoView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lineView", "Landroid/view/View;", "getLineView", "()Landroid/view/View;", "setLineView", "(Landroid/view/View;)V", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillLineInfoView.kt */
public final class BillLineInfoView extends BillItemView<ItemViewCommonLogic> {
    public View lineView;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillLineInfoView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final View getLineView() {
        View view = this.lineView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lineView");
        return null;
    }

    public final void setLineView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.lineView = view;
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_line_info, this);
        View findViewById = findViewById(R.id.customer_bill_line);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_bill_line)");
        setLineView(findViewById);
    }

    public void setData(ComponentModel componentModel) {
        BillLineModel lineModel;
        Integer num;
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        ComponentDataModel data = componentModel.getData();
        if (data != null && (lineModel = data.getLineModel()) != null) {
            try {
                num = Integer.valueOf(Color.parseColor(lineModel.getColor()));
            } catch (Exception unused) {
                num = null;
            }
            if (num != null) {
                getLineView().setBackgroundColor(num.intValue());
            }
        }
    }
}
