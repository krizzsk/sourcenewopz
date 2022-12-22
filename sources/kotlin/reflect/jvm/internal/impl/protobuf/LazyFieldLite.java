package kotlin.reflect.jvm.internal.impl.protobuf;

public class LazyFieldLite {

    /* renamed from: a */
    private ByteString f60774a;

    /* renamed from: b */
    private ExtensionRegistryLite f60775b;

    /* renamed from: c */
    private volatile boolean f60776c;
    protected volatile MessageLite value;

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.f60774a = null;
        this.f60776c = true;
        return messageLite2;
    }

    public int getSerializedSize() {
        if (this.f60776c) {
            return this.value.getSerializedSize();
        }
        return this.f60774a.size();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(1:12)(1:13)|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ensureInitialized(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3) {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.value
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r2)
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.value     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            return
        L_0x000c:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r2.f60774a     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0021
            kotlin.reflect.jvm.internal.impl.protobuf.Parser r3 = r3.getParserForType()     // Catch:{ IOException -> 0x0023 }
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r2.f60774a     // Catch:{ IOException -> 0x0023 }
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r1 = r2.f60775b     // Catch:{ IOException -> 0x0023 }
            java.lang.Object r3 = r3.parseFrom((kotlin.reflect.jvm.internal.impl.protobuf.ByteString) r0, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r1)     // Catch:{ IOException -> 0x0023 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r3     // Catch:{ IOException -> 0x0023 }
            r2.value = r3     // Catch:{ IOException -> 0x0023 }
            goto L_0x0023
        L_0x0021:
            r2.value = r3     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.LazyFieldLite.ensureInitialized(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite):void");
    }
}
