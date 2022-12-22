package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.C18405a;
import com.google.android.play.core.tasks.C18620j;

public class AssetPackException extends C18620j {

    /* renamed from: a */
    private final int f52694a;

    AssetPackException(int i) {
        super(String.format("Asset Pack Download Error(%d): %s", new Object[]{Integer.valueOf(i), C18405a.m37706a(i)}));
        if (i != 0) {
            this.f52694a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f52694a;
    }
}
