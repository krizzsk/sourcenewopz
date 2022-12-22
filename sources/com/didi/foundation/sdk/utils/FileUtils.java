package com.didi.foundation.sdk.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p245io.FilesKt;
import kotlin.text.Charsets;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/foundation/sdk/utils/FileUtils;", "", "()V", "encodeMd5", "", "text", "getFormAssets", "context", "Landroid/content/Context;", "fileName", "loadFile", "file_path", "writeFile", "", "content", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: FileUtils.kt */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final String getFormAssets(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "fileName");
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            if (open != null) {
                open.close();
            }
            return sb2;
        } catch (IOException e) {
            e.printStackTrace();
            if (inputStream == null) {
                return "";
            }
            inputStream.close();
            return "";
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public final void writeFile(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "file_path");
        Intrinsics.checkParameterIsNotNull(str2, "content");
        File file = new File(str);
        if (!file.exists()) {
            file = null;
        }
        if (file != null) {
            FilesKt.writeText$default(file, str2, (Charset) null, 2, (Object) null);
        }
    }

    public final String loadFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, "file_path");
        File file = new File(str);
        if (!file.exists()) {
            file = null;
        }
        return file != null ? FilesKt.readText$default(file, (Charset) null, 1, (Object) null) : "";
    }

    public final String encodeMd5(String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            Intrinsics.checkExpressionValueIsNotNull(instance, "MessageDigest.getInstance(\"MD5\")");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = instance.digest(bytes);
            Intrinsics.checkExpressionValueIsNotNull(digest, "instance.digest(text.toByteArray())");
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    hexString = '0' + hexString;
                }
                stringBuffer.append(hexString);
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
            return stringBuffer2;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
