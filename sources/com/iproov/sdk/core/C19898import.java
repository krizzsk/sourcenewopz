package com.iproov.sdk.core;

import com.iproov.sdk.cameray.C19776do;
import com.iproov.sdk.cameray.C19783if;
import com.iproov.sdk.cameray.C19791throw;
import com.iproov.sdk.cameray.C19795while;
import com.iproov.sdk.core.C19889if;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import p240import.C21006if;

/* renamed from: com.iproov.sdk.core.import */
/* compiled from: PatchLocation */
public enum C19898import {
    AND1(1000, C19795while.class.getName(), C19791throw.class.getName()),
    AND2(1000, C19783if.C19785for.class.getName(), C19776do.class.getName()),
    AND3(1000, C19783if.C19787new.class.getName(), C19776do.class.getName()),
    AND4(1000, OpenGLRenderer.class.getName()),
    AND5(1000, C19889if.C19894goto.class.getName()),
    AND6(1000, C21006if.class.getName()),
    AND7(1000, C21006if.class.getName()),
    AND8(1000, C21006if.class.getName()),
    AND9(0, C19798break.class.getName()),
    AND10(0, C19798break.class.getName()),
    AND11(0, C19798break.class.getName()),
    AND12(0, C19798break.class.getName()),
    AND13(0, C19798break.class.getName()),
    AND14(0, C19783if.C19787new.class.getName(), C19776do.class.getName());
    

    /* renamed from: do */
    public final Set<String> f54323do;

    /* renamed from: if */
    public final long f54324if;

    private C19898import(long j, String... strArr) {
        this.f54323do = new HashSet(Arrays.asList(strArr));
        this.f54324if = j;
    }
}
