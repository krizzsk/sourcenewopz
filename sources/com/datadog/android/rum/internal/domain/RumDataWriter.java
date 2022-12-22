package com.datadog.android.rum.internal.domain;

import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileDataWriter;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.EventType;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.google.firebase.messaging.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001d\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0010¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0019H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/RumDataWriter;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileDataWriter;", "", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "serializer", "Lcom/datadog/android/core/internal/persistence/Serializer;", "decoration", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "handler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "internalLogger", "Lcom/datadog/android/log/Logger;", "lastViewEventFile", "Ljava/io/File;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/Serializer;Lcom/datadog/android/core/internal/persistence/PayloadDecoration;Lcom/datadog/android/core/internal/persistence/file/FileHandler;Lcom/datadog/android/log/Logger;Ljava/io/File;)V", "notifyEventSent", "", "viewId", "", "eventType", "Lcom/datadog/android/rum/internal/monitor/EventType;", "onDataWritten", "data", "rawData", "", "onDataWritten$dd_sdk_android_release", "persistViewEvent", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumDataWriter.kt */
public final class RumDataWriter extends BatchFileDataWriter<Object> {

    /* renamed from: a */
    private final File f3693a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RumDataWriter(FileOrchestrator fileOrchestrator, Serializer<Object> serializer, PayloadDecoration payloadDecoration, FileHandler fileHandler, Logger logger, File file) {
        super(fileOrchestrator, serializer, payloadDecoration, fileHandler, logger);
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(payloadDecoration, "decoration");
        Intrinsics.checkNotNullParameter(fileHandler, "handler");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        Intrinsics.checkNotNullParameter(file, "lastViewEventFile");
        this.f3693a = file;
    }

    public void onDataWritten$dd_sdk_android_release(Object obj, byte[] bArr) {
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(bArr, Constants.MessagePayloadKeys.RAW_DATA);
        if (obj instanceof ViewEvent) {
            m2411a(bArr);
        } else if (obj instanceof ActionEvent) {
            m2410a(((ActionEvent) obj).getView().getId(), EventType.ACTION);
        } else if (obj instanceof ResourceEvent) {
            m2410a(((ResourceEvent) obj).getView().getId(), EventType.RESOURCE);
        } else if (obj instanceof ErrorEvent) {
            ErrorEvent errorEvent = (ErrorEvent) obj;
            if (!Intrinsics.areEqual((Object) errorEvent.getError().isCrash(), (Object) true)) {
                m2410a(errorEvent.getView().getId(), EventType.ERROR);
            }
        } else if (obj instanceof LongTaskEvent) {
            LongTaskEvent longTaskEvent = (LongTaskEvent) obj;
            if (Intrinsics.areEqual((Object) longTaskEvent.getLongTask().isFrozenFrame(), (Object) true)) {
                m2410a(longTaskEvent.getView().getId(), EventType.FROZEN_FRAME);
            } else {
                m2410a(longTaskEvent.getView().getId(), EventType.LONG_TASK);
            }
        }
    }

    /* renamed from: a */
    private final void m2411a(byte[] bArr) {
        FileHandler.DefaultImpls.writeData$default(getHandler$dd_sdk_android_release(), this.f3693a, bArr, false, (byte[]) null, 12, (Object) null);
    }

    /* renamed from: a */
    private final void m2410a(String str, EventType eventType) {
        RumMonitor rumMonitor = GlobalRum.get();
        if (rumMonitor instanceof AdvancedRumMonitor) {
            ((AdvancedRumMonitor) rumMonitor).eventSent(str, eventType);
        }
    }
}
