package com.didichuxing.dfbasesdk.video_capture;

public interface IRecordVideo {
    void frameAvailable(float[] fArr);

    String getVideoPath();

    boolean recording();

    void setErrorListener(IErrorListener iErrorListener);

    void start(int i);

    void start(int i, String str);

    void stop();
}
