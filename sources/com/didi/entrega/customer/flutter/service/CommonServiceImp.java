package com.didi.entrega.customer.flutter.service;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.uni_entrega_business.common.GLEUniCommonService;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/service/CommonServiceImp;", "Lcom/didi/entrega/uni_entrega_business/common/GLEUniCommonService;", "()V", "showToast", "", "msg", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonServiceImp.kt */
public final class CommonServiceImp implements GLEUniCommonService {
    public void showToast(String str) {
        ToastUtil.showCustomerToast((ScopeContext) null, str);
    }
}
