package com.didi.global.fintech.cashier.fastpay.api;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0006H&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayOperateProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "dismissLoading", "", "loading", "cancelable", "", "duration", "", "toast", "message", "", "success", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayOperateProcessor.kt */
public interface IFastPayOperateProcessor extends IFastPayBaseProcessor {
    void dismissLoading();

    void loading(boolean z, long j);

    void toast(String str, boolean z);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IFastPayOperateProcessor.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void loading$default(IFastPayOperateProcessor iFastPayOperateProcessor, boolean z, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    j = 0;
                }
                iFastPayOperateProcessor.loading(z, j);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loading");
        }

        public static /* synthetic */ void toast$default(IFastPayOperateProcessor iFastPayOperateProcessor, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                iFastPayOperateProcessor.toast(str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toast");
        }
    }
}
