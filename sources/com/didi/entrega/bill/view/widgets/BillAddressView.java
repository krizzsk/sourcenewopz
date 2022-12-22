package com.didi.entrega.bill.view.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.entrega.bill.model.AddressModel;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/widgets/BillAddressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAddress", "Lcom/didi/entrega/bill/model/AddressModel;", "getData", "setData", "", "address", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillAddressView.kt */
public final class BillAddressView extends ConstraintLayout {

    /* renamed from: a */
    private AddressModel f19604a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillAddressView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillAddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillAddressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillAddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.entrega_bill_address_layout, this);
    }

    public final AddressModel getData() {
        return this.f19604a;
    }

    public final void setData(AddressModel addressModel) {
        Unit unit;
        this.f19604a = addressModel;
        if (addressModel == null) {
            unit = null;
        } else {
            if (addressModel.getMarkerLabel().length() == 0) {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_mark_view)).setVisibility(8);
            } else {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_mark_view)).setVisibility(0);
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_mark_view)).setText(addressModel.getMarkerLabel());
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_mark_view)).setBackgroundResource(addressModel.getMarkerBg());
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_mark_view)).setTextColor(addressModel.getMarkerLabelColor());
            }
            ((CustomerAppCompatTextView) findViewById(R.id.bill_address_name_view)).setText(addressModel.getDisplayAddress());
            ((CustomerAppCompatTextView) findViewById(R.id.bill_address_name_view)).setTextColor(addressModel.getDisplayAddressTextColor());
            ((CustomerAppCompatTextView) findViewById(R.id.bill_address_name_view)).setTextSize((float) addressModel.getDisplayAddressTextSize());
            if (TextUtils.isEmpty(addressModel.getFloorInfo())) {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_floor_view)).setVisibility(8);
            } else {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_floor_view)).setVisibility(0);
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_floor_view)).setText(addressModel.getFloorInfo());
            }
            if (TextUtils.isEmpty(addressModel.getContactInfo())) {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_person_view)).setVisibility(8);
            } else {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_person_view)).setVisibility(0);
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_person_view)).setText(addressModel.getContactInfo());
            }
            if (TextUtils.isEmpty(addressModel.getPhoneInfo())) {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_phone_view)).setVisibility(8);
            } else {
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_phone_view)).setVisibility(0);
                String phoneInfo = addressModel.getPhoneInfo();
                if (((CustomerAppCompatTextView) findViewById(R.id.bill_address_person_view)).getVisibility() == 0) {
                    phoneInfo = Intrinsics.stringPlus(" ", phoneInfo);
                }
                ((CustomerAppCompatTextView) findViewById(R.id.bill_address_phone_view)).setText(phoneInfo);
            }
            setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BillAddressView.m14629a(AddressModel.this, view);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14629a(AddressModel addressModel, View view) {
        Function1<View, Unit> onAddressClick = addressModel.getOnAddressClick();
        if (onAddressClick != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            onAddressClick.invoke(view);
        }
    }
}
