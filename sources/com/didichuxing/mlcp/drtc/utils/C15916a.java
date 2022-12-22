package com.didichuxing.mlcp.drtc.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import org.webrtc.GlRectDrawer;
import org.webrtc.GlTextureFrameBuffer;
import org.webrtc.GlUtil;
import org.webrtc.RendererCommon;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrameDrawer;

/* renamed from: com.didichuxing.mlcp.drtc.utils.a */
/* compiled from: BitMapUtil */
public class C15916a {

    /* renamed from: a */
    private static final VideoFrameDrawer f48446a = new VideoFrameDrawer();

    /* renamed from: b */
    private static RendererCommon.GlDrawer f48447b = new GlRectDrawer();

    /* renamed from: c */
    private static final Matrix f48448c = new Matrix();

    /* renamed from: d */
    private static final GlTextureFrameBuffer f48449d = new GlTextureFrameBuffer(6408);

    /* renamed from: a */
    public static Bitmap m34717a(VideoFrame videoFrame) {
        f48448c.reset();
        f48448c.preTranslate(0.5f, 0.5f);
        f48448c.preScale(1.0f, -1.0f);
        f48448c.preTranslate(-0.5f, -0.5f);
        int rotatedWidth = videoFrame.getRotatedWidth() * 1;
        int rotatedHeight = videoFrame.getRotatedHeight() * 1;
        f48449d.setSize(rotatedWidth, rotatedHeight);
        GLES20.glBindFramebuffer(36160, f48449d.getFrameBufferId());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, f48449d.getTextureId(), 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        f48446a.drawFrame(videoFrame, f48447b, f48448c, 0, 0, rotatedWidth, rotatedHeight);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
        GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
        GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
        Bitmap createBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        return createBitmap;
    }
}
