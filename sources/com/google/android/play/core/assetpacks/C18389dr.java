package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18489cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* renamed from: com.google.android.play.core.assetpacks.dr */
final class C18389dr {

    /* renamed from: a */
    private static final C18432ag f53048a = new C18432ag("SliceMetadataManager");

    /* renamed from: b */
    private final byte[] f53049b = new byte[8192];

    /* renamed from: c */
    private final C18319bb f53050c;

    /* renamed from: d */
    private final String f53051d;

    /* renamed from: e */
    private final int f53052e;

    /* renamed from: f */
    private final long f53053f;

    /* renamed from: g */
    private final String f53054g;

    /* renamed from: h */
    private int f53055h;

    C18389dr(C18319bb bbVar, String str, int i, long j, String str2) {
        this.f53050c = bbVar;
        this.f53051d = str;
        this.f53052e = i;
        this.f53053f = j;
        this.f53054g = str2;
        this.f53055h = -1;
    }

    /* renamed from: e */
    private final File m37666e() {
        File f = this.f53050c.mo148932f(this.f53051d, this.f53052e, this.f53053f, this.f53054g);
        if (!f.exists()) {
            f.mkdirs();
        }
        return f;
    }

    /* renamed from: f */
    private final File m37667f() throws IOException {
        File c = this.f53050c.mo148920c(this.f53051d, this.f53052e, this.f53053f, this.f53054g);
        c.getParentFile().mkdirs();
        c.createNewFile();
        return c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C18388dq mo149023a() throws IOException {
        File c = this.f53050c.mo148920c(this.f53051d, this.f53052e, this.f53053f, this.f53054g);
        if (c.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(c);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new C18339bv("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f53055h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new C18388dq(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e) {
                    throw new C18339bv("Slice checkpoint file corrupt.", (Exception) e);
                }
            } catch (Throwable th) {
                C18489cj.m37906a(th, th);
            }
        } else {
            throw new C18339bv("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149024a(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(mo149031b().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f53055h));
        FileOutputStream fileOutputStream = new FileOutputStream(m37667f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149025a(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo149031b(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149026a(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo149031b(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.f53049b);
                if (read > 0) {
                    randomAccessFile.write(this.f53049b, 0, read);
                }
            } while (read == this.f53049b.length);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149027a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f53055h));
        FileOutputStream fileOutputStream = new FileOutputStream(m37667f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149028a(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        this.f53055h++;
        try {
            fileOutputStream = new FileOutputStream(new File(m37666e(), String.format("%s-LFH.dat", new Object[]{Integer.valueOf(this.f53055h)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new C18339bv("Could not write metadata file.", (Exception) e);
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149029a(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f53055h));
        FileOutputStream fileOutputStream = new FileOutputStream(m37667f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File d = this.f53050c.mo148924d(this.f53051d, this.f53052e, this.f53053f, this.f53054g);
            if (d.exists()) {
                d.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(d);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                C18489cj.m37906a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            C18489cj.m37906a(th, th2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149030a(byte[] bArr, InputStream inputStream) throws IOException {
        this.f53055h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo149031b());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.f53049b);
            while (read > 0) {
                fileOutputStream.write(this.f53049b, 0, read);
                read = inputStream.read(this.f53049b);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo149031b() {
        return new File(m37666e(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f53055h)}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo149032b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f53055h));
        FileOutputStream fileOutputStream = new FileOutputStream(m37667f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo149033b(byte[] bArr, int i) throws IOException {
        this.f53055h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo149031b());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo149034c() throws IOException {
        File c = this.f53050c.mo148920c(this.f53051d, this.f53052e, this.f53053f, this.f53054g);
        if (!c.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(c);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C18339bv("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo149035d() {
        FileInputStream fileInputStream;
        File c = this.f53050c.mo148920c(this.f53051d, this.f53052e, this.f53053f, this.f53054g);
        if (!c.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(c);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") != null) {
                return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
            }
            f53048a.mo149083b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
            return false;
        } catch (IOException e) {
            f53048a.mo149083b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        } catch (Throwable th) {
            C18489cj.m37906a(th, th);
        }
        throw th;
    }
}
