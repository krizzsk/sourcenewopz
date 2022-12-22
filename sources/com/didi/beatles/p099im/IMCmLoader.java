package com.didi.beatles.p099im;

import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.view.IMCmViewUtil;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.beatles.im.IMCmLoader */
public class IMCmLoader {

    /* renamed from: a */
    private static final String f8679a = "IMCmLoader";

    /* renamed from: b */
    private static IMCmLoader f8680b = new IMCmLoader();

    /* renamed from: c */
    private IMCmViewUtil f8681c;

    public static IMCmLoader getInstance() {
        return f8680b;
    }

    public IMCmViewUtil getViewUtil() {
        IMCmViewUtil iMCmViewUtil = this.f8681c;
        if (iMCmViewUtil != null) {
            return iMCmViewUtil;
        }
        IMCmViewUtil iMCmViewUtil2 = (IMCmViewUtil) ServiceLoader.load(IMCmViewUtil.class).iterator().next();
        this.f8681c = iMCmViewUtil2;
        if (iMCmViewUtil2 == null) {
            IMLog.m6632e(f8679a, "init fail not found IMCmViewUtil spi");
            this.f8681c = IMCmViewUtil.empty;
        }
        return this.f8681c;
    }
}
