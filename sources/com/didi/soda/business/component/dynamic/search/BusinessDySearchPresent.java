package com.didi.soda.business.component.dynamic.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.component.contract.dynamic.DynamicRecyclePresenter;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.PreviewImageRepo;
import com.didi.soda.business.component.search.helper.BusinessSearchOmegaModel;
import com.didi.soda.business.component.search.helper.SearchMenuPageInfo;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.GoodsItemClickListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessDyDataAssist;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.manager.BusinessSearchMenuTask;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchHotWordEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.router.DiRouter;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function4;

public class BusinessDySearchPresent extends DynamicRecyclePresenter<BusinessDySearchView> implements GoodsItemClickListener, RecommendWordListener {

    /* renamed from: a */
    private static final String f39496a = "BusinessSearchPresent";

    /* renamed from: b */
    private String f39497b;

    /* renamed from: c */
    private BusinessInfoEntity f39498c;

    /* renamed from: d */
    private BusinessSearchOmegaModel f39499d = new BusinessSearchOmegaModel();

    /* renamed from: e */
    private BusinessOmegaModel f39500e;

    /* renamed from: f */
    private String f39501f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BusinessOmegaHelper f39502g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f39503h = 1;

    /* renamed from: i */
    private TopGunAbnormalRvModel f39504i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BusinessSearchResultEntity f39505j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<ComponentModel> f39506k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<BusinessGoodsItemRvModel> f39507l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ChildDataListManager<RecyclerModel> f39508m;

    /* renamed from: n */
    private ChildDataItemManager<RecyclerModel> f39509n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public SearchMenuPageInfo f39510o;

    /* renamed from: p */
    private SerialTaskQueue f39511p = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Cancelable f39512q;

    /* renamed from: r */
    private Subscription f39513r;

    /* renamed from: s */
    private CartItemStateRepo f39514s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public BusinessSearchChangeListener f39515t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f39516u = false;

    /* renamed from: v */
    private String f39517v;

    /* renamed from: w */
    private CartInfoModel f39518w;

    public void onPageResult(Bundle bundle) {
    }

    public void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener) {
        this.f39515t = businessSearchChangeListener;
    }

    public void goBack(int i) {
        BusinessSearchChangeListener businessSearchChangeListener = this.f39515t;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.hideRecommendWord();
        }
        m28062k().onSearchCloseClick(i, (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName"));
        Bundle bundle = new Bundle();
        bundle.putString("from", "businesssearch");
        getScopeContext().getNavigator().finish(bundle);
    }

    public void onCreate() {
        super.onCreate();
        m28023a();
        m28036b();
        m28064l();
    }

    public void onDestroy() {
        super.onDestroy();
        Cancelable cancelable = this.f39512q;
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f39508m == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f39508m = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        if (this.f39509n == null) {
            ChildDataItemManager<RecyclerModel> createChildDataItemManager = createChildDataItemManager();
            this.f39509n = createChildDataItemManager;
            addDataManager(createChildDataItemManager);
        }
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        this.f39504i = topGunAbnormalRvModel;
        topGunAbnormalRvModel.mHeight = ((BusinessDySearchView) getLogicView()).calculateAbnormalHeight();
    }

    public void onRecommendWordSearch(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ((BusinessDySearchView) getLogicView()).showShimmerView();
            this.f39510o.setSearchWord(str, 1, (String) null);
            ((BusinessDySearchView) getLogicView()).setRecommendSearchText(str);
            BusinessSearchChangeListener businessSearchChangeListener = this.f39515t;
            if (businessSearchChangeListener != null) {
                businessSearchChangeListener.hideRecommendWord();
            }
            onSearchWordRequest(0);
            m28062k().onSearchHotWordClick(str2, str);
        }
    }

    public void onSearchWordUpdate(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39510o.setSearchWord(str, 0);
            onSearchWordRequest(1);
        }
    }

    public void onSearchWordClear() {
        this.f39508m.clear();
        this.f39511p.clear();
        Cancelable cancelable = this.f39512q;
        if (cancelable != null) {
            cancelable.cancel();
        }
        BusinessSearchChangeListener businessSearchChangeListener = this.f39515t;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.showRecommendWord();
            m28062k().onSearchHotWordShow(this.f39499d);
        }
        ((BusinessDySearchView) getLogicView()).hideShimmerView();
        ((BusinessDySearchView) getLogicView()).hideSearchLoading();
        ((BusinessDySearchView) getLogicView()).hideLoading();
        this.f39510o.clearSearchWord();
    }

    public void onSearchWordRequest(int i) {
        if (i == 1) {
            ((BusinessDySearchView) getLogicView()).showSearchLoading();
        } else if (i == 2) {
            ((BusinessDySearchView) getLogicView()).showLoading();
        }
        m28052f();
    }

    public void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m28062k().onSearchItemExposure(businessGoodsItemRvModel, this.f39510o.mRecId, this.f39510o.mTraceCnt, businessGoodsItemRvModel.mAdditionalType, businessGoodsItemRvModel.mCateIndex, businessGoodsItemRvModel.hasMultipleContents ? 1 : 0);
    }

    public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        String str;
        String str2;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m28027a(businessGoodsItemRvModel2, false);
        m28020a("onGoodsItemClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel2.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel2.mGoodsId).build().info();
        boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39498c);
        if (BusinessDataHelper.isNeedReloadSubitem(this.f39498c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
            m28030a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem ? 1 : 0, 0);
            if (TextUtils.isEmpty(businessGoodsItemRvModel2.mBusinessId) && (str = this.f39497b) != null) {
                businessGoodsItemRvModel2.mBusinessId = str;
            }
            BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28041b(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39501f, 2, this.f39517v, new int[0]);
            return;
        }
        GoodsItemEntity findGoodDyEntitySearch = BusinessDataHelper.findGoodDyEntitySearch(this.f39505j, this.f39508m.indexOf(businessGoodsItemRvModel2), businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
        m28030a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodDyEntitySearch) ? 1 : 0);
        if (findGoodDyEntitySearch != null) {
            if (TextUtils.isEmpty(findGoodDyEntitySearch.shopId) && (str2 = this.f39497b) != null) {
                findGoodDyEntitySearch.shopId = str2;
            }
            BusinessDataHelper.toGoodItemDetail(getScopeContext(), findGoodDyEntitySearch, businessGoodsItemRvModel2.mInCategoryIndex, m28041b(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39501f, 2, this.f39517v, businessGoodsItemRvModel2.mCateId, new int[0]);
        }
    }

    public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m28030a(EventConst.Business.SHOP_ITEM_PHOTO_CK, businessGoodsItemRvModel, BusinessDataHelper.isNeedReloadSubitem(this.f39498c) ? 1 : 0, GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntitySearch(this.f39505j, this.f39508m.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) ? 1 : 0);
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = view.getContext().getString(R.string.customer_transition_tag_business_preview_image_named, new Object[]{valueOf});
        ViewCompat.setTransitionName(view, string);
        DiRouter.request().path(RoutePath.BUSINESS_PREVIEW_IMAGE).putString(Const.PageParams.TRANSITION_NAMES, string).putSerializable(Const.PageParams.PREVIEW_IMAGE, PreviewImageModel.copyFrom(businessGoodsItemRvModel, view, 0, this.f39510o.mRecId, this.f39510o.mTraceCnt)).open();
    }

    public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m28027a(businessGoodsItemRvModel, false);
        m28020a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m28040b(businessGoodsItemRvModel, false);
    }

    public void onGoodsMinusClick(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2) {
        m28020a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m28026a(businessGoodsItemRvModel, str, str2, false);
    }

    /* renamed from: a */
    private void m28023a() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        this.f39497b = string;
        bundle.putString("current_shop_id", string);
        this.f39498c = (BusinessInfoEntity) bundle.getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        this.f39501f = getScopeContext().getBundle().getString(Const.PageParams.BIDATA, "");
        BusinessInfoEntity businessInfoEntity = this.f39498c;
        if (businessInfoEntity != null) {
            this.f39503h = businessInfoEntity.cShopStatus;
        }
        BusinessInfoEntity businessInfoEntity2 = this.f39498c;
        if (businessInfoEntity2 == null || TextUtils.isEmpty(businessInfoEntity2.cartRevision)) {
            this.f39517v = "0";
        } else {
            this.f39517v = this.f39498c.cartRevision;
        }
        BusinessDataHelper.addBlockScopeParam(this.f39498c, getScope());
        if (this.f39497b != null) {
            getScope().attach("shopId", this.f39497b);
        }
        LogUtil.m29100d(f39496a, "initParams status: " + this.f39503h);
        this.f39510o = new SearchMenuPageInfo(this.f39497b);
    }

    /* renamed from: b */
    private void m28036b() {
        this.f39514s = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(this.f39497b, getScopeContext(), new Action1<BusinessState>() {
            public void call(BusinessState businessState) {
                if (businessState != null) {
                    BusinessDataHelper.addBlockScopeParam(businessState, BusinessDySearchPresent.this.getScope());
                }
                boolean z = (businessState == null || BusinessDySearchPresent.this.f39503h == businessState.shopStatus) ? false : true;
                int unused = BusinessDySearchPresent.this.f39503h = businessState.shopStatus;
                if (businessState != null) {
                    boolean unused2 = BusinessDySearchPresent.this.f39516u = businessState.mHasShowedWineRemind;
                }
                LogUtil.m29100d(BusinessDySearchPresent.f39496a, "mBusinessStateRepo status: " + BusinessDySearchPresent.this.f39503h);
                if (z) {
                    BusinessDySearchPresent.this.m28050e();
                }
            }
        });
        ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).subscribe(getScopeContext(), new Action1<PreviewImageModel>() {
            public void call(PreviewImageModel previewImageModel) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(BusinessDySearchPresent.this.f39507l, previewImageModel.mGoodId, previewImageModel.mCateId);
                if (findGoodsItemRvModel != null) {
                    BusinessDySearchPresent.this.m28020a("onImageAddClick", "c-act|").setOtherParam("cate_id", findGoodsItemRvModel.mCateId).setOtherParam("goods_id", findGoodsItemRvModel.mGoodsId).build().info();
                    BusinessDySearchPresent.this.m28040b(findGoodsItemRvModel, true);
                }
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f39497b, (Action1<CustomerResource<CartInfoEntity>>) new Action1() {
            public final void call(Object obj) {
                BusinessDySearchPresent.this.m28028a((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28028a(CustomerResource customerResource) {
        if (customerResource != null && customerResource.data != null) {
            this.f39518w = new CartInfoModel().convertModel((CartInfoEntity) customerResource.data, this.f39503h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28044c() {
        Subscription subscription;
        if (this.f39505j != null && (subscription = this.f39513r) != null) {
            subscription.unsubscribe();
        }
    }

    /* renamed from: d */
    private void m28047d() {
        int i = 0;
        for (ComponentModel next : this.f39506k) {
            if (next.getDataModel() instanceof BusinessGoodsItemRvModel) {
                ((BusinessGoodsItemRvModel) next.getDataModel()).mGoodsAmountModel.clearAmount();
            }
            this.f39508m.set(i, next);
            i++;
        }
    }

    /* renamed from: a */
    private void m28031a(Map<String, ItemState> map) {
        int i = 0;
        for (ComponentModel next : this.f39506k) {
            if (next.getDataModel() instanceof BusinessGoodsItemRvModel) {
                BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next.getDataModel();
                if (!map.containsKey(businessGoodsItemRvModel.mGoodsId) || map.get(businessGoodsItemRvModel.mGoodsId) == null) {
                    businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                } else {
                    businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                    LogUtil.m29100d(f39496a, "updateGoodsAmount index: " + i);
                }
                next.setDataModel(businessGoodsItemRvModel);
            }
            this.f39508m.set(i, next);
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m28050e() {
        if (!CollectionsUtil.isEmpty(this.f39506k)) {
            for (ComponentModel next : this.f39506k) {
                if (next.getDataModel() instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next.getDataModel();
                    businessGoodsItemRvModel.mGoodsAmountModel.mGoodsItemState = GoodsDataHelper.getGoodsItemState(businessGoodsItemRvModel.mStatus, businessGoodsItemRvModel.mSoldStatus, this.f39503h);
                    next.setDataModel(businessGoodsItemRvModel);
                }
            }
            this.f39508m.clear();
            this.f39508m.addAll(this.f39506k);
            LogUtil.m29100d(f39496a, "updateGoodsStatus size: " + this.f39506k.size());
        }
    }

    /* renamed from: f */
    private void m28052f() {
        this.f39512q = this.f39511p.append(new BusinessSearchMenuTask(new CustomerRpcCallback<BusinessSearchResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideSearchLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideShimmerView();
                BusinessSearchResultEntity unused = BusinessDySearchPresent.this.f39505j = null;
                List unused2 = BusinessDySearchPresent.this.f39506k = null;
                BusinessDySearchPresent.this.m28029a(sFRpcException.getMessage());
                BusinessDySearchPresent.this.m28058i();
                Cancelable unused3 = BusinessDySearchPresent.this.f39512q = null;
            }

            public void onRpcSuccess(BusinessSearchResultEntity businessSearchResultEntity, long j) {
                BusinessDySearchPresent.this.f39502g.reset();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideSearchLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideShimmerView();
                BusinessSearchResultEntity unused = BusinessDySearchPresent.this.f39505j = businessSearchResultEntity;
                if (BusinessDySearchPresent.this.f39515t != null) {
                    BusinessDySearchPresent.this.f39515t.hideRecommendWord();
                }
                if (businessSearchResultEntity == null) {
                    BusinessDySearchPresent.this.m28053g();
                } else if (CollectionsUtil.isEmpty(businessSearchResultEntity.mTemplates)) {
                    BusinessDySearchPresent.this.m28053g();
                } else {
                    BusinessDyDataAssist.initTemplate(businessSearchResultEntity.mTemplates);
                    List unused2 = BusinessDySearchPresent.this.f39507l = new ArrayList();
                    try {
                        List unused3 = BusinessDySearchPresent.this.f39506k = BusinessDataHelper.parseDyBusinessSearchEntity(businessSearchResultEntity, BusinessDySearchPresent.this.f39507l, BusinessDySearchPresent.this.f39503h, BusinessDySearchPresent.this.getScope());
                        if (CollectionsUtil.isEmpty(BusinessDySearchPresent.this.f39506k)) {
                            BusinessDySearchPresent.this.m28053g();
                        } else {
                            for (ComponentModel componentModel : BusinessDySearchPresent.this.f39506k) {
                                if (!(componentModel == null || componentModel.getDataModel() == null || !(componentModel.getDataModel() instanceof BusinessGoodsItemRvModel))) {
                                    BusinessDySearchPresent.this.f39507l.add((BusinessGoodsItemRvModel) componentModel.getDataModel());
                                }
                            }
                            BusinessDySearchPresent.this.f39508m.clear();
                            BusinessDySearchPresent.this.f39508m.addAll(BusinessDySearchPresent.this.f39506k);
                            LogUtil.m29100d(BusinessDySearchPresent.f39496a, "data:" + BusinessDySearchPresent.this.f39506k.size());
                            BusinessDySearchPresent.this.m28044c();
                            BusinessDySearchPresent.this.m28032a(true);
                        }
                        BusinessDySearchPresent.this.m28058i();
                        if (businessSearchResultEntity != null) {
                            BusinessDySearchPresent.this.f39510o.autoAddTraceCnt(businessSearchResultEntity.recId);
                        } else {
                            BusinessDySearchPresent.this.f39510o.autoAddTraceCnt();
                        }
                        BusinessDySearchPresent.this.m28062k().onSearchItemSw(BusinessDySearchPresent.this.f39510o.mRecId, BusinessDySearchPresent.this.f39510o.mTraceCnt);
                        Cancelable unused4 = BusinessDySearchPresent.this.f39512q = null;
                    } catch (Exception e) {
                        BusinessDySearchPresent.this.m28020a("parseDyBusinessSearchEntity error", "c-data|").setMessage(e.getMessage()).build().error();
                        BusinessDySearchPresent.this.m28053g();
                    }
                }
            }
        }, this.f39510o), SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m28053g() {
        this.f39508m.clear();
        this.f39504i.setAbnormalVm(TopGunAbnormalFactory.buildShopNoResultService());
        this.f39508m.add(this.f39504i);
        m28056h();
        m28062k().onSearchNoResultSw(this.f39510o.mRecId, this.f39510o.mKeyWord);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28029a(String str) {
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            this.f39508m.clear();
            this.f39504i.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessDySearchPresent.this.m28045c(view);
                }
            }));
            this.f39508m.add(this.f39504i);
            m28056h();
        } else if (this.f39508m.size() == 0 || this.f39508m.indexOf(this.f39504i) >= 0) {
            this.f39508m.clear();
            this.f39504i.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessDySearchPresent.this.m28037b(view);
                }
            }));
            this.f39508m.add(this.f39504i);
            m28056h();
        } else {
            ((BusinessDySearchView) getLogicView()).showNetErrorToast();
        }
        BusinessSearchChangeListener businessSearchChangeListener = this.f39515t;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.hideRecommendWord();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m28045c(View view) {
        this.f39508m.clear();
        onSearchWordRequest(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28037b(View view) {
        this.f39508m.clear();
        onSearchWordRequest(2);
    }

    /* renamed from: h */
    private void m28056h() {
        m28032a(false);
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        ((BusinessDySearchView) getLogicView()).hideSearchFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m28058i() {
        if (this.f39508m.size() > 2) {
            this.f39509n.setItem(m28059j());
            LogUtil.m29100d(f39496a, "updateBottomDivider: add");
        } else {
            this.f39509n.removeItem();
            LogUtil.m29100d(f39496a, "updateBottomDivider: remove");
        }
        ((BusinessDySearchView) getLogicView()).scrollToTop();
    }

    /* renamed from: j */
    private CustomerDividerLineRvModel m28059j() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 110.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_gery_7_97_F5F5F7));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28032a(boolean z) {
        BusinessSearchChangeListener businessSearchChangeListener = this.f39515t;
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
    public BusinessOmegaHelper m28062k() {
        if (this.f39502g == null) {
            this.f39502g = new BusinessOmegaHelper(getScopeContext(), this.f39497b, this.f39503h);
        }
        return this.f39502g;
    }

    /* renamed from: l */
    private void m28064l() {
        this.f39500e = BusinessOmegaModel.newInstance(this.f39498c);
        BusinessInfoEntity businessInfoEntity = this.f39498c;
        if (businessInfoEntity != null) {
            BusinessSearchHotWordEntity businessSearchHotWordEntity = businessInfoEntity.recItemSearchWords;
            if (businessSearchHotWordEntity != null) {
                this.f39499d.mHotWordList = businessSearchHotWordEntity.recWords;
                this.f39499d.mHotWordRecId = businessSearchHotWordEntity.recId;
            }
            m28062k().onSearchShow(this.f39499d);
            m28062k().onSearchHotWordShow(this.f39499d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.f39498c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m28041b(boolean r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0010
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r0.f39498c
            if (r1 == 0) goto L_0x0010
            int r1 = r1.wineConfirm
            if (r1 != 0) goto L_0x0010
            boolean r1 = r0.f39516u
            if (r1 != 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.search.BusinessDySearchPresent.m28041b(boolean):boolean");
    }

    /* renamed from: a */
    private void m28027a(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        if (businessGoodsItemRvModel != null) {
            OmegaCommonParamHelper.setLv3Body(StringUtils.SP_DATA_ITEM + businessGoodsItemRvModel.mGoodsId);
            OmegaCommonParamHelper.setLv3Location(ParamConst.PARAM_SHOP_SEARCH + "_" + businessGoodsItemRvModel.mCateId + "_" + 0 + "_" + 0 + "_" + 0 + "_" + businessGoodsItemRvModel.mInCategoryIndex + "_" + 0 + "_" + (z ? 1 : 0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m28020a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f39496a).setLogModule("m-business|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f39497b).setOtherParam("business_status", Integer.valueOf(this.f39503h));
    }

    /* renamed from: a */
    private void m28030a(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2) {
        m28062k().onSearchGoodsItemClick(str, businessGoodsItemRvModel, i, i2, this.f39500e, this.f39510o.mRecId, this.f39510o.mTraceCnt);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28040b(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        String str;
        m28027a(businessGoodsItemRvModel, z);
        boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39498c);
        int i = z ? 6 : 2;
        if (BusinessDataHelper.isNeedReloadSubitem(this.f39498c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
            m28030a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, 0);
            if (TextUtils.isEmpty(businessGoodsItemRvModel.mBusinessId) && (str = this.f39497b) != null) {
                businessGoodsItemRvModel.mBusinessId = str;
            }
            BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28041b(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f39501f, i, this.f39517v, new int[0]);
            return;
        }
        GoodsItemEntity findGoodDyEntitySearch = BusinessDataHelper.findGoodDyEntitySearch(this.f39505j, this.f39508m.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
        m28030a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodDyEntitySearch) ? 1 : 0);
        if (findGoodDyEntitySearch != null) {
            BusinessDataHelper.dispatchAddAction(getScopeContext(), findGoodDyEntitySearch, businessGoodsItemRvModel, this.f39501f, i, this.f39517v, m28041b(businessGoodsItemRvModel.mNeedAlcoholRemind), m28062k(), (CartItemModel) null);
        }
    }

    /* renamed from: a */
    private void m28026a(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2, boolean z) {
        String str3;
        m28027a(businessGoodsItemRvModel, z);
        if (!m28065m()) {
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39498c);
            int i = z ? 6 : 2;
            if (BusinessDataHelper.isNeedReloadSubitem(this.f39498c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
                m28030a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, 0);
                if (TextUtils.isEmpty(businessGoodsItemRvModel.mBusinessId) && (str3 = this.f39497b) != null) {
                    businessGoodsItemRvModel.mBusinessId = str3;
                }
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28041b(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f39501f, i, this.f39517v, new int[0]);
                return;
            }
            GoodsItemEntity findGoodEntitySearch = BusinessDataHelper.findGoodEntitySearch(this.f39505j, this.f39508m.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
            m28030a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntitySearch) ? 1 : 0);
            if (findGoodEntitySearch != null) {
                BusinessDataHelper.dispatchMinusAction(getScopeContext(), findGoodEntitySearch, businessGoodsItemRvModel, this.f39501f, i, this.f39517v, m28041b(businessGoodsItemRvModel.mNeedAlcoholRemind), m28062k(), str, str2);
            }
        }
    }

    /* renamed from: m */
    private boolean m28065m() {
        if (this.f39498c != null) {
            return false;
        }
        m28020a("businessEntityIsNull", "c-data|").build().info();
        return true;
    }

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
        super.registerScopeActions(iBlockScope);
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_ADD, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m28046d((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_MINUS, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m28042c((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_CLICK, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m28034b((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_EXPOSURE, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m28018a((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ ActionResult m28046d(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f39514s.getMainGoodState(this.f39497b, goodRvModelFromParam.mItemUniqKey);
            if (mainGoodState != null) {
                mainGoodState.amount++;
            }
            goodRvModelFromParam.mGoodsAmountModel.updateGoodsItemAmountModel(mainGoodState);
            Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
            if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
                ((BusinessDySearchView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
                if (!goodRvModelFromParam.hasMultipleContents && goodRvModelFromParam.mHasWine != 1 && !BusinessDataHelper.isNeedReloadSubitem(goodRvModelFromParam) && !BusinessDataHelper.isNeedReloadSubitem(this.f39498c)) {
                    ((BusinessDySearchView) getLogicView()).playAdd2CartAnim();
                }
            }
            onGoodsAddClick(goodRvModelFromParam);
        }
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ ActionResult m28042c(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        String str;
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        CartInfoModel cartInfoModel = this.f39518w;
        if (cartInfoModel == null) {
            return ActionResult.resolve();
        }
        String cartId = cartInfoModel.getCartId();
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f39514s.getMainGoodState(this.f39497b, goodRvModelFromParam.mItemUniqKey);
            if (mainGoodState != null) {
                mainGoodState.amount--;
                LogUtil.m29100d("dispatchAddAction", "SCOPE_ACTION_ON_GOOD_MINUS amount : " + mainGoodState.amount);
                if (TextUtils.isEmpty(mainGoodState.mduId)) {
                    return ActionResult.resolve();
                }
                str = mainGoodState.mduId;
            } else {
                str = "";
            }
            goodRvModelFromParam.mGoodsAmountModel.updateGoodsItemAmountModel(mainGoodState);
            onGoodsMinusClick(goodRvModelFromParam, str, cartId);
        }
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ ActionResult m28034b(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
        if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
            ((BusinessDySearchView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
        }
        onGoodsItemClick(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ ActionResult m28018a(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        onGoodsItemExposure(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* renamed from: a */
    private View m28016a(View view) {
        int width = view.getWidth();
        View view2 = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px));
        layoutParams.gravity = 17;
        view2.setLayoutParams(layoutParams);
        view2.setAlpha(0.25f);
        view2.setBackgroundResource(R.drawable.customer_skin_add_view_virtual_animation_bg);
        return view2;
    }
}
