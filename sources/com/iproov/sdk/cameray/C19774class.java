package com.iproov.sdk.cameray;

import android.content.Context;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.core.C19885else;
import com.iproov.sdk.core.exception.CameraException;
import java.util.Arrays;
import p232do.C20818case;
import p232do.C20822goto;
import p234final.C20833if;

/* renamed from: com.iproov.sdk.cameray.class */
/* compiled from: CameraProvider */
public class C19774class {

    /* renamed from: a */
    private final C20833if f54013a;

    /* renamed from: b */
    private final C19792try.C19793do f54014b;

    /* renamed from: c */
    private final C20822goto f54015c;

    /* renamed from: d */
    private final C19768break[] f54016d;

    public C19774class(C20833if ifVar, C19792try.C19793do doVar, C20822goto gotoR, C19768break... breakArr) {
        this.f54013a = ifVar;
        this.f54014b = doVar;
        this.f54015c = gotoR;
        this.f54016d = breakArr;
    }

    /* renamed from: do */
    public C19792try mo161897do(Context context) throws CameraException {
        C19778else a = C19770c.m38672a();
        try {
            C19773catch catchR = a.mo161913do(context);
            if (catchR != null) {
                C19779final finalR = a.mo161914do(context, m38676a(this.f54013a, catchR));
                C19768break[] breakArr = this.f54013a.mo170666do() == null ? this.f54016d : new C19768break[]{this.f54013a.mo170666do()};
                if (finalR != null) {
                    C20818case caseR = finalR.mo161917do(breakArr);
                    if (caseR != null) {
                        return a.mo161915do(context, caseR, this.f54014b, new C19885else(), this.f54015c);
                    }
                    throw new CameraException(context, "No cameras available for lensFacing: " + Arrays.toString(breakArr) + " from: " + finalR.toString());
                }
                throw new CameraException(context, "No cameras available");
            }
            throw new CameraException(context, "No cameras available");
        } catch (C19771case e) {
            e.printStackTrace();
            throw new CameraException(context, e.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    private C19775const m38676a(C20833if ifVar, C19773catch catchR) {
        if (ifVar.m47642goto()) {
            return ifVar.mo170670if();
        }
        return catchR.mo161896do(C19773catch.CAMERA2_LIMITED) ? C19775const.CAMERA2 : C19775const.CAMERA1;
    }
}
