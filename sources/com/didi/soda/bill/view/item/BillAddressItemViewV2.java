package com.didi.soda.bill.view.item;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.didi.soda.bill.component.bill.BillWsgTouchHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020\u0018H\u0014J\b\u0010'\u001a\u00020\u0018H\u0014J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020#H\u0002J\u0010\u00100\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J(\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0016J\u0018\u00106\u001a\u00020\u00182\u0006\u0010/\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX.¢\u0006\u0002\n\u0000RB\u0010\u0011\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u00068"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillAddressItemViewV2;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addressAptBuildingTv", "Landroid/widget/TextView;", "addressDataLayout", "Landroid/view/View;", "addressEmptyLayout", "addressItemView", "addressName", "addressRecStrategy", "", "addressTag", "addressTagLayout", "clickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "from", "Landroid/os/Bundle;", "bundle", "", "contactName", "contactNameEmpty", "contactPhone", "noApartmentFloorLayout", "noApartmentFloorNewIcon", "noApartmentFloorNewTv", "initView", "isShowNewEmptyLayout", "", "model", "Lcom/didi/soda/bill/model/datamodel/AddressModel;", "needExtraPadding", "needFocusContent", "onAttachedToWindow", "onDetachedFromWindow", "performAutoClick", "type", "setBottomSinglePadding", "view", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "setContactAndAddress", "addressModel", "setData", "setPadding", "left", "top", "right", "bottom", "setRecDataStyle", "setRecDefaultStyle", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillAddressItemViewV2.kt */
public final class BillAddressItemViewV2 extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private View f39183a;

    /* renamed from: b */
    private TextView f39184b;

    /* renamed from: c */
    private TextView f39185c;

    /* renamed from: d */
    private TextView f39186d;

    /* renamed from: e */
    private TextView f39187e;

    /* renamed from: f */
    private TextView f39188f;

    /* renamed from: g */
    private View f39189g;

    /* renamed from: h */
    private TextView f39190h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f39191i;

    /* renamed from: j */
    private TextView f39192j;

    /* renamed from: k */
    private TextView f39193k;

    /* renamed from: l */
    private View f39194l;

    /* renamed from: m */
    private View f39195m;

    /* renamed from: n */
    private int f39196n;

    /* renamed from: o */
    private Function2<? super Integer, ? super Bundle, Unit> f39197o;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27756a(View view, MotionEvent motionEvent) {
        return false;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean needExtraPadding() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillAddressItemViewV2(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_address_v2, this);
        View findViewById = findViewById(R.id.customer_fl_address_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_fl_address_container)");
        this.f39183a = findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_address_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_address_name)");
        this.f39184b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_address_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_address_tag)");
        this.f39188f = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_address_tag_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_address_tag_layout)");
        this.f39189g = findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_address_sub_name);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_address_sub_name)");
        this.f39190h = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_contact_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_tv_contact_name)");
        this.f39186d = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_tv_contact_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_tv_contact_phone)");
        this.f39185c = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.customer_tv_contact_name_empty);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_tv_contact_name_empty)");
        this.f39187e = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.customer_tv_no_apartment_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_tv_no_apartment_layout)");
        this.f39191i = findViewById9;
        View findViewById10 = findViewById(R.id.customer_tv_no_apartment_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_tv_no_apartment_tv)");
        this.f39192j = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.customer_tv_no_apartment_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_tv_no_apartment_icon)");
        this.f39193k = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.customer_tv_address_empty_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.custom…_tv_address_empty_layout)");
        this.f39194l = findViewById12;
        View findViewById13 = findViewById(R.id.customer_tv_address_data_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.customer_tv_address_data_layout)");
        this.f39195m = findViewById13;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
        View view = this.f39183a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
            view = null;
        }
        view.setPadding(i, i2, i3, i4);
    }

    public boolean needFocusContent() {
        View view = this.f39194l;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressEmptyLayout");
            view = null;
        }
        if (view.getVisibility() != 0) {
            return false;
        }
        ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) getLogic();
        if (itemViewCommonLogic != null) {
            String string = ResourceHelper.getString(R.string.FoodC_I_Fill_in_CcSY);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC_I_Fill_in_CcSY)");
            itemViewCommonLogic.showToast(string);
        }
        return true;
    }

    public void performAutoClick(int i, Bundle bundle) {
        Function2<? super Integer, ? super Bundle, Unit> function2 = this.f39197o;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), bundle);
        }
    }

    /* renamed from: a */
    private final boolean m27757a(AddressModel addressModel) {
        CharSequence aid = addressModel.getAid();
        return aid == null || aid.length() == 0;
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        ComponentDataModel data = componentModel.getData();
        View view = null;
        AddressModel addressModel = data == null ? null : data.getAddressModel();
        if (addressModel != null) {
            TextView textView = this.f39184b;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressName");
                textView = null;
            }
            textView.setText(addressModel.getAddressName());
            this.f39196n = componentModel.getAddressRecStrategy();
            if (m27757a(addressModel)) {
                setRecDefaultStyle(componentModel);
            } else {
                m27754a(addressModel, componentModel);
            }
            this.f39197o = new BillAddressItemViewV2$setData$1$1(this, componentModel);
            View view2 = this.f39183a;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
            } else {
                view = view2;
            }
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BillAddressItemViewV2.m27755a(BillAddressItemViewV2.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27755a(BillAddressItemViewV2 billAddressItemViewV2, View view) {
        Intrinsics.checkNotNullParameter(billAddressItemViewV2, "this$0");
        Function2<? super Integer, ? super Bundle, Unit> function2 = billAddressItemViewV2.f39197o;
        if (function2 != null) {
            function2.invoke(0, null);
        }
    }

    private final void setContactAndAddress(AddressModel addressModel) {
        TextView textView = this.f39188f;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTag");
            textView = null;
        }
        textView.setText(addressModel.getAidTypeName());
        View view = this.f39189g;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTagLayout");
            view = null;
        }
        CharSequence aidTypeName = addressModel.getAidTypeName();
        boolean z = true;
        int i = 0;
        view.setVisibility(aidTypeName == null || aidTypeName.length() == 0 ? 8 : 0);
        TextView textView3 = this.f39185c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactPhone");
            textView3 = null;
        }
        textView3.setText(addressModel.getContactPhone());
        TextView textView4 = this.f39186d;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactName");
            textView4 = null;
        }
        textView4.setText(addressModel.getContactName());
        TextView textView5 = this.f39185c;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactPhone");
            textView5 = null;
        }
        textView5.setVisibility(0);
        TextView textView6 = this.f39186d;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactName");
            textView6 = null;
        }
        CharSequence contactName = addressModel.getContactName();
        textView6.setVisibility(contactName == null || contactName.length() == 0 ? 8 : 0);
        TextView textView7 = this.f39187e;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactNameEmpty");
            textView7 = null;
        }
        CharSequence contactName2 = addressModel.getContactName();
        textView7.setVisibility(contactName2 == null || contactName2.length() == 0 ? 0 : 8);
        View view2 = this.f39183a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
            view2 = null;
        }
        view2.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_40_corners);
        TextView textView8 = this.f39190h;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressAptBuildingTv");
            textView8 = null;
        }
        textView8.setText(addressModel.getAddressAptBuildingName());
        TextView textView9 = this.f39190h;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressAptBuildingTv");
        } else {
            textView2 = textView9;
        }
        CharSequence addressAptBuildingName = addressModel.getAddressAptBuildingName();
        if (!(addressAptBuildingName == null || addressAptBuildingName.length() == 0)) {
            z = false;
        }
        if (z) {
            i = 8;
        }
        textView2.setVisibility(i);
    }

    /* renamed from: a */
    private final void m27753a(View view, ComponentModel componentModel) {
        int i;
        if (componentModel.getCardBgType() == 0) {
            i = CustomerExtentionKt.getPx(R.dimen.rf_dimen_40);
        } else {
            i = CustomerExtentionKt.getPx(R.dimen.rf_dimen_20);
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    private final void setRecDefaultStyle(ComponentModel componentModel) {
        View view = this.f39194l;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressEmptyLayout");
            view = null;
        }
        view.setVisibility(0);
        View view3 = this.f39194l;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressEmptyLayout");
            view3 = null;
        }
        m27753a(view3, componentModel);
        View view4 = this.f39195m;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressDataLayout");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.f39183a;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
        } else {
            view2 = view5;
        }
        view2.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_bottom_40_corners);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27754a(com.didi.soda.bill.model.datamodel.AddressModel r8, com.didi.soda.bill.model.ComponentModel r9) {
        /*
            r7 = this;
            r7.setContactAndAddress(r8)
            android.view.View r0 = r7.f39195m
            java.lang.String r1 = "addressDataLayout"
            r2 = 0
            if (r0 != 0) goto L_0x000e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000e:
            r7.m27753a((android.view.View) r0, (com.didi.soda.bill.model.ComponentModel) r9)
            android.view.View r0 = r7.f39194l
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = "addressEmptyLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r2
        L_0x001b:
            r3 = 8
            r0.setVisibility(r3)
            android.view.View r0 = r7.f39195m
            if (r0 != 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0028:
            r1 = 0
            r0.setVisibility(r1)
            android.view.View r0 = r7.f39183a
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = "addressItemView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r2
        L_0x0036:
            r4 = 2131231977(0x7f0804e9, float:1.808005E38)
            r0.setBackgroundResource(r4)
            com.didi.soda.bill.model.ComponentDataModel r0 = r9.getData()
            if (r0 != 0) goto L_0x0044
            r0 = r2
            goto L_0x0048
        L_0x0044:
            com.didi.soda.bill.model.datamodel.BottomTipInfoModel r0 = r0.getBottomTipInfoModel()
        L_0x0048:
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r4 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r4 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r4)
            com.didi.soda.manager.base.ICustomerBillManager r4 = (com.didi.soda.manager.base.ICustomerBillManager) r4
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r4 = r4.getCurrentContact()
            boolean r8 = r8.isAddressClicked()
            java.lang.String r5 = "noApartmentFloorLayout"
            if (r8 == 0) goto L_0x006a
            android.view.View r8 = r7.f39191i
            if (r8 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0065
        L_0x0064:
            r2 = r8
        L_0x0065:
            r2.setVisibility(r3)
            goto L_0x0149
        L_0x006a:
            boolean r8 = r9.isCheckNameEmpty()
            java.lang.String r6 = "noApartmentFloorNewTv"
            if (r8 == 0) goto L_0x00ec
            if (r4 != 0) goto L_0x0076
            r8 = r2
            goto L_0x007a
        L_0x0076:
            java.lang.String r8 = r4.getFirstName()
        L_0x007a:
            boolean r8 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r8)
            if (r8 != 0) goto L_0x008a
            java.lang.String r8 = r4.getLastName()
            boolean r8 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r8)
            if (r8 == 0) goto L_0x00ec
        L_0x008a:
            android.widget.TextView r8 = r7.f39192j
            if (r8 != 0) goto L_0x0092
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r8 = r2
        L_0x0092:
            if (r4 != 0) goto L_0x0096
            r0 = r2
            goto L_0x009a
        L_0x0096:
            java.lang.String r0 = r4.getFirstName()
        L_0x009a:
            boolean r0 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r0)
            if (r0 == 0) goto L_0x00ae
            java.lang.String r0 = r4.getLastName()
            boolean r0 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r0)
            if (r0 == 0) goto L_0x00ae
            r0 = 2131951944(0x7f130148, float:1.9540317E38)
            goto L_0x00c3
        L_0x00ae:
            if (r4 != 0) goto L_0x00b2
            r0 = r2
            goto L_0x00b6
        L_0x00b2:
            java.lang.String r0 = r4.getFirstName()
        L_0x00b6:
            boolean r0 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r0)
            if (r0 == 0) goto L_0x00c0
            r0 = 2131951946(0x7f13014a, float:1.954032E38)
            goto L_0x00c3
        L_0x00c0:
            r0 = 2131951945(0x7f130149, float:1.9540319E38)
        L_0x00c3:
            java.lang.String r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            android.view.View r8 = r7.f39191i
            if (r8 != 0) goto L_0x00d4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x00d5
        L_0x00d4:
            r2 = r8
        L_0x00d5:
            r2.setVisibility(r1)
            com.didi.soda.bill.BillOmegaHelper$Companion r8 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r0 = r9.getCartId()
            java.lang.String r9 = r9.getShopId()
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8.traceCartAddressPromptSW(r0, r9, r1)
            goto L_0x0149
        L_0x00ec:
            if (r0 != 0) goto L_0x00f0
            r8 = r2
            goto L_0x00f4
        L_0x00f0:
            java.lang.String r8 = r0.getContent()
        L_0x00f4:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0101
            int r8 = r8.length()
            if (r8 != 0) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r8 = 0
            goto L_0x0102
        L_0x0101:
            r8 = 1
        L_0x0102:
            if (r8 != 0) goto L_0x013d
            android.view.View r8 = r7.f39191i
            if (r8 != 0) goto L_0x010c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r8 = r2
        L_0x010c:
            r8.setVisibility(r1)
            android.widget.TextView r8 = r7.f39192j
            if (r8 != 0) goto L_0x0117
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r8 = r2
        L_0x0117:
            if (r0 != 0) goto L_0x011b
            r1 = r2
            goto L_0x011f
        L_0x011b:
            java.lang.String r1 = r0.getContent()
        L_0x011f:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
            com.didi.soda.bill.BillOmegaHelper$Companion r8 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r1 = r9.getCartId()
            java.lang.String r9 = r9.getShopId()
            if (r0 != 0) goto L_0x0131
            goto L_0x0139
        L_0x0131:
            int r0 = r0.getType()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
        L_0x0139:
            r8.traceCartAddressPromptSW(r1, r9, r2)
            goto L_0x0149
        L_0x013d:
            android.view.View r8 = r7.f39191i
            if (r8 != 0) goto L_0x0145
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0146
        L_0x0145:
            r2 = r8
        L_0x0146:
            r2.setVisibility(r3)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillAddressItemViewV2.m27754a(com.didi.soda.bill.model.datamodel.AddressModel, com.didi.soda.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (BillWsgTouchHelper.Companion.getInstance().getAddressTouch() != null) {
            View view = this.f39183a;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
                view = null;
            }
            view.setOnTouchListener(BillWsgTouchHelper.Companion.getInstance().getAddressTouch());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        View view = this.f39183a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
            view = null;
        }
        view.setOnTouchListener($$Lambda$BillAddressItemViewV2$gUXgD7OZ2JQF2QpcC2q5JoFleo.INSTANCE);
        super.onDetachedFromWindow();
    }
}
