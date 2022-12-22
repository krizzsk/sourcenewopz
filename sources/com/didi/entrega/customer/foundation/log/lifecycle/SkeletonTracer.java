package com.didi.entrega.customer.foundation.log.lifecycle;

import com.didi.app.nova.skeleton.Skeleton;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;

public class SkeletonTracer implements Skeleton.Tracer {

    /* renamed from: a */
    private static final String f19942a = "SkeletonTracer";

    public void trace(String str, String str2) {
        LogUtil.m14761d(str, str2);
        RecordTracker.Builder.create().setTag(f19942a).setLogModule("m-skeleton|").setMessage(str2).setLogCategory("c-data|").build().info();
    }
}
