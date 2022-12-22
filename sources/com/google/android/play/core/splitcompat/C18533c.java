package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18448aw;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.c */
public final class C18533c {

    /* renamed from: a */
    private final long f53228a;

    /* renamed from: b */
    private final Context f53229b;

    /* renamed from: c */
    private File f53230c;

    public C18533c(Context context) throws PackageManager.NameNotFoundException {
        this.f53229b = context;
        this.f53228a = (long) SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
    }

    /* renamed from: a */
    private static File m38039a(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    /* renamed from: c */
    public static void m38040c(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File c : listFiles) {
                m38040c(c);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: d */
    private static void m38041d(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    /* renamed from: f */
    private final File m38042f() throws IOException {
        File file = new File(m38043g(), "verified-splits");
        m38041d(file);
        return file;
    }

    /* renamed from: g */
    private final File m38043g() throws IOException {
        File file = new File(m38045h(), Long.toString(this.f53228a));
        m38041d(file);
        return file;
    }

    /* renamed from: g */
    private final File m38044g(String str) throws IOException {
        File a = m38039a(m38047i(), str);
        m38041d(a);
        return a;
    }

    /* renamed from: h */
    private final File m38045h() throws IOException {
        if (this.f53230c == null) {
            Context context = this.f53229b;
            if (context != null) {
                this.f53230c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f53230c, "splitcompat");
        m38041d(file);
        return file;
    }

    /* renamed from: h */
    private static String m38046h(String str) {
        return String.valueOf(str).concat(".apk");
    }

    /* renamed from: i */
    private final File m38047i() throws IOException {
        File file = new File(m38043g(), "native-libraries");
        m38041d(file);
        return file;
    }

    /* renamed from: a */
    public final File mo149216a(File file) throws IOException {
        return m38039a(m38042f(), file.getName());
    }

    /* renamed from: a */
    public final File mo149217a(String str) throws IOException {
        return m38039a(mo149223c(), m38046h(str));
    }

    /* renamed from: a */
    public final File mo149218a(String str, String str2) throws IOException {
        return m38039a(m38044g(str), str2);
    }

    /* renamed from: a */
    public final void mo149219a() throws IOException {
        File h = m38045h();
        String[] list = h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f53228a))) {
                    File file = new File(h, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f53228a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    SystemUtils.log(3, "SplitCompat", sb.toString(), (Throwable) null, "com.google.android.play.core.splitcompat.c", -1);
                    m38040c(file);
                }
            }
        }
    }

    /* renamed from: b */
    public final File mo149220b() throws IOException {
        return new File(m38043g(), "lock.tmp");
    }

    /* renamed from: b */
    public final File mo149221b(String str) throws IOException {
        return m38039a(m38042f(), m38046h(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo149222b(File file) throws IOException {
        C18448aw.m37798a(file.getParentFile().getParentFile().equals(m38047i()), (Object) "File to remove is not a native library");
        m38040c(file);
    }

    /* renamed from: c */
    public final File mo149223c() throws IOException {
        File file = new File(m38043g(), "unverified-splits");
        m38041d(file);
        return file;
    }

    /* renamed from: c */
    public final File mo149224c(String str) throws IOException {
        File file = new File(m38043g(), "dex");
        m38041d(file);
        File a = m38039a(file, str);
        m38041d(a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final Set<C18547q> mo149225d() throws IOException {
        File f = m38042f();
        HashSet hashSet = new HashSet();
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new C18547q(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo149226d(String str) throws IOException {
        m38040c(m38044g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<String> mo149227e() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = m38047i().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final Set<File> mo149228e(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = m38044g(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo149229f(String str) throws IOException {
        m38040c(mo149221b(str));
    }
}
