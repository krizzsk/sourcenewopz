package com.didichuxing.diface.act;

import com.didichuxing.diface.appeal.AppealLauncher;

public abstract class DFStyleBaseAct extends DFBaseAct {
    /* access modifiers changed from: protected */
    public void switchStyle() {
        setTheme(AppealLauncher.getTheme());
    }
}
