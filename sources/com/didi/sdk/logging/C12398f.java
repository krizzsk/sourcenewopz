package com.didi.sdk.logging;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* renamed from: com.didi.sdk.logging.f */
/* compiled from: ResilientFileOutputStream */
class C12398f extends OutputStream {

    /* renamed from: a */
    protected OutputStream f36548a = new BufferedOutputStream(this.f36551d);

    /* renamed from: b */
    protected boolean f36549b = true;

    /* renamed from: c */
    private File f36550c;

    /* renamed from: d */
    private FileOutputStream f36551d;

    /* renamed from: e */
    private C12397e f36552e;

    C12398f(File file, boolean z) throws FileNotFoundException {
        this.f36550c = file;
        this.f36551d = new FileOutputStream(file, z);
    }

    /* renamed from: f */
    private boolean m25900f() {
        return this.f36552e != null && !this.f36549b;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!m25900f()) {
            try {
                this.f36548a.write(bArr, i, i2);
                m25901g();
            } catch (IOException e) {
                mo92608a(e);
            }
        } else if (!this.f36552e.mo92606a()) {
            mo92613e();
        }
    }

    public void write(int i) {
        if (!m25900f()) {
            try {
                this.f36548a.write(i);
                m25901g();
            } catch (IOException e) {
                mo92608a(e);
            }
        } else if (!this.f36552e.mo92606a()) {
            mo92613e();
        }
    }

    public void flush() {
        OutputStream outputStream = this.f36548a;
        if (outputStream != null) {
            try {
                outputStream.flush();
                m25901g();
            } catch (IOException e) {
                mo92608a(e);
            }
        }
    }

    /* renamed from: a */
    public FileChannel mo92607a() {
        if (this.f36548a == null) {
            return null;
        }
        return this.f36551d.getChannel();
    }

    /* renamed from: b */
    public File mo92609b() {
        return this.f36550c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo92610c() {
        return "mFile [" + this.f36550c + Const.jaRight;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public OutputStream mo92612d() throws IOException {
        this.f36551d = new FileOutputStream(this.f36550c, true);
        return new BufferedOutputStream(this.f36551d);
    }

    /* renamed from: g */
    private void m25901g() {
        if (this.f36552e != null) {
            this.f36552e = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo92608a(IOException iOException) {
        this.f36549b = false;
        if (this.f36552e == null) {
            this.f36552e = new C12397e();
        }
    }

    public void close() throws IOException {
        OutputStream outputStream = this.f36548a;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo92613e() {
        /*
            r1 = this;
            r1.close()     // Catch:{ IOException -> 0x0003 }
        L_0x0003:
            java.io.OutputStream r0 = r1.mo92612d()     // Catch:{ IOException -> 0x000c }
            r1.f36548a = r0     // Catch:{ IOException -> 0x000c }
            r0 = 1
            r1.f36549b = r0     // Catch:{ IOException -> 0x000c }
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.C12398f.mo92613e():void");
    }
}
