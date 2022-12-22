package com.didi.sdk.logging;

import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.RollingCalendar;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.sdk.logging.d */
/* compiled from: LogFileRemover */
class C12396d {

    /* renamed from: a */
    static final long f36533a = -1;

    /* renamed from: b */
    static final int f36534b = 336;

    /* renamed from: c */
    static final long f36535c = (TimeUnit.DAYS.toMillis(1) * 64);

    /* renamed from: d */
    private final RollingCalendar f36536d;

    /* renamed from: e */
    private int f36537e = LoggerFactory.getConfig().getFileMaxHistory();

    /* renamed from: f */
    private int f36538f;

    /* renamed from: g */
    private long f36539g = LoggerFactory.getConfig().getTotalFileSize();

    /* renamed from: h */
    private long f36540h = -1;

    /* renamed from: i */
    private File f36541i;

    C12396d(File file) {
        this.f36541i = file;
        this.f36536d = new RollingCalendar();
        mo92602a(this.f36537e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo92603a(Date date) {
        long time = date.getTime();
        int a = m25890a(time);
        this.f36540h = time;
        for (int i = 0; i < a; i++) {
            m25891a(date, this.f36538f - i);
        }
        mo92604b(date);
    }

    /* renamed from: a */
    private int m25890a(long j) {
        long j2 = this.f36540h;
        long j3 = 336;
        if (j2 == -1) {
            long periodsElapsed = this.f36536d.periodsElapsed(j, f36535c + j);
            if (periodsElapsed <= 336) {
                j3 = periodsElapsed;
            }
        } else {
            j3 = this.f36536d.periodsElapsed(j2, j);
            if (j3 < 1) {
                j3 = 1;
            }
        }
        return (int) j3;
    }

    /* renamed from: a */
    private void m25891a(Date date, int i) {
        File[] collectLogFiles = LoggerUtils.collectLogFiles(this.f36541i, (String) null, this.f36536d.getRelativeDate(date, i));
        if (collectLogFiles != null && collectLogFiles.length != 0) {
            for (File file : collectLogFiles) {
                Debug.m25980d("rm file:" + file);
                file.delete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo92602a(int i) {
        this.f36537e = i;
        this.f36538f = (-i) - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo92604b(Date date) {
        HashSet hashSet = new HashSet();
        int i = 0;
        for (int i2 = 0; i2 < this.f36537e; i2++) {
            File[] collectLogFiles = LoggerUtils.collectLogFiles(this.f36541i, (String) null, this.f36536d.getRelativeDate(date, -i2));
            if (collectLogFiles != null && collectLogFiles.length > 0) {
                m25892a(collectLogFiles);
                for (File file : collectLogFiles) {
                    long length = ((long) i) + file.length();
                    if (length >= this.f36539g) {
                        break;
                    }
                    hashSet.add(file.getName());
                    i = (int) length;
                }
            }
        }
        File[] collectLogFiles2 = LoggerUtils.collectLogFiles(this.f36541i);
        if (collectLogFiles2 != null && collectLogFiles2.length > hashSet.size()) {
            for (File file2 : collectLogFiles2) {
                if (!hashSet.contains(file2.getName())) {
                    Debug.m25980d("rm file:" + file2);
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: a */
    private void m25892a(File[] fileArr) {
        if (fileArr != null) {
            for (int i = 0; i < fileArr.length - 1; i++) {
                File file = fileArr[i];
                int i2 = i;
                int i3 = i2;
                while (i2 < fileArr.length) {
                    if (fileArr[i2].lastModified() > file.lastModified()) {
                        file = fileArr[i2];
                        i3 = i2;
                    }
                    i2++;
                }
                if (i != i3) {
                    fileArr[i3] = fileArr[i];
                    fileArr[i] = file;
                }
            }
        }
    }
}
