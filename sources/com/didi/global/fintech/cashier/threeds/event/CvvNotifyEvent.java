package com.didi.global.fintech.cashier.threeds.event;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/event/CvvNotifyEvent;", "Ljava/io/Serializable;", "cvv", "", "(Ljava/lang/String;)V", "getCvv", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CvvNotifyEvent.kt */
public final class CvvNotifyEvent implements Serializable {
    private final String cvv;

    public static /* synthetic */ CvvNotifyEvent copy$default(CvvNotifyEvent cvvNotifyEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cvvNotifyEvent.cvv;
        }
        return cvvNotifyEvent.copy(str);
    }

    public final String component1() {
        return this.cvv;
    }

    public final CvvNotifyEvent copy(String str) {
        return new CvvNotifyEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CvvNotifyEvent) && Intrinsics.areEqual((Object) this.cvv, (Object) ((CvvNotifyEvent) obj).cvv);
    }

    public int hashCode() {
        String str = this.cvv;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "CvvNotifyEvent(cvv=" + this.cvv + VersionRange.RIGHT_OPEN;
    }

    public CvvNotifyEvent(String str) {
        this.cvv = str;
    }

    public final String getCvv() {
        return this.cvv;
    }
}
