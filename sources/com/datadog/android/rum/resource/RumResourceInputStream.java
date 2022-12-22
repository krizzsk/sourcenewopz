package com.datadog.android.rum.resource;

import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016J4\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0!¢\u0006\u0002\b\"H\u0002¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0016J \u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00062"}, mo175978d2 = {"Lcom/datadog/android/rum/resource/RumResourceInputStream;", "Ljava/io/InputStream;", "delegate", "url", "", "(Ljava/io/InputStream;Ljava/lang/String;)V", "callStart", "", "getDelegate", "()Ljava/io/InputStream;", "failed", "", "getFailed$dd_sdk_android_release", "()Z", "setFailed$dd_sdk_android_release", "(Z)V", "firstByte", "key", "getKey$dd_sdk_android_release", "()Ljava/lang/String;", "lastByte", "size", "getSize$dd_sdk_android_release", "()J", "setSize$dd_sdk_android_release", "(J)V", "getUrl", "available", "", "callWithErrorTracking", "T", "errorMessage", "operation", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "close", "", "mark", "readlimit", "markSupported", "read", "b", "", "off", "len", "reset", "skip", "n", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumResourceInputStream.kt */
public final class RumResourceInputStream extends InputStream {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_CLOSE = "Error closing input stream";
    public static final String ERROR_MARK = "Error marking input stream";
    public static final String ERROR_READ = "Error reading from input stream";
    public static final String ERROR_RESET = "Error resetting input stream";
    public static final String ERROR_SKIP = "Error skipping bytes from input stream";
    public static final String METHOD = "GET";

    /* renamed from: a */
    private final InputStream f4014a;

    /* renamed from: b */
    private final String f4015b;

    /* renamed from: c */
    private final String f4016c = (this.f4014a.getClass().getSimpleName() + '@' + System.identityHashCode(this.f4014a));

    /* renamed from: d */
    private long f4017d;

    /* renamed from: e */
    private boolean f4018e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f4019f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f4020g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f4021h;

    public final InputStream getDelegate() {
        return this.f4014a;
    }

    public final String getUrl() {
        return this.f4015b;
    }

    public RumResourceInputStream(InputStream inputStream, String str) {
        Intrinsics.checkNotNullParameter(inputStream, "delegate");
        Intrinsics.checkNotNullParameter(str, "url");
        this.f4014a = inputStream;
        this.f4015b = str;
        RumMonitor rumMonitor = GlobalRum.get();
        rumMonitor.startResource(this.f4016c, "GET", this.f4015b, MapsKt.emptyMap());
        this.f4019f = System.nanoTime();
        if (rumMonitor instanceof AdvancedRumMonitor) {
            ((AdvancedRumMonitor) rumMonitor).waitForResourceTiming(this.f4016c);
        }
    }

    public final String getKey$dd_sdk_android_release() {
        return this.f4016c;
    }

    public final long getSize$dd_sdk_android_release() {
        return this.f4017d;
    }

    public final void setSize$dd_sdk_android_release(long j) {
        this.f4017d = j;
    }

    public final boolean getFailed$dd_sdk_android_release() {
        return this.f4018e;
    }

    public final void setFailed$dd_sdk_android_release(boolean z) {
        this.f4018e = z;
    }

    public int read() {
        if (this.f4020g == 0) {
            this.f4020g = System.nanoTime();
        }
        return ((Number) m2521a(ERROR_READ, new RumResourceInputStream$read$1(this))).intValue();
    }

    public int read(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        if (this.f4020g == 0) {
            this.f4020g = System.nanoTime();
        }
        return ((Number) m2521a(ERROR_READ, new RumResourceInputStream$read$2(bArr, this))).intValue();
    }

    public int read(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        if (this.f4020g == 0) {
            this.f4020g = System.nanoTime();
        }
        return ((Number) m2521a(ERROR_READ, new RumResourceInputStream$read$3(bArr, i, i2, this))).intValue();
    }

    public int available() {
        return ((Number) m2521a(ERROR_READ, RumResourceInputStream$available$1.INSTANCE)).intValue();
    }

    public long skip(long j) {
        return ((Number) m2521a(ERROR_SKIP, new RumResourceInputStream$skip$1(j))).longValue();
    }

    public boolean markSupported() {
        return ((Boolean) m2521a(ERROR_READ, RumResourceInputStream$markSupported$1.INSTANCE)).booleanValue();
    }

    public void mark(int i) {
        m2521a(ERROR_MARK, new RumResourceInputStream$mark$1(i));
    }

    public void reset() {
        m2521a(ERROR_RESET, RumResourceInputStream$reset$1.INSTANCE);
    }

    public void close() {
        m2521a(ERROR_CLOSE, new RumResourceInputStream$close$1(this));
    }

    /* renamed from: a */
    private final <T> T m2521a(String str, Function1<? super InputStream, ? extends T> function1) {
        try {
            return function1.invoke(this.f4014a);
        } catch (Throwable th) {
            if (!this.f4018e) {
                this.f4018e = true;
                RumMonitor.DefaultImpls.stopResourceWithError$default(GlobalRum.get(), this.f4016c, (Integer) null, str, RumErrorSource.SOURCE, th, (Map) null, 32, (Object) null);
            }
            throw th;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/rum/resource/RumResourceInputStream$Companion;", "", "()V", "ERROR_CLOSE", "", "ERROR_MARK", "ERROR_READ", "ERROR_RESET", "ERROR_SKIP", "METHOD", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumResourceInputStream.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
