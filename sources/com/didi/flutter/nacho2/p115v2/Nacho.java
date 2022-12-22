package com.didi.flutter.nacho2.p115v2;

import android.content.Context;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.flutter.nacho2.p115v2.NachoEngineCreator;
import com.didi.flutter.nacho2.p115v2.callback.NachoEngineCallback;
import p242io.flutter.embedding.engine.FlutterEngine;

/* renamed from: com.didi.flutter.nacho2.v2.Nacho */
public class Nacho {
    private Nacho() {
    }

    public static NachoAction createMainAction(NachoAction.Builder builder) {
        builder.engineId(NachoConstants.NACHO_MAIN_ACTION_NAME);
        NachoAction createBizAction = createBizAction(builder);
        NachoMainActionHolder.setMainAction(createBizAction);
        return createBizAction;
    }

    public static NachoAction createBizAction(NachoAction.Builder builder) {
        FlutterEngine flutterEngine;
        NachoAction build = builder.build();
        if (TextUtils.isEmpty(build.getEngineId())) {
            build.mo62878a(NachoConstants.NACHO_FLUTTER_ENGINE_NAME + System.currentTimeMillis());
        }
        String entrypoint = build.getEntrypoint();
        if (TextUtils.isEmpty(entrypoint)) {
            entrypoint = NachoConstants.NACHO_ENTRYPOINT_NAME;
            build.mo62879b(entrypoint);
        }
        Context context = build.getContext();
        NachoEngineCallback onEngineCallback = build.getOnEngineCallback();
        if (build.getEngineCreateMode() == NachoEngineCreator.EngineCreateMode.Standard) {
            flutterEngine = NachoEngineCreator.createEngineByStandard(context, entrypoint, build.getDartEntrypointLibrary(), build.getDartEntrypointArgs(), onEngineCallback);
        } else {
            flutterEngine = NachoEngineCreator.createEngineByGroup(context, entrypoint, build.getDartEntrypointLibrary(), build.getDartEntrypointArgs());
            if (onEngineCallback != null) {
                onEngineCallback.onEngineCreated(flutterEngine);
            }
        }
        build.mo62877a(flutterEngine);
        NachoChannelManager.registerNachoChannel(build);
        NachoLifecycleManager.registerLifecycleChannels(build);
        return build;
    }
}
