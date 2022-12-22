package com.didi.component.safetoolkit.sodaentregaapi;

import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenter;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.PresenterHolder;
import com.didi.safetoolkit.api.ISfOmegaService;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider(alias = "sodaEntrega", value = {ISfOmegaService.class})
public class SodaEntregaOmegaProvider implements ISfOmegaService {
    public void addOmegaEvent(String str, Map<String, Object> map) {
        IPresenter presenter = PresenterHolder.getIns().getPresenter();
        if (presenter instanceof AbsSafeToolkitPresenter) {
            int i = 0;
            AbsSafeToolkitPresenter absSafeToolkitPresenter = (AbsSafeToolkitPresenter) presenter;
            if (absSafeToolkitPresenter.getComponentParams().pageID != 1001) {
                i = absSafeToolkitPresenter.getComponentParams().bid;
            }
            map.put("g_BizId", i + "");
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                map.put("g_orderid", order.oid + "");
            }
            map.put("g_pageid", absSafeToolkitPresenter.getComponentParams().pageID + "");
            GlobalOmegaUtils.trackEvent(str, map);
            return;
        }
        int currentBID = BusinessUtils.getCurrentBID((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext());
        map.put("g_BizId", currentBID + "");
        CarOrder order2 = CarOrderHelper.getOrder();
        if (order2 != null) {
            map.put("g_orderid", order2.oid + "");
        }
        map.put("page", AbsJarvisPresenter.sGPageId);
        GlobalOmegaUtils.trackEvent(str, map);
    }
}
