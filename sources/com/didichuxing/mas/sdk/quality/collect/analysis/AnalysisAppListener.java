package com.didichuxing.mas.sdk.quality.collect.analysis;

import android.app.Application;
import com.didichuxing.mas.sdk.quality.report.analysis.AsyncWorker;

public class AnalysisAppListener {
    public static void whenAppStart(Application application) {
        AsyncWorker.doAsyncInit(application);
    }
}
