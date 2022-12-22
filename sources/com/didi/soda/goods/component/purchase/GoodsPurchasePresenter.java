package com.didi.soda.goods.component.purchase;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.cart.repo.CheckCartMaxNumKt;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillAddTyingEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillDelItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillRefreshEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillUpdateParams;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.helper.ToastActionHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.goods.binder.EmptyHeightBinder;
import com.didi.soda.goods.component.purchase.Contract;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.goods.helper.GoodsOmegaHelper;
import com.didi.soda.goods.helper.GoodsPurchaseOmegaModel;
import com.didi.soda.goods.manager.GoodsDetailRepo;
import com.didi.soda.goods.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goods.model.GoodsPurchaseCounterRvModel;
import com.didi.soda.goods.model.GoodsPurchaseHeaderRvModel;
import com.didi.soda.goods.model.GoodsPurchaseSubItemRvModel;
import com.didi.soda.goods.parser.SelectItemStateParser;
import com.didi.soda.goods.price.BuyGiftGoodsPriceCalculator;
import com.didi.soda.goods.price.GoodsPriceCalculator;
import com.didi.soda.goods.price.NoOpGoodsPriceCalculator;
import com.didi.soda.goods.price.NormalGoodsPriceCalculator;
import com.didi.soda.goods.price.SpecialGoodsPriceCalculator;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.taxis99.R;
import didinet.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class GoodsPurchasePresenter extends Contract.AbsGoodsPurchasePresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private static final String f42370a = "GoodsPurchasePresenter";

    /* renamed from: A */
    private String f42371A = "";

    /* renamed from: B */
    private boolean f42372B = false;

    /* renamed from: C */
    private String f42373C;

    /* renamed from: D */
    private GoodsDetailRepo f42374D;

    /* renamed from: E */
    private Subscription f42375E;

    /* renamed from: F */
    private ActInfoEntity f42376F;

    /* renamed from: G */
    private String f42377G;

    /* renamed from: b */
    private CartItemEntity f42378b;

    /* renamed from: c */
    private GoodsItemEntity f42379c;

    /* renamed from: d */
    private boolean f42380d = false;

    /* renamed from: e */
    private ChildDataItemManager<GoodsPurchaseCounterRvModel> f42381e;

    /* renamed from: f */
    private GoodsPurchaseCounterRvModel f42382f;

    /* renamed from: g */
    private GoodsAmountModel f42383g;

    /* renamed from: h */
    private String f42384h;

    /* renamed from: i */
    private String f42385i;

    /* renamed from: j */
    private String f42386j;

    /* renamed from: k */
    private int f42387k;

    /* renamed from: l */
    private int f42388l;

    /* renamed from: m */
    private String f42389m = "";

    /* renamed from: n */
    private String f42390n;

    /* renamed from: o */
    private String f42391o = "";

    /* renamed from: p */
    private int f42392p = 0;

    /* renamed from: q */
    private int f42393q;

    /* renamed from: r */
    private int f42394r = 1;

    /* renamed from: s */
    private boolean f42395s = false;

    /* renamed from: t */
    private boolean f42396t;

    /* renamed from: u */
    private int f42397u;

    /* renamed from: v */
    private int f42398v = Integer.MAX_VALUE;

    /* renamed from: w */
    private int f42399w;

    /* renamed from: x */
    private GoodsOmegaHelper f42400x;

    /* renamed from: y */
    private String f42401y;

    /* renamed from: z */
    private String f42402z;

    /* renamed from: d */
    private String m29867d(String str) {
        return str == null ? "" : str;
    }

    public void exceedMaxAmount(int i) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).exceedMaxAmount(i);
    }

    public void exceedMaxSaleAmount(int i) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).exceedMaxSaleAmount(i);
    }

    public void exceedMinAmount() {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).exceedMinAmount();
    }

    public void onAddCartViewClicked(boolean z) {
        if (!z) {
            anchorToUnSatisfiedContent();
        } else if (this.f42380d) {
            m29855a(this.f42373C);
        } else {
            m29849a();
        }
    }

    public void replaceSubItemState(SelectSubItemState selectSubItemState) {
        SelectItemStateParser.replaceSubItemState(this.mStateUniqueId, (SelectSubItemState) null, selectSubItemState);
    }

    public SelectSubItemState findSelectSubItemState(String str) {
        return SelectItemStateParser.getSubItemState(this.mStateUniqueId, getLevel(), str);
    }

    public void onCloseClicked() {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        super.onCloseClicked();
    }

    public void onSelectionStateChanged(String str, String str2, boolean z) {
        super.onSelectionStateChanged(str, str2, z);
        GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
        m29889t().onSubItemClick(goodsPurchaseOmegaModel.mCurContentId, goodsPurchaseOmegaModel.mCurContentType, goodsPurchaseOmegaModel.mValidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mInvalidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mCurSelectedSubItemId, goodsPurchaseOmegaModel.mSelectType, goodsPurchaseOmegaModel.mCurContentIsMust, goodsPurchaseOmegaModel.mCurSelectedSubItemType, goodsPurchaseOmegaModel.mIsMultiLevel);
    }

    public void onAddGoodsClick(String str, View view, Bundle bundle) {
        if (this.f42383g != null) {
            m29847a("onAddGoodsClick", "c-act|").build().info();
            this.f42383g.increaseAmount(1);
            m29874f();
            this.f42382f.mBuyTip = m29883n();
            this.f42382f.mReceviedGiftLimit = m29886q();
            this.f42381e.setItem(this.f42382f);
            changeOfflinePrice();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m29887r());
        }
    }

    public void onSubtractGoodsClick(String str, Bundle bundle) {
        if (this.f42383g != null) {
            m29847a("onSubtractGoodsClick", "c-act|").build().info();
            this.f42383g.decreaseAmount(1);
            m29874f();
            this.f42382f.mBuyTip = m29883n();
            this.f42382f.mReceviedGiftLimit = m29886q();
            this.f42381e.setItem(this.f42382f);
            changeOfflinePrice();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m29887r());
        }
    }

    public void onBack(Bundle bundle) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        if (bundle != null) {
            dismiss(getScopeContext(), bundle);
        } else {
            dismiss(getScopeContext());
        }
    }

    public void onCreate() {
        super.onCreate();
        m29847a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
        m29875g();
        m29879j();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m29847a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).clearSelectItemState(this.mStateUniqueId);
        m29889t().onPurchaseExit(this.mGoodsPurchaseOmegaModel.mHasMultiContents);
    }

    /* access modifiers changed from: protected */
    public void changeOfflinePrice() {
        if (!this.notNeedClientCal) {
            if (this.mGoodsPriceCalculator == null) {
                m29847a("mGoodsPriceCalculator == null", "c-show|").build().info();
                return;
            }
            List<SelectSubItemState> filterCalculatePriceStates = SelectItemStateParser.filterCalculatePriceStates(this.mSelectedSubItemStates.values());
            int calculateCurPriceWithStates = this.mGoodsPriceCalculator.calculateCurPriceWithStates(filterCalculatePriceStates, this.f42383g.getCurrentAmount(), this.f42398v);
            int calculateOriPriceWithStates = this.mGoodsPriceCalculator.calculateOriPriceWithStates(filterCalculatePriceStates, this.f42383g.getCurrentAmount());
            if (calculateCurPriceWithStates < 0 || calculateOriPriceWithStates < 0) {
                m29876g("price < 0 , not legal");
                calculateOriPriceWithStates = 0;
                calculateCurPriceWithStates = 0;
            }
            m29847a("changeOfflinePrice:{cur:" + calculateCurPriceWithStates + "},{ori:" + calculateOriPriceWithStates + "}", "c-show|").build().info();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeOfflinePrice(calculateCurPriceWithStates, calculateOriPriceWithStates, this.f42379c.currency);
        }
    }

    /* access modifiers changed from: protected */
    public int getLevel() {
        return this.f42379c.node.level + 1;
    }

    /* access modifiers changed from: protected */
    public GoodsSubItemEntity findSubItemEntity(String str, String str2) {
        return GoodsDataHelper.findGoodsSubItemEntity(this.f42379c, str, str2);
    }

    /* access modifiers changed from: protected */
    public void changeAddCartViewState() {
        if (!this.f42372B || this.f42383g.getCurrentAmount() != 0) {
            super.changeAddCartViewState();
            return;
        }
        m29847a("reduce amount to 0, enable add view", "c-act|").build().info();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).enableAddCartView();
    }

    /* renamed from: a */
    private void m29849a() {
        ArrayList<ItemNodeEntity> mapStateRepoToCartParams = SelectItemStateParser.mapStateRepoToCartParams(this.mStateUniqueId);
        int i = this.f42393q;
        if (i == 4) {
            m29868d((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (i == 9) {
            m29872e((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (this.f42396t) {
            m29862b((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (m29863b()) {
            m29856a(mapStateRepoToCartParams);
        } else {
            m29865c((List<ItemNodeEntity>) mapStateRepoToCartParams);
        }
        m29857a((List<ItemNodeEntity>) mapStateRepoToCartParams);
    }

    /* renamed from: b */
    private boolean m29863b() {
        return this.f42392p == 1;
    }

    /* renamed from: c */
    private boolean m29866c() {
        return this.f42392p == 1;
    }

    /* renamed from: d */
    private boolean m29869d() {
        return this.f42392p == 1;
    }

    /* renamed from: a */
    private void m29857a(List<ItemNodeEntity> list) {
        m29847a("Add to cart: {selected:" + list.toString() + "},{amount:" + this.f42383g.getCurrentAmount() + "},{isUpdate:" + this.f42396t + "}", "c-act|").build().info();
        AppsFlyerTrackHelper.trackAddCart(getContext());
        FirebaseAnalyticsHelper.trackAddCart(getContext());
    }

    /* renamed from: a */
    private void m29855a(String str) {
        m29847a("show alcohol", "c-act|").build().info();
        DialogUtil.showAlcoholRemindDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                GoodsPurchasePresenter.this.m29860b(rFDialog);
            }
        }, new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                GoodsPurchasePresenter.this.m29852a(rFDialog);
            }
        }, getContext().getString(R.string.customer_goods_detail_alcohol_remind_dialog_title), str);
        m29889t().onOrderDialogSw();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29860b(RFDialog rFDialog) {
        m29847a("click alcohol confirm", "c-act|").build().info();
        m29870e();
        this.f42395s = true;
        m29849a();
        m29889t().onOrderDialogConfirmCk();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29852a(RFDialog rFDialog) {
        m29889t().onOrderDialogCancelCk();
    }

    /* renamed from: e */
    private void m29870e() {
        this.f42380d = false;
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f42390n);
        if (state != null) {
            state.mHasShowedWineRemind = true;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: f */
    private void m29874f() {
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
        if (selectItemState != null) {
            selectItemState.node.amount = this.f42383g.getCurrentAmount();
            selectItemState.maxSale = this.f42398v;
        }
        if (this.f42372B) {
            changeAddCartViewState();
        }
    }

    /* renamed from: g */
    private void m29875g() {
        String str = "";
        this.f42391o = getScopeContext().getBundle().getString(Const.PageParams.BIDATA, str);
        this.f42390n = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        this.f42384h = getScopeContext().getBundle().getString(Const.PageParams.ITEM_ID);
        this.f42385i = getScopeContext().getBundle().getString(Const.PageParams.ITEM_UNIQ_KEY);
        this.f42386j = getScopeContext().getBundle().getString(Const.PageParams.KEY_CATE_ID);
        if (this.f42385i == null) {
            this.f42385i = this.f42384h;
        }
        this.f42379c = (GoodsItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.ITEM_ENTITY);
        this.f42378b = (CartItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.CART_ITEM_ENTITY);
        this.f42393q = getScopeContext().getBundle().getInt("from");
        this.f42380d = getScopeContext().getBundle().getBoolean(Const.PageParams.ITEM_NEED_SHOW_ALCOHOL_REMIND);
        this.f42401y = getScopeContext().getBundle().getString(Const.PageParams.CART_REVISION, str);
        this.f42402z = getScopeContext().getBundle().getString("cart_id", str);
        boolean z = false;
        this.f42392p = getScopeContext().getBundle().getInt("source", 0);
        this.f42377G = getScopeContext().getBundle().getString("is_item_merge", "0");
        if (this.f42378b != null) {
            z = true;
        }
        this.f42396t = z;
        CartItemEntity cartItemEntity = this.f42378b;
        if (cartItemEntity != null) {
            str = cartItemEntity.getMduId();
        }
        this.f42371A = str;
        GoodsItemEntity goodsItemEntity = this.f42379c;
        if (goodsItemEntity != null) {
            this.notNeedClientCal = goodsItemEntity.notNeedClientCal;
            this.allowOverAmount = this.f42379c.allowOverAmount;
        }
        try {
            this.f42376F = (ActInfoEntity) GsonUtil.fromJson(getScopeContext().getBundle().getString(Const.PageParams.ACT_INFO), ActInfoEntity.class);
        } catch (Exception unused) {
            LogUtil.m29104i(f42370a, "actInfoStr parse error: $e|$actInfoStr");
        }
        m29878i();
        m29877h();
    }

    /* renamed from: h */
    private void m29877h() {
        int i = this.f42393q;
        this.f42372B = i == 4 || i == 3;
        m29847a("initCanBZero: mCanDownToZero" + this.f42372B, "c-data|").build().info();
    }

    /* renamed from: i */
    private void m29878i() {
        m29847a("params: from:" + this.f42393q + " alcohol:" + this.f42380d + " cartRevision:" + this.f42401y + " cartId:" + this.f42402z + " mduId:" + this.f42371A, "c-data|").build().info();
    }

    /* renamed from: j */
    private void m29879j() {
        if (this.f42379c != null) {
            m29847a("data not null", "c-data|").build().info();
            m29880k();
            return;
        }
        m29847a("request goods data", "c-data|").build().info();
        if (this.f42374D == null) {
            this.f42374D = new GoodsDetailRepo();
        }
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideBottomButton();
        if (this.f42396t) {
            this.f42374D.requestGoodsDetail(this.f42390n, this.f42384h, this.f42378b.getMduId(), this.f42402z, this.f42392p, this.f42376F);
        } else {
            this.f42374D.requestGoodsDetail(this.f42390n, this.f42384h, "", "", this.f42392p, this.f42376F);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        GoodsDetailRepo goodsDetailRepo;
        super.onResume();
        if (this.f42375E == null && (goodsDetailRepo = this.f42374D) != null) {
            this.f42375E = goodsDetailRepo.subscribe(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    GoodsPurchasePresenter.this.m29853a((CustomerResource) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29853a(CustomerResource customerResource) {
        DialogUtil.hideLoadingDialog();
        if (customerResource == null) {
            m29861b(ResourceHelper.getString(R.string.customer_get_data_failure));
        } else if (customerResource.status == Resource.Status.SUCCESS) {
            m29882m();
            this.f42379c = (GoodsItemEntity) customerResource.data;
            m29880k();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).showBottomButton();
        } else if (customerResource.status == Resource.Status.ERROR) {
            m29861b(customerResource.message);
        }
    }

    /* renamed from: k */
    private void m29880k() {
        int i;
        int i2;
        GoodsItemEntity goodsItemEntity = this.f42379c;
        if (goodsItemEntity == null || goodsItemEntity.node == null) {
            m29847a("entity or node is null", "c-data|").build().info();
            return;
        }
        GoodsItemEntity goodsItemEntity2 = this.f42379c;
        if (goodsItemEntity2 != null) {
            this.notNeedClientCal = goodsItemEntity2.notNeedClientCal;
            this.allowOverAmount = this.f42379c.allowOverAmount;
        }
        this.f42384h = this.f42379c.itemId;
        String str = this.f42379c.itemUniqKey;
        this.f42385i = str;
        if (str == null) {
            this.f42385i = this.f42384h;
        }
        this.f42387k = this.f42379c.status;
        this.f42390n = this.f42379c.shopId;
        this.f42397u = this.f42379c.activityType;
        this.f42388l = this.f42379c.soldStatus;
        this.f42389m = this.f42379c.soldTimeDesc;
        if (this.f42379c.toast != null && !TextUtils.isEmpty(this.f42379c.toast.getContent())) {
            ToastActionHelper.toastAction(this.f42379c.toast, new Function0() {
                public final Object invoke() {
                    return GoodsPurchasePresenter.this.m29890u();
                }
            });
            if (this.f42376F != null) {
                m29889t().onToastShow(this.f42376F.getActId(), this.f42379c.toast.getContent());
            }
        }
        this.f42376F = this.f42379c.actInfo;
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo(this.f42376F);
        this.mStateUniqueId = this.f42384h + "_" + System.identityHashCode(this);
        StringBuilder sb = new StringBuilder();
        sb.append("state unique id: ");
        sb.append(this.mStateUniqueId);
        m29847a(sb.toString(), "c-data|").build().info();
        SelectItemState mapGoodsEntityToStateRepo = SelectItemStateParser.mapGoodsEntityToStateRepo(this.f42379c);
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).putSelectItemState(this.mStateUniqueId, mapGoodsEntityToStateRepo);
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f42390n);
        if (m29866c()) {
            if (state != null) {
                state.shopStatus = 1;
                ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
            }
            this.f42394r = 1;
        } else if (state != null) {
            this.f42394r = state.shopStatus;
        }
        if (state != null && !TextUtils.isEmpty(state.mWineConfirmDesc)) {
            this.f42373C = state.mWineConfirmDesc;
        } else if (!m29869d() || TextUtils.isEmpty(this.f42379c.wineConfirmDesc)) {
            this.f42373C = ResourceHelper.getString(R.string.customer_goods_detail_alcohol_remind_dialog_desc);
        } else {
            this.f42373C = this.f42379c.wineConfirmDesc;
        }
        if (m29869d() && this.f42379c.wineConfirm == 0) {
            this.f42380d = true;
        }
        mapGoodsEntityToStateRepo.shopId = this.f42390n;
        mapGoodsEntityToStateRepo.itemId = this.f42384h;
        mapGoodsEntityToStateRepo.shopStatus = this.f42394r;
        mapGoodsEntityToStateRepo.itemStatus = this.f42387k;
        mapGoodsEntityToStateRepo.soldStatus = this.f42388l;
        mapGoodsEntityToStateRepo.limitedTime = this.f42389m;
        mapGoodsEntityToStateRepo.from = this.f42393q;
        ItemState state2 = ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).getState(this.f42390n, this.f42385i);
        this.f42399w = (state2 == null || this.f42396t) ? 0 : state2.amount;
        if (GoodsDataHelper.hasSpecialPriceActivityInfo(this.f42379c) || GoodsDataHelper.isEFO(this.f42397u) || GoodsDataHelper.isRegularCustomer(this.f42397u)) {
            int i3 = this.f42379c.maxOrderSale;
            if (state2 != null) {
                i3 -= state2.amount;
            }
            this.f42398v = i3;
            if (i3 < 0) {
                this.f42398v = Integer.MAX_VALUE;
            }
        } else {
            this.f42398v = Integer.MAX_VALUE;
        }
        CartItemEntity cartItemEntity = this.f42378b;
        int amount = (cartItemEntity == null || cartItemEntity.getAmount() <= 0) ? 1 : this.f42378b.getAmount();
        int i4 = 99;
        if (state2 == null) {
            i = 99;
        } else {
            i = 99 - state2.amount;
        }
        if (this.f42396t) {
            i += amount;
        }
        if (i > 0 && i <= 99) {
            i4 = i;
        }
        this.f42383g = new GoodsAmountModel.Builder().setGoodsId(this.f42379c.itemId).setItemUniKey(this.f42379c.itemUniqKey).setBusinessId(this.f42379c.shopId).setActivityType(this.f42397u).setGoodsItemState(GoodsDataHelper.getGoodsItemState(this.f42379c, 1)).setMinAmount(this.f42372B ^ true ? 1 : 0).setInitialAmount(amount).setMaxAmount(i4).setMaxSaleAmount(this.f42398v).setAllowOverAmoun(this.allowOverAmount).build();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).refreshTitleBar(this.f42379c.itemName, 0.0f);
        m29847a("handleData: {initial:" + amount + "},{maxSale:" + this.f42398v + "}", "c-data|").build().info();
        this.mGoodsContentMap = GoodsDataHelper.parseGoodsItemEntity(this.f42379c, this.f42394r, mapGoodsEntityToStateRepo, this.mSelectedSubItemList, this.mSelectedSubItemStates, this.mStateUniqueId);
        this.f42383g.setGoodsAmountListener(this);
        m29874f();
        boolean z = GoodsDataHelper.isSoldOutOrLimitSale(GoodsDataHelper.getGoodsItemState(this.f42387k, this.f42379c.soldStatus, this.f42394r)) || !TextUtils.isEmpty(this.f42379c.headImg);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).updateHeadImage(z);
        if (z) {
            i2 = 0;
        } else {
            i2 = ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px);
        }
        addDataManager(createChildDataItemManager(new EmptyHeightBinder.HeightData(i2)));
        GoodsPurchaseHeaderRvModel newInstance = GoodsPurchaseHeaderRvModel.newInstance(this.f42379c);
        newInstance.mNeedShowAlcoholRemind = this.f42380d || this.f42379c.cHasWine == 1;
        newInstance.mBusinessStatus = this.f42394r;
        int i5 = 2;
        newInstance.setRvIndex(1);
        addDataManager(createChildDataItemManager(newInstance));
        int i6 = 0;
        for (GoodsPurchaseContentRvModel goodsPurchaseContentRvModel : this.mGoodsContentMap.values()) {
            int i7 = i5 + 1;
            goodsPurchaseContentRvModel.setRvIndex(i5);
            ChildDataItemManager createChildDataItemManager = createChildDataItemManager(goodsPurchaseContentRvModel);
            addDataManager(createChildDataItemManager);
            this.mContentDataManagers.put(goodsPurchaseContentRvModel.mContentId, createChildDataItemManager);
            if (goodsPurchaseContentRvModel.mIsObliged) {
                i6++;
            }
            updateValidSubItemOmegaModel(goodsPurchaseContentRvModel.mContentId);
            ArrayList arrayList = new ArrayList();
            if (!CollectionsUtil.isEmpty(goodsPurchaseContentRvModel.mSubItemList)) {
                int size = goodsPurchaseContentRvModel.mSubItemList.size();
                for (int i8 = 0; i8 < size; i8++) {
                    GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = goodsPurchaseContentRvModel.mSubItemList.get(i8);
                    int i9 = i7 + 1;
                    goodsPurchaseSubItemRvModel.setRvIndex(i7);
                    ChildDataItemManager createChildDataItemManager2 = createChildDataItemManager(goodsPurchaseSubItemRvModel);
                    arrayList.add(createChildDataItemManager2);
                    addDataManager(createChildDataItemManager2);
                    if (i8 != size - 1) {
                        i9++;
                        addDataManager(createChildDataItemManager(getDividerLineRvModel()));
                    }
                    i7 = i9;
                }
                this.mSubItemDataManagers.put(goodsPurchaseContentRvModel.mContentId, arrayList);
            }
            i5 = i7;
        }
        this.mGoodsPurchaseOmegaModel.setRequiredSelections(i6);
        this.mGoodsPurchaseOmegaModel.mHasMultiContents = GoodsDataHelper.hasMultipleContents(this.f42379c) ? 1 : 0;
        this.mGoodsPurchaseOmegaModel.mIsMultiLevel = GoodsDataHelper.isMultiLevelItem(this.f42379c) ? 1 : 0;
        GoodsPurchaseCounterRvModel newInstance2 = GoodsPurchaseCounterRvModel.newInstance(this.f42383g, this.f42394r, m29883n(), m29886q());
        this.f42382f = newInstance2;
        newInstance2.setRvIndex(i5);
        ChildDataItemManager<GoodsPurchaseCounterRvModel> createChildDataItemManager3 = createChildDataItemManager(this.f42382f);
        this.f42381e = createChildDataItemManager3;
        addDataManager(createChildDataItemManager3);
        changeAddCartViewState();
        m29850a(this.f42399w);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m29887r());
        if (this.f42387k != 1 || !BusinessDataHelper.checkBusinessStatusNormal(this.f42394r)) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).disableAddCartAndEvent();
        }
        m29889t().onPurchaseShow(this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mHasMultiContents, this.mGoodsPurchaseOmegaModel.mIsMultiLevel);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ Unit m29890u() {
        m29881l();
        return null;
    }

    /* renamed from: l */
    private void m29881l() {
        ((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).refreshBusinessPage(new BusinessActionParam(true, true, true));
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillRefreshEntity(1));
        dismiss(getScopeContext());
    }

    /* renamed from: b */
    private void m29861b(String str) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showAbnormalView(m29864c(str));
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideGoodsContent();
    }

    /* renamed from: m */
    private void m29882m() {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideAbnormalView();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showGoodsContent();
    }

    /* renamed from: c */
    private TopGunAbnormalViewModel m29864c(String str) {
        $$Lambda$GoodsPurchasePresenter$5FPBQzopRCzhGPVaaHQtDIL0KBs r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsPurchasePresenter.this.m29851a(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29851a(View view) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideAbnormalView();
        m29879j();
    }

    /* renamed from: n */
    private SpannableString m29883n() {
        if (GoodsDataHelper.isBuyGift(this.f42397u) && GoodsDataHelper.hasBuyGiftActivityInfo(this.f42379c)) {
            return m29884o();
        }
        if (this.allowOverAmount || this.f42398v >= Integer.MAX_VALUE) {
            return null;
        }
        return m29885p();
    }

    /* renamed from: o */
    private SpannableString m29884o() {
        int i = this.f42379c.activityInfo.buyGift.buyNum;
        int i2 = this.f42379c.activityInfo.buyGift.getNum - i;
        int currentAmount = (this.f42399w % (i + i2)) + this.f42383g.getCurrentAmount();
        if (currentAmount >= i) {
            int i3 = (currentAmount / i) * i2;
            SpannableString spannableString = new SpannableString(getContext().getResources().getQuantityString(R.plurals.customer_goods_buy_gift_received_tip, i3, new Object[]{Integer.valueOf(i3)}));
            spannableString.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString.length(), 33);
            return spannableString;
        } else if (i - currentAmount != 1) {
            return null;
        } else {
            SpannableString spannableString2 = new SpannableString(getContext().getResources().getQuantityString(R.plurals.customer_goods_buy_gift_amount_tip, i2, new Object[]{Integer.valueOf(i2)}));
            spannableString2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.rf_color_gery_2_40_666666)), 0, spannableString2.length(), 33);
            return spannableString2;
        }
    }

    /* renamed from: p */
    private SpannableString m29885p() {
        SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.FoodC_sale_Limited_purchase_xvEP, Integer.valueOf(this.f42398v)));
        spannableString.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* renamed from: q */
    private boolean m29886q() {
        if (GoodsDataHelper.isBuyGift(this.f42397u) && GoodsDataHelper.hasBuyGiftActivityInfo(this.f42379c)) {
            int i = this.f42379c.activityInfo.buyGift.buyNum;
            if ((this.f42399w % ((this.f42379c.activityInfo.buyGift.getNum - i) + i)) + this.f42383g.getCurrentAmount() >= i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    private String m29887r() {
        ResourceHelper.getString(R.string.FoodC_dish_Purchase_VBHv);
        if (this.f42396t) {
            return ResourceHelper.getString(R.string.customer_goods_purchase_update);
        }
        if (this.f42392p == 1) {
            return ResourceHelper.getString(R.string.FoodC_dish_Purchase_VBHv);
        }
        if (!GoodsDataHelper.isBuyGift(this.f42397u) || !GoodsDataHelper.hasBuyGiftActivityInfo(this.f42379c)) {
            return getContext().getResources().getQuantityString(R.plurals.customer_goods_purchase_add_num, this.f42383g.getCurrentAmount(), new Object[]{Integer.valueOf(this.f42383g.getCurrentAmount())});
        }
        int i = this.f42379c.activityInfo.buyGift.buyNum;
        int i2 = this.f42379c.activityInfo.buyGift.getNum - i;
        int currentAmount = ((((this.f42399w % (i + i2)) + this.f42383g.getCurrentAmount()) / i) * i2) + this.f42383g.getCurrentAmount();
        return getContext().getResources().getQuantityString(R.plurals.customer_goods_purchase_add_num, currentAmount, new Object[]{Integer.valueOf(currentAmount)});
    }

    /* renamed from: a */
    private void m29850a(int i) {
        m29847a("handleOfflineCalculate:{isUpdate:" + this.f42396t + "}", "c-show|").build().info();
        this.mGoodsPriceCalculator = m29858b(i);
        changeOfflinePrice();
    }

    /* renamed from: b */
    private GoodsPriceCalculator m29858b(int i) {
        if (this.f42396t) {
            return new NoOpGoodsPriceCalculator();
        }
        if (GoodsDataHelper.isBuyGift(this.f42397u)) {
            return new BuyGiftGoodsPriceCalculator(this.f42379c, i);
        }
        if (GoodsDataHelper.isSpecialPrice(this.f42397u) || GoodsDataHelper.isRegularCustomer(this.f42397u) || GoodsDataHelper.isEFO(this.f42397u)) {
            return new SpecialGoodsPriceCalculator(this.f42379c);
        }
        return new NormalGoodsPriceCalculator(this.f42379c);
    }

    /* renamed from: s */
    private void m29888s() {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f42390n, (Action2<CustomerResource<CartInfoEntity>>) new Action2() {
            public final void call(Object obj, Subscription subscription) {
                GoodsPurchasePresenter.this.m29854a((CustomerResource) obj, subscription);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29854a(CustomerResource customerResource, Subscription subscription) {
        CustomerResource customerResource2 = customerResource;
        if (customerResource2 == null) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            m29847a("calculate resource is null", "c-data|").build().info();
        } else if (customerResource2.status == Resource.Status.SUCCESS) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            if (customerResource2.data == null) {
                m29847a("calculate data is null", "c-data|").build().info();
                return;
            }
            m29847a("calculate success", "c-data|").build().info();
            this.mGoodsPurchaseOmegaModel.setCartId(((CartInfoEntity) customerResource2.data).getCartId());
            this.mGoodsPurchaseOmegaModel.setCartInfo((CartInfoEntity) customerResource2.data);
            GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
            m29889t().onPurchaseItem2CartClick(GsonUtil.toJson(goodsPurchaseOmegaModel.mGoodsSelectOmegaModel), this.f42383g.getCurrentAmount(), goodsPurchaseOmegaModel.mCartInfo, goodsPurchaseOmegaModel.mCartId, this.f42390n, this.f42384h, goodsPurchaseOmegaModel.mHasMultiContents, goodsPurchaseOmegaModel.mIsMultiLevel, this.f42379c.price + "", this.f42379c.specialPrice + "", this.f42397u + "", this.f42386j, this.f42377G);
            if (((CartInfoEntity) customerResource2.data).getAlert() != null && !TextUtils.isEmpty(((CartInfoEntity) customerResource2.data).getAlert().getContent())) {
                ToastUtil.showCustomerErrorToast((ScopeContext) null, ((CartInfoEntity) customerResource2.data).getAlert().getContent());
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(Const.PageParams.BUSINESS_GOODS_PURCHASED, !this.f42396t);
            bundle.putString(Const.PageParams.ITEM_ID, this.f42384h);
            bundle.putString(Const.PageParams.ITEM_UNIQ_KEY, this.f42385i);
            onBack(bundle);
        } else if (customerResource2.status == Resource.Status.ERROR) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            m29847a("calculate fail: " + customerResource2.message, "c-data|").build().error();
            String str = customerResource2.message;
            if (!NetWorkUtils.isNetworkConnected(getContext())) {
                str = ResourceHelper.getString(R.string.customer_net_error_tip_subtitle);
            }
            ToastUtil.showCustomerErrorToast(getScopeContext(), str);
        }
    }

    /* renamed from: b */
    private void m29862b(List<ItemNodeEntity> list) {
        m29847a("dispatch replace", "c-act|").build().info();
        m29888s();
        int currentAmount = this.f42383g.getCurrentAmount();
        CheckCartMaxNumKt.isReachMaxNum(getScopeContext(), this.f42390n, this.f42385i, this.f42371A, currentAmount, new Function0(currentAmount, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return GoodsPurchasePresenter.this.m29859b(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Unit m29859b(int i, List list) {
        int i2 = i;
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showCartLoadingView();
        m29847a("dispatchReplaceAction: amount is " + i2 + "businessId is " + this.f42390n + "mGoodsId is " + this.f42384h + "mMduId is " + this.f42371A + "mCartRevision is " + this.f42401y + "mBiData is " + this.f42391o, "c-data|").build().info();
        if (i2 == 0) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItemAmount(new SetItemAmountParams(m29867d(this.f42390n), m29867d(this.f42384h), this.f42385i, m29867d(this.f42402z), new SetItemAmountParams.Content(m29867d(this.f42371A), i2), m29867d(this.f42401y), m29867d(this.f42391o), (ActInfoEntity) null));
            return Unit.INSTANCE;
        }
        SetItemParams setItemParams = new SetItemParams(this.f42390n, this.f42384h, this.f42385i, GoodsDataHelper.hasMultipleContents(this.f42379c), i, list, this.f42402z, this.f42371A, Integer.valueOf(this.f42395s ? 1 : 0), this.f42401y, this.f42391o, this.f42376F);
        if ("1".equals(this.f42377G)) {
            setItemParams = new SetItemParams(this.f42390n, this.f42384h, this.f42385i, GoodsDataHelper.hasMultipleContents(this.f42379c), i, list, this.f42402z, this.f42371A, Integer.valueOf(this.f42395s ? 1 : 0), this.f42401y, this.f42391o, this.f42376F, 1);
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    /* renamed from: a */
    private void m29856a(ArrayList<ItemNodeEntity> arrayList) {
        int i = this.f42393q;
        String str = i == 7 ? "homePage" : i == 8 ? "discountDetail" : "";
        Bundle bundle = new Bundle();
        bundle.putString(Const.PageParams.SHOP_ID, this.f42390n);
        bundle.putString("from_page", str);
        bundle.putString("cart_id", this.f42402z);
        bundle.putInt("source", this.f42392p);
        bundle.putInt(Const.PageParams.WINE_CONFIRM, this.f42395s ? 1 : 0);
        bundle.putSerializable(Const.PageParams.NODE_LIST, arrayList);
        bundle.putInt(Const.PageParams.SUB_FROM_SKU_CHECK_OUT, this.f42393q);
        m29889t().trackCheckOut(this.mGoodsPurchaseOmegaModel.mHasMultiContents);
        dismiss(getScopeContext(), bundle);
    }

    /* renamed from: c */
    private void m29865c(List<ItemNodeEntity> list) {
        m29847a("dispatch add", "c-act|").build().info();
        m29888s();
        int currentAmount = this.f42383g.getCurrentAmount();
        CheckCartMaxNumKt.isReachMaxNum(getScopeContext(), this.f42390n, this.f42385i, this.f42371A, currentAmount, new Function0(currentAmount, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return GoodsPurchasePresenter.this.m29848a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m29848a(int i, List list) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showCartLoadingView();
        SetItemParams setItemParams = new SetItemParams(this.f42390n, this.f42384h, this.f42385i, GoodsDataHelper.hasMultipleContents(this.f42379c), i, list, (String) null, (String) null, Integer.valueOf(this.f42395s ? 1 : 0), this.f42401y, this.f42391o, this.f42376F);
        if ("1".equals(this.f42377G)) {
            setItemParams = new SetItemParams(this.f42390n, this.f42384h, this.f42385i, GoodsDataHelper.hasMultipleContents(this.f42379c), i, list, (String) null, (String) null, Integer.valueOf(this.f42395s ? 1 : 0), this.f42401y, this.f42391o, this.f42376F, 1);
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    /* renamed from: d */
    private void m29868d(List<ItemNodeEntity> list) {
        int currentAmount = this.f42383g.getCurrentAmount();
        m29847a("bill update amount is " + currentAmount, "c-act|").build().info();
        if (currentAmount == 0) {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillDelItemEntity(this.f42371A));
        } else {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillUpdateParams(this.f42402z, this.f42390n, this.f42371A, list, 0));
        }
        dismiss(getScopeContext());
    }

    /* renamed from: e */
    private void m29872e(List<ItemNodeEntity> list) {
        BillAddTyingEntity billAddTyingEntity = new BillAddTyingEntity();
        billAddTyingEntity.shopId = this.f42390n;
        billAddTyingEntity.nodeList = list;
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billAddTyingEntity);
        dismiss(getScopeContext());
    }

    /* renamed from: e */
    private void m29871e(String str) {
        Logger.m40928d(f42370a, str);
    }

    /* renamed from: t */
    private GoodsOmegaHelper m29889t() {
        String str;
        String str2;
        if (this.f42400x == null) {
            GoodsItemEntity goodsItemEntity = this.f42379c;
            if (goodsItemEntity != null) {
                String num = Integer.toString(goodsItemEntity.price);
                str = Integer.toString(this.f42379c.specialPrice);
                str2 = num;
            } else {
                str2 = "";
                str = str2;
            }
            this.f42400x = new GoodsOmegaHelper(getScopeContext(), this.f42390n, this.f42394r, this.f42384h, this.f42387k, this.f42388l, this.f42389m, this.f42393q, str2, str, Integer.toString(this.f42397u));
        }
        return this.f42400x;
    }

    /* renamed from: f */
    private RecordTracker.Builder m29873f(String str) {
        return m29847a(str, (String) null);
    }

    /* renamed from: a */
    private RecordTracker.Builder m29847a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42370a).setLogModule("m-purchase|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f42390n).setOtherParam("goods_id", this.f42384h);
    }

    /* renamed from: g */
    private void m29876g(String str) {
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SKU_OFFLINE_ERROR).addModuleName(ErrorConst.ModuleName.SKU).addErrorType(str).addParam("shop_id", this.f42379c.shopId).addParam("item_id", this.f42379c.itemId).build().trackError();
    }
}
