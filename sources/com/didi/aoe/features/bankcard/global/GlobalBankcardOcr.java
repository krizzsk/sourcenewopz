package com.didi.aoe.features.bankcard.global;

import android.content.Context;
import com.didi.aoe.extensions.biz.common.stat.StatExtKt;
import com.didi.aoe.features.bankcard.global.domain.BankcardInputData;
import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import com.didi.aoe.library.core.AoeClient;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J0\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u00102\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016J8\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/aoe/features/bankcard/global/GlobalBankcardOcr;", "Lcom/didi/aoe/features/bankcard/global/BankcardInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MODEL_TAG", "", "getContext", "()Landroid/content/Context;", "mClient", "Lcom/didi/aoe/library/core/AoeClient;", "mLogger", "Lcom/didi/aoe/library/logging/Logger;", "destory", "", "init", "", "process", "imageData", "", "imageWidth", "imageHeight", "result", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "imageType", "imageDegree", "global-ocr_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GlobalBankcardOcr.kt */
public final class GlobalBankcardOcr implements BankcardInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f8150a;

    /* renamed from: b */
    private final String f8151b = "id-GlobalBankcardOcr";

    /* renamed from: c */
    private final AoeClient f8152c = new AoeClient(this.f8153d, "id-GlobalBankcardOcr", new AoeClient.Options().setInterpreter(GlobalBankOcrInterceptor.class).useRemoteService(false), "bank_ocr_global_card_detect", "bank_ocr_global_num_detect", "bank_ocr_global_num_recognize");

    /* renamed from: d */
    private final Context f8153d;

    public GlobalBankcardOcr(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f8153d = context;
        Logger logger = LoggerFactory.getLogger("GlobalBankcardOcr");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(\"GlobalBankcardOcr\")");
        this.f8150a = logger;
    }

    public final Context getContext() {
        return this.f8153d;
    }

    public int init() {
        this.f8152c.init(new GlobalBankcardOcr$init$1(this));
        StatExtKt.statReport(com.didi.aoe.features.bankcard.global.stat.StatExtKt.STAT_EVENT_INIT, StatExtKt.getSTAT_KEY_MODULE_TAG(), this.f8151b);
        return this.f8152c.isRunning() ? 1 : 0;
    }

    public int process(byte[] bArr, int i, int i2, DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(bArr, "imageData");
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "result");
        return process(bArr, 1, i, i2, 90, detectCardInfo);
    }

    public int process(byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(bArr, "imageData");
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "result");
        Object process = this.f8152c.process(new BankcardInputData(bArr, i, i2, i3, i4, detectCardInfo));
        StatExtKt.statReport(com.didi.aoe.features.bankcard.global.stat.StatExtKt.STAT_EVENT_PROCESS, com.didi.aoe.features.bankcard.global.stat.StatExtKt.generalStatInfo(detectCardInfo));
        return process == null ? 1 : 0;
    }

    public void destory() {
        this.f8152c.release();
        StatExtKt.statReport(com.didi.aoe.features.bankcard.global.stat.StatExtKt.STAT_EVENT_RELEASE, StatExtKt.getSTAT_KEY_MODULE_TAG(), this.f8151b);
    }
}
