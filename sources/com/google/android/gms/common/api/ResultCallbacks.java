package com.google.android.gms.common.api;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    public final void onResult(R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException e) {
                SystemUtils.log(5, "ResultCallbacks", "Unable to release ".concat(String.valueOf(String.valueOf(r))), e, "com.google.android.gms.common.api.ResultCallbacks", 7);
            }
        }
    }

    public abstract void onSuccess(R r);
}
