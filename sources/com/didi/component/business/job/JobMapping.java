package com.didi.component.business.job;

import com.didi.sdk.apm.SystemUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class JobMapping {

    /* renamed from: a */
    private Map<String, AbsJob> f11316a = new ConcurrentHashMap();

    JobMapping() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final JobMapping _this = new JobMapping();

        private InstanceHolder() {
        }
    }

    /* renamed from: a */
    public static JobMapping m7629a() {
        return InstanceHolder._this;
    }

    /* renamed from: a */
    public void mo46226a(AbsJob absJob) {
        if (absJob != null) {
            this.f11316a.put(absJob.mo46210a(), absJob);
            mo46228c();
        }
    }

    /* renamed from: a */
    public AbsJob mo46225a(String str) {
        if (this.f11316a.isEmpty()) {
            return null;
        }
        AbsJob remove = this.f11316a.remove(str);
        mo46228c();
        return remove;
    }

    /* renamed from: b */
    public void mo46227b() {
        this.f11316a.clear();
    }

    /* renamed from: c */
    public void mo46228c() {
        StringBuilder sb = new StringBuilder("JobMapping: ");
        Iterator<String> it = this.f11316a.keySet().iterator();
        if (!it.hasNext()) {
            sb.append("is Empty");
        }
        while (it.hasNext()) {
            sb.append(it.next() + ", ");
        }
        SystemUtils.log(4, "JobManager", sb.toString(), (Throwable) null, "com.didi.component.business.job.JobMapping", 54);
    }
}
