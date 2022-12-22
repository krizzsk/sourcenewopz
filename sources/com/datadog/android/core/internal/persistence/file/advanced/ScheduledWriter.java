package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.log.Logger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0014B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ScheduledWriter;", "T", "", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "delegateWriter", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/persistence/DataWriter;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/log/Logger;)V", "getDelegateWriter$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/DataWriter;", "getExecutorService$dd_sdk_android_release", "()Ljava/util/concurrent/ExecutorService;", "write", "", "element", "(Ljava/lang/Object;)V", "data", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScheduledWriter.kt */
public final class ScheduledWriter<T> implements DataWriter<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_REJECTED = "Unable to schedule writing on the executor";

    /* renamed from: a */
    private final DataWriter<T> f3538a;

    /* renamed from: b */
    private final ExecutorService f3539b;

    /* renamed from: c */
    private final Logger f3540c;

    public ScheduledWriter(DataWriter<T> dataWriter, ExecutorService executorService, Logger logger) {
        Intrinsics.checkNotNullParameter(dataWriter, "delegateWriter");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3538a = dataWriter;
        this.f3539b = executorService;
        this.f3540c = logger;
    }

    public final DataWriter<T> getDelegateWriter$dd_sdk_android_release() {
        return this.f3538a;
    }

    public final ExecutorService getExecutorService$dd_sdk_android_release() {
        return this.f3539b;
    }

    public void write(T t) {
        Intrinsics.checkNotNullParameter(t, "element");
        try {
            this.f3539b.submit(new Runnable(t) {
                public final /* synthetic */ Object f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ScheduledWriter.m2342a(ScheduledWriter.this, this.f$1);
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.e$default(this.f3540c, ERROR_REJECTED, e, (Map) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2342a(ScheduledWriter scheduledWriter, Object obj) {
        Intrinsics.checkNotNullParameter(scheduledWriter, "this$0");
        Intrinsics.checkNotNullParameter(obj, "$element");
        scheduledWriter.getDelegateWriter$dd_sdk_android_release().write(obj);
    }

    public void write(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        try {
            this.f3539b.submit(new Runnable(list) {
                public final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ScheduledWriter.m2343a(ScheduledWriter.this, this.f$1);
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.e$default(this.f3540c, ERROR_REJECTED, e, (Map) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2343a(ScheduledWriter scheduledWriter, List list) {
        Intrinsics.checkNotNullParameter(scheduledWriter, "this$0");
        Intrinsics.checkNotNullParameter(list, "$data");
        scheduledWriter.getDelegateWriter$dd_sdk_android_release().write(list);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ScheduledWriter$Companion;", "", "()V", "ERROR_REJECTED", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ScheduledWriter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
