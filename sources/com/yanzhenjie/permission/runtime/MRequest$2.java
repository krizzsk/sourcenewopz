package com.yanzhenjie.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class MRequest$2 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C20719b this$0;

    MRequest$2(C20719b bVar) {
        this.this$0 = bVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C20719b.m40511b(C20719b.f56236b, this.this$0.f56237c, this.this$0.f56238d);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m40512b();
        } else {
            this.this$0.m40510a(list);
        }
    }
}
