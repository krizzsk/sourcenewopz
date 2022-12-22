package com.didi.soda.address.edit.component;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.address.edit.component.Contract;
import com.didi.soda.address.edit.strategy.AddressStrategyManager;
import com.didi.soda.address.manager.AddressKeyboardStatus;
import com.didi.soda.address.manager.AutoShowType;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertBtnEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

@Metadata(mo175977d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0010H\u0002J \u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J$\u00100\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u00102\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\b\u00104\u001a\u00020\u0010H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\u001c\u00107\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\b\u0010>\u001a\u00020\u0010H\u0016J \u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0018\u0010C\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0010\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u0012H\u0016J\u0018\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0012H\u0016J\b\u0010J\u001a\u00020\u0010H\u0016J\b\u0010K\u001a\u00020\u0010H\u0014J\b\u0010L\u001a\u00020\u0010H\u0016J\u0010\u0010M\u001a\u00020\u00102\b\u0010N\u001a\u0004\u0018\u00010OJ\b\u0010P\u001a\u00020\u0010H\u0014J\b\u0010Q\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u0016H\u0016J\u0012\u0010S\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010T\u001a\u00020\u00102\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\u0006H\u0002J\b\u0010[\u001a\u00020\u0010H\u0016Jf\u0010\\\u001a\u00020\u00102\b\u0010]\u001a\u0004\u0018\u00010H2\u0006\u0010^\u001a\u00020\u00122\b\u0010_\u001a\u0004\u0018\u00010H2\b\u0010`\u001a\u0004\u0018\u00010H2\u0006\u0010a\u001a\u00020\u00122\u0006\u0010b\u001a\u00020\u00122\b\u0010c\u001a\u0004\u0018\u00010H2\b\u0010d\u001a\u0004\u0018\u00010H2\b\u0010e\u001a\u0004\u0018\u00010H2\b\u0010f\u001a\u0004\u0018\u00010HH\u0003J\b\u0010g\u001a\u00020\u0010H\u0002J\u0010\u0010h\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010i\u001a\u00020\u00102\b\u0010j\u001a\u0004\u0018\u00010H2\b\u0010`\u001a\u0004\u0018\u00010HH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, mo175978d2 = {"Lcom/didi/soda/address/edit/component/EditAddressInfoPresent;", "Lcom/didi/soda/address/edit/component/Contract$AbsEditAddressInfoPresent;", "()V", "addressEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "<set-?>", "", "alreadyOperatedTips", "getAlreadyOperatedTips", "()Z", "setAlreadyOperatedTips", "(Z)V", "alreadyOperatedTips$delegate", "Lkotlin/properties/ReadWriteProperty;", "backAction", "Lkotlin/Function0;", "", "billAddressRecStrategy", "", "contactEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "editAddress", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "editAddressManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataItemManager;", "editContactManager", "emptyHeight", "enterFrom", "isBillShowAddressCard", "isCheckNameEmpty", "isCheckedAddress", "mIsAddressCheckDialogShow", "strategyManager", "Lcom/didi/soda/address/edit/strategy/AddressStrategyManager;", "confirmSaveAddress", "editAddressModel", "confirmSaveContact", "consumeRPCFailed", "type", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "enterFromShoppingCart", "freshAddressTipStatus", "alreadyOperated", "getReversePoi", "lat", "", "lng", "handleKeyboardLogic", "addressModel", "contact", "init", "initDataManagers", "isAddressClickable", "isContactShow", "isSamePoiByLatLng", "poi1", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "poi2", "isTypeAid", "isUseBillAddressStrategy", "needShowAddressTips", "onAddressClick", "onAddressPopClick", "isSkip", "hasAid", "scene", "onAddressPopShow", "onBindFinish", "height", "onCountryResult", "callingCode", "", "countryId", "onCreate", "onDestroy", "onFinish", "onPageResult", "data", "Landroid/os/Bundle;", "onResume", "resetModel", "saveAddress", "saveContact", "setBackAction", "action", "setEmptyHeight", "distance", "", "showPoiError", "isMapGesture", "traceConfirmClick", "trackAddressEdit", "aid", "actionType", "house", "buildName", "addressType", "success", "errorType", "errorMsg", "poiId", "poiType", "updateAddressView", "updateByModel", "updateHouseBuildName", "houseNumber", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoPresent.kt */
public final class EditAddressInfoPresent extends Contract.AbsEditAddressInfoPresent {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f38729a = {C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(EditAddressInfoPresent.class, "alreadyOperatedTips", "getAlreadyOperatedTips()Z", 0))};

    /* renamed from: b */
    private Function0<Unit> f38730b = EditAddressInfoPresent$backAction$1.INSTANCE;

    /* renamed from: c */
    private boolean f38731c;

    /* renamed from: d */
    private int f38732d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f38733e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final AddressStrategyManager f38734f = new AddressStrategyManager();

    /* renamed from: g */
    private ChildDataItemManager<EditAddressModel> f38735g;

    /* renamed from: h */
    private ChildDataItemManager<ContactEntity> f38736h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public EditAddressModel f38737i;

    /* renamed from: j */
    private ContactEntity f38738j;

    /* renamed from: k */
    private int f38739k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public AddressEntity f38740l;

    /* renamed from: m */
    private int f38741m;

    /* renamed from: n */
    private boolean f38742n;

    /* renamed from: o */
    private boolean f38743o;

    /* renamed from: p */
    private final ReadWriteProperty f38744p;

    /* renamed from: a */
    private final boolean m27439a(int i) {
        return 1 == i || 6 == i || 7 == i || 8 == i;
    }

    public void setEmptyHeight(float f) {
    }

    public EditAddressInfoPresent() {
        Delegates delegates = Delegates.INSTANCE;
        this.f38744p = new EditAddressInfoPresent$special$$inlined$observable$1(false, false, this);
    }

    public final boolean getAlreadyOperatedTips() {
        return ((Boolean) this.f38744p.getValue(this, f38729a[0])).booleanValue();
    }

    public final void setAlreadyOperatedTips(boolean z) {
        this.f38744p.setValue(this, f38729a[0], Boolean.valueOf(z));
    }

    public void initDataManagers() {
        super.initDataManagers();
        ChildDataItemManager<EditAddressModel> createChildDataItemManager = createChildDataItemManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataItemManager, "createChildDataItemManager()");
        this.f38735g = createChildDataItemManager;
        ChildDataItemManager<ContactEntity> createChildDataItemManager2 = createChildDataItemManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataItemManager2, "createChildDataItemManager()");
        this.f38736h = createChildDataItemManager2;
        ChildDataItemManager<EditAddressModel> childDataItemManager = this.f38735g;
        ChildDataItemManager<ContactEntity> childDataItemManager2 = null;
        if (childDataItemManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editAddressManager");
            childDataItemManager = null;
        }
        addDataManager(childDataItemManager);
        ChildDataItemManager<ContactEntity> childDataItemManager3 = this.f38736h;
        if (childDataItemManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editContactManager");
        } else {
            childDataItemManager2 = childDataItemManager3;
        }
        addDataManager(childDataItemManager2);
    }

    public void onCreate() {
        super.onCreate();
        m27429a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((Contract.AbsEditAddressInfoView) getLogicView()).centerBestView(this.f38737i, this.f38739k);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private final void m27429a() {
        AddressEntity.PoiEntity poiEntity;
        AddressEntity.PoiEntity poiEntity2;
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        this.f38740l = (AddressEntity) bundle.getSerializable(Const.PageParams.ADDRESS_ENTITY);
        this.f38737i = EditAddressModel.Companion.from(this.f38740l);
        this.f38732d = bundle.getInt("from", -1);
        this.f38738j = (ContactEntity) bundle.getSerializable(Const.PageParams.CONTACT_ENTITY);
        boolean z = false;
        this.f38741m = bundle.getInt(Const.PageParams.ADDRESS_STRATEGY, 0);
        this.f38742n = bundle.getBoolean(Const.PageParams.IS_SHOW_BILL_ADDRESS_DATA);
        boolean z2 = bundle.getBoolean(Const.PageParams.IS_FROM_BUSINESS);
        this.f38743o = getScopeContext().getBundle().getBoolean(Const.PageParams.NAME_COMPLETE_STRATEGY);
        m27430a(this.f38732d, this.f38737i, this.f38738j);
        String str = null;
        if (this.f38738j != null) {
            ChildDataItemManager<ContactEntity> childDataItemManager = this.f38736h;
            if (childDataItemManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editContactManager");
                childDataItemManager = null;
            }
            childDataItemManager.setItem(this.f38738j);
        }
        m27442b();
        this.f38734f.setFromStrategy(getScopeContext(), this.f38732d, z2);
        int i = bundle.getInt(Const.PageParams.BILL_ADDRESS_EDIT_SCENE, 0);
        if (AddressUtil.checkAddressValid(this.f38740l)) {
            AddressEntity addressEntity = this.f38740l;
            CharSequence charSequence = addressEntity == null ? null : addressEntity.aid;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            int i2 = z ? 1 : i;
            int i3 = this.f38732d;
            AddressEntity addressEntity2 = this.f38740l;
            String str2 = (addressEntity2 == null || (poiEntity2 = addressEntity2.poi) == null) ? null : poiEntity2.poiSrcTag;
            boolean needShowAddressTips = needShowAddressTips();
            AddressEntity addressEntity3 = this.f38740l;
            if (!(addressEntity3 == null || (poiEntity = addressEntity3.poi) == null)) {
                str = poiEntity.poiType;
            }
            AddressOmegaHelper.editAddressSw(i3, str2, needShowAddressTips, str, this.f38734f.getStrategy().getPromptScene(), i2);
        }
    }

    /* renamed from: a */
    private final void m27430a(int i, EditAddressModel editAddressModel, ContactEntity contactEntity) {
        AddressKeyboardStatus addressKeyboardStatus = new AddressKeyboardStatus(AutoShowType.Default, false);
        if (m27439a(i) && editAddressModel != null) {
            if (!editAddressModel.isValid()) {
                addressKeyboardStatus.setShowType(AutoShowType.Address);
            } else if (TextUtils.isEmpty(editAddressModel.getBuildingName()) || TextUtils.isEmpty(editAddressModel.getHouseNumber())) {
                addressKeyboardStatus.setShowType(AutoShowType.Address);
            } else if (contactEntity != null && (TextUtils.isEmpty(contactEntity.getFirstName()) || TextUtils.isEmpty(contactEntity.getLastName()) || TextUtils.isEmpty(contactEntity.phone))) {
                addressKeyboardStatus.setShowType(AutoShowType.Contact);
            }
        }
        getScopeContext().attach(Const.PageParams.ADDRESS_KEYBOARD_ENTITY, addressKeyboardStatus);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m27442b() {
        EditAddressModel editAddressModel = this.f38737i;
        if (editAddressModel != null) {
            if (this.f38738j != null) {
                editAddressModel.setShowImeActionNext(true);
            }
            ChildDataItemManager<EditAddressModel> childDataItemManager = this.f38735g;
            if (childDataItemManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editAddressManager");
                childDataItemManager = null;
            }
            childDataItemManager.setItem(editAddressModel);
        }
    }

    public void onCountryResult(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "callingCode");
        ContactEntity contactEntity = this.f38738j;
        if (contactEntity != null) {
            contactEntity.callingCode = str;
            contactEntity.countryId = i;
            ChildDataItemManager<ContactEntity> childDataItemManager = this.f38736h;
            if (childDataItemManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editContactManager");
                childDataItemManager = null;
            }
            childDataItemManager.setItem(contactEntity);
        }
    }

    public void onBindFinish(int i) {
        ((Contract.AbsEditAddressInfoView) getLogicView()).getNovaRecyclerView().post(new Runnable(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                EditAddressInfoPresent.m27432a(EditAddressInfoPresent.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27432a(EditAddressInfoPresent editAddressInfoPresent, int i) {
        Intrinsics.checkNotNullParameter(editAddressInfoPresent, "this$0");
        editAddressInfoPresent.f38739k = RangesKt.coerceAtLeast((((Contract.AbsEditAddressInfoView) editAddressInfoPresent.getLogicView()).getNovaRecyclerView().getHeight() - i) - editAddressInfoPresent.f38734f.getStrategy().getBottomHeight(), DisplayUtils.dip2px(editAddressInfoPresent.getContext(), 124.5f));
        ((Contract.AbsEditAddressInfoView) editAddressInfoPresent.getLogicView()).centerBestView(editAddressInfoPresent.f38737i, editAddressInfoPresent.f38739k);
        ((Contract.AbsEditAddressInfoView) editAddressInfoPresent.getLogicView()).getNovaRecyclerView().scrollToPosition(0);
    }

    public boolean isContactShow() {
        ChildDataItemManager<ContactEntity> childDataItemManager = this.f38736h;
        if (childDataItemManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editContactManager");
            childDataItemManager = null;
        }
        return childDataItemManager.size() > 0;
    }

    public void saveContact(ContactEntity contactEntity) {
        if (contactEntity != null) {
            this.f38738j = contactEntity;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAddress(com.didi.soda.address.edit.binder.EditAddressModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "addressModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            r1 = 1
            r0.element = r1
            java.lang.String r2 = r8.getHouseNumber()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            if (r2 == 0) goto L_0x001f
            int r2 = r2.length()
            if (r2 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r2 = 0
            goto L_0x0020
        L_0x001f:
            r2 = 1
        L_0x0020:
            if (r2 == 0) goto L_0x005b
            java.lang.String r2 = r8.getBuildingName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0033
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = 0
            goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            if (r2 == 0) goto L_0x005b
            boolean r2 = r7.isUseBillAddressStrategy()
            if (r2 == 0) goto L_0x004a
            r2 = 2131952039(0x7f1301a7, float:1.954051E38)
            java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
            java.lang.String r4 = "{\n                    Re…r_mbsj)\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            goto L_0x0057
        L_0x004a:
            r2 = 2131953944(0x7f130918, float:1.9544373E38)
            java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
            java.lang.String r4 = "{\n                    Re…ontent)\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
        L_0x0057:
            r4 = 3
            r0.element = r4
            goto L_0x0084
        L_0x005b:
            boolean r2 = r7.isUseBillAddressStrategy()
            if (r2 == 0) goto L_0x0086
            java.lang.String r2 = r8.getHouseNumber()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0072
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = 0
            goto L_0x0073
        L_0x0072:
            r2 = 1
        L_0x0073:
            if (r2 == 0) goto L_0x0086
            r2 = 2131952038(0x7f1301a6, float:1.9540507E38)
            java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
            java.lang.String r4 = "getString(R.string.FoodC_iterate_In_order_OzyI)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r4 = 2
            r0.element = r4
        L_0x0084:
            r4 = 1
            goto L_0x0089
        L_0x0086:
            java.lang.String r2 = ""
            r4 = 0
        L_0x0089:
            boolean r5 = r7.f38731c
            if (r5 != 0) goto L_0x00b8
            if (r4 == 0) goto L_0x00b8
            java.lang.String r4 = r8.getAid()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x009d
            int r4 = r4.length()
            if (r4 != 0) goto L_0x009e
        L_0x009d:
            r3 = 1
        L_0x009e:
            r3 = r3 ^ r1
            com.didi.app.nova.skeleton.ScopeContext r4 = r7.getScopeContext()
            com.didi.soda.address.edit.component.-$$Lambda$EditAddressInfoPresent$Cy6SV51_T7dbjVdPt35CvKOV2Ig r5 = new com.didi.soda.address.edit.component.-$$Lambda$EditAddressInfoPresent$Cy6SV51_T7dbjVdPt35CvKOV2Ig
            r5.<init>(r3, r0)
            com.didi.soda.address.edit.component.-$$Lambda$EditAddressInfoPresent$hWo4paPc8xvxFvS414PaMW-asQI r6 = new com.didi.soda.address.edit.component.-$$Lambda$EditAddressInfoPresent$hWo4paPc8xvxFvS414PaMW-asQI
            r6.<init>(r3, r0, r8)
            com.didi.soda.customer.foundation.util.DialogUtil.showAddressDetailEmptyTipDialog(r4, r2, r5, r6)
            int r8 = r0.element
            r7.m27437a((boolean) r3, (int) r8)
            r7.f38731c = r1
            goto L_0x00bb
        L_0x00b8:
            r7.m27431a((com.didi.soda.address.edit.binder.EditAddressModel) r8)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.component.EditAddressInfoPresent.saveAddress(com.didi.soda.address.edit.binder.EditAddressModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27433a(EditAddressInfoPresent editAddressInfoPresent, boolean z, Ref.IntRef intRef, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(editAddressInfoPresent, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$type");
        editAddressInfoPresent.m27438a(false, z, intRef.element);
        ((Contract.AbsEditAddressInfoView) editAddressInfoPresent.getLogicView()).hideLoading();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27434a(EditAddressInfoPresent editAddressInfoPresent, boolean z, Ref.IntRef intRef, EditAddressModel editAddressModel, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(editAddressInfoPresent, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$type");
        Intrinsics.checkNotNullParameter(editAddressModel, "$addressModel");
        editAddressInfoPresent.m27438a(true, z, intRef.element);
        editAddressInfoPresent.m27431a(editAddressModel);
    }

    public void getReversePoi(double d, double d2) {
        ((Contract.AbsEditAddressInfoView) getLogicView()).pinLoading();
        CustomerRpcManagerProxy.get().getReversePoi(d, d2, new EditAddressInfoPresent$getReversePoi$1(this, d, d2));
        if (m27439a(this.f38732d)) {
            AddressOmegaHelper.traceCartAddressLocationMoveCk();
        }
    }

    public void updateHouseBuildName(String str, String str2) {
        EditAddressModel editAddressModel;
        EditAddressModel editAddressModel2;
        if (!(str == null || (editAddressModel2 = this.f38737i) == null)) {
            editAddressModel2.setHouseNumber(str);
        }
        if (str2 != null && (editAddressModel = this.f38737i) != null) {
            editAddressModel.setBuildingName(str2);
        }
    }

    public boolean needShowAddressTips() {
        return this.f38742n && !getAlreadyOperatedTips();
    }

    public void freshAddressTipStatus(boolean z) {
        if (!getAlreadyOperatedTips()) {
            setAlreadyOperatedTips(z);
        }
    }

    public boolean isTypeAid() {
        EditAddressModel editAddressModel = this.f38737i;
        CharSequence aid = editAddressModel == null ? null : editAddressModel.getAid();
        return !(aid == null || aid.length() == 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27436a(boolean z) {
        m27442b();
        String string = ResourceHelper.getString(R.string.FoodC_toast_Unable_to_dwCf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC_toast_Unable_to_dwCf)");
        ((Contract.AbsEditAddressInfoView) getLogicView()).hidePinLoading(string, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m27441a(AddressEntity.PoiEntity poiEntity, AddressEntity.PoiEntity poiEntity2) {
        if (poiEntity == null || poiEntity2 == null) {
            return false;
        }
        return LatLngUtils.isCompletedSameLatLng(new LatLng(poiEntity.lat, poiEntity.lng), new LatLng(poiEntity2.lat, poiEntity2.lng));
    }

    public boolean isAddressClickable() {
        return this.f38734f.getStrategy().isAddressClickAble();
    }

    public boolean isUseBillAddressStrategy() {
        int i = this.f38741m;
        return i == 2 || i == 3;
    }

    public void traceConfirmClick() {
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        AddressEntity addressEntity = (AddressEntity) bundle.getSerializable(Const.PageParams.ADDRESS_ENTITY);
        if (AddressUtil.checkAddressValid(addressEntity)) {
            this.f38737i = EditAddressModel.Companion.from(addressEntity);
            int i = 0;
            if (addressEntity != null) {
                try {
                    AddressEntity.PoiEntity poiEntity = addressEntity.poi;
                    if (poiEntity != null) {
                        String str = poiEntity.poiSrcTag;
                        if (str != null) {
                            i = Integer.parseInt(str);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            AddressOmegaHelper.traceCartAddressConfirmCK(Integer.valueOf(this.f38732d), Integer.valueOf(i));
        }
    }

    public void updateByModel(EditAddressModel editAddressModel) {
        Intrinsics.checkNotNullParameter(editAddressModel, AlertBtnEntity.ACTION_EDIT_ADDRESS);
        this.f38737i = editAddressModel;
        m27442b();
    }

    public void resetModel() {
        boolean z;
        EditAddressModel editAddressModel = this.f38737i;
        Boolean valueOf = editAddressModel == null ? null : Boolean.valueOf(editAddressModel.isExpendMap());
        EditAddressModel from = EditAddressModel.Companion.from(this.f38740l);
        this.f38737i = from;
        if (from != null) {
            if (valueOf == null) {
                z = false;
            } else {
                z = valueOf.booleanValue();
            }
            from.setExpendMap(z);
        }
        m27442b();
    }

    public void onFinish() {
        this.f38730b.invoke();
        ScopeContext scopeContext = getScopeContext();
        String str = null;
        Object object = scopeContext == null ? null : scopeContext.getObject("PageName");
        if (object instanceof String) {
            str = (String) object;
        }
        OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
        if (str == null) {
            str = "";
        }
        create.addEventParam("from", str).build().track();
    }

    public void onAddressClick() {
        freshAddressTipStatus(true);
        this.f38734f.getStrategy().handleAddressClick(this.f38737i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r8 = r8.poi;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageResult(android.os.Bundle r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "entity"
            android.os.Parcelable r8 = r8.getParcelable(r0)
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r8 = (com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity) r8
            boolean r0 = com.didi.soda.address.util.AddressUtil.checkAddressValid(r8)
            if (r0 == 0) goto L_0x0047
            com.didi.soda.address.edit.binder.EditAddressModel$Companion r0 = com.didi.soda.address.edit.binder.EditAddressModel.Companion
            com.didi.soda.address.edit.binder.EditAddressModel r0 = r0.from(r8)
            r7.f38737i = r0
            r1 = 2
            r0 = 0
            if (r8 != 0) goto L_0x001f
        L_0x001d:
            r2 = r0
            goto L_0x0026
        L_0x001f:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r2 = r8.poi
            if (r2 != 0) goto L_0x0024
            goto L_0x001d
        L_0x0024:
            java.lang.String r2 = r2.poiSrcTag
        L_0x0026:
            boolean r3 = r7.needShowAddressTips()
            if (r8 != 0) goto L_0x002e
        L_0x002c:
            r4 = r0
            goto L_0x0036
        L_0x002e:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r8 = r8.poi
            if (r8 != 0) goto L_0x0033
            goto L_0x002c
        L_0x0033:
            java.lang.String r8 = r8.poiType
            r4 = r8
        L_0x0036:
            com.didi.soda.address.edit.strategy.AddressStrategyManager r8 = r7.f38734f
            com.didi.soda.address.edit.strategy.IAddressStrategy r8 = r8.getStrategy()
            int r5 = r8.getPromptScene()
            r6 = 0
            com.didi.soda.address.omega.AddressOmegaHelper.editAddressSw(r1, r2, r3, r4, r5, r6)
            r7.m27442b()
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.component.EditAddressInfoPresent.onPageResult(android.os.Bundle):void");
    }

    public final void setBackAction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.f38730b = function0;
    }

    /* renamed from: a */
    private final void m27437a(boolean z, int i) {
        AddressOmegaHelper.editAddressPopSw(z, this.f38732d, i);
    }

    /* renamed from: a */
    private final void m27438a(boolean z, boolean z2, int i) {
        AddressOmegaHelper.editAddressPopClick(z, z2, this.f38732d, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m27443c() {
        if (isContactShow()) {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).setCurrentContact(this.f38738j);
        }
    }

    /* renamed from: a */
    private final void m27431a(EditAddressModel editAddressModel) {
        String str;
        String str2;
        ContactEntity contactEntity;
        if (editAddressModel.isValid()) {
            String houseNumber = editAddressModel.getHouseNumber();
            AddressEntity.PoiEntity poiEntity = null;
            boolean z = false;
            if (houseNumber == null) {
                str = null;
            } else {
                CharSequence charSequence = houseNumber;
                int length = charSequence.length() - 1;
                int i = 0;
                boolean z2 = false;
                while (i <= length) {
                    boolean z3 = Intrinsics.compare((int) charSequence.charAt(!z2 ? i : length), 32) <= 0;
                    if (!z2) {
                        if (!z3) {
                            z2 = true;
                        } else {
                            i++;
                        }
                    } else if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                }
                str = charSequence.subSequence(i, length + 1).toString();
            }
            String buildingName = editAddressModel.getBuildingName();
            if (buildingName == null) {
                str2 = null;
            } else {
                CharSequence charSequence2 = buildingName;
                int length2 = charSequence2.length() - 1;
                int i2 = 0;
                boolean z4 = false;
                while (i2 <= length2) {
                    boolean z5 = Intrinsics.compare((int) charSequence2.charAt(!z4 ? i2 : length2), 32) <= 0;
                    if (!z4) {
                        if (!z5) {
                            z4 = true;
                        } else {
                            i2++;
                        }
                    } else if (!z5) {
                        break;
                    } else {
                        length2--;
                    }
                }
                str2 = charSequence2.subSequence(i2, length2 + 1).toString();
            }
            if (this.f38743o) {
                contactEntity = this.f38738j;
            } else {
                contactEntity = null;
            }
            ContactEntity contactEntity2 = contactEntity;
            CharSequence aid = editAddressModel.getAid();
            if (aid == null || aid.length() == 0) {
                z = true;
            }
            if (z) {
                CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
                int type = editAddressModel.getType();
                AddressEntity originAddressEntity = editAddressModel.getOriginAddressEntity();
                if (originAddressEntity != null) {
                    poiEntity = originAddressEntity.poi;
                }
                customerRpcService.createAddress(type, poiEntity, str, str2, contactEntity2, new EditAddressInfoPresent$confirmSaveAddress$1(this, editAddressModel));
                return;
            }
            CustomerRpcManagerProxy.get().updateAddress(editAddressModel.getType(), editAddressModel.getAid(), str, str2, contactEntity2, new EditAddressInfoPresent$confirmSaveAddress$2(this, editAddressModel));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        r0 = r0.poi;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m27440a(int r15, com.didi.soda.address.edit.binder.EditAddressModel r16, com.didi.soda.customer.foundation.rpc.net.SFRpcException r17) {
        /*
            r14 = this;
            r11 = r14
            com.didi.app.nova.skeleton.mvp.IView r0 = r14.getLogicView()
            com.didi.soda.address.edit.component.Contract$AbsEditAddressInfoView r0 = (com.didi.soda.address.edit.component.Contract.AbsEditAddressInfoView) r0
            r0.hideLoading()
            boolean r0 = r14.isActive()
            r12 = 0
            if (r0 != 0) goto L_0x0012
            return r12
        L_0x0012:
            java.lang.String r0 = r16.getAid()
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            java.lang.String r0 = ""
        L_0x001b:
            r1 = r0
            java.lang.String r3 = r16.getHouseNumber()
            java.lang.String r4 = r16.getBuildingName()
            int r5 = r16.getType()
            r6 = 0
            int r0 = r17.getCode()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            java.lang.String r8 = r17.getMessage()
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r0 = r16.getOriginAddressEntity()
            r13 = 0
            if (r0 != 0) goto L_0x003e
        L_0x003c:
            r9 = r13
            goto L_0x0046
        L_0x003e:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r0 = r0.poi
            if (r0 != 0) goto L_0x0043
            goto L_0x003c
        L_0x0043:
            java.lang.String r0 = r0.poiId
            r9 = r0
        L_0x0046:
            if (r16 != 0) goto L_0x004a
        L_0x0048:
            r10 = r13
            goto L_0x0059
        L_0x004a:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r0 = r16.getOriginAddressEntity()
            if (r0 != 0) goto L_0x0051
            goto L_0x0048
        L_0x0051:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r0 = r0.poi
            if (r0 != 0) goto L_0x0056
            goto L_0x0048
        L_0x0056:
            java.lang.String r0 = r0.poiType
            r10 = r0
        L_0x0059:
            r0 = r14
            r2 = r15
            r0.m27435a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r0 = r17.getCode()
            r1 = 42424(0xa5b8, float:5.9449E-41)
            if (r0 != r1) goto L_0x0084
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r0 = r11.f38738j
            if (r0 != 0) goto L_0x006c
            goto L_0x0072
        L_0x006c:
            java.lang.String r1 = r17.getMessage()
            r0.nameErrorMsg = r1
        L_0x0072:
            com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager<com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity> r0 = r11.f38736h
            if (r0 != 0) goto L_0x007c
            java.lang.String r0 = "editContactManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x007d
        L_0x007c:
            r13 = r0
        L_0x007d:
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r0 = r11.f38738j
            r13.setItem(r0)
            r12 = 1
            goto L_0x0099
        L_0x0084:
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r0 = r11.f38738j
            if (r0 != 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r0.nameErrorMsg = r13
        L_0x008b:
            com.didi.app.nova.skeleton.ScopeContext r0 = r14.getScopeContext()
            r1 = 2131953864(0x7f1308c8, float:1.9544211E38)
            java.lang.String r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r1)
            com.didi.soda.customer.foundation.util.ToastUtil.showCustomerErrorToast(r0, r1)
        L_0x0099:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.component.EditAddressInfoPresent.m27440a(int, com.didi.soda.address.edit.binder.EditAddressModel, com.didi.soda.customer.foundation.rpc.net.SFRpcException):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27435a(String str, int i, String str2, String str3, int i2, int i3, String str4, String str5, String str6, String str7) {
        int i4;
        String string = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        String string2 = getScopeContext().getBundle().getString(Const.PageParams.CART_ID);
        ContactEntity contactEntity = this.f38738j;
        String str8 = null;
        CharSequence lastName = contactEntity == null ? null : contactEntity.getLastName();
        if (lastName == null || lastName.length() == 0) {
            ContactEntity contactEntity2 = this.f38738j;
            if (contactEntity2 != null) {
                str8 = contactEntity2.getFirstName();
            }
            CharSequence charSequence = str8;
            if (charSequence == null || charSequence.length() == 0) {
                i4 = 0;
                AddressOmegaHelper.editAddress(string, string2, str, i, 1, str2, str3, i2, i3, i4, str4, str5, str6, str7);
            }
        }
        i4 = 1;
        AddressOmegaHelper.editAddress(string, string2, str, i, 1, str2, str3, i2, i3, i4, str4, str5, str6, str7);
    }
}
