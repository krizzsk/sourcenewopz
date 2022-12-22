package com.didi.soda.cart.omega;

import android.text.TextUtils;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.cart.manager.task.AddTrackModel;
import com.didi.soda.cart.manager.task.CartMergeModel;
import com.didi.soda.cart.model.CartGuideModel;
import com.didi.soda.cart.model.CartItemBaseModel;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/cart/omega/FloatingCartOmegaHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FloatingCartOmegaHelper.kt */
public final class FloatingCartOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ.\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J6\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J.\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0013J,\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(J\u001e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00062\u0006\u0010%\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0013J>\u0010-\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bJ\u0018\u00101\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u00102\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u00103\u001a\u000204J\u0016\u00106\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u00103\u001a\u000204J,\u00107\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u00108\u001a\u0004\u0018\u00010\b¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/cart/omega/FloatingCartOmegaHelper$Companion;", "", "()V", "cartInfoError", "", "errorType", "", "errorMsg", "", "clickCartItem", "fromPage", "cartId", "shopId", "itemId", "clickCheckout", "itemAction", "subItem", "Lcom/didi/soda/cart/model/CartItemBaseModel;", "action", "", "showFloatingCart", "itemCount", "subTotal", "cartInfoType", "trackAddEnd", "isError", "con", "duration", "", "lastDuration", "isRollback", "trackAddItemRefresh", "info", "successful", "trackAddTaskBegin", "api", "cartSession", "model", "Lcom/didi/soda/cart/manager/task/CartMergeModel;", "intervalList", "", "trackAddTaskEnd", "errorCode", "Lcom/didi/soda/cart/manager/task/AddTrackModel;", "isOver", "trackItemRealShow", "price", "discount", "activityType", "trackOneMoreToastSw", "trackTyingItemAdd", "cartTyingItemModel", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "trackTyingItemCK", "trackTyingItemRealShow", "trackTyingShow", "itemList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FloatingCartOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackAddItemRefresh(String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "shopId");
            Intrinsics.checkNotNullParameter(str3, "info");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_REFRESH_ADD_ITEM);
            if (str2 == null) {
                str2 = "";
            }
            create.addEventParam("cart_id", str2).addEventParam("shop_id", str).addEventParam(ParamConst.PARAM_TIME_LIST, str3).addEventParam(ParamConst.PARAM_REFRESH_TIME, Long.valueOf(System.currentTimeMillis())).addEventParam("is_suc", Integer.valueOf(z ? 1 : 0)).build().track();
        }

        public final void showFloatingCart(String str, String str2, String str3, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, "shopId");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_FLOATING_SW).addEventParam("from_page", str).addEventParam("cart_id", str2).addEventParam("shop_id", str3).addEventParam(ParamConst.PARAM_ITEM_COUNT, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_SUBTOTAL, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_CART_INFO_TYPE, Integer.valueOf(i3)).build().track();
        }

        public final void itemAction(String str, String str2, String str3, CartItemBaseModel cartItemBaseModel, boolean z) {
            Map<String, Object> guideParams;
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, "shopId");
            Intrinsics.checkNotNullParameter(cartItemBaseModel, "subItem");
            CartGuideModel cartGuideParams = CartGuideDataManager.Companion.getInstance().getCartGuideParams(str3, cartItemBaseModel.getItemId());
            Map linkedHashMap = new LinkedHashMap();
            if (!(cartGuideParams == null || (guideParams = cartGuideParams.getGuideParams()) == null)) {
                linkedHashMap.putAll(guideParams);
            }
            linkedHashMap.put("item_id", cartItemBaseModel.getItemId());
            linkedHashMap.put("amount", Integer.valueOf(cartItemBaseModel.getPrice()));
            linkedHashMap.put("discount", Integer.valueOf(cartItemBaseModel.getSpecialPrice()));
            linkedHashMap.put(ParamConst.PARAM_MDU_ID, cartItemBaseModel.getMduId());
            linkedHashMap.put(ParamConst.PARAM_ITEM_TYPE, Integer.valueOf(cartItemBaseModel.getMduType()));
            CharSequence headImg = cartItemBaseModel.getHeadImg();
            linkedHashMap.put(ParamConst.PARAM_HAS_IMAGE, Integer.valueOf(((headImg == null || headImg.length() == 0) ? 1 : 0) ^ 1));
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_FLOATING_ADD_ITEM_CK).addEventParam("from_page", str).addEventParam("cart_id", str2).addEventParam("shop_id", str3).addEventParam("item_id", cartItemBaseModel.getItemId()).addEventParam("item_name", cartItemBaseModel.getItemName()).addEventParam(ParamConst.PARAM_COPY_NUM, Integer.valueOf(cartItemBaseModel.getAmount())).addEventParam(ParamConst.PARAM_SUBITEM, GsonUtil.toJson(linkedHashMap)).addEventParam("price", Integer.valueOf(cartItemBaseModel.getPrice())).addEventParam("discount_price", Integer.valueOf(cartItemBaseModel.getSpecialPrice())).addEventParam("activity_type", Integer.valueOf(cartItemBaseModel.getActivityType())).addEventParam("button_type", Integer.valueOf(z ? 1 : 0)).build().track();
            if (cartItemBaseModel.getAmount() == 0) {
                CartGuideDataManager.Companion.getInstance().deleteItemParams(str3, cartItemBaseModel.getItemId());
            }
        }

        public final void clickCheckout(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, "shopId");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_FLOATING_CHECKOUT_CK).addEventParam("from_page", str).addEventParam("cart_id", str2).addEventParam("shop_id", str3).build().track();
        }

        public final void clickCartItem(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, "shopId");
            Intrinsics.checkNotNullParameter(str4, BlocksConst.ACTION_PARAMS_ITEM_ID);
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_FLOATING_ITEM_CK).addEventParam("from_page", str).addEventParam("cart_id", str2).addEventParam("shop_id", str3).addEventParam("item_id", str4).build().track();
        }

        public final void trackAddEnd(boolean z, boolean z2, long j, long j2, boolean z3) {
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_ADD_END).addEventParam(ParamConst.PARAM_IS_ERROR, Boolean.valueOf(z)).addEventParam(ParamConst.PARAM_IS_CON, Boolean.valueOf(z2)).addEventParam(ParamConst.PARAM_WHOLE_DURATION, Long.valueOf(j)).addEventParam(ParamConst.PARAM_LAT_END_DURATION, Long.valueOf(j2)).addEventParam(ParamConst.PARAM_ROLLBACK, Boolean.valueOf(z3)).build().track();
        }

        public final void trackAddTaskBegin(String str, String str2, CartMergeModel cartMergeModel, List<Long> list) {
            Intrinsics.checkNotNullParameter(str, "api");
            Intrinsics.checkNotNullParameter(str2, "cartSession");
            Intrinsics.checkNotNullParameter(cartMergeModel, "model");
            Intrinsics.checkNotNullParameter(list, "intervalList");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_ADD_TASK_BEGIN).addEventParam(ParamConst.PARAM_WAIT_TIME, Long.valueOf(cartMergeModel.getMergeWaitTime())).addEventParam("action_type", str).addEventParam(ParamConst.PARAM_ACTION_COUNT, Integer.valueOf(cartMergeModel.getRunMergeTimes())).addEventParam(ParamConst.PARAM_CART_SESSION_ID, str2).addEventParam(ParamConst.PARAM_INTERVAL, GsonUtil.toJson(list)).build().track();
        }

        public final void trackAddTaskEnd(int i, AddTrackModel addTrackModel, boolean z) {
            Intrinsics.checkNotNullParameter(addTrackModel, "model");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CART_ADD_TASK_END).addEventParam("error_code", Integer.valueOf(i)).addEventParam("action_type", addTrackModel.getApi()).addEventParam(ParamConst.PARAM_ACTION_COUNT, Integer.valueOf(addTrackModel.getMergeTimes())).addEventParam(ParamConst.PARAM_ACTION_AMOUNT_OVER, Boolean.valueOf(z)).addEventParam(ParamConst.PARAM_CART_SESSION_ID, addTrackModel.getSession()).build().track();
        }

        public final void cartInfoError(int i, String str) {
            ErrorTracker.Builder addErrorType = ErrorTracker.create(EventConst.Cart.TECH_SAILING_C_CART_INFO_API_ERROR).addModuleName(ErrorConst.ModuleName.CART).addErrorType(ApiErrorUtil.Companion.getErrorType(String.valueOf(i)));
            if (str == null) {
                str = "";
            }
            addErrorType.addErrorMsg(str).build().trackError();
        }

        public final void trackOneMoreToastSw(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "shopId");
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Business.SHOP_ONE_MORE_TOAST_SW).addEventParam("shop_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("error_msg", str2).build().track();
        }

        public final void trackItemRealShow(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, "shopId");
            Intrinsics.checkNotNullParameter(str4, BlocksConst.ACTION_PARAMS_ITEM_ID);
            Intrinsics.checkNotNullParameter(str5, "price");
            Intrinsics.checkNotNullParameter(str6, "discount");
            Intrinsics.checkNotNullParameter(str7, "activityType");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_ITEM_REAL_SHOW).addEventParam("cart_id", str2).addEventParam("from_page", str).addEventParam("shop_id", str3).addEventParam("item_id", str4).addEventParam("price", str5).addEventParam("discount_price", str6).addEventParam("activity_type", str7).build().track();
        }

        public final void trackTyingItemRealShow(String str, CartTyingItemModel cartTyingItemModel) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(cartTyingItemModel, "cartTyingItemModel");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_SAILING_C_X_CART_MERGE_REALEXPOSURE_SW);
            String cartId = cartTyingItemModel.getCartId();
            String str2 = "";
            if (cartId == null) {
                cartId = str2;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", cartId).addEventParam("shop_id", cartTyingItemModel.getShopId()).addEventParam("item_id", cartTyingItemModel.getItemId()).addEventParam("price", Integer.valueOf(cartTyingItemModel.getPrice())).addEventParam("discount_price", Integer.valueOf(cartTyingItemModel.getSpecialPrice())).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(cartTyingItemModel.getShopStatus())).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(cartTyingItemModel.getStatus())).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(cartTyingItemModel.getSoldStatus()));
            String limited_time = cartTyingItemModel.getLimited_time();
            if (limited_time != null) {
                str2 = limited_time;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, str2).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Integer.valueOf(TextUtils.isEmpty(cartTyingItemModel.getHeadImg()) ^ true ? 1 : 0));
            addEventParam2.addEventParam(ParamConst.PARAM_DELIVERY_FEE, cartTyingItemModel.getCurrency() + '_' + cartTyingItemModel.getDeliveryPriceOri() + '_' + cartTyingItemModel.getDeliveryPriceAct()).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Long.valueOf(cartTyingItemModel.getDeliveryTime())).addEventParam("distance", Integer.valueOf(((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).getBusinessDistance())).addEventParam(ParamConst.PARAM_MERGE_PAGE_FROM, str).addEventParam(ParamConst.PARAM_MERGE_ORDER_INDEX, Integer.valueOf(cartTyingItemModel.getPosition())).addEventParam("has_multi_content", Integer.valueOf(cartTyingItemModel.isMultiContent() ? 1 : 0)).build().track();
        }

        public final void trackTyingItemCK(String str, CartTyingItemModel cartTyingItemModel) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(cartTyingItemModel, "cartTyingItemModel");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_SAILING_C_X_CART_MERGE_ITEM_CK);
            String cartId = cartTyingItemModel.getCartId();
            String str2 = "";
            if (cartId == null) {
                cartId = str2;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", cartId).addEventParam("shop_id", cartTyingItemModel.getShopId()).addEventParam("item_id", cartTyingItemModel.getItemId()).addEventParam("price", Integer.valueOf(cartTyingItemModel.getPrice())).addEventParam("discount_price", Integer.valueOf(cartTyingItemModel.getSpecialPrice())).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(cartTyingItemModel.getShopStatus())).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(cartTyingItemModel.getStatus())).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(cartTyingItemModel.getSoldStatus()));
            String limited_time = cartTyingItemModel.getLimited_time();
            if (limited_time != null) {
                str2 = limited_time;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, str2).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Integer.valueOf(TextUtils.isEmpty(cartTyingItemModel.getHeadImg()) ^ true ? 1 : 0));
            addEventParam2.addEventParam(ParamConst.PARAM_DELIVERY_FEE, cartTyingItemModel.getCurrency() + '_' + cartTyingItemModel.getDeliveryPriceOri() + '_' + cartTyingItemModel.getDeliveryPriceAct()).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Long.valueOf(cartTyingItemModel.getDeliveryTime())).addEventParam("distance", Integer.valueOf(((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).getBusinessDistance())).addEventParam(ParamConst.PARAM_MERGE_PAGE_FROM, str).addEventParam(ParamConst.PARAM_MERGE_ORDER_INDEX, Integer.valueOf(cartTyingItemModel.getPosition())).addEventParam("has_multi_content", Integer.valueOf(cartTyingItemModel.isMultiContent() ? 1 : 0)).build().track();
        }

        public final void trackTyingItemAdd(String str, CartTyingItemModel cartTyingItemModel) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            Intrinsics.checkNotNullParameter(cartTyingItemModel, "cartTyingItemModel");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_SAILING_C_X_CART_MERGE_ITEM2CART_CK);
            String cartId = cartTyingItemModel.getCartId();
            String str2 = "";
            if (cartId == null) {
                cartId = str2;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", cartId).addEventParam("shop_id", cartTyingItemModel.getShopId()).addEventParam("item_id", cartTyingItemModel.getItemId()).addEventParam("price", Integer.valueOf(cartTyingItemModel.getPrice())).addEventParam("discount_price", Integer.valueOf(cartTyingItemModel.getSpecialPrice())).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(cartTyingItemModel.getShopStatus())).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(cartTyingItemModel.getStatus())).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(cartTyingItemModel.getSoldStatus()));
            String limited_time = cartTyingItemModel.getLimited_time();
            if (limited_time == null) {
                limited_time = str2;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, limited_time).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Integer.valueOf(TextUtils.isEmpty(cartTyingItemModel.getHeadImg()) ^ true ? 1 : 0));
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_DELIVERY_FEE, cartTyingItemModel.getCurrency() + '_' + cartTyingItemModel.getDeliveryPriceOri() + '_' + cartTyingItemModel.getDeliveryPriceAct()).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Long.valueOf(cartTyingItemModel.getDeliveryTime())).addEventParam("distance", Integer.valueOf(((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).getBusinessDistance())).addEventParam(ParamConst.PARAM_MERGE_PAGE_FROM, str).addEventParam(ParamConst.PARAM_MERGE_ORDER_INDEX, Integer.valueOf(cartTyingItemModel.getPosition())).addEventParam("has_multi_content", Integer.valueOf(cartTyingItemModel.isMultiContent() ? 1 : 0));
            String cartId2 = cartTyingItemModel.getCartId();
            if (cartId2 != null) {
                str2 = cartId2;
            }
            addEventParam3.addEventParam("cart_id", str2).addEventParam(ParamConst.PARAM_COPY_NUM, 1).build().track();
        }

        public final void trackTyingShow(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "fromPage");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_SAILING_C_X_CART_MERGE_ORDER_SW);
            create.addEventParam(ParamConst.PARAM_MERGE_PAGE_FROM, str);
            if (str2 != null) {
                create.addEventParam("cart_id", str2);
            }
            if (str3 != null) {
                create.addEventParam("shop_id", str3);
            }
            if (str4 != null) {
                create.addEventParam("item_list", str4);
            }
            create.build().track();
        }
    }
}
