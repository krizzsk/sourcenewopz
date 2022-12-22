package com.didi.component.safetoolkit.spi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.core.IPresenter;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.PresenterHolder;
import com.didi.safetoolkit.api.ISfUriDispatcherServices;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.push.ServerParam;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {ISfUriDispatcherServices.class})
public class UriDispatcherProvider implements ISfUriDispatcherServices {
    public void handleUri(Context context, String str) {
        CountryInfo countryInfo;
        IPresenter presenter = PresenterHolder.getIns().getPresenter();
        if (!TextUtils.isEmpty(str)) {
            if (presenter instanceof AbsSafeToolkitPresenter) {
                countryInfo = BusinessUtils.getCountryInfo(((AbsSafeToolkitPresenter) presenter).getComponentParams().bizCtx);
            } else {
                countryInfo = BusinessUtils.getCountryInfo((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext());
            }
            if (countryInfo != null) {
                str = Uri.parse(str).buildUpon().appendQueryParameter(ServerParam.PARAM_TRIPCOUNTRY, countryInfo.getCountryIsoCode()).build().toString();
            }
            Intent intent = new Intent(context, GlobalWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
            context.startActivity(intent);
        }
    }
}
