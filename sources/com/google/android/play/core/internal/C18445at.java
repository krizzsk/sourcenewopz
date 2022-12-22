package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitcompat.C18533c;
import com.google.android.play.core.splitcompat.C18546p;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.C18576d;
import com.google.android.play.core.splitinstall.C18578f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.internal.at */
public final class C18445at implements C18578f {

    /* renamed from: a */
    private final Context f53154a;

    /* renamed from: b */
    private final C18533c f53155b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C18446au f53156c;

    /* renamed from: d */
    private final Executor f53157d;

    /* renamed from: e */
    private final C18546p f53158e;

    public C18445at(Context context, Executor executor, C18446au auVar, C18533c cVar, C18546p pVar) {
        this.f53154a = context;
        this.f53155b = cVar;
        this.f53156c = auVar;
        this.f53157d = executor;
        this.f53158e = pVar;
    }

    /* renamed from: a */
    private final Integer m37786a(List<Intent> list) {
        FileChannel channel;
        FileLock fileLock;
        Exception exc;
        String str;
        String str2;
        int i;
        String str3;
        FileOutputStream fileOutputStream;
        try {
            channel = new RandomAccessFile(this.f53155b.mo149220b(), "rw").getChannel();
            Integer num = null;
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLock = null;
            }
            if (fileLock != null) {
                int i2 = 0;
                try {
                    SystemUtils.log(4, "SplitCompat", "Copying splits.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                    for (Intent next : list) {
                        String stringExtra = next.getStringExtra("split_id");
                        AssetFileDescriptor openAssetFileDescriptor = this.f53154a.getContentResolver().openAssetFileDescriptor(next.getData(), "r");
                        File a = this.f53155b.mo149217a(stringExtra);
                        if (!a.exists() || a.length() == openAssetFileDescriptor.getLength()) {
                            if (a.exists()) {
                            }
                        }
                        if (!this.f53155b.mo149221b(stringExtra).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                            try {
                                fileOutputStream = new FileOutputStream(a);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                bufferedInputStream.close();
                                throw th;
                            }
                        }
                    }
                    SystemUtils.log(4, "SplitCompat", "Splits copied.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                    try {
                        if (!this.f53156c.mo149098a()) {
                            str = "SplitCompat";
                            str2 = "Split verification failed.";
                            i = 6;
                            exc = null;
                            str3 = "com.google.android.play.core.internal.at";
                            SystemUtils.log(i, str, str2, exc, str3, -1);
                            i2 = -11;
                            num = Integer.valueOf(i2);
                            fileLock.release();
                        } else {
                            SystemUtils.log(4, "SplitCompat", "Splits verified.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                            num = Integer.valueOf(i2);
                            fileLock.release();
                        }
                    } catch (Exception e) {
                        exc = e;
                        str = "SplitCompat";
                        str2 = "Error verifying splits.";
                        i = 6;
                        str3 = "com.google.android.play.core.internal.at";
                    }
                } catch (Exception e2) {
                    SystemUtils.log(6, "SplitCompat", "Error copying splits.", e2, "com.google.android.play.core.internal.at", -1);
                    i2 = -13;
                } catch (Throwable th2) {
                    C18489cj.m37906a(th, th2);
                }
            }
            if (channel != null) {
                channel.close();
            }
            return num;
            throw th;
            throw th;
        } catch (Exception e3) {
            SystemUtils.log(6, "SplitCompat", "Error locking files.", e3, "com.google.android.play.core.internal.at", -1);
            return -13;
        } catch (Throwable th3) {
            C18489cj.m37906a(th, th3);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m37787a(C18445at atVar, C18576d dVar) {
        try {
            if (!SplitCompat.m38031a(C18546p.m38075a(atVar.f53154a))) {
                SystemUtils.log(6, "SplitCompat", "Emulating splits failed.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                dVar.mo149293a(-12);
                return;
            }
            SystemUtils.log(4, "SplitCompat", "Splits installed.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
            dVar.mo149292a();
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Error emulating splits.", e, "com.google.android.play.core.internal.at", -1);
            dVar.mo149293a(-12);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m37788a(C18445at atVar, List list, C18576d dVar) {
        Integer a = atVar.m37786a((List<Intent>) list);
        if (a != null) {
            if (a.intValue() == 0) {
                dVar.mo149294b();
            } else {
                dVar.mo149293a(a.intValue());
            }
        }
    }

    /* renamed from: a */
    public final void mo149097a(List<Intent> list, C18576d dVar) {
        if (SplitCompat.m38030a()) {
            this.f53157d.execute(new C18444as(this, list, dVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
