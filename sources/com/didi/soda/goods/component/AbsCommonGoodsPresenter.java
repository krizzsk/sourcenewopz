package com.didi.soda.goods.component;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.customer.widget.scroll.SmoothScrollListener;
import com.didi.soda.goods.binder.logic.PurchaseSubItemLogicRepo;
import com.didi.soda.goods.component.AbsCommonGoodsPresenter;
import com.didi.soda.goods.component.Contract;
import com.didi.soda.goods.component.Contract.AbsGoodsView;
import com.didi.soda.goods.helper.GoodsPurchaseOmegaModel;
import com.didi.soda.goods.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goods.model.GoodsPurchaseSubItemRvModel;
import com.didi.soda.goods.price.GoodsPriceCalculator;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbsCommonGoodsPresenter<T extends Contract.AbsGoodsView> extends Contract.AbsGoodsPresenter<T> implements IRFFloatingExpand {
    private static final String TAG = "AbsCommonGoodsPresenter";
    protected boolean allowOverAmount;
    protected ComponentLogicUnit mComponentLogicUnit;
    protected Map<String, ChildDataItemManager<GoodsPurchaseContentRvModel>> mContentDataManagers = new LinkedHashMap();
    protected Map<String, GoodsPurchaseContentRvModel> mGoodsContentMap;
    protected GoodsPriceCalculator mGoodsPriceCalculator;
    protected GoodsPurchaseOmegaModel mGoodsPurchaseOmegaModel = new GoodsPurchaseOmegaModel();
    protected Set<GoodsSubItemEntity> mSelectedSubItemList = new HashSet();
    protected HashMap<String, SelectSubItemState> mSelectedSubItemStates = new HashMap<>();
    protected String mStateUniqueId;
    protected Map<String, List<ChildDataItemManager<GoodsPurchaseSubItemRvModel>>> mSubItemDataManagers = new HashMap();
    protected boolean notNeedClientCal;

    /* access modifiers changed from: protected */
    public abstract void changeOfflinePrice();

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public abstract SelectSubItemState findSelectSubItemState(String str);

    /* access modifiers changed from: protected */
    public abstract GoodsSubItemEntity findSubItemEntity(String str, String str2);

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    /* access modifiers changed from: protected */
    public abstract int getLevel();

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public abstract void onAddCartViewClicked(boolean z);

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public abstract void replaceSubItemState(SelectSubItemState selectSubItemState);

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void onCloseClicked() {
        dismiss(getScopeContext());
        String str = "";
        String str2 = (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? str : (String) getScopeContext().getObject("PageName");
        OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
        if (str2 != null) {
            str = str2;
        }
        create.addEventParam("from", str).build().track();
    }

    public void onPageResult(Bundle bundle) {
        if (bundle != null && bundle.containsKey(Const.PageParams.MULTI_SUB_ITEM_STATE_BACK)) {
            SelectSubItemState selectSubItemState = (SelectSubItemState) bundle.getSerializable(Const.PageParams.MULTI_SUB_ITEM_STATE_BACK);
            replaceSubItemState(selectSubItemState);
            HashMap hashMap = (HashMap) bundle.getSerializable(Const.PageParams.MULTI_SELECTED_SUB_ITEM_STATE_BACK);
            if (hashMap != null && !CollectionsUtil.isEmpty(hashMap.keySet())) {
                this.mSelectedSubItemStates.clear();
                this.mSelectedSubItemStates.putAll(hashMap);
            }
            if (selectSubItemState != null && this.mSubItemDataManagers.containsKey(selectSubItemState.contentId)) {
                getLogTracker("onPageResult: " + selectSubItemState.isSelect(), "c-act|");
                String str = selectSubItemState.contentId;
                String str2 = selectSubItemState.subItemId;
                ChildDataItemManager<GoodsPurchaseSubItemRvModel> findSubItemDataManager = findSubItemDataManager(str, str2);
                if (findSubItemDataManager != null && findSubItemDataManager.size() > 0) {
                    GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = findSubItemDataManager.get(0);
                    goodsPurchaseSubItemRvModel.updateFromState(selectSubItemState);
                    findSubItemDataManager.setItem(goodsPurchaseSubItemRvModel);
                    onSelectionStateChanged(str, str2, true);
                }
            }
        }
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        if (this.mComponentLogicUnit == null) {
            this.mComponentLogicUnit = new ComponentLogicUnit() {
                public void onBindLogic() {
                    ((PurchaseSubItemLogicRepo) getLogic(PurchaseSubItemLogicRepo.class)).subscribe(AbsCommonGoodsPresenter.this.getScopeContext(), new Action1() {
                        public final void call(Object obj) {
                            AbsCommonGoodsPresenter.C139061.this.lambda$onBindLogic$0$AbsCommonGoodsPresenter$1((PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel) obj);
                        }
                    });
                }

                public /* synthetic */ void lambda$onBindLogic$0$AbsCommonGoodsPresenter$1(PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel purchaseSubItemLogicModel) {
                    if (purchaseSubItemLogicModel != null && "goMultiLevel".equals(purchaseSubItemLogicModel.mType)) {
                        GoodsPriceCalculator goodsPriceCalculator = AbsCommonGoodsPresenter.this.mGoodsPriceCalculator;
                        if (AbsCommonGoodsPresenter.this.mGoodsPriceCalculator != null) {
                            goodsPriceCalculator = AbsCommonGoodsPresenter.this.mGoodsPriceCalculator.copy();
                        }
                        SelectSubItemState findSelectSubItemState = AbsCommonGoodsPresenter.this.findSelectSubItemState(purchaseSubItemLogicModel.rvModel.nodeId);
                        if (findSelectSubItemState != null) {
                            findSelectSubItemState = findSelectSubItemState.copy();
                        }
                        DiRouter.request().setFromPage(AbsCommonGoodsPresenter.this.getScopeContext()).path(RoutePath.GOODS_MULTI_LEVEL).putString(Const.PageParams.SELECT_ITEM_STATE_UNIQUE_ID, AbsCommonGoodsPresenter.this.mStateUniqueId).putBoolean(Const.PageParams.SUBITEM_NOTNEEDCAL, AbsCommonGoodsPresenter.this.notNeedClientCal).putSerializable(Const.PageParams.SUBITEM_ENTITY, purchaseSubItemLogicModel.rvModel.subItemEntity).putSerializable(Const.PageParams.GOODS_PRICE_CALCULATOR, goodsPriceCalculator).putSerializable(Const.PageParams.SUB_ITEM_STATE_COPY, findSelectSubItemState).putSerializable(Const.PageParams.SELECTED_SUB_ITEM_STATE_COPY, AbsCommonGoodsPresenter.this.mSelectedSubItemStates).open();
                    }
                }
            };
        }
        return this.mComponentLogicUnit;
    }

    public boolean canSubItemSelected(String str) {
        GoodsPurchaseContentRvModel goodsPurchaseContentRvModel = this.mGoodsContentMap.get(str);
        if (goodsPurchaseContentRvModel == null) {
            return false;
        }
        int i = 0;
        for (GoodsPurchaseSubItemRvModel selectedAmount : goodsPurchaseContentRvModel.mSubItemList) {
            i += selectedAmount.getSelectedAmount();
        }
        if (i < goodsPurchaseContentRvModel.mMaxItemNum) {
            return true;
        }
        return false;
    }

    public void onSelectionStateChanged(String str, String str2, boolean z) {
        onSelectionStateChanged(str, str2, z, true);
    }

    public void onSelectionStateChanged(String str, String str2, boolean z, boolean z2) {
        GoodsPurchaseContentRvModel goodsPurchaseContentRvModel = this.mGoodsContentMap.get(str);
        if (goodsPurchaseContentRvModel != null) {
            boolean z3 = false;
            int i = 0;
            int i2 = 1;
            for (GoodsPurchaseSubItemRvModel next : goodsPurchaseContentRvModel.mSubItemList) {
                i += next.getSelectedAmount();
                GoodsSubItemEntity findSubItemEntity = findSubItemEntity(str, next.mSubItemId);
                if (findSubItemEntity != null) {
                    SelectSubItemState findSelectSubItemState = findSelectSubItemState(next.nodeId);
                    if (str2 != null && str2.equals(next.mSubItemId)) {
                        i2 = next.getSelectedType();
                        if (z) {
                            this.mSelectedSubItemList.add(findSubItemEntity);
                            if (findSelectSubItemState != null) {
                                findSelectSubItemState.node.amount = next.getSelectedAmount();
                                this.mSelectedSubItemStates.putAll(findSelectSubItemState.getSelectedSubItemStates());
                            }
                        } else {
                            this.mSelectedSubItemList.remove(findSubItemEntity);
                            if (findSelectSubItemState != null) {
                                for (String remove : findSelectSubItemState.getSelectedSubItemStates().keySet()) {
                                    this.mSelectedSubItemStates.remove(remove);
                                }
                                findSelectSubItemState.node.amount = 0;
                            }
                        }
                    }
                }
            }
            boolean z4 = goodsPurchaseContentRvModel.mIsSatisfied;
            goodsPurchaseContentRvModel.updateSatisfiedState(i);
            if (!z2 || !goodsPurchaseContentRvModel.mIsObliged) {
                goodsPurchaseContentRvModel.mGoodsContentAnimation = GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_NONE;
                this.mContentDataManagers.get(goodsPurchaseContentRvModel.mContentId).setItem(goodsPurchaseContentRvModel);
            } else if (!z4) {
                if (goodsPurchaseContentRvModel.mIsSatisfied && this.mContentDataManagers.get(goodsPurchaseContentRvModel.mContentId) != null) {
                    goodsPurchaseContentRvModel.mGoodsContentAnimation = GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_SATISFIED;
                    this.mContentDataManagers.get(goodsPurchaseContentRvModel.mContentId).setItem(goodsPurchaseContentRvModel);
                }
            } else if (!goodsPurchaseContentRvModel.mIsSatisfied && this.mContentDataManagers.get(goodsPurchaseContentRvModel.mContentId) != null) {
                goodsPurchaseContentRvModel.mGoodsContentAnimation = GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_UNSATISFIED;
                this.mContentDataManagers.get(goodsPurchaseContentRvModel.mContentId).setItem(goodsPurchaseContentRvModel);
            }
            this.mGoodsPurchaseOmegaModel.mCurContentId = str;
            this.mGoodsPurchaseOmegaModel.mCurContentType = goodsPurchaseContentRvModel.mContentType;
            this.mGoodsPurchaseOmegaModel.mCurSelectedSubItemId = str2;
            int i3 = 2;
            this.mGoodsPurchaseOmegaModel.mSelectType = z ? 1 : 2;
            this.mGoodsPurchaseOmegaModel.mCurSelectedSubItemType = i2;
            GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
            if (goodsPurchaseContentRvModel.mIsObliged) {
                i3 = 1;
            }
            goodsPurchaseOmegaModel.mCurContentIsMust = i3;
            this.mGoodsPurchaseOmegaModel.setSelectOmegaModel(this.mSelectedSubItemList);
            changeAddCartViewState();
            changeOfflinePrice();
            if (i >= goodsPurchaseContentRvModel.mMaxItemNum) {
                z3 = true;
            }
            changeStepperState(str, z3);
        }
    }

    public void resetSelectionState(String str, boolean z) {
        List<ChildDataItemManager> list = this.mSubItemDataManagers.get(str);
        if (!CollectionsUtil.isEmpty(list)) {
            for (ChildDataItemManager childDataItemManager : list) {
                GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = (GoodsPurchaseSubItemRvModel) childDataItemManager.get(0);
                if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.SELECTED) {
                    goodsPurchaseSubItemRvModel.updateSelectedState(false);
                    SelectSubItemState findSelectSubItemState = findSelectSubItemState(goodsPurchaseSubItemRvModel.nodeId);
                    if (findSelectSubItemState != null) {
                        for (String remove : findSelectSubItemState.getSelectedSubItemStates().keySet()) {
                            this.mSelectedSubItemStates.remove(remove);
                        }
                        findSelectSubItemState.node.amount = 0;
                    }
                    childDataItemManager.setItem(goodsPurchaseSubItemRvModel);
                    if (z) {
                        onSelectionStateChanged(str, goodsPurchaseSubItemRvModel.mSubItemId, false, false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void showRemindAnimation(String str) {
        ChildDataItemManager childDataItemManager = this.mContentDataManagers.get(str);
        if (childDataItemManager != null && childDataItemManager.get(0) != null) {
            showRemindAnimation((GoodsPurchaseContentRvModel) childDataItemManager.get(0), true);
        }
    }

    /* access modifiers changed from: protected */
    public CustomerDividerLineRvModel getDividerLineRvModel() {
        return new CustomerDividerLineRvModel(1, DisplayUtils.dip2px(getContext(), 20.0f), DisplayUtils.dip2px(getContext(), 2.0f), getContext().getResources().getColor(R.color.rf_color_gery_5_90_E5E5E5));
    }

    /* access modifiers changed from: protected */
    public void anchorToUnSatisfiedContent() {
        for (GoodsPurchaseContentRvModel next : this.mGoodsContentMap.values()) {
            if (!next.mIsSatisfied) {
                boolean z = false;
                if (!CollectionsUtil.isEmpty(this.mSelectedSubItemList)) {
                    Iterator<GoodsSubItemEntity> it = this.mSelectedSubItemList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GoodsSubItemEntity next2 = it.next();
                        if (next.mContentId != null && next.mContentId.equals(next2.contentId)) {
                            z = true;
                            break;
                        }
                    }
                }
                showRemindAnimation(next, z);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateValidSubItemOmegaModel(String str) {
        if (!TextUtils.isEmpty(str) && this.mGoodsContentMap != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            GoodsPurchaseContentRvModel goodsPurchaseContentRvModel = this.mGoodsContentMap.get(str);
            if (goodsPurchaseContentRvModel != null && !CollectionsUtil.isEmpty(goodsPurchaseContentRvModel.mSubItemList)) {
                for (GoodsPurchaseSubItemRvModel next : goodsPurchaseContentRvModel.mSubItemList) {
                    if (next.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
                        arrayList2.add(next.mSubItemId);
                    } else {
                        arrayList.add(next.mSubItemId);
                    }
                }
            }
            this.mGoodsPurchaseOmegaModel.mValidSubItemIdMap.put(str, SentenceUtil.foldStringList(arrayList, ","));
            this.mGoodsPurchaseOmegaModel.mInvalidSubItemIdMap.put(str, SentenceUtil.foldStringList(arrayList2, ","));
        }
    }

    /* access modifiers changed from: protected */
    public void changeAddCartViewState() {
        for (GoodsPurchaseContentRvModel goodsPurchaseContentRvModel : this.mGoodsContentMap.values()) {
            if (!goodsPurchaseContentRvModel.mIsSatisfied) {
                ((Contract.AbsGoodsView) getLogicView()).disableAddCartView();
                getLogTracker("disableAddCartView", "c-show|").build().info();
                return;
            }
        }
        ((Contract.AbsGoodsView) getLogicView()).enableAddCartView();
        getLogTracker("enableAddCartView", "c-show|").build().info();
    }

    private void showRemindAnimation(final GoodsPurchaseContentRvModel goodsPurchaseContentRvModel, final boolean z) {
        ((Contract.AbsGoodsView) getLogicView()).anchorToUnSatisfiedContent(goodsPurchaseContentRvModel.mRvIndex, new SmoothScrollListener() {
            public void onStart() {
                AbsCommonGoodsPresenter.this.log("onStart");
            }

            public void onStop() {
                AbsCommonGoodsPresenter.this.log("onStop");
                ChildDataItemManager childDataItemManager = AbsCommonGoodsPresenter.this.mContentDataManagers.get(goodsPurchaseContentRvModel.mContentId);
                if (childDataItemManager != null) {
                    goodsPurchaseContentRvModel.mHasSelectedItems = z;
                    goodsPurchaseContentRvModel.mGoodsContentAnimation = GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_REMIND;
                    AbsCommonGoodsPresenter absCommonGoodsPresenter = AbsCommonGoodsPresenter.this;
                    absCommonGoodsPresenter.log("Start to play remind animation, contentId is" + goodsPurchaseContentRvModel.mContentId);
                    childDataItemManager.setItem(goodsPurchaseContentRvModel);
                }
            }
        });
    }

    private ChildDataItemManager<GoodsPurchaseSubItemRvModel> findSubItemDataManager(String str, String str2) {
        List<ChildDataItemManager<GoodsPurchaseSubItemRvModel>> list = this.mSubItemDataManagers.get(str);
        if (CollectionsUtil.isEmpty(list)) {
            return null;
        }
        for (ChildDataItemManager<GoodsPurchaseSubItemRvModel> childDataItemManager : list) {
            if (str2.equals(childDataItemManager.get(0).mSubItemId)) {
                return childDataItemManager;
            }
        }
        return null;
    }

    private void changeStepperState(String str, boolean z) {
        List<ChildDataItemManager> list = this.mSubItemDataManagers.get(str);
        if (!CollectionsUtil.isEmpty(list)) {
            for (ChildDataItemManager childDataItemManager : list) {
                GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = (GoodsPurchaseSubItemRvModel) childDataItemManager.get(0);
                goodsPurchaseSubItemRvModel.exceedLimit = z;
                childDataItemManager.setItem(goodsPurchaseSubItemRvModel);
            }
        }
    }

    private RecordTracker.Builder getLogTracker(String str, String str2) {
        return RecordTracker.Builder.create().setTag(TAG).setLogModule("m-purchase|").setMessage(str).setLogCategory(str2);
    }

    /* access modifiers changed from: private */
    public void log(String str) {
        LogUtil.m29100d(TAG, str);
    }
}
