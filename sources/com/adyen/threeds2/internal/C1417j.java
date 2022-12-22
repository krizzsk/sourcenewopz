package com.adyen.threeds2.internal;

import com.adyen.threeds2.Warning;

/* renamed from: com.adyen.threeds2.internal.j */
public final class C1417j implements Warning {

    /* renamed from: a */
    private final String f1041a;

    /* renamed from: b */
    private final String f1042b;

    /* renamed from: c */
    private final Warning.Severity f1043c;

    public C1417j(String str, String str2, Warning.Severity severity) {
        this.f1041a = str;
        this.f1042b = str2;
        this.f1043c = severity;
    }

    public String getID() {
        return this.f1041a;
    }

    public String getMessage() {
        return this.f1042b;
    }

    public Warning.Severity getSeverity() {
        return this.f1043c;
    }
}
