package com.didi.beatles.p099im.views.eggs;

import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.eggs.fall.IMFallEggsDrop;

/* renamed from: com.didi.beatles.im.views.eggs.IMEggsDropFactory */
public final class IMEggsDropFactory {

    /* renamed from: a */
    private static final String f10204a = IMEggsDropFactory.class.getSimpleName();

    private IMEggsDropFactory() {
    }

    public static IIMEggsDrop create(IMConfig.EggsInfo eggsInfo) {
        if (eggsInfo.displayStyle == 0) {
            return IMFallEggsDrop.obtain();
        }
        IMLog.m6632e(f10204a, C4234I.m6591t("[drop] Invalid displayType -> ", Integer.valueOf(eggsInfo.displayStyle)));
        return null;
    }
}
