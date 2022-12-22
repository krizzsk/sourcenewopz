package com.koushikdutta.async.callback;

public interface CompletedCallback {

    public static class NullCompletedCallback implements CompletedCallback {
        public void onCompleted(Exception exc) {
        }
    }

    void onCompleted(Exception exc);
}
