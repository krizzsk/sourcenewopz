package com.appsflyer.internal.model.event;

import android.content.Context;
import com.appsflyer.AFEvent;
import com.appsflyer.AFHelper;

public abstract class BackgroundEvent extends AFEvent {

    /* renamed from: ɪ */
    private final boolean f2003;

    /* renamed from: ɾ */
    private boolean f2004;

    /* renamed from: ӏ */
    private final boolean f2005;

    BackgroundEvent() {
        this((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundEvent(String str, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z = true;
        this.f2003 = bool != null ? bool.booleanValue() : true;
        this.f2005 = bool2 != null ? bool2.booleanValue() : z;
    }

    public BackgroundEvent trackingStopped(boolean z) {
        this.f2004 = z;
        return this;
    }

    public boolean trackingStopped() {
        return this.f2004;
    }

    public boolean readResponse() {
        return this.f2003;
    }

    public boolean proxyMode() {
        return this.f2005;
    }

    public String body() {
        return AFHelper.convertToJsonObject(params()).toString();
    }
}
