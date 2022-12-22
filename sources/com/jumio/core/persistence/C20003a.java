package com.jumio.core.persistence;

import com.jumio.commons.log.Log;
import com.jumio.core.models.AuthorizationModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* renamed from: com.jumio.core.persistence.a */
/* compiled from: PersistenceUtil.kt */
public final class C20003a {

    /* renamed from: a */
    public static final C20003a f54939a = new C20003a();

    /* renamed from: com.jumio.core.persistence.a$b */
    /* compiled from: PersistenceUtil.kt */
    public static final class C20005b {

        /* renamed from: a */
        public ObjectInputStream f54941a;

        public C20005b(AuthorizationModel.SessionKey sessionKey, File file) {
            Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
            Intrinsics.checkNotNullParameter(file, "file");
            try {
                this.f54941a = new ObjectInputStream(new BufferedInputStream(new CipherInputStream(new FileInputStream(file), sessionKey.getDecryptCipher())));
            } catch (Exception e) {
                Log.m39477w("ModelRow", "error in deserialize()", (Throwable) e);
                throw new IOException(e);
            } catch (IOException e2) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Error restoring DataManager", Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                Log.m39477w("PersistenceUtil", format, (Throwable) e2);
            }
        }

        /* renamed from: a */
        public final <T> T mo163075a() {
            try {
                ObjectInputStream objectInputStream = this.f54941a;
                if (objectInputStream == null) {
                    return null;
                }
                return objectInputStream.readObject();
            } catch (Exception e) {
                throw C20003a.f54939a.mo163072a(e);
            }
        }
    }

    /* renamed from: a */
    public final IOException mo163072a(Exception exc) throws IOException {
        Log.m39477w("ModelRow", "error in serialize()", (Throwable) exc);
        return new IOException(exc);
    }

    /* renamed from: com.jumio.core.persistence.a$a */
    /* compiled from: PersistenceUtil.kt */
    public static final class C20004a {

        /* renamed from: a */
        public ObjectOutputStream f54940a;

        public C20004a(AuthorizationModel.SessionKey sessionKey, File file) {
            Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
            Intrinsics.checkNotNullParameter(file, "file");
            try {
                if (file.exists()) {
                    file.delete();
                }
                this.f54940a = new ObjectOutputStream(new BufferedOutputStream(new CipherOutputStream(new FileOutputStream(file), sessionKey.getEncryptCipher())));
            } catch (Exception e) {
                throw C20003a.f54939a.mo163072a(e);
            } catch (IOException e2) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Error persisting DataManager", Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                Log.m39477w("PersistenceUtil", format, (Throwable) e2);
            }
        }

        /* renamed from: a */
        public final void mo163074a(Object obj) {
            try {
                ObjectOutputStream objectOutputStream = this.f54940a;
                if (objectOutputStream != null) {
                    objectOutputStream.writeObject(obj);
                }
            } catch (Exception e) {
                throw C20003a.f54939a.mo163072a(e);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            kotlin.p245io.CloseableKt.closeFinally(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
            throw r2;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo163073a() {
            /*
                r3 = this;
                java.io.ObjectOutputStream r0 = r3.f54940a     // Catch:{ Exception -> 0x0016 }
                if (r0 != 0) goto L_0x0005
                goto L_0x0016
            L_0x0005:
                r1 = 0
                r0.flush()     // Catch:{ all -> 0x000f }
                kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x000f }
                kotlin.p245io.CloseableKt.closeFinally(r0, r1)     // Catch:{ Exception -> 0x0016 }
                goto L_0x0016
            L_0x000f:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x0011 }
            L_0x0011:
                r2 = move-exception
                kotlin.p245io.CloseableKt.closeFinally(r0, r1)     // Catch:{ Exception -> 0x0016 }
                throw r2     // Catch:{ Exception -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.persistence.C20003a.C20004a.mo163073a():void");
        }
    }
}
