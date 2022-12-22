package com.didi.entrega.customer.app;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.home.page.CustomerMainPage;
import com.didi.entrega.router.HubTable;
import java.util.HashMap;
import java.util.Map;

public final class CustomerPageManager {

    /* renamed from: a */
    private static final String f19782a = "TimeMachine";

    /* renamed from: b */
    private Class<?> f19783b;

    /* renamed from: c */
    private Map<Class<?>, String> f19784c;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerPageManager INSTANCE = new CustomerPageManager();

        private Holder() {
        }
    }

    private CustomerPageManager() {
        this.f19784c = new HashMap();
        m14668a();
    }

    public static CustomerPageManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setCurrentPage(Class<?> cls) {
        LogUtil.m14761d(f19782a, "setCurrentPage = " + cls);
        this.f19783b = cls;
    }

    public String getCurrentPageName() {
        return getPageName(this.f19783b);
    }

    public String getPageName(Class<?> cls) {
        String str = this.f19784c.get(cls);
        return TextUtils.isEmpty(str) ? HubTable.getPageId(cls) : str;
    }

    /* renamed from: a */
    private void m14668a() {
        this.f19784c.put(CustomerMainPage.class, "1");
    }
}
