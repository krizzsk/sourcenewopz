package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.view.GLSurfaceView;
import com.didi.map.common.ApolloHawaii;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class DefaultEGLContextFactory implements GLSurfaceView.EGLContextFactory {

    /* renamed from: a */
    private volatile EGLEnv f23811a = null;

    /* renamed from: b */
    private boolean f23812b = false;

    /* renamed from: c */
    private boolean f23813c = ApolloHawaii.USE_NEWWAY_CONTEXT;

    DefaultEGLContextFactory() {
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    public javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 r13, javax.microedition.khronos.egl.EGLDisplay r14, javax.microedition.khronos.egl.EGLConfig r15) {
        /*
            r12 = this;
            r0 = 3
            int[] r0 = new int[r0]
            r0 = {12440, 2, 12344} // fill-array
            boolean r1 = r12.f23813c
            if (r1 == 0) goto L_0x000d
            javax.microedition.khronos.egl.EGLContext r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            goto L_0x0013
        L_0x000d:
            javax.microedition.khronos.egl.EGLContext r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r13.eglCreateContext(r14, r15, r1, r0)
        L_0x0013:
            boolean r2 = com.didi.map.common.ApolloHawaii.USE_SHARE_CONTEXT
            if (r2 == 0) goto L_0x00df
            r2 = 0
            com.didi.hawaii.mapsdkv2.core.C9188h.m17099a(r2)
            r3 = 17
            int[] r6 = new int[r3]
            r6 = {12339, 1, 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 24, 12326, 8, 12337, 4, 12344} // fill-array
            r3 = 1
            javax.microedition.khronos.egl.EGLConfig[] r10 = new javax.microedition.khronos.egl.EGLConfig[r3]
            int[] r11 = new int[r3]
            r8 = 1
            r4 = r13
            r5 = r14
            r7 = r10
            r9 = r11
            boolean r4 = r4.eglChooseConfig(r5, r6, r7, r8, r9)
            if (r4 == 0) goto L_0x0051
            r4 = r11[r2]
            if (r4 == 0) goto L_0x0038
            r4 = 1
            goto L_0x006a
        L_0x0038:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "create eglChooseConfig failed,[0] error:"
            r4.append(r5)
            int r5 = r13.eglGetError()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.didi.hawaii.utils.OmegaUtils.trackShareContextException(r4)
            goto L_0x0069
        L_0x0051:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "create eglChooseConfig false failed, error:"
            r4.append(r5)
            int r5 = r13.eglGetError()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.didi.hawaii.utils.OmegaUtils.trackShareContextException(r4)
        L_0x0069:
            r4 = 0
        L_0x006a:
            if (r4 == 0) goto L_0x00d4
            r4 = 9
            int[] r4 = new int[r4]
            r4 = {12375, 1, 12374, 1, 12417, 12380, 12416, 12380, 12344} // fill-array
            r5 = r10[r2]
            javax.microedition.khronos.egl.EGLSurface r4 = r13.eglCreatePbufferSurface(r14, r5, r4)
            if (r4 == 0) goto L_0x0082
            javax.microedition.khronos.egl.EGLSurface r5 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r4 != r5) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r5 = 1
            goto L_0x009b
        L_0x0082:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "create EGLSurface failed, error:"
            r5.append(r6)
            int r6 = r13.eglGetError()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.didi.hawaii.utils.OmegaUtils.trackShareContextException(r5)
            r5 = 0
        L_0x009b:
            if (r5 == 0) goto L_0x00d4
            r2 = r10[r2]
            javax.microedition.khronos.egl.EGLContext r2 = r13.eglCreateContext(r14, r2, r1, r0)
            if (r2 == 0) goto L_0x00bc
            javax.microedition.khronos.egl.EGLContext r5 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r2 == r5) goto L_0x00bc
            com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv r5 = new com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv
            r5.<init>()
            r5.sharedContext = r2
            r5.display = r14
            r5.egl10 = r13
            r5.eglSurface = r4
            r12.f23811a = r5
            com.didi.hawaii.mapsdkv2.core.C9188h.m17099a(r3)
            goto L_0x00d4
        L_0x00bc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "create shareContext failed, error:"
            r2.append(r4)
            int r4 = r13.eglGetError()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.didi.hawaii.utils.OmegaUtils.trackShareContextException(r2)
        L_0x00d4:
            monitor-enter(r12)
            r12.notifyAll()     // Catch:{ all -> 0x00dc }
            r12.f23812b = r3     // Catch:{ all -> 0x00dc }
            monitor-exit(r12)     // Catch:{ all -> 0x00dc }
            goto L_0x00df
        L_0x00dc:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00dc }
            throw r13
        L_0x00df:
            boolean r2 = r12.f23813c
            if (r2 == 0) goto L_0x00f1
            javax.microedition.khronos.egl.EGLContext r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv r2 = r12.f23811a
            if (r2 == 0) goto L_0x00ed
            com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv r1 = r12.f23811a
            javax.microedition.khronos.egl.EGLContext r1 = r1.sharedContext
        L_0x00ed:
            javax.microedition.khronos.egl.EGLContext r1 = r13.eglCreateContext(r14, r15, r1, r0)
        L_0x00f1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory.createContext(javax.microedition.khronos.egl.EGL10, javax.microedition.khronos.egl.EGLDisplay, javax.microedition.khronos.egl.EGLConfig):javax.microedition.khronos.egl.EGLContext");
    }

    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        return r1.f23811a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0011 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory.EGLEnv mo69752a() {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv r0 = r1.f23811a     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x0018
            boolean r0 = r1.f23812b     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x000d
            com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv r0 = r1.f23811a     // Catch:{ all -> 0x001c }
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            return r0
        L_0x000d:
            r1.wait()     // Catch:{ InterruptedException -> 0x0011 }
            goto L_0x0001
        L_0x0011:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001c }
            r0.interrupt()     // Catch:{ all -> 0x001c }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv r0 = r1.f23811a
            return r0
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory.mo69752a():com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory$EGLEnv");
    }

    static class EGLEnv {
        EGLDisplay display;
        EGL10 egl10;
        EGLSurface eglSurface;
        EGLContext sharedContext;

        EGLEnv() {
        }
    }
}
