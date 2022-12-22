package com.pay99.diff_passenger;

import android.app.Application;
import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.jsbridge.ExportNamespace;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.view.webview.fusion.model.WalletCommonModule;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.PaySecureConfig;
import com.didiglobal.pay.paysecure.PaySecureNetParamListener;
import com.didiglobal.pay.paysecure.PaySecureTheme99;
import com.didiglobal.pay.paysecure.WebUrlListener;
import com.pay99.diff_base.DiffConstantsKt;
import com.pay99.diff_passenger.utils.WalletSPUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ServiceProvider({ApplicationDelegate.class})
public class WalletApplicationDelegate extends ApplicationDelegate {
    public void onCreate(final Application application) {
        super.onCreate(application);
        PaySecure.INSTANCE.init(application, new PaySecureConfig(WalletCommonParamsUtil.getTerminalId(application), "5".equals(NationTypeUtil.getNationComponentData().getOriginID()) ? "60004" : "60000", PaySecureTheme99.INSTANCE, new PaySecureNetParamListener() {
            public Map<String, Object> getOmegaParams() {
                return null;
            }

            public String getProductId() {
                return WalletCommonParamsUtil.getCommonParam(application, "product_id") == null ? "500" : String.valueOf(WalletCommonParamsUtil.getCommonParam(application, "product_id"));
            }

            public String getToken() {
                return WalletCommonParamsUtil.getToken(application);
            }

            public String getLanguage() {
                return WalletCommonParamsUtil.getLang(application);
            }

            public double getLat() {
                try {
                    return Double.parseDouble(WalletCommonParamsUtil.getLat(application));
                } catch (Exception unused) {
                    return 0.0d;
                }
            }

            public double getLng() {
                try {
                    return Double.parseDouble(WalletCommonParamsUtil.getLng(application));
                } catch (Exception unused) {
                    return 0.0d;
                }
            }

            public String getLocale() {
                return Locale.getDefault().toString();
            }

            public String getCityId() {
                return (String) WalletCommonParamsUtil.getCommonParam(application, "city_id");
            }

            public String getCountry() {
                return WalletCommonParamsUtil.getCountry(application);
            }

            public int getUtcOffset(Context context) {
                return NationTypeUtil.getNationComponentData().getTimeZoneUtcOffset();
            }

            public Map<String, Object> getExtraInfo() {
                HashMap hashMap = new HashMap();
                hashMap.put("uid", WalletCommonParamsUtil.getUID(application));
                return hashMap;
            }
        }, (WebUrlListener) null));
        new Thread(new Runnable() {
            public void run() {
                DRouter.build(DiffConstantsKt.ROUTER_DIFF_INDEX).start();
                WalletDiminaUtil.INSTANCE.init(application);
                Application application = application;
                WalletSPUtils.saveCanRequestPwd(application, WalletCommonParamsUtil.getToken(application), true);
                WalletApplicationDelegate.exportWalletWebBridge();
            }
        }).start();
    }

    public static void exportWalletWebBridge() {
        if (!isExportModuleNameExist("WalletCommonModule")) {
            FusionEngine.export("WalletCommonModule", WalletCommonModule.class);
        }
    }

    private static boolean isExportModuleNameExist(String str) {
        ExportNamespace exportNamespace;
        if (WebViewJavascriptBridge.namespaceMap == null || (exportNamespace = WebViewJavascriptBridge.namespaceMap.get(str)) == null || !str.equals(exportNamespace.getExportModuleName())) {
            return false;
        }
        return true;
    }
}
