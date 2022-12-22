package com.didichuxing.dfbasesdk.video_capture;

public interface IMediaControl {
    String getVideoPath();

    boolean recording();

    void setErrorListener(IErrorListener iErrorListener);

    void startRecord();

    void startRecord(String str);

    void stopRecord();
}
