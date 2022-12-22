package com.didi.sdk.logging;

import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.RollingCalendar;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.logging.g */
/* compiled from: SizeAndTimeBasedRollingPolicy */
class C12399g extends C12387a {

    /* renamed from: b */
    private final RollingCalendar f36553b;

    /* renamed from: c */
    private C12396d f36554c;

    /* renamed from: d */
    private long f36555d = -1;

    /* renamed from: e */
    private long f36556e = 0;

    /* renamed from: f */
    private InvocationGate f36557f = new C12394b();

    /* renamed from: g */
    private int f36558g;

    /* renamed from: h */
    private String f36559h;

    /* renamed from: i */
    private String f36560i;

    /* renamed from: j */
    private String f36561j;

    /* renamed from: k */
    private File f36562k;

    C12399g(Type type, String str) {
        this.f36561j = type.name;
        this.f36560i = str;
        this.f36518a.setTime(mo92617d());
        this.f36559h = LoggerUtils.formatForNewFile(this.f36518a);
        this.f36553b = new RollingCalendar();
        m25909e();
    }

    /* renamed from: e */
    private void m25909e() {
        File c = mo92599c();
        this.f36562k = c;
        this.f36558g = m25908a(c, this.f36561j, this.f36560i, this.f36559h);
        this.f36554c = new C12396d(this.f36562k);
    }

    /* renamed from: c */
    public File mo92599c() {
        return LoggerContext.getDefault().getMainLogPathDir();
    }

    /* renamed from: a */
    public boolean mo92597a(File file) {
        long d = mo92617d();
        long j = this.f36556e;
        if (j == 0) {
            m25910f();
            return true;
        } else if (d > j) {
            this.f36558g = 0;
            mo92596a(d);
            m25910f();
            return true;
        } else if (this.f36557f.isTooSoon(d)) {
            return false;
        } else {
            if (!mo92599c().getPath().equals(this.f36562k.getPath())) {
                m25909e();
                return true;
            } else if (file.length() <= LoggerFactory.getConfig().getMaxFileSize()) {
                return false;
            } else {
                this.f36558g++;
                return true;
            }
        }
    }

    /* renamed from: a */
    public void mo92595a() {
        C12396d dVar = this.f36554c;
        if (dVar != null) {
            dVar.mo92603a(this.f36518a);
        }
    }

    /* renamed from: b */
    public String mo92598b() {
        File c = mo92599c();
        return new File(c, this.f36561j + "-" + this.f36560i + "-" + this.f36559h + "-" + this.f36558g + ".log").getAbsolutePath();
    }

    /* renamed from: d */
    public long mo92617d() {
        long j = this.f36555d;
        return j >= 0 ? j : System.currentTimeMillis();
    }

    /* renamed from: f */
    private void m25910f() {
        this.f36556e = this.f36553b.getNextTriggeringMillis(this.f36518a);
    }

    /* renamed from: a */
    public static int m25908a(File file, String str, String str2, String str3) {
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
