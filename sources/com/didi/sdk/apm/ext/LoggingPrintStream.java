package com.didi.sdk.apm.ext;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Formatter;
import java.util.Locale;

public abstract class LoggingPrintStream extends PrintStream {

    /* renamed from: a */
    private final StringBuilder f35025a = new StringBuilder();

    /* renamed from: b */
    private ByteBuffer f35026b;

    /* renamed from: c */
    private CharBuffer f35027c;

    /* renamed from: d */
    private CharsetDecoder f35028d;

    /* renamed from: e */
    private final Formatter f35029e = new Formatter(this.f35025a, (Locale) null);

    public boolean checkError() {
        return false;
    }

    public void close() {
    }

    /* access modifiers changed from: protected */
    public abstract void log(String str);

    /* access modifiers changed from: protected */
    public void setError() {
    }

    protected LoggingPrintStream() {
        super(new OutputStream() {
            public void write(int i) throws IOException {
                throw new AssertionError();
            }
        });
    }

    public synchronized void flush() {
        m24759a(true);
    }

    /* renamed from: a */
    private void m24759a(boolean z) {
        int length = this.f35025a.length();
        int i = 0;
        while (i < length) {
            int indexOf = this.f35025a.indexOf("\n", i);
            if (indexOf == -1) {
                break;
            }
            log(this.f35025a.substring(i, indexOf));
            i = indexOf + 1;
        }
        if (z) {
            if (i < length) {
                log(this.f35025a.substring(i));
            }
            this.f35025a.setLength(0);
            return;
        }
        this.f35025a.delete(0, i);
    }

    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        CoderResult decode;
        if (this.f35028d == null) {
            this.f35026b = ByteBuffer.allocate(80);
            this.f35027c = CharBuffer.allocate(80);
            this.f35028d = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        }
        int i3 = i2 + i;
        while (i < i3) {
            int min = Math.min(this.f35026b.remaining(), i3 - i);
            this.f35026b.put(bArr, i, min);
            i += min;
            this.f35026b.flip();
            do {
                decode = this.f35028d.decode(this.f35026b, this.f35027c, false);
                this.f35027c.flip();
                this.f35025a.append(this.f35027c);
                this.f35027c.clear();
            } while (decode.isOverflow());
            this.f35026b.compact();
        }
        m24759a(false);
    }

    public PrintStream format(String str, Object... objArr) {
        return format(Locale.getDefault(), str, objArr);
    }

    public PrintStream printf(String str, Object... objArr) {
        return format(str, objArr);
    }

    public PrintStream printf(Locale locale, String str, Object... objArr) {
        return format(locale, str, objArr);
    }

    public synchronized PrintStream format(Locale locale, String str, Object... objArr) {
        if (str != null) {
            this.f35029e.format(locale, str, objArr);
            m24759a(false);
        } else {
            throw new NullPointerException("format");
        }
        return this;
    }

    public synchronized void print(char[] cArr) {
        this.f35025a.append(cArr);
        m24759a(false);
    }

    public synchronized void print(char c) {
        this.f35025a.append(c);
        if (c == 10) {
            m24759a(false);
        }
    }

    public synchronized void print(double d) {
        this.f35025a.append(d);
    }

    public synchronized void print(float f) {
        this.f35025a.append(f);
    }

    public synchronized void print(int i) {
        this.f35025a.append(i);
    }

    public synchronized void print(long j) {
        this.f35025a.append(j);
    }

    public synchronized void print(Object obj) {
        this.f35025a.append(obj);
        m24759a(false);
    }

    public synchronized void print(String str) {
        this.f35025a.append(str);
        m24759a(false);
    }

    public synchronized void print(boolean z) {
        this.f35025a.append(z);
    }

    public synchronized void println() {
        m24759a(true);
    }

    public synchronized void println(char[] cArr) {
        this.f35025a.append(cArr);
        m24759a(true);
    }

    public synchronized void println(char c) {
        this.f35025a.append(c);
        m24759a(true);
    }

    public synchronized void println(double d) {
        this.f35025a.append(d);
        m24759a(true);
    }

    public synchronized void println(float f) {
        this.f35025a.append(f);
        m24759a(true);
    }

    public synchronized void println(int i) {
        this.f35025a.append(i);
        m24759a(true);
    }

    public synchronized void println(long j) {
        this.f35025a.append(j);
        m24759a(true);
    }

    public synchronized void println(Object obj) {
        this.f35025a.append(obj);
        m24759a(true);
    }

    public synchronized void println(String str) {
        if (this.f35025a.length() != 0 || str == null) {
            this.f35025a.append(str);
            m24759a(true);
        } else {
            int length = str.length();
            int i = 0;
            while (i < length) {
                int indexOf = str.indexOf(10, i);
                if (indexOf == -1) {
                    break;
                }
                log(str.substring(i, indexOf));
                i = indexOf + 1;
            }
            if (i < length) {
                log(str.substring(i));
            }
        }
    }

    public synchronized void println(boolean z) {
        this.f35025a.append(z);
        m24759a(true);
    }

    public synchronized PrintStream append(char c) {
        print(c);
        return this;
    }

    public synchronized PrintStream append(CharSequence charSequence) {
        this.f35025a.append(charSequence);
        m24759a(false);
        return this;
    }

    public synchronized PrintStream append(CharSequence charSequence, int i, int i2) {
        this.f35025a.append(charSequence, i, i2);
        m24759a(false);
        return this;
    }
}
