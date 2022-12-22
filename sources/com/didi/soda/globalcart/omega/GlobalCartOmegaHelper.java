package com.didi.soda.globalcart.omega;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillCartItemsInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillSection;
import com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0004j\b\u0012\u0004\u0012\u00020\u0014`\u0006H\u0002J \u0010\u0015\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0004j\b\u0012\u0004\u0012\u00020\u0014`\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J$\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010%\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0004j\b\u0012\u0004\u0012\u00020\u0014`\u0006R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068BX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR+\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/globalcart/omega/GlobalCartOmegaHelper;", "", "()V", "exposureShopList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getExposureShopList", "()Ljava/util/ArrayList;", "exposureShopList$delegate", "Lkotlin/Lazy;", "noOperateShopList", "getNoOperateShopList", "noOperateShopList$delegate", "openShopList", "getOpenShopList", "openShopList$delegate", "checkWithMutexRule", "", "billList", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "setExposureShopListInfo", "trackBackCk", "fromPage", "trackGlobalCartGlobalMutexRulerSW", "shopId", "cartId", "itemId", "trackGlobalCartItemCheckoutCk", "index", "", "trackGlobalCartListError", "eventName", "errorType", "errorMsg", "trackGlobalCartShopCk", "shopStatus", "trackGlobalCartSw", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartOmegaHelper.kt */
public final class GlobalCartOmegaHelper {

    /* renamed from: a */
    private final Lazy f42299a = LazyKt.lazy(GlobalCartOmegaHelper$exposureShopList$2.INSTANCE);

    /* renamed from: b */
    private final Lazy f42300b = LazyKt.lazy(GlobalCartOmegaHelper$openShopList$2.INSTANCE);

    /* renamed from: c */
    private final Lazy f42301c = LazyKt.lazy(GlobalCartOmegaHelper$noOperateShopList$2.INSTANCE);

    /* renamed from: a */
    private final ArrayList<String> m29802a() {
        return (ArrayList) this.f42299a.getValue();
    }

    /* renamed from: b */
    private final ArrayList<String> m29804b() {
        return (ArrayList) this.f42300b.getValue();
    }

    /* renamed from: c */
    private final ArrayList<String> m29806c() {
        return (ArrayList) this.f42301c.getValue();
    }

    public final void trackGlobalCartSw(ArrayList<BillInfoEntity> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "billList");
        m29803a(arrayList);
        m29805b(arrayList);
        OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_GLOBAL_SW).addEventParam(ParamConst.PARAM_EXPOSURE_SHOP_LIST, m29802a().toString()).addEventParam(ParamConst.PARAM_OPEN_SHOP_LIST, m29804b().toString()).addEventParam(ParamConst.PARAM_NO_OPERATE_SHOP_LIST, m29806c().toString()).build().track();
    }

    /* renamed from: a */
    private final void m29803a(ArrayList<BillInfoEntity> arrayList) {
        Iterator<BillInfoEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            ShopInfo shopInfo = it.next().getShopInfo();
            if (shopInfo != null) {
                ArrayList<String> a = m29802a();
                String shopId = shopInfo.getShopId();
                String str = "";
                if (shopId == null) {
                    shopId = str;
                }
                a.add(shopId);
                if (shopInfo.getCShopStatus() == 1) {
                    ArrayList<String> b = m29804b();
                    String shopId2 = shopInfo.getShopId();
                    if (shopId2 != null) {
                        str = shopId2;
                    }
                    b.add(str);
                } else {
                    ArrayList<String> c = m29806c();
                    String shopId3 = shopInfo.getShopId();
                    if (shopId3 != null) {
                        str = shopId3;
                    }
                    c.add(str);
                }
            }
        }
    }

    /* renamed from: b */
    private final void m29805b(ArrayList<BillInfoEntity> arrayList) {
        List<BillSection> sections;
        ArrayList<BillComponentEntity> components;
        BillComponentDataEntity data;
        BillCartItemsInfo itemsInfo;
        ArrayList<CartItemEntity> items;
        String str;
        Object obj;
        String str2;
        ShopInfo shopInfo;
        boolean z;
        GlobalCartOmegaHelper globalCartOmegaHelper = this;
        for (BillInfoEntity billInfoEntity : arrayList) {
            if (!(billInfoEntity == null || (sections = billInfoEntity.getSections()) == null)) {
                for (BillSection billSection : sections) {
                    if (!(billSection == null || (components = billSection.getComponents()) == null)) {
                        for (BillComponentEntity billComponentEntity : components) {
                            if (!(billComponentEntity == null || (data = billComponentEntity.getData()) == null || (itemsInfo = data.getItemsInfo()) == null || (items = itemsInfo.getItems()) == null)) {
                                Iterator it = items.iterator();
                                while (true) {
                                    str = null;
                                    if (!it.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it.next();
                                    if (((CartItemEntity) obj).getActRules() != null) {
                                        z = true;
                                        continue;
                                    } else {
                                        z = false;
                                        continue;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                                CartItemEntity cartItemEntity = (CartItemEntity) obj;
                                if (cartItemEntity != null) {
                                    if (billInfoEntity == null || (shopInfo = billInfoEntity.getShopInfo()) == null) {
                                        str2 = null;
                                    } else {
                                        str2 = shopInfo.getShopId();
                                    }
                                    if (billInfoEntity != null) {
                                        str = billInfoEntity.getCartId();
                                    }
                                    globalCartOmegaHelper.trackGlobalCartGlobalMutexRulerSW(str2, str, cartItemEntity.getItemId());
                                    return;
                                }
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
    }

    public final void trackGlobalCartShopCk(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_GLOBAL_SHOP_CK).addEventParam("shop_id", str).addEventParam("cart_id", str2).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(i)).addEventParam("index", Integer.valueOf(i2)).build().track();
    }

    public final void trackGlobalCartItemCheckoutCk(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_GLOBAL_CHECKOUT_CK).addEventParam("shop_id", str).addEventParam("cart_id", str2).addEventParam("index", Integer.valueOf(i)).build().track();
    }

    public final void trackGlobalCartListError(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "errorType");
        Intrinsics.checkNotNullParameter(str3, "errorMsg");
        ErrorTracker.create(str).addModuleName(ErrorConst.ModuleName.CART).addErrorType(str2).addErrorMsg(str3).build().trackError();
    }

    public final void trackBackCk(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
        if (str == null) {
            str = "";
        }
        create.addEventParam("from", str).build().track();
    }

    public final void trackGlobalCartGlobalMutexRulerSW(String str, String str2, String str3) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.GlobalCart.SAILING_C_X_CART_GLOBAL_MUTEX_RULER_SW);
        if (str == null) {
            str = "";
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", str);
        if (str2 == null) {
            str2 = "";
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("cart_id", str2);
        if (str3 == null) {
            str3 = "";
        }
        addEventParam2.addEventParam("item_id", str3).build().track();
    }
}
