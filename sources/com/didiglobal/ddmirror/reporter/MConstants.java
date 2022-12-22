package com.didiglobal.ddmirror.reporter;

import com.didi.sdk.monitor.TrackerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/reporter/MConstants;", "", "()V", "OMEGA_TECH_EVENT_PEFIX", "", "getOMEGA_TECH_EVENT_PEFIX", "()Ljava/lang/String;", "setOMEGA_TECH_EVENT_PEFIX", "(Ljava/lang/String;)V", "ErrType", "UiErrType", "DDMirrorReporter_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: MConstants.kt */
public final class MConstants {
    public static final MConstants INSTANCE = new MConstants();
    private static String OMEGA_TECH_EVENT_PEFIX = TrackerConstants.OMEGA_TECH_EVENT_PEFIX;

    private MConstants() {
    }

    public final String getOMEGA_TECH_EVENT_PEFIX() {
        return OMEGA_TECH_EVENT_PEFIX;
    }

    public final void setOMEGA_TECH_EVENT_PEFIX(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        OMEGA_TECH_EVENT_PEFIX = str;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/reporter/MConstants$ErrType;", "", "()V", "CANCEL_ERROR", "", "CODE_ERROR", "DEFAULT", "DEFAULT_ERROR", "EMPTY_DATA", "JSON_ERROR", "NET_ERROR", "SEVER_ERROR", "DDMirrorReporter_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: MConstants.kt */
    public static final class ErrType {
        public static final int CANCEL_ERROR = 5;
        public static final int CODE_ERROR = 6;
        public static final int DEFAULT = -1;
        public static final int DEFAULT_ERROR = 4;
        public static final int EMPTY_DATA = 1;
        public static final ErrType INSTANCE = new ErrType();
        public static final int JSON_ERROR = 3;
        public static final int NET_ERROR = 0;
        public static final int SEVER_ERROR = 2;

        private ErrType() {
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/reporter/MConstants$UiErrType;", "", "()V", "ELEMENT_LOST", "", "RULE_UN_MATCH", "UN_ENABLED", "DDMirrorReporter_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: MConstants.kt */
    public static final class UiErrType {
        public static final int ELEMENT_LOST = 2;
        public static final UiErrType INSTANCE = new UiErrType();
        public static final int RULE_UN_MATCH = 1;
        public static final int UN_ENABLED = 3;

        private UiErrType() {
        }
    }
}
