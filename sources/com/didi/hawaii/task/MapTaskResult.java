package com.didi.hawaii.task;

import android.os.Message;

public class MapTaskResult {
    public Throwable exception;
    public Object result;
    public Object userObj;

    public static MapTaskResult forMessage(Message message, Object obj, Throwable th) {
        MapTaskResult mapTaskResult = new MapTaskResult(message.obj, obj, th);
        message.obj = mapTaskResult;
        return mapTaskResult;
    }

    public static MapTaskResult forMessage(Message message) {
        MapTaskResult mapTaskResult = new MapTaskResult(message.obj, (Object) null, (Throwable) null);
        message.obj = mapTaskResult;
        return mapTaskResult;
    }

    public MapTaskResult(Object obj, Object obj2, Throwable th) {
        this.userObj = obj;
        this.result = obj2;
        this.exception = th;
    }
}
