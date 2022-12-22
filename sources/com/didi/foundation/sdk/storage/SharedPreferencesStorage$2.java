package com.didi.foundation.sdk.storage;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.didi.foundation.sdk.storage.IStorage;

class SharedPreferencesStorage$2 implements Runnable {
    final /* synthetic */ IStorage.Callback val$callback;
    final /* synthetic */ SharedPreferences.Editor val$editor;

    SharedPreferencesStorage$2(SharedPreferences.Editor editor, IStorage.Callback callback) {
        this.val$editor = editor;
        this.val$callback = callback;
    }

    public void run() {
        final boolean commit = this.val$editor.commit();
        if (this.val$callback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    SharedPreferencesStorage$2.this.val$callback.done(commit);
                }
            });
        }
    }
}
