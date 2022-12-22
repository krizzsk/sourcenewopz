package com.didi.soda.blocks.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/WidgetFactory;", "", "widgetPool", "Lcom/didi/soda/blocks/widget/WidgetPool;", "(Lcom/didi/soda/blocks/widget/WidgetPool;)V", "getWidgetPool", "()Lcom/didi/soda/blocks/widget/WidgetPool;", "setWidgetPool", "createWidget", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "name", "", "templateId", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WidgetFactory.kt */
public final class WidgetFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "WidgetFactory";
    private WidgetPool widgetPool;

    public WidgetFactory(WidgetPool widgetPool2) {
        Intrinsics.checkParameterIsNotNull(widgetPool2, "widgetPool");
        this.widgetPool = widgetPool2;
    }

    public final WidgetPool getWidgetPool() {
        return this.widgetPool;
    }

    public final void setWidgetPool(WidgetPool widgetPool2) {
        Intrinsics.checkParameterIsNotNull(widgetPool2, "<set-?>");
        this.widgetPool = widgetPool2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bb A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.blocks.widget.Buildable createWidget(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r1)
            r1 = 1
            r2 = 0
            com.didi.soda.blocks.widget.WidgetPool r3 = r6.widgetPool     // Catch:{ Exception -> 0x0029 }
            java.lang.Class r9 = r3.getWidget(r8, r9)     // Catch:{ Exception -> 0x0029 }
            if (r9 == 0) goto L_0x0085
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0029 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x0029 }
            java.lang.reflect.Constructor r9 = r9.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0029 }
            if (r9 == 0) goto L_0x0085
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0029 }
            r3[r5] = r7     // Catch:{ Exception -> 0x0029 }
            java.lang.Object r7 = r9.newInstance(r3)     // Catch:{ Exception -> 0x0029 }
            com.didi.soda.blocks.widget.Buildable r7 = (com.didi.soda.blocks.widget.Buildable) r7     // Catch:{ Exception -> 0x0029 }
            goto L_0x0086
        L_0x0029:
            r7 = move-exception
            r7.printStackTrace()
            com.didi.soda.blocks.sdk.BlocksEngine$Companion r9 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
            com.didi.soda.blocks.sdk.BlocksEngine r9 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r9, r2, r1, r2)
            com.didi.soda.blocks.sdk.config.IBlocksLogger r9 = r9.getLogger()
            if (r9 == 0) goto L_0x0079
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "can't create widget which name is:"
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = " with error:"
            r3.append(r4)
            java.lang.String r4 = r7.getMessage()
            if (r4 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r4 = r0
        L_0x0053:
            r3.append(r4)
            r4 = 32
            r3.append(r4)
            java.lang.Throwable r4 = r7.getCause()
            if (r4 == 0) goto L_0x006c
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L_0x006c
            if (r4 == 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r4 = r0
            goto L_0x006d
        L_0x006c:
            r4 = r2
        L_0x006d:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "WidgetFactory"
            r9.error(r4, r3)
        L_0x0079:
            com.didi.soda.blocks.sdk.BlocksEngine$Companion r9 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
            com.didi.soda.blocks.sdk.BlocksEngine r9 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r9, r2, r1, r2)
            boolean r9 = r9.isDebug()
            if (r9 != 0) goto L_0x00bc
        L_0x0085:
            r7 = r2
        L_0x0086:
            if (r7 != 0) goto L_0x00bb
            com.didi.soda.blocks.sdk.BlocksEngine$Companion r9 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
            com.didi.soda.blocks.sdk.BlocksEngine r9 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r9, r2, r1, r2)
            boolean r9 = r9.isDebug()
            r9 = r9 ^ r1
            if (r9 != 0) goto L_0x00bb
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "can't resolved Widget which name is "
            r7.append(r9)
            if (r8 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r8 = r0
        L_0x00a3:
            r7.append(r8)
            java.lang.String r8 = ", please register the widget when start up the BlocksEngine"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x00bb:
            return r7
        L_0x00bc:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.WidgetFactory.createWidget(android.content.Context, java.lang.String, java.lang.String):com.didi.soda.blocks.widget.Buildable");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/WidgetFactory$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: WidgetFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
