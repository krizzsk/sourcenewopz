package com.didi.soda.goods.helper;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.lang.ref.WeakReference;

public class GoodsOmegaHelper {

    /* renamed from: a */
    private static final String f42413a = "GoodsOmegaHelper";

    /* renamed from: b */
    private WeakReference<ScopeContext> f42414b;

    /* renamed from: c */
    private String f42415c;

    /* renamed from: d */
    private int f42416d;

    /* renamed from: e */
    private String f42417e;

    /* renamed from: f */
    private int f42418f;

    /* renamed from: g */
    private int f42419g;

    /* renamed from: h */
    private String f42420h;

    /* renamed from: i */
    private int f42421i;

    /* renamed from: j */
    private String f42422j;

    /* renamed from: k */
    private String f42423k;

    /* renamed from: l */
    private String f42424l;

    public GoodsOmegaHelper(ScopeContext scopeContext, String str, int i, String str2, int i2, int i3, String str3, int i4) {
        this.f42414b = new WeakReference<>(scopeContext);
        this.f42415c = str;
        this.f42416d = i;
        this.f42417e = str2;
        this.f42418f = i2;
        this.f42419g = i3;
        this.f42420h = str3;
        this.f42421i = i4;
    }

    public GoodsOmegaHelper(ScopeContext scopeContext, String str, int i, String str2, int i2, int i3, String str3, int i4, String str4, String str5, String str6) {
        this.f42414b = new WeakReference<>(scopeContext);
        this.f42415c = str;
        this.f42416d = i;
        this.f42417e = str2;
        this.f42418f = i2;
        this.f42419g = i3;
        this.f42420h = str3;
        this.f42421i = i4;
        this.f42422j = str4;
        this.f42423k = str5;
        this.f42424l = str6;
    }

    public void onPurchaseExit(int i) {
        m29902b(EventConst.Goods.ITEM_PURCHASE_RETURN_CK).addEventParam("has_multi_content", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42419g)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42420h).addEventParam("from", Integer.valueOf(this.f42421i)).build().track();
    }

    public void onPurchaseItem2CartClick(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, String str8, String str9, String str10) {
        OmegaTracker.Builder addEventParam = m29901a(EventConst.Goods.ITEM_PURCHASE_ADD_CART_CK).addEventParam(ParamConst.PARAM_SELECTED_SUBITEMS, str).addEventParam(ParamConst.PARAM_COPY_NUM, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_CART_INFO, str2).addEventParam("has_multi_content", Integer.valueOf(i2)).addEventParam("cart_id", str3).addEventParam("price", str6).addEventParam("discount_price", str7).addEventParam("activity_type", str8).addEventParam(ParamConst.PARAM_IS_MULTI_LEVEL, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42419g)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42420h).addEventParam("from", Integer.valueOf(this.f42421i)).addEventParam("is_item_merge", str10);
        if (str9 == null) {
            str9 = "";
        }
        addEventParam.addEventParam(ParamConst.PARAM_TAB_ID, str9).enableGuideParam().build().track();
    }

    public void onPurchaseShow(int i, int i2, int i3) {
        m29901a(EventConst.Goods.ITEM_PURCHASE_COMMON_SW).addEventParam(ParamConst.PARAM_REQUIRED_SELECTIONS, Integer.valueOf(i)).addEventParam("has_multi_content", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_MULTI_LEVEL, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42419g)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42420h).addEventParam("from", Integer.valueOf(this.f42421i)).enableGuideParam().build().track();
    }

    public void onToastShow(String str, String str2) {
        m29901a(EventConst.Goods.ITEM_PURCHASE_TOAST_SW).addEventParam("activity_id", str).addEventParam("error_msg", str2).enableGuideParam().build().track();
    }

    public void trackCheckOut(int i) {
        m29901a(EventConst.Goods.ITEM_PURCHASE_CHECK_OUT).addEventParam("item_id", this.f42417e).addEventParam("has_multi_content", Integer.valueOf(i)).addEventParam("shop_id", this.f42415c).addEventParam(ParamConst.PARAM_COPY_NUM, 1).addEventParam("price", this.f42422j).addEventParam("discount_price", this.f42423k).addEventParam("activity_type", this.f42424l).build().track();
    }

    public void onSubItemClick(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4) {
        m29901a(EventConst.Goods.ITEM_PURCHASE_CHOOSE_CK).addEventParam(ParamConst.PARAM_QUESTION, str).addEventParam(ParamConst.PARAM_QUESTION_TYPE, str2).addEventParam(ParamConst.PARAM_VALID_ANSWER, str3).addEventParam(ParamConst.PARAM_UNVALID_ANSWER, str4).addEventParam(ParamConst.PARAM_SELECTED_ANSWER, str5).addEventParam(ParamConst.PARAM_CHOOSE_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_OPTION_TYPE, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_CONTENT_SELECT_TYPE, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_IS_MULTI_LEVEL, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42419g)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42420h).addEventParam("from", Integer.valueOf(this.f42421i)).build().track();
    }

    public void onMultiLevelShow(int i, String str) {
        m29902b(EventConst.Goods.ITEM_MULTI_LEVEL_COMMON_SW).addEventParam("level", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_PARENT_SUB_ITEM_ID, str).addEventParam("from", Integer.valueOf(this.f42421i)).build().track();
    }

    public void onMultiLevelConfirmClick(int i, String str) {
        m29902b(EventConst.Goods.ITEM_MULTI_LEVEL_CONFIRM_CK).addEventParam("level", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_PARENT_SUB_ITEM_ID, str).addEventParam("from", Integer.valueOf(this.f42421i)).build().track();
    }

    /* renamed from: a */
    private OmegaTracker.Builder m29901a(String str) {
        return OmegaTracker.Builder.create(str, (ScopeContext) this.f42414b.get()).addEventParam("shop_id", this.f42415c).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42416d)).addEventParam("item_id", this.f42417e).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(this.f42418f));
    }

    /* renamed from: b */
    private OmegaTracker.Builder m29902b(String str) {
        return OmegaTracker.Builder.create(str).addEventParam("shop_id", this.f42415c).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42416d)).addEventParam("item_id", this.f42417e).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(this.f42418f));
    }

    public void onOrderDialogConfirmCk() {
        OmegaTracker.Builder.create(EventConst.Alcohol.ORDER_DIALOG_CONFIRM_CK).addEventParam("shop_id", this.f42415c).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42416d)).addEventParam("item_id", this.f42417e).build().track();
    }

    public void onOrderDialogCancelCk() {
        OmegaTracker.Builder.create(EventConst.Alcohol.ORDER_DIALOG_CANCEL_CK).addEventParam("shop_id", this.f42415c).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42416d)).addEventParam("item_id", this.f42417e).build().track();
    }

    public void onOrderDialogSw() {
        OmegaTracker.Builder.create(EventConst.Alcohol.ORDER_DIALOG_SW).addEventParam("shop_id", this.f42415c).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42416d)).addEventParam("item_id", this.f42417e).build().track();
    }
}
