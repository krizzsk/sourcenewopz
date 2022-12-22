package com.didi.soda.bill.view.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.DeliveryModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillDeliveryItemViewV2;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deliveryContent", "Landroid/widget/TextView;", "deliveryName", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "showOrHide", "isShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillDeliveryItemViewV2.kt */
public final class BillDeliveryItemViewV2 extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private TextView f39201a;

    /* renamed from: b */
    private TextView f39202b;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillDeliveryItemViewV2(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_delevery_v2, this);
        View findViewById = findViewById(R.id.customer_tv_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_name)");
        this.f39201a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_content)");
        this.f39202b = (TextView) findViewById2;
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        TextView textView = this.f39201a;
        Unit unit = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryName");
            textView = null;
        }
        textView.setText(componentModel.getName());
        TextView textView2 = this.f39202b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryContent");
            textView2 = null;
        }
        textView2.setText(componentModel.getContent());
        ComponentDataModel data = componentModel.getData();
        DeliveryModel deliveryModel = data == null ? null : data.getDeliveryModel();
        if (deliveryModel != null) {
            m27765a(true);
            setOnClickListener(new View.OnClickListener(componentModel) {
                public final /* synthetic */ ComponentModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BillDeliveryItemViewV2.m27764a(DeliveryModel.this, this.f$1, view);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m27765a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27764a(DeliveryModel deliveryModel, ComponentModel componentModel, View view) {
        List<DeliveryMethodEntity> methods;
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        String str = "";
        if (!(deliveryModel == null || (methods = deliveryModel.getMethods()) == null)) {
            for (DeliveryMethodEntity deliveryMethodEntity : methods) {
                if (deliveryMethodEntity.isSelected == 1) {
                    str = deliveryMethodEntity.remark;
                    Intrinsics.checkNotNullExpressionValue(str, "it.remark");
                }
            }
        }
        BillOmegaHelper.Companion.trackDeliveryCK(Integer.valueOf(deliveryModel.getSelectType()), componentModel.getCartId(), componentModel.getShopId(), str);
        Request.Builder path = DiRouter.request().path(RoutePath.DELIVERY_METHOD_EDIT);
        if (deliveryModel != null) {
            path.putSerializable("entity", deliveryModel).putString(Const.PageParams.SHOP_ID, componentModel.getShopId()).putString(Const.PageParams.CART_ID, componentModel.getCartId()).putInt("from", 2).open();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
    }

    /* renamed from: a */
    private final void m27765a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
