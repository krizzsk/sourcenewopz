package com.didi.soda.goodsV2.helper;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.lang.ref.WeakReference;

public class GoodsOmegaHelper {

    /* renamed from: a */
    private static final String f42503a = "GoodsOmegaHelper";

    /* renamed from: b */
    private int f42504b;

    /* renamed from: c */
    private String f42505c;

    /* renamed from: d */
    private int f42506d;

    /* renamed from: e */
    private boolean f42507e;

    /* renamed from: f */
    private WeakReference<ScopeContext> f42508f;

    /* renamed from: g */
    private String f42509g;

    /* renamed from: h */
    private int f42510h;

    /* renamed from: i */
    private String f42511i;

    /* renamed from: j */
    private int f42512j;

    /* renamed from: k */
    private int f42513k;

    /* renamed from: l */
    private String f42514l;

    /* renamed from: m */
    private int f42515m;

    /* renamed from: n */
    private String f42516n;

    /* renamed from: o */
    private String f42517o;

    /* renamed from: p */
    private String f42518p;

    public GoodsOmegaHelper(ScopeContext scopeContext, String str, int i, String str2, int i2, int i3, String str3, int i4) {
        this.f42508f = new WeakReference<>(scopeContext);
        this.f42509g = str;
        this.f42510h = i;
        this.f42511i = str2;
        this.f42512j = i2;
        this.f42513k = i3;
        this.f42514l = str3;
        this.f42515m = i4;
    }

    public GoodsOmegaHelper(ScopeContext scopeContext, String str, int i, String str2, int i2, int i3, String str3, int i4, String str4, String str5, String str6, int i5, boolean z, String str7, int i6) {
        ScopeContext scopeContext2 = scopeContext;
        this.f42508f = new WeakReference<>(scopeContext);
        this.f42509g = str;
        this.f42510h = i;
        this.f42511i = str2;
        this.f42512j = i2;
        this.f42513k = i3;
        this.f42514l = str3;
        this.f42515m = i4;
        this.f42516n = str4;
        this.f42517o = str5;
        this.f42518p = str6;
        this.f42505c = str7;
        this.f42506d = i5;
        this.f42507e = z;
        this.f42504b = i6;
    }

    public void onPurchaseExit(int i, int i2, int i3, int i4) {
        OmegaTracker.Builder addEventParam = m29977b(EventConst.Goods.ITEM_PURCHASE_RETURN_CK).addEventParam("has_multi_content", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42513k)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42514l).addEventParam("from", Integer.valueOf(this.f42515m));
        String str = this.f42505c;
        if (str == null) {
            str = "";
        }
        addEventParam.addEventParam(ParamConst.PARAM_TAB_ID, str).addEventParam(ParamConst.PARAM_TAB_LOCATION, Integer.valueOf(this.f42506d)).addEventParam("price", this.f42516n).addEventParam("discount_price", this.f42517o).addEventParam("activity_type", this.f42518p).addEventParam(ParamConst.ITEM_COMBO_TYPE, Integer.valueOf(this.f42504b)).addEventParam(ParamConst.PARAM_REQUIRED_SELECTIONS, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_OPTIONAL_SELECTIONS, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_MUTIPLY_LEVEL_CNT, Integer.valueOf(i4)).build().track();
    }

    public void onPurchaseItem2CartClick(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, String str8, int i4, int i5, int i6, String str9, int i7) {
        String str10 = str;
        String str11 = str2;
        String str12 = str3;
        String str13 = str6;
        String str14 = str7;
        String str15 = str8;
        OmegaTracker.Builder addEventParam = m29976a(EventConst.Goods.ITEM_PURCHASE_ADD_CART_CK).addEventParam(ParamConst.PARAM_SELECTED_SUBITEMS, str).addEventParam(ParamConst.PARAM_COPY_NUM, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_CART_INFO, str2).addEventParam("has_multi_content", Integer.valueOf(i2)).addEventParam("cart_id", str3).addEventParam("price", str6).addEventParam("discount_price", str7).addEventParam("activity_type", str8).addEventParam(ParamConst.PARAM_IS_MULTI_LEVEL, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42513k)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42514l).addEventParam("from", Integer.valueOf(this.f42515m));
        String str16 = this.f42505c;
        if (str16 == null) {
            str16 = "";
        }
        addEventParam.addEventParam(ParamConst.PARAM_TAB_ID, str16).addEventParam(ParamConst.PARAM_TAB_LOCATION, Integer.valueOf(this.f42506d)).addEventParam(ParamConst.ITEM_COMBO_TYPE, Integer.valueOf(this.f42504b)).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Integer.valueOf(this.f42507e ? 1 : 0)).addEventParam(ParamConst.PARAM_REQUIRED_SELECTIONS, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_OPTIONAL_SELECTIONS, Integer.valueOf(i5)).addEventParam(ParamConst.PARAM_MUTIPLY_LEVEL_CNT, Integer.valueOf(i6)).addEventParam("is_item_merge", str9).addEventParam(ParamConst.PARAM_ITEM_LOCATION, Integer.valueOf(i7)).enableGuideParam().build().track();
    }

    public void onPurchaseShow(int i, int i2, int i3, int i4, int i5) {
        OmegaTracker.Builder addEventParam = m29976a(EventConst.Goods.ITEM_PURCHASE_COMMON_SW).addEventParam(ParamConst.PARAM_REQUIRED_SELECTIONS, Integer.valueOf(i)).addEventParam("has_multi_content", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_MULTI_LEVEL, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42513k)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42514l).addEventParam("from", Integer.valueOf(this.f42515m));
        String str = this.f42505c;
        if (str == null) {
            str = "";
        }
        addEventParam.addEventParam(ParamConst.PARAM_TAB_ID, str).addEventParam(ParamConst.PARAM_TAB_LOCATION, Integer.valueOf(this.f42506d)).addEventParam("price", this.f42516n).addEventParam("discount_price", this.f42517o).addEventParam("activity_type", this.f42518p).addEventParam(ParamConst.ITEM_COMBO_TYPE, Integer.valueOf(this.f42504b)).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Integer.valueOf(this.f42507e ? 1 : 0)).addEventParam(ParamConst.PARAM_OPTIONAL_SELECTIONS, Integer.valueOf(i5)).addEventParam(ParamConst.PARAM_MUTIPLY_LEVEL_CNT, Integer.valueOf(i4)).enableGuideParam().build().track();
    }

    public void onToastShow(String str, String str2) {
        m29976a(EventConst.Goods.ITEM_PURCHASE_TOAST_SW).addEventParam("activity_id", str).addEventParam("error_msg", str2).enableGuideParam().build().track();
    }

    public void trackCheckOut(int i) {
        m29976a(EventConst.Goods.ITEM_PURCHASE_CHECK_OUT).addEventParam("item_id", this.f42511i).addEventParam("has_multi_content", Integer.valueOf(i)).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_COPY_NUM, 1).addEventParam("price", this.f42516n).addEventParam("discount_price", this.f42517o).addEventParam("activity_type", this.f42518p).build().track();
    }

    public void trackEntreMultiPage(String str) {
        OmegaTracker.Builder.create(EventConst.Goods.ITEM_MULTI_LEVEL_ENTER_CK).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42510h)).addEventParam("item_id", str).addEventParam(ParamConst.PARAM_ITEM_PARENT_SUB_ITEM_ID, this.f42511i).build().track();
    }

    public void onSubItemClick(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5) {
        OmegaTracker.Builder addEventParam = m29976a(EventConst.Goods.ITEM_PURCHASE_CHOOSE_CK).addEventParam(ParamConst.PARAM_QUESTION, str).addEventParam(ParamConst.PARAM_QUESTION_TYPE, str2).addEventParam(ParamConst.PARAM_VALID_ANSWER, str3).addEventParam(ParamConst.PARAM_UNVALID_ANSWER, str4).addEventParam(ParamConst.PARAM_SELECTED_ANSWER, str5).addEventParam(ParamConst.PARAM_CHOOSE_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_OPTION_TYPE, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_CONTENT_SELECT_TYPE, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_IS_MULTI_LEVEL, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(this.f42513k)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, this.f42514l).addEventParam("from", Integer.valueOf(this.f42515m));
        String str6 = this.f42505c;
        if (str6 == null) {
            str6 = "";
        }
        addEventParam.addEventParam(ParamConst.PARAM_TAB_ID, str6).addEventParam(ParamConst.PARAM_TAB_LOCATION, Integer.valueOf(this.f42506d)).addEventParam("price", this.f42516n).addEventParam("discount_price", this.f42517o).addEventParam("activity_type", this.f42518p).addEventParam(ParamConst.ITEM_COMBO_TYPE, Integer.valueOf(this.f42504b)).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Integer.valueOf(this.f42507e ? 1 : 0)).addEventParam(ParamConst.PARAM_MUTIPLY_LEVEL_CNT, Integer.valueOf(i5)).build().track();
    }

    public void onMultiLevelShow(int i, String str) {
        m29977b(EventConst.Goods.ITEM_MULTI_LEVEL_COMMON_SW).addEventParam("level", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_PARENT_SUB_ITEM_ID, str).addEventParam("from", Integer.valueOf(this.f42515m)).build().track();
    }

    public void onMultiLevelConfirmClick(int i, String str) {
        m29977b(EventConst.Goods.ITEM_MULTI_LEVEL_CONFIRM_CK).addEventParam("level", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_PARENT_SUB_ITEM_ID, str).addEventParam("from", Integer.valueOf(this.f42515m)).build().track();
    }

    /* renamed from: a */
    private OmegaTracker.Builder m29976a(String str) {
        return OmegaTracker.Builder.create(str, (ScopeContext) this.f42508f.get()).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42510h)).addEventParam("item_id", this.f42511i).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(this.f42512j));
    }

    /* renamed from: b */
    private OmegaTracker.Builder m29977b(String str) {
        return OmegaTracker.Builder.create(str).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42510h)).addEventParam("item_id", this.f42511i).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(this.f42512j));
    }

    public void onOrderDialogConfirmCk() {
        OmegaTracker.Builder.create(EventConst.Alcohol.ORDER_DIALOG_CONFIRM_CK).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42510h)).addEventParam("item_id", this.f42511i).build().track();
    }

    public void onOrderDialogCancelCk() {
        OmegaTracker.Builder.create(EventConst.Alcohol.ORDER_DIALOG_CANCEL_CK).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42510h)).addEventParam("item_id", this.f42511i).build().track();
    }

    public void onOrderDialogSw() {
        OmegaTracker.Builder.create(EventConst.Alcohol.ORDER_DIALOG_SW).addEventParam("shop_id", this.f42509g).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f42510h)).addEventParam("item_id", this.f42511i).build().track();
    }
}
