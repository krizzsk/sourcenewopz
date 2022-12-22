package com.kwai.koom.javaoom.analysis;

import android.app.Application;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import com.kwai.koom.javaoom.analysis.IPCReceiver;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;

public class HeapAnalyzeService extends IntentService {

    /* renamed from: a */
    static final /* synthetic */ boolean f55547a = (!HeapAnalyzeService.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final String f55548b = "HeapAnalyzeService";

    /* renamed from: c */
    private ResultReceiver f55549c;

    /* renamed from: d */
    private C20312a f55550d;

    public HeapAnalyzeService() {
        super(f55548b);
    }

    public HeapAnalyzeService(String str) {
        super(str);
    }

    public static void runAnalysis(Application application, HeapAnalysisListener heapAnalysisListener) {
        KLog.m40102i(f55548b, "runAnalysis startService");
        Intent intent = new Intent(application, HeapAnalyzeService.class);
        intent.putExtra("receiver", m40075a(heapAnalysisListener));
        intent.putExtra(KConstants.ServiceIntent.HEAP_FILE, KHeapFile.getKHeapFile());
        application.startService(intent);
    }

    /* renamed from: a */
    private static IPCReceiver m40075a(final HeapAnalysisListener heapAnalysisListener) {
        return new IPCReceiver(new IPCReceiver.ReceiverCallback() {
            public void onSuccess() {
                KLog.m40102i(HeapAnalyzeService.f55548b, "IPC call back, heap analysis success");
                heapAnalysisListener.onHeapAnalyzed();
            }

            public void onError() {
                KLog.m40102i(HeapAnalyzeService.f55548b, "IPC call back, heap analysis failed");
                heapAnalysisListener.onHeapAnalyzeFailed();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        boolean z;
        KLog.m40102i(f55548b, "start analyze pid:" + Process.myPid());
        try {
            m40076a(intent);
            z = m40077a();
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        ResultReceiver resultReceiver = this.f55549c;
        if (resultReceiver != null) {
            resultReceiver.send(z ? 1001 : 1002, (Bundle) null);
        }
    }

    /* renamed from: a */
    private void m40076a(Intent intent) {
        if (f55547a || intent != null) {
            this.f55549c = (ResultReceiver) intent.getParcelableExtra("receiver");
            KHeapFile kHeapFile = (KHeapFile) intent.getParcelableExtra(KConstants.ServiceIntent.HEAP_FILE);
            KHeapFile.buildInstance(kHeapFile);
            if (f55547a || kHeapFile != null) {
                this.f55550d = new C20312a(kHeapFile);
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private boolean m40077a() {
        return this.f55550d.mo164755a();
    }
}
