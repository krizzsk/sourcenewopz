package com.didi.dqr.oned.rss.expanded.decoders;

final class CurrentParsingState {

    /* renamed from: a */
    private int f18828a = 0;

    /* renamed from: b */
    private State f18829b = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58422a() {
        return this.f18828a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58423a(int i) {
        this.f18828a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58424b(int i) {
        this.f18828a += i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo58425b() {
        return this.f18829b == State.ALPHA;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo58426c() {
        return this.f18829b == State.NUMERIC;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo58427d() {
        return this.f18829b == State.ISO_IEC_646;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo58428e() {
        this.f18829b = State.NUMERIC;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo58429f() {
        this.f18829b = State.ALPHA;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo58430g() {
        this.f18829b = State.ISO_IEC_646;
    }
}
