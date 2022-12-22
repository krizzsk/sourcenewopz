package com.didi.drouter.router;

import android.content.Intent;

public interface RouterCallback {

    public static abstract class ActivityCallback implements RouterCallback {
        public abstract void onActivityResult(int i, Intent intent);

        public void onResult(Result result) {
        }
    }

    void onResult(Result result);
}
