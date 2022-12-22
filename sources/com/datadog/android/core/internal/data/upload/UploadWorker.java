package com.datadog.android.core.internal.data.upload;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.datadog.android.Datadog;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.net.UploadStatus;
import com.datadog.android.core.internal.persistence.Batch;
import com.datadog.android.core.internal.persistence.DataReader;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.error.internal.CrashReportsFeature;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.tracing.internal.TracesFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0014"}, mo175978d2 = {"Lcom/datadog/android/core/internal/data/upload/UploadWorker;", "Landroidx/work/Worker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "consumeBatch", "", "batch", "Lcom/datadog/android/core/internal/persistence/Batch;", "uploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "doWork", "Landroidx/work/ListenableWorker$Result;", "uploadAllBatches", "", "reader", "Lcom/datadog/android/core/internal/persistence/DataReader;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UploadWorker.kt */
public final class UploadWorker extends Worker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f3466a = "UploadWorker";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    public ListenableWorker.Result doWork() {
        if (!Datadog.isInitialized()) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), Datadog.MESSAGE_NOT_INITIALIZED, (Throwable) null, (Map) null, 6, (Object) null);
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            return success;
        }
        m2316a(CrashReportsFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getReader(), CrashReportsFeature.INSTANCE.getUploader$dd_sdk_android_release());
        m2316a(LogsFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getReader(), LogsFeature.INSTANCE.getUploader$dd_sdk_android_release());
        m2316a(TracesFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getReader(), TracesFeature.INSTANCE.getUploader$dd_sdk_android_release());
        m2316a(RumFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getReader(), RumFeature.INSTANCE.getUploader$dd_sdk_android_release());
        ListenableWorker.Result success2 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success2, "success()");
        return success2;
    }

    /* renamed from: a */
    private final void m2316a(DataReader dataReader, DataUploader dataUploader) {
        Batch lockAndReadNext;
        List<Batch> arrayList = new ArrayList<>();
        do {
            lockAndReadNext = dataReader.lockAndReadNext();
            if (lockAndReadNext != null) {
                if (m2317a(lockAndReadNext, dataUploader)) {
                    dataReader.drop(lockAndReadNext);
                    continue;
                } else {
                    arrayList.add(lockAndReadNext);
                    continue;
                }
            }
        } while (lockAndReadNext != null);
        for (Batch release : arrayList) {
            dataReader.release(release);
        }
    }

    /* renamed from: a */
    private final boolean m2317a(Batch batch, DataUploader dataUploader) {
        UploadStatus upload = dataUploader.upload(batch.getData());
        String simpleName = dataUploader.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "uploader.javaClass.simpleName");
        UploadStatus uploadStatus = upload;
        UploadStatus.logStatus$default(uploadStatus, simpleName, batch.getData().length, RuntimeUtilsKt.getDevLogger(), false, (String) null, 16, (Object) null);
        String simpleName2 = dataUploader.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "uploader.javaClass.simpleName");
        UploadStatus.logStatus$default(uploadStatus, simpleName2, batch.getData().length, RuntimeUtilsKt.getSdkLogger(), true, (String) null, 16, (Object) null);
        return upload == UploadStatus.SUCCESS;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/core/internal/data/upload/UploadWorker$Companion;", "", "()V", "TAG", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: UploadWorker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
