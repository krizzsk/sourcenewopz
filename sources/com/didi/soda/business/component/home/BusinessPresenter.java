package com.didi.soda.business.component.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.component.dynamic.BusinessPayload;
import com.didi.soda.business.component.home.Contract;
import com.didi.soda.business.component.image.PreviewImageRepo;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessActionRepo;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessDialogHelper;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.page.BusinessHomePage;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
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
import com.didi.soda.customer.foundation.util.function.Function1;
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

public class BusinessPresenter extends Contract.AbsBusinessPresenter {

    /* renamed from: a */
    private static final String f39535a = "BusinessPresenter";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f39536A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f39537B = false;

    /* renamed from: C */
    private String f39538C;

    /* renamed from: D */
    private String f39539D = "0";

    /* renamed from: E */
    private Subscription f39540E;

    /* renamed from: F */
    private int f39541F = 0;

    /* renamed from: G */
    private int f39542G = 0;

    /* renamed from: H */
    private int f39543H = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_80);

    /* renamed from: b */
    private ICustomerBusinessManager f39544b;

    /* renamed from: c */
    private String f39545c;

    /* renamed from: d */
    private BusinessEntity f39546d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BusinessHeaderRvModel f39547e;

    /* renamed from: f */
    private LinkedHashMap<String, BusinessCategoryRvModel> f39548f;

    /* renamed from: g */
    private HashMap<String, GoodsAmountModel> f39549g = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<BusinessGoodsItemRvModel> f39550h = new ArrayList();

    /* renamed from: i */
    private ChildDataListManager<RecyclerModel> f39551i;

    /* renamed from: j */
    private CartItemStateRepo f39552j;

    /* renamed from: k */
    private boolean f39553k = false;

    /* renamed from: l */
    private Subscription f39554l = null;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f39555m = 1;

    /* renamed from: n */
    private String f39556n = "";

    /* renamed from: o */
    private String f39557o = "";

    /* renamed from: p */
    private BusinessOmegaHelper f39558p;

    /* renamed from: q */
    private BusinessOmegaModel f39559q = new BusinessOmegaModel();

    /* renamed from: r */
    private BusinessCategoryListener f39560r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f39561s = "";

    /* renamed from: t */
    private int f39562t;

    /* renamed from: u */
    private String f39563u;

    /* renamed from: v */
    private int f39564v;

    /* renamed from: w */
    private String f39565w;

    /* renamed from: x */
    private String f39566x;

    /* renamed from: y */
    private int f39567y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f39568z = false;

    public void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        m28135s().onClassifyTabSw(businessCategoryRvModel.mCategoryId, businessCategoryRvModel.mCategoryIndex, businessCategoryRvModel.mCategoryName, 1, businessCategoryRvModel.mItemCount, this.f39557o);
    }

    public void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        if (z) {
            m28078a("onTabClicked", "c-act|").setOtherParam("cate_index", Integer.valueOf(i)).build().info();
            m28135s().onClassifyTabClick(businessCategoryRvModel.mCategoryId, businessCategoryRvModel.mCategoryIndex, businessCategoryRvModel.mCategoryName, 1);
        }
    }

    public void onMoreTabExposure() {
        m28135s().onMoreClassifyTabSw();
    }

    public void onPageResult(Bundle bundle) {
        int i = 0;
        if (bundle.getBoolean(Const.PageParams.BUSINESS_GOODS_PURCHASED, false)) {
            String string = bundle.getString(Const.PageParams.ITEM_UNIQ_KEY);
            ChildDataListManager<RecyclerModel> childDataListManager = this.f39551i;
            if (childDataListManager != null && childDataListManager.size() > 0 && !TextUtils.isEmpty(string)) {
                int size = this.f39551i.size();
                while (i < size) {
                    if (!(this.f39551i.get(i) instanceof BusinessGoodsItemRvModel) || !string.equals(((BusinessGoodsItemRvModel) this.f39551i.get(i)).mItemUniqKey)) {
                        i++;
                    } else {
                        BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39551i.get(i);
                        businessGoodsItemRvModel.mAddToCartAnimation = true;
                        this.f39551i.set(i, businessGoodsItemRvModel);
                        return;
                    }
                }
            }
        }
    }

    public int getCategoryRvIndex(int i) {
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap;
        ChildDataListManager<RecyclerModel> childDataListManager;
        if (!(i == 0 || (linkedHashMap = this.f39548f) == null)) {
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
            if (!(businessCategoryRvModel == null || (childDataListManager = this.f39551i) == null)) {
                return childDataListManager.indexOf(businessCategoryRvModel);
            }
        }
        return 0;
    }

    public void goBusinessDetail() {
        m28078a("goBusinessDetail", "c-act|").build().info();
        m28135s().onHeaderClick(this.f39559q.mDistance, this.f39559q.mDeliveryFee, this.f39559q.mDeliveryTime);
        BusinessEntity businessEntity = this.f39546d;
        DiRouter.request().path(RoutePath.BUSINESS_DETAIL).putSerializable(Const.PageParams.SHOP_ID, this.f39545c).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, (businessEntity == null || businessEntity.shopInfo == null) ? null : this.f39546d.shopInfo).putSerializable(Const.PageParams.SHOP_OMEGA_MODEL, this.f39559q).open();
    }

    public void onBusinessFavor(boolean z) {
        BusinessHeaderRvModel businessHeaderRvModel = this.f39547e;
        if (businessHeaderRvModel != null) {
            businessHeaderRvModel.isFavor = z;
        }
        BusinessOmegaHelper businessOmegaHelper = this.f39558p;
        if (businessOmegaHelper != null) {
            businessOmegaHelper.onFavorClick(this.f39545c, this.f39555m, z);
        }
        CustomerRpcManagerProxy.get().setBusinessFavor(this.f39545c, z ? 1 : 0, new CustomerRpcCallback<BusinessFavorResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
            }

            public void onRpcSuccess(BusinessFavorResultEntity businessFavorResultEntity, long j) {
            }
        });
    }

    public void goBusinessSearch() {
        int i;
        BusinessInfoEntity businessInfoEntity;
        m28135s().onHeaderSearchClick();
        BusinessEntity businessEntity = this.f39546d;
        String str = null;
        if (businessEntity == null || businessEntity.shopInfo == null) {
            i = 1;
            businessInfoEntity = null;
        } else {
            BusinessInfoEntity businessInfoEntity2 = this.f39546d.shopInfo;
            String str2 = this.f39546d.shopInfo.cartRevision;
            i = this.f39546d.shopInfo.cShopStatus;
            BusinessInfoEntity businessInfoEntity3 = businessInfoEntity2;
            str = str2;
            businessInfoEntity = businessInfoEntity3;
        }
        DiRouter.request().path(RoutePath.BUSINESS_SEARCH_HOME).putSerializable(Const.PageParams.SHOP_ID, this.f39545c).putInt(Const.PageParams.SHOP_STATUS, i).putString(Const.PageParams.CART_REVISION, str).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, businessInfoEntity).putString(Const.PageParams.BIDATA, this.f39561s).open();
    }

    public boolean isDataLoadSuccess() {
        return this.f39553k;
    }

    public void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39548f;
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
        m28078a("Exposure: {id}" + businessGoodsItemRvModel2.mGoodsId + " {uniKey}" + businessGoodsItemRvModel2.mItemUniqKey + " {name}" + businessGoodsItemRvModel2.mGoodsName, "c-show|").build().info();
        if (businessGoodsItemRvModel2.mActinfo != null) {
            Integer.toString(businessGoodsItemRvModel2.mActinfo.getActType());
        }
        m28135s().onItemExposure(businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mStatus, businessGoodsItemRvModel2.mGoodsMarketingTipString, this.f39556n, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateName, i, businessGoodsItemRvModel2.mInCategoryIndex, 0, businessGoodsItemRvModel2.mHeadImg, businessGoodsItemRvModel2.mSoldStatus, businessGoodsItemRvModel2.mSoldTimeDesc, businessGoodsItemRvModel2.mPrice + "", businessGoodsItemRvModel2.mSpecialPrice + "", businessGoodsItemRvModel2.mActivityType + "", businessGoodsItemRvModel2.mAdditionalType, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.hasMultipleContents ? 1 : 0, businessGoodsItemRvModel2.mInCategoryIndex);
    }

    public void showMoreCategory(BusinessSelectedCallback businessSelectedCallback) {
        m28135s().onMoreClassifyTabCk();
        BusinessCategoryListener businessCategoryListener = this.f39560r;
        if (businessCategoryListener != null) {
            BusinessHeaderRvModel businessHeaderRvModel = this.f39547e;
            businessCategoryListener.showCategory(businessHeaderRvModel != null ? businessHeaderRvModel.mCategoryList : null, businessSelectedCallback);
        }
    }

    public boolean hasDynamicNotice() {
        return BusinessDataHelper.hasDynamicNotice(this.f39546d);
    }

    public void updateAnchorData(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2;
        int i = this.f39564v;
        int i2 = 0;
        if (i == 2 || i == 3) {
            ChildDataListManager<RecyclerModel> childDataListManager = this.f39551i;
            if (childDataListManager != null && childDataListManager.size() > 0) {
                int size = this.f39551i.size();
                while (i2 < size) {
                    if (!(this.f39551i.get(i2) instanceof BusinessGoodsItemRvModel) || (businessGoodsItemRvModel2 = (BusinessGoodsItemRvModel) this.f39551i.get(i2)) != businessGoodsItemRvModel) {
                        i2++;
                    } else {
                        businessGoodsItemRvModel2.mIsAnchorItem = true;
                        this.f39551i.set(i2, businessGoodsItemRvModel2);
                        return;
                    }
                }
                return;
            }
            return;
        }
        ChildDataListManager<RecyclerModel> childDataListManager2 = this.f39551i;
        if (childDataListManager2 != null && childDataListManager2.size() > 0 && this.f39562t == 1) {
            int size2 = this.f39551i.size();
            while (i2 < size2) {
                if (!(this.f39551i.get(i2) instanceof BusinessGoodsItemRvModel) || !this.f39563u.equals(((BusinessGoodsItemRvModel) this.f39551i.get(i2)).mGoodsId)) {
                    i2++;
                } else {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel3 = (BusinessGoodsItemRvModel) this.f39551i.get(i2);
                    businessGoodsItemRvModel3.mIsAnchorItem = true;
                    this.f39551i.set(i2, businessGoodsItemRvModel3);
                    return;
                }
            }
        }
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
        List<BusinessGoodsItemRvModel> list = businessExpandRvModel.mExpandList;
        if (businessExpandRvModel.mIsExpand) {
            this.f39551i.addAll(i, list);
            return;
        }
        for (BusinessGoodsItemRvModel indexOf : list) {
            this.f39551i.remove(this.f39551i.indexOf(indexOf));
        }
    }

    public void onExpandShow(BusinessExpandRvModel businessExpandRvModel) {
        m28135s().onExpandExposure(businessExpandRvModel);
    }

    public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
        m28135s().onExpandClickEvent(businessExpandRvModel);
    }

    public void onRvScrolled(int i) {
        LogUtil.m29100d(f39535a, "onRvScrolled:" + i);
        if (Math.abs(i) <= this.f39543H) {
            LogUtil.m29100d(f39535a, "onRvScrolled a little:" + i);
        } else if (i > 0) {
            m28135s().onRvScrolled(1);
        } else {
            m28135s().onRvScrolled(2);
        }
    }

    public void onTabScrolled(int i) {
        LogUtil.m29100d(f39535a, "onTabScrolled:" + i);
        if (Math.abs(i) <= this.f39543H) {
            LogUtil.m29100d(f39535a, "onTabScrolled a little:" + i);
        } else if (i > 0) {
            m28135s().onTabScrolled(3);
        } else {
            m28135s().onTabScrolled(4);
        }
    }

    public void onBack(int i) {
        Bundle bundle = new Bundle();
        BusinessHeaderRvModel businessHeaderRvModel = this.f39547e;
        if (businessHeaderRvModel != null) {
            bundle.putInt(Const.PageParams.IS_BUSINESS_FAVORED, businessHeaderRvModel.isFavor);
        }
        if (!TextUtils.isEmpty(this.f39545c)) {
            bundle.putString(Const.PageParams.SHOP_ID, this.f39545c);
        }
        this.f39559q.mReturnWay = i;
        String str = (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName");
        bundle.putString("fromPage", str);
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", str).build().track();
        getScopeContext().getNavigator().finish(bundle);
    }

    public void onCreate() {
        super.onCreate();
        m28078a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
        m28113d();
        m28115e();
        m28120f();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m28078a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
        m28081a();
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f39545c);
        if (state != null) {
            state.mHasShowedWineRemind = false;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
        BusinessDialogHelper.dismissAllDialog();
        m28135s().onExit(this.f39559q.mDistance, this.f39559q.mReturnWay, this.f39559q.mDeliveryFee, this.f39559q.mDeliveryTime, this.f39559q.mExposureActivityNum, this.f39559q.mTabTypeList, this.f39559q.mDeliveryType, this.f39559q.mRecId);
    }

    public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        BusinessCategoryRvModel businessCategoryRvModel;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        m28103b(businessGoodsItemRvModel2, false);
        m28078a("onGoodsItemClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel2.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel2.mGoodsId).build().info();
        if (!m28136t()) {
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39548f;
            int i = -1;
            if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId)) == null)) {
                i = businessCategoryRvModel.mCategoryIndex;
            }
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39546d.shopInfo);
            if (BusinessDataHelper.isNeedReloadSubitem(this.f39546d.shopInfo) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
                m28094a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem ? 1 : 0, 0);
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28098a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39561s, 1, this.f39538C, i);
                return;
            }
            GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f39546d, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
            m28094a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
            if (findGoodEntity != null) {
                BusinessDataHelper.toGoodItemDetail(getScopeContext(), findGoodEntity, businessGoodsItemRvModel2.mInCategoryIndex, m28098a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f39561s, 1, this.f39538C, businessGoodsItemRvModel2.mCateId, i);
            }
        }
    }

    public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        m28103b(businessGoodsItemRvModel, true);
        m28094a(EventConst.Business.SHOP_ITEM_PHOTO_CK, businessGoodsItemRvModel, BusinessDataHelper.isNeedReloadSubitem(this.f39546d.shopInfo) ? 1 : 0, GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntity(this.f39546d, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) ? 1 : 0);
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39548f;
        if (linkedHashMap != null) {
            BusinessCategoryRvModel businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId);
            i = businessCategoryRvModel != null ? businessCategoryRvModel.mCategoryIndex : -1;
        } else {
            i = 0;
        }
        String string = view.getContext().getString(R.string.customer_transition_tag_business_preview_image_named, new Object[]{String.valueOf(System.currentTimeMillis())});
        ViewCompat.setTransitionName(view, string);
        DiRouter.request().path(RoutePath.BUSINESS_PREVIEW_IMAGE).setFromPage(getScopeContext()).putString(Const.PageParams.TRANSITION_NAMES, string).putSerializable(Const.PageParams.PREVIEW_IMAGE, PreviewImageModel.copyFrom(businessGoodsItemRvModel, view, i, this.f39556n, -1)).open();
    }

    public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m28078a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m28089a(businessGoodsItemRvModel, false);
    }

    public void setBusinessCategoryListener(BusinessCategoryListener businessCategoryListener) {
        this.f39560r = businessCategoryListener;
    }

    public void onAttentionShow() {
        m28135s().onDeliveryMessageShow();
    }

    public void onAttentionClick() {
        m28135s().onDeliveryMessageClick();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m28078a("onStart", "c-state|").build().info();
        OmegaCommonParamHelper.refreshLv3GuideParam();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f39554l == null) {
            this.f39554l = BusinessRepo.get(getScopeContext()).subscribe(getScopeContext(), new Action1<CustomerResource<BusinessEntity>>() {
                public void call(CustomerResource<BusinessEntity> customerResource) {
                    if (customerResource != null) {
                        if (customerResource.status == Resource.Status.LOADING) {
                            BusinessPresenter.this.m28124h();
                        } else {
                            BusinessPresenter.this.m28125i();
                            if (customerResource.data == null) {
                                BusinessPresenter.this.m28104b(ResourceHelper.getString(R.string.customer_global_no_data_available));
                                return;
                            }
                            int i = C134617.$SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status[customerResource.status.ordinal()];
                            if (i == 1 || i == 2) {
                                BusinessPresenter.this.m28092a(customerResource);
                            } else if (i == 3) {
                                BusinessPresenter.this.m28104b(customerResource.message);
                            }
                        }
                        if (!BusinessPresenter.this.f39537B && customerResource.data != null && ((BusinessEntity) customerResource.data).shopInfo != null && !TextUtils.isEmpty(((BusinessEntity) customerResource.data).shopInfo.cartRevision)) {
                            boolean unused = BusinessPresenter.this.f39537B = true;
                            ((IFloatingCartProvider) BusinessPresenter.this.getScopeContext().getObject("service_floating_cart_key")).showFloatingCart(((BusinessEntity) customerResource.data).shopInfo.cartRevision, ((BusinessEntity) customerResource.data).shopInfo.cShopStatus, BusinessPresenter.this.f39561s, BusinessPresenter.this.f39536A);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.didi.soda.business.component.home.BusinessPresenter$7 */
    static /* synthetic */ class C134617 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.home.BusinessPresenter.C134617.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28089a(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        m28103b(businessGoodsItemRvModel, z);
        if (!m28136t()) {
            int i = z ? 5 : 1;
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f39546d.shopInfo);
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39548f;
            int i2 = -1;
            if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId)) == null)) {
                i2 = businessCategoryRvModel.mCategoryIndex;
            }
            if (BusinessDataHelper.isNeedReloadSubitem(this.f39546d.shopInfo)) {
                m28094a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem, 0);
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m28098a(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f39561s, i, this.f39538C, i2);
                return;
            }
            GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f39546d, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
            m28094a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
            if (findGoodEntity != null) {
                BusinessDataHelper.dispatchAddAction(getScopeContext(), findGoodEntity, businessGoodsItemRvModel, this.f39561s, i, this.f39538C, m28098a(businessGoodsItemRvModel.mNeedAlcoholRemind), m28135s(), (CartItemModel) null);
            }
        }
    }

    /* renamed from: a */
    private void m28081a() {
        this.f39549g.clear();
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39551i;
        if (childDataListManager != null) {
            childDataListManager.clear();
            this.f39551i = null;
        }
        this.f39550h.clear();
        clearDataManagers();
        m28135s().reset();
    }

    public int getBusinessDialogSourceType() {
        if (this.f39541F == 1) {
            return 2;
        }
        if (TextUtils.equals(this.f39539D, "1")) {
            return 1;
        }
        return 0;
    }

    /* renamed from: b */
    private void m28101b() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.ANCHOR_INFO);
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ANCHOR_INFO2);
        }
        try {
            AnchorInfoModel anchorInfoModel = (AnchorInfoModel) GsonUtil.fromJson(string, AnchorInfoModel.class);
            if (anchorInfoModel != null) {
                this.f39563u = anchorInfoModel.itemId;
                this.f39562t = anchorInfoModel.anchorStatus;
            }
        } catch (Exception e) {
            LogUtil.m29104i(f39535a, "anchorInfo parse error: " + e.toString() + string);
        }
    }

    /* renamed from: c */
    private void m28108c() {
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
                this.f39564v = actionInfoEntity.getType();
                this.f39565w = actionInfoEntity.getItemId();
            }
        } catch (Exception e) {
            LogUtil.m29104i(f39535a, "actionInfo parse error: " + e.toString() + string);
        }
    }

    /* renamed from: d */
    private void m28113d() {
        this.f39544b = (ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class);
    }

    /* renamed from: e */
    private void m28115e() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        this.f39545c = string;
        bundle.putString("current_shop_id", string);
        this.f39561s = bundle.getString(Const.PageParams.BIDATA, "");
        this.f39566x = bundle.getString(Const.PageParams.SHOP_ITEM_SEARCH_INFO);
        this.f39539D = bundle.getString(Const.URI_FROM_OUTER, "0");
        this.f39541F = bundle.getInt("sceneType", 0);
        this.f39542G = bundle.getInt("fromType", 0);
        int i = bundle.getInt(Const.PageParams.WINE_CONFIRM, 0);
        this.f39567y = i;
        if (i == 1) {
            this.f39568z = true;
        }
        m28101b();
        m28108c();
    }

    /* renamed from: f */
    private void m28120f() {
        this.f39552j = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(this.f39545c, getScopeContext(), new Action1<BusinessState>() {
            public void call(BusinessState businessState) {
                if (businessState != null) {
                    boolean unused = BusinessPresenter.this.f39568z = businessState.mHasShowedWineRemind;
                }
                if (businessState != null && BusinessPresenter.this.f39555m != businessState.shopStatus) {
                    BusinessPresenter.this.m28082a(businessState.shopStatus);
                    if (BusinessPresenter.this.f39547e != null) {
                        BusinessPresenter.this.f39547e.updateBusinessStatus(businessState.shopStatus, businessState.shopStatusDesc);
                        ((Contract.AbsBusinessView) BusinessPresenter.this.getLogicView()).updateHeaderView(BusinessPresenter.this.f39547e);
                    }
                }
            }
        });
        ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).subscribe(getScopeContext(), new Action1<PreviewImageModel>() {
            public void call(PreviewImageModel previewImageModel) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(BusinessPresenter.this.f39550h, previewImageModel.mGoodId, previewImageModel.mCateId);
                if (findGoodsItemRvModel != null) {
                    BusinessPresenter.this.m28078a("onImageAddClick", "c-act|").setOtherParam("cate_id", findGoodsItemRvModel.mCateId).setOtherParam("goods_id", findGoodsItemRvModel.mGoodsId).build().info();
                    BusinessPresenter.this.m28089a(findGoodsItemRvModel, true);
                }
            }
        });
        ((BusinessActionRepo) RepoFactory.getRepo(BusinessActionRepo.class)).subscribe(getScopeContext(), new Action1<BusinessActionParam>() {
            public void call(BusinessActionParam businessActionParam) {
                if (businessActionParam != null) {
                    if (businessActionParam.isNeedRefreshBusiness()) {
                        LogUtil.m29100d("BusinessLink", "requestShopData");
                        BusinessPresenter.this.m28110d("requestShopData").build().info();
                        BusinessHomePage.refreshBusinessData(BusinessPresenter.this.getScopeContext(), businessActionParam.isWithActInfo());
                    }
                    if (businessActionParam.isNeedRefreshCart()) {
                        ((IFloatingCartProvider) BusinessPresenter.this.getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
                    }
                }
            }
        });
    }

    /* renamed from: g */
    private void m28122g() {
        LogUtil.m29100d("BusinessLink", "requestShopData");
        m28110d("requestShopData").build().info();
        BusinessHomePage.requestBusinessData(getScopeContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m28124h() {
        ((Contract.AbsBusinessView) getLogicView()).showShimmerView();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m28125i() {
        ((Contract.AbsBusinessView) getLogicView()).hideShimmerView();
    }

    /* renamed from: a */
    private void m28093a(String str) {
        ((Contract.AbsBusinessView) getLogicView()).showAbnormalView(m28106c(str));
        ((Contract.AbsBusinessView) getLogicView()).showBusinessHeader(false);
        BusinessDialogHelper.dismissAllDialog();
    }

    /* renamed from: j */
    private void m28126j() {
        ((Contract.AbsBusinessView) getLogicView()).hideAbnormalView();
        ((Contract.AbsBusinessView) getLogicView()).showBusinessHeader(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28092a(CustomerResource<BusinessEntity> customerResource) {
        BusinessEntity businessEntity = (BusinessEntity) customerResource.data;
        if (customerResource.mExtension != null) {
            this.f39557o = customerResource.mExtension.getString(ParamConst.TRACE_ID, "");
        }
        m28078a("onLoadShopDataSuccess", "c-data|").build().info();
        this.f39553k = true;
        this.f39546d = businessEntity;
        this.f39556n = businessEntity.recId;
        m28081a();
        m28128l();
        this.f39559q = BusinessOmegaModel.newInstance(businessEntity, this.f39557o);
        m28137u();
        this.f39552j.subscribe(this.f39545c, getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessPresenter.this.m28095a((HashMap) obj);
            }
        });
        if (businessEntity.shopInfo != null) {
            ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo(businessEntity.shopInfo.actInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28095a(HashMap hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            m28127k();
        } else {
            m28096a((Map<String, ItemState>) hashMap);
        }
    }

    /* renamed from: k */
    private void m28127k() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39551i;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39551i.size();
            for (int i = 0; i < size; i++) {
                if (this.f39551i.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39551i.get(i);
                    businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                    this.f39551i.set(i, businessGoodsItemRvModel);
                }
            }
        }
    }

    public int getBusinessSourceType() {
        if (TextUtils.equals(this.f39539D, "1")) {
            return 2;
        }
        int i = this.f39542G;
        if (i == 1) {
            return 4;
        }
        return i == 2 ? 3 : 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28104b(String str) {
        m28078a("onLoadShopDataError", "c-data|").build().info();
        this.f39553k = false;
        m28093a(str);
    }

    /* renamed from: c */
    private TopGunAbnormalViewModel m28106c(String str) {
        $$Lambda$BusinessPresenter$YNVSoYi4IpzmYpYfU_Wfq3WaUUE r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessPresenter.this.m28083a(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28083a(View view) {
        m28126j();
        m28122g();
        ((IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
    }

    /* renamed from: a */
    private void m28096a(Map<String, ItemState> map) {
        String str;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39551i;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39551i.size();
            for (int i = 0; i < size; i++) {
                if (this.f39551i.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39551i.get(i);
                    if (!map.containsKey(businessGoodsItemRvModel.mItemUniqKey) || map.get(businessGoodsItemRvModel.mItemUniqKey) == null) {
                        str = "Goods amount is 0 goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey;
                        businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                    } else {
                        str = "Goods amount or status changed...[goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey + ", amount: " + map.get(businessGoodsItemRvModel.mItemUniqKey).amount + com.didichuxing.bigdata.p173dp.locsdk.Const.jaRight;
                        businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                    }
                    m28078a(str, "c-show|").build().info();
                    this.f39551i.set(i, businessGoodsItemRvModel);
                }
            }
        }
    }

    /* renamed from: l */
    private void m28128l() {
        BusinessEntity businessEntity = this.f39546d;
        if (businessEntity != null) {
            if (businessEntity.shopInfo == null || TextUtils.isEmpty(this.f39546d.shopInfo.cartRevision)) {
                this.f39538C = "0";
            } else {
                this.f39538C = this.f39546d.shopInfo.cartRevision;
            }
            if (CollectionsUtil.isEmpty(this.f39546d.cateInfo)) {
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", this.f39545c).build().trackError();
                m28093a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                m28078a("No Cate", "c-data|").build().error();
                return;
            }
            m28126j();
            BusinessHeaderRvModel newInstance = BusinessHeaderRvModel.newInstance(getContext(), this.f39546d, (BusinessPayload) null);
            this.f39547e = newInstance;
            try {
                LinkedHashMap<String, BusinessCategoryRvModel> parseBusinessEntity = BusinessDataHelper.parseBusinessEntity(this.f39546d, newInstance.mCategoryList, (IBlockScope) null);
                this.f39548f = parseBusinessEntity;
                this.f39547e.mCategoryMap = parseBusinessEntity;
                ((Contract.AbsBusinessView) getLogicView()).updateHeaderView(this.f39547e);
                m28090a(this.f39546d);
                m28130n();
                m28132p();
                if (TextUtils.equals(this.f39539D, "1") || this.f39541F == 1) {
                    m28129m();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", this.f39545c).addParam("errmsg", e.toString()).build().trackError();
                m28093a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                m28078a("parseBusinessEntity error", "c-data|").setMessage(e.getMessage()).build().error();
            }
        }
    }

    /* renamed from: m */
    private void m28129m() {
        if (this.f39540E == null && getScopeContext() != null) {
            LogUtil.m29100d("BusinessLink", "subscribeAddress");
            this.f39540E = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressNoViscous(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    BusinessPresenter.this.m28091a((AddressEntity) obj);
                }
            });
        }
        m28138v();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28091a(AddressEntity addressEntity) {
        m28122g();
    }

    /* renamed from: n */
    private void m28130n() {
        ((Contract.AbsBusinessView) getLogicView()).updateCategoryAmount(this.f39548f);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (BusinessCategoryRvModel next : this.f39548f.values()) {
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
                    this.f39549g.put(next2.mItemUniqKey, next2.mGoodsAmountModel);
                    this.f39550h.add(next2);
                }
            }
            if (next.mExpandRvModel != null) {
                boolean z2 = false;
                for (BusinessGoodsItemRvModel next3 : next.mExpandRvModel.mExpandList) {
                    this.f39549g.put(next3.mItemUniqKey, next3.mGoodsAmountModel);
                    this.f39550h.add(next3);
                    if (this.f39562t == 1 && TextUtils.equals(next3.mGoodsId, this.f39563u)) {
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
        arrayList.add(m28133q());
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager(arrayList);
        this.f39551i = createChildDataListManager;
        addDataManager(createChildDataListManager);
    }

    /* renamed from: o */
    private void m28131o() {
        BusinessCategoryRvModel businessCategoryRvModel;
        BusinessEntity businessEntity = this.f39546d;
        if (businessEntity != null && businessEntity.shopInfo != null && this.f39546d.shopInfo.anchorInfo != null) {
            AnchorInfoEntity anchorInfoEntity = this.f39546d.shopInfo.anchorInfo;
            String str = anchorInfoEntity.cateId;
            String str2 = anchorInfoEntity.itemId;
            int i = anchorInfoEntity.anchorStatus;
            if (anchorInfoEntity.reminder != null && !TextUtils.isEmpty(anchorInfoEntity.reminder.content)) {
                ToastUtil.showCustomerErrorToast(getScopeContext(), anchorInfoEntity.reminder.content);
            }
            if (i == 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (businessCategoryRvModel = (BusinessCategoryRvModel) CollectionsUtil.find(this.f39548f.values(), new Function1(str) {
                public final /* synthetic */ String f$0;

                {
                    this.f$0 = r1;
                }

                public final Object apply(Object obj) {
                    return Boolean.valueOf(TextUtils.equals(((BusinessCategoryRvModel) obj).mCategoryId, this.f$0));
                }
            })) == null) {
                return;
            }
            if (i == 2) {
                int i2 = businessCategoryRvModel.mCategoryIndex;
                ((Contract.AbsBusinessView) getLogicView()).anchorView(i2, getCategoryRvIndex(i2), (BusinessGoodsItemRvModel) null);
            } else if (i == 1) {
                BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) CollectionsUtil.find(businessCategoryRvModel.getAllDisplayGoods(), new Function1(str2) {
                    public final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final Object apply(Object obj) {
                        return Boolean.valueOf(TextUtils.equals(this.f$0, ((BusinessGoodsItemRvModel) obj).mGoodsId));
                    }
                });
                ((Contract.AbsBusinessView) getLogicView()).anchorView(businessCategoryRvModel.mCategoryIndex, this.f39551i.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel);
                if (anchorInfoEntity.setItemAction.intValue() == 1) {
                    if (!GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntity(this.f39546d, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) && !businessGoodsItemRvModel.mNeedAlcoholRemind) {
                        this.f39536A = true;
                    }
                    m28089a(businessGoodsItemRvModel, false);
                }
            }
        }
    }

    /* renamed from: p */
    private void m28132p() {
        BusinessEntity businessEntity;
        int i = this.f39564v;
        if (i == 2 || i == 3) {
            m28131o();
            return;
        }
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39548f;
        if (linkedHashMap != null) {
            int i2 = -1;
            Iterator<BusinessCategoryRvModel> it = linkedHashMap.values().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BusinessCategoryRvModel next = it.next();
                if (this.f39562t == 2 && this.f39563u.equals(next.mCategoryId)) {
                    i3 = next.mCategoryIndex;
                    i2 = getCategoryRvIndex(i3);
                    break;
                }
                if (this.f39562t == 1) {
                    List<BusinessGoodsItemRvModel> allDisplayGoods = next.getAllDisplayGoods();
                    if (!CollectionsUtil.isEmpty(allDisplayGoods)) {
                        Iterator<BusinessGoodsItemRvModel> it2 = allDisplayGoods.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                continue;
                                break;
                            }
                            BusinessGoodsItemRvModel next2 = it2.next();
                            if (this.f39563u.equals(next2.mGoodsId)) {
                                int i4 = next.mCategoryIndex;
                                i3 = i4;
                                i2 = this.f39551i.indexOf(next2);
                                continue;
                                break;
                            }
                        }
                    } else {
                        continue;
                    }
                }
                if (i2 >= 0) {
                    break;
                }
            }
            if (this.f39564v == 1) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(this.f39550h, this.f39565w);
                if (findGoodsItemRvModel != null && (businessEntity = this.f39546d) != null && businessEntity.shopInfo != null && this.f39546d.shopInfo.cShopStatus == 1) {
                    m28089a(findGoodsItemRvModel, false);
                    return;
                }
                return;
            }
            ((Contract.AbsBusinessView) getLogicView()).anchorView(i3, i2, (BusinessGoodsItemRvModel) null);
        }
    }

    /* renamed from: a */
    private void m28090a(BusinessEntity businessEntity) {
        if (businessEntity.shopInfo != null) {
            m28082a(businessEntity.shopInfo.cShopStatus);
            BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f39545c);
            if (state == null) {
                state = new BusinessState();
            }
            state.shopId = businessEntity.shopInfo.shopId;
            state.shopStatus = businessEntity.shopInfo.cShopStatus;
            state.shopStatusDesc = businessEntity.shopInfo.cShopStatusDesc;
            if (this.f39567y == 1) {
                state.mHasShowedWineRemind = true;
            }
            state.mWineConfirmDesc = businessEntity.shopInfo.wineConfirmDesc;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: q */
    private CustomerDividerLineRvModel m28133q() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 220.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_gery_7_97_F5F5F7));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28082a(int i) {
        m28078a("Business status changed... old: " + this.f39555m + " new: " + i, "c-show|").build().info();
        this.f39555m = i;
        m28135s().updateBusinessStatus(i);
        m28134r();
    }

    /* renamed from: r */
    private void m28134r() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f39551i;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f39551i.size();
            for (int i = 0; i < size; i++) {
                if (this.f39551i.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f39551i.get(i);
                    GoodsAmountModel goodsAmountModel = this.f39549g.get(businessGoodsItemRvModel.mItemUniqKey);
                    if (goodsAmountModel != null) {
                        goodsAmountModel.mGoodsItemState = GoodsDataHelper.getGoodsItemState(businessGoodsItemRvModel.mStatus, businessGoodsItemRvModel.mSoldStatus, this.f39555m);
                        businessGoodsItemRvModel.mGoodsAmountModel = goodsAmountModel;
                        this.f39551i.set(i, businessGoodsItemRvModel);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.f39546d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m28098a(boolean r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r1 = r0.f39546d
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r1.shopInfo
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r1 = r0.f39546d
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r1.shopInfo
            int r1 = r1.wineConfirm
            if (r1 != 0) goto L_0x0018
            boolean r1 = r0.f39568z
            if (r1 != 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.home.BusinessPresenter.m28098a(boolean):boolean");
    }

    /* renamed from: s */
    private BusinessOmegaHelper m28135s() {
        if (this.f39558p == null) {
            this.f39558p = new BusinessOmegaHelper(getScopeContext(), this.f39545c, this.f39555m);
        }
        return this.f39558p;
    }

    /* renamed from: t */
    private boolean m28136t() {
        if (this.f39546d != null) {
            return false;
        }
        m28078a("businessEntityIsNull", "c-data|").build().info();
        return true;
    }

    /* renamed from: u */
    private void m28137u() {
        m28135s().onShow(this.f39559q.mDistance, this.f39559q.mDeliveryFee, this.f39559q.mDeliveryTime, this.f39559q.mExposureActivityNum, this.f39559q.mTabTypeList, this.f39559q.mDeliveryType, this.f39559q.mRecId, getBusinessSourceType(), this.f39559q.mIsCouponLogo, this.f39559q.mTraceId);
        if (!AppsFlyerTrackHelper.isOpenOmegaTrack()) {
            AppsFlyerTrackHelper.trackViewRestaurant(getContext());
        }
        FirebaseAnalyticsHelper.trackViewRestaurant(getContext());
    }

    /* renamed from: v */
    private void m28138v() {
        BusinessEntity businessEntity;
        if (getScopeContext() != null && (businessEntity = this.f39546d) != null && businessEntity.shopInfo != null) {
            int businessDialogSourceType = getBusinessDialogSourceType();
            int i = this.f39546d.shopInfo.cShopStatus;
            if (i != 2) {
                if (i == 3) {
                    AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
                    BusinessDialogHelper.showBusinessOutSideDialog(getScopeContext().getNavigator(), AddressUtil.checkAddressValid(delieveryAddress) ? delieveryAddress.getBusinessDepartPoi() : "", new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m28112d(this.f$1);
                        }
                    }, new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m28107c(this.f$1);
                        }
                    }, new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m28100b(this.f$1);
                        }
                    });
                    m28135s().onOutsideDeliveryPopupSw(businessDialogSourceType);
                    return;
                } else if (!(i == 4 || i == 5)) {
                    return;
                }
            }
            BusinessDialogHelper.showBusinessClosedsDialog(getScopeContext(), getContext(), this.f39546d.shopInfo.nextBizTimeDesc, new Function0(businessDialogSourceType) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return BusinessPresenter.this.m28119f(this.f$1);
                }
            }, new Function0(businessDialogSourceType) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return BusinessPresenter.this.m28114e(this.f$1);
                }
            });
            m28135s().onOutsideClosePopupSw(businessDialogSourceType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ Unit m28119f(int i) {
        getScopeContext().getNavigator().popToRoot();
        m28135s().onOutsideClosePopupCk(1, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Unit m28114e(int i) {
        m28135s().onOutsideClosePopupCk(2, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ Unit m28112d(int i) {
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 8).open();
        m28135s().onOutsideDeliveryPopupCk(1, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Unit m28107c(int i) {
        getScopeContext().getNavigator().popToRoot();
        m28135s().onOutsideDeliveryPopupCk(2, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Unit m28100b(int i) {
        m28135s().onOutsideDeliveryPopupCk(3, i);
        return null;
    }

    /* renamed from: b */
    private void m28103b(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        if (businessGoodsItemRvModel != null) {
            OmegaCommonParamHelper.setLv3RecId(this.f39559q.mRecId);
            OmegaCommonParamHelper.setLv3Body(StringUtils.SP_DATA_ITEM + businessGoodsItemRvModel.mGoodsId);
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f39548f;
            if (linkedHashMap != null && (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId)) != null) {
                OmegaCommonParamHelper.setLv3Location("shop" + "_" + businessCategoryRvModel.mCategoryId + "_" + 0 + "_" + businessCategoryRvModel.mCategoryIndex + "_" + 0 + "_" + businessGoodsItemRvModel.mInCategoryIndex + "_" + 0 + "_" + (z ? 1 : 0));
            }
        }
    }

    /* renamed from: a */
    private void m28094a(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2) {
        m28135s().onGoodsItemClick(str, businessGoodsItemRvModel, i, i2, this.f39559q);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public RecordTracker.Builder m28110d(String str) {
        return m28078a(str, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m28078a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f39535a).setLogModule("m-business|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f39545c).setOtherParam("business_status", Integer.valueOf(this.f39555m));
    }

    /* renamed from: e */
    private void m28116e(String str) {
        LogUtil.m29100d(f39535a, str);
    }
}
