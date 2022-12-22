package com.yanzhenjie.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class LRequest$1 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C20718a this$0;

    LRequest$1(C20718a aVar) {
        this.this$0 = aVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C20718a.m40501b(C20718a.f56230a, this.this$0.f56231b, this.this$0.f56232c);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m40502b();
        } else {
            this.this$0.m40500a(list);
        }
    }
}
