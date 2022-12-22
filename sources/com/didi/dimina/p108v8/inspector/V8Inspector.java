package com.didi.dimina.p108v8.inspector;

import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.V8Object;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dimina.v8.inspector.V8Inspector */
public class V8Inspector {
    private List<DebuggerConnectionListener> debuggerConnectionListeners;
    private long inspectorPtr = 0;
    private C7781V8 runtime;
    private boolean waitingForConnection = true;

    protected V8Inspector(C7781V8 v8, V8InspectorDelegate v8InspectorDelegate, String str) {
        this.runtime = v8;
        this.inspectorPtr = v8.createInspector(v8InspectorDelegate, str);
        this.debuggerConnectionListeners = new ArrayList();
    }

    public static V8Inspector createV8Inspector(C7781V8 v8, V8InspectorDelegate v8InspectorDelegate, String str) {
        return new V8Inspector(v8, v8InspectorDelegate, str);
    }

    public static V8Inspector createV8Inspector(C7781V8 v8, V8InspectorDelegate v8InspectorDelegate) {
        return new V8Inspector(v8, v8InspectorDelegate, (String) null);
    }

    public void dispatchProtocolMessage(String str) {
        try {
            this.runtime.dispatchProtocolMessage(this.inspectorPtr, str);
            if (this.waitingForConnection) {
                verifyDebuggerConnection(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        this.debuggerConnectionListeners.add(debuggerConnectionListener);
    }

    public void removeDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        this.debuggerConnectionListeners.remove(debuggerConnectionListener);
    }

    private void verifyDebuggerConnection(String str) {
        V8Object v8Object = null;
        try {
            C7781V8 v8 = this.runtime;
            v8Object = v8.executeObjectScript("JSON.parse(JSON.stringify(" + str + "))");
            if (v8Object.getString("method").equals("Runtime.runIfWaitingForDebugger")) {
                this.waitingForConnection = false;
                this.runtime.schedulePauseOnNextStatement(this.inspectorPtr, "");
                for (DebuggerConnectionListener onDebuggerConnected : this.debuggerConnectionListeners) {
                    onDebuggerConnected.onDebuggerConnected();
                }
            }
        } finally {
            if (v8Object != null) {
                v8Object.close();
            }
        }
    }
}
