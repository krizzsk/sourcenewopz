package com.didi.sdk.logging;

import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.RollingCalendar;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.logging.h */
/* compiled from: SizeBasedRollingPolicy */
class C12400h extends C12387a {

    /* renamed from: b */
    private final RollingCalendar f36563b;

    /* renamed from: c */
    private C12396d f36564c;

    /* renamed from: d */
    private long f36565d = -1;

    /* renamed from: e */
    private long f36566e = 0;

    /* renamed from: f */
    private int f36567f;

    /* renamed from: g */
    private String f36568g;

    /* renamed from: h */
    private String f36569h;

    /* renamed from: i */
    private String f36570i;

    /* renamed from: j */
    private File f36571j;

    C12400h(Type type, String str) {
        this.f36570i = type.name;
        this.f36569h = str;
        this.f36518a.setTime(mo92618d());
        this.f36568g = LoggerUtils.formatForNewFile(this.f36518a);
        this.f36563b = new RollingCalendar();
        m25917e();
    }

    /* renamed from: e */
    private void m25917e() {
        File c = mo92599c();
        this.f36571j = c;
        this.f36567f = m25916a(c, this.f36570i, this.f36569h, this.f36568g);
        this.f36564c = new C12396d(this.f36571j);
    }

    /* renamed from: c */
    public File mo92599c() {
        return LoggerContext.getDefault().getMainLogPathDir();
    }

    /* renamed from: a */
    public boolean mo92597a(File file) {
        if (this.f36566e == 0) {
            m25918f();
            return true;
        } else if (!mo92599c().getPath().equals(this.f36571j.getPath())) {
            m25917e();
            return true;
        } else if (file.length() <= LoggerFactory.getConfig().getMaxFileSize()) {
            return false;
        } else {
            this.f36567f++;
            return true;
        }
    }

    /* renamed from: a */
    public void mo92595a() {
        C12396d dVar = this.f36564c;
        if (dVar != null) {
            dVar.mo92603a(this.f36518a);
        }
    }

    /* renamed from: b */
    public String mo92598b() {
        File c = mo92599c();
        return new File(c, this.f36570i + "-" + this.f36569h + "-" + this.f36568g + "-" + this.f36567f + ".log").getAbsolutePath();
    }

    /* renamed from: d */
    public long mo92618d() {
        long j = this.f36565d;
        return j >= 0 ? j : System.currentTimeMillis();
    }

    /* renamed from: f */
    private void m25918f() {
        this.f36566e = this.f36563b.getNextTriggeringMillis(this.f36518a);
    }

    /* renamed from: a */
    public static int m25916a(File file, String str, String str2, String str3) {
        int intValue;
        File[] collectLogFiles = LoggerUtils.collectLogFiles(file, str, str2, str3);
        if (collectLogFiles.length == 0) {
            return 0;
        }
        Pattern logFileRegex = LoggerUtils.getLogFileRegex(str);
        int i = 0;
        for (File name : collectLogFiles) {
            Matcher matcher = logFileRegex.matcher(name.getName());
            if (matcher.matches() && i < (intValue = Integer.valueOf(matcher.group(4)).intValue())) {
                i = intValue;
            }
        }
        return i;
    }
}
