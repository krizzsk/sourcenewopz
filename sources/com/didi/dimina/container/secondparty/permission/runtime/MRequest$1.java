package com.didi.dimina.container.secondparty.permission.runtime;

import android.content.Context;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import java.util.List;

class MRequest$1 implements Rationale<List<String>> {
    final /* synthetic */ C7607b this$0;

    MRequest$1(C7607b bVar) {
        this.this$0 = bVar;
    }

    public void showRationale(Context context, List<String> list, RequestExecutor requestExecutor) {
        requestExecutor.execute();
    }
}
