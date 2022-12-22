package com.didi.sdk.apm.ext;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class VoidPrintStream extends PrintStream {
    public boolean checkError() {
        return false;
    }

    public void close() {
    }

    public PrintStream format(String str, Object... objArr) {
        return this;
    }

    public PrintStream printf(String str, Object... objArr) {
        return this;
    }

    public PrintStream printf(Locale locale, String str, Object... objArr) {
        return this;
    }

    /* access modifiers changed from: protected */
    public void setError() {
    }

    public void write(int i) {
    }

    public void write(byte[] bArr) {
    }

    public VoidPrintStream() {
        super(new OutputStream() {
            public void write(int i) throws IOException {
            }
        });
    }

    public synchronized void flush() {
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
    }

    public synchronized PrintStream format(Locale locale, String str, Object... objArr) {
        return this;
    }

    public synchronized void print(char[] cArr) {
    }

    public synchronized void print(char c) {
    }

    public synchronized void print(double d) {
    }

    public synchronized void print(float f) {
    }

    public synchronized void print(int i) {
    }

    public synchronized void print(long j) {
    }

    public synchronized void print(Object obj) {
    }

    public synchronized void print(String str) {
    }

    public synchronized void print(boolean z) {
    }

    public synchronized void println() {
    }

    public synchronized void println(char[] cArr) {
    }

    public synchronized void println(char c) {
    }

    public synchronized void println(double d) {
    }

    public synchronized void println(float f) {
    }

    public synchronized void println(int i) {
    }

    public synchronized void println(long j) {
    }

    public synchronized void println(Object obj) {
    }

    public synchronized void println(String str) {
    }

    public synchronized void println(boolean z) {
    }

    public synchronized PrintStream append(char c) {
        return this;
    }

    public synchronized PrintStream append(CharSequence charSequence) {
        return this;
    }

    public synchronized PrintStream append(CharSequence charSequence, int i, int i2) {
        return this;
    }
}
