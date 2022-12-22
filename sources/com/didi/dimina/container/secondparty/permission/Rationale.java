package com.didi.dimina.container.secondparty.permission;

import android.content.Context;

public interface Rationale<T> {
    void showRationale(Context context, T t, RequestExecutor requestExecutor);
}
