package com.didiglobal.ddmirror.network;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.ddmirror.network.model.NetConfig;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/NetConfigUtil;", "", "()V", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NetConfigUtil.kt */
public final class NetConfigUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static NetConfig config;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/NetConfigUtil$Companion;", "", "()V", "config", "Lcom/didiglobal/ddmirror/network/model/NetConfig;", "getConfig", "()Lcom/didiglobal/ddmirror/network/model/NetConfig;", "setConfig", "(Lcom/didiglobal/ddmirror/network/model/NetConfig;)V", "closeQuietly", "", "closeable", "Ljava/io/Closeable;", "fromJSON", "data", "", "getConfigFromFile", "context", "Landroid/content/Context;", "getConfigFromString", "configStr", "readLocalConfigFile", "readStringFromStream", "inputStream", "Ljava/io/InputStream;", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NetConfigUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NetConfig getConfig() {
            return NetConfigUtil.config;
        }

        public final void setConfig(NetConfig netConfig) {
            NetConfigUtil.config = netConfig;
        }

        public final NetConfig getConfigFromFile(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Companion companion = this;
            if (companion.getConfig() != null) {
                return companion.getConfig();
            }
            String readLocalConfigFile = companion.readLocalConfigFile(context);
            if (TextUtils.isEmpty(readLocalConfigFile)) {
                SystemUtils.log(4, "NetConfigUtil", "readLocalConfigFile is empty", (Throwable) null, "com.didiglobal.ddmirror.network.NetConfigUtil$Companion", 29);
                return null;
            }
            companion.setConfig(companion.fromJSON(readLocalConfigFile));
            return companion.getConfig();
        }

        public final NetConfig getConfigFromString(String str) {
            if (TextUtils.isEmpty(str)) {
                SystemUtils.log(4, "NetConfigUtil", "config string is empty", (Throwable) null, "com.didiglobal.ddmirror.network.NetConfigUtil$Companion", 38);
                return null;
            }
            Companion companion = this;
            companion.setConfig(companion.fromJSON(str));
            return companion.getConfig();
        }

        public final NetConfig fromJSON(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (NetConfig) new Gson().fromJson(str, NetConfig.class);
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
            Intrinsics.checkParameterIsNotNull(context, "context");
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open("network.json");
                return readStringFromStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                closeQuietly(inputStream);
            }
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
