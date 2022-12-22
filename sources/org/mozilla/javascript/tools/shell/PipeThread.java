package org.mozilla.javascript.tools.shell;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.mozilla.javascript.Context;

/* compiled from: Global */
class PipeThread extends Thread {
    private InputStream from;
    private boolean fromProcess;

    /* renamed from: to */
    private OutputStream f6673to;

    PipeThread(boolean z, InputStream inputStream, OutputStream outputStream) {
        setDaemon(true);
        this.fromProcess = z;
        this.from = inputStream;
        this.f6673to = outputStream;
    }

    public void run() {
        try {
            Global.pipe(this.fromProcess, this.from, this.f6673to);
        } catch (IOException e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }
}
