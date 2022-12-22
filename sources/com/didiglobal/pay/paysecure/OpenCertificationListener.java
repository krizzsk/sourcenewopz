package com.didiglobal.pay.paysecure;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/OpenCertificationListener;", "", "openCert", "", "activity", "Landroid/app/Activity;", "checkType", "", "params", "source", "", "scene", "resultListener", "Lcom/didiglobal/pay/paysecure/CertificationResultListener;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Listener.kt */
public interface OpenCertificationListener {
    void openCert(Activity activity, String str, String str2, int i, String str3, CertificationResultListener certificationResultListener);
}
