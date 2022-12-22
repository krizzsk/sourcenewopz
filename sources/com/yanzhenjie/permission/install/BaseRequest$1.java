package com.yanzhenjie.permission.install;

import android.content.Context;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import java.io.File;

class BaseRequest$1 implements Rationale<File> {
    final /* synthetic */ C20706a this$0;

    BaseRequest$1(C20706a aVar) {
        this.this$0 = aVar;
    }

    public void showRationale(Context context, File file, RequestExecutor requestExecutor) {
        requestExecutor.execute();
    }
}
