package com.didi.component.estimate.dynamicprice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.store.DDTravelConfigStore;

public class DynamicPriceFacade {

    /* renamed from: a */
    private static final String f13026a = "DynamicPriceFacade";

    /* renamed from: b */
    private final Logger f13027b = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private Context f13028c;

    public DynamicPriceFacade(Context context) {
        this.f13028c = context;
    }

    public boolean showTips(int i, String str) {
        Logger logger = this.f13027b;
        logger.info(" showTips url:" + str + " bid = " + i + " FormStore_Sid = " + FormStore.getInstance().Sid, new Object[0]);
        if (!m8851a() || FormStore.getInstance().mDynamicTipShown.get(i, false) || DDTravelConfigStore.getInstance().getDynamicPriceConfirmMark()) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            m8850a(str);
            FormStore.getInstance().mDynamicTipShown.put(i, true);
            return true;
        }
        this.f13027b.info("not show", new Object[0]);
        return false;
    }

    /* renamed from: a */
    private void m8850a(String str) {
        if (isWindowShowing()) {
            disMissWindow();
        }
        Intent intent = new Intent(this.f13028c, DynamicOnceWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
        this.f13028c.startActivity(intent);
    }

    /* renamed from: a */
    private boolean m8851a() {
        return m8852b();
    }

    /* renamed from: b */
    private boolean m8852b() {
        CarOrder order = CarOrderHelper.getOrder();
        return order == null || order.status == 0 || order.status == 7;
    }

    public void disMissWindow() {
        this.f13027b.info(" disMissWindow ", new Object[0]);
    }

    public boolean isWindowShowing() {
        this.f13027b.info(" isWindowShowing ", new Object[0]);
        return false;
    }
}
