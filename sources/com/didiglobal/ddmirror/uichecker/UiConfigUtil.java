package com.didiglobal.ddmirror.uichecker;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.ddmirror.uichecker.model.UiConfig;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/UiConfigUtil;", "", "()V", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiConfigUtil.kt */
public final class UiConfigUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static UiConfig config;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/UiConfigUtil$Companion;", "", "()V", "config", "Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "getConfig", "()Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "setConfig", "(Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;)V", "closeQuietly", "", "closeable", "Ljava/io/Closeable;", "fromJSON", "data", "", "getConfigFromFile", "context", "Landroid/content/Context;", "getConfigFromNet", "getConfigFromString", "configStr", "readFromPath", "readLocalConfigFile", "readStringFromStream", "inputStream", "Ljava/io/InputStream;", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: UiConfigUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UiConfig getConfig() {
            return UiConfigUtil.config;
        }

        public final void setConfig(UiConfig uiConfig) {
            UiConfigUtil.config = uiConfig;
        }

        public final UiConfig getConfigFromFile(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Companion companion = this;
            if (companion.getConfig() != null) {
                return companion.getConfig();
            }
            String readLocalConfigFile = companion.readLocalConfigFile(context);
            if (TextUtils.isEmpty(readLocalConfigFile)) {
                SystemUtils.log(4, "UiConfigUtil", "readLocalConfigFile is empty", (Throwable) null, "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion", 27);
                return null;
            }
            companion.setConfig(companion.fromJSON(readLocalConfigFile));
            return companion.getConfig();
        }

        public final UiConfig getConfigFromString(String str) {
            if (TextUtils.isEmpty(str)) {
                SystemUtils.log(4, "UiConfigUtil", "config string is empty", (Throwable) null, "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion", 36);
                return null;
            }
            Companion companion = this;
            companion.setConfig(companion.fromJSON(str));
            return companion.getConfig();
        }

        public final void getConfigFromNet(Context context) {
            if (getConfig() == null) {
                new HttpHelper(context).getUiConfig(new UiConfigUtil$Companion$getConfigFromNet$1());
            }
        }

        public final UiConfig fromJSON(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (UiConfig) new Gson().fromJson(str, UiConfig.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return null;
            }
        }

        private final String readStringFromStream(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            Ref.IntRef intRef = new Ref.IntRef();
            while (true) {
                int read = bufferedInputStream.read(bArr);
                intRef.element = read;
                if (read == -1) {
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write(bArr, 0, intRef.element);
            }
        }

        public final String readLocalConfigFile(Context context) {
            InputStream inputStream;
            IOException e;
            Intrinsics.checkParameterIsNotNull(context, "context");
            InputStream inputStream2 = null;
            try {
                inputStream = new FileInputStream(SystemUtils.getExternalStorageDirectory().getPath() + "/didi/check_config.json");
                try {
                    String readStringFromStream = readStringFromStream(inputStream);
                    closeQuietly(inputStream);
                    return readStringFromStream;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        closeQuietly(inputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        closeQuietly(inputStream2);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                inputStream = inputStream2;
                e = iOException;
                e.printStackTrace();
                closeQuietly(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(inputStream2);
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[SYNTHETIC, Splitter:B:26:0x0084] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[SYNTHETIC, Splitter:B:32:0x008f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.lang.String readFromPath() {
            /*
                r11 = this;
                java.io.File r0 = new java.io.File
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.io.File r2 = com.didi.sdk.apm.SystemUtils.getExternalStorageDirectory()
                java.lang.String r2 = r2.getPath()
                r1.append(r2)
                java.lang.String r2 = "/didi/check_config.json"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                boolean r1 = r0.exists()
                java.lang.String r3 = "readFromPath fail:"
                r4 = 0
                if (r1 == 0) goto L_0x0098
                boolean r1 = r0.isFile()
                if (r1 == 0) goto L_0x0098
                boolean r1 = r0.canRead()
                if (r1 != 0) goto L_0x0034
                goto L_0x0098
            L_0x0034:
                r1 = r4
                java.io.FileInputStream r1 = (java.io.FileInputStream) r1
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0060 }
                r2.<init>(r0)     // Catch:{ IOException -> 0x0060 }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                r5 = r2
                java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                r1.<init>(r5)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                r0.<init>(r1)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
                r2.close()     // Catch:{ IOException -> 0x0053 }
                goto L_0x0057
            L_0x0053:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0057:
                return r0
            L_0x0058:
                r0 = move-exception
                r1 = r2
                goto L_0x008d
            L_0x005b:
                r0 = move-exception
                r1 = r2
                goto L_0x0061
            L_0x005e:
                r0 = move-exception
                goto L_0x008d
            L_0x0060:
                r0 = move-exception
            L_0x0061:
                java.lang.String r6 = "UiConfigUtil"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
                r2.<init>()     // Catch:{ all -> 0x005e }
                r2.append(r3)     // Catch:{ all -> 0x005e }
                java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x005e }
                r2.append(r3)     // Catch:{ all -> 0x005e }
                java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x005e }
                r5 = 5
                r8 = 0
                java.lang.String r9 = "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion"
                r10 = 117(0x75, float:1.64E-43)
                com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x005e }
                r0.printStackTrace()     // Catch:{ all -> 0x005e }
                if (r1 == 0) goto L_0x008c
                r1.close()     // Catch:{ IOException -> 0x0088 }
                goto L_0x008c
            L_0x0088:
                r0 = move-exception
                r0.printStackTrace()
            L_0x008c:
                return r4
            L_0x008d:
                if (r1 == 0) goto L_0x0097
                r1.close()     // Catch:{ IOException -> 0x0093 }
                goto L_0x0097
            L_0x0093:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0097:
                throw r0
            L_0x0098:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.io.File r3 = com.didi.sdk.apm.SystemUtils.getExternalStorageDirectory()
                java.lang.String r3 = r3.getPath()
                r1.append(r3)
                r1.append(r2)
                java.lang.String r7 = r1.toString()
                r5 = 5
                r8 = 0
                r10 = 103(0x67, float:1.44E-43)
                java.lang.String r6 = "UiConfigUtil"
                java.lang.String r9 = "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion"
                com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ""
                r1.append(r2)
                boolean r3 = r0.exists()
                r1.append(r3)
                java.lang.String r7 = r1.toString()
                r10 = 104(0x68, float:1.46E-43)
                java.lang.String r6 = "UiConfigUtil"
                java.lang.String r9 = "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion"
                com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r2)
                boolean r3 = r0.isFile()
                r1.append(r3)
                java.lang.String r7 = r1.toString()
                r10 = 105(0x69, float:1.47E-43)
                java.lang.String r6 = "UiConfigUtil"
                java.lang.String r9 = "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion"
                com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r2)
                boolean r0 = r0.canRead()
                r1.append(r0)
                java.lang.String r7 = r1.toString()
                r10 = 106(0x6a, float:1.49E-43)
                java.lang.String r6 = "UiConfigUtil"
                java.lang.String r9 = "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion"
                com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.uichecker.UiConfigUtil.Companion.readFromPath():java.lang.String");
        }

        public final void closeQuietly(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }
}
