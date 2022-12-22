package xcrash;

import android.os.Build;
import android.text.TextUtils;
import com.didi.soda.customer.app.constant.StringConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TombstoneParser {

    /* renamed from: a */
    private static final Pattern f7042a = Pattern.compile("^(.*):\\s'(.*?)'$");

    /* renamed from: b */
    private static final Pattern f7043b = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");

    /* renamed from: c */
    private static final Pattern f7044c = Pattern.compile("^pid:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");

    /* renamed from: d */
    private static final Pattern f7045d = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");

    /* renamed from: e */
    private static final Pattern f7046e = Pattern.compile("^(\\d{20})_(.*)__(.*)$");

    /* renamed from: f */
    private static final Set<String> f7047f = new HashSet(Arrays.asList(new String[]{keyTombstoneMaker, keyCrashType, keyStartTime, keyCrashTime, keyAppId, keyAppVersion, keyRooted, keyApiLevel, keyOsVersion, keyKernelVersion, keyAbiList, keyManufacturer, keyBrand, "Model", keyBuildFingerprint, keyAbi, keyAbortMessage}));

    /* renamed from: g */
    private static final Set<String> f7048g = new HashSet(Arrays.asList(new String[]{keyBacktrace, keyBuildId, "stack", keyMemoryMap, "logcat", keyOpenFiles, keyJavaStacktrace, keyXCrashError, keyXCrashErrorDebug}));

    /* renamed from: h */
    private static final Set<String> f7049h = new HashSet(Arrays.asList(new String[]{keyForeground}));
    public static final String keyAbi = "ABI";
    public static final String keyAbiList = "ABI list";
    public static final String keyAbortMessage = "Abort message";
    public static final String keyApiLevel = "API level";
    public static final String keyAppId = "App ID";
    public static final String keyAppVersion = "App version";
    public static final String keyBacktrace = "backtrace";
    public static final String keyBrand = "Brand";
    public static final String keyBuildFingerprint = "Build fingerprint";
    public static final String keyBuildId = "build id";
    public static final String keyCode = "code";
    public static final String keyCrashTime = "Crash time";
    public static final String keyCrashType = "Crash type";
    public static final String keyFaultAddr = "fault addr";
    public static final String keyForeground = "foreground";
    public static final String keyFromProcLimits = " Process Limits (From: /proc/PID/limits)";
    public static final String keyFromProcMemInfo = " System Summary (From: /proc/meminfo)";
    public static final String keyFromProcStatus = " Process Status (From: /proc/PID/status)";
    public static final String keyJavaStacktrace = "java stacktrace";
    public static final String keyKernelVersion = "Kernel version";
    public static final String keyLogcat = "logcat";
    public static final String keyManufacturer = "Manufacturer";
    public static final String keyMemoryInfo = "memory info";
    public static final String keyMemoryMap = "memory map";
    public static final String keyMemoryNear = "memory near";
    public static final String keyModel = "Model";
    public static final String keyNetworkInfo = "network info";
    public static final String keyOpenFiles = "open files";
    public static final String keyOsVersion = "OS version";
    public static final String keyOtherThreads = "other threads";
    public static final String keyProcessDalvikDetailsFromProcSmaps = " Process Dalvik Details (From: /proc/PID/smaps)";
    public static final String keyProcessDetailsFromProcSmaps = " Process Details (From: /proc/PID/smaps)";
    public static final String keyProcessId = "pid";
    public static final String keyProcessName = "pname";
    public static final String keyProcessSummaryFromProcSmaps = " Process Summary (From: /proc/PID/smaps)";
    public static final String keyRegisters = "registers";
    public static final String keyRooted = "Rooted";
    public static final String keySignal = "signal";
    public static final String keyStack = "stack";
    public static final String keyStartTime = "Start time";
    public static final String keyThreadId = "tid";
    public static final String keyThreadName = "tname";
    public static final String keyTombstoneMaker = "Tombstone maker";
    public static final String keyXCrashError = "xcrash error";
    public static final String keyXCrashErrorDebug = "xcrash error debug";

    private enum Status {
        UNKNOWN,
        HEAD,
        SECTION
    }

    private TombstoneParser() {
    }

    public static Map<String, String> parse(File file) throws IOException {
        return parse(file.getAbsolutePath(), (String) null);
    }

    public static Map<String, String> parse(String str) throws IOException {
        return parse(str, (String) null);
    }

    public static Map<String, String> parse(String str, String str2) throws IOException {
        HashMap hashMap = new HashMap();
        if (str != null) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            m4186a((Map<String, String>) hashMap, bufferedReader, true);
            bufferedReader.close();
        }
        if (str2 != null) {
            BufferedReader bufferedReader2 = new BufferedReader(new StringReader(str2));
            m4186a((Map<String, String>) hashMap, bufferedReader2, false);
            bufferedReader2.close();
        }
        m4187a(hashMap, str);
        if (TextUtils.isEmpty((String) hashMap.get(keyAppVersion))) {
            String appVersion = XCrash.getAppVersion();
            if (TextUtils.isEmpty(appVersion)) {
                appVersion = "unknown";
            }
            hashMap.put(keyAppVersion, appVersion);
        }
        m4185a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private static void m4187a(Map<String, String> map, String str) {
        String str2;
        if (str != null) {
            if (TextUtils.isEmpty(map.get(keyCrashTime))) {
                map.put(keyCrashTime, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date(new File(str).lastModified())));
            }
            String str3 = map.get(keyStartTime);
            String str4 = map.get(keyAppVersion);
            String str5 = map.get(keyProcessName);
            String str6 = map.get(keyCrashType);
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6)) {
                String substring = str.substring(str.lastIndexOf(47) + 1);
                if (!substring.isEmpty() && substring.startsWith("tombstone_")) {
                    String substring2 = substring.substring(10);
                    if (substring2.endsWith(".java.xcrash")) {
                        if (TextUtils.isEmpty(str6)) {
                            map.put(keyCrashType, StringConst.JAVA);
                        }
                        str2 = substring2.substring(0, substring2.length() - 12);
                    } else if (substring2.endsWith(".native.xcrash")) {
                        if (TextUtils.isEmpty(str6)) {
                            map.put(keyCrashType, "native");
                        }
                        str2 = substring2.substring(0, substring2.length() - 14);
                    } else if (substring2.endsWith(".anr.xcrash")) {
                        if (TextUtils.isEmpty(str6)) {
                            map.put(keyCrashType, "anr");
                        }
                        str2 = substring2.substring(0, substring2.length() - 11);
                    } else {
                        return;
                    }
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                        Matcher matcher = f7046e.matcher(str2);
                        if (matcher.find() && matcher.groupCount() == 3) {
                            if (TextUtils.isEmpty(str3)) {
                                map.put(keyStartTime, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date(Long.parseLong(matcher.group(1), 10) / 1000)));
                            }
                            if (TextUtils.isEmpty(str4)) {
                                map.put(keyAppVersion, matcher.group(2));
                            }
                            if (TextUtils.isEmpty(str5)) {
                                map.put(keyProcessName, matcher.group(3));
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m4185a(Map<String, String> map) {
        if (TextUtils.isEmpty(map.get(keyAppId))) {
            map.put(keyAppId, XCrash.getAppId());
        }
        if (TextUtils.isEmpty(map.get(keyTombstoneMaker))) {
            map.put(keyTombstoneMaker, "xCrash 3.0.0");
        }
        if (TextUtils.isEmpty(map.get(keyRooted))) {
            map.put(keyRooted, C3160Util.m4197a() ? "Yes" : "No");
        }
        if (TextUtils.isEmpty(map.get(keyApiLevel))) {
            map.put(keyApiLevel, String.valueOf(Build.VERSION.SDK_INT));
        }
        if (TextUtils.isEmpty(map.get(keyOsVersion))) {
            map.put(keyOsVersion, Build.VERSION.RELEASE);
        }
        if (TextUtils.isEmpty(map.get(keyBuildFingerprint))) {
            map.put("Model", Build.FINGERPRINT);
        }
        if (TextUtils.isEmpty(map.get(keyManufacturer))) {
            map.put(keyManufacturer, Build.MANUFACTURER);
        }
        if (TextUtils.isEmpty(map.get(keyBrand))) {
            map.put(keyBrand, Build.BRAND);
        }
        if (TextUtils.isEmpty(map.get("Model"))) {
            map.put("Model", C3160Util.getMobileModel());
        }
        if (TextUtils.isEmpty(map.get(keyAbiList))) {
            map.put(keyAbiList, C3160Util.m4200b());
        }
    }

    /* renamed from: a */
    private static String m4184a(BufferedReader bufferedReader) throws IOException {
        try {
            bufferedReader.mark(2);
            int i = 0;
            while (i < 2) {
                try {
                    int read = bufferedReader.read();
                    if (read == -1) {
                        bufferedReader.reset();
                        return null;
                    } else if (read > 0) {
                        bufferedReader.reset();
                        return bufferedReader.readLine();
                    } else {
                        i++;
                    }
                } catch (Exception unused) {
                    bufferedReader.reset();
                    return bufferedReader.readLine();
                }
            }
            bufferedReader.reset();
            return null;
        } catch (Exception unused2) {
            return bufferedReader.readLine();
        }
    }

    /* renamed from: a */
    private static void m4186a(Map<String, String> map, BufferedReader bufferedReader, boolean z) throws IOException {
        String str;
        Map<String, String> map2 = map;
        StringBuilder sb = new StringBuilder();
        Status status = Status.UNKNOWN;
        String a = z ? m4184a(bufferedReader) : bufferedReader.readLine();
        int i = 1;
        boolean z2 = a == null;
        String str2 = null;
        String str3 = "";
        boolean z3 = false;
        boolean z4 = false;
        while (!z2) {
            String a2 = z ? m4184a(bufferedReader) : bufferedReader.readLine();
            boolean z5 = a2 == null;
            int i2 = C31591.$SwitchMap$xcrash$TombstoneParser$Status[status.ordinal()];
            if (i2 != i) {
                if (i2 == 2) {
                    if (a.startsWith("pid: ")) {
                        Matcher matcher = f7043b.matcher(a);
                        if (!matcher.find() || matcher.groupCount() != 4) {
                            Matcher matcher2 = f7044c.matcher(a);
                            if (matcher2.find() && matcher2.groupCount() == 2) {
                                m4188a(map2, "pid", matcher2.group(1));
                                m4188a(map2, keyProcessName, matcher2.group(2));
                            }
                        } else {
                            m4188a(map2, "pid", matcher.group(1));
                            m4188a(map2, keyThreadId, matcher.group(2));
                            m4188a(map2, keyThreadName, matcher.group(3));
                            m4188a(map2, keyProcessName, matcher.group(4));
                        }
                    } else if (a.startsWith("signal ")) {
                        Matcher matcher3 = f7045d.matcher(a);
                        if (matcher3.find() && matcher3.groupCount() == 3) {
                            m4188a(map2, "signal", matcher3.group(1));
                            m4188a(map2, "code", matcher3.group(2));
                            m4188a(map2, keyFaultAddr, matcher3.group(3));
                        }
                    } else {
                        Matcher matcher4 = f7042a.matcher(a);
                        if (matcher4.find() && matcher4.groupCount() == 2 && f7047f.contains(matcher4.group(1))) {
                            m4188a(map2, matcher4.group(1), matcher4.group(2));
                        }
                    }
                    if (a2 != null && (a2.startsWith("    r0 ") || a2.startsWith("    x0 ") || a2.startsWith("    eax ") || a2.startsWith("    rax "))) {
                        status = Status.SECTION;
                        str2 = keyRegisters;
                        str3 = "";
                        z3 = true;
                        z4 = false;
                    }
                    if (a2 == null || a2.isEmpty()) {
                        status = Status.UNKNOWN;
                    }
                } else if (i2 == 3) {
                    if (a.equals(str3) || z5) {
                        if (f7049h.contains(str2) && sb.length() > 0 && sb.charAt(sb.length() - 1) == 10) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        m4189a(map2, str2, sb.toString(), z4);
                        sb.setLength(0);
                        status = Status.UNKNOWN;
                    } else {
                        if (z3) {
                            if (str2.equals(keyJavaStacktrace) && a.startsWith(" ")) {
                                a = a.trim();
                            } else if (a.startsWith("    ")) {
                                a = a.substring(4);
                            }
                        }
                        sb.append(a);
                        sb.append(10);
                    }
                }
            } else if (a.equals("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***")) {
                status = Status.HEAD;
            } else {
                if (a.equals("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---")) {
                    status = Status.SECTION;
                    sb.append(a);
                    sb.append(10);
                    str3 = "+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++";
                    str = keyOtherThreads;
                } else if (a.length() <= 1 || !a.endsWith(":")) {
                    if (a.length() > 1 && (a.equals(keyFromProcMemInfo) || a.equals(keyFromProcStatus) || a.equals(keyFromProcLimits) || a.equals(keyProcessDetailsFromProcSmaps) || a.equals(keyProcessDalvikDetailsFromProcSmaps) || a.equals(keyProcessSummaryFromProcSmaps))) {
                        status = Status.SECTION;
                        sb.append(a);
                        sb.append(10);
                        str3 = "-";
                        str2 = a;
                        z3 = false;
                        z4 = true;
                    }
                    a = a2;
                    z2 = z5;
                    i = 1;
                } else {
                    status = Status.SECTION;
                    String substring = a.substring(0, a.length() - 1);
                    if (f7048g.contains(substring)) {
                        z3 = substring.equals(keyBacktrace) || substring.equals(keyBuildId) || substring.equals("stack") || substring.equals(keyMemoryMap) || substring.equals(keyOpenFiles) || substring.equals(keyJavaStacktrace) || substring.equals(keyXCrashErrorDebug);
                        z4 = substring.equals(keyXCrashError);
                        str2 = substring;
                        str3 = "";
                    } else {
                        if (substring.equals(keyMemoryInfo)) {
                            str2 = substring;
                        } else if (substring.startsWith("memory near ")) {
                            sb.append(a);
                            sb.append(10);
                            str2 = keyMemoryNear;
                        } else {
                            str = substring;
                            str3 = "";
                        }
                        str3 = "";
                        z3 = false;
                        z4 = true;
                    }
                    a = a2;
                    z2 = z5;
                    i = 1;
                }
                z3 = false;
                z4 = false;
                a = a2;
                z2 = z5;
                i = 1;
            }
            a = a2;
            z2 = z5;
            i = 1;
        }
    }

    /* renamed from: xcrash.TombstoneParser$1 */
    static /* synthetic */ class C31591 {
        static final /* synthetic */ int[] $SwitchMap$xcrash$TombstoneParser$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                xcrash.TombstoneParser$Status[] r0 = xcrash.TombstoneParser.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$xcrash$TombstoneParser$Status = r0
                xcrash.TombstoneParser$Status r1 = xcrash.TombstoneParser.Status.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$xcrash$TombstoneParser$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                xcrash.TombstoneParser$Status r1 = xcrash.TombstoneParser.Status.HEAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$xcrash$TombstoneParser$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                xcrash.TombstoneParser$Status r1 = xcrash.TombstoneParser.Status.SECTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xcrash.TombstoneParser.C31591.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static void m4188a(Map<String, String> map, String str, String str2) {
        m4189a(map, str, str2, false);
    }

    /* renamed from: a */
    private static void m4189a(Map<String, String> map, String str, String str2, boolean z) {
        if (str != null && !str.isEmpty() && str2 != null) {
            String str3 = map.get(str);
            if (z) {
                if (str3 != null) {
                    str2 = str3 + str2;
                }
                map.put(str, str2);
            } else if (str3 == null || (str3.isEmpty() && !str2.isEmpty())) {
                map.put(str, str2);
            }
        }
    }
}
