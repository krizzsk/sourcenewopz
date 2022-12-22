package com.didi.map.intl.commonwalkengine;

import com.didi.map.intl.commonwalkengine.impl.hawaii.HawaiiEngineImpl;
import com.didi.map.intl.commonwalkengine.impl.navbase.NavBaseEngineImpl;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/map/intl/commonwalkengine/WalkEngineFactory;", "", "()V", "getWalkEngine", "Lcom/didi/map/intl/commonwalkengine/IWalkEngine;", "type", "Lcom/didi/map/intl/commonwalkengine/WalkEngineType;", "commonWalkEngine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalkEngineFactory.kt */
public final class WalkEngineFactory {
    public static final WalkEngineFactory INSTANCE = new WalkEngineFactory();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalkEngineFactory.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalkEngineType.values().length];
            iArr[WalkEngineType.NAV_BASE.ordinal()] = 1;
            iArr[WalkEngineType.HAWAII.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private WalkEngineFactory() {
    }

    @JvmStatic
    public static final IWalkEngine getWalkEngine(WalkEngineType walkEngineType) {
        Intrinsics.checkNotNullParameter(walkEngineType, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[walkEngineType.ordinal()];
        if (i == 1) {
            return new NavBaseEngineImpl();
        }
        if (i == 2) {
            return new HawaiiEngineImpl();
        }
        throw new NoWhenBranchMatchedException();
    }
}
