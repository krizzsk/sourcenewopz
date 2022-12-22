package com.didi.flutter.nacho;

import java.util.ArrayList;
import java.util.List;

public class EngineOption {

    /* renamed from: a */
    boolean f21077a;

    /* renamed from: b */
    String f21078b;

    /* renamed from: c */
    List<String> f21079c = new ArrayList();

    /* renamed from: d */
    boolean f21080d = false;

    public EngineOption createByGroup(boolean z) {
        this.f21080d = z;
        return this;
    }

    public EngineOption(String str) {
        this.f21078b = str;
    }

    public EngineOption addArg(String str) {
        this.f21079c.add(str);
        return this;
    }

    public EngineOption addArgs(List<String> list) {
        this.f21079c.addAll(list);
        return this;
    }

    public EngineOption enableBufferingIncomingMessages(boolean z) {
        this.f21077a = z;
        return this;
    }
}
