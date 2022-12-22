package com.didi.soda.business.manager;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessDetailModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemBaseModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.cart.repo.CheckCartMaxNumKt;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.dynamic.BlocksCommonParser;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.BusinessAttentionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessCateEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessStarRatingEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSideSpacingSpan;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.goodsV2.page.GoodsPurchasePage;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class BusinessDataHelper {
    public static final String PARA_IS_MARKET_AREA = "PARA_IS_MARKET_AREA";

    /* renamed from: a */
    private static final String f39668a = ResourceHelper.getString(R.string.customer_global_blank);

    /* renamed from: b */
    private static final String f39669b = "BusinessDataHelper";

    public static boolean checkBusinessStatusNormal(int i) {
        return i == 1;
    }

    public static boolean checkEntityValid(BusinessEntity businessEntity) {
        return businessEntity != null;
    }

    private BusinessDataHelper() {
    }

    public static LinkedHashMap<String, BusinessCategoryRvModel> parseBusinessEntity(BusinessEntity businessEntity, List list, IBlockScope iBlockScope) {
        return parseBusinessEntity(businessEntity, list, (List) null, iBlockScope, (String) null);
    }

    public static LinkedHashMap<String, BusinessCategoryRvModel> parseBusinessEntity(BusinessEntity businessEntity, List list, List list2, IBlockScope iBlockScope, String str) {
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = new LinkedHashMap<>();
        if (list != null) {
            list.clear();
        }
        if (list2 != null) {
            list2.clear();
        }
        if (!CollectionsUtil.isEmpty(businessEntity.cateInfo)) {
            int i = 0;
            int i2 = businessEntity.shopInfo != null ? businessEntity.shopInfo.cShopStatus : 1;
            addBlockScopeParam(businessEntity, iBlockScope);
            for (BusinessCateEntity next : businessEntity.cateInfo) {
                BusinessCategoryRvModel newInstance = BusinessCategoryRvModel.newInstance(next);
                BusinessCategoryMenuRvModel newInstance2 = BusinessCategoryMenuRvModel.newInstance(next);
                int i3 = i + 1;
                newInstance.mCategoryIndex = i;
                if (!CollectionsUtil.isEmpty(next.mJsonComponentList)) {
                    parseDyGoodItems(next, newInstance, i2, iBlockScope, str);
                } else if (!CollectionsUtil.isEmpty(next.items)) {
                    parseGoodItems(next, newInstance, i2);
                } else {
                    LogUtil.m29100d(f39669b, "there are no good items in current category");
                }
                if (list != null) {
                    list.add(newInstance);
                }
                if (list2 != null) {
                    list2.add(newInstance2);
                }
                linkedHashMap.put(next.cateId, newInstance);
                i = i3;
            }
        }
        return linkedHashMap;
    }

    public static void addBlockScopeParam(BusinessEntity businessEntity, IBlockScope iBlockScope) {
        if (iBlockScope != null && businessEntity != null && businessEntity.shopInfo != null) {
            if (businessEntity.shopInfo.nextBizTimeDesc != null) {
                iBlockScope.attach(BlocksConst.BIZ_TIME_DESC, businessEntity.shopInfo.nextBizTimeDesc);
            }
            if (businessEntity.shopInfo.cShopStatusDesc != null) {
                iBlockScope.attach("statusDesc", businessEntity.shopInfo.cShopStatusDesc);
            }
            iBlockScope.attach(BlocksConst.SHOP_STATUS, Integer.valueOf(businessEntity.shopInfo.cShopStatus));
            if (businessEntity.shopInfo.shopId != null) {
                iBlockScope.attach("shopId", businessEntity.shopInfo.shopId);
            }
        }
    }

    public static void addBlockScopeParam(BusinessInfoEntity businessInfoEntity, IBlockScope iBlockScope) {
        if (iBlockScope != null && businessInfoEntity != null) {
            if (businessInfoEntity.nextBizTimeDesc != null) {
                iBlockScope.attach(BlocksConst.BIZ_TIME_DESC, businessInfoEntity.nextBizTimeDesc);
            }
            if (businessInfoEntity.cShopStatusDesc != null) {
                iBlockScope.attach("statusDesc", businessInfoEntity.cShopStatusDesc);
            }
            iBlockScope.attach(BlocksConst.SHOP_STATUS, Integer.valueOf(businessInfoEntity.cShopStatus));
        }
    }

    public static void addBlockScopeParam(BusinessState businessState, IBlockScope iBlockScope) {
        if (iBlockScope != null && businessState != null) {
            if (businessState.nextBizTimeDesc != null) {
                iBlockScope.attach(BlocksConst.BIZ_TIME_DESC, businessState.nextBizTimeDesc);
            }
            if (businessState.shopStatusDesc != null) {
                iBlockScope.attach("statusDesc", businessState.shopStatusDesc);
            }
            iBlockScope.attach(BlocksConst.SHOP_STATUS, Integer.valueOf(businessState.shopStatus));
            if (businessState.shopId != null) {
                iBlockScope.attach("shopId", businessState.shopId);
            }
        }
    }

    public static void addBlockNodeContextParam(ComponentModel componentModel, BusinessCategoryRvModel businessCategoryRvModel) {
        try {
            componentModel.getWidgetNodeModel().getContextParams().put(BlocksConst.CATEGORY_ID, businessCategoryRvModel.mCategoryId);
            componentModel.getWidgetNodeModel().getContextParams().put(BlocksConst.CATEGORY_POSITION, Integer.valueOf(businessCategoryRvModel.mCategoryIndex));
            if (componentModel.getDataModel() instanceof BusinessGoodsItemRvModel) {
                componentModel.getWidgetNodeModel().getContextParams().put(BlocksConst.ITEM_UNI_KEY, ((BusinessGoodsItemRvModel) componentModel.getDataModel()).mItemUniqKey);
            }
        } catch (Exception e) {
            LogUtil.m29100d(f39669b, "addBlockNodeContextParam error:" + e.toString());
        }
    }

    public static void addBlockJsonParam(JsonObject jsonObject, BusinessCategoryRvModel businessCategoryRvModel, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        if (businessGoodsItemRvModel != null && jsonObject != null && businessCategoryRvModel != null) {
            jsonObject.addProperty(BlocksConst.AETHER_INDEX, (Number) Integer.valueOf(businessGoodsItemRvModel.mInCategoryIndex));
            jsonObject.addProperty(BlocksConst.AETHER_ISLAST, (Number) 1);
        }
    }

    public static void addBlockJsonParam(JsonObject jsonObject, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i) {
        if (businessGoodsItemRvModel != null && jsonObject != null) {
            jsonObject.addProperty(BlocksConst.AETHER_INDEX, (Number) Integer.valueOf(businessGoodsItemRvModel.mInCategoryIndex));
            jsonObject.addProperty(BlocksConst.AETHER_ISLAST, (Number) 1);
        }
    }

    public static void addBlockJsonParam(JsonObject jsonObject, int i, boolean z) {
        if (jsonObject != null) {
            jsonObject.addProperty(BlocksConst.AETHER_INDEX, (Number) Integer.valueOf(i));
            jsonObject.addProperty(BlocksConst.AETHER_ISLAST, (Number) Integer.valueOf(z ? 1 : 0));
        }
    }

    public static void parseDyGoodItems(BusinessCateEntity businessCateEntity, BusinessCategoryRvModel businessCategoryRvModel, int i, IBlockScope iBlockScope, String str) {
        GoodsItemEntity goodsItemEntity;
        BusinessCateEntity businessCateEntity2 = businessCateEntity;
        BusinessCategoryRvModel businessCategoryRvModel2 = businessCategoryRvModel;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!CollectionsUtil.isEmpty(businessCateEntity2.mJsonComponentList)) {
            int i2 = 0;
            for (JsonObject next : businessCateEntity2.mJsonComponentList) {
                try {
                    goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) next.getAsJsonObject("data"), (Type) GoodsItemEntity.class);
                } catch (Exception e) {
                    LogUtil.m29100d(f39669b, "parse business goods error:" + e.toString());
                    goodsItemEntity = null;
                }
                int i3 = i2 + 1;
                if (BlocksCommonParser.isBlockType(next)) {
                    if (m28265b(next)) {
                        parseDynamicGoodRvModel(goodsItemEntity, next, businessCateEntity, i, arrayList, businessCategoryRvModel, i3, iBlockScope);
                    } else {
                        parseDynamicPromotionGoodRvModel(next, businessCateEntity, businessCategoryRvModel, i3, iBlockScope, i, str);
                    }
                } else if (goodsItemEntity != null) {
                    parseGoodRvModel(goodsItemEntity, businessCateEntity, i, arrayList2, businessCategoryRvModel, i3);
                } else {
                    LogUtil.m29100d(f39669b, "there are no good items");
                }
                i2 = i3;
            }
            if (arrayList.size() > 0) {
                businessCategoryRvModel2.mGoodsDynamicItemList.add((ComponentModel) arrayList.remove(0));
            }
            if (!arrayList.isEmpty()) {
                businessCategoryRvModel2.mExpandRvModel = BusinessExpandRvModel.createForDy(false, arrayList);
            }
            if (arrayList2.size() > 0) {
                businessCategoryRvModel2.mGoodsItemList.add((BusinessGoodsItemRvModel) arrayList2.remove(0));
            }
            if (!arrayList2.isEmpty()) {
                businessCategoryRvModel2.mExpandRvModel = BusinessExpandRvModel.createForDy(false, arrayList);
            }
        }
    }

    public static void parseGoodItems(BusinessCateEntity businessCateEntity, BusinessCategoryRvModel businessCategoryRvModel, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (GoodsItemEntity parseGoodRvModel : businessCateEntity.items) {
            int i3 = i2 + 1;
            parseGoodRvModel(parseGoodRvModel, businessCateEntity, i, arrayList, businessCategoryRvModel, i3);
            i2 = i3;
        }
        if (arrayList.size() > 0) {
            businessCategoryRvModel.mGoodsItemList.add((BusinessGoodsItemRvModel) arrayList.remove(0));
        }
        if (!arrayList.isEmpty()) {
            businessCategoryRvModel.mExpandRvModel = BusinessExpandRvModel.create(false, arrayList);
        }
    }

    public static void parseGoodRvModel(GoodsItemEntity goodsItemEntity, BusinessCateEntity businessCateEntity, int i, List<BusinessGoodsItemRvModel> list, BusinessCategoryRvModel businessCategoryRvModel, int i2) {
        BusinessGoodsItemRvModel newInstance = BusinessGoodsItemRvModel.newInstance(goodsItemEntity);
        newInstance.mCateId = businessCateEntity.cateId;
        newInstance.mCateName = businessCateEntity.cateName;
        boolean z = true;
        if (!(goodsItemEntity.cHasWine == 1 || businessCateEntity.type == 1)) {
            z = false;
        }
        newInstance.mNeedAlcoholRemind = z;
        newInstance.mInCategoryIndex = i2;
        GoodsItemState goodsItemState = GoodsDataHelper.getGoodsItemState(goodsItemEntity, i);
        newInstance.mGoodsAmountModel = new GoodsAmountModel.Builder().setGoodsItemState(goodsItemState).setMaxSaleAmount(newInstance.mMaxOrderSale).setActivityType(goodsItemEntity.activityType).setGoodsId(newInstance.mGoodsId).setItemUniKey(newInstance.mItemUniqKey).setBusinessId(newInstance.mBusinessId).setInitialAmount(0).setMinAmount(0).setMaxAmount(99).setAllowOverAmoun(goodsItemEntity.allowOverAmount).build();
        newInstance.mCateIndex = businessCategoryRvModel.mCategoryIndex;
        if (goodsItemState == GoodsItemState.SOLD_OUT) {
            list.add(newInstance);
        } else {
            businessCategoryRvModel.mGoodsItemList.add(newInstance);
        }
    }

    public static void parseDynamicGoodRvModel(GoodsItemEntity goodsItemEntity, JsonObject jsonObject, BusinessCateEntity businessCateEntity, int i, List<ComponentModel> list, BusinessCategoryRvModel businessCategoryRvModel, int i2, IBlockScope iBlockScope) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel;
        RecyclerModel parseExceptWidgetNodeModel = BlocksCommonParser.parseExceptWidgetNodeModel(GlobalContext.getContext(), jsonObject, iBlockScope);
        GoodsItemState goodsItemState = GoodsItemState.FOR_SALE;
        if (goodsItemEntity != null) {
            goodsItemState = GoodsDataHelper.getGoodsItemState(goodsItemEntity, i);
            businessGoodsItemRvModel = BusinessGoodsItemRvModel.newInstance(goodsItemEntity);
            businessGoodsItemRvModel.mCateId = businessCateEntity.cateId;
            businessGoodsItemRvModel.mCateName = businessCateEntity.cateName;
            boolean z = true;
            if (!(goodsItemEntity.cHasWine == 1 || businessCateEntity.type == 1)) {
                z = false;
            }
            businessGoodsItemRvModel.mNeedAlcoholRemind = z;
            businessGoodsItemRvModel.mInCategoryIndex = i2;
            businessGoodsItemRvModel.mGoodsAmountModel = new GoodsAmountModel.Builder().setGoodsItemState(goodsItemState).setMaxSaleAmount(businessGoodsItemRvModel.mMaxOrderSale).setActivityType(goodsItemEntity.activityType).setGoodsId(businessGoodsItemRvModel.mGoodsId).setItemUniKey(businessGoodsItemRvModel.mItemUniqKey).setBusinessId(businessGoodsItemRvModel.mBusinessId).setInitialAmount(0).setMinAmount(0).setMaxAmount(99).setAllowOverAmoun(goodsItemEntity.allowOverAmount).build();
            businessGoodsItemRvModel.mCateIndex = businessCategoryRvModel.mCategoryIndex;
            if (parseExceptWidgetNodeModel instanceof ComponentModel) {
                ((ComponentModel) parseExceptWidgetNodeModel).setDataModel(businessGoodsItemRvModel);
            }
        } else {
            businessGoodsItemRvModel = null;
        }
        JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
        if (asJsonObject != null) {
            addBlockJsonParam(asJsonObject, businessCategoryRvModel, businessGoodsItemRvModel);
        }
        if (parseExceptWidgetNodeModel instanceof ComponentModel) {
            if (iBlockScope != null) {
                ComponentModel componentModel = (ComponentModel) parseExceptWidgetNodeModel;
                componentModel.setWidgetNodeModel(BlocksCommonParser.parseWidgetNode(jsonObject, componentModel, iBlockScope));
                addBlockNodeContextParam(componentModel, businessCategoryRvModel);
            }
            if (goodsItemState == null || goodsItemState != GoodsItemState.SOLD_OUT) {
                businessCategoryRvModel.mGoodsDynamicItemList.add((ComponentModel) parseExceptWidgetNodeModel);
            } else {
                list.add((ComponentModel) parseExceptWidgetNodeModel);
            }
        }
    }

    public static void parseDynamicPromotionGoodRvModel(JsonObject jsonObject, BusinessCateEntity businessCateEntity, BusinessCategoryRvModel businessCategoryRvModel, int i, IBlockScope iBlockScope, int i2, String str) {
        GoodsItemEntity goodsItemEntity;
        JsonObject jsonObject2 = jsonObject;
        BusinessCateEntity businessCateEntity2 = businessCateEntity;
        BusinessCategoryRvModel businessCategoryRvModel2 = businessCategoryRvModel;
        IBlockScope iBlockScope2 = iBlockScope;
        String str2 = str;
        RecyclerModel parseExceptWidgetNodeModel = BlocksCommonParser.parseExceptWidgetNodeModel(GlobalContext.getContext(), jsonObject2, iBlockScope2);
        JsonObject asJsonObject = jsonObject2.getAsJsonObject("data");
        if (asJsonObject != null) {
            int i3 = 1;
            addBlockJsonParam(asJsonObject, i, true);
            JsonArray asJsonArray = asJsonObject.getAsJsonArray(FirebaseAnalytics.Param.ITEMS);
            ArrayList arrayList = new ArrayList();
            if (asJsonArray != null) {
                int i4 = 0;
                while (i4 < asJsonArray.size()) {
                    JsonObject asJsonObject2 = asJsonArray.get(i4).getAsJsonObject();
                    if (asJsonObject2 == null || (goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) asJsonObject2, (Type) GoodsItemEntity.class)) == null) {
                        int i5 = i2;
                    } else {
                        BusinessGoodsItemRvModel newInstance = BusinessGoodsItemRvModel.newInstance(goodsItemEntity);
                        newInstance.mCateId = businessCateEntity2.cateId;
                        newInstance.mCateName = businessCateEntity2.cateName;
                        newInstance.mNeedAlcoholRemind = goodsItemEntity.cHasWine == i3 || businessCateEntity2.type == i3;
                        newInstance.mInCategoryIndex = i4;
                        newInstance.mGoodsAmountModel = new GoodsAmountModel.Builder().setGoodsItemState(GoodsDataHelper.getGoodsItemState(goodsItemEntity, i2)).setMaxSaleAmount(newInstance.mMaxOrderSale).setActivityType(goodsItemEntity.activityType).setGoodsId(newInstance.mGoodsId).setItemUniKey(newInstance.mItemUniqKey).setBusinessId(newInstance.mBusinessId).setInitialAmount(0).setMinAmount(0).setMaxAmount(99).setAllowOverAmoun(goodsItemEntity.allowOverAmount).build();
                        if (str2 != null && (str2.equals(newInstance.mItemUniqKey) || str2.equals(newInstance.mGoodsId))) {
                            asJsonObject.addProperty(BlocksConst.HORIZONTAL_ANCHOR_INDEX, (Number) Integer.valueOf(i4));
                        }
                        newInstance.mCateIndex = businessCategoryRvModel2.mCategoryIndex;
                        parseIsMarketArea(goodsItemEntity, iBlockScope2);
                        arrayList.add(newInstance);
                    }
                    i4++;
                    i3 = 1;
                }
            }
            if (parseExceptWidgetNodeModel instanceof ComponentModel) {
                ComponentModel componentModel = (ComponentModel) parseExceptWidgetNodeModel;
                componentModel.setDataModel(arrayList);
                if (iBlockScope2 != null) {
                    componentModel.setWidgetNodeModel(BlocksCommonParser.parseWidgetNode(jsonObject2, componentModel, iBlockScope2));
                    addBlockNodeContextParam(componentModel, businessCategoryRvModel2);
                }
                businessCategoryRvModel2.mGoodsDynamicItemList.add(componentModel);
            }
        }
    }

    public static void parseIsMarketArea(GoodsItemEntity goodsItemEntity, IBlockScope iBlockScope) {
        if (goodsItemEntity != null) {
            if (100 == goodsItemEntity.activityType) {
                iBlockScope.attach(PARA_IS_MARKET_AREA, 1);
            } else if (101 == goodsItemEntity.activityType) {
                iBlockScope.attach(PARA_IS_MARKET_AREA, 2);
            }
        }
    }

    public static List<BusinessGoodsItemRvModel> parseBusinessSearchEntity(BusinessSearchResultEntity businessSearchResultEntity, int i) {
        ArrayList arrayList = new ArrayList();
        if (businessSearchResultEntity != null && !CollectionsUtil.isEmpty(businessSearchResultEntity.data)) {
            int i2 = 0;
            for (BusinessSearchResultEntity.GoodsItemAndCatEntity next : businessSearchResultEntity.data) {
                if (!(next.item == null || next.category == null)) {
                    BusinessGoodsItemRvModel newInstance = BusinessGoodsItemRvModel.newInstance(next.item);
                    newInstance.mCateId = next.category.cateId;
                    newInstance.mCateName = next.category.cateName;
                    boolean z = true;
                    if (!(next.item.cHasWine == 1 || next.category.type == 1)) {
                        z = false;
                    }
                    newInstance.mNeedAlcoholRemind = z;
                    newInstance.mInCategoryIndex = i2;
                    newInstance.mGoodsAmountModel = new GoodsAmountModel.Builder().setGoodsItemState(GoodsDataHelper.getGoodsItemState(next.item, i)).setMaxSaleAmount(newInstance.mMaxOrderSale).setActivityType(next.item.activityType).setGoodsId(newInstance.mGoodsId).setItemUniKey(newInstance.mItemUniqKey).setBusinessId(newInstance.mBusinessId).setInitialAmount(0).setMinAmount(0).setMaxAmount(99).setAllowOverAmoun(next.item.allowOverAmount).build();
                    arrayList.add(newInstance);
                    i2++;
                }
            }
        }
        return arrayList;
    }

    public static List<ComponentModel> parseDyBusinessSearchEntity(BusinessSearchResultEntity businessSearchResultEntity, List<BusinessGoodsItemRvModel> list, int i, IBlockScope iBlockScope) {
        ArrayList arrayList = new ArrayList();
        if (businessSearchResultEntity != null && !CollectionsUtil.isEmpty(businessSearchResultEntity.data)) {
            int i2 = 0;
            for (BusinessSearchResultEntity.GoodsItemAndCatEntity next : businessSearchResultEntity.data) {
                if (!(next.mJsonComp == null || next.category == null || next.mJsonComp.getAsJsonObject("data") == null || next.mJsonComp.getAsJsonObject("componentV2") == null || next.mJsonComp.getAsJsonObject("componentV2").get("tmplId") == null || TextUtils.isEmpty(next.mJsonComp.getAsJsonObject("componentV2").get("tmplId").getAsString()))) {
                    GoodsItemEntity goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) next.mJsonComp.getAsJsonObject("data"), (Type) GoodsItemEntity.class);
                    next.item = goodsItemEntity;
                    ComponentModel parseExceptWidgetNodeModelComponent = BlocksCommonParser.parseExceptWidgetNodeModelComponent(GlobalContext.getContext(), next.mJsonComp, iBlockScope);
                    if (parseExceptWidgetNodeModelComponent != null) {
                        if (goodsItemEntity != null) {
                            BusinessGoodsItemRvModel newInstance = BusinessGoodsItemRvModel.newInstance(goodsItemEntity);
                            newInstance.mCateId = next.category.cateId;
                            newInstance.mCateName = next.category.cateName;
                            boolean z = true;
                            if (!(goodsItemEntity.cHasWine == 1 || next.category.type == 1)) {
                                z = false;
                            }
                            newInstance.mNeedAlcoholRemind = z;
                            newInstance.mInCategoryIndex = i2;
                            newInstance.mGoodsAmountModel = new GoodsAmountModel.Builder().setGoodsItemState(GoodsDataHelper.getGoodsItemState(goodsItemEntity, i)).setMaxSaleAmount(newInstance.mMaxOrderSale).setActivityType(goodsItemEntity.activityType).setGoodsId(newInstance.mGoodsId).setItemUniKey(newInstance.mItemUniqKey).setBusinessId(newInstance.mBusinessId).setInitialAmount(0).setMinAmount(0).setMaxAmount(99).setAllowOverAmoun(goodsItemEntity.allowOverAmount).build();
                            addBlockJsonParam(next.mJsonComp.getAsJsonObject("data"), newInstance, businessSearchResultEntity.data.size());
                            list.add(newInstance);
                            parseExceptWidgetNodeModelComponent.setDataModel(newInstance);
                            i2++;
                        }
                        parseExceptWidgetNodeModelComponent.setWidgetNodeModel(BlocksCommonParser.parseWidgetNode(next.mJsonComp, parseExceptWidgetNodeModelComponent, iBlockScope));
                        if (next.category != null) {
                            addBlockNodeContextParam(parseExceptWidgetNodeModelComponent, BusinessCategoryRvModel.newInstance(next.category));
                        }
                        arrayList.add(parseExceptWidgetNodeModelComponent);
                    }
                }
            }
        }
        return arrayList;
    }

    public static BusinessGoodsItemRvModel getGoodRvModelFromParam(HashMap<String, Object> hashMap, Buildable buildable) {
        List<BusinessGoodsItemRvModel> b;
        BusinessGoodsItemRvModel a = m28251a(buildable);
        if (a != null || (b = m28262b(buildable)) == null) {
            return a;
        }
        try {
            return b.get(Integer.parseInt((String) hashMap.get("innerIndex")));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m29100d(f39669b, "parse promotion list error" + e.toString());
            return a;
        }
    }

    /* renamed from: a */
    private static BusinessGoodsItemRvModel m28251a(Buildable buildable) {
        if (buildable != null && (buildable instanceof BaseBinder)) {
            BaseBinder baseBinder = (BaseBinder) buildable;
            if (baseBinder.getVirtualNode() != null && (baseBinder.getVirtualNode().getDataModel() instanceof ComponentModel)) {
                ComponentModel componentModel = (ComponentModel) baseBinder.getVirtualNode().getDataModel();
                if (componentModel.getDataModel() instanceof BusinessGoodsItemRvModel) {
                    return (BusinessGoodsItemRvModel) componentModel.getDataModel();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static List<BusinessGoodsItemRvModel> m28262b(Buildable buildable) {
        if (buildable != null && (buildable instanceof BaseBinder)) {
            BaseBinder baseBinder = (BaseBinder) buildable;
            if (baseBinder.getVirtualNode() != null && (baseBinder.getVirtualNode().getDataModel() instanceof ComponentModel)) {
                ComponentModel componentModel = (ComponentModel) baseBinder.getVirtualNode().getDataModel();
                if (componentModel.getDataModel() instanceof List) {
                    List list = (List) componentModel.getDataModel();
                    if (list.size() > 0 && (list.get(0) instanceof BusinessGoodsItemRvModel)) {
                        return (List) componentModel.getDataModel();
                    }
                }
            }
        }
        return null;
    }

    public static ComponentModel findGoodItemRvFromComponent(List<ComponentModel> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            for (ComponentModel next : list) {
                if (getGoodItemRvModelFromComponentModel(next, str) != null) {
                    return next;
                }
            }
        }
        return null;
    }

    public static BusinessGoodsItemRvModel getGoodItemRvModelFromComponentModel(ComponentModel componentModel, String str) {
        List list;
        if (componentModel == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if ((componentModel.getDataModel() instanceof BusinessGoodsItemRvModel) && (str.equals(((BusinessGoodsItemRvModel) componentModel.getDataModel()).mItemUniqKey) || str.equals(((BusinessGoodsItemRvModel) componentModel.getDataModel()).mGoodsId))) {
            return (BusinessGoodsItemRvModel) componentModel.getDataModel();
        }
        if (!(componentModel.getDataModel() instanceof List) || (list = (List) componentModel.getDataModel()) == null) {
            return null;
        }
        for (Object next : list) {
            if (next instanceof BusinessGoodsItemRvModel) {
                BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next;
                if (str.equals(businessGoodsItemRvModel.mItemUniqKey) || str.equals(businessGoodsItemRvModel.mGoodsId)) {
                    return businessGoodsItemRvModel;
                }
            }
        }
        return null;
    }

    public static BusinessGoodsItemRvModel findGoodsItemRvModel(List<BusinessGoodsItemRvModel> list, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !CollectionsUtil.isEmpty(list)) {
            for (BusinessGoodsItemRvModel next : list) {
                if (str.equals(next.mGoodsId) && str2.equals(next.mCateId)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static BusinessGoodsItemRvModel findGoodsItemRvModel(List<BusinessGoodsItemRvModel> list, String str) {
        if (!TextUtils.isEmpty(str) && !CollectionsUtil.isEmpty(list)) {
            for (BusinessGoodsItemRvModel next : list) {
                if (str.equals(next.mGoodsId)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean hasDynamicNotice(BusinessEntity businessEntity) {
        return (businessEntity == null || businessEntity.alertInfo == null || TextUtils.isEmpty(businessEntity.alertInfo.content)) ? false : true;
    }

    public static boolean hasAttentionContent(BusinessEntity businessEntity) {
        return businessEntity != null && hasAttentionContent(businessEntity.attentionInfo);
    }

    public static boolean hasAttentionContent(BusinessAttentionInfoEntity businessAttentionInfoEntity) {
        return businessAttentionInfoEntity != null && !TextUtils.isEmpty(businessAttentionInfoEntity.content) && !TextUtils.isEmpty(businessAttentionInfoEntity.imgUrl);
    }

    public static GoodsItemEntity findGoodEntityById(BusinessEntity businessEntity, String str) {
        if (checkCategoryValid(businessEntity) && !TextUtils.isEmpty(str)) {
            for (BusinessCateEntity next : businessEntity.cateInfo) {
                if (!CollectionsUtil.isEmpty(next.items)) {
                    for (GoodsItemEntity next2 : next.items) {
                        if (next2 != null && str.equals(next2.itemId)) {
                            return next2;
                        }
                    }
                    continue;
                } else if (!CollectionsUtil.isEmpty(next.mJsonComponentList)) {
                    for (JsonObject next3 : next.mJsonComponentList) {
                        try {
                            if (m28265b(next3)) {
                                GoodsItemEntity goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) next3.getAsJsonObject("data"), (Type) GoodsItemEntity.class);
                                if (goodsItemEntity != null && str.equals(goodsItemEntity.itemId)) {
                                    return goodsItemEntity;
                                }
                            } else {
                                GoodsItemEntity a = m28252a(next3, str);
                                if (a != null) {
                                    return a;
                                }
                            }
                        } catch (Exception e) {
                            LogUtil.m29100d(f39669b, "parse business goods error:" + e.toString());
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static GoodsItemEntity findGoodEntityByItemUniKey(BusinessEntity businessEntity, String str) {
        if (checkCategoryValid(businessEntity) && !TextUtils.isEmpty(str)) {
            for (BusinessCateEntity next : businessEntity.cateInfo) {
                if (!CollectionsUtil.isEmpty(next.items)) {
                    for (GoodsItemEntity next2 : next.items) {
                        if (next2 != null && str.equals(next2.itemUniqKey)) {
                            return next2;
                        }
                    }
                    continue;
                } else if (!CollectionsUtil.isEmpty(next.mJsonComponentList)) {
                    for (JsonObject next3 : next.mJsonComponentList) {
                        try {
                            if (m28265b(next3)) {
                                GoodsItemEntity goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) next3.getAsJsonObject("data"), (Type) GoodsItemEntity.class);
                                if (goodsItemEntity != null && str.equals(goodsItemEntity.itemUniqKey)) {
                                    return goodsItemEntity;
                                }
                            } else {
                                GoodsItemEntity a = m28252a(next3, str);
                                if (a != null) {
                                    return a;
                                }
                            }
                        } catch (Exception e) {
                            LogUtil.m29100d(f39669b, "parse business goods error:" + e.toString());
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static GoodsItemEntity m28252a(JsonObject jsonObject, String str) {
        JsonArray asJsonArray;
        GoodsItemEntity goodsItemEntity;
        JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
        if (!(asJsonObject == null || (asJsonArray = asJsonObject.getAsJsonArray(FirebaseAnalytics.Param.ITEMS)) == null)) {
            for (int i = 0; i < asJsonArray.size(); i++) {
                JsonObject asJsonObject2 = asJsonArray.get(i).getAsJsonObject();
                if ((Objects.equals(str, asJsonObject2.get(Const.PageParams.ITEM_UNIQ_KEY).getAsString()) || Objects.equals(str, asJsonObject2.get(BlocksConst.ACTION_PARAMS_ITEM_ID).getAsString())) && (goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) asJsonObject2, (Type) GoodsItemEntity.class)) != null) {
                    return goodsItemEntity;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m28260a(JsonObject jsonObject) {
        return (jsonObject == null || jsonObject.get("type") == null || !"200".equals(jsonObject.get("type").getAsString())) ? false : true;
    }

    /* renamed from: b */
    private static boolean m28265b(JsonObject jsonObject) {
        return (jsonObject == null || jsonObject.get("type") == null || !Const.BindCardScene.DEFAULT_EMBED.equals(jsonObject.get("type").getAsString())) ? false : true;
    }

    public static GoodsItemEntity findGoodEntity(BusinessEntity businessEntity, String str, String str2) {
        GoodsItemEntity findGoodEntityByItemUniKey = findGoodEntityByItemUniKey(businessEntity, str2);
        return findGoodEntityByItemUniKey == null ? findGoodEntityById(businessEntity, str) : findGoodEntityByItemUniKey;
    }

    public static GoodsItemEntity findGoodEntityById(BusinessSearchResultEntity businessSearchResultEntity, int i, String str) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("findGoodEntityById entity is null = ");
        sb.append(businessSearchResultEntity);
        sb.append(",data = ");
        Object obj2 = "";
        if (businessSearchResultEntity == null) {
            obj = obj2;
        } else {
            obj = businessSearchResultEntity.data;
        }
        sb.append(obj);
        sb.append(",goodID = ");
        sb.append(str);
        sb.append("，index = ");
        sb.append(i);
        LogUtil.m29104i(f39669b, sb.toString());
        if (!(businessSearchResultEntity == null || businessSearchResultEntity.data == null || TextUtils.isEmpty(str))) {
            List<BusinessSearchResultEntity.GoodsItemAndCatEntity> list = businessSearchResultEntity.data;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item size =");
            sb2.append(list == null ? "null" : Integer.valueOf(list.size()));
            LogUtil.m29104i(f39669b, sb2.toString());
            if (i < 0 || i >= list.size() || list.get(i) == null || list.get(i).item == null || !str.equals(list.get(i).item.itemId)) {
                for (BusinessSearchResultEntity.GoodsItemAndCatEntity next : list) {
                    if (next != null && next.item != null && str.equals(next.item.itemId)) {
                        LogUtil.m29104i(f39669b, "findGoodEntityById return good.item node = " + next.item.node);
                        return next.item;
                    }
                }
                LogUtil.m29104i(f39669b, "findGoodEntityById final return null");
            } else {
                GoodsItemEntity goodsItemEntity = businessSearchResultEntity.data.get(i).item;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("findGoodEntityById return goodsItemEntity node = ");
                if (goodsItemEntity != null) {
                    obj2 = goodsItemEntity.node;
                }
                sb3.append(obj2);
                LogUtil.m29104i(f39669b, sb3.toString());
                return goodsItemEntity;
            }
        }
        return null;
    }

    public static GoodsItemEntity findGoodEntityByUniKey(BusinessSearchResultEntity businessSearchResultEntity, int i, String str) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("findGoodEntityByUniKey entity is null = ");
        sb.append(businessSearchResultEntity);
        sb.append(",data = ");
        Object obj2 = "";
        if (businessSearchResultEntity == null) {
            obj = obj2;
        } else {
            obj = businessSearchResultEntity.data;
        }
        sb.append(obj);
        sb.append(",goodID = ");
        sb.append(str);
        sb.append("，index = ");
        sb.append(i);
        LogUtil.m29104i(f39669b, sb.toString());
        if (!(businessSearchResultEntity == null || businessSearchResultEntity.data == null || TextUtils.isEmpty(str))) {
            List<BusinessSearchResultEntity.GoodsItemAndCatEntity> list = businessSearchResultEntity.data;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item size =");
            sb2.append(list == null ? "null" : Integer.valueOf(list.size()));
            LogUtil.m29104i(f39669b, sb2.toString());
            if (i < 0 || i >= list.size() || list.get(i) == null || list.get(i).item == null || !str.equals(list.get(i).item.itemUniqKey)) {
                for (BusinessSearchResultEntity.GoodsItemAndCatEntity next : list) {
                    if (next != null && next.item != null && str.equals(next.item.itemUniqKey)) {
                        LogUtil.m29104i(f39669b, "findGoodEntityByUniKey return good.item node = " + next.item.node);
                        return next.item;
                    }
                }
                LogUtil.m29104i(f39669b, "findGoodEntityByUniKey final return null");
            } else {
                GoodsItemEntity goodsItemEntity = businessSearchResultEntity.data.get(i).item;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("findGoodEntityByUniKey return goodsItemEntity node = ");
                if (goodsItemEntity != null) {
                    obj2 = goodsItemEntity.node;
                }
                sb3.append(obj2);
                LogUtil.m29104i(f39669b, sb3.toString());
                return goodsItemEntity;
            }
        }
        return null;
    }

    public static GoodsItemEntity findDyGoodEntityById(BusinessSearchResultEntity businessSearchResultEntity, int i, String str) {
        Object obj;
        GoodsItemEntity goodsItemEntity;
        StringBuilder sb = new StringBuilder();
        sb.append("findDyGoodEntityById entity is null = ");
        sb.append(businessSearchResultEntity);
        sb.append(",data = ");
        Object obj2 = "";
        if (businessSearchResultEntity == null) {
            obj = obj2;
        } else {
            obj = businessSearchResultEntity.data;
        }
        sb.append(obj);
        sb.append(",goodID = ");
        sb.append(str);
        sb.append("，index = ");
        sb.append(i);
        LogUtil.m29104i(f39669b, sb.toString());
        if (!(businessSearchResultEntity == null || businessSearchResultEntity.data == null || TextUtils.isEmpty(str))) {
            List<BusinessSearchResultEntity.GoodsItemAndCatEntity> list = businessSearchResultEntity.data;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item size =");
            sb2.append(list == null ? "null" : Integer.valueOf(list.size()));
            LogUtil.m29104i(f39669b, sb2.toString());
            for (BusinessSearchResultEntity.GoodsItemAndCatEntity next : list) {
                if (next != null && next.mJsonComp != null && next.mJsonComp.getAsJsonObject("data") != null && (goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) next.mJsonComp.getAsJsonObject("data"), (Type) GoodsItemEntity.class)) != null && str.equals(goodsItemEntity.itemId)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("findDyGoodEntityById return goodsItemEntity node = ");
                    if (goodsItemEntity != null) {
                        obj2 = goodsItemEntity.node;
                    }
                    sb3.append(obj2);
                    LogUtil.m29104i(f39669b, sb3.toString());
                    return goodsItemEntity;
                }
            }
            LogUtil.m29104i(f39669b, "findDyGoodEntityById final return null");
        }
        return null;
    }

    public static GoodsItemEntity findDyGoodEntityByUniKey(BusinessSearchResultEntity businessSearchResultEntity, int i, String str) {
        Object obj;
        GoodsItemEntity goodsItemEntity;
        StringBuilder sb = new StringBuilder();
        sb.append("findGoodEntityByUniKey entity is null = ");
        sb.append(businessSearchResultEntity);
        sb.append(",data = ");
        Object obj2 = "";
        if (businessSearchResultEntity == null) {
            obj = obj2;
        } else {
            obj = businessSearchResultEntity.data;
        }
        sb.append(obj);
        sb.append(",goodID = ");
        sb.append(str);
        sb.append("，index = ");
        sb.append(i);
        LogUtil.m29104i(f39669b, sb.toString());
        if (!(businessSearchResultEntity == null || businessSearchResultEntity.data == null || TextUtils.isEmpty(str))) {
            List<BusinessSearchResultEntity.GoodsItemAndCatEntity> list = businessSearchResultEntity.data;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item size =");
            sb2.append(list == null ? "null" : Integer.valueOf(list.size()));
            LogUtil.m29104i(f39669b, sb2.toString());
            for (BusinessSearchResultEntity.GoodsItemAndCatEntity next : list) {
                if (next != null && next.mJsonComp != null && next.mJsonComp.getAsJsonObject("data") != null && (goodsItemEntity = (GoodsItemEntity) GsonUtil.fromJson((JsonElement) next.mJsonComp.getAsJsonObject("data"), (Type) GoodsItemEntity.class)) != null && str.equals(goodsItemEntity.itemUniqKey)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("findDyGoodEntityByUniKey return goodsItemEntity node = ");
                    if (goodsItemEntity != null) {
                        obj2 = goodsItemEntity.node;
                    }
                    sb3.append(obj2);
                    LogUtil.m29104i(f39669b, sb3.toString());
                    return goodsItemEntity;
                }
            }
            LogUtil.m29104i(f39669b, "findDyGoodEntityByUniKey final return null");
        }
        return null;
    }

    public static GoodsItemEntity findGoodEntitySearch(BusinessSearchResultEntity businessSearchResultEntity, int i, String str, String str2) {
        GoodsItemEntity findGoodEntityByUniKey = findGoodEntityByUniKey(businessSearchResultEntity, i, str2);
        return findGoodEntityByUniKey == null ? findGoodEntityById(businessSearchResultEntity, i, str) : findGoodEntityByUniKey;
    }

    public static GoodsItemEntity findGoodDyEntitySearch(BusinessSearchResultEntity businessSearchResultEntity, int i, String str, String str2) {
        try {
            GoodsItemEntity findDyGoodEntityByUniKey = findDyGoodEntityByUniKey(businessSearchResultEntity, i, str2);
            return findDyGoodEntityByUniKey == null ? findDyGoodEntityById(businessSearchResultEntity, i, str) : findDyGoodEntityByUniKey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CharSequence getBusinessDeliveryInfo(Context context, BusinessInfoEntity businessInfoEntity) {
        if (businessInfoEntity == null) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m28259a(businessInfoEntity)) {
            m28263b(spannableStringBuilder, businessInfoEntity, context);
        } else {
            m28256a(spannableStringBuilder, businessInfoEntity);
        }
        m28257a(spannableStringBuilder, businessInfoEntity, context);
        m28266c(spannableStringBuilder, businessInfoEntity, context);
        return spannableStringBuilder;
    }

    public static boolean isBuyAgent(BusinessInfoEntity businessInfoEntity) {
        if (businessInfoEntity == null || businessInfoEntity.modeInfo == null) {
            return false;
        }
        return businessInfoEntity.modeInfo.isBuyAgent();
    }

    /* renamed from: a */
    private static boolean m28259a(BusinessInfoEntity businessInfoEntity) {
        return isBuyAgent(businessInfoEntity) && !TextUtils.isEmpty(businessInfoEntity.modeInfo.getModeTagDesc());
    }

    public static boolean isShowBuyAgentInDetail(BusinessDetailModel.BusinessModeInfoModel businessModeInfoModel) {
        if (businessModeInfoModel != null && businessModeInfoModel.isBuyAgent() && !TextUtils.isEmpty(businessModeInfoModel.modeTagDesc) && !TextUtils.isEmpty(businessModeInfoModel.shortDesc)) {
            return true;
        }
        return false;
    }

    public static boolean isShowBuyAgentBtnLink(BusinessDetailModel.BusinessModeInfoModel businessModeInfoModel) {
        return businessModeInfoModel != null && businessModeInfoModel.isBuyAgent() && !TextUtils.isEmpty(businessModeInfoModel.ruleLink);
    }

    public static SpannableString createStarRatingSpanString(BusinessInfoEntity businessInfoEntity) {
        if (!m28264b(businessInfoEntity)) {
            return null;
        }
        String string = ResourceHelper.getString(R.string.customer_common_icon_recommend);
        SpannableString spannableString = new SpannableString(string + " " + businessInfoEntity.starRating.score);
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        if (businessInfoEntity.starRating.starColor == BusinessStarRatingEntity.STAR_COLOR_ORANGE) {
            spannableString.setSpan(new CustomerVerticalCenterSpan(14, SkinUtil.getBrandPrimaryColor()), 0, string.length(), 33);
            return spannableString;
        }
        spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, string.length(), 33);
        return spannableString;
    }

    public static boolean hasDeliveryFeeAct(BusinessInfoEntity businessInfoEntity) {
        return businessInfoEntity.deliveryPriceOri > businessInfoEntity.deliveryPriceAct;
    }

    public static CharSequence getBusinessDeliveryInfoForHome(Context context, BusinessInfoEntity businessInfoEntity) {
        if (businessInfoEntity == null || businessInfoEntity.deliveryPriceAct < 0) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int sp2px = (int) DisplayUtils.sp2px(context, 14.0f);
        if (!TextUtils.isEmpty(businessInfoEntity.deliveryDesc)) {
            SpannableString spannableString = new SpannableString(businessInfoEntity.deliveryDesc);
            spannableString.setSpan(new AbsoluteSizeSpan(sp2px), 0, spannableString.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_2_40_666666)), 0, spannableString.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(" ");
            SpannableString spannableString2 = new SpannableString(context.getResources().getString(R.string.customer_global_slash));
            spannableString2.setSpan(new AbsoluteSizeSpan((int) DisplayUtils.sp2px(context, 12.0f)), 0, spannableString2.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999)), 0, spannableString2.length(), 33);
            spannableStringBuilder.append(spannableString2);
            spannableStringBuilder.append(" ");
        }
        if (businessInfoEntity.deliveryPriceAct > 0) {
            SpannableString spannableString3 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceActDisplay, (long) businessInfoEntity.deliveryPriceAct, businessInfoEntity.currency, "home"));
            spannableString3.setSpan(new AbsoluteSizeSpan(sp2px), 0, spannableString3.length(), 33);
            spannableString3.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_2_40_666666)), 0, spannableString3.length(), 33);
            spannableStringBuilder.append(spannableString3);
            spannableStringBuilder.append(" ");
            if (businessInfoEntity.deliveryPriceOri > businessInfoEntity.deliveryPriceAct) {
                SpannableString spannableString4 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceOriDisplay, (long) businessInfoEntity.deliveryPriceOri, businessInfoEntity.currency, "home"));
                spannableString4.setSpan(new AbsoluteSizeSpan(sp2px), 0, spannableString4.length(), 33);
                spannableString4.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC)), 0, spannableString4.length(), 33);
                spannableString4.setSpan(new StrikethroughSpan(), 0, spannableString4.length(), 33);
                spannableStringBuilder.append(spannableString4);
                spannableStringBuilder.append(" ");
            }
        }
        return spannableStringBuilder;
    }

    public static String getBusinessCategoryInfo(Context context, BusinessInfoEntity businessInfoEntity) {
        if (CollectionsUtil.isEmpty(businessInfoEntity.cateTips)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String string = context.getResources().getString(R.string.customer_business_comma);
        int size = businessInfoEntity.cateTips.size() - 1;
        for (int i = 0; i <= size; i++) {
            sb.append(businessInfoEntity.cateTips.get(i).content);
            if (i != size) {
                sb.append(" ");
                sb.append(string);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static boolean checkCategoryValid(BusinessEntity businessEntity) {
        return checkEntityValid(businessEntity) && !CollectionsUtil.isEmpty(businessEntity.cateInfo);
    }

    public static boolean checkBusinessStatusNormal(BusinessInfoEntity businessInfoEntity) {
        return checkBusinessStatusNormal(businessInfoEntity.cShopStatus);
    }

    public static boolean hasBuyMoreInfo(BusinessEntity businessEntity) {
        return businessEntity.buyMoreInfo != null;
    }

    public static String getBusinessDeliveryTypeDesc(Context context, int i) {
        if (i != 1) {
            return i == 2 ? context.getResources().getString(R.string.customer_business_self_delivery) : "";
        }
        return context.getResources().getString(R.string.customer_business_didi_delivery, new Object[]{"99"});
    }

    public static int getBusinessExceptionShowStyle(int i, String str) {
        if (i == 2) {
            return TextUtils.isEmpty(str) ? 1 : 2;
        }
        if (i != 3) {
            return i != 4 ? 1 : 3;
        }
        return 0;
    }

    public static String getBusinessStatusTxt(int i, String str) {
        int businessExceptionShowStyle = getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            return ResourceHelper.getString(R.string.customer_business_status_out_of_delivery_no_folding);
        }
        if (businessExceptionShowStyle == 2) {
            return ResourceHelper.getString(R.string.customer_business_status_next_open_time_no_folding, str);
        } else if (businessExceptionShowStyle != 3) {
            return ResourceHelper.getString(R.string.customer_business_status_open_soon_no_folding);
        } else {
            return ResourceHelper.getString(R.string.customer_business_detail_temporarily_unavailable);
        }
    }

    public static boolean isNeedReloadSubitem(BusinessInfoEntity businessInfoEntity) {
        return (businessInfoEntity != null ? businessInfoEntity.needReloadSubitem : 0) != 0;
    }

    public static boolean isNeedReloadSubitem(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        return businessGoodsItemRvModel.mNeedReloadDetail == 1;
    }

    public static void toGoodItemDetail(ScopeContext scopeContext, GoodsItemEntity goodsItemEntity, int i, boolean z, String str, int i2, String str2, String str3, int... iArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i2);
        bundle.putString(Const.PageParams.SHOP_ID, goodsItemEntity.shopId);
        bundle.putBoolean(Const.PageParams.ITEM_NEED_SHOW_ALCOHOL_REMIND, z);
        bundle.putString(Const.PageParams.CART_REVISION, str2);
        bundle.putString(Const.PageParams.BIDATA, str);
        bundle.putString(Const.PageParams.KEY_CATE_ID, str3);
        bundle.putInt(ParamConst.PARAM_ITEM_LOCATION, i);
        if (iArr != null && iArr.length > 0) {
            bundle.putInt(ParamConst.PARAM_TAB_LOCATION, iArr[0]);
        }
        try {
            bundle.putString(Const.PageParams.ACT_INFO, GsonUtil.toJson(goodsItemEntity.actInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle) {
            bundle.putString(Const.PageParams.ITEM_ID, goodsItemEntity.itemId);
            bundle.putString(Const.PageParams.ITEM_UNIQ_KEY, TextUtils.isEmpty(goodsItemEntity.itemUniqKey) ? goodsItemEntity.itemId : goodsItemEntity.itemUniqKey);
            scopeContext.getNavigator().pushForResult((GoodsPurchasePage) PageFactory.newInstance(GoodsPurchasePage.class, bundle));
            return;
        }
        bundle.putSerializable(Const.PageParams.ITEM_ENTITY, goodsItemEntity);
        scopeContext.getNavigator().pushForResult((com.didi.soda.goods.page.GoodsPurchasePage) PageFactory.newInstance(com.didi.soda.goods.page.GoodsPurchasePage.class, bundle));
    }

    public static void toGoodsItemDetail(ScopeContext scopeContext, BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z, String str, int i, String str2, int... iArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        bundle.putString(Const.PageParams.SHOP_ID, businessGoodsItemRvModel.mBusinessId);
        bundle.putString(Const.PageParams.ITEM_ID, businessGoodsItemRvModel.mGoodsId);
        bundle.putString(Const.PageParams.ITEM_UNIQ_KEY, businessGoodsItemRvModel.mItemUniqKey);
        bundle.putBoolean(Const.PageParams.ITEM_NEED_SHOW_ALCOHOL_REMIND, z);
        bundle.putString(Const.PageParams.CART_REVISION, str2);
        bundle.putString(Const.PageParams.BIDATA, str);
        bundle.putString(Const.PageParams.KEY_CATE_ID, businessGoodsItemRvModel.mCateId);
        bundle.putInt(ParamConst.PARAM_ITEM_LOCATION, businessGoodsItemRvModel.mInCategoryIndex);
        if (iArr != null && iArr.length > 0) {
            bundle.putInt(ParamConst.PARAM_TAB_LOCATION, iArr[0]);
        }
        try {
            bundle.putString(Const.PageParams.ACT_INFO, GsonUtil.toJson(businessGoodsItemRvModel.mActinfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle) {
            scopeContext.getNavigator().pushForResult((GoodsPurchasePage) PageFactory.newInstance(GoodsPurchasePage.class, bundle));
            return;
        }
        scopeContext.getNavigator().pushForResult((com.didi.soda.goods.page.GoodsPurchasePage) PageFactory.newInstance(com.didi.soda.goods.page.GoodsPurchasePage.class, bundle));
    }

    public static void dispatchAddAction(ScopeContext scopeContext, GoodsItemEntity goodsItemEntity, BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, int i, String str2, boolean z, BusinessOmegaHelper businessOmegaHelper, CartItemModel cartItemModel) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        int currentAmount = (businessGoodsItemRvModel2 == null || businessGoodsItemRvModel2.mGoodsAmountModel == null || businessGoodsItemRvModel2.mGoodsAmountModel.getCurrentAmount() <= 0) ? 1 : businessGoodsItemRvModel2.mGoodsAmountModel.getCurrentAmount();
        LogUtil.m29100d("dispatchAddAction", "amount : " + currentAmount);
        if (!GoodsDataHelper.hasMultipleContents(goodsItemEntity) && !businessGoodsItemRvModel2.mNeedAlcoholRemind) {
            m28258a(scopeContext, goodsItemEntity, currentAmount, str2, businessOmegaHelper, str, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.mInCategoryIndex);
        } else if (isNeedReloadSubitem(businessGoodsItemRvModel)) {
            toGoodsItemDetail(scopeContext, businessGoodsItemRvModel, z, str, i, str2, businessGoodsItemRvModel2.mCateIndex);
        } else {
            toGoodItemDetail(scopeContext, goodsItemEntity, businessGoodsItemRvModel2.mInCategoryIndex, z, str, i, str2, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateIndex);
        }
    }

    public static void dispatchMinusAction(ScopeContext scopeContext, GoodsItemEntity goodsItemEntity, BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, int i, String str2, boolean z, BusinessOmegaHelper businessOmegaHelper, String str3, String str4) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        int currentAmount = (businessGoodsItemRvModel2 == null || businessGoodsItemRvModel2.mGoodsAmountModel == null || businessGoodsItemRvModel2.mGoodsAmountModel.getCurrentAmount() <= 0) ? 0 : businessGoodsItemRvModel2.mGoodsAmountModel.getCurrentAmount();
        LogUtil.m29100d("dispatchAddAction", "amount : " + currentAmount);
        if (!GoodsDataHelper.hasMultipleContents(goodsItemEntity) && !businessGoodsItemRvModel2.mNeedAlcoholRemind) {
            dispatchSetItemAmountAction(scopeContext, goodsItemEntity, str3, str4, str2, currentAmount, businessOmegaHelper, str, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.mInCategoryIndex);
        } else if (isNeedReloadSubitem(businessGoodsItemRvModel)) {
            toGoodsItemDetail(scopeContext, businessGoodsItemRvModel, z, str, i, str2, businessGoodsItemRvModel2.mCateIndex);
        } else {
            toGoodItemDetail(scopeContext, goodsItemEntity, businessGoodsItemRvModel2.mInCategoryIndex, z, str, i, str2, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateIndex);
        }
    }

    /* renamed from: a */
    private static void m28258a(ScopeContext scopeContext, GoodsItemEntity goodsItemEntity, int i, String str, BusinessOmegaHelper businessOmegaHelper, String str2, String str3, int i2, int i3) {
        GoodsItemEntity goodsItemEntity2 = goodsItemEntity;
        if (goodsItemEntity2 == null || goodsItemEntity2.node == null) {
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_ADD_CART_ERROR).build().track();
            return;
        }
        CheckCartMaxNumKt.isReachMaxNum(scopeContext, goodsItemEntity2.shopId, goodsItemEntity2.itemUniqKey, (String) null, 1, new Function0(goodsItemEntity, str3, i2, i3, str, str2, i) {
            public final /* synthetic */ GoodsItemEntity f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ int f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ String f$5;
            public final /* synthetic */ String f$6;
            public final /* synthetic */ int f$7;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
            }

            public final Object invoke() {
                return BusinessDataHelper.m28254a(BusinessOmegaHelper.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Unit m28254a(BusinessOmegaHelper businessOmegaHelper, GoodsItemEntity goodsItemEntity, String str, int i, int i2, String str2, String str3, int i3) {
        GoodsItemEntity goodsItemEntity2 = goodsItemEntity;
        businessOmegaHelper.onGoodsAddPreCalculate(goodsItemEntity2.itemId, goodsItemEntity2.status, goodsItemEntity2.soldStatus, goodsItemEntity2.soldTimeDesc, goodsItemEntity2.price + "", goodsItemEntity2.specialPrice + "", goodsItemEntity2.activityType + "", str, i, i2);
        ArrayList arrayList = new ArrayList();
        ItemNodeEntity copy = goodsItemEntity2.node.copy();
        copy.amount = 1;
        arrayList.add(copy);
        LogUtil.m29104i(f39669b, "add single item:" + str2 + " shopId:" + goodsItemEntity2.shopId + " itemId:" + goodsItemEntity2.itemId + " itemUniKey" + goodsItemEntity2.itemUniqKey);
        SetItemParams setItemParams = new SetItemParams(goodsItemEntity2.shopId, goodsItemEntity2.itemId, goodsItemEntity2.itemUniqKey, GoodsDataHelper.hasMultipleContents(goodsItemEntity), 1, arrayList, (String) null, (String) null, 0, str2, str3, goodsItemEntity2.actInfo);
        StringBuilder sb = new StringBuilder();
        sb.append("直接加购 amount : ");
        sb.append(i3);
        LogUtil.m29100d("dispatchAddAction", sb.toString());
        final BusinessOmegaHelper businessOmegaHelper2 = businessOmegaHelper;
        setItemParams.setCallback(new CustomerRpcCallback<CartInfoEntity>() {
            public void onRpcSuccess(CartInfoEntity cartInfoEntity, long j) {
                if (cartInfoEntity != null) {
                    BusinessOmegaHelper.this.onGoodsAddPostCalculate(cartInfoEntity.getCartId(), BusinessDataHelper.m28261b(cartInfoEntity), 1);
                }
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                BusinessOmegaHelper.this.onGoodsAddPostCalculate("", "", 0);
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    public static void dispatchSetItemAmountAction(ScopeContext scopeContext, GoodsItemEntity goodsItemEntity, String str, String str2, String str3, int i, BusinessOmegaHelper businessOmegaHelper, String str4, String str5, int i2, int i3) {
        GoodsItemEntity goodsItemEntity2 = goodsItemEntity;
        if (goodsItemEntity2 == null || goodsItemEntity2.node == null) {
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_ADD_CART_ERROR).build().track();
            return;
        }
        CheckCartMaxNumKt.isReachMaxNum(scopeContext, goodsItemEntity2.shopId, goodsItemEntity2.itemUniqKey, str, i, new Function0(goodsItemEntity, str5, i2, i3, str3, str, i, str2, str4) {
            public final /* synthetic */ GoodsItemEntity f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ int f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ String f$5;
            public final /* synthetic */ String f$6;
            public final /* synthetic */ int f$7;
            public final /* synthetic */ String f$8;
            public final /* synthetic */ String f$9;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
                this.f$8 = r9;
                this.f$9 = r10;
            }

            public final Object invoke() {
                return BusinessDataHelper.m28255a(BusinessOmegaHelper.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Unit m28255a(final BusinessOmegaHelper businessOmegaHelper, GoodsItemEntity goodsItemEntity, String str, int i, int i2, String str2, String str3, int i3, String str4, String str5) {
        String str6;
        GoodsItemEntity goodsItemEntity2 = goodsItemEntity;
        businessOmegaHelper.onGoodsAddPreCalculate(goodsItemEntity2.itemId, goodsItemEntity2.status, goodsItemEntity2.soldStatus, goodsItemEntity2.soldTimeDesc, goodsItemEntity2.price + "", goodsItemEntity2.specialPrice + "", goodsItemEntity2.activityType + "", str, i, i2);
        LogUtil.m29104i(f39669b, "add single item:" + str2 + " shopId:" + goodsItemEntity2.shopId + " itemId:" + goodsItemEntity2.itemId + " itemUniKey" + goodsItemEntity2.itemUniqKey);
        SetItemAmountParams.Content content = new SetItemAmountParams.Content(str3, i3);
        String str7 = goodsItemEntity2.shopId;
        String str8 = goodsItemEntity2.itemId;
        String str9 = goodsItemEntity2.itemUniqKey;
        if (str4 == null) {
            str6 = "";
        } else {
            str6 = str4;
        }
        SetItemAmountParams setItemAmountParams = new SetItemAmountParams(str7, str8, str9, str6, content, str2, str5, goodsItemEntity2.actInfo);
        BusinessOmegaHelper businessOmegaHelper2 = businessOmegaHelper;
        setItemAmountParams.setCallback(new CustomerRpcCallback<CartInfoEntity>() {
            public void onRpcSuccess(CartInfoEntity cartInfoEntity, long j) {
                if (cartInfoEntity != null) {
                    BusinessOmegaHelper.this.onGoodsAddPostCalculate(cartInfoEntity.getCartId(), BusinessDataHelper.m28261b(cartInfoEntity), 1);
                }
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                BusinessOmegaHelper.this.onGoodsAddPostCalculate("", "", 0);
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItemAmount(setItemAmountParams);
        return Unit.INSTANCE;
    }

    public static CartItemModel findCartItemModel(CartInfoModel cartInfoModel, String str) {
        if (!(cartInfoModel == null || cartInfoModel.getCartItems() == null || cartInfoModel.getCartItems().size() == 0)) {
            Iterator<CartItemBaseModel> it = cartInfoModel.getCartItems().iterator();
            while (it.hasNext()) {
                CartItemBaseModel next = it.next();
                if (next != null && (next instanceof CartItemModel) && Objects.equals(next.getItemUniqKey(), str)) {
                    return (CartItemModel) next;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m28261b(CartInfoEntity cartInfoEntity) {
        if (!CollectionsUtil.isEmpty(cartInfoEntity.getItems())) {
            StringBuilder sb = new StringBuilder();
            for (CartItemEntity next : cartInfoEntity.getItems()) {
                if (next != null) {
                    sb.append(next.itemId);
                    sb.append("_");
                    sb.append(next.getAmount());
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                return sb.deleteCharAt(sb.length() - 1).toString();
            }
        }
        return "";
    }

    /* renamed from: a */
    private static SpannableString m28250a(Context context) {
        SpannableString spannableString = new SpannableString(context.getResources().getString(R.string.customer_global_middle_dot));
        int sp2px = (int) DisplayUtils.sp2px(context, 10.0f);
        int dip2px = DisplayUtils.dip2px(GlobalContext.getContext(), 0.0f);
        spannableString.setSpan(new AbsoluteSizeSpan(sp2px), 0, spannableString.length(), 33);
        spannableString.setSpan(new CustomerSideSpacingSpan(sp2px, dip2px), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private static void m28256a(SpannableStringBuilder spannableStringBuilder, BusinessInfoEntity businessInfoEntity) {
        SpannableString createStarRatingSpanString = createStarRatingSpanString(businessInfoEntity);
        if (!TextUtils.isEmpty(createStarRatingSpanString)) {
            spannableStringBuilder.append(createStarRatingSpanString);
        }
    }

    /* renamed from: a */
    private static void m28257a(SpannableStringBuilder spannableStringBuilder, BusinessInfoEntity businessInfoEntity, Context context) {
        if (checkBusinessStatusNormal(businessInfoEntity)) {
            String businessDeliveryTypeDesc = getBusinessDeliveryTypeDesc(context, businessInfoEntity.deliveryType);
            boolean b = m28264b(businessInfoEntity);
            if (b || m28259a(businessInfoEntity)) {
                spannableStringBuilder.append(f39668a);
                spannableStringBuilder.append(m28250a(context));
                spannableStringBuilder.append(f39668a);
            }
            SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_delivery));
            spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 33);
            spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, spannableString.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(f39668a);
            if (!m28259a(businessInfoEntity) && !b && !TextUtils.isEmpty(businessDeliveryTypeDesc)) {
                spannableStringBuilder.append(businessDeliveryTypeDesc);
                spannableStringBuilder.append(f39668a);
            }
            if (!TextUtils.isEmpty(businessInfoEntity.deliveryDesc)) {
                spannableStringBuilder.append(businessInfoEntity.deliveryDesc);
                spannableStringBuilder.append(f39668a);
            }
        }
    }

    /* renamed from: b */
    private static void m28263b(SpannableStringBuilder spannableStringBuilder, BusinessInfoEntity businessInfoEntity, Context context) {
        if (isBuyAgent(businessInfoEntity)) {
            SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_buy_by_rider));
            spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 33);
            spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, spannableString.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(f39668a);
            if (!TextUtils.isEmpty(businessInfoEntity.modeInfo.getModeTagDesc())) {
                spannableStringBuilder.append(businessInfoEntity.modeInfo.getModeTagDesc());
                spannableStringBuilder.append(f39668a);
            }
        }
    }

    /* renamed from: c */
    private static void m28266c(SpannableStringBuilder spannableStringBuilder, BusinessInfoEntity businessInfoEntity, Context context) {
        if (checkBusinessStatusNormal(businessInfoEntity) && businessInfoEntity.deliveryPriceAct >= 0) {
            spannableStringBuilder.append(m28250a(context));
            spannableStringBuilder.append(f39668a);
            if (businessInfoEntity.isDeliveryPriceAdjusted == 1) {
                SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_rise));
                spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 33);
                spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, spannableString.length(), 33);
                spannableStringBuilder.append(spannableString);
                spannableStringBuilder.append(f39668a);
                SpannableString spannableString2 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceOriDisplay, (long) businessInfoEntity.deliveryPriceOri, businessInfoEntity.currency, "shop"));
                spannableString2.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.LIGHT)), 0, spannableString2.length(), 33);
                spannableStringBuilder.append(f39668a);
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(f39668a);
                return;
            }
            if (businessInfoEntity.deliveryPriceAct >= 0) {
                SpannableString spannableString3 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceActDisplay, (long) businessInfoEntity.deliveryPriceAct, businessInfoEntity.currency, "shop"));
                spannableString3.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(hasDeliveryFeeAct(businessInfoEntity) ? IToolsService.FontType.NORMAL : IToolsService.FontType.LIGHT)), 0, spannableString3.length(), 33);
                if (hasDeliveryFeeAct(businessInfoEntity)) {
                    spannableString3.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString3.length(), 33);
                }
                spannableStringBuilder.append(spannableString3);
                spannableStringBuilder.append(f39668a);
            }
            if (hasDeliveryFeeAct(businessInfoEntity)) {
                SpannableString spannableString4 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceOriDisplay, (long) businessInfoEntity.deliveryPriceOri, businessInfoEntity.currency, "shop"));
                spannableString4.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_3_60_999999)), 0, spannableString4.length(), 33);
                spannableString4.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.LIGHT)), 0, spannableString4.length(), 33);
                spannableString4.setSpan(new StrikethroughSpan(), 0, spannableString4.length(), 33);
                spannableStringBuilder.append(spannableString4);
            }
        }
    }

    /* renamed from: b */
    private static boolean m28264b(BusinessInfoEntity businessInfoEntity) {
        return businessInfoEntity != null && businessInfoEntity.starRating != null && businessInfoEntity.starRating.display == BusinessStarRatingEntity.STAR_STATUS_SHOW && !TextUtils.isEmpty(businessInfoEntity.starRating.score);
    }

    public static String getBusinessCategoryTipString(BusinessCategoryRvModel businessCategoryRvModel) {
        return (businessCategoryRvModel == null || businessCategoryRvModel.businessTabTipRvModel == null || TextUtils.isEmpty(businessCategoryRvModel.businessTabTipRvModel.getTopContent())) ? "" : businessCategoryRvModel.businessTabTipRvModel.getTopContent();
    }
}
