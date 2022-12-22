package com.didi.hawaii.p118ar.core;

/* renamed from: com.didi.hawaii.ar.core.DiARNavManager */
public class DiARNavManager extends BaseDelegate implements IDiARNavDelegate {
    DiARNavManager(DiAREngine diAREngine) {
        attachEngine(diAREngine);
    }

    public void start() {
        if (this.mAREngine != null) {
            this.mAREngine.start();
        }
    }

    public void pause() {
        if (this.mAREngine != null) {
            this.mAREngine.pause();
        }
    }

    public void resume() {
        if (this.mAREngine != null) {
            this.mAREngine.resume();
        }
    }

    public void stop() {
        if (this.mAREngine != null) {
            this.mAREngine.stop();
        }
    }

    public void destroy() {
        if (this.mAREngine != null) {
            this.mAREngine.destroyEngineContext();
        }
    }

    public void release() {
        super.release();
    }
}
