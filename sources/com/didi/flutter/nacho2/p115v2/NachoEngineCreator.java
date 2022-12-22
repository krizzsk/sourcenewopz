package com.didi.flutter.nacho2.p115v2;

import android.content.Context;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.callback.NachoEngineCallback;
import java.util.List;
import p242io.flutter.FlutterInjector;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.FlutterEngineGroup;
import p242io.flutter.embedding.engine.dart.DartExecutor;

/* renamed from: com.didi.flutter.nacho2.v2.NachoEngineCreator */
public class NachoEngineCreator {

    /* renamed from: a */
    private static FlutterEngineGroup f21144a;

    /* renamed from: com.didi.flutter.nacho2.v2.NachoEngineCreator$EngineCreateMode */
    public enum EngineCreateMode {
        Standard,
        EngineGroup
    }

    public static FlutterEngine createEngineByStandard(Context context, String str, String str2, List<String> list, NachoEngineCallback nachoEngineCallback) {
        DartExecutor.DartEntrypoint dartEntrypoint;
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                str = NachoConstants.NACHO_ENTRYPOINT_NAME;
            }
            FlutterEngine flutterEngine = new FlutterEngine(context);
            if (str2 == null) {
                dartEntrypoint = new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str);
            } else {
                dartEntrypoint = new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str2, str);
            }
            if (nachoEngineCallback != null) {
                nachoEngineCallback.onEngineCreated(flutterEngine);
            }
            flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint, list);
            return flutterEngine;
        }
        throw new RuntimeException("context can not be empty.");
    }

    public static FlutterEngine createEngineByGroup(Context context, String str, String str2, List<String> list) {
        DartExecutor.DartEntrypoint dartEntrypoint;
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                str = NachoConstants.NACHO_ENTRYPOINT_NAME;
            }
            if (f21144a == null) {
                f21144a = new FlutterEngineGroup(context);
            }
            if (str2 == null) {
                dartEntrypoint = new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str);
            } else {
                dartEntrypoint = new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str2, str);
            }
            return f21144a.createAndRunEngine(new FlutterEngineGroup.Options(context).setDartEntrypoint(dartEntrypoint).setInitialRoute((String) null).setDartEntrypointArgs(list));
        }
        throw new RuntimeException("context can not be empty.");
    }
}
