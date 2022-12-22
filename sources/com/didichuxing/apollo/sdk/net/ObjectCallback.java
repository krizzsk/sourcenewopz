package com.didichuxing.apollo.sdk.net;

import android.os.AsyncTask;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.google.gson.Gson;
import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.HttpResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class ObjectCallback<T> extends AsyncCallback {
    /* access modifiers changed from: private */
    public Class<T> mClazz;

    public abstract void onComplete(T t);

    public ObjectCallback(Class<T> cls) {
        this.mClazz = cls;
    }

    public final void onComplete(HttpResponse httpResponse) {
        byte[] body = httpResponse.getBody();
        if (body == null) {
            onComplete((Object) null);
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(body)));
            new GsonTask().execute(new BufferedReader[]{bufferedReader});
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtils.m32692e("Exception while ObjectCallback#onComplete: " + th.getMessage());
            onComplete((Object) null);
        }
    }

    private class GsonTask extends AsyncTask<BufferedReader, Integer, T> {
        private GsonTask() {
        }

        /* access modifiers changed from: protected */
        public T doInBackground(BufferedReader... bufferedReaderArr) {
            try {
                return new Gson().fromJson((Reader) bufferedReaderArr[0], ObjectCallback.this.mClazz);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(T t) {
            ObjectCallback.this.onComplete(t);
        }
    }
}
