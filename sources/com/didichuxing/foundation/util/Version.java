package com.didichuxing.foundation.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Version implements Comparable<Version> {
    protected static final String DEFAULT_SEPARATOR = " ";
    public static final int IMPLICIT_MICRO_REV = 0;
    public static final int IMPLICIT_MINOR_REV = 0;
    public static final int MISSING_MAJOR_REV = 0;
    public static final int NOT_A_PREVIEW = 0;
    public static final Version NOT_SPECIFIED = new Version(0);

    /* renamed from: a */
    private static final Pattern f47654a = Pattern.compile("\\s*([0-9]+)(?:\\.([0-9]+)(?:\\.([0-9]+))?)?([\\s-]*)?(?:(rc|alpha|beta)([0-9]+))?\\s*");

    /* renamed from: b */
    private final int f47655b;

    /* renamed from: c */
    private final int f47656c;

    /* renamed from: d */
    private final int f47657d;

    /* renamed from: e */
    private final int f47658e;

    /* renamed from: f */
    private final Precision f47659f;

    /* renamed from: g */
    private final String f47660g;

    public enum PreviewComparison {
        COMPARE_NUMBER,
        COMPARE_TYPE,
        IGNORE
    }

    public enum Precision {
        MAJOR(1),
        MINOR(2),
        MICRO(3),
        PREVIEW(4);
        
        private final int mTermCount;

        private Precision(int i) {
            this.mTermCount = i;
        }

        /* access modifiers changed from: package-private */
        public int getTermCount() {
            return this.mTermCount;
        }
    }

    public static Version parse(String str, Precision precision) throws NumberFormatException {
        int i;
        int i2;
        String str2;
        int i3;
        try {
            Matcher matcher = f47654a.matcher(str);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                Precision precision2 = Precision.MAJOR;
                String group = matcher.group(2);
                if (group != null) {
                    i = Integer.parseInt(group);
                    precision2 = Precision.MINOR;
                } else {
                    i = 0;
                }
                String group2 = matcher.group(3);
                if (group2 != null) {
                    i2 = Integer.parseInt(group2);
                    precision2 = Precision.MICRO;
                } else {
                    i2 = 0;
                }
                String group3 = matcher.group(6);
                if (group3 != null) {
                    int parseInt2 = Integer.parseInt(group3);
                    str2 = matcher.group(4);
                    i3 = parseInt2;
                    precision2 = Precision.PREVIEW;
                } else {
                    str2 = " ";
                    i3 = 0;
                }
                return new Version(parseInt, i, i2, i3, precision.compareTo(precision2) >= 0 ? precision : precision2, str2);
            }
            th = null;
            NumberFormatException numberFormatException = new NumberFormatException("Invalid revision: " + str);
            if (th != null) {
                numberFormatException.initCause(th);
            }
            throw numberFormatException;
        } catch (Throwable th) {
            th = th;
        }
    }

    public static Version parse(String str) throws NumberFormatException {
        return parse(str, Precision.MAJOR);
    }

    public Version(int i) {
        this(i, 0, 0, 0, Precision.MAJOR, " ");
    }

    public Version(int i, int i2) {
        this(i, i2, 0, 0, Precision.MINOR, " ");
    }

    public Version(Version version) {
        this(version.getMajor(), version.getMinor(), version.getMicro(), version.getPreview(), version.f47659f, version.getSeparator());
    }

    public Version(int i, int i2, int i3) {
        this(i, i2, i3, 0, Precision.MICRO, " ");
    }

    public Version(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, Precision.PREVIEW, " ");
    }

    Version(int i, int i2, int i3, int i4, Precision precision, String str) {
        this.f47655b = i;
        this.f47656c = i2;
        this.f47657d = i3;
        this.f47658e = i4;
        this.f47660g = str;
        this.f47659f = precision;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Version(int r10, java.lang.Integer r11, java.lang.Integer r12, java.lang.Integer r13) {
        /*
            r9 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0005
            r4 = 0
            goto L_0x000a
        L_0x0005:
            int r1 = r11.intValue()
            r4 = r1
        L_0x000a:
            if (r12 != 0) goto L_0x000e
            r5 = 0
            goto L_0x0013
        L_0x000e:
            int r1 = r12.intValue()
            r5 = r1
        L_0x0013:
            if (r13 != 0) goto L_0x0017
            r6 = 0
            goto L_0x001c
        L_0x0017:
            int r0 = r13.intValue()
            r6 = r0
        L_0x001c:
            if (r13 == 0) goto L_0x0022
            com.didichuxing.foundation.util.Version$Precision r11 = com.didichuxing.foundation.util.Version.Precision.PREVIEW
        L_0x0020:
            r7 = r11
            goto L_0x002f
        L_0x0022:
            if (r12 == 0) goto L_0x0027
            com.didichuxing.foundation.util.Version$Precision r11 = com.didichuxing.foundation.util.Version.Precision.MICRO
            goto L_0x0020
        L_0x0027:
            if (r11 == 0) goto L_0x002c
            com.didichuxing.foundation.util.Version$Precision r11 = com.didichuxing.foundation.util.Version.Precision.MINOR
            goto L_0x0020
        L_0x002c:
            com.didichuxing.foundation.util.Version$Precision r11 = com.didichuxing.foundation.util.Version.Precision.MAJOR
            goto L_0x0020
        L_0x002f:
            java.lang.String r8 = " "
            r2 = r9
            r3 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.util.Version.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer):void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMajor());
        if (this.f47659f.compareTo(Precision.MINOR) >= 0) {
            sb.append('.');
            sb.append(getMinor());
            if (this.f47659f.compareTo(Precision.MICRO) >= 0) {
                sb.append('.');
                sb.append(getMicro());
                if (this.f47659f.compareTo(Precision.PREVIEW) >= 0 && isPreview()) {
                    sb.append(getSeparator());
                    sb.append("rc");
                    sb.append(getPreview());
                }
            }
        }
        return sb.toString();
    }

    public int[] toIntArray(boolean z) {
        int[] iArr;
        if (this.f47659f.compareTo(Precision.PREVIEW) < 0) {
            iArr = new int[this.f47659f.getTermCount()];
        } else if (z) {
            iArr = new int[this.f47659f.getTermCount()];
            iArr[3] = getPreview();
        } else {
            iArr = new int[(this.f47659f.getTermCount() - 1)];
        }
        iArr[0] = getMajor();
        if (this.f47659f.compareTo(Precision.MINOR) >= 0) {
            iArr[1] = getMinor();
            if (this.f47659f.compareTo(Precision.MICRO) >= 0) {
                iArr[2] = getMicro();
            }
        }
        return iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.f47655b == version.f47655b && this.f47656c == version.f47656c && this.f47657d == version.f47657d && this.f47658e == version.f47658e && this.f47659f == version.f47659f) {
            return true;
        }
        return false;
    }

    public int getMajor() {
        return this.f47655b;
    }

    public int getMinor() {
        return this.f47656c;
    }

    public int getMicro() {
        return this.f47657d;
    }

    /* access modifiers changed from: protected */
    public String getSeparator() {
        return this.f47660g;
    }

    public boolean isPreview() {
        return this.f47658e > 0;
    }

    public int getPreview() {
        return this.f47658e;
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47655b);
        if (this.f47656c > 0 || this.f47657d > 0) {
            sb.append('.');
            sb.append(this.f47656c);
        }
        if (this.f47657d > 0) {
            sb.append('.');
            sb.append(this.f47657d);
        }
        if (this.f47658e != 0) {
            sb.append(this.f47660g);
            sb.append("rc");
            sb.append(this.f47658e);
        }
        return sb.toString();
    }

    public int hashCode() {
        return ((((((((this.f47655b + 31) * 31) + this.f47656c) * 31) + this.f47657d) * 31) + this.f47658e) * 31) + this.f47659f.getTermCount();
    }

    public int compareTo(Version version) {
        return compareTo(version, PreviewComparison.COMPARE_NUMBER);
    }

    public int compareTo(Version version, PreviewComparison previewComparison) {
        int i;
        int i2;
        int i3 = this.f47655b - version.f47655b;
        if (i3 != 0) {
            return i3;
        }
        int i4 = this.f47656c - version.f47656c;
        if (i4 != 0) {
            return i4;
        }
        int i5 = this.f47657d - version.f47657d;
        if (i5 != 0) {
            return i5;
        }
        int i6 = C156881.f47661x7a4d5d7d[previewComparison.ordinal()];
        if (i6 == 2) {
            int i7 = this.f47658e;
            i2 = Integer.MAX_VALUE;
            if (i7 == 0) {
                i7 = Integer.MAX_VALUE;
            }
            int i8 = version.f47658e;
            if (i8 != 0) {
                i2 = i8;
            }
        } else if (i6 != 3) {
            return i5;
        } else {
            i2 = 1;
            i = this.f47658e == 0 ? 1 : 0;
            if (version.f47658e != 0) {
                i2 = 0;
            }
        }
        return i - i2;
    }

    /* renamed from: com.didichuxing.foundation.util.Version$1 */
    static /* synthetic */ class C156881 {

        /* renamed from: $SwitchMap$com$didichuxing$foundation$util$Version$PreviewComparison */
        static final /* synthetic */ int[] f47661x7a4d5d7d;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didichuxing.foundation.util.Version$PreviewComparison[] r0 = com.didichuxing.foundation.util.Version.PreviewComparison.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47661x7a4d5d7d = r0
                com.didichuxing.foundation.util.Version$PreviewComparison r1 = com.didichuxing.foundation.util.Version.PreviewComparison.IGNORE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f47661x7a4d5d7d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.foundation.util.Version$PreviewComparison r1 = com.didichuxing.foundation.util.Version.PreviewComparison.COMPARE_NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f47661x7a4d5d7d     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.foundation.util.Version$PreviewComparison r1 = com.didichuxing.foundation.util.Version.PreviewComparison.COMPARE_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.util.Version.C156881.<clinit>():void");
        }
    }
}
