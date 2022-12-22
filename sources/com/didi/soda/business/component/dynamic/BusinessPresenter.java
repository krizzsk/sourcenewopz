package com.didi.soda.business.component.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.component.dynamic.home.Contract;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.PreviewImageRepo;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessActionRepo;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.soda.business.manager.BusinessDialogHelper;
import com.didi.soda.business.manager.BusinessGuideManager;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.model.BusinessPageLifeStateRepo;
import com.didi.soda.business.page.BusinessHomePage;
import com.didi.soda.business.page.BusinessSearchPage;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.login.LoginListener;
import com.didi.soda.customer.foundation.push.model.AnchorInfoModel;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.AnchorInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessFavorResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.didi.soda.router.DiRouter;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

public class BusinessPresenter extends Contract.AbsBusinessPresenter {

    /* renamed from: c */
    private static final String f39414c = "BusinessPresenter";

    /* renamed from: A */
    private int f39415A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f39416B = false;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f39417C = false;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f39418D = false;

    /* renamed from: E */
    private String f39419E;

    /* renamed from: F */
    private String f39420F = "0";

    /* renamed from: G */
    private Subscription f39421G;

    /* renamed from: H */
    private int f39422H = 0;

    /* renamed from: I */
    private int f39423I = 0;

    /* renamed from: J */
    private int f39424J = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_80);

    /* renamed from: K */
    private int f39425K = -1;

    /* renamed from: L */
    private BusinessPayload f39426L;

    /* renamed from: M */
    private CartInfoModel f39427M;

    /* renamed from: N */
    private boolean f39428N;

    /* renamed from: O */
    private boolean f39429O;

    /* renamed from: P */
    private BusinessGoodsItemRvModel f39430P;

    /* renamed from: a */
    int f39431a = 0;

    /* renamed from: b */
    int f39432b = -1;

    /* renamed from: d */
    private ICustomerBusinessManager f39433d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f39434e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BusinessEntity f39435f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BusinessHeaderRvModel f39436g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LinkedHashMap<String, BusinessCategoryRvModel> f39437h;

    /* renamed from: i */
    private HashMap<String, GoodsAmountModel> f39438i = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<BusinessGoodsItemRvModel> f39439j = new ArrayList();

    /* renamed from: k */
    private ChildDataListManager<RecyclerModel> f39440k;

    /* renamed from: l */
    private CartItemStateRepo f39441l;

    /* renamed from: m */
    private boolean f39442m = false;

    /* renamed from: n */
    private Subscription f39443n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f39444o = 1;

    /* renamed from: p */
    private String f39445p = "";

    /* renamed from: q */
    private String f39446q = "";

    /* renamed from: r */
    private BusinessOmegaHelper f39447r;

    /* renamed from: s */
    private BusinessOmegaModel f39448s = new BusinessOmegaModel();

    /* renamed from: t */
    private BusinessCategoryListener f39449t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f39450u = "";

    /* renamed from: v */
    private int f39451v;

    /* renamed from: w */
    private String f39452w;

    /* renamed from: x */
    private int f39453x;

    /* renamed from: y */
    private String f39454y;

    /* renamed from: z */
    private String f39455z;

    interface GetModelCallBack {
        boolean doBeforeSetMddel(BusinessGoodsItemRvModel businessGoodsItemRvModel);
    }

    public void updateAnchorData(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
    }

    public void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        m27983u().onClassifyTabSw(businessCategoryRvModel.mCategoryId, businessCategoryRvModel.mCategoryIndex, businessCategoryRvModel.mCategoryName, 1, businessCategoryRvModel.mItemCount, this.f39446q);
    }

    public void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        if (z) {
            m27911a("onTabClicked", "c-act|").setOtherParam("cate_index", Integer.valueOf(i)).build().info();
            m27983u().onClassifyTabClick(businessCategoryRvModel.mCategoryId, businessCategoryRvModel.mCategoryIndex, businessCategoryRvModel.mCategoryName, 1);
        }
        BusinessHeaderRvModel businessHeaderRvModel = this.f39436g;
        if (businessHeaderRvModel != null && !CollectionsUtil.isEmpty(businessHeaderRvModel.mCategoryMenuList) && this.f39425K != i && i < this.f39436g.mCategoryMenuList.size() && this.f39425K < this.f39436g.mCategoryMenuList.size()) {
            if (this.f39425K == -1) {
                this.f39436g.mCategoryMenuList.get(0).isSelected = true;
            } else {
                this.f39436g.mCategoryMenuList.get(i).isSelected = true;
                this.f39436g.mCategoryMenuList.get(this.f39425K).isSelected = false;
            }
            this.f39425K = i;
        }
    }

    public void onMoreTabExposure() {
        m27983u().onMoreClassifyTabSw();
    }

    public void onPageResult(Bundle bundle) {
        int i = 0;
        if (bundle.getBoolean(Const.PageParams.BUSINESS_GOODS_PURCHASED, false)) {
            String string = bundle.getString(Const.PageParams.ITEM_UNIQ_KEY);
            ((Contract.AbsBusinessView) getLogicView()).playAdd2CartAnim();
            ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
            if (childDataListManager != null && childDataListManager.size() > 0 && !TextUtils.isEmpty(string)) {
                int size = this.f39440k.size();
                while (true) {
                    if (i < size) {
                        if ((this.f39440k.get(i) instanceof BusinessGoodsItemRvModel) && string.equals(((BusinessGoodsItemRvModel) this.f39440k.get(i)).mItemUniqKey)) {
                            BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39440k.get(i);
                            businessGoodsItemRvModel.mAddToCartAnimation = true;
                            this.f39440k.set(i, businessGoodsItemRvModel);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (bundle.getString("from") != null && bundle.getString("from").contains("businesssearch")) {
            ((IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
        }
    }

    public int getCategoryRvIndex(int i) {
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap;
        ChildDataListManager<RecyclerModel> childDataListManager;
        if (!(i == 0 || (linkedHashMap = this.f39437h) == null)) {
            Iterator<BusinessCategoryRvModel> it = linkedHashMap.values().iterator();
            BusinessCategoryRvModel businessCategoryRvModel = null;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BusinessCategoryRvModel next = it.next();
                if (i2 == i) {
                    businessCategoryRvModel = next;
                    break;
                }
                i2++;
            }
            if (!(businessCategoryRvModel == null || (childDataListManager = this.f39440k) == null)) {
                return childDataListManager.indexOf(businessCategoryRvModel);
            }
        }
        return 0;
    }

    public void goBusinessDetail() {
        m27911a("goBusinessDetail", "c-act|").build().info();
        BusinessEntity businessEntity = this.f39435f;
        DiRouter.request().path(RoutePath.BUSINESS_DETAIL).putSerializable(Const.PageParams.SHOP_ID, this.f39434e).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, (businessEntity == null || businessEntity.shopInfo == null) ? null : this.f39435f.shopInfo).putSerializable(Const.PageParams.SHOP_OMEGA_MODEL, this.f39448s).open();
    }

    public void onBusinessFavor(boolean z) {
        BusinessHeaderRvModel businessHeaderRvModel = this.f39436g;
        if (businessHeaderRvModel != null) {
            businessHeaderRvModel.isFavor = z;
        }
        BusinessOmegaHelper businessOmegaHelper = this.f39447r;
        if (businessOmegaHelper != null) {
            businessOmegaHelper.onFavorClick(this.f39434e, this.f39444o, z);
        }
        CustomerRpcManagerProxy.get().setBusinessFavor(this.f39434e, z ? 1 : 0, new CustomerRpcCallback<BusinessFavorResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
            }

            public void onRpcSuccess(BusinessFavorResultEntity businessFavorResultEntity, long j) {
            }
        });
    }

    public void goBusinessSearch() {
        int i;
        BusinessInfoEntity businessInfoEntity;
        m27983u().onHeaderSearchClick();
        BusinessEntity businessEntity = this.f39435f;
        String str = null;
        if (businessEntity == null || businessEntity.shopInfo == null) {
            i = 1;
            businessInfoEntity = null;
        } else {
            BusinessInfoEntity businessInfoEntity2 = this.f39435f.shopInfo;
            String str2 = this.f39435f.shopInfo.cartRevision;
            i = this.f39435f.shopInfo.cShopStatus;
            BusinessInfoEntity businessInfoEntity3 = businessInfoEntity2;
            str = str2;
            businessInfoEntity = businessInfoEntity3;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.PageParams.SHOP_ID, this.f39434e);
        bundle.putInt(Const.PageParams.SHOP_STATUS, i);
        bundle.putString(Const.PageParams.CART_REVISION, str);
        bundle.putSerializable(Const.PageParams.SHOP_INFO_ENTITY, businessInfoEntity);
        bundle.putString(Const.PageParams.BIDATA, this.f39450u);
        getScopeContext().getNavigator().pushForResult((BusinessSearchPage) PageFactory.newInstance(BusinessSearchPage.class, bundle));
    }

    public boolean isDataLoadSuccess() {
        return this.f39442m;
    }

    public void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
        int i2 = -1;
        if (linkedHashMap != null) {
            BusinessCategoryRvModel businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId);
            if (businessCategoryRvModel != null) {
                i2 = businessCategoryRvModel.mCategoryIndex;
            }
            i = i2;
        } else {
            i = -1;
        }
        m27911a("Exposure: {id}" + businessGoodsItemRvModel2.mGoodsId + " {uniKey}" + businessGoodsItemRvModel2.mItemUniqKey + " {name}" + businessGoodsItemRvModel2.mGoodsName, "c-show|").build().info();
        if (businessGoodsItemRvModel2.mActinfo != null) {
            Integer.toString(businessGoodsItemRvModel2.mActinfo.getActType());
        }
        m27983u().onItemExposure(businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mStatus, businessGoodsItemRvModel2.mGoodsMarketingTipString, this.f39445p, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateName, i, businessGoodsItemRvModel2.mInCategoryIndex, 0, businessGoodsItemRvModel2.mHeadImg, businessGoodsItemRvModel2.mSoldStatus, businessGoodsItemRvModel2.mSoldTimeDesc, businessGoodsItemRvModel2.mPrice + "", businessGoodsItemRvModel2.mSpecialPrice + "", businessGoodsItemRvModel2.mActivityType + "", businessGoodsItemRvModel2.mAdditionalType, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.hasMultipleContents ? 1 : 0, businessGoodsItemRvModel2.mInCategoryIndex);
    }

    public void showMoreCategory(BusinessSelectedCallback businessSelectedCallback) {
        m27983u().onMoreClassifyTabCk();
        BusinessCategoryListener businessCategoryListener = this.f39449t;
        if (businessCategoryListener != null) {
            BusinessHeaderRvModel businessHeaderRvModel = this.f39436g;
            businessCategoryListener.showDyCategory(businessHeaderRvModel != null ? businessHeaderRvModel.mCategoryMenuList : null, businessSelectedCallback);
        }
    }

    public boolean hasDynamicNotice() {
        return BusinessDataHelper.hasDynamicNotice(this.f39435f);
    }

    public void onFavorLogin() {
        LoginUtil.updateLoginPopToRootStatus(false);
        LoginUtil.loginActivityAndTrack(getContext(), 18, new LoginListener() {
            public /* synthetic */ void onCancel() {
                LoginListener.CC.$default$onCancel(this);
            }

            public void onSuccess(String str) {
                BusinessPresenter.this.onBusinessFavor(true);
                ((Contract.AbsBusinessView) BusinessPresenter.this.getLogicView()).favorBusiness();
            }
        });
    }

    public void onExpandOrFoldAction(BusinessExpandRvModel businessExpandRvModel, int i) {
        List<ComponentModel> list = businessExpandRvModel.mComponentModelExpandList;
        if (CollectionsUtil.isEmpty(list)) {
            List<BusinessGoodsItemRvModel> list2 = businessExpandRvModel.mExpandList;
            if (businessExpandRvModel.mIsExpand) {
                this.f39440k.addAll(i, list2);
                return;
            }
            for (BusinessGoodsItemRvModel indexOf : list2) {
                this.f39440k.remove(this.f39440k.indexOf(indexOf));
            }
        } else if (businessExpandRvModel.mIsExpand) {
            this.f39440k.addAll(i, list);
            ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
            childDataListManager.remove(childDataListManager.indexOf(businessExpandRvModel));
        }
    }

    public void onExpandShow(BusinessExpandRvModel businessExpandRvModel) {
        m27983u().onExpandExposure(businessExpandRvModel);
    }

    public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
        m27983u().onExpandClickEvent(businessExpandRvModel);
    }

    public void onRvScrolled(int i) {
        LogUtil.m29100d(f39414c, "onRvScrolled:" + i);
        if (Math.abs(i) <= this.f39424J) {
            LogUtil.m29100d(f39414c, "onRvScrolled a little:" + i);
        } else if (i > 0) {
            m27983u().onRvScrolled(1);
        } else {
            m27983u().onRvScrolled(2);
        }
    }

    public void onTabScrolled(int i) {
        LogUtil.m29100d(f39414c, "onTabScrolled:" + i);
        if (Math.abs(i) <= this.f39424J) {
            LogUtil.m29100d(f39414c, "onTabScrolled a little:" + i);
        } else if (i > 0) {
            m27983u().onTabScrolled(3);
        } else {
            m27983u().onTabScrolled(4);
        }
    }

    public void onBack(int i) {
        Bundle bundle = new Bundle();
        BusinessHeaderRvModel businessHeaderRvModel = this.f39436g;
        if (businessHeaderRvModel != null) {
            bundle.putInt(Const.PageParams.IS_BUSINESS_FAVORED, businessHeaderRvModel.isFavor);
        }
        if (!TextUtils.isEmpty(this.f39434e)) {
            bundle.putString(Const.PageParams.SHOP_ID, this.f39434e);
        }
        this.f39448s.mReturnWay = i;
        String str = (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName");
        bundle.putString("fromPage", str);
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", str).build().track();
        getScopeContext().getNavigator().finish(bundle);
    }

    public void onCreate() {
        super.onCreate();
        m27911a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
        m27953d();
        m27956e();
        m27962f();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m27911a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
        m27913a();
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f39434e);
        if (state != null) {
            state.mHasShowedWineRemind = false;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
        ((BusinessPageLifeStateRepo) RepoFactory.getRepo(BusinessPageLifeStateRepo.class)).setState(1);
        BusinessDialogHelper.dismissAllDialog();
        m27983u().onExit(this.f39448s.mDistance, this.f39448s.mReturnWay, this.f39448s.mDeliveryFee, this.f39448s.mDeliveryTime, this.f39448s.mExposureActivityNum, this.f39448s.mTabTypeList, this.f39448s.mDeliveryType, this.f39448s.couponNum, this.f39448s.mRecId, this.f39448s.mIsMarketArea);
    }

    public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        BusinessCategoryRvModel businessCategoryRvModel;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        m27937b(businessGoodsItemRvModel2, false);
        m27911a("onGoodsItemClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel2.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel2.mGoodsId).build().info();
        if (!m27984v()) {
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
            int i = -1;
            if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId)) == null)) {
                i = businessCategoryRvModel.mCategoryIndex;
            }
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo);
            if (BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
                m27928a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem ? 1 : 0, 0);
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m27931a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39450u, 1, this.f39419E, i);
                return;
            }
            GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f39435f, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
            m27928a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
            if (findGoodEntity != null) {
                BusinessDataHelper.toGoodItemDetail(getScopeContext(), findGoodEntity, businessGoodsItemRvModel2.mInCategoryIndex, m27931a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39450u, 1, this.f39419E, businessGoodsItemRvModel2.mCateId, i);
            }
        }
    }

    public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        m27937b(businessGoodsItemRvModel, true);
        m27928a(EventConst.Business.SHOP_ITEM_PHOTO_CK, businessGoodsItemRvModel, BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo) ? 1 : 0, GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntity(this.f39435f, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) ? 1 : 0);
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
        if (linkedHashMap != null) {
            BusinessCategoryRvModel businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId);
            i = businessCategoryRvModel != null ? businessCategoryRvModel.mCategoryIndex : -1;
        } else {
            i = 0;
        }
        String string = view.getContext().getString(R.string.customer_transition_tag_business_preview_image_named, new Object[]{String.valueOf(System.currentTimeMillis())});
        ViewCompat.setTransitionName(view, string);
        DiRouter.request().path(RoutePath.BUSINESS_PREVIEW_IMAGE).setFromPage(getScopeContext()).putString(Const.PageParams.TRANSITION_NAMES, string).putSerializable(Const.PageParams.PREVIEW_IMAGE, PreviewImageModel.copyFrom(businessGoodsItemRvModel, view, i, this.f39445p, -1)).open();
    }

    public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m27911a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m27923a(businessGoodsItemRvModel, false);
    }

    public void onGoodsMinusClick(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2) {
        m27911a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m27922a(businessGoodsItemRvModel, str, str2, false);
    }

    public void setBusinessCategoryListener(BusinessCategoryListener businessCategoryListener) {
        this.f39449t = businessCategoryListener;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m27911a("onStart", "c-state|").build().info();
        OmegaCommonParamHelper.refreshLv3GuideParam();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f39443n == null) {
            this.f39443n = BusinessRepo.get(getScopeContext()).subscribe(getScopeContext(), new Action1<CustomerResource<BusinessEntity>>() {
                public void call(CustomerResource<BusinessEntity> customerResource) {
                    if (customerResource != null) {
                        if (customerResource.status == Resource.Status.LOADING) {
                            BusinessPresenter.this.m27966h();
                        } else {
                            BusinessPresenter.this.m27968i();
                            if (customerResource.data == null) {
                                BusinessPresenter.this.m27939b(ResourceHelper.getString(R.string.customer_global_no_data_available));
                                return;
                            }
                            int i = C134347.$SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status[customerResource.status.ordinal()];
                            if (i == 1 || i == 2) {
                                BusinessPresenter.this.m27926a(customerResource);
                            } else if (i == 3) {
                                BusinessPresenter.this.m27939b(customerResource.message);
                            }
                        }
                        if (!BusinessPresenter.this.f39418D && customerResource.data != null && ((BusinessEntity) customerResource.data).shopInfo != null && !TextUtils.isEmpty(((BusinessEntity) customerResource.data).shopInfo.cartRevision)) {
                            boolean unused = BusinessPresenter.this.f39418D = true;
                            ((IFloatingCartProvider) BusinessPresenter.this.getScopeContext().getObject("service_floating_cart_key")).showFloatingCart(((BusinessEntity) customerResource.data).shopInfo.cartRevision, ((BusinessEntity) customerResource.data).shopInfo.cShopStatus, BusinessPresenter.this.f39450u, BusinessPresenter.this.f39417C);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.didi.soda.business.component.dynamic.BusinessPresenter$7 */
    static /* synthetic */ class C134347 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.app.nova.skeleton.repo.Resource$Status[] r0 = com.didi.app.nova.skeleton.repo.Resource.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status = r0
                com.didi.app.nova.skeleton.repo.Resource$Status r1 = com.didi.app.nova.skeleton.repo.Resource.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.app.nova.skeleton.repo.Resource$Status r1 = com.didi.app.nova.skeleton.repo.Resource.Status.CHANGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.app.nova.skeleton.repo.Resource$Status r1 = com.didi.app.nova.skeleton.repo.Resource.Status.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.BusinessPresenter.C134347.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27923a(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        if (businessGoodsItemRvModel != null) {
            m27937b(businessGoodsItemRvModel, z);
            if (!m27984v()) {
                int i = z ? 5 : 1;
                boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo);
                LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
                int i2 = -1;
                if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId)) == null)) {
                    i2 = businessCategoryRvModel.mCategoryIndex;
                }
                if (BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo)) {
                    m27928a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, 0);
                    BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m27931a(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f39450u, i, this.f39419E, i2);
                    return;
                }
                GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f39435f, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
                m27928a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
                if (findGoodEntity != null) {
                    BusinessDataHelper.dispatchAddAction(getScopeContext(), findGoodEntity, businessGoodsItemRvModel, this.f39450u, i, this.f39419E, m27931a(businessGoodsItemRvModel.mNeedAlcoholRemind), m27983u(), (CartItemModel) null);
                }
            }
        }
    }

    /* renamed from: a */
    private void m27922a(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        boolean z2 = z;
        m27937b(businessGoodsItemRvModel, z2);
        if (!m27984v()) {
            int i = z2 ? 5 : 1;
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo);
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
            int i2 = -1;
            if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId)) == null)) {
                i2 = businessCategoryRvModel.mCategoryIndex;
            }
            if (BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo)) {
                m27928a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, 0);
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m27931a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39450u, i, this.f39419E, i2);
                return;
            }
            GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f39435f, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
            m27928a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
            if (findGoodEntity != null) {
                BusinessDataHelper.dispatchMinusAction(getScopeContext(), findGoodEntity, businessGoodsItemRvModel, this.f39450u, i, this.f39419E, m27931a(businessGoodsItemRvModel2.mNeedAlcoholRemind), m27983u(), str, str2);
            }
        }
    }

    /* renamed from: a */
    private void m27913a() {
        this.f39438i.clear();
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
        if (childDataListManager != null) {
            childDataListManager.clear();
            this.f39440k = null;
        }
        this.f39439j.clear();
        clearDataManagers();
        m27983u().reset();
    }

    public int getBusinessDialogSourceType() {
        if (this.f39422H == 1) {
            return 2;
        }
        if (TextUtils.equals(this.f39420F, "1")) {
            return 1;
        }
        return 0;
    }

    /* renamed from: b */
    private void m27934b() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.ANCHOR_INFO);
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ANCHOR_INFO2);
        }
        try {
            AnchorInfoModel anchorInfoModel = (AnchorInfoModel) GsonUtil.fromJson(string, AnchorInfoModel.class);
            if (anchorInfoModel != null) {
                this.f39452w = anchorInfoModel.itemId;
                this.f39451v = anchorInfoModel.anchorStatus;
            }
        } catch (Exception e) {
            LogUtil.m29104i(f39414c, "anchorInfo parse error: " + e.toString() + string);
        }
    }

    /* renamed from: c */
    private void m27947c() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.ACTION_INFO);
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ACTION_INFO_DICT);
        }
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ACTION_INFO_DICT2);
        }
        try {
            ActionInfoEntity actionInfoEntity = (ActionInfoEntity) GsonUtil.fromJson(string, ActionInfoEntity.class);
            if (actionInfoEntity != null) {
                this.f39453x = actionInfoEntity.getType();
                this.f39454y = actionInfoEntity.getItemId();
            }
        } catch (Exception e) {
            LogUtil.m29104i(f39414c, "actionInfo parse error: " + e.toString() + string);
        }
    }

    /* renamed from: d */
    private void m27953d() {
        this.f39433d = (ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class);
    }

    /* renamed from: e */
    private void m27956e() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        this.f39434e = string;
        bundle.putString("current_shop_id", string);
        this.f39450u = bundle.getString(Const.PageParams.BIDATA, "");
        this.f39455z = bundle.getString(Const.PageParams.SHOP_ITEM_SEARCH_INFO);
        this.f39420F = bundle.getString(Const.URI_FROM_OUTER, "0");
        this.f39422H = bundle.getInt("sceneType", 0);
        this.f39423I = bundle.getInt("fromType", 0);
        int i = bundle.getInt(Const.PageParams.WINE_CONFIRM, 0);
        this.f39415A = i;
        if (i == 1) {
            this.f39416B = true;
        }
        m27934b();
        m27947c();
    }

    /* renamed from: f */
    private void m27962f() {
        this.f39441l = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(this.f39434e, getScopeContext(), new Action1<BusinessState>() {
            public void call(BusinessState businessState) {
                if (businessState != null) {
                    boolean unused = BusinessPresenter.this.f39416B = businessState.mHasShowedWineRemind;
                    BusinessDataHelper.addBlockScopeParam(businessState, BusinessPresenter.this.getScope());
                }
                if (businessState != null && BusinessPresenter.this.f39444o != businessState.shopStatus) {
                    if (!(BusinessPresenter.this.f39435f == null || BusinessPresenter.this.f39435f.shopInfo == null)) {
                        try {
                            BusinessPresenter.this.f39435f.shopInfo.cShopStatus = businessState.shopStatus;
                            LinkedHashMap unused2 = BusinessPresenter.this.f39437h = BusinessDataHelper.parseBusinessEntity(BusinessPresenter.this.f39435f, BusinessPresenter.this.f39436g.mCategoryList, BusinessPresenter.this.f39436g.mCategoryMenuList, BusinessPresenter.this.getScope(), BusinessPresenter.this.m27975m());
                            BusinessPresenter.this.clearDataManagers();
                            BusinessPresenter.this.m27977o();
                            LogUtil.m29100d(BusinessPresenter.f39414c, "BusinessStateRepo changed and showCategoryAndGoods");
                            if (BusinessPresenter.this.f39436g != null) {
                                BusinessPresenter.this.f39436g.updateBusinessStatus(businessState.shopStatus, businessState.shopStatusDesc);
                                ((Contract.AbsBusinessView) BusinessPresenter.this.getLogicView()).updateHeaderView(BusinessPresenter.this.f39436g, BusinessPresenter.this.getScope());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", BusinessPresenter.this.f39434e).addParam("errmsg", e.toString()).build().trackError();
                            BusinessPresenter.this.m27927a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                            BusinessPresenter.this.m27911a("parseBusinessEntity error", "c-data|").setMessage(e.getMessage()).build().error();
                            return;
                        }
                    }
                    BusinessPresenter.this.m27914a(businessState.shopStatus);
                }
            }
        });
        ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).subscribe(getScopeContext(), new Action1<PreviewImageModel>() {
            public void call(PreviewImageModel previewImageModel) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(BusinessPresenter.this.f39439j, previewImageModel.mGoodId, previewImageModel.mCateId);
                if (findGoodsItemRvModel != null) {
                    BusinessPresenter.this.m27911a("onImageAddClick", "c-act|").setOtherParam("cate_id", findGoodsItemRvModel.mCateId).setOtherParam("goods_id", findGoodsItemRvModel.mGoodsId).build().info();
                    BusinessPresenter.this.m27923a(findGoodsItemRvModel, true);
                }
            }
        });
        ((BusinessActionRepo) RepoFactory.getRepo(BusinessActionRepo.class)).subscribe(getScopeContext(), new Action1<BusinessActionParam>() {
            public void call(BusinessActionParam businessActionParam) {
                if (businessActionParam != null) {
                    if (businessActionParam.isNeedRefreshBusiness()) {
                        LogUtil.m29100d("BusinessLink", "requestShopData");
                        BusinessPresenter.this.m27950d("requestShopData").build().info();
                        BusinessHomePage.refreshBusinessData(BusinessPresenter.this.getScopeContext(), businessActionParam.isWithActInfo());
                    }
                    if (businessActionParam.isNeedRefreshCart()) {
                        ((IFloatingCartProvider) BusinessPresenter.this.getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
                    }
                }
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f39434e, (Action1<CustomerResource<CartInfoEntity>>) new Action1() {
            public final void call(Object obj) {
                BusinessPresenter.this.m27938b((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27938b(CustomerResource customerResource) {
        if (customerResource != null && customerResource.data != null) {
            this.f39427M = new CartInfoModel().convertModel((CartInfoEntity) customerResource.data, this.f39444o);
        }
    }

    /* renamed from: g */
    private void m27964g() {
        LogUtil.m29100d("BusinessLink", "requestShopData");
        m27950d("requestShopData").build().info();
        BusinessHomePage.requestBusinessData(getScopeContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m27966h() {
        ((Contract.AbsBusinessView) getLogicView()).showShimmerView();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m27968i() {
        ((Contract.AbsBusinessView) getLogicView()).hideShimmerView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27927a(String str) {
        ((Contract.AbsBusinessView) getLogicView()).showAbnormalView(m27945c(str));
        ((Contract.AbsBusinessView) getLogicView()).showBusinessHeader(false);
        BusinessDialogHelper.dismissAllDialog();
    }

    /* renamed from: j */
    private void m27969j() {
        ((Contract.AbsBusinessView) getLogicView()).hideAbnormalView();
        ((Contract.AbsBusinessView) getLogicView()).showBusinessHeader(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27926a(CustomerResource<BusinessEntity> customerResource) {
        BusinessEntity businessEntity = (BusinessEntity) customerResource.data;
        if (customerResource.mExtension != null) {
            this.f39446q = customerResource.mExtension.getString(ParamConst.TRACE_ID, "");
        }
        m27911a("onLoadShopDataSuccess", "c-data|").build().info();
        this.f39442m = true;
        this.f39435f = businessEntity;
        this.f39445p = businessEntity.recId;
        m27913a();
        m27974l();
        this.f39448s = BusinessOmegaModel.newInstance(businessEntity, this.f39446q);
        int i = 0;
        if (getScope().getObject(BusinessDataHelper.PARA_IS_MARKET_AREA) != null) {
            i = ((Integer) getScope().getObject(BusinessDataHelper.PARA_IS_MARKET_AREA)).intValue();
        }
        this.f39448s.mIsMarketArea = i;
        m27985w();
        this.f39441l.subscribe(this.f39434e, getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessPresenter.this.m27940b((HashMap) obj);
            }
        });
        if (businessEntity.shopInfo != null) {
            ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo(businessEntity.shopInfo.actInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27940b(HashMap hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            m27972k();
        } else {
            m27929a((Map<String, ItemState>) hashMap);
        }
    }

    /* renamed from: k */
    private void m27972k() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39440k.size();
            for (int i = 0; i < size; i++) {
                if (this.f39440k.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39440k.get(i);
                    businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                    this.f39440k.set(i, businessGoodsItemRvModel);
                }
            }
        }
    }

    public int getBusinessSourceType() {
        if (TextUtils.equals(this.f39420F, "1")) {
            return 2;
        }
        int i = this.f39423I;
        if (i == 1) {
            return 4;
        }
        return i == 2 ? 3 : 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27939b(String str) {
        m27911a("onLoadShopDataError", "c-data|").build().info();
        this.f39442m = false;
        m27927a(str);
    }

    /* renamed from: c */
    private TopGunAbnormalViewModel m27945c(String str) {
        $$Lambda$BusinessPresenter$8mgI3mICNlPmvdIpf8jbsX6h8bs r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessPresenter.this.m27916a(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27916a(View view) {
        m27969j();
        m27964g();
        ((IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
    }

    /* renamed from: a */
    private void m27929a(Map<String, ItemState> map) {
        String str;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39440k.size();
            for (int i = 0; i < size; i++) {
                if (this.f39440k.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39440k.get(i);
                    if (!map.containsKey(businessGoodsItemRvModel.mItemUniqKey) || map.get(businessGoodsItemRvModel.mItemUniqKey) == null) {
                        str = "Goods amount is 0 goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey;
                        businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                    } else {
                        str = "Goods amount or status changed...[goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey + ", amount: " + map.get(businessGoodsItemRvModel.mItemUniqKey).amount + com.didichuxing.bigdata.p173dp.locsdk.Const.jaRight;
                        businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                    }
                    m27911a(str, "c-show|").build().info();
                    this.f39440k.set(i, businessGoodsItemRvModel);
                }
            }
        }
    }

    /* renamed from: b */
    private void m27941b(Map<String, ItemState> map) {
        String str;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39440k.size();
            for (int i = 0; i < size; i++) {
                if (this.f39440k.get(i) instanceof ComponentModel) {
                    ComponentModel componentModel = (ComponentModel) this.f39440k.get(i);
                    if (componentModel.getDataModel() instanceof BusinessGoodsItemRvModel) {
                        BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) componentModel.getDataModel();
                        if (!map.containsKey(businessGoodsItemRvModel.mItemUniqKey) || map.get(businessGoodsItemRvModel.mItemUniqKey) == null) {
                            str = "Goods amount is 0 goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey;
                            businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                        } else {
                            str = "Goods amount or status changed...[goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey + ", amount: " + map.get(businessGoodsItemRvModel.mItemUniqKey).amount + com.didichuxing.bigdata.p173dp.locsdk.Const.jaRight;
                            businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                        }
                        m27911a(str, "c-show|").build().info();
                    }
                }
            }
        }
    }

    /* renamed from: l */
    private void m27974l() {
        BusinessEntity businessEntity = this.f39435f;
        if (businessEntity != null) {
            if (businessEntity.shopInfo == null || TextUtils.isEmpty(this.f39435f.shopInfo.cartRevision)) {
                this.f39419E = "0";
            } else {
                this.f39419E = this.f39435f.shopInfo.cartRevision;
            }
            if (CollectionsUtil.isEmpty(this.f39435f.cateInfo)) {
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", this.f39434e).build().trackError();
                m27927a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                m27911a("No Cate", "c-data|").build().error();
                return;
            }
            m27969j();
            BusinessHeaderRvModel newInstance = BusinessHeaderRvModel.newInstance(getContext(), this.f39435f, this.f39426L);
            this.f39436g = newInstance;
            try {
                this.f39437h = BusinessDataHelper.parseBusinessEntity(this.f39435f, newInstance.mCategoryList, this.f39436g.mCategoryMenuList, getScope(), m27975m());
                ((Contract.AbsBusinessView) getLogicView()).updateHeaderView(this.f39436g, getScope());
                m27924a(this.f39435f);
                m27977o();
                m27978p();
                m27915a(this.f39431a, this.f39432b, this.f39428N, this.f39429O);
                if ((TextUtils.equals(this.f39420F, "1") && !BusinessGuideManager.Companion.getInstance().isGuideWidgetShown()) || this.f39422H == 1) {
                    m27976n();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", this.f39434e).addParam("errmsg", e.toString()).build().trackError();
                m27927a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                m27911a("parseBusinessEntity error", "c-data|").setMessage(e.getMessage()).build().error();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public String m27975m() {
        BusinessEntity businessEntity;
        String str = this.f39452w;
        int i = this.f39453x;
        if (!((i != 2 && i != 3) || (businessEntity = this.f39435f) == null || businessEntity.shopInfo == null || this.f39435f.shopInfo.anchorInfo == null)) {
            str = this.f39435f.shopInfo.anchorInfo.itemUniqKey;
            if (TextUtils.isEmpty(str)) {
                str = this.f39435f.shopInfo.anchorInfo.itemId;
            }
        }
        if (getScope() != null && !TextUtils.isEmpty(str)) {
            getScope().attach(BlocksConst.ANCHOR_UNIQ_KEY, str);
        }
        return str;
    }

    /* renamed from: n */
    private void m27976n() {
        if (this.f39421G == null && getScopeContext() != null) {
            LogUtil.m29100d("BusinessLink", "subscribeAddress");
            this.f39421G = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressNoViscous(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    BusinessPresenter.this.m27925a((AddressEntity) obj);
                }
            });
        }
        m27986x();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27925a(AddressEntity addressEntity) {
        m27964g();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m27977o() {
        ((Contract.AbsBusinessView) getLogicView()).updateCategoryAmount(this.f39437h);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (BusinessCategoryRvModel next : this.f39437h.values()) {
            if (!z) {
                next.isFirst = true;
                arrayList.add(next);
                z = true;
            } else {
                arrayList.add(next);
            }
            if (!CollectionsUtil.isEmpty(next.mGoodsItemList)) {
                for (BusinessGoodsItemRvModel next2 : next.mGoodsItemList) {
                    arrayList.add(next2);
                    this.f39438i.put(next2.mItemUniqKey, next2.mGoodsAmountModel);
                    this.f39439j.add(next2);
                }
            }
            if (!CollectionsUtil.isEmpty(next.mGoodsDynamicItemList)) {
                for (ComponentModel next3 : next.mGoodsDynamicItemList) {
                    arrayList.add(next3);
                    if (!(next3 == null || next3.getDataModel() == null || !(next3.getDataModel() instanceof BusinessGoodsItemRvModel))) {
                        BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next3.getDataModel();
                        this.f39438i.put(businessGoodsItemRvModel.mItemUniqKey, businessGoodsItemRvModel.mGoodsAmountModel);
                        this.f39439j.add(businessGoodsItemRvModel);
                    }
                }
            }
            if (next.mExpandRvModel != null) {
                boolean z2 = false;
                for (BusinessGoodsItemRvModel next4 : next.mExpandRvModel.mExpandList) {
                    this.f39438i.put(next4.mItemUniqKey, next4.mGoodsAmountModel);
                    this.f39439j.add(next4);
                    if (this.f39451v == 1 && TextUtils.equals(next4.mGoodsId, this.f39452w)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    next.mExpandRvModel.mIsExpand = true;
                    arrayList.addAll(next.mExpandRvModel.mExpandList);
                }
                arrayList.add(next.mExpandRvModel);
            }
        }
        arrayList.add(m27981s());
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager(arrayList);
        this.f39440k = createChildDataListManager;
        addDataManager(createChildDataListManager);
    }

    /* renamed from: p */
    private void m27978p() {
        AnchorInfoEntity anchorInfoEntity;
        BusinessGoodsItemRvModel businessGoodsItemRvModel;
        int i;
        BusinessEntity businessEntity = this.f39435f;
        if (businessEntity == null || businessEntity.shopInfo == null || this.f39435f.shopInfo.anchorInfo == null || !((i = this.f39453x) == 2 || i == 3)) {
            anchorInfoEntity = null;
        } else {
            anchorInfoEntity = this.f39435f.shopInfo.anchorInfo;
            int i2 = anchorInfoEntity.anchorStatus;
            if (i2 == 2) {
                this.f39452w = anchorInfoEntity.cateId;
                this.f39451v = 2;
            } else {
                if (!TextUtils.isEmpty(anchorInfoEntity.itemUniqKey)) {
                    this.f39452w = anchorInfoEntity.itemUniqKey;
                } else {
                    this.f39452w = anchorInfoEntity.itemId;
                }
                this.f39451v = 1;
            }
            if (anchorInfoEntity.reminder != null && !TextUtils.isEmpty(anchorInfoEntity.reminder.content)) {
                ToastUtil.showCustomerErrorToast(getScopeContext(), anchorInfoEntity.reminder.content);
            }
            if (i2 == 0) {
                this.f39429O = false;
                this.f39428N = false;
                return;
            }
        }
        m27979q();
        if (anchorInfoEntity != null && this.f39451v == 1 && anchorInfoEntity.setItemAction.intValue() == 1 && (businessGoodsItemRvModel = this.f39430P) != null) {
            if (!GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntity(this.f39435f, businessGoodsItemRvModel.mGoodsId, this.f39430P.mItemUniqKey)) && !this.f39430P.mNeedAlcoholRemind) {
                this.f39417C = true;
            }
            this.f39429O = true;
        }
    }

    /* renamed from: q */
    private void m27979q() {
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
        if (linkedHashMap != null) {
            for (BusinessCategoryRvModel next : linkedHashMap.values()) {
                if (this.f39451v == 2) {
                    if (anchorCateGory(next)) {
                        break;
                    }
                }
                if (this.f39451v == 1) {
                    if (anchorItem(next, this.f39452w)) {
                        break;
                    }
                }
                if (this.f39432b >= 0) {
                    break;
                }
            }
            this.f39429O = this.f39453x == 1;
            this.f39428N = true;
            BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(this.f39439j, this.f39454y);
            this.f39430P = findGoodsItemRvModel;
            if (findGoodsItemRvModel != null) {
                findGoodsItemRvModel.mIsAnchorItem = true;
            }
        }
    }

    public boolean anchorCateGory(BusinessCategoryRvModel businessCategoryRvModel) {
        if (businessCategoryRvModel == null) {
            return false;
        }
        if (this.f39452w.equals(businessCategoryRvModel.mCategoryId)) {
            int i = businessCategoryRvModel.mCategoryIndex;
            this.f39431a = i;
            this.f39432b = getCategoryRvIndex(i);
            return true;
        }
        List<ComponentModel> allDyDisplayGoods = businessCategoryRvModel.getAllDyDisplayGoods();
        if (!CollectionsUtil.isEmpty(allDyDisplayGoods)) {
            ComponentModel findGoodItemRvFromComponent = BusinessDataHelper.findGoodItemRvFromComponent(allDyDisplayGoods, this.f39452w);
            this.f39431a = businessCategoryRvModel.mCategoryIndex;
            int indexOf = this.f39440k.indexOf(findGoodItemRvFromComponent);
            this.f39432b = indexOf;
            if (indexOf > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean anchorItem(BusinessCategoryRvModel businessCategoryRvModel, String str) {
        if (businessCategoryRvModel == null) {
            return false;
        }
        List<BusinessGoodsItemRvModel> allDisplayGoods = businessCategoryRvModel.getAllDisplayGoods();
        if (!CollectionsUtil.isEmpty(allDisplayGoods)) {
            for (BusinessGoodsItemRvModel next : allDisplayGoods) {
                if (str.equals(next.mGoodsId)) {
                    this.f39431a = businessCategoryRvModel.mCategoryIndex;
                    this.f39432b = this.f39440k.indexOf(next);
                    return true;
                }
            }
        }
        List<ComponentModel> allDyDisplayGoods = businessCategoryRvModel.getAllDyDisplayGoods();
        if (!CollectionsUtil.isEmpty(allDyDisplayGoods)) {
            ComponentModel findGoodItemRvFromComponent = BusinessDataHelper.findGoodItemRvFromComponent(allDyDisplayGoods, str);
            if (findGoodItemRvFromComponent != null) {
                this.f39431a = businessCategoryRvModel.mCategoryIndex;
                this.f39432b = this.f39440k.indexOf(findGoodItemRvFromComponent);
                return true;
            }
            this.f39432b = -1;
        }
        return false;
    }

    /* renamed from: a */
    private void m27915a(int i, int i2, boolean z, boolean z2) {
        if (z2 && m27980r()) {
            m27923a(this.f39430P, false);
        }
        this.f39430P = null;
        if (i != 0 || i2 > 0) {
            if (z) {
                ((Contract.AbsBusinessView) getLogicView()).anchorView(i, i2, (BusinessGoodsItemRvModel) null);
            }
            this.f39431a = 0;
            this.f39432b = -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.f39435f;
     */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m27980r() {
        /*
            r2 = this;
            com.didi.soda.business.model.BusinessGoodsItemRvModel r0 = r2.f39430P
            r1 = 1
            if (r0 == 0) goto L_0x0016
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r0 = r2.f39435f
            if (r0 == 0) goto L_0x0016
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r0 = r0.shopInfo
            if (r0 == 0) goto L_0x0016
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r0 = r2.f39435f
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r0 = r0.shopInfo
            int r0 = r0.cShopStatus
            if (r0 != r1) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.BusinessPresenter.m27980r():boolean");
    }

    /* renamed from: a */
    private void m27924a(BusinessEntity businessEntity) {
        if (businessEntity.shopInfo != null) {
            m27914a(businessEntity.shopInfo.cShopStatus);
            BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f39434e);
            if (state == null) {
                state = new BusinessState();
            }
            state.shopId = businessEntity.shopInfo.shopId;
            state.shopStatus = businessEntity.shopInfo.cShopStatus;
            state.shopStatusDesc = businessEntity.shopInfo.cShopStatusDesc;
            state.nextBizTimeDesc = businessEntity.shopInfo.nextBizTimeDesc;
            if (this.f39415A == 1) {
                state.mHasShowedWineRemind = true;
            }
            state.mWineConfirmDesc = businessEntity.shopInfo.wineConfirmDesc;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: s */
    private CustomerDividerLineRvModel m27981s() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 220.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_gery_7_97_F5F5F7));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27914a(int i) {
        m27911a("Business status changed... old: " + this.f39444o + " new: " + i, "c-show|").build().info();
        this.f39444o = i;
        m27983u().updateBusinessStatus(i);
        m27982t();
    }

    /* renamed from: t */
    private void m27982t() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39440k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39440k.size();
            GoodsAmountModel[] goodsAmountModelArr = new GoodsAmountModel[1];
            for (int i = 0; i < size; i++) {
                if (this.f39440k.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39440k.get(i);
                    goodsAmountModelArr[0] = this.f39438i.get(businessGoodsItemRvModel.mItemUniqKey);
                    if (goodsAmountModelArr[0] != null) {
                        goodsAmountModelArr[0].mGoodsItemState = GoodsDataHelper.getGoodsItemState(businessGoodsItemRvModel.mStatus, businessGoodsItemRvModel.mSoldStatus, this.f39444o);
                        businessGoodsItemRvModel.mGoodsAmountModel = goodsAmountModelArr[0];
                        this.f39440k.set(i, businessGoodsItemRvModel);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.f39435f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m27931a(boolean r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r1 = r0.f39435f
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r1.shopInfo
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r1 = r0.f39435f
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r1.shopInfo
            int r1 = r1.wineConfirm
            if (r1 != 0) goto L_0x0018
            boolean r1 = r0.f39416B
            if (r1 != 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.BusinessPresenter.m27931a(boolean):boolean");
    }

    /* renamed from: u */
    private BusinessOmegaHelper m27983u() {
        if (this.f39447r == null) {
            this.f39447r = new BusinessOmegaHelper(getScopeContext(), this.f39434e, this.f39444o);
        }
        return this.f39447r;
    }

    /* renamed from: v */
    private boolean m27984v() {
        if (this.f39435f != null) {
            return false;
        }
        m27911a("businessEntityIsNull", "c-data|").build().info();
        return true;
    }

    /* renamed from: w */
    private void m27985w() {
        m27983u().onShow(this.f39448s.mDistance, this.f39448s.mDeliveryFee, this.f39448s.mDeliveryTime, this.f39448s.mExposureActivityNum, this.f39448s.mTabTypeList, this.f39448s.mDeliveryType, this.f39448s.mRecId, getBusinessSourceType(), this.f39448s.mIsCouponLogo, this.f39448s.mTraceId, this.f39448s.couponNum, this.f39448s.mIsMarketArea);
        AppsFlyerTrackHelper.trackViewRestaurant(getContext());
        FirebaseAnalyticsHelper.trackViewRestaurant(getContext());
    }

    /* renamed from: x */
    private void m27986x() {
        BusinessEntity businessEntity;
        if (getScopeContext() != null && (businessEntity = this.f39435f) != null && businessEntity.shopInfo != null) {
            int businessDialogSourceType = getBusinessDialogSourceType();
            int i = this.f39435f.shopInfo.cShopStatus;
            if (i != 2) {
                if (i == 3) {
                    AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
                    BusinessDialogHelper.showBusinessOutSideDialog(getScopeContext().getNavigator(), AddressUtil.checkAddressValid(delieveryAddress) ? delieveryAddress.getBusinessDepartPoi() : "", new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m27952d(this.f$1);
                        }
                    }, new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m27946c(this.f$1);
                        }
                    }, new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m27933b(this.f$1);
                        }
                    });
                    m27983u().onOutsideDeliveryPopupSw(businessDialogSourceType);
                    return;
                } else if (!(i == 4 || i == 5)) {
                    return;
                }
            }
            BusinessDialogHelper.showBusinessClosedsDialog(getScopeContext(), getContext(), this.f39435f.shopInfo.nextBizTimeDesc, new Function0(businessDialogSourceType) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return BusinessPresenter.this.m27961f(this.f$1);
                }
            }, new Function0(businessDialogSourceType) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return BusinessPresenter.this.m27955e(this.f$1);
                }
            });
            m27983u().onOutsideClosePopupSw(businessDialogSourceType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ Unit m27961f(int i) {
        getScopeContext().getNavigator().popToRoot();
        m27983u().onOutsideClosePopupCk(1, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Unit m27955e(int i) {
        m27983u().onOutsideClosePopupCk(2, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ Unit m27952d(int i) {
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 8).open();
        m27983u().onOutsideDeliveryPopupCk(1, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Unit m27946c(int i) {
        getScopeContext().getNavigator().popToRoot();
        m27983u().onOutsideDeliveryPopupCk(2, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Unit m27933b(int i) {
        m27983u().onOutsideDeliveryPopupCk(3, i);
        return null;
    }

    /* renamed from: b */
    private void m27937b(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        if (businessGoodsItemRvModel != null) {
            OmegaCommonParamHelper.setLv3RecId(this.f39448s.mRecId);
            OmegaCommonParamHelper.setLv3Body(StringUtils.SP_DATA_ITEM + businessGoodsItemRvModel.mGoodsId);
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39437h;
            if (linkedHashMap != null && (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId)) != null) {
                OmegaCommonParamHelper.setLv3Location("shop" + "_" + businessCategoryRvModel.mCategoryId + "_" + 0 + "_" + businessCategoryRvModel.mCategoryIndex + "_" + 0 + "_" + businessGoodsItemRvModel.mInCategoryIndex + "_" + 0 + "_" + (z ? 1 : 0));
            }
        }
    }

    /* renamed from: a */
    private void m27928a(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2) {
        m27983u().onGoodsItemClick(str, businessGoodsItemRvModel, i, i2, this.f39448s);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public RecordTracker.Builder m27950d(String str) {
        return m27911a(str, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m27911a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f39414c).setLogModule("m-business|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f39434e).setOtherParam("business_status", Integer.valueOf(this.f39444o));
    }

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
        iBlockScope.registerAction(BusinessDeliveryFeeTipsManager.TIPS_EVENT_NAME, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m27960f((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_TYPE_OPEN_SHOP_DETAIL, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m27954e((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_ADD, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m27949d((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_MINUS, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m27943c((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_CLICK, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m27932b((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_EXPOSURE, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m27909a((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ ActionResult m27960f(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        ((Contract.AbsBusinessView) getLogicView()).showDeliveryFeeDescRule(hashMap, buildable.getView());
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ ActionResult m27954e(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        goBusinessDetail();
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ ActionResult m27949d(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f39441l.getMainGoodState(this.f39434e, goodRvModelFromParam.mItemUniqKey);
            if (mainGoodState != null) {
                mainGoodState.amount++;
            }
            goodRvModelFromParam.mGoodsAmountModel.updateGoodsItemAmountModel(mainGoodState);
            Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
            if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
                ((Contract.AbsBusinessView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
                if (!goodRvModelFromParam.hasMultipleContents && goodRvModelFromParam.mHasWine != 1 && !BusinessDataHelper.isNeedReloadSubitem(goodRvModelFromParam) && !BusinessDataHelper.isNeedReloadSubitem(this.f39435f.shopInfo)) {
                    ((Contract.AbsBusinessView) getLogicView()).playAdd2CartAnim();
                }
            }
            onGoodsAddClick(goodRvModelFromParam);
        }
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ ActionResult m27943c(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        String str;
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        CartInfoModel cartInfoModel = this.f39427M;
        if (cartInfoModel == null) {
            return ActionResult.resolve();
        }
        String cartId = cartInfoModel.getCartId();
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f39441l.getMainGoodState(this.f39434e, goodRvModelFromParam.mItemUniqKey);
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
    public /* synthetic */ ActionResult m27932b(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
        if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
            ((Contract.AbsBusinessView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
        }
        onGoodsItemClick(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ ActionResult m27909a(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        onGoodsItemExposure(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* renamed from: a */
    private int m27908a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.get(BlocksConst.SCOPE_ACTION_PARAM_GOOD_NEXT_VALUE) == null) {
            return 0;
        }
        return ((Integer) hashMap.get(BlocksConst.SCOPE_ACTION_PARAM_GOOD_NEXT_VALUE)).intValue();
    }

    /* renamed from: e */
    private void m27957e(String str) {
        LogUtil.m29100d(f39414c, str);
    }
}
