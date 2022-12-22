package com.didi.soda.customer.foundation.log;

import android.text.TextUtils;
import com.didi.sofa.utils.TimeUtils;
import java.util.HashMap;
import java.util.Map;

public final class RecordTracker {

    /* renamed from: a */
    private HashMap<String, Object> f40942a;

    /* renamed from: b */
    private String f40943b;

    /* renamed from: c */
    private String f40944c;

    /* renamed from: d */
    private String f40945d;

    /* renamed from: e */
    private String f40946e;

    /* renamed from: f */
    private String f40947f;

    /* renamed from: g */
    private RecordTrakerGenerator f40948g;

    private RecordTracker(String str, String str2, String str3, String str4, HashMap<String, Object> hashMap, String str5) {
        this.f40942a = new HashMap<>();
        this.f40946e = str;
        this.f40943b = str2;
        this.f40944c = str3;
        this.f40945d = str4;
        this.f40942a = hashMap;
        this.f40947f = str5;
        this.f40948g = new RecordTrakerGenerator(this);
    }

    public static StringBuilder buildLogFormat(RecordTracker recordTracker) {
        StringBuilder sb = new StringBuilder();
        if (recordTracker == null) {
            return sb;
        }
        if (!TextUtils.isEmpty(recordTracker.f40946e)) {
            sb.append(String.format("tag- %s |", new Object[]{recordTracker.f40946e}));
        }
        if (!TextUtils.isEmpty(recordTracker.f40945d)) {
            sb.append(String.format("msg- %s | ", new Object[]{recordTracker.f40945d.trim()}));
        }
        if (!TextUtils.isEmpty(recordTracker.f40947f)) {
            sb.append(String.format("time- %s |", new Object[]{recordTracker.f40947f}));
        }
        if (!TextUtils.isEmpty(recordTracker.f40943b)) {
            sb.append(recordTracker.f40943b);
        }
        if (!TextUtils.isEmpty(recordTracker.f40944c)) {
            sb.append(recordTracker.f40944c);
        }
        HashMap<String, Object> hashMap = recordTracker.f40942a;
        if (hashMap != null && hashMap.size() > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : recordTracker.f40942a.entrySet()) {
                Object value = next.getValue();
                sb2.append(((String) next.getKey()) + ":" + value + ",");
            }
            sb2.substring(0, sb2.length() - 1);
            sb.append(String.format("params- %s |", new Object[]{sb2.toString()}));
        }
        return sb;
    }

    public void error() {
        m29099a("l-ERROR|");
    }

    public void info() {
        m29099a("l-INFO|");
    }

    public void warn() {
        m29099a("l-WARNING|");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m29099a(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1713390571(0xffffffff99dfbc15, float:-2.3133625E-23)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -1575727891(0xffffffffa2144ced, float:-2.0098464E-18)
            if (r0 == r1) goto L_0x0020
            r1 = 1801023681(0x6b5970c1, float:2.6286937E26)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "l-WARNING|"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "l-INFO|"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "l-ERROR|"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0053
            if (r5 == r3) goto L_0x004b
            if (r5 == r2) goto L_0x0043
            java.lang.String r5 = r4.f40946e
            com.didi.soda.customer.foundation.log.RecordTracker$RecordTrakerGenerator r0 = r4.f40948g
            com.didi.soda.customer.foundation.log.util.LogUtil.m29103i((java.lang.String) r5, (com.didi.soda.customer.foundation.log.IMessageGenerator<java.lang.String>) r0)
            goto L_0x005a
        L_0x0043:
            java.lang.String r5 = r4.f40946e
            com.didi.soda.customer.foundation.log.RecordTracker$RecordTrakerGenerator r0 = r4.f40948g
            com.didi.soda.customer.foundation.log.util.LogUtil.m29101e((java.lang.String) r5, (com.didi.soda.customer.foundation.log.IMessageGenerator<java.lang.String>) r0)
            goto L_0x005a
        L_0x004b:
            java.lang.String r5 = r4.f40946e
            com.didi.soda.customer.foundation.log.RecordTracker$RecordTrakerGenerator r0 = r4.f40948g
            com.didi.soda.customer.foundation.log.util.LogUtil.m29105w((java.lang.String) r5, (com.didi.soda.customer.foundation.log.IMessageGenerator<java.lang.String>) r0)
            goto L_0x005a
        L_0x0053:
            java.lang.String r5 = r4.f40946e
            com.didi.soda.customer.foundation.log.RecordTracker$RecordTrakerGenerator r0 = r4.f40948g
            com.didi.soda.customer.foundation.log.util.LogUtil.m29103i((java.lang.String) r5, (com.didi.soda.customer.foundation.log.IMessageGenerator<java.lang.String>) r0)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.log.RecordTracker.m29099a(java.lang.String):void");
    }

    public static final class Builder {
        private String mCategory;
        private String mMessage;
        private String mModule;
        private HashMap<String, Object> mOtherParams = new HashMap<>();
        private String mTag;
        private String mTime = TimeUtils.getDateEN();

        private Builder() {
        }

        private Builder(String str, String str2) {
            this.mTag = str;
            this.mMessage = str2;
        }

        public static Builder create() {
            return new Builder();
        }

        public static Builder create(String str, String str2) {
            return new Builder(str, str2);
        }

        public RecordTracker build() {
            return new RecordTracker(this.mTag, this.mCategory, this.mModule, this.mMessage, this.mOtherParams, this.mTime);
        }

        public Builder setLogCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setLogModule(String str) {
            this.mModule = str;
            return this;
        }

        public Builder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        public Builder setOtherParam(String str, Object obj) {
            this.mOtherParams.put(str, obj);
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setTime(String str) {
            this.mTime = str;
            return this;
        }
    }

    public static class RecordTrakerGenerator implements IMessageGenerator<String> {
        private RecordTracker mRecordTracker;

        public RecordTrakerGenerator(String str, String str2) {
            this.mRecordTracker = buildRecordTracker(str, str2);
        }

        public RecordTrakerGenerator(RecordTracker recordTracker) {
            this.mRecordTracker = recordTracker;
        }

        public String build() {
            return RecordTracker.buildLogFormat(this.mRecordTracker).toString();
        }

        private RecordTracker buildRecordTracker(String str, String str2) {
            return Builder.create(str, str2).setTime(TimeUtils.getDateEN()).build();
        }
    }
}
