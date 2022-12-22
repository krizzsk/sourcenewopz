package com.didi.dimina.container.bridge.canvas;

import com.didi.dimina.container.p106ui.canvas.CanvasView;
import com.didi.dimina.container.util.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

public class CanvasViewManager {

    /* renamed from: a */
    private final ConcurrentHashMap<String, CanvasView> f16710a;

    private CanvasViewManager() {
        this.f16710a = new ConcurrentHashMap<>();
    }

    private static class CanvasViewManagerHolder {
        /* access modifiers changed from: private */
        public static final CanvasViewManager mCanvasViewManager = new CanvasViewManager();

        private CanvasViewManagerHolder() {
        }
    }

    public static CanvasViewManager getCanvasViewManager() {
        return CanvasViewManagerHolder.mCanvasViewManager;
    }

    public void createCanvasView(String str, CanvasView canvasView) {
        LogUtil.m13411i("CanvasViewManager createCanvasView: canvasId => " + str + ", CanvasView => " + canvasView);
        this.f16710a.put(str, canvasView);
    }

    public CanvasView getCanvasView(String str) {
        LogUtil.m13411i("CanvasViewManager getCanvasView");
        return this.f16710a.get(str);
    }

    public void clearCanvasView(String str) {
        LogUtil.m13411i("CanvasViewManager clearCanvasView");
        this.f16710a.remove(str);
    }
}
