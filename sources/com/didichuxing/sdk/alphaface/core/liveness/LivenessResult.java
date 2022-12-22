package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.util.ArrayList;
import java.util.List;

public class LivenessResult {

    /* renamed from: a */
    private final List<ILivenessCallback.PicWithScore> f48711a = new ArrayList();

    /* renamed from: b */
    private final List<ILivenessCallback.PicWithScore> f48712b = new ArrayList();

    /* renamed from: c */
    private final List<ILivenessCallback.PicWithScore> f48713c = new ArrayList();

    /* renamed from: d */
    private final List<ILivenessCallback.PicWithScore> f48714d = new ArrayList();

    LivenessResult() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120626a() {
        this.f48711a.clear();
        this.f48712b.clear();
        this.f48713c.clear();
        this.f48714d.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120628a(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
        this.f48711a.addAll(list);
        this.f48713c.addAll(list2);
        this.f48714d.addAll(list3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120627a(List<ILivenessCallback.PicWithScore> list) {
        this.f48712b.addAll(list);
    }

    public List<ILivenessCallback.PicWithScore> getBestPicList() {
        return this.f48711a;
    }

    public List<ILivenessCallback.PicWithScore> getBestActionPicList() {
        return this.f48712b;
    }

    public List<ILivenessCallback.PicWithScore> getAttackPicList() {
        return this.f48713c;
    }

    public List<ILivenessCallback.PicWithScore> getWaterPicList() {
        return this.f48714d;
    }
}
