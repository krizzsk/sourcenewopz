package com.didi.soda.blocks.widget;

import com.didi.soda.blocks.action.ShowActionHelper;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.track.BlocksTrackHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006R$\u0010\u0003\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/WidgetPool;", "", "()V", "mPool", "", "", "Ljava/lang/Class;", "Lcom/didi/soda/blocks/widget/Buildable;", "getWidget", "widgetName", "templateId", "registWidget", "", "widgetClazz", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WidgetPool.kt */
public final class WidgetPool {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "WidgetPool";
    private final Map<String, Class<? extends Buildable>> mPool = new LinkedHashMap();

    public final void registWidget(Class<? extends Buildable> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "widgetClazz");
        if (cls.isAnnotationPresent(WidgetNameMeta.class)) {
            WidgetNameMeta widgetNameMeta = (WidgetNameMeta) cls.getAnnotation(WidgetNameMeta.class);
            synchronized (this.mPool) {
                this.mPool.put(widgetNameMeta != null ? widgetNameMeta.widgetName() : null, cls);
                if (widgetNameMeta != null && widgetNameMeta.realTimeExposure()) {
                    ShowActionHelper.Companion.registerRealTimeExposureContainer(widgetNameMeta.widgetName());
                }
                IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                if (logger != null) {
                    logger.info(TAG, "regist widget which clazzname is: " + cls.getName());
                    Unit unit = Unit.INSTANCE;
                }
            }
        } else if (!(!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug())) {
            throw new IllegalStateException("You should impl WidgetNameMeta annotation before registWidget.".toString());
        }
    }

    public final Class<? extends Buildable> getWidget(String str, String str2) {
        Class<? extends Buildable> cls;
        if (str != null && (cls = this.mPool.get(str)) != null) {
            return cls;
        }
        IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
        if (logger != null) {
            logger.error(TAG, "unregisted Widget Name：" + str);
        }
        BlocksTrackHelper.Companion.trackWidgetNotFound(str, str2);
        return null;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/WidgetPool$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: WidgetPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
