package com.didi.sdk.audiorecorder.utils.log;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* renamed from: com.didi.sdk.audiorecorder.utils.log.b */
/* compiled from: ResilientFileOutputStream */
final class C12126b extends OutputStream {

    /* renamed from: a */
    protected OutputStream f35608a;

    /* renamed from: b */
    protected boolean f35609b = true;

    /* renamed from: c */
    private File f35610c;

    /* renamed from: d */
    private FileOutputStream f35611d;

    /* renamed from: e */
    private C12125a f35612e;

    public C12126b(File file, boolean z) throws FileNotFoundException {
        this.f35610c = file;
        this.f35611d = new FileOutputStream(file, z);
        this.f35608a = new BufferedOutputStream(this.f35611d);
        this.f35609b = true;
    }

    /* renamed from: f */
    private boolean m25209f() {
        return this.f35612e != null && !this.f35609b;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!m25209f()) {
            try {
                this.f35608a.write(bArr, i, i2);
                m25210g();
            } catch (IOException e) {
                mo91283a(e);
            }
        } else if (!this.f35612e.mo91281a()) {
            mo91288e();
        }
    }

    public void write(int i) {
        if (!m25209f()) {
            try {
                this.f35608a.write(i);
                m25210g();
            } catch (IOException e) {
                mo91283a(e);
            }
        } else if (!this.f35612e.mo91281a()) {
            mo91288e();
        }
    }

    public void flush() {
        OutputStream outputStream = this.f35608a;
        if (outputStream != null) {
            try {
                outputStream.flush();
                m25210g();
            } catch (IOException e) {
                mo91283a(e);
            }
        }
    }

    /* renamed from: a */
    public FileChannel mo91282a() {
        if (this.f35608a == null) {
            return null;
        }
        return this.f35611d.getChannel();
    }

    /* renamed from: b */
    public File mo91284b() {
        return this.f35610c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo91285c() {
        return "mFile [" + this.f35610c + Const.jaRight;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public OutputStream mo91287d() throws IOException {
        this.f35611d = new FileOutputStream(this.f35610c, true);
        return new BufferedOutputStream(this.f35611d);
    }

    /* renamed from: g */
    private void m25210g() {
        if (this.f35612e != null) {
            this.f35612e = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91283a(IOException iOException) {
        this.f35609b = false;
        if (this.f35612e == null) {
            this.f35612e = new C12125a();
        }
    }

    public void close() throws IOException {
        OutputStream outputStream = this.f35608a;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo91288e() {
        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.f35608a = mo91287d();
            this.f35609b = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
