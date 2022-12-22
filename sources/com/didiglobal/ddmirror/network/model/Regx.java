package com.didiglobal.ddmirror.network.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/model/Regx;", "", "keyPath", "", "regex", "useAsExtraAttr", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getKeyPath", "()Ljava/lang/String;", "setKeyPath", "(Ljava/lang/String;)V", "getRegex", "setRegex", "getUseAsExtraAttr", "()Ljava/lang/Integer;", "setUseAsExtraAttr", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didiglobal/ddmirror/network/model/Regx;", "equals", "", "other", "hashCode", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NetConfig.kt */
public final class Regx {
    private String keyPath;
    private String regex;
    private Integer useAsExtraAttr;

    public static /* synthetic */ Regx copy$default(Regx regx, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = regx.keyPath;
        }
        if ((i & 2) != 0) {
            str2 = regx.regex;
        }
        if ((i & 4) != 0) {
            num = regx.useAsExtraAttr;
        }
        return regx.copy(str, str2, num);
    }

    public final String component1() {
        return this.keyPath;
    }

    public final String component2() {
        return this.regex;
    }

    public final Integer component3() {
        return this.useAsExtraAttr;
    }

    public final Regx copy(String str, String str2, Integer num) {
        return new Regx(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Regx)) {
            return false;
        }
        Regx regx = (Regx) obj;
        return Intrinsics.areEqual((Object) this.keyPath, (Object) regx.keyPath) && Intrinsics.areEqual((Object) this.regex, (Object) regx.regex) && Intrinsics.areEqual((Object) this.useAsExtraAttr, (Object) regx.useAsExtraAttr);
    }

    public int hashCode() {
        String str = this.keyPath;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.regex;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.useAsExtraAttr;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Regx(keyPath=" + this.keyPath + ", regex=" + this.regex + ", useAsExtraAttr=" + this.useAsExtraAttr + ")";
    }

    public Regx(String str, String str2, Integer num) {
        this.keyPath = str;
        this.regex = str2;
        this.useAsExtraAttr = num;
    }

    public final String getKeyPath() {
        return this.keyPath;
    }

    public final void setKeyPath(String str) {
        this.keyPath = str;
    }

    public final String getRegex() {
        return this.regex;
    }

    public final void setRegex(String str) {
        this.regex = str;
    }

    public final Integer getUseAsExtraAttr() {
        return this.useAsExtraAttr;
    }

    public final void setUseAsExtraAttr(Integer num) {
        this.useAsExtraAttr = num;
    }
}
