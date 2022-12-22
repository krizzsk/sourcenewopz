package com.didi.drouter.remote;

import android.os.RemoteException;
import com.didi.drouter.remote.IClientService;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.utils.RouterLogger;

class RemoteDispatcher$2 implements RouterCallback {
    final /* synthetic */ C7935a this$0;
    final /* synthetic */ RemoteCommand val$command;

    RemoteDispatcher$2(C7935a aVar, RemoteCommand remoteCommand) {
        this.this$0 = aVar;
        this.val$command = remoteCommand;
    }

    public void onResult(Result result) {
        if (this.val$command.f19146i != null) {
            RouterLogger.getCoreLogger().mo59000d("[Service] command \"%s\" result start callback", this.val$command);
            RemoteCommand remoteCommand = new RemoteCommand(1);
            remoteCommand.f19147j = result.isActivityStarted();
            remoteCommand.f19148k = result.getRouterSize();
            remoteCommand.f19149l = result.getExtra();
            remoteCommand.f19150m = result.getAddition();
            try {
                IClientService.Stub.asInterface(this.val$command.f19146i).callback(remoteCommand);
            } catch (RemoteException e) {
                RouterLogger.getCoreLogger().mo59001e("[Service] command \"%s\" callback Exception %s", this.val$command, e);
            }
        }
    }
}
