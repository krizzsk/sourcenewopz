package com.didi.dimina.config.national;

import com.didi.dimina.container.service.RegionConfigService;
import com.didi.dimina.container.util.DomainComplianceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/dimina/config/national/InternationalConfig;", "Lcom/didi/dimina/container/service/RegionConfigService;", "()V", "state", "Lcom/didi/dimina/container/service/RegionConfigService$RegionState;", "getState", "()Lcom/didi/dimina/container/service/RegionConfigService$RegionState;", "setState", "(Lcom/didi/dimina/container/service/RegionConfigService$RegionState;)V", "getDiminaMonitorHttpConfigHost", "", "getDiminaMonitorHttpHost", "getDiminaMonitorWssHost", "isInternational", "", "()Ljava/lang/Boolean;", "config-international_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: InternationalConfig.kt */
public final class InternationalConfig extends RegionConfigService {
    private RegionConfigService.RegionState state = RegionConfigService.RegionState.INTERNATIONAL_OK;

    public RegionConfigService.RegionState getState() {
        return this.state;
    }

    public void setState(RegionConfigService.RegionState regionState) {
        Intrinsics.checkParameterIsNotNull(regionState, "<set-?>");
        this.state = regionState;
    }

    public String getDiminaMonitorHttpHost() {
        return DomainComplianceUtil.Companion.getHttpsColonDoubleSlash() + "kaleido.didiglobal.com/saga-track";
    }

    public String getDiminaMonitorWssHost() {
        return DomainComplianceUtil.Companion.getWssColonDoubleSlash() + "kaleido.didiglobal.com/";
    }

    public String getDiminaMonitorHttpConfigHost() {
        return DomainComplianceUtil.Companion.getWssColonDoubleSlash() + "kaleido.didiglobal.com/getTrackConfig";
    }

    public Boolean isInternational() {
        return true;
    }
}
