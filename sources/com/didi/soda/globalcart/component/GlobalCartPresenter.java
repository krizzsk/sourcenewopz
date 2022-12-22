package com.didi.soda.globalcart.component;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.model.datamodel.ShopInfoModel;
import com.didi.soda.business.BusinessOpen;
import com.didi.soda.customer.app.ApplicationForegroundListener;
import com.didi.soda.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.globalcart.component.Contract;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.globalcart.model.BillInfoRvModel;
import com.didi.soda.globalcart.omega.GlobalCartOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J1\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0014J\b\u0010\u001e\u001a\u00020\fH\u0014J\b\u0010\u001f\u001a\u00020\fH\u0002J\u0018\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/GlobalCartPresenter;", "Lcom/didi/soda/globalcart/component/Contract$AbsGlobalCartPresenter;", "()V", "foregroundListener", "Lcom/didi/soda/customer/app/ApplicationForegroundListener;", "globalCartListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "isAbnormalViewShown", "", "onBecomeBackground", "fetchBillListInfo", "", "handleResponse", "listInfo", "Lcom/didi/soda/globalcart/entity/BillListInfoEntity;", "initDataManagers", "onCartItemCheckoutClick", "shopId", "", "cartId", "onCartItemRemoveClick", "onCartItemShopClick", "businessType", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "onClickBack", "onCreate", "onDestroy", "onResume", "resetDataManager", "showAbnormalView", "type", "Lcom/didi/soda/globalcart/component/GlobalCartPresenter$ErrorType;", "errorMsg", "Companion", "ErrorType", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartPresenter.kt */
public final class GlobalCartPresenter extends Contract.AbsGlobalCartPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "GlobalCartPresenter";

    /* renamed from: a */
    private ChildDataListManager<RecyclerModel> f42284a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f42285b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f42286c;

    /* renamed from: d */
    private ApplicationForegroundListener f42287d = new GlobalCartPresenter$foregroundListener$1(this);

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/GlobalCartPresenter$ErrorType;", "", "(Ljava/lang/String;I)V", "NO_NETWORK", "NO_SERVICE", "NO_DATA", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCartPresenter.kt */
    private enum ErrorType {
        NO_NETWORK,
        NO_SERVICE,
        NO_DATA
    }

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCartPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorType.values().length];
            iArr[ErrorType.NO_NETWORK.ordinal()] = 1;
            iArr[ErrorType.NO_DATA.ordinal()] = 2;
            iArr[ErrorType.NO_SERVICE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/GlobalCartPresenter$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCartPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onClickBack() {
        getScopeContext().getNavigator().finish();
        Object object = getScopeContext().getObject("PageName");
        new GlobalCartOmegaHelper().trackBackCk(object instanceof String ? (String) object : null);
    }

    public void onCreate() {
        super.onCreate();
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f42287d);
    }

    public void initDataManagers() {
        super.initDataManagers();
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManager()");
        this.f42284a = createChildDataListManager;
        if (createChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
            createChildDataListManager = null;
        }
        addDataManager(createChildDataListManager);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f42286c) {
            m29794a();
        }
        this.f42286c = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f42287d);
    }

    /* renamed from: a */
    private final void m29794a() {
        LogUtil.m29104i(TAG, "fetchBillListInfo");
        ((Contract.AbsGlobalCartView) getLogicView()).showLoadingView();
        if (this.f42285b) {
            m29798b();
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchGlobalCartList(new GlobalCartPresenter$fetchBillListInfo$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29797a(BillListInfoEntity billListInfoEntity) {
        m29798b();
        ArrayList arrayList = new ArrayList();
        Collection bills = billListInfoEntity.getBills();
        if (!(bills == null || bills.isEmpty())) {
            Iterator<BillInfoEntity> it = billListInfoEntity.getBills().iterator();
            while (it.hasNext()) {
                BillInfoEntity next = it.next();
                BillInfoRvModel.Companion companion = BillInfoRvModel.Companion;
                Intrinsics.checkNotNullExpressionValue(next, "billInfo");
                arrayList.add(companion.convert(next, 1));
            }
            ChildDataListManager<RecyclerModel> childDataListManager = this.f42284a;
            if (childDataListManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
                childDataListManager = null;
            }
            childDataListManager.addAll(arrayList);
            this.f42285b = false;
            new GlobalCartOmegaHelper().trackGlobalCartSw(billListInfoEntity.getBills());
        }
    }

    /* renamed from: b */
    private final void m29798b() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42284a;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
            childDataListManager = null;
        }
        childDataListManager.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29795a(ErrorType errorType, String str) {
        m29798b();
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        topGunAbnormalRvModel.mHeight = ((Contract.AbsGlobalCartView) getLogicView()).calculateAbnormalHeight();
        int i = WhenMappings.$EnumSwitchMapping$0[errorType.ordinal()];
        if (i == 1) {
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    GlobalCartPresenter.m29796a(GlobalCartPresenter.this, view);
                }
            }));
        } else if (i == 2) {
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildGlobalCartNoData());
        } else if (i == 3) {
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    GlobalCartPresenter.m29799b(GlobalCartPresenter.this, view);
                }
            }));
        }
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42284a;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
            childDataListManager = null;
        }
        childDataListManager.add(topGunAbnormalRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29796a(GlobalCartPresenter globalCartPresenter, View view) {
        Intrinsics.checkNotNullParameter(globalCartPresenter, "this$0");
        globalCartPresenter.m29794a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m29799b(GlobalCartPresenter globalCartPresenter, View view) {
        Intrinsics.checkNotNullParameter(globalCartPresenter, "this$0");
        globalCartPresenter.m29794a();
    }

    public void onCartItemRemoveClick(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, Const.BundleKey.CART_ID);
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).clearGlobalCartItem(str, new GlobalCartPresenter$onCartItemRemoveClick$1());
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42284a;
        ChildDataListManager<RecyclerModel> childDataListManager2 = null;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
            childDataListManager = null;
        }
        int count = childDataListManager.getCount();
        if (count > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ChildDataListManager<RecyclerModel> childDataListManager3 = this.f42284a;
                if (childDataListManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
                    childDataListManager3 = null;
                }
                RecyclerModel recyclerModel = childDataListManager3.get(i);
                BillInfoRvModel billInfoRvModel = recyclerModel instanceof BillInfoRvModel ? (BillInfoRvModel) recyclerModel : null;
                if (billInfoRvModel == null) {
                    str2 = null;
                } else {
                    str2 = billInfoRvModel.getCartId();
                }
                if (Intrinsics.areEqual((Object) str2, (Object) str)) {
                    ChildDataListManager<RecyclerModel> childDataListManager4 = this.f42284a;
                    if (childDataListManager4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
                        childDataListManager4 = null;
                    }
                    childDataListManager4.remove(i);
                } else if (i2 >= count) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        ChildDataListManager<RecyclerModel> childDataListManager5 = this.f42284a;
        if (childDataListManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
        } else {
            childDataListManager2 = childDataListManager5;
        }
        if (childDataListManager2.getCount() == 0) {
            m29795a(ErrorType.NO_DATA, "");
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
        }
    }

    public void onCartItemShopClick(String str, String str2, Integer num, String str3) {
        int i;
        String str4;
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        BusinessOpen create = BusinessOpen.Companion.create(str);
        if (num == null) {
            i = 1;
        } else {
            i = num.intValue();
        }
        create.businessType(i).url(str3).open();
        int i2 = 0;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42284a;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
            childDataListManager = null;
        }
        int count = childDataListManager.getCount();
        int i3 = -1;
        if (count > 0) {
            while (true) {
                int i4 = i2 + 1;
                ChildDataListManager<RecyclerModel> childDataListManager2 = this.f42284a;
                if (childDataListManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
                    childDataListManager2 = null;
                }
                RecyclerModel recyclerModel = childDataListManager2.get(i2);
                BillInfoRvModel billInfoRvModel = recyclerModel instanceof BillInfoRvModel ? (BillInfoRvModel) recyclerModel : null;
                if (billInfoRvModel == null) {
                    str4 = null;
                } else {
                    str4 = billInfoRvModel.getCartId();
                }
                if (Intrinsics.areEqual((Object) str4, (Object) str2)) {
                    ShopInfoModel shopInfo = billInfoRvModel.getShopInfo();
                    if (shopInfo != null) {
                        i3 = shopInfo.getCShopStatus();
                    }
                } else if (i4 >= count) {
                    break;
                } else {
                    i2 = i4;
                }
            }
            new GlobalCartOmegaHelper().trackGlobalCartShopCk(str, str2, i3, i2);
        }
        i2 = -1;
        new GlobalCartOmegaHelper().trackGlobalCartShopCk(str, str2, i3, i2);
    }

    public void onCartItemCheckoutClick(String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        Request.Builder putString = DiRouter.request().path(RoutePath.BILL_PAGE).putString(Const.PageParams.SHOP_ID, str);
        ScopeContext scopeContext = getScopeContext();
        Object object = scopeContext == null ? null : scopeContext.getObject("PageName");
        String str4 = object instanceof String ? (String) object : null;
        if (str4 == null) {
            str4 = "";
        }
        putString.putString("from_page", str4).putString("cart_id", str2).putString("scene", "7").open();
        int i = -1;
        int i2 = 0;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42284a;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
            childDataListManager = null;
        }
        int count = childDataListManager.getCount();
        if (count > 0) {
            while (true) {
                int i3 = i2 + 1;
                ChildDataListManager<RecyclerModel> childDataListManager2 = this.f42284a;
                if (childDataListManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("globalCartListManager");
                    childDataListManager2 = null;
                }
                RecyclerModel recyclerModel = childDataListManager2.get(i2);
                BillInfoRvModel billInfoRvModel = recyclerModel instanceof BillInfoRvModel ? (BillInfoRvModel) recyclerModel : null;
                if (billInfoRvModel == null) {
                    str3 = null;
                } else {
                    str3 = billInfoRvModel.getCartId();
                }
                if (Intrinsics.areEqual((Object) str3, (Object) str2)) {
                    i = i2;
                }
                if (i3 >= count) {
                    break;
                }
                i2 = i3;
            }
        }
        new GlobalCartOmegaHelper().trackGlobalCartItemCheckoutCk(str, str2, i);
    }
}
