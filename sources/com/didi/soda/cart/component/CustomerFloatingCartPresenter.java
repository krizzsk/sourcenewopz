package com.didi.soda.cart.component;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.soda.cart.component.Contract;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemBaseModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.cart.model.CartTyingModel;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.cart.repo.CheckCartMaxNumKt;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoAlertEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.helper.ToastActionHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020 H\u0016J\u0006\u0010%\u001a\u00020 J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0014J\b\u0010+\u001a\u00020 H\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0003H\u0002J\u001a\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u00104\u001a\u00020\u0014H\u0002J&\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0014J\b\u00108\u001a\u00020 H\u0002J\b\u00109\u001a\u00020 H\u0016J\u0010\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00020;H\u0016J\u0010\u0010:\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010<\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010>\u001a\u00020 2\u0006\u0010!\u001a\u00020;2\u0006\u0010#\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, mo175978d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartPresenter;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartPresenter;", "shopId", "", "(Ljava/lang/String;)V", "actionType", "", "biData", "businessStatus", "cartInfoModel", "Lcom/didi/soda/cart/model/CartInfoModel;", "cartInfoResource", "Lcom/didi/soda/customer/repo/CustomerResource;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "cartItemListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "cartItemTotalAmount", "cartReversion", "firstHandleCartData", "", "firstHasCartData", "firstReceiveCartData", "isCartInfoRequestFinished", "isCartMenuShowNeed", "isCartMenuShowed", "lastHasCartData", "orderId", "sceneType", "shopHasRequestFinished", "wineConfirm", "addSku", "", "cartItemModel", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "action", "clearAllData", "getCartInfo", "handleCartInfo", "initParams", "notifyBillList", "onCreate", "onDestroy", "openCartTracker", "parseActionInfo", "bundle", "Landroid/os/Bundle;", "removeItemData", "itemId", "mduId", "showAlertAndCartMenu", "model", "isAddOrMinusItem", "showFloatingCart", "reversion", "needShowCartMenu", "subscribeCartInfo", "toBillPage", "toSkuPage", "Lcom/didi/soda/cart/model/CartItemModel;", "updateGlobalCartFlag", "cartInfoEntity", "updateSku", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartPresenter.kt */
public final class CustomerFloatingCartPresenter extends Contract.AbsFloatingCartPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CustomerFloatingCartPresenter";

    /* renamed from: a */
    private String f39899a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f39900b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CartInfoModel f39901c;

    /* renamed from: d */
    private CustomerResource<CartInfoEntity> f39902d;

    /* renamed from: e */
    private ChildDataListManager<RecyclerModel> f39903e;

    /* renamed from: f */
    private boolean f39904f;

    /* renamed from: g */
    private int f39905g = 1;

    /* renamed from: h */
    private boolean f39906h;

    /* renamed from: i */
    private boolean f39907i = true;

    /* renamed from: j */
    private int f39908j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f39909k = "";

    /* renamed from: l */
    private String f39910l;

    /* renamed from: m */
    private int f39911m;

    /* renamed from: n */
    private int f39912n;

    /* renamed from: o */
    private int f39913o;

    /* renamed from: p */
    private boolean f39914p;

    /* renamed from: q */
    private boolean f39915q;

    /* renamed from: r */
    private boolean f39916r = true;

    /* renamed from: s */
    private boolean f39917s;

    /* renamed from: t */
    private boolean f39918t;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28457a(RFDialog rFDialog) {
    }

    public CustomerFloatingCartPresenter(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        this.f39899a = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartPresenter$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerFloatingCartPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r2 = r2.getCartId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSku(com.didi.soda.cart.model.CartItemModel r20, boolean r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "cartItemModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.didi.soda.cart.model.CartInfoModel r2 = r0.f39901c
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0011
        L_0x000f:
            r8 = r3
            goto L_0x0019
        L_0x0011:
            java.lang.String r2 = r2.getCartId()
            if (r2 != 0) goto L_0x0018
            goto L_0x000f
        L_0x0018:
            r8 = r2
        L_0x0019:
            com.didi.soda.cart.model.SetItemAmountParams$Content r9 = new com.didi.soda.cart.model.SetItemAmountParams$Content
            java.lang.String r2 = r20.getMduId()
            int r4 = r20.getAmount()
            r9.<init>(r2, r4)
            com.didi.soda.cart.model.SetItemAmountParams r2 = new com.didi.soda.cart.model.SetItemAmountParams
            java.lang.String r5 = r0.f39899a
            java.lang.String r6 = r20.getItemId()
            java.lang.String r7 = r20.getItemUniqKey()
            java.lang.String r4 = r0.f39900b
            java.lang.String r10 = java.lang.String.valueOf(r4)
            java.lang.String r11 = r0.f39909k
            r12 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.didi.soda.cart.omega.FloatingCartOmegaHelper$Companion r13 = com.didi.soda.cart.omega.FloatingCartOmegaHelper.Companion
            com.didi.app.nova.skeleton.ScopeContext r4 = r19.getScopeContext()
            r5 = 0
            if (r4 != 0) goto L_0x004a
            r4 = r5
            goto L_0x0050
        L_0x004a:
            java.lang.String r6 = "PageName"
            java.lang.Object r4 = r4.getObject(r6)
        L_0x0050:
            if (r4 == 0) goto L_0x00a4
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            com.didi.soda.cart.model.CartInfoModel r4 = r0.f39901c
            if (r4 != 0) goto L_0x005b
        L_0x0059:
            r15 = r3
            goto L_0x0063
        L_0x005b:
            java.lang.String r4 = r4.getCartId()
            if (r4 != 0) goto L_0x0062
            goto L_0x0059
        L_0x0062:
            r15 = r4
        L_0x0063:
            java.lang.String r3 = r0.f39899a
            r17 = r1
            com.didi.soda.cart.model.CartItemBaseModel r17 = (com.didi.soda.cart.model.CartItemBaseModel) r17
            r16 = r3
            r18 = r21
            r13.itemAction(r14, r15, r16, r17, r18)
            java.lang.Class<com.didi.soda.manager.base.ICustomerCartManager> r3 = com.didi.soda.manager.base.ICustomerCartManager.class
            com.didi.soda.manager.base.ICustomerManager r3 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r3)
            com.didi.soda.manager.base.ICustomerCartManager r3 = (com.didi.soda.manager.base.ICustomerCartManager) r3
            r3.setItemAmount(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "updateSku: cartId:"
            r2.append(r3)
            com.didi.soda.cart.model.CartInfoModel r3 = r0.f39901c
            if (r3 != 0) goto L_0x008b
            goto L_0x008f
        L_0x008b:
            java.lang.String r5 = r3.getCartId()
        L_0x008f:
            r2.append(r5)
            java.lang.String r3 = " cartItemModel:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "CustomerFloatingCartPresenter"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29104i((java.lang.String) r2, (java.lang.String) r1)
            return
        L_0x00a4:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.component.CustomerFloatingCartPresenter.updateSku(com.didi.soda.cart.model.CartItemModel, boolean):void");
    }

    public void toSkuPage(CartTyingItemModel cartTyingItemModel) {
        String cartId;
        Intrinsics.checkNotNullParameter(cartTyingItemModel, "cartItemModel");
        Request.Builder putString = DiRouter.request().path(((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle ? RoutePath.GOODS_PURCHASE_V2 : RoutePath.GOODS_PURCHASE).setFromPage(getScopeContext()).putInt("from", 3).putString(Const.PageParams.SHOP_ID, this.f39899a).putString(Const.PageParams.ITEM_ID, cartTyingItemModel.getItemId()).putString(Const.PageParams.ITEM_UNIQ_KEY, cartTyingItemModel.getItemUniqKey());
        CartInfoModel cartInfoModel = this.f39901c;
        Object obj = null;
        putString.putString("cart_id", cartInfoModel == null ? null : cartInfoModel.getCartId()).putString(Const.PageParams.CART_REVISION, this.f39900b).putString(Const.PageParams.BIDATA, this.f39909k).putString("is_item_merge", "1").putSerializable(Const.PageParams.CART_ITEM_ENTITY, cartTyingItemModel.convertModel()).open();
        FloatingCartOmegaHelper.Companion companion = FloatingCartOmegaHelper.Companion;
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null) {
            obj = scopeContext.getObject("PageName");
        }
        if (obj != null) {
            String str = (String) obj;
            CartInfoModel cartInfoModel2 = this.f39901c;
            String str2 = "";
            if (!(cartInfoModel2 == null || (cartId = cartInfoModel2.getCartId()) == null)) {
                str2 = cartId;
            }
            companion.clickCartItem(str, str2, this.f39899a, cartTyingItemModel.getItemId());
            LogUtil.m29104i(TAG, Intrinsics.stringPlus("to SkuPage, item ID:", cartTyingItemModel.getItemId()));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void addSku(CartTyingItemModel cartTyingItemModel, boolean z) {
        Intrinsics.checkNotNullParameter(cartTyingItemModel, "cartItemModel");
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        CheckCartMaxNumKt.isReachMaxNum(scopeContext, cartTyingItemModel.getShopId(), cartTyingItemModel.getItemUniqKey(), (String) null, 1, new CustomerFloatingCartPresenter$addSku$1(cartTyingItemModel, this));
    }

    public void toSkuPage(CartItemModel cartItemModel) {
        String cartId;
        Intrinsics.checkNotNullParameter(cartItemModel, "cartItemModel");
        Request.Builder putString = DiRouter.request().path(((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle ? RoutePath.GOODS_PURCHASE_V2 : RoutePath.GOODS_PURCHASE).setFromPage(getScopeContext()).putInt("from", 3).putString(Const.PageParams.SHOP_ID, this.f39899a).putString(Const.PageParams.ITEM_ID, cartItemModel.getItemId()).putString(Const.PageParams.ITEM_UNIQ_KEY, cartItemModel.getItemUniqKey());
        CartInfoModel cartInfoModel = this.f39901c;
        Object obj = null;
        putString.putString("cart_id", cartInfoModel == null ? null : cartInfoModel.getCartId()).putString(Const.PageParams.CART_REVISION, this.f39900b).putString(Const.PageParams.BIDATA, this.f39909k).putString("is_item_merge", "1").putSerializable(Const.PageParams.CART_ITEM_ENTITY, cartItemModel.convertModel(cartItemModel)).open();
        FloatingCartOmegaHelper.Companion companion = FloatingCartOmegaHelper.Companion;
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null) {
            obj = scopeContext.getObject("PageName");
        }
        if (obj != null) {
            String str = (String) obj;
            CartInfoModel cartInfoModel2 = this.f39901c;
            String str2 = "";
            if (!(cartInfoModel2 == null || (cartId = cartInfoModel2.getCartId()) == null)) {
                str2 = cartId;
            }
            companion.clickCartItem(str, str2, this.f39899a, cartItemModel.getItemId());
            LogUtil.m29104i(TAG, Intrinsics.stringPlus("to SkuPage, item ID:", cartItemModel.getItemId()));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void toBillPage() {
        String cartId;
        Request.Builder putString = DiRouter.request().path(RoutePath.BILL_PAGE).putString(Const.PageParams.SHOP_ID, this.f39899a);
        Object object = getScopeContext().getObject("PageName");
        Object obj = null;
        String str = object instanceof String ? (String) object : null;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        Request.Builder putString2 = putString.putString("from_page", str);
        CartInfoModel cartInfoModel = this.f39901c;
        putString2.putString("cart_id", String.valueOf(cartInfoModel == null ? null : cartInfoModel.getCartId())).open();
        FloatingCartOmegaHelper.Companion companion = FloatingCartOmegaHelper.Companion;
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null) {
            obj = scopeContext.getObject("PageName");
        }
        if (obj != null) {
            String str3 = (String) obj;
            CartInfoModel cartInfoModel2 = this.f39901c;
            if (!(cartInfoModel2 == null || (cartId = cartInfoModel2.getCartId()) == null)) {
                str2 = cartId;
            }
            companion.clickCheckout(str3, str2, this.f39899a);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: a */
    private final void m28463a(String str, String str2) {
        CartInfoModel cartInfoModel = this.f39901c;
        if (cartInfoModel != null) {
            Collection cartItems = cartInfoModel.getCartItems();
            if (!(cartItems == null || cartItems.isEmpty())) {
                Iterator<CartItemBaseModel> it = cartInfoModel.getCartItems().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "this.cartItems.iterator()");
                while (it.hasNext()) {
                    CartItemBaseModel next = it.next();
                    if (Intrinsics.areEqual((Object) str, (Object) next.getItemId()) && Intrinsics.areEqual((Object) str2, (Object) next.getMduId())) {
                        it.remove();
                        ChildDataListManager<RecyclerModel> childDataListManager = this.f39903e;
                        ChildDataListManager<RecyclerModel> childDataListManager2 = null;
                        if (childDataListManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                            childDataListManager = null;
                        }
                        int count = childDataListManager.getCount();
                        if (count > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                ChildDataListManager<RecyclerModel> childDataListManager3 = this.f39903e;
                                if (childDataListManager3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                                    childDataListManager3 = null;
                                }
                                if (childDataListManager3.get(i) instanceof CartItemBaseModel) {
                                    ChildDataListManager<RecyclerModel> childDataListManager4 = this.f39903e;
                                    if (childDataListManager4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                                        childDataListManager4 = null;
                                    }
                                    RecyclerModel recyclerModel = childDataListManager4.get(i);
                                    if (recyclerModel != null) {
                                        CartItemBaseModel cartItemBaseModel = (CartItemBaseModel) recyclerModel;
                                        if (Intrinsics.areEqual((Object) str, (Object) cartItemBaseModel.getItemId()) && Intrinsics.areEqual((Object) str2, (Object) cartItemBaseModel.getMduId())) {
                                            ChildDataListManager<RecyclerModel> childDataListManager5 = this.f39903e;
                                            if (childDataListManager5 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                                            } else {
                                                childDataListManager2 = childDataListManager5;
                                            }
                                            childDataListManager2.remove(i);
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.cart.model.CartItemBaseModel");
                                    }
                                }
                                if (i2 >= count) {
                                    break;
                                }
                                i = i2;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public void clearAllData() {
        ArrayList<CartItemBaseModel> cartItems;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39903e;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
            childDataListManager = null;
        }
        childDataListManager.clear();
        CartInfoModel cartInfoModel = this.f39901c;
        if (cartInfoModel != null && (cartItems = cartInfoModel.getCartItems()) != null) {
            cartItems.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r5 = r5.getPrices();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openCartTracker() {
        /*
            r8 = this;
            com.didi.soda.cart.omega.FloatingCartOmegaHelper$Companion r0 = com.didi.soda.cart.omega.FloatingCartOmegaHelper.Companion
            com.didi.app.nova.skeleton.ScopeContext r1 = r8.getScopeContext()
            java.lang.String r2 = "PageName"
            java.lang.Object r1 = r1.getObject(r2)
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = (java.lang.String) r1
            com.didi.soda.cart.model.CartInfoModel r2 = r8.f39901c
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0018
        L_0x0016:
            r2 = r3
            goto L_0x001f
        L_0x0018:
            java.lang.String r2 = r2.getCartId()
            if (r2 != 0) goto L_0x001f
            goto L_0x0016
        L_0x001f:
            java.lang.String r3 = r8.f39899a
            int r4 = r8.f39908j
            com.didi.soda.cart.model.CartInfoModel r5 = r8.f39901c
            r6 = 0
            if (r5 != 0) goto L_0x002a
        L_0x0028:
            r5 = 0
            goto L_0x0035
        L_0x002a:
            com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoPriceEntity r5 = r5.getPrices()
            if (r5 != 0) goto L_0x0031
            goto L_0x0028
        L_0x0031:
            int r5 = r5.getCartFavorPrice()
        L_0x0035:
            int r6 = r8.f39911m
            r7 = 1
            if (r6 == r7) goto L_0x003c
            r6 = 1
            goto L_0x003d
        L_0x003c:
            r6 = 2
        L_0x003d:
            r0.showFloatingCart(r1, r2, r3, r4, r5, r6)
            return
        L_0x0041:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.component.CustomerFloatingCartPresenter.openCartTracker():void");
    }

    public void onCreate() {
        super.onCreate();
        m28464b();
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).createCartDataContext(this.f39899a);
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManager()");
        this.f39903e = createChildDataListManager;
        if (createChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
            createChildDataListManager = null;
        }
        addDataManager(createChildDataListManager);
        m28465c();
        getCartInfo();
    }

    /* renamed from: a */
    private final void m28456a() {
        if (this.f39917s != this.f39918t) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
        }
    }

    /* renamed from: b */
    private final void m28464b() {
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        this.f39910l = bundle.getString("orderId", "");
        this.f39911m = bundle.getInt("sceneType", 0);
        this.f39913o = bundle.getInt(Const.PageParams.WINE_CONFIRM, 0);
        this.f39912n = m28455a(bundle);
    }

    /* renamed from: a */
    private final int m28455a(Bundle bundle) {
        String str;
        CharSequence string = bundle.getString(Const.PageParams.ACTION_INFO);
        boolean z = true;
        if (!(string == null || string.length() == 0)) {
            str = bundle.getString(Const.PageParams.ACTION_INFO, "");
        } else {
            String string2 = bundle.getString(Const.PageParams.ACTION_INFO_DICT, "");
            Intrinsics.checkNotNullExpressionValue(string2, "info");
            str = string2.length() == 0 ? bundle.getString(Const.PageParams.ACTION_INFO_DICT2, "") : string2;
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (z) {
            return 0;
        }
        try {
            ActionInfoEntity actionInfoEntity = (ActionInfoEntity) GsonUtil.fromJson(str, ActionInfoEntity.class);
            if (actionInfoEntity == null) {
                return 0;
            }
            return actionInfoEntity.getType();
        } catch (Exception e) {
            LogUtil.m29104i(TAG, "actionInfo parse error: " + e + str);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m28456a();
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).releaseCartDataContext(this.f39899a);
        super.onDestroy();
    }

    public final void showFloatingCart(String str, int i, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "reversion");
        Intrinsics.checkNotNullParameter(str2, "biData");
        LogUtil.m29104i(TAG, "business call showFloatingCart");
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setReversion(this.f39899a, str);
        boolean z2 = true;
        this.f39904f = true;
        this.f39900b = str;
        if (str2.length() != 0) {
            z2 = false;
        }
        if (!z2) {
            this.f39909k = str2;
        }
        this.f39905g = i;
        ((Contract.AbsFloatingCartView) getLogicView()).setBusinessStatus(i);
        this.f39914p = z;
        if (this.f39906h) {
            LogUtil.m29104i(TAG, "Shopping cart request is faster than merchant request");
            m28466d();
        }
    }

    public final void getCartInfo() {
        if (1 == this.f39911m) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchCartInfoForOneMoreOrder(this.f39899a, this.f39910l, this.f39913o);
        } else {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchCartInfo(this.f39899a);
        }
    }

    /* renamed from: a */
    private final void m28462a(CartInfoEntity cartInfoEntity) {
        boolean z = cartInfoEntity != null && !CollectionsUtil.isEmpty(cartInfoEntity.getItems());
        if (this.f39916r) {
            this.f39917s = z;
        }
        this.f39918t = z;
        this.f39916r = false;
    }

    /* renamed from: c */
    private final void m28465c() {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f39899a, (Action1<CustomerResource<CartInfoEntity>>) new Action1() {
            public final void call(Object obj) {
                CustomerFloatingCartPresenter.m28459a(CustomerFloatingCartPresenter.this, (CustomerResource) obj);
            }
        });
        String str = this.f39899a;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(str, scopeContext, new Action1() {
            public final void call(Object obj) {
                CustomerFloatingCartPresenter.m28458a(CustomerFloatingCartPresenter.this, (BusinessState) obj);
            }
        });
        String str2 = this.f39899a;
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
        ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).subscribeList(str2, scopeContext2, new Action1() {
            public final void call(Object obj) {
                CustomerFloatingCartPresenter.m28460a(CustomerFloatingCartPresenter.this, (ArrayList) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28459a(CustomerFloatingCartPresenter customerFloatingCartPresenter, CustomerResource customerResource) {
        Resource.Status status;
        CartInfoEntity cartInfoEntity;
        Intrinsics.checkNotNullParameter(customerFloatingCartPresenter, "this$0");
        customerFloatingCartPresenter.f39902d = customerResource;
        ToastEntity toastEntity = null;
        if (customerResource == null) {
            status = null;
        } else {
            status = customerResource.status;
        }
        if (status != Resource.Status.LOADING) {
            customerFloatingCartPresenter.f39906h = true;
            CustomerResource<CartInfoEntity> customerResource2 = customerFloatingCartPresenter.f39902d;
            customerFloatingCartPresenter.m28462a(customerResource2 == null ? null : (CartInfoEntity) customerResource2.data);
        }
        CustomerResource<CartInfoEntity> customerResource3 = customerFloatingCartPresenter.f39902d;
        if (!(customerResource3 == null || (cartInfoEntity = (CartInfoEntity) customerResource3.data) == null)) {
            toastEntity = cartInfoEntity.getToast();
        }
        ToastActionHelper.toastAction(toastEntity, CustomerFloatingCartPresenter$subscribeCartInfo$1$1.INSTANCE);
        if (customerFloatingCartPresenter.f39904f) {
            LogUtil.m29104i(TAG, "Merchant request is faster than shopping cart request");
            customerFloatingCartPresenter.m28466d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28458a(CustomerFloatingCartPresenter customerFloatingCartPresenter, BusinessState businessState) {
        Intrinsics.checkNotNullParameter(customerFloatingCartPresenter, "this$0");
        if (businessState != null) {
            int i = businessState.shopStatus;
            customerFloatingCartPresenter.f39905g = i;
            LogUtil.m29104i(TAG, Intrinsics.stringPlus("Business state changed: ", Integer.valueOf(i)));
            ChildDataListManager<RecyclerModel> childDataListManager = customerFloatingCartPresenter.f39903e;
            if (childDataListManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                childDataListManager = null;
            }
            int count = childDataListManager.getCount();
            if (count > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    ChildDataListManager<RecyclerModel> childDataListManager2 = customerFloatingCartPresenter.f39903e;
                    if (childDataListManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                        childDataListManager2 = null;
                    }
                    RecyclerModel recyclerModel = childDataListManager2.get(i2);
                    if (recyclerModel instanceof CartItemBaseModel) {
                        ((CartItemBaseModel) recyclerModel).setShopStatus(customerFloatingCartPresenter.f39905g);
                        ChildDataListManager<RecyclerModel> childDataListManager3 = customerFloatingCartPresenter.f39903e;
                        if (childDataListManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                            childDataListManager3 = null;
                        }
                        childDataListManager3.set(i2, recyclerModel);
                    }
                    if (i3 >= count) {
                        break;
                    }
                    i2 = i3;
                }
            }
            ((Contract.AbsFloatingCartView) customerFloatingCartPresenter.getLogicView()).setBusinessStatus(customerFloatingCartPresenter.f39905g);
            customerFloatingCartPresenter.m28461a(customerFloatingCartPresenter.f39901c, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28460a(CustomerFloatingCartPresenter customerFloatingCartPresenter, ArrayList arrayList) {
        int i;
        ArrayList<CartItemBaseModel> cartItems;
        Intrinsics.checkNotNullParameter(customerFloatingCartPresenter, "this$0");
        ArrayList arrayList2 = new ArrayList();
        LogUtil.m29104i(TAG, Intrinsics.stringPlus("Floating Cart Item amount changed: ", arrayList));
        if (arrayList == null) {
            i = 0;
        } else {
            Iterator it = arrayList.iterator();
            i = 0;
            while (it.hasNext()) {
                ItemState itemState = (ItemState) it.next();
                if (itemState.amount == 0) {
                    arrayList2.add(itemState);
                }
                i += itemState.amount;
            }
        }
        if (customerFloatingCartPresenter.f39908j > 0 || i <= 0) {
            if (customerFloatingCartPresenter.f39908j <= 0 || i > 0) {
                if (!arrayList2.isEmpty()) {
                    ((Contract.AbsFloatingCartView) customerFloatingCartPresenter.getLogicView()).setSkuDeleteFlag();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ItemState itemState2 = (ItemState) it2.next();
                        String str = itemState2.itemId;
                        Intrinsics.checkNotNullExpressionValue(str, "itemState.itemId");
                        String str2 = itemState2.mduId;
                        Intrinsics.checkNotNullExpressionValue(str2, "itemState.mduId");
                        customerFloatingCartPresenter.m28463a(str, str2);
                    }
                }
                CartInfoModel cartInfoModel = customerFloatingCartPresenter.f39901c;
                if (cartInfoModel != null) {
                    ((Contract.AbsFloatingCartView) customerFloatingCartPresenter.getLogicView()).updateCartInfo(cartInfoModel, false);
                }
            } else {
                CartInfoModel cartInfoModel2 = customerFloatingCartPresenter.f39901c;
                if (!(cartInfoModel2 == null || (cartItems = cartInfoModel2.getCartItems()) == null)) {
                    cartItems.clear();
                }
                ((Contract.AbsFloatingCartView) customerFloatingCartPresenter.getLogicView()).hideAllCartView();
            }
        } else if (customerFloatingCartPresenter.f39901c != null) {
            ((Contract.AbsFloatingCartView) customerFloatingCartPresenter.getLogicView()).showBottomCartCard(false);
        }
        ((Contract.AbsFloatingCartView) customerFloatingCartPresenter.getLogicView()).updateCartTotalAmount(i);
        customerFloatingCartPresenter.f39908j = i;
    }

    /* renamed from: d */
    private final void m28466d() {
        ArrayList<CartTyingItemModel> cartItems;
        CustomerResource<CartInfoEntity> customerResource = this.f39902d;
        if (customerResource != null) {
            LogUtil.m29104i(TAG, "handleCartInfo request status: " + customerResource.status + " request message:" + customerResource.message);
            if (customerResource.status == Resource.Status.LOADING) {
                ((Contract.AbsFloatingCartView) getLogicView()).showPriceLoading();
                return;
            }
            Bundle bundle = customerResource.mExtension;
            ChildDataListManager<RecyclerModel> childDataListManager = null;
            Object obj = bundle == null ? null : bundle.get(ParamConst.ADD_OR_MINUS_ITEM);
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            CharSequence charSequence = customerResource.message;
            boolean z = true;
            if (!(charSequence == null || charSequence.length() == 0)) {
                String str = customerResource.message;
                if (!NetWorkUtils.isNetworkConnected(getContext())) {
                    str = ResourceHelper.getString(R.string.customer_net_error_tip_subtitle);
                }
                if (!(customerResource.code == 45303 || customerResource.code == 45307)) {
                    ToastUtil.showCustomerErrorToast(getScopeContext(), str);
                }
                this.f39914p = false;
            }
            ((Contract.AbsFloatingCartView) getLogicView()).hidePriceLoading();
            CartInfoEntity cartInfoEntity = (CartInfoEntity) customerResource.data;
            if (cartInfoEntity != null) {
                CartInfoModel convertModel = new CartInfoModel().convertModel(cartInfoEntity, this.f39905g);
                this.f39901c = convertModel;
                if (convertModel != null) {
                    Collection cartItems2 = convertModel.getCartItems();
                    if (!(cartItems2 == null || cartItems2.isEmpty())) {
                        ((Contract.AbsFloatingCartView) getLogicView()).setSkuDeleteFlag();
                        ChildDataListManager<RecyclerModel> childDataListManager2 = this.f39903e;
                        if (childDataListManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                            childDataListManager2 = null;
                        }
                        childDataListManager2.clear();
                        ChildDataListManager<RecyclerModel> childDataListManager3 = this.f39903e;
                        if (childDataListManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                            childDataListManager3 = null;
                        }
                        childDataListManager3.addAll(convertModel.getCartItems());
                        if (convertModel.getCartTyingModel() != null) {
                            CartTyingModel cartTyingModel = convertModel.getCartTyingModel();
                            if (cartTyingModel == null || (cartItems = cartTyingModel.getCartItems()) == null || !cartItems.isEmpty()) {
                                z = false;
                            }
                            if (!z) {
                                ChildDataListManager<RecyclerModel> childDataListManager4 = this.f39903e;
                                if (childDataListManager4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("cartItemListManager");
                                } else {
                                    childDataListManager = childDataListManager4;
                                }
                                childDataListManager.add(convertModel.getCartTyingModel());
                            }
                        }
                    }
                    ((Contract.AbsFloatingCartView) getLogicView()).updateCartInfo(convertModel, this.f39907i);
                    this.f39907i = false;
                }
                m28461a(this.f39901c, booleanValue);
                LogUtil.m29104i(TAG, Intrinsics.stringPlus("handleCartInfo data: ", this.f39901c));
            }
        }
    }

    /* renamed from: a */
    private final void m28461a(CartInfoModel cartInfoModel, boolean z) {
        boolean z2;
        if (cartInfoModel != null && !this.f39915q && this.f39905g == 1) {
            boolean z3 = false;
            if (1 == this.f39911m) {
                CartInfoAlertEntity alert = cartInfoModel.getAlert();
                String str = null;
                CharSequence content = alert == null ? null : alert.getContent();
                if (!(content == null || content.length() == 0)) {
                    CartInfoAlertEntity alert2 = cartInfoModel.getAlert();
                    DialogUtil.showErrorDialog(alert2 == null ? null : alert2.getContent(), getScopeContext(), C13516x62d4a9d5.INSTANCE);
                    FloatingCartOmegaHelper.Companion companion = FloatingCartOmegaHelper.Companion;
                    String shopId = cartInfoModel.getShopId();
                    CartInfoAlertEntity alert3 = cartInfoModel.getAlert();
                    if (alert3 != null) {
                        str = alert3.getContent();
                    }
                    companion.trackOneMoreToastSw(shopId, String.valueOf(str));
                }
                z2 = true;
            } else {
                z2 = false;
            }
            int i = this.f39912n;
            if (i == 1 || (i == 3 && z && this.f39914p)) {
                z2 = true;
            }
            if (z2) {
                Collection cartItems = cartInfoModel.getCartItems();
                if (cartItems == null || cartItems.isEmpty()) {
                    z3 = true;
                }
                if (!z3) {
                    ((Contract.AbsFloatingCartView) getLogicView()).showCartMenu();
                    this.f39915q = true;
                }
            }
        }
    }
}
