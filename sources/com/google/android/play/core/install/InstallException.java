package com.google.android.play.core.install;

import com.google.android.play.core.install.model.C18424a;
import com.google.android.play.core.tasks.C18620j;

public class InstallException extends C18620j {

    /* renamed from: a */
    private final int f53120a;

    public InstallException(int i) {
        super(String.format("Install Error(%d): %s", new Object[]{Integer.valueOf(i), C18424a.m37743a(i)}));
        if (i != 0) {
            this.f53120a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f53120a;
    }
}
