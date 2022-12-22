package com.didichuxing.dfbasesdk.ottoevent;

public class H5AppealDoneEvent {

    /* renamed from: a */
    private int f46662a;
    public final int code;
    public final String msg;

    public H5AppealDoneEvent(int i, String str) {
        this.code = i;
        this.msg = str;
        m33512a(i);
    }

    /* renamed from: a */
    private void m33512a(int i) {
        if (i == 100000) {
            this.f46662a = 1;
        } else if (i == 100004) {
            this.f46662a = 2;
        } else {
            this.f46662a = 3;
        }
    }

    public int getStatus() {
        return this.f46662a;
    }
}
