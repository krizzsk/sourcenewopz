package com.didi.soda.blocks.action;

import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.compose.log.ComposeLogUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006R$\u0010\u0003\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionPool;", "", "()V", "mPool", "", "", "Ljava/lang/Class;", "Lcom/didi/soda/blocks/action/BaseAction;", "getAction", "actionType", "registAction", "", "actionClazz", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionPool.kt */
public final class ActionPool {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ActionPool";
    private final Map<String, Class<? extends BaseAction>> mPool = new LinkedHashMap();

    public final void registAction(Class<? extends BaseAction> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "actionClazz");
        String str = null;
        if (cls.isAnnotationPresent(ActionNameMeta.class)) {
            ActionNameMeta actionNameMeta = (ActionNameMeta) cls.getAnnotation(ActionNameMeta.class);
            synchronized (this.mPool) {
                Map<String, Class<? extends BaseAction>> map = this.mPool;
                if (actionNameMeta != null) {
                    str = actionNameMeta.actionType();
                }
                Class put = map.put(str, cls);
            }
        } else if (!(!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug())) {
            throw new IllegalStateException("You should impl ActionNameMeta annotation before registAction.".toString());
        }
    }

    public final Class<? extends BaseAction> getAction(String str) {
        Class<? extends BaseAction> cls;
        if (str != null && (cls = this.mPool.get(str)) != null) {
            return cls;
        }
        ComposeLogUtil.m28546e(TAG, "unregistedAction type：" + str);
        return null;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionPool$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ActionPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
