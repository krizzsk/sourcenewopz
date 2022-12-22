package com.yanzhenjie.permission;

import android.content.Context;

public interface Rationale<T> {
    void showRationale(Context context, T t, RequestExecutor requestExecutor);
}
