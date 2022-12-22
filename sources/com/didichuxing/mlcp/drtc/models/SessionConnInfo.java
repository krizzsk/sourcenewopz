package com.didichuxing.mlcp.drtc.models;

import android.util.Base64;
import java.io.Serializable;

public class SessionConnInfo implements Serializable {
    private String connSvr;
    private String icePolicy;
    private String sessionID;
    private String turnPwd;
    private String turnSvr;
    private String turnUsr;

    /* renamed from: a */
    public String mo118972a() {
        return this.connSvr;
    }

    /* renamed from: b */
    public String mo118973b() {
        return new String(Base64.decode(this.turnPwd, 0));
    }

    /* renamed from: c */
    public String mo118974c() {
        return this.turnSvr;
    }

    /* renamed from: d */
    public String mo118975d() {
        return new String(Base64.decode(this.turnUsr, 0));
    }
}
