package com.didi.soda.router;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.address.edit.EditAddressInfoPage;
import com.didi.soda.address.page.SelectAddressPage;
import com.didi.soda.address.page.SelectedAddressListPage;
import com.didi.soda.bill.page.BillTipPage;
import com.didi.soda.bill.page.BillTipsFeeEditPage;
import com.didi.soda.bill.page.BusinessRulePage;
import com.didi.soda.bill.page.CartInfoConfirmPage;
import com.didi.soda.bill.page.CustomerBillPage;
import com.didi.soda.bill.page.EditDeliveryMethodPage;
import com.didi.soda.bill.page.EditRemarkPage;
import com.didi.soda.bill.page.MutualExclusionRulePage;
import com.didi.soda.bill.page.OutOfStockPage;
import com.didi.soda.bill.page.RefundRulePage;
import com.didi.soda.business.page.BusinessAddressPage;
import com.didi.soda.business.page.BusinessCategoryMenuPage;
import com.didi.soda.business.page.BusinessDetailPage;
import com.didi.soda.business.page.BusinessHomePage;
import com.didi.soda.business.page.BusinessImagePage;
import com.didi.soda.business.page.BusinessSearchPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.flutter.CustomerFlutterPage;
import com.didi.soda.customer.flutter.CustomerFlutterTransferPage;
import com.didi.soda.customer.p165h5.CustomerLandingWebPage;
import com.didi.soda.customer.p165h5.CustomerPhotoTransferPage;
import com.didi.soda.customer.p165h5.CustomerTransparentWebPage;
import com.didi.soda.customer.p165h5.CustomerVerticalWebPage;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import com.didi.soda.globalcart.page.GlobalCartPage;
import com.didi.soda.goods.page.GoodsMultiLevelPage;
import com.didi.soda.goods.page.GoodsPurchasePage;
import com.didi.soda.home.efo.detail.DiscountDetailPage;
import com.didi.soda.home.page.AllCategoryPage;
import com.didi.soda.home.page.CustomerMainPage;
import com.didi.soda.home.page.FilterPage;
import com.didi.soda.home.page.HomeCityListPage;
import com.didi.soda.home.page.HomeTopicPage;
import com.didi.soda.home.page.PolicyUpdatePage;
import com.didi.soda.home.page.ShopCategoryLandingPage;
import com.didi.soda.home.page.SubscribePhonePage;
import com.didi.soda.home.page.TopicActivityPage;
import com.didi.soda.order.flutterpage.OrderPage;
import com.didi.soda.order.page.EditTipsPage;
import com.didi.soda.order.page.debtpay.DebtOrderPayPage;
import com.didi.soda.order.page.evaluate.OrderEvaluatePage;
import com.didi.soda.order.page.evaluate.OrderEvaluateSuccessPage;
import com.didi.soda.order.page.evaluationdetail.OrderEvaluateDetailPage;
import com.didi.soda.order.page.preview.EvaluatePreviewImagePage;
import com.didi.soda.order.page.receipt.SendReceiptPage;
import com.didi.soda.order.page.refund.RefundDetailPage;
import com.didi.soda.pay.PayMethodPage;
import com.didi.soda.pay.pospay.PosListPage;
import com.didi.soda.search.page.SearchHomePage;
import com.didi.soda.security.SecurityPage;
import java.util.HashMap;
import java.util.Map;

public final class HubTable {

    /* renamed from: a */
    private static HashMap<String, Class<?>> f43653a = new HashMap<>();

    /* renamed from: b */
    private static Map<Class<?>, String> f43654b = new HashMap();

    static {
        m30965a("taxis99OneTravel://soda", CustomerMainPage.class);
        m30965a("webPage", CustomerWebPage.class);
        m30965a(RoutePath.TRANSPARENT_WEB_PAGE, CustomerTransparentWebPage.class);
        m30965a(RoutePath.LANDING_WEB_PAGE, CustomerLandingWebPage.class);
        m30965a("verticalWebPage", CustomerVerticalWebPage.class);
        m30965a(RoutePath.ADDRESS_HOME, SelectAddressPage.class);
        m30965a(RoutePath.BILL_PAGE, CustomerBillPage.class);
        m30965a(RoutePath.GLOBAL_CART, GlobalCartPage.class);
        m30965a(RoutePath.FILTER_PAGE, FilterPage.class);
        m30965a(RoutePath.All_CATEGORY_PAGE, AllCategoryPage.class);
        m30965a(RoutePath.SHOP_CATEGORY_LANDING_PAGE, ShopCategoryLandingPage.class);
        m30965a("WebPage/Transfer_Page", CustomerPhotoTransferPage.class);
        m30965a(RoutePath.GOODS_PURCHASE, GoodsPurchasePage.class);
        m30965a(RoutePath.GOODS_MULTI_LEVEL, GoodsMultiLevelPage.class);
        m30965a(RoutePath.GOODS_PURCHASE_V2, com.didi.soda.goodsV2.page.GoodsPurchasePage.class);
        m30965a(RoutePath.GOODS_MULTI_LEVEL_V2, com.didi.soda.goodsV2.page.GoodsMultiLevelPage.class);
        m30965a(RoutePath.BUSINESS_HOME, BusinessHomePage.class);
        m30965a(RoutePath.BUSINESS_SEARCH_HOME, BusinessSearchPage.class);
        m30965a(RoutePath.BUSINESS_PREVIEW_IMAGE, BusinessImagePage.class);
        m30965a(RoutePath.BUSINESS_DETAIL, BusinessDetailPage.class);
        m30965a(RoutePath.BUSINESS_ADDRESS_MAP, BusinessAddressPage.class);
        m30965a(RoutePath.BUSINESS_CATEGORY_MENU, BusinessCategoryMenuPage.class);
        m30965a(RoutePath.TOPIC_PAGE, HomeTopicPage.class);
        m30965a(RoutePath.TOPIC_ACTIVITY_PAGE, TopicActivityPage.class);
        m30965a(RoutePath.BLOCKS_LANDING_PAGE, TopicActivityPage.class);
        m30965a(RoutePath.HOME_SUBSCRIBE_PHONE_PAGE, SubscribePhonePage.class);
        m30965a(RoutePath.SEARCH_HOME, SearchHomePage.class);
        m30965a("orderPage", OrderPage.class);
        m30965a(RoutePath.ORDER_EVALUATE, OrderEvaluatePage.class);
        m30965a(RoutePath.ORDER_EVALUATE_DETAIL, OrderEvaluateDetailPage.class);
        m30965a(RoutePath.ORDER_EVALUATE_SUCCESS, OrderEvaluateSuccessPage.class);
        m30965a(RoutePath.EVALUATE_PREVIEW_IMAGE, EvaluatePreviewImagePage.class);
        m30965a("debtOrderPayPage", DebtOrderPayPage.class);
        m30965a("payMethodPage", PayMethodPage.class);
        m30965a("payPosListPage", PosListPage.class);
        m30965a(RoutePath.ADDRESS_EDIT, EditAddressInfoPage.class);
        m30965a(RoutePath.TIPS_EDIT, EditTipsPage.class);
        m30965a("securityPage", SecurityPage.class);
        m30965a(RoutePath.SEND_RECEIPT, SendReceiptPage.class);
        m30965a(RoutePath.DELIVERY_METHOD_EDIT, EditDeliveryMethodPage.class);
        m30965a(RoutePath.REMARK_EDIT, EditRemarkPage.class);
        m30965a("citySelectPage", HomeCityListPage.class);
        m30965a("priceRuleDescPage", BusinessRulePage.class);
        m30965a("billTipPage", BillTipPage.class);
        m30965a(RoutePath.BILL_TIP_FEE_EDIT_TIP, BillTipsFeeEditPage.class);
        m30965a(RoutePath.REFUND_DETAIL_PAGE, RefundDetailPage.class);
        m30965a(RoutePath.BILL_OUT_OF_STOCK, OutOfStockPage.class);
        m30965a(RoutePath.ADDRESS_LIST, SelectedAddressListPage.class);
        m30965a(RoutePath.POLICY_UPDATE_PAGE, PolicyUpdatePage.class);
        m30965a("flutterCommonPage", CustomerFlutterPage.class);
        m30965a(RoutePath.FLUTTER_TRANSFER_CONTAINER, CustomerFlutterTransferPage.class);
        m30965a("discountDetail", DiscountDetailPage.class);
        m30965a(RoutePath.CART_INFO_CONFIRM, CartInfoConfirmPage.class);
        m30965a(RoutePath.REFUND_RULE_PAGE, RefundRulePage.class);
        m30965a(RoutePath.MUTUAL_EXCLUSION_RULE_PAGE, MutualExclusionRulePage.class);
    }

    private HubTable() {
    }

    public static String getPageId(Class<?> cls) {
        return f43654b.get(cls);
    }

    public static String getPageId(ScopeContext scopeContext) {
        return (String) scopeContext.getObject("ScopeContextPageId");
    }

    public static void registerExternalScheme(String str, Class<?> cls) {
        f43653a.put(str, cls);
    }

    /* renamed from: a */
    static Class<?> m30964a(String str) {
        return f43653a.get(str);
    }

    /* renamed from: a */
    private static void m30965a(String str, Class<?> cls) {
        f43653a.put(str, cls);
        if ("taxis99OneTravel://soda".equals(str)) {
            f43654b.put(cls, "homePage");
        } else {
            f43654b.put(cls, str);
        }
    }
}
