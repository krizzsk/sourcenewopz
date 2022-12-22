package com.didi.hawaii.p118ar.core.modle;

import com.didi.hawaii.p118ar.jni.DARCAskResponse;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;

/* renamed from: com.didi.hawaii.ar.core.modle.DiARNavViewCAResponseData */
public class DiARNavViewCAResponseData {

    /* renamed from: a */
    private ARCoreCheckerAndGenerator.CheckOption f23077a;

    /* renamed from: b */
    private DARCAskResponse f23078b;

    public void setArRequestOption(ARCoreCheckerAndGenerator.CheckOption checkOption) {
        this.f23077a = checkOption;
    }

    public void setcResData(DARCAskResponse dARCAskResponse) {
        this.f23078b = dARCAskResponse;
    }

    public ARCoreCheckerAndGenerator.CheckOption getArRequestOption() {
        return this.f23077a;
    }

    public DARCAskResponse getcResData() {
        return this.f23078b;
    }
}
