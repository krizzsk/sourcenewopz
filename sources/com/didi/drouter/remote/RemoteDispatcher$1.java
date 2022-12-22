package com.didi.drouter.remote;

class RemoteDispatcher$1 implements Runnable {
    final /* synthetic */ C7935a this$0;
    final /* synthetic */ RemoteCommand val$command;

    RemoteDispatcher$1(C7935a aVar, RemoteCommand remoteCommand) {
        this.this$0 = aVar;
        this.val$command = remoteCommand;
    }

    public void run() {
        this.this$0.m14348b(this.val$command);
    }
}
