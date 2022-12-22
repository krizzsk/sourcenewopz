package com.didi.entrega.router;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.address.list.SelectAddressPage;
import com.didi.entrega.bill.page.BillTipPage;
import com.didi.entrega.bill.page.CustomerBillPage;
import com.didi.entrega.bill.page.CustomerRulePage;
import com.didi.entrega.customer.base.pages.RoutePath;
import com.didi.entrega.customer.flutter.CustomerFlutterPage;
import com.didi.entrega.customer.p113h5.CustomerPhotoTransferPage;
import com.didi.entrega.customer.p113h5.CustomerVerticalWebPage;
import com.didi.entrega.customer.p113h5.CustomerWebPage;
import com.didi.entrega.home.page.CustomerMainPage;
import com.didi.entrega.home.page.HomeCityListPage;
import com.didi.entrega.home.page.ServiceNotifyPage;
import com.didi.entrega.info.page.EditReceivePage;
import com.didi.entrega.info.page.EditSendPage;
import com.didi.entrega.info.page.EditStuffPage;
import com.didi.entrega.order.debt.DebtOrderPayPage;
import com.didi.entrega.order.page.OrderPage;
import com.didi.entrega.orderlist.page.OrderListPage;
import com.didi.entrega.pay.PayMethodPage;
import com.didi.entrega.security.SecurityPage;
import java.util.HashMap;
import java.util.Map;

public final class HubTable {

    /* renamed from: a */
    private static HashMap<String, Class<?>> f21020a = new HashMap<>();

    /* renamed from: b */
    private static Map<Class<?>, String> f21021b = new HashMap();

    static {
        m15402a("taxis99OneTravel://sodaEntrega", CustomerMainPage.class);
        m15402a("citySelectPage", HomeCityListPage.class);
        m15402a("flutterCommonPage", CustomerFlutterPage.class);
        m15402a(RoutePath.BILL_PAGE, CustomerBillPage.class);
        m15402a("addressListPage", SelectAddressPage.class);
        m15402a("payMethodPage", PayMethodPage.class);
        m15402a(RoutePath.EDIT_SEND_PAGE, EditSendPage.class);
        m15402a(RoutePath.EDIT_RECEIVE_PAGE, EditReceivePage.class);
        m15402a(RoutePath.EDIT_STUFF_PAGE, EditStuffPage.class);
        m15402a(RoutePath.SERVICE_NOTIFY_PAGE, ServiceNotifyPage.class);
        m15402a("debtOrderPayPage", DebtOrderPayPage.class);
        m15402a("orderPage", OrderPage.class);
        m15402a("securityPage", SecurityPage.class);
        m15402a("orderListPage", OrderListPage.class);
        m15402a("priceRuleDescPage", CustomerRulePage.class);
        m15402a("verticalWebPage", CustomerVerticalWebPage.class);
        m15402a("billTipPage", BillTipPage.class);
        m15402a("webPage", CustomerWebPage.class);
        m15402a("WebPage/Transfer_Page", CustomerPhotoTransferPage.class);
    }

    private HubTable() {
    }

    public static String getPageId(Class<?> cls) {
        return f21021b.get(cls);
    }

    public static String getPageId(ScopeContext scopeContext) {
        return (String) scopeContext.getObject("ScopeContextPageId");
    }

    public static void registerExternalScheme(String str, Class<?> cls) {
        f21020a.put(str, cls);
    }

    /* renamed from: a */
    static Class<?> m15401a(String str) {
        return f21020a.get(str);
    }

    /* renamed from: a */
    private static void m15402a(String str, Class<?> cls) {
        f21020a.put(str, cls);
        if ("taxis99OneTravel://sodaEntrega".equals(str)) {
            f21021b.put(cls, "homePage");
        } else {
            f21021b.put(cls, str);
        }
    }
}
