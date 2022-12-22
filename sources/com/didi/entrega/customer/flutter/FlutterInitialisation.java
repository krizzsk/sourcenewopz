package com.didi.entrega.customer.flutter;

import android.content.Context;
import android.os.Bundle;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.entrega.customer.biz.scheme.FlutterScheme;
import com.didi.entrega.customer.flutter.FlutterInitialisation;
import com.didi.entrega.customer.flutter.plugin.EnvironmentPlugin;
import com.didi.entrega.customer.flutter.plugin.HttpPlugin;
import com.didi.entrega.customer.flutter.plugin.LoggerPlugin;
import com.didi.entrega.customer.flutter.plugin.PageContainerPlugin;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.widget.xpanel.XPanelPlugin;
import com.didi.flutter.nacho2.p115v2.Nacho;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.flutter.nacho2.p115v2.NachoEngineCreator;
import com.didi.flutter.nacho2.p115v2.callback.NachoEngineCallback;
import com.didi.flutter.nacho2.p115v2.callback.NachoRouterCallback;
import java.util.Arrays;
import java.util.HashMap;
import p242io.flutter.embedding.android.registry.NFlutterContainerRegistry;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugins.GeneratedPluginRegistrant;

public final class FlutterInitialisation {
    public static final String BIZ_ENTRY_POINT_NAME = "mainEntrega";
    public static final String ENGINE_ID = "io.flutter.entrega.main";
    public static final String ENTRY_POINT_LIBRARY = "package:pax_flutter/main.dart";

    /* renamed from: a */
    private static final String f19894a = "FlutterInitialisation";

    /* renamed from: b */
    private static final String f19895b = "entrega";

    private FlutterInitialisation() {
    }

    public static void initFlutter(Context context, PageInstrument pageInstrument) {
        NachoAction bizMainEngineAction = FlutterEngineStore.getInstance().getBizMainEngineAction();
        if (bizMainEngineAction == null || bizMainEngineAction.getEngine() == null || !BIZ_ENTRY_POINT_NAME.equals(bizMainEngineAction.getEntrypoint())) {
            FlutterEngineStore.getInstance().setBizMainEngineAction(Nacho.createBizAction(new NachoAction.Builder(context).engineCreateMode(NachoEngineCreator.EngineCreateMode.Standard).dartEntrypointArgs(Arrays.asList(new String[]{f19895b})).engineId(ENGINE_ID).routeCallback(new EntregaNachoRouterCallback(pageInstrument)).engineCallback(new NachoEngineCallback() {
                public void onEngineDestroyed() {
                }

                public void onEngineCreated(FlutterEngine flutterEngine) {
                    FlutterInitialisation.m14726b(flutterEngine);
                }
            })));
            return;
        }
        bizMainEngineAction.setOnRouteCallback(new EntregaNachoRouterCallback(pageInstrument));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14726b(FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        flutterEngine.getPlugins().add((FlutterPlugin) new EnvironmentPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new HttpPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new LoggerPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new PageContainerPlugin());
        flutterEngine.getPlugins().add((FlutterPlugin) new XPanelPlugin());
        FlutterBusinessAbility.Companion.registerService(flutterEngine.getDartExecutor().getBinaryMessenger());
    }

    static class EntregaNachoRouterCallback implements NachoRouterCallback {
        PageInstrument instrument;

        public EntregaNachoRouterCallback(PageInstrument pageInstrument) {
            this.instrument = pageInstrument;
        }

        public void onPageOpen(String str, String str2, HashMap<String, Object> hashMap) {
            FlutterScheme.flutterOpenSodaPage(str2, hashMap, str);
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
                        public final void run() {
                            FlutterInitialisation.EntregaNachoRouterCallback.this.mo59893x647f999();
                        }
                    });
                }
            }
        }

        /* renamed from: lambda$onPageClose$0$FlutterInitialisation$EntregaNachoRouterCallback */
        public /* synthetic */ void mo59893x647f999() {
            this.instrument.popToRoot();
        }
    }
}
