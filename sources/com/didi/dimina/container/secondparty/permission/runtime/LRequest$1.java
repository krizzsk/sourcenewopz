package com.didi.dimina.container.secondparty.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class LRequest$1 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C7606a this$0;

    LRequest$1(C7606a aVar) {
        this.this$0 = aVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C7606a.m12933b(C7606a.f17390a, this.this$0.f17391b, this.this$0.f17392c);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m12934b();
        } else {
            this.this$0.m12932a(list);
        }
    }
}
