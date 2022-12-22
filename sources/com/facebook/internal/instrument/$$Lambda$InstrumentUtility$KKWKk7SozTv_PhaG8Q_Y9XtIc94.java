package com.facebook.internal.instrument;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.instrument.-$$Lambda$InstrumentUtility$KKWKk7SozTv_PhaG8Q_Y9XtIc94  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$InstrumentUtility$KKWKk7SozTv_PhaG8Q_Y9XtIc94 implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$InstrumentUtility$KKWKk7SozTv_PhaG8Q_Y9XtIc94 INSTANCE = new $$Lambda$InstrumentUtility$KKWKk7SozTv_PhaG8Q_Y9XtIc94();

    private /* synthetic */ $$Lambda$InstrumentUtility$KKWKk7SozTv_PhaG8Q_Y9XtIc94() {
    }

    public final boolean accept(File file, String str) {
        return InstrumentUtility.m47409listExceptionAnalysisReportFiles$lambda2(file, str);
    }
}
