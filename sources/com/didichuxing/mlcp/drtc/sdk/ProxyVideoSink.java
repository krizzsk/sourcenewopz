package com.didichuxing.mlcp.drtc.sdk;

import com.didichuxing.mlcp.drtc.interfaces.C15890d;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

public class ProxyVideoSink implements VideoSink {

    /* renamed from: a */
    private VideoSink f48399a;

    /* renamed from: b */
    private C15890d f48400b;

    public synchronized void onFrame(VideoFrame videoFrame) {
        VideoSink videoSink = this.f48399a;
        if (videoSink != null) {
            videoSink.onFrame(videoFrame);
        }
        C15890d dVar = this.f48400b;
        if (dVar != null) {
            dVar.mo118941a(videoFrame);
        }
    }

    public synchronized void setListener(C15890d dVar) {
        this.f48400b = dVar;
    }

    public synchronized void setTarget(VideoSink videoSink) {
        this.f48399a = videoSink;
    }
}
