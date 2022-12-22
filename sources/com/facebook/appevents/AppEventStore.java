package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0017\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "persistEvents", "", "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppEventStore.kt */
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG;

    private AppEventStore() {
    }

    static {
        String name = AppEventStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AppEventStore::class.java.name");
        TAG = name;
    }

    @JvmStatic
    public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
                    Intrinsics.checkNotNullParameter(sessionEventsState, "appEvents");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    @JvmStatic
    public static final synchronized void persistEvents(AppEventCollection appEventCollection) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Intrinsics.checkNotNullParameter(appEventCollection, "eventsToPersist");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                        SessionEventsState sessionEventsState = appEventCollection.get(next);
                        if (sessionEventsState != null) {
                            readAndClearStore.addEvents(next, sessionEventsState.getEventsToPersist());
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                    saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e0 A[Catch:{ Exception -> 0x004a, all -> 0x00e7 }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x00ed }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch:{ all -> 0x00e7 }
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x00e7 }
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00e7 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00bf, Exception -> 0x0069, all -> 0x0066 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x0064 }
            if (r3 == 0) goto L_0x005c
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x0064 }
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00e7 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00e7 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00e7 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x004a }
            r1.delete()     // Catch:{ Exception -> 0x004a }
            goto L_0x00de
        L_0x004a:
            r1 = move-exception
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00e7 }
            java.lang.String r6 = "Got unexpected exception when removing events file: "
            r7 = r1
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00e7 }
            r4 = 5
            java.lang.String r8 = "com.facebook.appevents.AppEventStore"
            r9 = 88
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e7 }
            goto L_0x00de
        L_0x005c:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x0064 }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x0064 }
            throw r3     // Catch:{ FileNotFoundException -> 0x00c0, Exception -> 0x0064 }
        L_0x0064:
            r3 = move-exception
            goto L_0x006b
        L_0x0066:
            r3 = move-exception
            r4 = r2
            goto L_0x009d
        L_0x0069:
            r3 = move-exception
            r4 = r2
        L_0x006b:
            java.lang.String r6 = TAG     // Catch:{ all -> 0x009c }
            java.lang.String r7 = "Got unexpected exception while reading events: "
            r8 = r3
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x009c }
            r5 = 5
            java.lang.String r9 = "com.facebook.appevents.AppEventStore"
            r10 = 77
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x009c }
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00e7 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00e7 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x008b }
            r1.delete()     // Catch:{ Exception -> 0x008b }
            goto L_0x00dd
        L_0x008b:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00e7 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            r6 = r1
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00e7 }
            r3 = 5
            java.lang.String r7 = "com.facebook.appevents.AppEventStore"
        L_0x0096:
            r8 = 88
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00e7 }
            goto L_0x00dd
        L_0x009c:
            r3 = move-exception
        L_0x009d:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00e7 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00e7 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00e7 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x00ae }
            r1.delete()     // Catch:{ Exception -> 0x00ae }
            goto L_0x00be
        L_0x00ae:
            r1 = move-exception
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00e7 }
            java.lang.String r6 = "Got unexpected exception when removing events file: "
            r7 = r1
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00e7 }
            r4 = 5
            java.lang.String r8 = "com.facebook.appevents.AppEventStore"
            r9 = 88
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e7 }
        L_0x00be:
            throw r3     // Catch:{ all -> 0x00e7 }
        L_0x00bf:
            r4 = r2
        L_0x00c0:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00e7 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00e7 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x00d1 }
            r1.delete()     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00dd
        L_0x00d1:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00e7 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            r6 = r1
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00e7 }
            r3 = 5
            java.lang.String r7 = "com.facebook.appevents.AppEventStore"
            goto L_0x0096
        L_0x00dd:
            r3 = r2
        L_0x00de:
            if (r3 != 0) goto L_0x00e5
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x00e7 }
            r3.<init>()     // Catch:{ all -> 0x00e7 }
        L_0x00e5:
            monitor-exit(r0)
            return r3
        L_0x00e7:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)     // Catch:{ all -> 0x00ed }
            monitor-exit(r0)
            return r2
        L_0x00ed:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0049 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents r10) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.lang.Class<com.facebook.appevents.AppEventStore> r1 = com.facebook.appevents.AppEventStore.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            r2 = 0
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x005a }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x005a }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0034 }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0034 }
            r6 = 0
            java.io.FileOutputStream r6 = r3.openFileOutput(r0, r6)     // Catch:{ all -> 0x0034 }
            java.io.OutputStream r6 = (java.io.OutputStream) r6     // Catch:{ all -> 0x0034 }
            r5.<init>(r6)     // Catch:{ all -> 0x0034 }
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x0034 }
            r4.<init>(r5)     // Catch:{ all -> 0x0034 }
            r4.writeObject(r10)     // Catch:{ all -> 0x0030 }
            com.facebook.internal.Utility r10 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x005a }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x005a }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x005a }
            goto L_0x0050
        L_0x0030:
            r10 = move-exception
            r7 = r10
            r2 = r4
            goto L_0x0036
        L_0x0034:
            r10 = move-exception
            r7 = r10
        L_0x0036:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = "Got unexpected exception while persisting events: "
            r4 = 5
            java.lang.String r8 = "com.facebook.appevents.AppEventStore"
            r9 = 108(0x6c, float:1.51E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0051 }
            java.io.File r10 = r3.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0049 }
            r10.delete()     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            com.facebook.internal.Utility r10 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x005a }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x005a }
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x005a }
        L_0x0050:
            return
        L_0x0051:
            r10 = move-exception
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x005a }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x005a }
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x005a }
            throw r10     // Catch:{ all -> 0x005a }
        L_0x005a:
            r10 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r10, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents):void");
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, mo175978d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AppEventStore.kt */
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual((Object) readClassDescriptor.getName(), (Object) ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual((Object) readClassDescriptor.getName(), (Object) APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }

        @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream$Companion;", "", "()V", "ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME", "", "APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME", "facebook-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: AppEventStore.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
