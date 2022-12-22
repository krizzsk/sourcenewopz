package com.didiglobal.p205sa.biz.delegate;

import com.didi.app.delegate.IBusinessParamsService;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider(alias = "sa_home", value = {IBusinessParamsService.class})
@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/delegate/SaIndexBusinessParamsService;", "Lcom/didi/app/delegate/IBusinessParamsService;", "()V", "getProductId", "", "getTripCityId", "", "getTripCountry", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaIndexBusinessParamsService */
/* compiled from: SaIndexBusinessParamsService.kt */
public final class SaIndexBusinessParamsService implements IBusinessParamsService {
    public int getProductId() {
        return 30008;
    }

    public String getTripCityId() {
        return NationTypeUtil.getNationComponentData().getCityId();
    }

    public String getTripCountry() {
        return NationTypeUtil.getNationComponentData().getLocCountry();
    }
}
