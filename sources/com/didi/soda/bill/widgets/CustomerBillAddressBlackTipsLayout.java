package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillRefreshEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/CustomerBillAddressBlackTipsLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setData", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "addressEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "fromPage", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillAddressBlackTipsLayout.kt */
public final class CustomerBillAddressBlackTipsLayout extends FrameLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomerBillAddressBlackTipsLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomerBillAddressBlackTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerBillAddressBlackTipsLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBillAddressBlackTipsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_item_bill_address_black_tips, this);
    }

    public final void setData(ComponentModel componentModel, AddressEntity addressEntity, String str) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        Intrinsics.checkNotNullParameter(addressEntity, "addressEntity");
        boolean z = true;
        BillOmegaHelper.Companion.traceCartRecommendBubbleSW(componentModel.getCartId(), componentModel.getShopId(), str, 1);
        AddressModel addressModel = new AddressModel();
        StringBuilder sb = new StringBuilder();
        sb.append(addressEntity.poi.displayName);
        String buildNameAndApt = addressEntity.getBuildNameAndApt();
        if (buildNameAndApt != null) {
            if (!(buildNameAndApt.length() == 0)) {
                sb.append(" ");
                sb.append(buildNameAndApt);
            }
        }
        ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_apartment)).setText(sb);
        CharSequence contactName = addressModel.getContactName();
        if (contactName == null || contactName.length() == 0) {
            ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_name)).setVisibility(8);
        } else {
            ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_name)).setVisibility(0);
            ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_name)).setText(addressModel.getContactName());
        }
        CharSequence contactPhone = addressModel.getContactPhone();
        if (!(contactPhone == null || contactPhone.length() == 0)) {
            z = false;
        }
        if (z) {
            ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_phone)).setVisibility(8);
        } else {
            ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_phone)).setVisibility(0);
            ((RFTextView) findViewById(R.id.customer_bill_address_black_tips_phone)).setText(addressModel.getContactPhone());
        }
        ((RFIconView) findViewById(R.id.customer_bill_address_black_tips_close)).setOnClickListener(new View.OnClickListener(str, this) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ CustomerBillAddressBlackTipsLayout f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CustomerBillAddressBlackTipsLayout.m27816a(ComponentModel.this, this.f$1, this.f$2, view);
            }
        });
        setOnClickListener(new View.OnClickListener(str, addressEntity) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ AddressEntity f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CustomerBillAddressBlackTipsLayout.m27817a(ComponentModel.this, this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27816a(ComponentModel componentModel, String str, CustomerBillAddressBlackTipsLayout customerBillAddressBlackTipsLayout, View view) {
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Intrinsics.checkNotNullParameter(customerBillAddressBlackTipsLayout, "this$0");
        BillOmegaHelper.Companion.traceCartRecommendBubbleCancel(componentModel.getCartId(), componentModel.getShopId(), str, 1);
        customerBillAddressBlackTipsLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27817a(ComponentModel componentModel, String str, AddressEntity addressEntity, View view) {
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Intrinsics.checkNotNullParameter(addressEntity, "$addressEntity");
        BillOmegaHelper.Companion.traceCartRecommendBubbleCK(componentModel.getCartId(), componentModel.getShopId(), str, 1);
        BillRefreshEntity billRefreshEntity = new BillRefreshEntity(2);
        billRefreshEntity.setAddressEntity(addressEntity);
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billRefreshEntity);
    }
}
