package com.didi.dimina.container.secondparty.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class MRequest$2 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C7607b this$0;

    MRequest$2(C7607b bVar) {
        this.this$0 = bVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C7607b.m12943b(C7607b.f17396b, this.this$0.f17397c, this.this$0.f17398d);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m12944b();
        } else {
            this.this$0.m12942a(list);
        }
    }
}
