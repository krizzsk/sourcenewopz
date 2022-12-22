package com.didichuxing.hawaii.arsdk.glarlib;

public class JNIThread extends Thread {
    private volatile boolean mIsCancelled = false;
    private volatile boolean mIsFinished = false;
    private long mNativeObj;

    private native void nativeWork(long j);

    public static JNIThread create(long j) {
        return new JNIThread(j);
    }

    private JNIThread(long j) {
        this.mNativeObj = j;
    }

    public void run() {
        super.run();
        nativeWork(this.mNativeObj);
        this.mIsFinished = true;
    }

    public synchronized void start() {
        super.start();
    }

    public void cancel() {
        this.mIsCancelled = true;
    }

    public boolean isCancelled() {
        return this.mIsCancelled;
    }

    public boolean isFinished() {
        return this.mIsFinished;
    }
}
