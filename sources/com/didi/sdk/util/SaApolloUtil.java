package com.didi.sdk.util;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/sdk/util/SaApolloUtil;", "", "()V", "isSaOne", "", "saOneType", "", "saType", "showSaUserTab", "getSaOneState", "getSaOneTypeValue", "getSaState", "getSaType", "Lcom/didi/sdk/util/SaApolloUtil$SaType;", "getSaTypeValue", "getSaUserTabShow", "setSaOneState", "", "setSaOneType", "type", "setSaType", "setShowSaUserTab", "show", "SaType", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SaApolloUtil.kt */
public final class SaApolloUtil {
    public static final SaApolloUtil INSTANCE = new SaApolloUtil();

    /* renamed from: a */
    private static int f37683a;

    /* renamed from: b */
    private static int f37684b;

    /* renamed from: c */
    private static boolean f37685c;

    /* renamed from: d */
    private static boolean f37686d = true;

    private SaApolloUtil() {
    }

    public final boolean getSaState() {
        SaType saType = getSaType();
        boolean z = saType == SaType.SA_NONE || saType == SaType.SA_NONE_CONTROL;
        if (f37684b == 0) {
            return false;
        }
        if (!z || getSaOneState()) {
            return true;
        }
        return false;
    }

    public final boolean getSaOneState() {
        return f37685c;
    }

    public final void setSaOneState(boolean z) {
        f37685c = z;
    }

    public final void setShowSaUserTab(boolean z) {
        f37686d = z;
    }

    public final void setSaType(int i) {
        f37683a = i;
    }

    public final void setSaOneType(int i) {
        f37684b = i;
    }

    public final int getSaTypeValue() {
        return f37683a;
    }

    public final int getSaOneTypeValue() {
        return f37684b;
    }

    public final SaType getSaType() {
        int i;
        if (f37685c) {
            i = f37684b;
        } else {
            i = f37683a;
        }
        if (i == -1) {
            return SaType.SA_NONE_CONTROL;
        }
        if (i == 0) {
            return SaType.SA_NONE;
        }
        if (i == 1) {
            return SaType.SA_A;
        }
        if (i == 2) {
            return SaType.SA_B;
        }
        if (i != 3) {
            return SaType.SA_NONE;
        }
        return SaType.SA_C;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/sdk/util/SaApolloUtil$SaType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "SA_NONE_CONTROL", "SA_NONE", "SA_A", "SA_B", "SA_C", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: SaApolloUtil.kt */
    public enum SaType {
        SA_NONE_CONTROL(-1),
        SA_NONE(0),
        SA_A(1),
        SA_B(2),
        SA_C(3);
        
        private int type;

        private SaType(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }
    }

    public final boolean getSaUserTabShow() {
        return getSaOneState() && f37686d;
    }
}
