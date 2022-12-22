package com.didi.soda.home.topgun.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.login.LoginListener;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.home.topgun.binder.model.HomeEfoRvModel;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0007J@\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J4\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J:\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/manager/HomeEfoJumpHelper;", "", "()V", "goToBillPage", "", "shopId", "", "nodeList", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "Lkotlin/collections/ArrayList;", "from", "", "fromPage", "source", "actInfo", "goToEfoPage", "homeEfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeEfoRvModel;", "goToSKUPage", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "itemId", "handleEfoItemBuyClicked", "itemRvModel", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "loginListener", "Lcom/didi/soda/customer/foundation/login/LoginListener;", "fromType", "handleEfoItemClicked", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeEfoJumpHelper.kt */
public final class HomeEfoJumpHelper {
    public static final HomeEfoJumpHelper INSTANCE = new HomeEfoJumpHelper();

    private HomeEfoJumpHelper() {
    }

    @JvmStatic
    public static final void goToEfoPage(HomeEfoRvModel homeEfoRvModel, int i) {
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "homeEfoRvModel");
        String str = 1 == i ? homeEfoRvModel.mUrl : homeEfoRvModel.mMoreUrl;
        if (str != null) {
            SchemeHelper.dispatchMsg(str);
        }
    }

    @JvmStatic
    public static final void handleEfoItemClicked(ScopeContext scopeContext, int i, String str, String str2, LoginListener loginListener) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        if (!LoginUtil.isLogin()) {
            LoginUtil.updateLoginPopToRootStatus(false);
            LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 7 == i ? 22 : 23, loginListener);
            return;
        }
        goToSKUPage$default(scopeContext, str, str2, i, (String) null, 0, 48, (Object) null);
    }

    @JvmStatic
    public static final void handleEfoItemBuyClicked(ScopeContext scopeContext, int i, int i2, BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "itemRvModel");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ACT_INFO);
        if (businessGoodsItemRvModel.mHasWine == 1 || businessGoodsItemRvModel.mMaxLevel > 1) {
            goToSKUPage(scopeContext, businessGoodsItemRvModel.mBusinessId, businessGoodsItemRvModel.mGoodsId, i, str2, i2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (businessGoodsItemRvModel.mNode != null) {
            businessGoodsItemRvModel.mNode.amount = 1;
            arrayList.add(businessGoodsItemRvModel.mNode);
        }
        goToBillPage(businessGoodsItemRvModel.mBusinessId, arrayList, i, str, i2, str2);
    }

    @JvmStatic
    public static final void handleEfoItemBuyClicked(ScopeContext scopeContext, int i, BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, LoginListener loginListener) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "itemRvModel");
        if (!LoginUtil.isLogin()) {
            LoginUtil.updateLoginPopToRootStatus(false);
            LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 7 == i ? 22 : 23, loginListener);
        } else if (businessGoodsItemRvModel.mHasWine == 1 || businessGoodsItemRvModel.mMaxLevel > 1) {
            goToSKUPage$default(scopeContext, businessGoodsItemRvModel.mBusinessId, businessGoodsItemRvModel.mGoodsId, i, (String) null, 0, 48, (Object) null);
        } else {
            ArrayList arrayList = new ArrayList();
            if (businessGoodsItemRvModel.mNode != null) {
                businessGoodsItemRvModel.mNode.amount = 1;
                arrayList.add(businessGoodsItemRvModel.mNode);
            }
            goToBillPage$default(businessGoodsItemRvModel.mBusinessId, arrayList, i, str, 1, (String) null, 32, (Object) null);
        }
    }

    public static /* synthetic */ void goToSKUPage$default(ScopeContext scopeContext, String str, String str2, int i, String str3, int i2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str3 = "";
        }
        goToSKUPage(scopeContext, str, str2, i, str3, (i3 & 32) != 0 ? 1 : i2);
    }

    @JvmStatic
    public static final void goToSKUPage(ScopeContext scopeContext, String str, String str2, int i, String str3, int i2) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(str3, BlocksConst.ACTION_PARAMS_ACT_INFO);
        Request.Builder fromPage = DiRouter.request().path(((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle ? RoutePath.GOODS_PURCHASE_V2 : RoutePath.GOODS_PURCHASE).setFromPage(scopeContext);
        if (str == null) {
            str = "";
        }
        Request.Builder putString = fromPage.putString(Const.PageParams.SHOP_ID, str);
        if (str2 == null) {
            str2 = "";
        }
        putString.putString(Const.PageParams.ITEM_ID, str2).putString(Const.PageParams.ACT_INFO, str3).putInt("from", i).putInt("source", i2).open();
    }

    public static /* synthetic */ void goToBillPage$default(String str, ArrayList arrayList, int i, String str2, int i2, String str3, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            str3 = "";
        }
        goToBillPage(str, arrayList, i, str2, i2, str3);
    }

    @JvmStatic
    public static final void goToBillPage(String str, ArrayList<ItemNodeEntity> arrayList, int i, String str2, int i2, String str3) {
        Intrinsics.checkNotNullParameter(arrayList, "nodeList");
        Intrinsics.checkNotNullParameter(str3, BlocksConst.ACTION_PARAMS_ACT_INFO);
        Request.Builder path = DiRouter.request().path(RoutePath.BILL_PAGE);
        if (str == null) {
            str = "";
        }
        Request.Builder putInt = path.putString(Const.PageParams.SHOP_ID, str).putInt("source", i2).putString(Const.PageParams.ACT_INFO, str3).putInt("from", i);
        if (str2 == null) {
            str2 = "";
        }
        putInt.putString("from_page", str2).putInt(Const.PageParams.WINE_CONFIRM, 0).putSerializable(Const.PageParams.NODE_LIST, arrayList).open();
    }
}
