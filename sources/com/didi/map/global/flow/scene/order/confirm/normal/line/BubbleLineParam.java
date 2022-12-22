package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.map.global.flow.scene.order.confirm.normal.LineMode;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.sdk.address.address.entity.Address;

public class BubbleLineParam {

    /* renamed from: a */
    private CommonLineParam f26670a;

    /* renamed from: b */
    private Address f26671b;

    /* renamed from: c */
    private Address f26672c;

    /* renamed from: d */
    private LineMode f26673d;

    /* renamed from: e */
    private String f26674e;

    /* renamed from: f */
    private int f26675f;

    public BubbleLineParam(CommonLineParam commonLineParam, Address address, Address address2, LineMode lineMode, String str, int i) {
        this.f26670a = commonLineParam;
        this.f26671b = address;
        this.f26672c = address2;
        this.f26673d = lineMode;
        this.f26674e = str;
        this.f26675f = i;
    }

    public CommonLineParam getCommonLineParam() {
        return this.f26670a;
    }

    public Address getStartAddress() {
        return this.f26671b;
    }

    public Address getEndAddress() {
        return this.f26672c;
    }

    public LineMode getLineMode() {
        return this.f26673d;
    }

    public String getBubbleId() {
        return this.f26674e;
    }

    public int getBizGroup() {
        return this.f26675f;
    }

    public String toString() {
        return "BubbleLineParam{commonLineParam=" + this.f26670a + ", startAddress=" + this.f26671b + ", endAddress=" + this.f26672c + ", lineMode=" + this.f26673d + ", bubbleId='" + this.f26674e + '\'' + ", bizGroup=" + this.f26675f + '}';
    }
}
