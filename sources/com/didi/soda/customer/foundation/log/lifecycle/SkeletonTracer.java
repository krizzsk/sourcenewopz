package com.didi.soda.customer.foundation.log.lifecycle;

import com.didi.app.nova.skeleton.Skeleton;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class SkeletonTracer implements Skeleton.Tracer {

    /* renamed from: a */
    private static final String f40949a = "SkeletonTracer";

    public void trace(String str, String str2) {
        LogUtil.m29100d(str, str2);
        RecordTracker.Builder.create().setTag(f40949a).setLogModule("m-skeleton|").setMessage(str2).setLogCategory("c-data|").build().info();
    }
}
