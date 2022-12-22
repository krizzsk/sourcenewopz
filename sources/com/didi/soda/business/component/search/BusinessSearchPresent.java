package com.didi.soda.business.component.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.PreviewImageRepo;
import com.didi.soda.business.component.search.helper.BusinessSearchOmegaModel;
import com.didi.soda.business.component.search.helper.SearchMenuPageInfo;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.GoodsItemClickListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.manager.BusinessSearchMenuTask;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchHotWordEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.router.DiRouter;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessSearchPresent extends CustomerRecyclerPresenter<BusinessSearchView> implements GoodsItemClickListener, RecommendWordListener {

    /* renamed from: a */
    private static final String f39636a = "BusinessSearchPresent";

    /* renamed from: b */
    private String f39637b;

    /* renamed from: c */
    private BusinessInfoEntity f39638c;

    /* renamed from: d */
    private BusinessSearchOmegaModel f39639d = new BusinessSearchOmegaModel();

    /* renamed from: e */
    private BusinessOmegaModel f39640e;

    /* renamed from: f */
    private String f39641f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BusinessOmegaHelper f39642g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f39643h = 1;

    /* renamed from: i */
    private TopGunAbnormalRvModel f39644i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BusinessSearchResultEntity f39645j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<BusinessGoodsItemRvModel> f39646k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ChildDataListManager<RecyclerModel> f39647l;

    /* renamed from: m */
    private ChildDataItemManager<RecyclerModel> f39648m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SearchMenuPageInfo f39649n;

    /* renamed from: o */
    private SerialTaskQueue f39650o = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Cancelable f39651p;

    /* renamed from: q */
    private Subscription f39652q;

    /* renamed from: r */
    private CartItemStateRepo f39653r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public BusinessSearchChangeListener f39654s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f39655t = false;

    /* renamed from: u */
    private String f39656u;

    public void onPageResult(Bundle bundle) {
    }

    public void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener) {
        this.f39654s = businessSearchChangeListener;
    }

    public void goBack(int i) {
        BusinessSearchChangeListener businessSearchChangeListener = this.f39654s;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.hideRecommendWord();
        }
        m28231k().onSearchCloseClick(i, (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName"));
        getScopeContext().getNavigator().finish();
    }

    public void onCreate() {
        super.onCreate();
        m28198a();
        m28209b();
        m28233l();
    }

    public void onDestroy() {
        super.onDestroy();
        Cancelable cancelable = this.f39651p;
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f39647l == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f39647l = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        if (this.f39648m == null) {
            ChildDataItemManager<RecyclerModel> createChildDataItemManager = createChildDataItemManager();
            this.f39648m = createChildDataItemManager;
            addDataManager(createChildDataItemManager);
        }
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        this.f39644i = topGunAbnormalRvModel;
        topGunAbnormalRvModel.mHeight = ((BusinessSearchView) getLogicView()).calculateAbnormalHeight();
    }

    public void onRecommendWordSearch(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ((BusinessSearchView) getLogicView()).showShimmerView();
            this.f39649n.setSearchWord(str, 1, (String) null);
            ((BusinessSearchView) getLogicView()).setRecommendSearchText(str);
            BusinessSearchChangeListener businessSearchChangeListener = this.f39654s;
            if (businessSearchChangeListener != null) {
                businessSearchChangeListener.hideRecommendWord();
            }
            onSearchWordRequest(0);
            m28231k().onSearchHotWordClick(str2, str);
        }
    }

    public void onSearchWordUpdate(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39649n.setSearchWord(str, 0);
            onSearchWordRequest(1);
        }
    }

    public void onSearchWordClear() {
        this.f39647l.clear();
        this.f39650o.clear();
        Cancelable cancelable = this.f39651p;
        if (cancelable != null) {
            cancelable.cancel();
        }
        BusinessSearchChangeListener businessSearchChangeListener = this.f39654s;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.showRecommendWord();
            m28231k().onSearchHotWordShow(this.f39639d);
        }
        ((BusinessSearchView) getLogicView()).hideShimmerView();
        ((BusinessSearchView) getLogicView()).hideSearchLoading();
        ((BusinessSearchView) getLogicView()).hideLoading();
        this.f39649n.clearSearchWord();
    }

    public void onSearchWordRequest(int i) {
        if (i == 1) {
            ((BusinessSearchView) getLogicView()).showSearchLoading();
        } else if (i == 2) {
            ((BusinessSearchView) getLogicView()).showLoading();
        }
        m28222f();
    }

    public void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m28231k().onSearchItemExposure(businessGoodsItemRvModel, this.f39649n.mRecId, this.f39649n.mTraceCnt, businessGoodsItemRvModel.mAdditionalType, businessGoodsItemRvModel.mCateIndex, businessGoodsItemRvModel.hasMultipleContents ? 1 : 0);
    }

    public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m28202a(businessGoodsItemRvModel2, false);
        m28195a("onGoodsItemClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel2.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel2.mGoodsId).build().info();
        boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39638c);
        if (BusinessDataHelper.isNeedReloadSubitem(this.f39638c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
            m28204a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem ? 1 : 0, 0);
            BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28214b(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39641f, 2, this.f39656u, new int[0]);
            return;
        }
        GoodsItemEntity findGoodEntitySearch = BusinessDataHelper.findGoodEntitySearch(this.f39645j, this.f39647l.indexOf(businessGoodsItemRvModel2), businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
        m28204a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntitySearch) ? 1 : 0);
        if (findGoodEntitySearch != null) {
            BusinessDataHelper.toGoodItemDetail(getScopeContext(), findGoodEntitySearch, businessGoodsItemRvModel2.mInCategoryIndex, m28214b(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39641f, 2, this.f39656u, businessGoodsItemRvModel2.mCateId, new int[0]);
        }
    }

    public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m28204a(EventConst.Business.SHOP_ITEM_PHOTO_CK, businessGoodsItemRvModel, BusinessDataHelper.isNeedReloadSubitem(this.f39638c) ? 1 : 0, GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntitySearch(this.f39645j, this.f39647l.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) ? 1 : 0);
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = view.getContext().getString(R.string.customer_transition_tag_business_preview_image_named, new Object[]{valueOf});
        ViewCompat.setTransitionName(view, string);
        DiRouter.request().path(RoutePath.BUSINESS_PREVIEW_IMAGE).putString(Const.PageParams.TRANSITION_NAMES, string).putSerializable(Const.PageParams.PREVIEW_IMAGE, PreviewImageModel.copyFrom(businessGoodsItemRvModel, view, 0, this.f39649n.mRecId, this.f39649n.mTraceCnt)).open();
    }

    public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m28202a(businessGoodsItemRvModel, false);
        m28195a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m28213b(businessGoodsItemRvModel, false);
    }

    /* renamed from: a */
    private void m28198a() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        this.f39637b = string;
        bundle.putString("current_shop_id", string);
        this.f39638c = (BusinessInfoEntity) bundle.getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        this.f39641f = getScopeContext().getBundle().getString(Const.PageParams.BIDATA, "");
        BusinessInfoEntity businessInfoEntity = this.f39638c;
        if (businessInfoEntity != null) {
            this.f39643h = businessInfoEntity.cShopStatus;
        }
        BusinessInfoEntity businessInfoEntity2 = this.f39638c;
        if (businessInfoEntity2 == null || TextUtils.isEmpty(businessInfoEntity2.cartRevision)) {
            this.f39656u = "0";
        } else {
            this.f39656u = this.f39638c.cartRevision;
        }
        LogUtil.m29100d(f39636a, "initParams status: " + this.f39643h);
        this.f39649n = new SearchMenuPageInfo(this.f39637b);
    }

    /* renamed from: b */
    private void m28209b() {
        this.f39653r = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(this.f39637b, getScopeContext(), new Action1<BusinessState>() {
            public void call(BusinessState businessState) {
                boolean z = (businessState == null || BusinessSearchPresent.this.f39643h == businessState.shopStatus) ? false : true;
                int unused = BusinessSearchPresent.this.f39643h = businessState.shopStatus;
                if (businessState != null) {
                    boolean unused2 = BusinessSearchPresent.this.f39655t = businessState.mHasShowedWineRemind;
                }
                LogUtil.m29100d(BusinessSearchPresent.f39636a, "mBusinessStateRepo status: " + BusinessSearchPresent.this.f39643h);
                if (z) {
                    BusinessSearchPresent.this.m28220e();
                }
            }
        });
        ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).subscribe(getScopeContext(), new Action1<PreviewImageModel>() {
            public void call(PreviewImageModel previewImageModel) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(BusinessSearchPresent.this.f39646k, previewImageModel.mGoodId, previewImageModel.mCateId);
                if (findGoodsItemRvModel != null) {
                    BusinessSearchPresent.this.m28195a("onImageAddClick", "c-act|").setOtherParam("cate_id", findGoodsItemRvModel.mCateId).setOtherParam("goods_id", findGoodsItemRvModel.mGoodsId).build().info();
                    BusinessSearchPresent.this.m28213b(findGoodsItemRvModel, true);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28216c() {
        if (this.f39645j != null) {
            Subscription subscription = this.f39652q;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f39652q = this.f39653r.subscribe(this.f39637b, getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    BusinessSearchPresent.this.m28205a((HashMap) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28205a(HashMap hashMap) {
        LogUtil.m29100d(f39636a, "updateItemsRepo: " + hashMap);
        if (hashMap == null || hashMap.size() <= 0) {
            m28217d();
        } else {
            m28206a((Map<String, ItemState>) hashMap);
        }
    }

    /* renamed from: d */
    private void m28217d() {
        int i = 0;
        for (BusinessGoodsItemRvModel next : this.f39646k) {
            next.mGoodsAmountModel.clearAmount();
            this.f39647l.set(i, next);
            i++;
        }
    }

    /* renamed from: a */
    private void m28206a(Map<String, ItemState> map) {
        int i = 0;
        for (BusinessGoodsItemRvModel next : this.f39646k) {
            if (!map.containsKey(next.mGoodsId) || map.get(next.mGoodsId) == null) {
                next.mGoodsAmountModel.clearAmount();
            } else {
                next.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(next.mItemUniqKey));
                LogUtil.m29100d(f39636a, "updateGoodsAmount index: " + i);
            }
            this.f39647l.set(i, next);
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m28220e() {
        if (!CollectionsUtil.isEmpty(this.f39646k)) {
            for (BusinessGoodsItemRvModel next : this.f39646k) {
                GoodsAmountModel goodsAmountModel = next.mGoodsAmountModel;
                goodsAmountModel.mGoodsItemState = GoodsDataHelper.getGoodsItemState(next.mStatus, next.mSoldStatus, this.f39643h);
                next.mGoodsAmountModel = goodsAmountModel;
            }
            this.f39647l.clear();
            this.f39647l.addAll(this.f39646k);
            LogUtil.m29100d(f39636a, "updateGoodsStatus size: " + this.f39646k.size());
        }
    }

    /* renamed from: f */
    private void m28222f() {
        this.f39651p = this.f39650o.append(new BusinessSearchMenuTask(new CustomerRpcCallback<BusinessSearchResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((BusinessSearchView) BusinessSearchPresent.this.getLogicView()).hideSearchLoading();
                ((BusinessSearchView) BusinessSearchPresent.this.getLogicView()).hideLoading();
                ((BusinessSearchView) BusinessSearchPresent.this.getLogicView()).hideShimmerView();
                BusinessSearchResultEntity unused = BusinessSearchPresent.this.f39645j = null;
                List unused2 = BusinessSearchPresent.this.f39646k = null;
                BusinessSearchPresent.this.m28203a(sFRpcException.getMessage());
                BusinessSearchPresent.this.m28227i();
                Cancelable unused3 = BusinessSearchPresent.this.f39651p = null;
            }

            public void onRpcSuccess(BusinessSearchResultEntity businessSearchResultEntity, long j) {
                BusinessSearchPresent.this.f39642g.reset();
                ((BusinessSearchView) BusinessSearchPresent.this.getLogicView()).hideSearchLoading();
                ((BusinessSearchView) BusinessSearchPresent.this.getLogicView()).hideLoading();
                ((BusinessSearchView) BusinessSearchPresent.this.getLogicView()).hideShimmerView();
                BusinessSearchResultEntity unused = BusinessSearchPresent.this.f39645j = businessSearchResultEntity;
                BusinessSearchPresent businessSearchPresent = BusinessSearchPresent.this;
                List unused2 = businessSearchPresent.f39646k = BusinessDataHelper.parseBusinessSearchEntity(businessSearchResultEntity, businessSearchPresent.f39643h);
                if (BusinessSearchPresent.this.f39654s != null) {
                    BusinessSearchPresent.this.f39654s.hideRecommendWord();
                }
                if (CollectionsUtil.isEmpty(BusinessSearchPresent.this.f39646k)) {
                    BusinessSearchPresent.this.m28223g();
                } else {
                    BusinessSearchPresent.this.f39647l.clear();
                    BusinessSearchPresent.this.f39647l.addAll(BusinessSearchPresent.this.f39646k);
                    LogUtil.m29100d(BusinessSearchPresent.f39636a, "data:" + BusinessSearchPresent.this.f39646k.size());
                    BusinessSearchPresent.this.m28216c();
                    BusinessSearchPresent.this.m28207a(true);
                }
                BusinessSearchPresent.this.m28227i();
                if (businessSearchResultEntity != null) {
                    BusinessSearchPresent.this.f39649n.autoAddTraceCnt(businessSearchResultEntity.recId);
                } else {
                    BusinessSearchPresent.this.f39649n.autoAddTraceCnt();
                }
                BusinessSearchPresent.this.m28231k().onSearchItemSw(BusinessSearchPresent.this.f39649n.mRecId, BusinessSearchPresent.this.f39649n.mTraceCnt);
                Cancelable unused3 = BusinessSearchPresent.this.f39651p = null;
            }
        }, this.f39649n), SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m28223g() {
        this.f39647l.clear();
        this.f39644i.setAbnormalVm(TopGunAbnormalFactory.buildShopNoResultService());
        this.f39647l.add(this.f39644i);
        m28226h();
        m28231k().onSearchNoResultSw(this.f39649n.mRecId, this.f39649n.mKeyWord);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28203a(String str) {
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            this.f39647l.clear();
            this.f39644i.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessSearchPresent.this.m28210b(view);
                }
            }));
            this.f39647l.add(this.f39644i);
            m28226h();
        } else if (this.f39647l.size() == 0 || this.f39647l.indexOf(this.f39644i) >= 0) {
            this.f39647l.clear();
            this.f39644i.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessSearchPresent.this.m28199a(view);
                }
            }));
            this.f39647l.add(this.f39644i);
            m28226h();
        } else {
            ((BusinessSearchView) getLogicView()).showNetErrorToast();
        }
        BusinessSearchChangeListener businessSearchChangeListener = this.f39654s;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.hideRecommendWord();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28210b(View view) {
        this.f39647l.clear();
        onSearchWordRequest(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28199a(View view) {
        this.f39647l.clear();
        onSearchWordRequest(2);
    }

    /* renamed from: h */
    private void m28226h() {
        m28207a(false);
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        ((BusinessSearchView) getLogicView()).hideSearchFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m28227i() {
        if (this.f39647l.size() > 2) {
            this.f39648m.setItem(m28230j());
            LogUtil.m29100d(f39636a, "updateBottomDivider: add");
        } else {
            this.f39648m.removeItem();
            LogUtil.m29100d(f39636a, "updateBottomDivider: remove");
        }
        ((BusinessSearchView) getLogicView()).scrollToTop();
    }

    /* renamed from: j */
    private CustomerDividerLineRvModel m28230j() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 110.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_gery_7_97_F5F5F7));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28207a(boolean z) {
        BusinessSearchChangeListener businessSearchChangeListener = this.f39654s;
        if (businessSearchChangeListener == null) {
            return;
        }
        if (z) {
            businessSearchChangeListener.showFloatingCart();
        } else {
            businessSearchChangeListener.hideFloatingCart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public BusinessOmegaHelper m28231k() {
        if (this.f39642g == null) {
            this.f39642g = new BusinessOmegaHelper(getScopeContext(), this.f39637b, this.f39643h);
        }
        return this.f39642g;
    }

    /* renamed from: l */
    private void m28233l() {
        this.f39640e = BusinessOmegaModel.newInstance(this.f39638c);
        BusinessInfoEntity businessInfoEntity = this.f39638c;
        if (businessInfoEntity != null) {
            BusinessSearchHotWordEntity businessSearchHotWordEntity = businessInfoEntity.recItemSearchWords;
            if (businessSearchHotWordEntity != null) {
                this.f39639d.mHotWordList = businessSearchHotWordEntity.recWords;
                this.f39639d.mHotWordRecId = businessSearchHotWordEntity.recId;
            }
            m28231k().onSearchShow(this.f39639d);
            m28231k().onSearchHotWordShow(this.f39639d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.f39638c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m28214b(boolean r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0010
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r0.f39638c
            if (r1 == 0) goto L_0x0010
            int r1 = r1.wineConfirm
            if (r1 != 0) goto L_0x0010
            boolean r1 = r0.f39655t
            if (r1 != 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.search.BusinessSearchPresent.m28214b(boolean):boolean");
    }

    /* renamed from: a */
    private void m28202a(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        if (businessGoodsItemRvModel != null) {
            OmegaCommonParamHelper.setLv3Body(StringUtils.SP_DATA_ITEM + businessGoodsItemRvModel.mGoodsId);
            OmegaCommonParamHelper.setLv3Location(ParamConst.PARAM_SHOP_SEARCH + "_" + businessGoodsItemRvModel.mCateId + "_" + 0 + "_" + 0 + "_" + 0 + "_" + businessGoodsItemRvModel.mInCategoryIndex + "_" + 0 + "_" + (z ? 1 : 0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m28195a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f39636a).setLogModule("m-business|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f39637b).setOtherParam("business_status", Integer.valueOf(this.f39643h));
    }

    /* renamed from: a */
    private void m28204a(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2) {
        m28231k().onSearchGoodsItemClick(str, businessGoodsItemRvModel, i, i2, this.f39640e, this.f39649n.mRecId, this.f39649n.mTraceCnt);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28213b(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        m28202a(businessGoodsItemRvModel, z);
        boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39638c);
        int i = z ? 6 : 2;
        if (BusinessDataHelper.isNeedReloadSubitem(this.f39638c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
            m28204a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, 0);
            BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28214b(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f39641f, i, this.f39656u, new int[0]);
            return;
        }
        GoodsItemEntity findGoodEntitySearch = BusinessDataHelper.findGoodEntitySearch(this.f39645j, this.f39647l.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
        m28204a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntitySearch) ? 1 : 0);
        if (findGoodEntitySearch != null) {
            BusinessDataHelper.dispatchAddAction(getScopeContext(), findGoodEntitySearch, businessGoodsItemRvModel, this.f39641f, i, this.f39656u, m28214b(businessGoodsItemRvModel.mNeedAlcoholRemind), m28231k(), (CartItemModel) null);
        }
    }
}
