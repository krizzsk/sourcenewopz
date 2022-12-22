package com.didi.dimina.container.mina;

import java.util.ArrayList;
import java.util.List;

public class DMFrontBackgroundManager {

    /* renamed from: a */
    private final List<IDMCommonAction<Void>> f16879a = new ArrayList();

    /* renamed from: b */
    private final List<IDMCommonAction<Void>> f16880b = new ArrayList();

    /* renamed from: c */
    private boolean f16881c = true;

    public void registerFrontCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f16879a.add(iDMCommonAction);
    }

    public void unRegisterFrontCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f16879a.remove(iDMCommonAction);
    }

    public void registerBackgroundCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f16880b.add(iDMCommonAction);
    }

    public void unRegisterBackgroundCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f16880b.remove(iDMCommonAction);
    }

    public void hookFrontCallback() {
        this.f16881c = true;
        for (IDMCommonAction iDMCommonAction : new ArrayList(this.f16879a)) {
            if (iDMCommonAction != null) {
                iDMCommonAction.callback(null);
            }
        }
    }

    public void hookBackgroundCallback() {
        this.f16881c = false;
        for (IDMCommonAction iDMCommonAction : new ArrayList(this.f16880b)) {
            if (iDMCommonAction != null) {
                iDMCommonAction.callback(null);
            }
        }
    }

    public boolean inFrontStatus() {
        return this.f16881c;
    }
}
