package com.didi.component.safetoolkit.sodaentregaapi;

import android.content.Context;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.PresenterHolder;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider(alias = "sodaEntrega", value = {ISfInfoService.class})
public class SodaEntregaBaseInfoProvider implements ISfInfoService {
    public Map<String, Object> getBaseParams(Context context) {
        return new ProviderBaseRequest().createBaseParams(context);
    }

    public String getCarOrderId() {
        CarOrder order = CarOrderHelper.getOrder();
        return order != null ? order.getOid() : "";
    }

    public String getCountryIsoCode() {
        ComponentParams componentParams;
        IPresenter presenter = PresenterHolder.getIns().getPresenter();
        if (!(presenter instanceof AbsSafeToolkitPresenter) || (componentParams = ((AbsSafeToolkitPresenter) presenter).getComponentParams()) == null) {
            return BusinessUtils.getCountryIsoCode((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext());
        }
        return BusinessUtils.getCountryIsoCode(componentParams.bizCtx);
    }

    private class ProviderBaseRequest extends BaseRequest {
        private ProviderBaseRequest() {
        }

        public Map<String, Object> createBaseParams(Context context) {
            return super.createBaseParams(context);
        }
    }
}
