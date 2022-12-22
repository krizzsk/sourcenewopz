package com.datadog.android.rum.internal.ndk;

import android.content.Context;
import com.datadog.android.core.internal.net.info.NetworkInfoSerializer;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileMigrator;
import com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.single.SingleFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.single.SingleItemDataWriter;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.log.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/ndk/NdkNetworkInfoDataWriter;", "Lcom/datadog/android/core/internal/persistence/file/single/SingleItemDataWriter;", "Lcom/datadog/android/core/model/NetworkInfo;", "context", "Landroid/content/Context;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "executorService", "Ljava/util/concurrent/ExecutorService;", "fileHandler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Landroid/content/Context;Lcom/datadog/android/core/internal/privacy/ConsentProvider;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/core/internal/persistence/file/FileHandler;Lcom/datadog/android/log/Logger;)V", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NdkNetworkInfoDataWriter.kt */
public final class NdkNetworkInfoDataWriter extends SingleItemDataWriter<NetworkInfo> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NdkNetworkInfoDataWriter(Context context, ConsentProvider consentProvider, ExecutorService executorService, FileHandler fileHandler, Logger logger) {
        super(new ConsentAwareFileOrchestrator(consentProvider, new SingleFileOrchestrator(DatadogNdkCrashHandler.Companion.getPendingNetworkInfoFile$dd_sdk_android_release(context)), new SingleFileOrchestrator(DatadogNdkCrashHandler.Companion.getGrantedNetworkInfoFile$dd_sdk_android_release(context)), new ConsentAwareFileMigrator(fileHandler, executorService, logger)), new NetworkInfoSerializer(), fileHandler, logger);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(fileHandler, "fileHandler");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
    }
}
