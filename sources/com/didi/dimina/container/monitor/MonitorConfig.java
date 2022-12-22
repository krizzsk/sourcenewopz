package com.didi.dimina.container.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/dimina/container/monitor/MonitorConfig;", "", "tagName", "", "isPrintLog", "", "(Ljava/lang/String;Z)V", "()Z", "setPrintLog", "(Z)V", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "changeTag", "", "newTagName", "openLog", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: MonitorConfig.kt */
public final class MonitorConfig {

    /* renamed from: a */
    private String f16956a;

    /* renamed from: b */
    private boolean f16957b;

    public MonitorConfig(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "tagName");
        this.f16956a = str;
        this.f16957b = z;
    }

    public final String getTagName() {
        return this.f16956a;
    }

    public final boolean isPrintLog() {
        return this.f16957b;
    }

    public final void setPrintLog(boolean z) {
        this.f16957b = z;
    }

    public final void setTagName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f16956a = str;
    }

    public final void openLog() {
        this.f16957b = true;
    }

    public final void changeTag(String str) {
        Intrinsics.checkParameterIsNotNull(str, "newTagName");
        this.f16956a = str;
    }
}
