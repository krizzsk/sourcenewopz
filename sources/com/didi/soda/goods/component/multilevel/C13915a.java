package com.didi.soda.goods.component.multilevel;

import android.os.Bundle;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.goods.binder.EmptyHeightBinder;
import com.didi.soda.goods.component.multilevel.Contract;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.goods.helper.GoodsOmegaHelper;
import com.didi.soda.goods.helper.GoodsPurchaseOmegaModel;
import com.didi.soda.goods.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goods.model.GoodsPurchaseSubItemRvModel;
import com.didi.soda.goods.parser.SelectItemStateParser;
import com.didi.soda.goods.price.GoodsPriceCalculator;
import com.didi.soda.goods.price.NoOpGoodsPriceCalculator;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.soda.goods.component.multilevel.a */
/* compiled from: MultiLevelPresenter */
class C13915a extends Contract.AbsMultiLevelPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private static final String f42355a = "GoodsPurchasePresenter";

    /* renamed from: b */
    private String f42356b;

    /* renamed from: c */
    private int f42357c;

    /* renamed from: d */
    private int f42358d;

    /* renamed from: e */
    private int f42359e;

    /* renamed from: f */
    private String f42360f;

    /* renamed from: g */
    private int f42361g;

    /* renamed from: h */
    private int f42362h;

    /* renamed from: i */
    private String f42363i;

    /* renamed from: j */
    private GoodsSubItemEntity f42364j;

    /* renamed from: k */
    private SelectSubItemState f42365k;

    /* renamed from: l */
    private int f42366l;

    /* renamed from: m */
    private GoodsOmegaHelper f42367m;

    C13915a() {
    }

    public void onCreate() {
        super.onCreate();
        m29844c();
        m29843b();
        m29845d().onMultiLevelShow(this.f42362h, this.f42365k.subItemId);
    }

    public void onAddCartViewClicked(boolean z) {
        if (z) {
            m29845d().onMultiLevelConfirmClick(this.f42362h, this.f42365k.subItemId);
            m29842a();
            return;
        }
        anchorToUnSatisfiedContent();
    }

    public void replaceSubItemState(SelectSubItemState selectSubItemState) {
        SelectItemStateParser.replaceSubItemState(this.mStateUniqueId, this.f42365k, selectSubItemState);
    }

    public SelectSubItemState findSelectSubItemState(String str) {
        for (SelectSubItemState next : this.f42365k.selectedSubItemStates) {
            if (next != null && str != null && str.equals(next.uniqueId)) {
                return next;
            }
        }
        return null;
    }

    public void onSelectionStateChanged(String str, String str2, boolean z) {
        super.onSelectionStateChanged(str, str2, z);
        GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
        m29845d().onSubItemClick(goodsPurchaseOmegaModel.mCurContentId, goodsPurchaseOmegaModel.mCurContentType, goodsPurchaseOmegaModel.mValidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mInvalidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mCurSelectedSubItemId, goodsPurchaseOmegaModel.mSelectType, goodsPurchaseOmegaModel.mCurContentIsMust, goodsPurchaseOmegaModel.mCurSelectedSubItemType, goodsPurchaseOmegaModel.mIsMultiLevel);
    }

    /* access modifiers changed from: protected */
    public int getLevel() {
        return this.f42362h;
    }

    /* access modifiers changed from: protected */
    public GoodsSubItemEntity findSubItemEntity(String str, String str2) {
        return GoodsDataHelper.filterSubItemEntity(this.f42364j, str, str2);
    }

    /* access modifiers changed from: protected */
    public void changeOfflinePrice() {
        if (!this.notNeedClientCal) {
            if (this.mGoodsPriceCalculator == null) {
                m29841a("mGoodsPriceCalculator == null", "c-show|").build().info();
                return;
            }
            SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
            int i = Integer.MAX_VALUE;
            if (selectItemState != null) {
                i = selectItemState.maxSale;
            }
            List<SelectSubItemState> filterCalculatePriceStates = SelectItemStateParser.filterCalculatePriceStates(this.mSelectedSubItemStates.values());
            int calculateOriPriceWithStates = this.mGoodsPriceCalculator.calculateOriPriceWithStates(filterCalculatePriceStates, this.f42366l);
            int calculateCurPriceWithStates = this.mGoodsPriceCalculator.calculateCurPriceWithStates(filterCalculatePriceStates, this.f42366l, i);
            if (calculateCurPriceWithStates < 0) {
                calculateCurPriceWithStates = 0;
                calculateOriPriceWithStates = 0;
            }
            m29841a("changeOfflinePrice:{cur:" + calculateCurPriceWithStates + "},{ori:" + calculateOriPriceWithStates + "}", "c-show|").build().info();
            ((Contract.AbsMultiLevelView) getLogicView()).changeOfflinePrice(calculateCurPriceWithStates, calculateOriPriceWithStates, this.f42364j.currency);
        }
    }

    /* renamed from: a */
    private void m29842a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.PageParams.MULTI_SUB_ITEM_STATE_BACK, this.f42365k);
        bundle.putSerializable(Const.PageParams.MULTI_SELECTED_SUB_ITEM_STATE_BACK, this.mSelectedSubItemStates);
        dismiss(getScopeContext(), bundle);
    }

    /* renamed from: b */
    private void m29843b() {
        if (this.f42364j != null) {
            ((Contract.AbsMultiLevelView) getLogicView()).refreshTitleBar(this.f42364j.itemName, 1.0f);
            int i = 1;
            this.f42362h = this.f42364j.node.level + 1;
            this.f42365k.node.amount = 1;
            this.mSelectedSubItemStates.put(this.f42365k.uniqueId, this.f42365k);
            this.mSelectedSubItemStates.putAll(this.f42365k.getSelectedSubItemStates());
            this.mGoodsContentMap = GoodsDataHelper.parseMultiLevelSubItem(this.f42364j, this.f42358d, this.f42365k, this.mSelectedSubItemList, this.mSelectedSubItemStates);
            addDataManager(createChildDataItemManager(new EmptyHeightBinder.HeightData(ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px))));
            for (GoodsPurchaseContentRvModel goodsPurchaseContentRvModel : this.mGoodsContentMap.values()) {
                int i2 = i + 1;
                goodsPurchaseContentRvModel.setRvIndex(i);
                ChildDataItemManager createChildDataItemManager = createChildDataItemManager(goodsPurchaseContentRvModel);
                addDataManager(createChildDataItemManager);
                this.mContentDataManagers.put(goodsPurchaseContentRvModel.mContentId, createChildDataItemManager);
                updateValidSubItemOmegaModel(goodsPurchaseContentRvModel.mContentId);
                ArrayList arrayList = new ArrayList();
                if (!CollectionsUtil.isEmpty(goodsPurchaseContentRvModel.mSubItemList)) {
                    int size = goodsPurchaseContentRvModel.mSubItemList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = goodsPurchaseContentRvModel.mSubItemList.get(i3);
                        int i4 = i2 + 1;
                        goodsPurchaseSubItemRvModel.setRvIndex(i2);
                        ChildDataItemManager createChildDataItemManager2 = createChildDataItemManager(goodsPurchaseSubItemRvModel);
                        arrayList.add(createChildDataItemManager2);
                        addDataManager(createChildDataItemManager2);
                        if (i3 != size - 1) {
                            i4++;
                            addDataManager(createChildDataItemManager(getDividerLineRvModel()));
                        }
                        i2 = i4;
                    }
                    this.mSubItemDataManagers.put(goodsPurchaseContentRvModel.mContentId, arrayList);
                }
                i = i2;
            }
            changeAddCartViewState();
            changeOfflinePrice();
        }
    }

    /* renamed from: c */
    private void m29844c() {
        this.mStateUniqueId = getScopeContext().getBundle().getString(Const.PageParams.SELECT_ITEM_STATE_UNIQUE_ID, "");
        this.f42364j = (GoodsSubItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.SUBITEM_ENTITY);
        this.f42365k = (SelectSubItemState) getScopeContext().getBundle().getSerializable(Const.PageParams.SUB_ITEM_STATE_COPY);
        this.mSelectedSubItemStates.putAll((Map) getScopeContext().getBundle().getSerializable(Const.PageParams.SELECTED_SUB_ITEM_STATE_COPY));
        Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.GOODS_PRICE_CALCULATOR);
        if (serializable == null) {
            this.mGoodsPriceCalculator = new NoOpGoodsPriceCalculator();
        } else {
            this.mGoodsPriceCalculator = (GoodsPriceCalculator) serializable;
        }
        this.notNeedClientCal = getScopeContext().getBundle().getBoolean(Const.PageParams.SUBITEM_NOTNEEDCAL, false);
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
        if (selectItemState != null) {
            this.f42366l = selectItemState.node.amount;
            this.f42363i = selectItemState.shopId;
            this.f42358d = selectItemState.shopStatus;
            this.f42356b = selectItemState.itemId;
            this.f42357c = selectItemState.itemStatus;
            this.f42359e = selectItemState.soldStatus;
            this.f42360f = selectItemState.limitedTime;
            this.f42361g = selectItemState.from;
        }
    }

    /* renamed from: d */
    private GoodsOmegaHelper m29845d() {
        if (this.f42367m == null) {
            this.f42367m = new GoodsOmegaHelper(getScopeContext(), this.f42363i, this.f42358d, this.f42356b, this.f42357c, this.f42359e, this.f42360f, this.f42361g);
        }
        return this.f42367m;
    }

    /* renamed from: a */
    private RecordTracker.Builder m29841a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42355a).setLogModule("m-purchase|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f42363i).setOtherParam("goods_id", this.f42356b);
    }
}
