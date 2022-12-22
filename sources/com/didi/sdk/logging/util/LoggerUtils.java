package com.didi.sdk.logging.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.utils.TimeUtil;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.p071io.FileUtils;

public class LoggerUtils {

    /* renamed from: a */
    private static final String f36656a = "yyyy-MM-dd";

    /* renamed from: b */
    private static final String f36657b = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: c */
    private static final CachingDateFormatter f36658c = new CachingDateFormatter("yyyy-MM-dd");

    /* renamed from: d */
    private static final CachingDateFormatter f36659d = new CachingDateFormatter("yyyy-MM-dd HH:mm:ss");

    /* renamed from: e */
    private static final Pattern f36660e = Pattern.compile("^(logback|binary)-(\\w+)-(\\d{4}-\\d{2}-\\d{2})( \\d{2}:\\d{2}:\\d{2})?-(\\d{1,3})\\.log");

    /* renamed from: f */
    private static ThreadLocal<DateFormat> f36661f = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return new SimpleDateFormat(TimeUtil.YMD_HMSS, Locale.getDefault());
        }
    };

    public static boolean isOverlap(long j, long j2, long j3, long j4) {
        return j <= j4 && j2 >= j3;
    }

    private LoggerUtils() {
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isConnected()) {
            return IStoreCallback.DEFAULT_API_DETAIL_KEY;
        }
        return activeNetworkInfo.getTypeName().toUpperCase();
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static File[] collectLogFiles(File file) {
        return file.listFiles();
    }

    public static File[] collectLogFiles(File file, String str, Date date) {
        return collectLogFiles(file, (String) null, str, formatForMatch(date));
    }

    public static File[] collectLogFiles(File file, String str, String str2) {
        return collectLogFiles(file, (String) null, str, str2);
    }

    public static File[] collectLogFiles(File file, String str, String str2, final String str3) {
        final String[] split = TextUtils.isEmpty(str2) ? new String[0] : str2.trim().split(",");
        final Pattern logFileRegex = str == null ? f36660e : getLogFileRegex(str);
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                File file2 = new File(file, str);
                if (file2.isDirectory() || file2.length() == 0) {
                    return false;
                }
                Matcher matcher = logFileRegex.matcher(str);
                if (!matcher.matches()) {
                    return false;
                }
                String[] strArr = split;
                if (strArr.length == 0) {
                    return TextUtils.equals(matcher.group(3), str3);
                }
                for (String equals : strArr) {
                    if (TextUtils.equals(matcher.group(2), equals) && TextUtils.equals(matcher.group(3), str3)) {
                        return true;
                    }
                }
                return false;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    public static File[] collectLogFiles(File file, String str, String str2, Date date, Date date2) {
        final String[] split = TextUtils.isEmpty(str2) ? new String[0] : str2.trim().split(",");
        final Pattern logFileRegex = str == null ? f36660e : getLogFileRegex(str);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final Date date3 = date;
        final Date date4 = date2;
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                File file2 = new File(file, str);
                if (file2.isDirectory() || file2.length() == 0) {
                    return false;
                }
                Matcher matcher = logFileRegex.matcher(str);
                if (!matcher.matches()) {
                    return false;
                }
                try {
                    long time = simpleDateFormat.parse(matcher.group(3) + matcher.group(4)).getTime();
                    long lastModified = file2.lastModified();
                    long time2 = date3.getTime();
                    long time3 = date4.getTime();
                    if (split.length == 0) {
                        return LoggerUtils.isOverlap(time, lastModified, time2, time3);
                    }
                    for (String equals : split) {
                        if (TextUtils.equals(matcher.group(2), equals)) {
                            return LoggerUtils.isOverlap(time, lastModified, time2, time3);
                        }
                    }
                    return false;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    public static Pattern getLogFileRegex(String str) {
        return Pattern.compile("^(" + str + ")-(\\w+)-(\\d{4}-\\d{2}-\\d{2})( \\d{2}:\\d{2}:\\d{2})?-(\\d{1,3})\\.log");
    }

    public static List<File> collectLogFilesWithRange(File file, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date parse = simpleDateFormat.parse(str3);
            Calendar instance = Calendar.getInstance();
            for (Date parse2 = simpleDateFormat.parse(str2); parse2.compareTo(parse) <= 0; parse2 = instance.getTime()) {
                File[] collectLogFiles = collectLogFiles(file, (String) null, str, simpleDateFormat.format(parse2));
                if (collectLogFiles != null && collectLogFiles.length > 0) {
                    arrayList.addAll(Arrays.asList(collectLogFiles));
                }
                instance.setTime(parse2);
                instance.add(5, 1);
            }
        } catch (ParseException unused) {
        }
        return arrayList;
    }

    public static List<File> collectLogFilesWithRange(File file, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        File[] collectLogFiles = collectLogFiles(file, (String) null, str, new Date(j * 1000), new Date(j2 * 1000));
        if (collectLogFiles.length > 0) {
            arrayList.addAll(Arrays.asList(collectLogFiles));
        }
        return arrayList;
    }

    public static List<File> collectExtraLogFiles(File file) {
        ArrayList arrayList = new ArrayList();
        if (file != null && file.exists() && file.isDirectory()) {
            arrayList.addAll(FileUtils.collectAllFiles(file));
        }
        return arrayList;
    }

    public static String formatForMatch(Date date) {
        return f36658c.format(date.getTime());
    }

    public static String formatForNewFile(Date date) {
        return f36659d.format(date.getTime());
    }

    public static String formatForLogHead(Date date) {
        return f36661f.get().format(Long.valueOf(date.getTime()));
    }

    public static String formatFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format((double) j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(((double) j) / 1024.0d) + "KB";
        } else if (j < FileUtils.ONE_GB) {
            return decimalFormat.format(((double) j) / 1048576.0d) + "MB";
        } else {
            return decimalFormat.format(((double) j) / 1.073741824E9d) + GlobalCountryCode.ENGLAND;
        }
    }

    public static String currentProcessName(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            try {
                str = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
                str = null;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    public static String dumpBundleArray(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        for (int i = 0; i < bundleArr.length; i++) {
            sb.append(dumpBundle(bundleArr[i]));
            if (i < bundleArr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public static String dumpBundle(Bundle bundle) {
        String str;
        if (bundle == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder(Const.joLeft);
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            sb.append(str2);
            sb.append("=");
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                if (obj == bundle) {
                    str = "{this}";
                } else {
                    str = dumpBundle((Bundle) obj);
                }
            } else if (obj instanceof Bundle[]) {
                str = dumpBundleArray((Bundle[]) obj);
            } else if (obj instanceof Object[]) {
                str = Arrays.toString((Object[]) obj);
            } else {
                str = String.valueOf(obj);
            }
            sb.append(str);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
