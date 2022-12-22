package com.dmap.navigation.engine.event;

public final class VoiceEvent extends NaviEvent {

    /* renamed from: a */
    private final String f51983a;

    /* renamed from: b */
    private final String f51984b;

    /* renamed from: c */
    private final int f51985c;

    /* renamed from: d */
    private final int f51986d;

    /* renamed from: e */
    private final int f51987e;

    /* renamed from: f */
    private final int f51988f;

    /* renamed from: g */
    private final int f51989g;

    /* renamed from: h */
    private final int f51990h;

    /* renamed from: i */
    private final int f51991i;

    public VoiceEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f51983a = str;
        this.f51984b = str2;
        this.f51985c = i;
        this.f51986d = i2;
        this.f51987e = i3;
        this.f51988f = i4;
        this.f51989g = i5;
        this.f51990h = i6;
        this.f51991i = i7;
    }

    public final String toString() {
        return "VoiceEvent{eventId='" + this.f51983a + '\'' + ", text='" + this.f51984b + '\'' + ", prefix=" + this.f51985c + ", priority=" + this.f51986d + ", type=" + this.f51987e + ", voiceType=" + this.f51988f + ", subType=" + this.f51989g + ", distanceKind=" + this.f51990h + ", eventIdRaw=" + this.f51991i + '}';
    }

    public final String getEventId() {
        return this.f51983a;
    }

    public final String getText() {
        return this.f51984b;
    }

    public final int getPrefix() {
        return this.f51985c;
    }

    public final int getPriority() {
        return this.f51986d;
    }

    public final int getType() {
        return this.f51987e;
    }

    public final int getVoiceType() {
        return this.f51988f;
    }

    public final int getSubType() {
        return this.f51989g;
    }

    public final int getDistanceKind() {
        return this.f51990h;
    }

    public final int getEventIdRaw() {
        return this.f51991i;
    }
}
