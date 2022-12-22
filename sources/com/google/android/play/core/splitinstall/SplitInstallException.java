package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.C18586a;
import com.google.android.play.core.tasks.C18620j;

public class SplitInstallException extends C18620j {

    /* renamed from: a */
    private final int f53255a;

    public SplitInstallException(int i) {
        super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i), C18586a.m38162a(i)}));
        if (i != 0) {
            this.f53255a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f53255a;
    }
}
