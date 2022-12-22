package com.didi.global.flutter.linker;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.flutter.nacho.Nacho;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.auth.InnerAuthManager;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.listener.LoginListeners;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FlutterRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        final Uri uri = request.getUri();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            Context context = request.getContext();
            if (path.startsWith("/safety") && path.contains("safety_panel")) {
                String uri2 = uri.toString();
                Nacho.Router().open(context, uri2.substring(uri2.indexOf("/safety") + 7));
            } else if (path.startsWith("/delivery") && path.contains("delivery_consignee")) {
                String uri3 = uri.toString();
                try {
                    StringBuffer stringBuffer = new StringBuffer(uri3);
                    if (!uri3.endsWith(ParamKeys.SIGN_AND)) {
                        stringBuffer.append(ParamKeys.SIGN_AND);
                    }
                    CountryListResponse.CountryRule defCountry = CountryManager.getIns().getDefCountry();
                    if (defCountry != null) {
                        stringBuffer.append("calling_code=");
                        stringBuffer.append(URLEncoder.encode(defCountry.calling_code, "UTF-8"));
                        stringBuffer.append("&format=");
                        stringBuffer.append(URLEncoder.encode(defCountry.format, "UTF-8"));
                        stringBuffer.append("&max_len=");
                        stringBuffer.append(URLEncoder.encode("" + defCountry.max_len, "UTF-8"));
                    }
                    uri3 = stringBuffer.toString();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Nacho.Router().open(context, uri3.substring(uri3.indexOf("/delivery") + 9));
            } else if (path.startsWith("/login")) {
                final InnerAuthManager instance = InnerAuthManager.getInstance();
                if (instance.requestAuth(uri)) {
                    if (!OneLoginFacade.getStore().isLoginNow()) {
                        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
                            public void onSuccess(Activity activity, String str) {
                                DRouter.build(uri.toString()).start();
                            }

                            public void onCancel() {
                                instance.notAuth();
                            }
                        });
                        OneLoginFacade.getAction().go2Login(request.getContext());
                        return;
                    }
                    instance.register(request.getContext(), uri);
                    if (instance.illegal()) {
                        instance.notAuth();
                        return;
                    }
                    String uri4 = uri.toString();
                    Nacho.Router().open(context, uri4.substring(uri4.indexOf("/login") + 6));
                } else if (instance.responseAuth(uri)) {
                    instance.onAuth(uri);
                } else {
                    String uri5 = uri.toString();
                    Nacho.Router().open(context, uri5.substring(uri5.indexOf("/login") + 6));
                }
            } else if (path.startsWith("/btc")) {
                String uri6 = uri.toString();
                Nacho.Router().open(context, uri6.substring(uri6.indexOf("/btc") + 4));
            } else if (!path.startsWith("/country_code") || !path.contains(ParamConst.PARAM_CALLING_CODE)) {
                path.startsWith("/setting");
            } else {
                String uri7 = uri.toString();
                Nacho.Router().open(context, uri7.substring(uri7.indexOf("/country_code") + 13));
            }
        }
    }
}
