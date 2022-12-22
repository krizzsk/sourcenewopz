package com.didi.aoe.library.modeloption.loader.impl;

import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/aoe/library/modeloption/loader/impl/LocalOnlyModelOptionLoader;", "Lcom/didi/aoe/library/api/AoeProcessor$ModelOptionLoaderComponent;", "()V", "mLogger", "Lcom/didi/aoe/library/logging/Logger;", "load", "Lcom/didi/aoe/library/api/AoeModelOption;", "context", "Landroid/content/Context;", "modelDir", "", "Companion", "library-model-option-loader_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LocalOnlyModelOptionLoader.kt */
public final class LocalOnlyModelOptionLoader implements AoeProcessor.ModelOptionLoaderComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f8211b = "model.config";

    /* renamed from: a */
    private final Logger f8212a;

    public LocalOnlyModelOptionLoader() {
        Logger logger = LoggerFactory.getLogger("LocalOnlyModelOptionLoader");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(…alOnlyModelOptionLoader\")");
        this.f8212a = logger;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.aoe.library.api.AoeModelOption load(android.content.Context r4, java.lang.String r5) throws com.didi.aoe.library.lang.AoeIOException {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "modelDir"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            r0 = 0
            r1 = r0
            com.didi.aoe.library.modeloption.loader.pojos.LocalModelOption r1 = (com.didi.aoe.library.modeloption.loader.pojos.LocalModelOption) r1
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x00ab }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab }
            r1.<init>()     // Catch:{ Exception -> 0x00ab }
            r1.append(r5)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x00ab }
            r1.append(r5)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r5 = "model.config"
            r1.append(r5)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x00ab }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ Exception -> 0x00ab }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ Exception -> 0x00ab }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x00ab }
            r5 = r4
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "input"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)     // Catch:{ all -> 0x00a4 }
            byte[] r5 = com.didi.aoe.library.common.util.FileUtils.read((java.io.InputStream) r5)     // Catch:{ all -> 0x00a4 }
            if (r5 != 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x00a4 }
        L_0x0044:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00a4 }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x00a4 }
            r1.<init>(r5, r2)     // Catch:{ all -> 0x00a4 }
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ all -> 0x00a4 }
            r5.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.Class<com.didi.aoe.library.modeloption.loader.pojos.LocalModelOption> r2 = com.didi.aoe.library.modeloption.loader.pojos.LocalModelOption.class
            java.lang.Object r5 = r5.fromJson((java.lang.String) r1, r2)     // Catch:{ all -> 0x00a4 }
            com.didi.aoe.library.modeloption.loader.pojos.LocalModelOption r5 = (com.didi.aoe.library.modeloption.loader.pojos.LocalModelOption) r5     // Catch:{ all -> 0x00a4 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
            kotlin.p245io.CloseableKt.closeFinally(r4, r0)     // Catch:{ Exception -> 0x00ab }
            com.didi.aoe.library.logging.Logger r4 = r3.f8212a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Parse LocalModelOption: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r4.debug(r0, r1)
            if (r5 == 0) goto L_0x008b
            if (r5 != 0) goto L_0x007d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x007d:
            boolean r4 = r5.isValid()
            if (r4 == 0) goto L_0x008b
            if (r5 != 0) goto L_0x0088
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0088:
            com.didi.aoe.library.api.AoeModelOption r5 = (com.didi.aoe.library.api.AoeModelOption) r5
            return r5
        L_0x008b:
            com.didi.aoe.library.lang.AoeIOException r4 = new com.didi.aoe.library.lang.AoeIOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Some fields of this config is empty: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>((java.lang.String) r5)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        L_0x00a4:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x00ab }
            throw r0     // Catch:{ Exception -> 0x00ab }
        L_0x00ab:
            r4 = move-exception
            com.didi.aoe.library.lang.AoeIOException r5 = new com.didi.aoe.library.lang.AoeIOException
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.String r0 = "Parse LocalModelOption failed: "
            r5.<init>(r0, r4)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.library.modeloption.loader.impl.LocalOnlyModelOptionLoader.load(android.content.Context, java.lang.String):com.didi.aoe.library.api.AoeModelOption");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/aoe/library/modeloption/loader/impl/LocalOnlyModelOptionLoader$Companion;", "", "()V", "CONFIG_FILE_NAME", "", "library-model-option-loader_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LocalOnlyModelOptionLoader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
