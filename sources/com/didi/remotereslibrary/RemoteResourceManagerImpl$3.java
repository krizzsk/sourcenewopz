package com.didi.remotereslibrary;

class RemoteResourceManagerImpl$3 implements Runnable {
    final /* synthetic */ C11501a this$0;
    final /* synthetic */ double val$lat;
    final /* synthetic */ double val$lng;

    RemoteResourceManagerImpl$3(C11501a aVar, double d, double d2) {
        this.this$0 = aVar;
        this.val$lat = d;
        this.val$lng = d2;
    }

    public void run() {
        this.this$0.pullRemoteResource(this.val$lat, this.val$lng);
    }
}
