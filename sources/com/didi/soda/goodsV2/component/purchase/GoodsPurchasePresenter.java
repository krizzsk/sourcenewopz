package com.didi.soda.goodsV2.component.purchase;

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
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
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
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.binder.EmptyHeightBinder;
import com.didi.soda.goodsV2.binder.logic.PurchaseSubItemLogicRepo;
import com.didi.soda.goodsV2.component.purchase.Contract;
import com.didi.soda.goodsV2.contract.GoodsAmountModel;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.didi.soda.goodsV2.helper.GoodsOmegaHelper;
import com.didi.soda.goodsV2.helper.GoodsPurchaseOmegaModel;
import com.didi.soda.goodsV2.manager.GoodsDetailRepo;
import com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseCounterRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;
import com.didi.soda.goodsV2.parser.SelectItemStateParser;
import com.didi.soda.goodsV2.price.BuyGiftGoodsPriceCalculator;
import com.didi.soda.goodsV2.price.GoodsPriceCalculator;
import com.didi.soda.goodsV2.price.NoOpGoodsPriceCalculator;
import com.didi.soda.goodsV2.price.NormalGoodsPriceCalculator;
import com.didi.soda.goodsV2.price.SpecialGoodsPriceCalculator;
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
    private static final String f42458a = "GoodsPurchasePresenter";

    /* renamed from: A */
    private boolean f42459A = false;

    /* renamed from: B */
    private String f42460B;

    /* renamed from: C */
    private GoodsDetailRepo f42461C;

    /* renamed from: D */
    private Subscription f42462D;

    /* renamed from: E */
    private ActInfoEntity f42463E;

    /* renamed from: F */
    private int f42464F = -1;

    /* renamed from: G */
    private boolean f42465G;

    /* renamed from: H */
    private String f42466H;

    /* renamed from: I */
    private int f42467I = -1;

    /* renamed from: b */
    private CartItemEntity f42468b;

    /* renamed from: c */
    private GoodsItemEntity f42469c;

    /* renamed from: d */
    private boolean f42470d = false;

    /* renamed from: e */
    private GoodsPurchaseCounterRvModel f42471e;

    /* renamed from: f */
    private GoodsAmountModel f42472f;

    /* renamed from: g */
    private String f42473g;

    /* renamed from: h */
    private String f42474h;

    /* renamed from: i */
    private String f42475i;

    /* renamed from: j */
    private int f42476j;

    /* renamed from: k */
    private int f42477k;

    /* renamed from: l */
    private String f42478l = "";

    /* renamed from: m */
    private String f42479m;

    /* renamed from: n */
    private String f42480n = "";

    /* renamed from: o */
    private int f42481o = 0;

    /* renamed from: p */
    private int f42482p;

    /* renamed from: q */
    private int f42483q = 1;

    /* renamed from: r */
    private boolean f42484r = false;

    /* renamed from: s */
    private boolean f42485s;

    /* renamed from: t */
    private int f42486t;

    /* renamed from: u */
    private int f42487u = Integer.MAX_VALUE;

    /* renamed from: v */
    private int f42488v;

    /* renamed from: w */
    private GoodsOmegaHelper f42489w;

    /* renamed from: x */
    private String f42490x;

    /* renamed from: y */
    private String f42491y;

    /* renamed from: z */
    private String f42492z = "";

    /* renamed from: d */
    private String m29942d(String str) {
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
        } else if (this.f42470d) {
            m29930a(this.f42460B);
        } else {
            m29924a();
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
        GoodsItemEntity goodsItemEntity = this.f42469c;
        m29964t().onSubItemClick(goodsPurchaseOmegaModel.mCurContentId, goodsPurchaseOmegaModel.mCurContentType, goodsPurchaseOmegaModel.mValidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mInvalidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mCurSelectedSubItemId, goodsPurchaseOmegaModel.mSelectType, goodsPurchaseOmegaModel.mCurContentIsMust, goodsPurchaseOmegaModel.mCurSelectedSubItemType, goodsPurchaseOmegaModel.mIsMultiLevel, (goodsItemEntity == null || goodsItemEntity.node == null) ? 0 : this.f42469c.node.totalLevel);
    }

    /* access modifiers changed from: protected */
    public void onMultiPageEnter(PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel purchaseSubItemLogicModel) {
        m29964t().trackEntreMultiPage(purchaseSubItemLogicModel.rvModel.mSubItemId);
    }

    public void onAddGoodsClick(String str, View view, Bundle bundle) {
        if (this.f42472f != null) {
            m29922a("onAddGoodsClick", "c-act|").build().info();
            this.f42472f.increaseAmount(1);
            m29949f();
            this.f42471e.mBuyTip = m29958n();
            this.f42471e.mReceviedGiftLimit = m29961q();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).bindGoodsPurchaseCounter(this.f42471e, this);
            changeOfflinePrice();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m29962r());
        }
    }

    public void onSubtractGoodsClick(String str, Bundle bundle) {
        if (this.f42472f != null) {
            m29922a("onSubtractGoodsClick", "c-act|").build().info();
            this.f42472f.decreaseAmount(1);
            m29949f();
            this.f42471e.mBuyTip = m29958n();
            this.f42471e.mReceviedGiftLimit = m29961q();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).bindGoodsPurchaseCounter(this.f42471e, this);
            changeOfflinePrice();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m29962r());
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
        m29922a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
        m29950g();
        m29954j();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m29922a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).clearSelectItemState(this.mStateUniqueId);
        GoodsItemEntity goodsItemEntity = this.f42469c;
        m29964t().onPurchaseExit(this.mGoodsPurchaseOmegaModel.mHasMultiContents, this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mUnRequiredSelections, (goodsItemEntity == null || goodsItemEntity.node == null) ? 0 : this.f42469c.node.totalLevel);
    }

    /* access modifiers changed from: protected */
    public void changeOfflinePrice() {
        if (!this.notNeedClientCal) {
            if (this.mGoodsPriceCalculator == null) {
                m29922a("mGoodsPriceCalculator == null", "c-show|").build().info();
                return;
            }
            List<SelectSubItemState> filterCalculatePriceStates = SelectItemStateParser.filterCalculatePriceStates(this.mSelectedSubItemStates.values());
            int calculateCurPriceWithStates = this.mGoodsPriceCalculator.calculateCurPriceWithStates(filterCalculatePriceStates, this.f42472f.getCurrentAmount(), this.f42487u);
            int calculateOriPriceWithStates = this.mGoodsPriceCalculator.calculateOriPriceWithStates(filterCalculatePriceStates, this.f42472f.getCurrentAmount());
            if (calculateCurPriceWithStates < 0 || calculateOriPriceWithStates < 0) {
                m29951g("price < 0 , not legal");
                calculateOriPriceWithStates = 0;
                calculateCurPriceWithStates = 0;
            }
            m29922a("changeOfflinePrice:{cur:" + calculateCurPriceWithStates + "},{ori:" + calculateOriPriceWithStates + "}", "c-show|").build().info();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeOfflinePrice(calculateCurPriceWithStates, calculateOriPriceWithStates, this.f42469c.currency);
        }
    }

    /* access modifiers changed from: protected */
    public int getLevel() {
        return this.f42469c.node.level + 1;
    }

    /* access modifiers changed from: protected */
    public GoodsSubItemEntity findSubItemEntity(String str, String str2) {
        return GoodsDataHelper.findGoodsSubItemEntity(this.f42469c, str, str2);
    }

    /* access modifiers changed from: protected */
    public void changeAddCartViewState() {
        if (!this.f42459A || this.f42472f.getCurrentAmount() != 0) {
            super.changeAddCartViewState();
            return;
        }
        m29922a("reduce amount to 0, enable add view", "c-act|").build().info();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).enableAddCartView();
    }

    /* renamed from: a */
    private void m29924a() {
        ArrayList<ItemNodeEntity> mapStateRepoToCartParams = SelectItemStateParser.mapStateRepoToCartParams(this.mStateUniqueId);
        int i = this.f42482p;
        if (i == 4) {
            m29943d((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (i == 9) {
            m29947e((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (this.f42485s) {
            m29937b((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (m29938b()) {
            m29931a(mapStateRepoToCartParams);
        } else {
            m29940c((List<ItemNodeEntity>) mapStateRepoToCartParams);
        }
        m29932a((List<ItemNodeEntity>) mapStateRepoToCartParams);
    }

    /* renamed from: b */
    private boolean m29938b() {
        return this.f42481o == 1;
    }

    /* renamed from: c */
    private boolean m29941c() {
        return this.f42481o == 1;
    }

    /* renamed from: d */
    private boolean m29944d() {
        return this.f42481o == 1;
    }

    /* renamed from: a */
    private void m29932a(List<ItemNodeEntity> list) {
        m29922a("Add to cart: {selected:" + list.toString() + "},{amount:" + this.f42472f.getCurrentAmount() + "},{isUpdate:" + this.f42485s + "}", "c-act|").build().info();
        AppsFlyerTrackHelper.trackAddCart(getContext());
        FirebaseAnalyticsHelper.trackAddCart(getContext());
    }

    /* renamed from: a */
    private void m29930a(String str) {
        m29922a("show alcohol", "c-act|").build().info();
        DialogUtil.showAlcoholRemindDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                GoodsPurchasePresenter.this.m29935b(rFDialog);
            }
        }, new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                GoodsPurchasePresenter.this.m29927a(rFDialog);
            }
        }, getContext().getString(R.string.customer_goods_detail_alcohol_remind_dialog_title), str);
        m29964t().onOrderDialogSw();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29935b(RFDialog rFDialog) {
        m29922a("click alcohol confirm", "c-act|").build().info();
        m29945e();
        this.f42484r = true;
        m29924a();
        m29964t().onOrderDialogConfirmCk();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29927a(RFDialog rFDialog) {
        m29964t().onOrderDialogCancelCk();
    }

    /* renamed from: e */
    private void m29945e() {
        this.f42470d = false;
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f42479m);
        if (state != null) {
            state.mHasShowedWineRemind = true;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: f */
    private void m29949f() {
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
        if (selectItemState != null) {
            selectItemState.node.amount = this.f42472f.getCurrentAmount();
            selectItemState.maxSale = this.f42487u;
        }
        if (this.f42459A) {
            changeAddCartViewState();
        }
    }

    /* renamed from: g */
    private void m29950g() {
        String str = "";
        this.f42480n = getScopeContext().getBundle().getString(Const.PageParams.BIDATA, str);
        this.f42479m = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        this.f42473g = getScopeContext().getBundle().getString(Const.PageParams.ITEM_ID);
        this.f42474h = getScopeContext().getBundle().getString(Const.PageParams.ITEM_UNIQ_KEY);
        this.f42475i = getScopeContext().getBundle().getString(Const.PageParams.KEY_CATE_ID);
        if (this.f42474h == null) {
            this.f42474h = this.f42473g;
        }
        this.f42469c = (GoodsItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.ITEM_ENTITY);
        this.f42468b = (CartItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.CART_ITEM_ENTITY);
        this.f42482p = getScopeContext().getBundle().getInt("from");
        this.f42466H = getScopeContext().getBundle().getString("is_item_merge", "0");
        this.f42470d = getScopeContext().getBundle().getBoolean(Const.PageParams.ITEM_NEED_SHOW_ALCOHOL_REMIND);
        this.f42490x = getScopeContext().getBundle().getString(Const.PageParams.CART_REVISION, str);
        this.f42491y = getScopeContext().getBundle().getString("cart_id", str);
        this.f42464F = getScopeContext().getBundle().getInt(ParamConst.PARAM_TAB_LOCATION, -1);
        this.f42467I = getScopeContext().getBundle().getInt(ParamConst.PARAM_ITEM_LOCATION, -1);
        boolean z = false;
        this.f42481o = getScopeContext().getBundle().getInt("source", 0);
        if (this.f42468b != null) {
            z = true;
        }
        this.f42485s = z;
        CartItemEntity cartItemEntity = this.f42468b;
        if (cartItemEntity != null) {
            str = cartItemEntity.getMduId();
        }
        this.f42492z = str;
        GoodsItemEntity goodsItemEntity = this.f42469c;
        if (goodsItemEntity != null) {
            this.notNeedClientCal = goodsItemEntity.notNeedClientCal;
            this.allowOverAmount = this.f42469c.allowOverAmount;
        }
        try {
            this.f42463E = (ActInfoEntity) GsonUtil.fromJson(getScopeContext().getBundle().getString(Const.PageParams.ACT_INFO), ActInfoEntity.class);
        } catch (Exception unused) {
            LogUtil.m29104i(f42458a, "actInfoStr parse error: $e|$actInfoStr");
        }
        m29953i();
        m29952h();
    }

    /* renamed from: h */
    private void m29952h() {
        int i = this.f42482p;
        this.f42459A = i == 4 || i == 3;
        m29922a("initCanBZero: mCanDownToZero" + this.f42459A, "c-data|").build().info();
    }

    /* renamed from: i */
    private void m29953i() {
        m29922a("params: from:" + this.f42482p + " alcohol:" + this.f42470d + " cartRevision:" + this.f42490x + " cartId:" + this.f42491y + " mduId:" + this.f42492z, "c-data|").build().info();
    }

    /* renamed from: j */
    private void m29954j() {
        if (this.f42469c != null) {
            m29922a("data not null", "c-data|").build().info();
            m29955k();
            return;
        }
        m29922a("request goods data", "c-data|").build().info();
        if (this.f42461C == null) {
            this.f42461C = new GoodsDetailRepo();
        }
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideBottomButton();
        if (this.f42485s) {
            this.f42461C.requestGoodsDetail(this.f42479m, this.f42473g, this.f42468b.getMduId(), this.f42491y, this.f42481o, this.f42463E);
        } else {
            this.f42461C.requestGoodsDetail(this.f42479m, this.f42473g, "", "", this.f42481o, this.f42463E);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        GoodsDetailRepo goodsDetailRepo;
        super.onResume();
        if (this.f42462D == null && (goodsDetailRepo = this.f42461C) != null) {
            this.f42462D = goodsDetailRepo.subscribe(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    GoodsPurchasePresenter.this.m29928a((CustomerResource) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29928a(CustomerResource customerResource) {
        DialogUtil.hideLoadingDialog();
        if (customerResource == null) {
            m29936b(ResourceHelper.getString(R.string.customer_get_data_failure));
        } else if (customerResource.status == Resource.Status.SUCCESS) {
            m29957m();
            this.f42469c = (GoodsItemEntity) customerResource.data;
            m29955k();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).showBottomButton();
        } else if (customerResource.status == Resource.Status.ERROR) {
            m29936b(customerResource.message);
        }
    }

    /* renamed from: k */
    private void m29955k() {
        int i;
        GoodsItemEntity goodsItemEntity = this.f42469c;
        if (goodsItemEntity == null || goodsItemEntity.node == null) {
            m29922a("entity or node is null", "c-data|").build().info();
            return;
        }
        GoodsItemEntity goodsItemEntity2 = this.f42469c;
        if (goodsItemEntity2 != null) {
            this.notNeedClientCal = goodsItemEntity2.notNeedClientCal;
            this.allowOverAmount = this.f42469c.allowOverAmount;
        }
        this.f42473g = this.f42469c.itemId;
        String str = this.f42469c.itemUniqKey;
        this.f42474h = str;
        if (str == null) {
            this.f42474h = this.f42473g;
        }
        this.f42476j = this.f42469c.status;
        this.f42479m = this.f42469c.shopId;
        this.f42486t = this.f42469c.activityType;
        this.f42477k = this.f42469c.soldStatus;
        this.f42478l = this.f42469c.soldTimeDesc;
        if (this.f42469c.toast != null && !TextUtils.isEmpty(this.f42469c.toast.getContent())) {
            ToastActionHelper.toastAction(this.f42469c.toast, new Function0() {
                public final Object invoke() {
                    return GoodsPurchasePresenter.this.m29965u();
                }
            });
            if (this.f42463E != null) {
                m29964t().onToastShow(this.f42463E.getActId(), this.f42469c.toast.getContent());
            }
        }
        this.f42463E = this.f42469c.actInfo;
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo(this.f42463E);
        this.mStateUniqueId = this.f42473g + "_" + System.identityHashCode(this);
        StringBuilder sb = new StringBuilder();
        sb.append("state unique id: ");
        sb.append(this.mStateUniqueId);
        m29922a(sb.toString(), "c-data|").build().info();
        SelectItemState mapGoodsEntityToStateRepo = SelectItemStateParser.mapGoodsEntityToStateRepo(this.f42469c);
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).putSelectItemState(this.mStateUniqueId, mapGoodsEntityToStateRepo);
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f42479m);
        if (m29941c()) {
            if (state != null) {
                state.shopStatus = 1;
                ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
            }
            this.f42483q = 1;
        } else if (state != null) {
            this.f42483q = state.shopStatus;
        }
        if (state != null && !TextUtils.isEmpty(state.mWineConfirmDesc)) {
            this.f42460B = state.mWineConfirmDesc;
        } else if (!m29944d() || TextUtils.isEmpty(this.f42469c.wineConfirmDesc)) {
            this.f42460B = ResourceHelper.getString(R.string.customer_goods_detail_alcohol_remind_dialog_desc);
        } else {
            this.f42460B = this.f42469c.wineConfirmDesc;
        }
        if (m29944d() && this.f42469c.wineConfirm == 0) {
            this.f42470d = true;
        }
        mapGoodsEntityToStateRepo.shopId = this.f42479m;
        mapGoodsEntityToStateRepo.itemId = this.f42473g;
        mapGoodsEntityToStateRepo.shopStatus = this.f42483q;
        mapGoodsEntityToStateRepo.itemStatus = this.f42476j;
        mapGoodsEntityToStateRepo.soldStatus = this.f42477k;
        mapGoodsEntityToStateRepo.limitedTime = this.f42478l;
        mapGoodsEntityToStateRepo.from = this.f42482p;
        ItemState state2 = ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).getState(this.f42479m, this.f42474h);
        this.f42488v = (state2 == null || this.f42485s) ? 0 : state2.amount;
        if (GoodsDataHelper.hasSpecialPriceActivityInfo(this.f42469c) || GoodsDataHelper.isEFO(this.f42486t) || GoodsDataHelper.isRegularCustomer(this.f42486t)) {
            int i2 = this.f42469c.maxOrderSale;
            if (state2 != null) {
                i2 -= state2.amount;
            }
            this.f42487u = i2;
            if (i2 < 0) {
                this.f42487u = Integer.MAX_VALUE;
            }
        } else {
            this.f42487u = Integer.MAX_VALUE;
        }
        CartItemEntity cartItemEntity = this.f42468b;
        int amount = (cartItemEntity == null || cartItemEntity.getAmount() <= 0) ? 1 : this.f42468b.getAmount();
        int i3 = 99;
        if (state2 == null) {
            i = 99;
        } else {
            i = 99 - state2.amount;
        }
        if (this.f42485s) {
            i += amount;
        }
        if (i > 0 && i <= 99) {
            i3 = i;
        }
        this.f42472f = new GoodsAmountModel.Builder().setGoodsId(this.f42469c.itemId).setItemUniKey(this.f42469c.itemUniqKey).setBusinessId(this.f42469c.shopId).setActivityType(this.f42486t).setGoodsItemState(GoodsDataHelper.getGoodsItemState(this.f42469c, 1)).setMinAmount(this.f42459A ^ true ? 1 : 0).setInitialAmount(amount).setMaxAmount(i3).setMaxSaleAmount(this.f42487u).setAllowOverAmoun(this.allowOverAmount).build();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).refreshTitleBar(this.f42469c.itemName, 0.0f);
        m29922a("handleData: {initial:" + amount + "},{maxSale:" + this.f42487u + "}", "c-data|").build().info();
        this.mGoodsContentMap = GoodsDataHelper.parseGoodsItemEntity(this.f42469c, this.f42483q, mapGoodsEntityToStateRepo, this.mSelectedSubItemList, this.mSelectedSubItemStates, this.mStateUniqueId);
        this.f42472f.setGoodsAmountListener(this);
        m29949f();
        this.f42465G = GoodsDataHelper.isSoldOutOrLimitSale(GoodsDataHelper.getGoodsItemState(this.f42476j, this.f42469c.soldStatus, this.f42483q)) || !TextUtils.isEmpty(this.f42469c.headImg);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).updateHeadImage(this.f42465G);
        addDataManager(createChildDataItemManager(new EmptyHeightBinder.HeightData(this.f42465G ? 0 : ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px))));
        GoodsPurchaseHeaderRvModel newInstance = GoodsPurchaseHeaderRvModel.newInstance(this.f42469c);
        newInstance.mNeedShowAlcoholRemind = this.f42470d || this.f42469c.cHasWine == 1;
        newInstance.mBusinessStatus = this.f42483q;
        int i4 = 2;
        newInstance.setRvIndex(1);
        addDataManager(createChildDataItemManager(newInstance));
        int i5 = 0;
        int i6 = 0;
        for (GoodsPurchaseContentRvModel goodsPurchaseContentRvModel : this.mGoodsContentMap.values()) {
            int i7 = i4 + 1;
            addDataManager(createChildDataItemManager(getDividerLineRvModel()));
            int i8 = i7 + 1;
            goodsPurchaseContentRvModel.setRvIndex(i7);
            ChildDataItemManager createChildDataItemManager = createChildDataItemManager(goodsPurchaseContentRvModel);
            addDataManager(createChildDataItemManager);
            this.mContentDataManagers.put(goodsPurchaseContentRvModel.mContentId, createChildDataItemManager);
            if (goodsPurchaseContentRvModel.mIsObliged) {
                i5++;
            } else {
                i6++;
            }
            updateValidSubItemOmegaModel(goodsPurchaseContentRvModel.mContentId);
            ArrayList arrayList = new ArrayList();
            if (!CollectionsUtil.isEmpty(goodsPurchaseContentRvModel.mSubItemList)) {
                int size = goodsPurchaseContentRvModel.mSubItemList.size();
                int i9 = 0;
                while (i9 < size) {
                    GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = goodsPurchaseContentRvModel.mSubItemList.get(i9);
                    int i10 = i8 + 1;
                    goodsPurchaseSubItemRvModel.setRvIndex(i8);
                    ChildDataItemManager createChildDataItemManager2 = createChildDataItemManager(goodsPurchaseSubItemRvModel);
                    arrayList.add(createChildDataItemManager2);
                    addDataManager(createChildDataItemManager2);
                    i9++;
                    i8 = i10;
                }
                this.mSubItemDataManagers.put(goodsPurchaseContentRvModel.mContentId, arrayList);
            }
            i4 = i8;
        }
        this.mGoodsPurchaseOmegaModel.setRequiredSelections(i5);
        this.mGoodsPurchaseOmegaModel.setUnRequiredSelections(i6);
        this.mGoodsPurchaseOmegaModel.mHasMultiContents = GoodsDataHelper.hasMultipleContents(this.f42469c) ? 1 : 0;
        this.mGoodsPurchaseOmegaModel.mIsMultiLevel = GoodsDataHelper.isMultiLevelItem(this.f42469c) ? 1 : 0;
        this.f42471e = GoodsPurchaseCounterRvModel.newInstance(this.f42472f, this.f42483q, m29958n(), m29961q());
        ((Contract.AbsGoodsPurchaseView) getLogicView()).bindGoodsPurchaseCounter(this.f42471e, this);
        changeAddCartViewState();
        m29925a(this.f42488v);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m29962r());
        if (this.f42476j != 1 || !BusinessDataHelper.checkBusinessStatusNormal(this.f42483q)) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).disableAddCartAndEvent();
        }
        GoodsItemEntity goodsItemEntity3 = this.f42469c;
        m29964t().onPurchaseShow(this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mHasMultiContents, this.mGoodsPurchaseOmegaModel.mIsMultiLevel, (goodsItemEntity3 == null || goodsItemEntity3.node == null) ? 0 : this.f42469c.node.totalLevel, this.mGoodsPurchaseOmegaModel.mUnRequiredSelections);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ Unit m29965u() {
        m29956l();
        return null;
    }

    /* renamed from: l */
    private void m29956l() {
        ((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).refreshBusinessPage(new BusinessActionParam(true, true, true));
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillRefreshEntity(1));
        dismiss(getScopeContext());
    }

    /* renamed from: b */
    private void m29936b(String str) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showAbnormalView(m29939c(str));
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideGoodsContent();
    }

    /* renamed from: m */
    private void m29957m() {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideAbnormalView();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showGoodsContent();
    }

    /* renamed from: c */
    private TopGunAbnormalViewModel m29939c(String str) {
        $$Lambda$GoodsPurchasePresenter$MybTfIL9hrpNtFMiPRZh6zhcTE r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsPurchasePresenter.this.m29926a(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29926a(View view) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideAbnormalView();
        m29954j();
    }

    /* renamed from: n */
    private SpannableString m29958n() {
        if (GoodsDataHelper.isBuyGift(this.f42486t) && GoodsDataHelper.hasBuyGiftActivityInfo(this.f42469c)) {
            return m29959o();
        }
        if (this.allowOverAmount || this.f42487u >= Integer.MAX_VALUE) {
            return null;
        }
        return m29960p();
    }

    /* renamed from: o */
    private SpannableString m29959o() {
        int i = this.f42469c.activityInfo.buyGift.buyNum;
        int i2 = this.f42469c.activityInfo.buyGift.getNum - i;
        int currentAmount = (this.f42488v % (i + i2)) + this.f42472f.getCurrentAmount();
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
    private SpannableString m29960p() {
        SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.FoodC_sale_Limited_purchase_xvEP, Integer.valueOf(this.f42487u)));
        spannableString.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* renamed from: q */
    private boolean m29961q() {
        if (GoodsDataHelper.isBuyGift(this.f42486t) && GoodsDataHelper.hasBuyGiftActivityInfo(this.f42469c)) {
            int i = this.f42469c.activityInfo.buyGift.buyNum;
            if ((this.f42488v % ((this.f42469c.activityInfo.buyGift.getNum - i) + i)) + this.f42472f.getCurrentAmount() >= i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    private String m29962r() {
        ResourceHelper.getString(R.string.FoodC_dish_Purchase_VBHv);
        if (this.f42485s) {
            return ResourceHelper.getString(R.string.customer_goods_purchase_update);
        }
        if (this.f42481o == 1) {
            return ResourceHelper.getString(R.string.FoodC_requirement_Purchase_MOXm);
        }
        if (!GoodsDataHelper.isBuyGift(this.f42486t) || !GoodsDataHelper.hasBuyGiftActivityInfo(this.f42469c)) {
            return getContext().getResources().getString(R.string.customer_global_add);
        }
        int i = this.f42469c.activityInfo.buyGift.buyNum;
        int currentAmount = ((this.f42488v % ((this.f42469c.activityInfo.buyGift.getNum - i) + i)) + this.f42472f.getCurrentAmount()) / i;
        this.f42472f.getCurrentAmount();
        return getContext().getResources().getString(R.string.customer_global_add);
    }

    /* renamed from: a */
    private void m29925a(int i) {
        m29922a("handleOfflineCalculate:{isUpdate:" + this.f42485s + "}", "c-show|").build().info();
        this.mGoodsPriceCalculator = m29933b(i);
        changeOfflinePrice();
    }

    /* renamed from: b */
    private GoodsPriceCalculator m29933b(int i) {
        if (this.f42485s) {
            return new NoOpGoodsPriceCalculator();
        }
        if (GoodsDataHelper.isBuyGift(this.f42486t)) {
            return new BuyGiftGoodsPriceCalculator(this.f42469c, i);
        }
        if (GoodsDataHelper.isSpecialPrice(this.f42486t) || GoodsDataHelper.isRegularCustomer(this.f42486t) || GoodsDataHelper.isEFO(this.f42486t)) {
            return new SpecialGoodsPriceCalculator(this.f42469c);
        }
        return new NormalGoodsPriceCalculator(this.f42469c);
    }

    /* renamed from: s */
    private void m29963s() {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f42479m, (Action2<CustomerResource<CartInfoEntity>>) new Action2() {
            public final void call(Object obj, Subscription subscription) {
                GoodsPurchasePresenter.this.m29929a((CustomerResource) obj, subscription);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29929a(CustomerResource customerResource, Subscription subscription) {
        CustomerResource customerResource2 = customerResource;
        if (customerResource2 == null) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            m29922a("calculate resource is null", "c-data|").build().info();
        } else if (customerResource2.status == Resource.Status.SUCCESS) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            if (customerResource2.data == null) {
                m29922a("calculate data is null", "c-data|").build().info();
                return;
            }
            m29922a("calculate success", "c-data|").build().info();
            GoodsItemEntity goodsItemEntity = this.f42469c;
            int i = (goodsItemEntity == null || goodsItemEntity.node == null) ? 0 : this.f42469c.node.totalLevel;
            this.mGoodsPurchaseOmegaModel.setCartId(((CartInfoEntity) customerResource2.data).getCartId());
            this.mGoodsPurchaseOmegaModel.setCartInfo((CartInfoEntity) customerResource2.data);
            GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
            m29964t().onPurchaseItem2CartClick(GsonUtil.toJson(goodsPurchaseOmegaModel.mGoodsSelectOmegaModel), this.f42472f.getCurrentAmount(), goodsPurchaseOmegaModel.mCartInfo, goodsPurchaseOmegaModel.mCartId, this.f42479m, this.f42473g, goodsPurchaseOmegaModel.mHasMultiContents, goodsPurchaseOmegaModel.mIsMultiLevel, this.f42469c.price + "", this.f42469c.specialPrice + "", this.f42486t + "", this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mUnRequiredSelections, i, this.f42466H, this.f42467I);
            if (((CartInfoEntity) customerResource2.data).getAlert() != null && !TextUtils.isEmpty(((CartInfoEntity) customerResource2.data).getAlert().getContent())) {
                ToastUtil.showCustomerErrorToast((ScopeContext) null, ((CartInfoEntity) customerResource2.data).getAlert().getContent());
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(Const.PageParams.BUSINESS_GOODS_PURCHASED, !this.f42485s);
            bundle.putString(Const.PageParams.ITEM_ID, this.f42473g);
            bundle.putString(Const.PageParams.ITEM_UNIQ_KEY, this.f42474h);
            onBack(bundle);
        } else if (customerResource2.status == Resource.Status.ERROR) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            m29922a("calculate fail: " + customerResource2.message, "c-data|").build().error();
            String str = customerResource2.message;
            if (!NetWorkUtils.isNetworkConnected(getContext())) {
                str = ResourceHelper.getString(R.string.customer_net_error_tip_subtitle);
            }
            ToastUtil.showCustomerErrorToast(getScopeContext(), str);
        }
    }

    /* renamed from: b */
    private void m29937b(List<ItemNodeEntity> list) {
        m29922a("dispatch replace", "c-act|").build().info();
        m29963s();
        int currentAmount = this.f42472f.getCurrentAmount();
        CheckCartMaxNumKt.isReachMaxNum(getScopeContext(), this.f42479m, this.f42474h, this.f42492z, currentAmount, new Function0(currentAmount, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return GoodsPurchasePresenter.this.m29934b(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Unit m29934b(int i, List list) {
        int i2 = i;
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showCartLoadingView();
        m29922a("dispatchReplaceAction: amount is " + i2 + "businessId is " + this.f42479m + "mGoodsId is " + this.f42473g + "mMduId is " + this.f42492z + "mCartRevision is " + this.f42490x + "mBiData is " + this.f42480n, "c-data|").build().info();
        if (i2 == 0) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItemAmount(new SetItemAmountParams(m29942d(this.f42479m), m29942d(this.f42473g), this.f42474h, m29942d(this.f42491y), new SetItemAmountParams.Content(m29942d(this.f42492z), i2), m29942d(this.f42490x), m29942d(this.f42480n), (ActInfoEntity) null));
            return Unit.INSTANCE;
        }
        SetItemParams setItemParams = new SetItemParams(this.f42479m, this.f42473g, this.f42474h, GoodsDataHelper.hasMultipleContents(this.f42469c), i, list, this.f42491y, this.f42492z, Integer.valueOf(this.f42484r ? 1 : 0), this.f42490x, this.f42480n, this.f42463E);
        if ("1".equals(this.f42466H)) {
            setItemParams = new SetItemParams(this.f42479m, this.f42473g, this.f42474h, GoodsDataHelper.hasMultipleContents(this.f42469c), i, list, this.f42491y, this.f42492z, Integer.valueOf(this.f42484r ? 1 : 0), this.f42490x, this.f42480n, this.f42463E, 1);
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    /* renamed from: a */
    private void m29931a(ArrayList<ItemNodeEntity> arrayList) {
        int i = this.f42482p;
        String str = i == 7 ? "homePage" : i == 8 ? "discountDetail" : "";
        Bundle bundle = new Bundle();
        bundle.putString(Const.PageParams.SHOP_ID, this.f42479m);
        bundle.putString("from_page", str);
        bundle.putString("cart_id", this.f42491y);
        bundle.putInt("source", this.f42481o);
        bundle.putInt(Const.PageParams.WINE_CONFIRM, this.f42484r ? 1 : 0);
        bundle.putSerializable(Const.PageParams.NODE_LIST, arrayList);
        bundle.putInt(Const.PageParams.SUB_FROM_SKU_CHECK_OUT, this.f42482p);
        m29964t().trackCheckOut(this.mGoodsPurchaseOmegaModel.mHasMultiContents);
        dismiss(getScopeContext(), bundle);
    }

    /* renamed from: c */
    private void m29940c(List<ItemNodeEntity> list) {
        m29922a("dispatch add", "c-act|").build().info();
        m29963s();
        int currentAmount = this.f42472f.getCurrentAmount();
        CheckCartMaxNumKt.isReachMaxNum(getScopeContext(), this.f42479m, this.f42474h, this.f42492z, currentAmount, new Function0(currentAmount, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return GoodsPurchasePresenter.this.m29923a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m29923a(int i, List list) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showCartLoadingView();
        SetItemParams setItemParams = new SetItemParams(this.f42479m, this.f42473g, this.f42474h, GoodsDataHelper.hasMultipleContents(this.f42469c), i, list, (String) null, (String) null, Integer.valueOf(this.f42484r ? 1 : 0), this.f42490x, this.f42480n, this.f42463E);
        if ("1".equals(this.f42466H)) {
            setItemParams = new SetItemParams(this.f42479m, this.f42473g, this.f42474h, GoodsDataHelper.hasMultipleContents(this.f42469c), i, list, (String) null, (String) null, Integer.valueOf(this.f42484r ? 1 : 0), this.f42490x, this.f42480n, this.f42463E, 1);
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    /* renamed from: d */
    private void m29943d(List<ItemNodeEntity> list) {
        int currentAmount = this.f42472f.getCurrentAmount();
        m29922a("bill update amount is " + currentAmount, "c-act|").build().info();
        if (currentAmount == 0) {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillDelItemEntity(this.f42492z));
        } else {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillUpdateParams(this.f42491y, this.f42479m, this.f42492z, list, 0));
        }
        dismiss(getScopeContext());
    }

    /* renamed from: e */
    private void m29947e(List<ItemNodeEntity> list) {
        BillAddTyingEntity billAddTyingEntity = new BillAddTyingEntity();
        billAddTyingEntity.shopId = this.f42479m;
        billAddTyingEntity.nodeList = list;
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billAddTyingEntity);
        dismiss(getScopeContext());
    }

    /* renamed from: e */
    private void m29946e(String str) {
        Logger.m40928d(f42458a, str);
    }

    /* renamed from: t */
    private GoodsOmegaHelper m29964t() {
        int i;
        String str;
        String str2;
        if (this.f42489w == null) {
            GoodsItemEntity goodsItemEntity = this.f42469c;
            if (goodsItemEntity != null) {
                String num = Integer.toString(goodsItemEntity.price);
                str = Integer.toString(this.f42469c.specialPrice);
                i = this.f42469c.additionalType == 0 ? 1 : 2;
                str2 = num;
            } else {
                str2 = "";
                str = str2;
                i = 0;
            }
            this.f42489w = new GoodsOmegaHelper(getScopeContext(), this.f42479m, this.f42483q, this.f42473g, this.f42476j, this.f42477k, this.f42478l, this.f42482p, str2, str, Integer.toString(this.f42486t), this.f42464F, this.f42465G, this.f42475i, i);
        }
        return this.f42489w;
    }

    /* renamed from: f */
    private RecordTracker.Builder m29948f(String str) {
        return m29922a(str, (String) null);
    }

    /* renamed from: a */
    private RecordTracker.Builder m29922a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42458a).setLogModule("m-purchase|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f42479m).setOtherParam("goods_id", this.f42473g);
    }

    /* renamed from: g */
    private void m29951g(String str) {
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SKU_OFFLINE_ERROR).addModuleName(ErrorConst.ModuleName.SKU).addErrorType(str).addParam("shop_id", this.f42469c.shopId).addParam("item_id", this.f42469c.itemId).build().trackError();
    }
}
