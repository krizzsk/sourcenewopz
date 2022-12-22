package com.didi.aoe.library.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.core.service.IAoeProcessService;
import com.didi.aoe.library.logging.Logger;
import java.util.List;

class RemoteProcessorWrapper$1 implements ServiceConnection {
    final /* synthetic */ C3609g this$0;

    RemoteProcessorWrapper$1(C3609g gVar) {
        this.this$0 = gVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger b = this.this$0.f8196b;
        b.debug("onServiceConnected: " + this.this$0.f8200f, new Object[0]);
        this.this$0.f8199e.set(true);
        IAoeProcessService unused = this.this$0.f8202h = IAoeProcessService.Stub.asInterface(iBinder);
        if (2 == this.this$0.f8204j) {
            C3609g gVar = this.this$0;
            InterpreterInitResult a = gVar.m5315a(gVar.f8200f, (List<AoeModelOption>) this.this$0.f8201g);
            if (this.this$0.f8203i != null) {
                this.this$0.f8203i.onInitResult(a);
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.this$0.f8196b.debug("onServiceDisconnected", new Object[0]);
        this.this$0.f8199e.set(false);
        IAoeProcessService unused = this.this$0.f8202h = null;
    }
}
