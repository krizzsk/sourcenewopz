package com.didichuxing.omega.sdk.feedback;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.afanty.beans.SmileMenuItem;
import com.didichuxing.afanty.common.utils.Constants;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.apollo.sdk.swarm.ToggleService;
import com.didichuxing.omega.sdk.feedback.judgment.Judge;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewConfig;
import com.didichuxing.swarm.runtime.SwarmPlugin;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.OnAuthenticationStateChangeListener;
import com.taxis99.R;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class FeedbackActivator extends SwarmPlugin {
    public void stop(BundleContext bundleContext) throws Exception {
    }

    public void start(BundleContext bundleContext) throws Exception {
        if (bundleContext == null) {
            OLog.m32669i("afanty bundle contenxt is null!");
            return;
        }
        ServiceReference<S> serviceReference = bundleContext.getServiceReference(Application.class);
        if (serviceReference == null) {
            OLog.m32669i("afanty appRef null!");
            return;
        }
        final Application application = (Application) bundleContext.getService(serviceReference);
        if (application == null) {
            OLog.m32669i("afatny app context is null!");
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    FloatingView.feedback_init(application);
                } catch (Exception e) {
                    OLog.m32669i("feedback init fail:" + e.toString());
                }
            }
        });
        try {
            loadDynamicMenu(application);
            ((ToggleService) bundleContext.getService(bundleContext.getServiceReference(ToggleService.class))).addToggleStateChangeListener(new OnToggleStateChangeListener() {
                public void onStateChanged() {
                    FloatingViewState.getInstance().clearDynamicMenuItem();
                    FeedbackActivator.loadDynamicMenu(application);
                }
            });
            ((AuthenticationService) bundleContext.getService(bundleContext.getServiceReference(AuthenticationService.class))).addAuthenticationChangeListener(new OnAuthenticationStateChangeListener() {
                public void onAuthenticationStateChanged(AuthenticationChangeEvent authenticationChangeEvent) {
                    if (authenticationChangeEvent.isAuthenticated()) {
                        FloatingViewState.getInstance().clearDynamicMenuItem();
                        FeedbackActivator.loadDynamicMenu(application);
                        return;
                    }
                    FloatingViewApi.uninit();
                }
            });
            ((LanguageService) bundleContext.getService(bundleContext.getServiceReference(LanguageService.class))).addOnLanguageChangedListener(new LanguageService.OnLanguageChangedListener() {
                public void onLanguageChanged(String str, String str2) {
                    FloatingViewState.getInstance().clearDynamicMenuItem();
                    FeedbackActivator.loadDynamicMenu(application);
                }
            });
        } catch (Exception e) {
            OLog.m32669i("load afanty dynamic menu fail:" + e.toString());
        }
        try {
            ToggleService toggleService = (ToggleService) bundleContext.getService(bundleContext.getServiceReference(ToggleService.class));
            Boolean allow = toggleService.allow("OmegaSmileFaceTip");
            long intValue = (long) ((Integer) toggleService.getToggle("OmegaSmileFaceTip").getExperiment().getParam("SmileFaceTipDelay", 10000)).intValue();
            if (allow.booleanValue()) {
                Judge.getInstance().startJudge(application, intValue);
            } else {
                Judge.getInstance().stopJudge(application);
            }
        } catch (Exception e2) {
            OLog.m32669i("start judge failed " + e2.getMessage());
        }
    }

    private void showUI(final Application application) {
        OLog.m32669i("show ui in activator method");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                FloatingView.showUI(application);
            }
        });
    }

    private void showHuiduUI(final Application application) {
        OLog.m32669i("show ui in activator method");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                FloatingView.showHuiduUI(application);
            }
        });
    }

    private void hideUI() {
        OLog.m32669i("hide ui in activator method");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                FloatingView.hideUI();
            }
        });
    }

    public static void loadDynamicMenu(final Application application) {
        IToggle toggle = Apollo.getToggle(Constants.AFANTY_CONFIG_TOGGLE_NAME);
        if (toggle.allow()) {
            try {
                updateText((String) toggle.getExperiment().getParam("Smile_Text", ""));
                initExceptPage((String) toggle.getExperiment().getParam("except_ui", "[]"));
                JSONArray jSONArray = new JSONArray((String) toggle.getExperiment().getParam("menu_android", "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    String str = (String) toggle.getExperiment().getParam(string, "");
                    if (checkGroupApollo(toggle, string)) {
                        final SmileMenuItem smileMenuItem = new SmileMenuItem(application, string, str, application.getResources().getDrawable(R.drawable.user));
                        smileMenuItem.setMenuLabel(string);
                        if (smileMenuItem.isVisiable()) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    FloatingView.addSmileMenuItem(smileMenuItem, application);
                                }
                            });
                        }
                    }
                }
            } catch (Exception e) {
                OLog.m32669i("parse json err:" + e.toString());
            }
        }
    }

    private static void initExceptPage(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!"".equals(optString)) {
                    FloatingViewApi.addExceptActivity(optString);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static boolean checkGroupApollo(IToggle iToggle, String str) {
        String str2 = (String) iToggle.getExperiment().getParam("menu_group", "");
        if (TextUtils.isEmpty(str2) || !str2.contains(str)) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONArray jSONArray = jSONObject.getJSONArray(keys.next());
                if (jSONArray.toString().contains(str)) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        if (!Apollo.getToggle(new JSONObject((String) iToggle.getExperiment().getParam((String) jSONArray.get(i), "")).optString(GlobalCashierCoreModule.APOLLO)).allow()) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private static void updateText(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lang = SwarmUtil.getLang();
            try {
                JSONObject jSONObject = new JSONObject(str);
                final String optString = new JSONObject(jSONObject.optString("close_smile_item")).optString(lang);
                final String optString2 = new JSONObject(jSONObject.optString("cancel_item")).optString(lang);
                final String optString3 = new JSONObject(jSONObject.optString("dialog_content")).optString(lang);
                final String optString4 = new JSONObject(jSONObject.optString("dialog_confirm")).optString(lang);
                final String optString5 = new JSONObject(jSONObject.optString("dialog_cancel")).optString(lang);
                FloatingViewApi.setConfig(new FloatingViewConfig.IConfig() {
                    public String getCloseItemText() {
                        return optString;
                    }

                    public String getCancelItemText() {
                        return optString2;
                    }

                    public String getDialogContent() {
                        return optString3;
                    }

                    public String getDialogConfirm() {
                        return optString4;
                    }

                    public String getDialogCancel() {
                        return optString5;
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
