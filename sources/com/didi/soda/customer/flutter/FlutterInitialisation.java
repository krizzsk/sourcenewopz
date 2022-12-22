package com.didi.soda.customer.flutter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.flutter.nacho2.p115v2.Nacho;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.flutter.nacho2.p115v2.NachoEngineCreator;
import com.didi.flutter.nacho2.p115v2.callback.NachoEngineCallback;
import com.didi.flutter.nacho2.p115v2.callback.NachoRouterCallback;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.flutter.plugin.EnvironmentPlugin;
import com.didi.soda.customer.flutter.plugin.HttpPlugin;
import com.didi.soda.customer.flutter.plugin.LoggerPlugin;
import com.didi.soda.customer.flutter.plugin.PageContainerPlugin;
import com.didi.soda.customer.flutter.plugin.PaymentPlugin;
import com.didi.soda.customer.flutter.plugin.SharePlugin;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.immap.IMMapHelper;
import com.didi.soda.customer.widget.xpanel.XPanelPlugin;
import com.didi.soda.home.efo.detail.DiscountDetailServicePlugin;
import com.didi.soda.home.feedback.GetPhotoPlugin;
import com.didi.soda.home.feedback.UserInfoPlugin;
import com.didi.soda.order.flutterpage.OrderServicePlugin;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import java.util.Collections;
import java.util.HashMap;
import p242io.flutter.embedding.android.registry.NFlutterContainerRegistry;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugins.GeneratedPluginRegistrant;

public final class FlutterInitialisation {
    public static final String ENGINE_BIZ = "food";
    public static final String ENGINE_ID = "io.flutter.food.main";

    private FlutterInitialisation() {
    }

    public static void init(Context context, Activity activity, PageInstrument pageInstrument) {
        if (FallbackController.isOpenDelayInitFlutter()) {
            UIHandler.post(new Runnable(context, activity, pageInstrument) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ Activity f$1;
                public final /* synthetic */ PageInstrument f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    FlutterInitialisation.m29059a(this.f$0, this.f$1, this.f$2);
                }
            });
            return;
        }
        initFlutter(context, activity, pageInstrument);
        IMMapHelper.init(activity.getApplicationContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29059a(Context context, Activity activity, PageInstrument pageInstrument) {
        LaunchAppTracker.Companion.log(">>>>> init flutter begin");
        initFlutter(context, activity, pageInstrument);
        IMMapHelper.init(activity.getApplicationContext());
        LaunchAppTracker.Companion.log(">>>>> init flutter end");
    }

    public static void initFlutter(Context context, final Activity activity, PageInstrument pageInstrument) {
        NachoAction bizFoodEngineAction = CustomerFlutterEngineManager.getInstance().getBizFoodEngineAction();
        if (bizFoodEngineAction == null || bizFoodEngineAction.getEngine() == null) {
            CustomerFlutterEngineManager.getInstance().setBizFoodEngineAction(Nacho.createBizAction(new NachoAction.Builder(context).engineId(ENGINE_ID).dartEntrypointArgs(Collections.singletonList(ENGINE_BIZ)).engineCreateMode(NachoEngineCreator.EngineCreateMode.Standard).routeCallback(new FoodNachoRouterCallback(pageInstrument)).engineCallback(new NachoEngineCallback() {
                public void onEngineDestroyed() {
                }

                public void onEngineCreated(FlutterEngine flutterEngine) {
                    GeneratedPluginRegistrant.registerWith(flutterEngine);
                    flutterEngine.getPlugins().add((FlutterPlugin) new EnvironmentPlugin(activity));
                    flutterEngine.getPlugins().add((FlutterPlugin) new HttpPlugin());
                    flutterEngine.getPlugins().add((FlutterPlugin) new LoggerPlugin());
                    flutterEngine.getPlugins().add((FlutterPlugin) new SharePlugin(activity));
                    flutterEngine.getPlugins().add((FlutterPlugin) new PageContainerPlugin());
                    flutterEngine.getPlugins().add((FlutterPlugin) new PaymentPlugin());
                    flutterEngine.getPlugins().add((FlutterPlugin) new XPanelPlugin());
                    FlutterBusinessAbility.Companion.registerService(flutterEngine.getDartExecutor().getBinaryMessenger());
                    flutterEngine.getPlugins().add((FlutterPlugin) new OrderServicePlugin(activity));
                    flutterEngine.getPlugins().add((FlutterPlugin) new DiscountDetailServicePlugin());
                    flutterEngine.getPlugins().add((FlutterPlugin) new UserInfoPlugin());
                    flutterEngine.getPlugins().add((FlutterPlugin) new GetPhotoPlugin());
                }
            })));
            return;
        }
        bizFoodEngineAction.setOnRouteCallback(new FoodNachoRouterCallback(pageInstrument));
    }

    static class FoodNachoRouterCallback implements NachoRouterCallback {
        PageInstrument mInstrument;

        public FoodNachoRouterCallback(PageInstrument pageInstrument) {
            this.mInstrument = pageInstrument;
        }

        public void onPageOpen(String str, String str2, HashMap<String, Object> hashMap) {
            SchemeHelper.flutterOpenSodaPage(str2, hashMap, str);
        }

        public void onPageClose(String str, HashMap<String, Object> hashMap) {
            CustomerFlutterPage customerFlutterPage = (CustomerFlutterPage) NFlutterContainerRegistry.getContainer(str);
            if (customerFlutterPage != null) {
                Bundle bundle = new Bundle();
                if (hashMap != null) {
                    for (String next : hashMap.keySet()) {
                        Object obj = hashMap.get(next);
                        if (obj instanceof String) {
                            bundle.putString(next, (String) obj);
                        } else if (obj instanceof Boolean) {
                            bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof Integer) {
                            bundle.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(next, ((Long) obj).longValue());
                        } else if (obj instanceof Double) {
                            bundle.putDouble(next, ((Double) obj).doubleValue());
                        }
                    }
                }
                customerFlutterPage.finish(bundle);
                if (hashMap != null && hashMap.containsKey("popRoot") && ((Integer) hashMap.get("popRoot")).intValue() == 1) {
                    UiHandlerUtil.post(new Runnable() {
                        public void run() {
                            FoodNachoRouterCallback.this.mInstrument.popToRoot();
                        }
                    });
                }
            }
        }
    }
}
