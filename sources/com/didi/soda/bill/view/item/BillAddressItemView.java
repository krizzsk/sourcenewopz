package com.didi.soda.bill.view.item;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.didi.soda.bill.component.bill.BillWsgTouchHelper;
import com.didi.soda.bill.model.BillFocusHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.bill.widgets.CustomerBillAddressBlackTipsLayout;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.cart.CustomerMaxCartAddressTagView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020\u001cH\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0016J\b\u0010-\u001a\u00020\u001cH\u0014J\b\u0010.\u001a\u00020\u001cH\u0014J\u001a\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001c2\u0006\u00102\u001a\u00020*H\u0002J\u0010\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020(H\u0002J\u000e\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020!J\u0018\u0010;\u001a\u00020\u001c2\u0006\u00102\u001a\u00020*2\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010<\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000RB\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006="}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillAddressItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addressAptBuildingTv", "Landroid/widget/TextView;", "addressDataLayout", "Landroid/view/View;", "addressEmptyLayout", "addressItemView", "addressName", "addressRecStrategy", "", "addressTag", "Lcom/didi/soda/customer/widget/cart/CustomerMaxCartAddressTagView;", "addressTitle", "addressTitleIcon", "blackTipsLayout", "Lcom/didi/soda/bill/widgets/CustomerBillAddressBlackTipsLayout;", "clickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "from", "Landroid/os/Bundle;", "bundle", "", "contactName", "contactNameEmpty", "contactPhone", "goToEditPageListener", "Landroid/view/View$OnClickListener;", "noApartmentFloorLayout", "noApartmentFloorNewIcon", "noApartmentFloorNewTv", "noApartmentFloorTv", "initView", "isShowNewEmptyLayout", "", "model", "Lcom/didi/soda/bill/model/datamodel/AddressModel;", "needExtraPadding", "needFocusContent", "onAttachedToWindow", "onDetachedFromWindow", "performAutoClick", "type", "setContactAndAddress", "addressModel", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "setDataStyle", "setDefaultStyle", "isFocus", "setGotoEditListener", "listener", "setRecDataStyle", "setRecDefaultStyle", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillAddressItemView.kt */
public final class BillAddressItemView extends BillItemView<ItemViewCommonLogic> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f39164a;

    /* renamed from: b */
    private TextView f39165b;

    /* renamed from: c */
    private View f39166c;

    /* renamed from: d */
    private TextView f39167d;

    /* renamed from: e */
    private TextView f39168e;

    /* renamed from: f */
    private TextView f39169f;

    /* renamed from: g */
    private TextView f39170g;

    /* renamed from: h */
    private CustomerMaxCartAddressTagView f39171h;

    /* renamed from: i */
    private TextView f39172i;

    /* renamed from: j */
    private TextView f39173j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f39174k;

    /* renamed from: l */
    private TextView f39175l;

    /* renamed from: m */
    private TextView f39176m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CustomerBillAddressBlackTipsLayout f39177n;

    /* renamed from: o */
    private View f39178o;

    /* renamed from: p */
    private View f39179p;

    /* renamed from: q */
    private int f39180q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View.OnClickListener f39181r;

    /* renamed from: s */
    private Function2<? super Integer, ? super Bundle, Unit> f39182s;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27751a(View view, MotionEvent motionEvent) {
        return false;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean needExtraPadding() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillAddressItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_address, this);
        View findViewById = findViewById(R.id.customer_fl_address_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_fl_address_container)");
        this.f39164a = findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_to);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_to)");
        this.f39165b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_address_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_address_name)");
        this.f39167d = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_address_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_address_tag)");
        this.f39171h = (CustomerMaxCartAddressTagView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_address_sub_name);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_address_sub_name)");
        this.f39172i = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_contact_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_tv_contact_name)");
        this.f39169f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_tv_contact_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_tv_contact_phone)");
        this.f39168e = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.customer_tv_contact_name_empty);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_tv_contact_name_empty)");
        this.f39170g = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.customer_tv_no_apartment_floor);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_tv_no_apartment_floor)");
        this.f39173j = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.customer_tv_no_apartment_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_tv_no_apartment_layout)");
        this.f39174k = findViewById10;
        View findViewById11 = findViewById(R.id.customer_tv_no_apartment_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_tv_no_apartment_tv)");
        this.f39175l = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.customer_tv_no_apartment_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.customer_tv_no_apartment_icon)");
        this.f39176m = (TextView) findViewById12;
        View findViewById13 = findViewById(R.id.customer_tv_address_empty_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.custom…_tv_address_empty_layout)");
        this.f39178o = findViewById13;
        View findViewById14 = findViewById(R.id.customer_tv_address_data_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.customer_tv_address_data_layout)");
        this.f39179p = findViewById14;
        View findViewById15 = findViewById(R.id.customer_tv_to_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.customer_tv_to_icon)");
        this.f39166c = findViewById15;
        View findViewById16 = findViewById(R.id.customer_bill_address_black_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.custom…ill_address_black_layout)");
        this.f39177n = (CustomerBillAddressBlackTipsLayout) findViewById16;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean needFocusContent() {
        /*
            r4 = this;
            int r0 = r4.f39180q
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0030
            android.view.View r0 = r4.f39178o
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "addressEmptyLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0047
            com.didi.soda.bill.view.item.logic.ItemViewAbsLogic r0 = r4.getLogic()
            com.didi.soda.bill.view.item.logic.ItemViewCommonLogic r0 = (com.didi.soda.bill.view.item.logic.ItemViewCommonLogic) r0
            if (r0 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            r1 = 2131951934(0x7f13013e, float:1.9540297E38)
            java.lang.String r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r1)
            java.lang.String r3 = "getString(R.string.FoodC_I_Fill_in_CcSY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r0.showToast(r1)
        L_0x002f:
            return r2
        L_0x0030:
            android.widget.TextView r0 = r4.f39168e
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = "contactPhone"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x003b
        L_0x003a:
            r1 = r0
        L_0x003b:
            int r0 = r1.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0047
            r4.setDefaultStyle(r2)
            return r2
        L_0x0047:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillAddressItemView.needFocusContent():boolean");
    }

    public void performAutoClick(int i, Bundle bundle) {
        Function2<? super Integer, ? super Bundle, Unit> function2 = this.f39182s;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), bundle);
        }
    }

    /* renamed from: a */
    private final boolean m27752a(AddressModel addressModel) {
        AddressEntity addressEntity = null;
        CharSequence aid = addressModel == null ? null : addressModel.getAid();
        if (!(aid == null || aid.length() == 0)) {
            int i = this.f39180q;
            if (i == 0 || i == 3) {
                return false;
            }
            if (addressModel != null) {
                addressEntity = addressModel.getRecAddressEntity();
            }
            if (addressEntity != null) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        TextView textView = this.f39165b;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTitle");
            textView = null;
        }
        textView.setText(componentModel.getName());
        ComponentDataModel data = componentModel.getData();
        AddressModel addressModel = data == null ? null : data.getAddressModel();
        boolean z = false;
        if (addressModel != null) {
            TextView textView3 = this.f39167d;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressName");
                textView3 = null;
            }
            textView3.setText(addressModel.getAddressName());
            int addressRecStrategy = componentModel.getAddressRecStrategy();
            this.f39180q = addressRecStrategy;
            if (addressRecStrategy == 0) {
                CharSequence addressName = addressModel.getAddressName();
                if (addressName == null || addressName.length() == 0) {
                    setDefaultStyle(componentModel.getSectionIndex() == BillFocusHelper.Companion.getNeedFocusIndex());
                } else {
                    setDataStyle(addressModel);
                }
            } else if (m27752a(addressModel)) {
                setRecDefaultStyle(componentModel);
            } else {
                m27749a(addressModel, componentModel);
            }
            this.f39182s = new BillAddressItemView$setData$1$1(this, componentModel);
            View view = this.f39164a;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BillAddressItemView.m27750a(BillAddressItemView.this, view);
                }
            });
        }
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        TextView textView4 = this.f39167d;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView4 = null;
        }
        TextView textView5 = this.f39167d;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
        } else {
            textView2 = textView5;
        }
        CharSequence text = textView2.getText();
        if (text == null || text.length() == 0) {
            z = true;
        }
        iToolsService.setTypeface(textView4, z ? IToolsService.FontType.LIGHT : IToolsService.FontType.MEDIUM);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27750a(BillAddressItemView billAddressItemView, View view) {
        Intrinsics.checkNotNullParameter(billAddressItemView, "this$0");
        Function2<? super Integer, ? super Bundle, Unit> function2 = billAddressItemView.f39182s;
        if (function2 != null) {
            function2.invoke(0, null);
        }
    }

    private final void setDefaultStyle(boolean z) {
        View view = this.f39178o;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressEmptyLayout");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.f39179p;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressDataLayout");
            view3 = null;
        }
        view3.setVisibility(0);
        if (z) {
            TextView textView = this.f39167d;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressName");
                textView = null;
            }
            textView.setHintTextColor(ResourceHelper.getColor(R.color.rf_color_alert_red_100_FF4E45));
        } else {
            TextView textView2 = this.f39167d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressName");
                textView2 = null;
            }
            textView2.setHintTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        }
        CustomerMaxCartAddressTagView customerMaxCartAddressTagView = this.f39171h;
        if (customerMaxCartAddressTagView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTag");
            customerMaxCartAddressTagView = null;
        }
        customerMaxCartAddressTagView.setVisibility(8);
        TextView textView3 = this.f39168e;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactPhone");
            textView3 = null;
        }
        textView3.setVisibility(8);
        TextView textView4 = this.f39169f;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactName");
            textView4 = null;
        }
        textView4.setVisibility(8);
        TextView textView5 = this.f39170g;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactNameEmpty");
            textView5 = null;
        }
        textView5.setVisibility(8);
        TextView textView6 = this.f39172i;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressAptBuildingTv");
            textView6 = null;
        }
        textView6.setVisibility(8);
        TextView textView7 = this.f39173j;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noApartmentFloorTv");
            textView7 = null;
        }
        textView7.setVisibility(8);
        View view4 = this.f39164a;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
        } else {
            view2 = view4;
        }
        view2.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_bottom_12_corners);
    }

    private final void setContactAndAddress(AddressModel addressModel) {
        CustomerMaxCartAddressTagView customerMaxCartAddressTagView = this.f39171h;
        TextView textView = null;
        if (customerMaxCartAddressTagView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTag");
            customerMaxCartAddressTagView = null;
        }
        customerMaxCartAddressTagView.setText(addressModel.getAidTypeName());
        CustomerMaxCartAddressTagView customerMaxCartAddressTagView2 = this.f39171h;
        if (customerMaxCartAddressTagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTag");
            customerMaxCartAddressTagView2 = null;
        }
        CharSequence aidTypeName = addressModel.getAidTypeName();
        boolean z = true;
        int i = 0;
        customerMaxCartAddressTagView2.setVisibility(aidTypeName == null || aidTypeName.length() == 0 ? 8 : 0);
        TextView textView2 = this.f39168e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactPhone");
            textView2 = null;
        }
        textView2.setText(addressModel.getContactPhone());
        TextView textView3 = this.f39169f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactName");
            textView3 = null;
        }
        textView3.setText(addressModel.getContactName());
        TextView textView4 = this.f39168e;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactPhone");
            textView4 = null;
        }
        textView4.setVisibility(0);
        TextView textView5 = this.f39169f;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactName");
            textView5 = null;
        }
        CharSequence contactName = addressModel.getContactName();
        textView5.setVisibility(contactName == null || contactName.length() == 0 ? 8 : 0);
        TextView textView6 = this.f39170g;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactNameEmpty");
            textView6 = null;
        }
        CharSequence contactName2 = addressModel.getContactName();
        textView6.setVisibility(contactName2 == null || contactName2.length() == 0 ? 0 : 8);
        View view = this.f39164a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
            view = null;
        }
        view.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_12_corners);
        TextView textView7 = this.f39172i;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressAptBuildingTv");
            textView7 = null;
        }
        textView7.setText(addressModel.getAddressAptBuildingName());
        TextView textView8 = this.f39172i;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressAptBuildingTv");
        } else {
            textView = textView8;
        }
        CharSequence addressAptBuildingName = addressModel.getAddressAptBuildingName();
        if (!(addressAptBuildingName == null || addressAptBuildingName.length() == 0)) {
            z = false;
        }
        if (z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    private final void setDataStyle(AddressModel addressModel) {
        setContactAndAddress(addressModel);
        View view = this.f39178o;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressEmptyLayout");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.f39179p;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressDataLayout");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.f39174k;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noApartmentFloorLayout");
            view3 = null;
        }
        view3.setVisibility(8);
        CharSequence buildingName = addressModel.getBuildingName();
        boolean z = true;
        if (buildingName == null || StringsKt.isBlank(buildingName)) {
            CharSequence houseNumber = addressModel.getHouseNumber();
            if (houseNumber != null && !StringsKt.isBlank(houseNumber)) {
                z = false;
            }
            if (z) {
                TextView textView2 = this.f39173j;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noApartmentFloorTv");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(0);
                return;
            }
        }
        TextView textView3 = this.f39173j;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noApartmentFloorTv");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.getAddressModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setRecDefaultStyle(com.didi.soda.bill.model.ComponentModel r9) {
        /*
            r8 = this;
            com.didi.soda.bill.model.ComponentDataModel r0 = r9.getData()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0014
        L_0x0009:
            com.didi.soda.bill.model.datamodel.AddressModel r0 = r0.getAddressModel()
            if (r0 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r0 = r0.getRecAddressEntity()
        L_0x0014:
            int r2 = r9.getAddressRecStrategy()
            com.didi.soda.bill.view.item.logic.ItemViewAbsLogic r3 = r8.getLogic()
            com.didi.soda.bill.view.item.logic.ItemViewCommonLogic r3 = (com.didi.soda.bill.view.item.logic.ItemViewCommonLogic) r3
            if (r3 != 0) goto L_0x0022
        L_0x0020:
            r3 = r1
            goto L_0x002f
        L_0x0022:
            com.didi.app.nova.skeleton.ScopeContext r3 = r3.getScopeContext()
            if (r3 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            java.lang.String r4 = "PageName"
            java.lang.Object r3 = r3.getObject(r4)
        L_0x002f:
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L_0x0036
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0037
        L_0x0036:
            r3 = r1
        L_0x0037:
            android.view.View r4 = r8.f39178o
            if (r4 != 0) goto L_0x0041
            java.lang.String r4 = "addressEmptyLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x0041:
            r5 = 0
            r4.setVisibility(r5)
            android.view.View r4 = r8.f39179p
            if (r4 != 0) goto L_0x004f
            java.lang.String r4 = "addressDataLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x004f:
            r6 = 8
            r4.setVisibility(r6)
            android.view.View r4 = r8.f39164a
            if (r4 != 0) goto L_0x005e
            java.lang.String r4 = "addressItemView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x005e:
            r7 = 2131231978(0x7f0804ea, float:1.8080052E38)
            r4.setBackgroundResource(r7)
            java.lang.String r4 = "blackTipsLayout"
            if (r0 == 0) goto L_0x0095
            java.lang.String r7 = r0.aid
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0077
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r7 = 0
            goto L_0x0078
        L_0x0077:
            r7 = 1
        L_0x0078:
            if (r7 != 0) goto L_0x0095
            r7 = 2
            if (r2 != r7) goto L_0x0095
            com.didi.soda.bill.widgets.CustomerBillAddressBlackTipsLayout r2 = r8.f39177n
            if (r2 != 0) goto L_0x0085
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r1
        L_0x0085:
            r2.setData(r9, r0, r3)
            com.didi.soda.bill.widgets.CustomerBillAddressBlackTipsLayout r9 = r8.f39177n
            if (r9 != 0) goto L_0x0090
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0091
        L_0x0090:
            r1 = r9
        L_0x0091:
            r1.setVisibility(r5)
            goto L_0x00a1
        L_0x0095:
            com.didi.soda.bill.widgets.CustomerBillAddressBlackTipsLayout r9 = r8.f39177n
            if (r9 != 0) goto L_0x009d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x009e
        L_0x009d:
            r1 = r9
        L_0x009e:
            r1.setVisibility(r6)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillAddressItemView.setRecDefaultStyle(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27749a(com.didi.soda.bill.model.datamodel.AddressModel r8, com.didi.soda.bill.model.ComponentModel r9) {
        /*
            r7 = this;
            r7.setContactAndAddress(r8)
            android.view.View r8 = r7.f39178o
            r0 = 0
            if (r8 != 0) goto L_0x000e
            java.lang.String r8 = "addressEmptyLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r0
        L_0x000e:
            r1 = 8
            r8.setVisibility(r1)
            android.view.View r8 = r7.f39179p
            if (r8 != 0) goto L_0x001d
            java.lang.String r8 = "addressDataLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r0
        L_0x001d:
            r2 = 0
            r8.setVisibility(r2)
            android.view.View r8 = r7.f39166c
            if (r8 != 0) goto L_0x002b
            java.lang.String r8 = "addressTitleIcon"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r0
        L_0x002b:
            r8.setVisibility(r1)
            android.widget.TextView r8 = r7.f39165b
            if (r8 != 0) goto L_0x0038
            java.lang.String r8 = "addressTitle"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r0
        L_0x0038:
            r8.setVisibility(r1)
            android.view.View r8 = r7.f39164a
            if (r8 != 0) goto L_0x0045
            java.lang.String r8 = "addressItemView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r0
        L_0x0045:
            r3 = 2131231976(0x7f0804e8, float:1.8080048E38)
            r8.setBackgroundResource(r3)
            android.widget.TextView r8 = r7.f39173j
            if (r8 != 0) goto L_0x0055
            java.lang.String r8 = "noApartmentFloorTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r0
        L_0x0055:
            r8.setVisibility(r1)
            com.didi.soda.bill.model.ComponentDataModel r8 = r9.getData()
            if (r8 != 0) goto L_0x0060
            r8 = r0
            goto L_0x0064
        L_0x0060:
            com.didi.soda.bill.model.datamodel.BottomTipInfoModel r8 = r8.getBottomTipInfoModel()
        L_0x0064:
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r3 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r3 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r3)
            com.didi.soda.manager.base.ICustomerBillManager r3 = (com.didi.soda.manager.base.ICustomerBillManager) r3
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r3 = r3.getCurrentContact()
            boolean r4 = r9.isCheckNameEmpty()
            java.lang.String r5 = "noApartmentFloorNewTv"
            java.lang.String r6 = "noApartmentFloorLayout"
            if (r4 == 0) goto L_0x00f4
            if (r3 != 0) goto L_0x007e
            r4 = r0
            goto L_0x0082
        L_0x007e:
            java.lang.String r4 = r3.getFirstName()
        L_0x0082:
            boolean r4 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r4)
            if (r4 != 0) goto L_0x0092
            java.lang.String r4 = r3.getLastName()
            boolean r4 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r4)
            if (r4 == 0) goto L_0x00f4
        L_0x0092:
            android.widget.TextView r8 = r7.f39175l
            if (r8 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r8 = r0
        L_0x009a:
            if (r3 != 0) goto L_0x009e
            r1 = r0
            goto L_0x00a2
        L_0x009e:
            java.lang.String r1 = r3.getFirstName()
        L_0x00a2:
            boolean r1 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r1)
            if (r1 == 0) goto L_0x00b6
            java.lang.String r1 = r3.getLastName()
            boolean r1 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r1)
            if (r1 == 0) goto L_0x00b6
            r1 = 2131951944(0x7f130148, float:1.9540317E38)
            goto L_0x00cb
        L_0x00b6:
            if (r3 != 0) goto L_0x00ba
            r1 = r0
            goto L_0x00be
        L_0x00ba:
            java.lang.String r1 = r3.getFirstName()
        L_0x00be:
            boolean r1 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.isNameNullOrEmpty(r1)
            if (r1 == 0) goto L_0x00c8
            r1 = 2131951946(0x7f13014a, float:1.954032E38)
            goto L_0x00cb
        L_0x00c8:
            r1 = 2131951945(0x7f130149, float:1.9540319E38)
        L_0x00cb:
            java.lang.String r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
            android.view.View r8 = r7.f39174k
            if (r8 != 0) goto L_0x00dc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x00dd
        L_0x00dc:
            r0 = r8
        L_0x00dd:
            r0.setVisibility(r2)
            com.didi.soda.bill.BillOmegaHelper$Companion r8 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r0 = r9.getCartId()
            java.lang.String r9 = r9.getShopId()
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8.traceCartAddressPromptSW(r0, r9, r1)
            goto L_0x0151
        L_0x00f4:
            if (r8 != 0) goto L_0x00f8
            r3 = r0
            goto L_0x00fc
        L_0x00f8:
            java.lang.String r3 = r8.getContent()
        L_0x00fc:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0109
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0107
            goto L_0x0109
        L_0x0107:
            r3 = 0
            goto L_0x010a
        L_0x0109:
            r3 = 1
        L_0x010a:
            if (r3 != 0) goto L_0x0145
            android.view.View r1 = r7.f39174k
            if (r1 != 0) goto L_0x0114
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r1 = r0
        L_0x0114:
            r1.setVisibility(r2)
            android.widget.TextView r1 = r7.f39175l
            if (r1 != 0) goto L_0x011f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r0
        L_0x011f:
            if (r8 != 0) goto L_0x0123
            r2 = r0
            goto L_0x0127
        L_0x0123:
            java.lang.String r2 = r8.getContent()
        L_0x0127:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            com.didi.soda.bill.BillOmegaHelper$Companion r1 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r2 = r9.getCartId()
            java.lang.String r9 = r9.getShopId()
            if (r8 != 0) goto L_0x0139
            goto L_0x0141
        L_0x0139:
            int r8 = r8.getType()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
        L_0x0141:
            r1.traceCartAddressPromptSW(r2, r9, r0)
            goto L_0x0151
        L_0x0145:
            android.view.View r8 = r7.f39174k
            if (r8 != 0) goto L_0x014d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x014e
        L_0x014d:
            r0 = r8
        L_0x014e:
            r0.setVisibility(r1)
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillAddressItemView.m27749a(com.didi.soda.bill.model.datamodel.AddressModel, com.didi.soda.bill.model.ComponentModel):void");
    }

    public final void setGotoEditListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.f39181r = onClickListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (BillWsgTouchHelper.Companion.getInstance().getAddressTouch() != null) {
            View view = this.f39164a;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
                view = null;
            }
            view.setOnTouchListener(BillWsgTouchHelper.Companion.getInstance().getAddressTouch());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        View view = this.f39164a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
            view = null;
        }
        view.setOnTouchListener($$Lambda$BillAddressItemView$zizDYiFvo_lI2aFRCUpbabL8mLg.INSTANCE);
        super.onDetachedFromWindow();
    }
}
