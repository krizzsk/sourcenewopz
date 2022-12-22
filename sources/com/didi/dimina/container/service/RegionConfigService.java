package com.didi.dimina.container.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/dimina/container/service/RegionConfigService;", "", "()V", "state", "Lcom/didi/dimina/container/service/RegionConfigService$RegionState;", "getState", "()Lcom/didi/dimina/container/service/RegionConfigService$RegionState;", "setState", "(Lcom/didi/dimina/container/service/RegionConfigService$RegionState;)V", "getDiminaMonitorHttpConfigHost", "", "getDiminaMonitorHttpHost", "getDiminaMonitorWssHost", "isInternational", "", "()Ljava/lang/Boolean;", "RegionState", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RegionConfigService.kt */
public class RegionConfigService {
    private RegionState state = RegionState.DEFAULT;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/dimina/container/service/RegionConfigService$RegionState;", "", "(Ljava/lang/String;I)V", "DEFAULT", "NATIONAL_OK", "INTERNATIONAL_OK", "NATIONAL_INIT_FAIL", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RegionConfigService.kt */
    public enum RegionState {
        DEFAULT,
        NATIONAL_OK,
        INTERNATIONAL_OK,
        NATIONAL_INIT_FAIL
    }

    public String getDiminaMonitorHttpConfigHost() {
        return null;
    }

    public String getDiminaMonitorHttpHost() {
        return null;
    }

    public String getDiminaMonitorWssHost() {
        return null;
    }

    public Boolean isInternational() {
        return null;
    }

    public RegionState getState() {
        return this.state;
    }

    public void setState(RegionState regionState) {
        Intrinsics.checkParameterIsNotNull(regionState, "<set-?>");
        this.state = regionState;
    }
}
