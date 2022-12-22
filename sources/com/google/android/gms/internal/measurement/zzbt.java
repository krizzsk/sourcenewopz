package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 0
            r4 = 24
            r5 = 0
            if (r0 < r4) goto L_0x003e
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x002b }
            java.lang.Class<android.app.job.JobInfo> r6 = android.app.job.JobInfo.class
            r0[r3] = r6     // Catch:{ NoSuchMethodException -> 0x002b }
            r6 = 1
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002b }
            r6 = 2
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x002b }
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002b }
            r6 = 3
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002b }
            java.lang.Class<android.app.job.JobScheduler> r6 = android.app.job.JobScheduler.class
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r6.getDeclaredMethod(r7, r0)     // Catch:{ NoSuchMethodException -> 0x002b }
            goto L_0x003f
        L_0x002b:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x003e
            r6 = 6
            r9 = 0
            r11 = 3
            java.lang.String r7 = "JobSchedulerCompat"
            java.lang.String r8 = "No scheduleAsPackage method available, falling back to schedule"
            java.lang.String r10 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x003e:
            r0 = r5
        L_0x003f:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0063
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r4 = "myUserId"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0050 }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0050 }
            goto L_0x0063
        L_0x0050:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0063
            r6 = 6
            r9 = 0
            r11 = 6
            java.lang.String r7 = "JobSchedulerCompat"
            java.lang.String r8 = "No myUserId method available"
            java.lang.String r10 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x0063:
            zzb = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r7, android.app.job.JobInfo r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r9 = "jobscheduler"
            java.lang.Object r9 = r7.getSystemService(r9)
            android.app.job.JobScheduler r9 = (android.app.job.JobScheduler) r9
            if (r9 == 0) goto L_0x0085
            java.lang.reflect.Method r10 = zza
            if (r10 == 0) goto L_0x0080
            java.lang.String r10 = "android.permission.UPDATE_DEVICE_STATS"
            int r7 = r7.checkSelfPermission(r10)
            if (r7 == 0) goto L_0x0017
            goto L_0x0080
        L_0x0017:
            java.lang.reflect.Method r7 = zzb
            r10 = 0
            if (r7 == 0) goto L_0x0045
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r10]     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            java.lang.Object r7 = r7.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            if (r7 == 0) goto L_0x0045
            int r7 = r7.intValue()     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r7 = move-exception
            goto L_0x0030
        L_0x002f:
            r7 = move-exception
        L_0x0030:
            r3 = r7
            r7 = 6
            java.lang.String r0 = "JobSchedulerCompat"
            boolean r7 = android.util.Log.isLoggable(r0, r7)
            if (r7 == 0) goto L_0x0045
            r0 = 6
            r5 = 7
            java.lang.String r1 = "JobSchedulerCompat"
            java.lang.String r2 = "myUserId invocation illegal"
            java.lang.String r4 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0045:
            r7 = 0
        L_0x0046:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = "UploadAlarm"
            java.lang.reflect.Method r1 = zza
            if (r1 == 0) goto L_0x007b
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r3[r10] = r8     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r4 = 1
            r3[r4] = r0     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r0 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r3[r0] = r7     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r7 = 3
            r3[r7] = r2     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            java.lang.Object r7 = r1.invoke(r9, r3)     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            if (r7 == 0) goto L_0x007f
            int r10 = r7.intValue()     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            goto L_0x007f
        L_0x006d:
            r7 = move-exception
            goto L_0x0070
        L_0x006f:
            r7 = move-exception
        L_0x0070:
            r4 = r7
            r1 = 6
            r6 = 10
            java.lang.String r3 = "error calling scheduleAsPackage"
            java.lang.String r5 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x007b:
            int r10 = r9.schedule(r8)
        L_0x007f:
            return r10
        L_0x0080:
            int r7 = r9.schedule(r8)
            return r7
        L_0x0085:
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
