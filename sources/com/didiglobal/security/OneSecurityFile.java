package com.didiglobal.security;

import android.content.Context;
import android.text.TextUtils;
import androidx.security.crypto.EncryptedFile;
import androidx.security.crypto.MasterKey;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/security/OneSecurityFile;", "", "()V", "createEncryptedFile", "Landroidx/security/crypto/EncryptedFile;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "dir", "", "fileName", "readFromFile", "", "writeToFile", "", "data", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: OneSecurityFile.kt */
public final class OneSecurityFile {
    public static final OneSecurityFile INSTANCE = new OneSecurityFile();

    private OneSecurityFile() {
    }

    public static /* synthetic */ void writeToFile$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        writeToFile(context, str, str2, str3);
    }

    @JvmStatic
    public static final void writeToFile(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "data");
        Intrinsics.checkParameterIsNotNull(str2, "dir");
        Intrinsics.checkParameterIsNotNull(str3, "fileName");
        EncryptedFile a = m36806a(context, str2, str3);
        Charset charset = StandardCharsets.UTF_8;
        Intrinsics.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        FileOutputStream openFileOutput = a.openFileOutput();
        openFileOutput.write(bytes);
        openFileOutput.flush();
        openFileOutput.close();
    }

    @JvmStatic
    public static final void writeToFile(Context context, String str, File file) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "data");
        Intrinsics.checkParameterIsNotNull(file, "file");
        EncryptedFile a = m36805a(context, file);
        Charset charset = StandardCharsets.UTF_8;
        Intrinsics.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        FileOutputStream openFileOutput = a.openFileOutput();
        openFileOutput.write(bytes);
        openFileOutput.flush();
        openFileOutput.close();
    }

    public static /* synthetic */ byte[] readFromFile$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return readFromFile(context, str, str2);
    }

    @JvmStatic
    public static final byte[] readFromFile(Context context, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "dir");
        Intrinsics.checkParameterIsNotNull(str2, "fileName");
        FileInputStream openFileInput = m36806a(context, str, str2).openFileInput();
        Intrinsics.checkExpressionValueIsNotNull(openFileInput, "createEncryptedFile(cont…fileName).openFileInput()");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int read = openFileInput.read(); read != -1; read = openFileInput.read()) {
            byteArrayOutputStream.write(read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArrayOutputStream.toByteArray()");
        return byteArray;
    }

    @JvmStatic
    public static final byte[] readFromFile(Context context, File file) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(file, "file");
        FileInputStream openFileInput = m36805a(context, file).openFileInput();
        Intrinsics.checkExpressionValueIsNotNull(openFileInput, "createEncryptedFile(context, file).openFileInput()");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int read = openFileInput.read(); read != -1; read = openFileInput.read()) {
            byteArrayOutputStream.write(read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteArrayOutputStream.toByteArray()");
        return byteArray;
    }

    /* renamed from: a */
    static /* synthetic */ EncryptedFile m36807a(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return m36806a(context, str, str2);
    }

    @JvmStatic
    /* renamed from: a */
    private static final EncryptedFile m36806a(Context context, String str, String str2) {
        File file;
        MasterKey build = new MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "MasterKey.Builder(contex…GCM)\n            .build()");
        if (TextUtils.isEmpty(str)) {
            File filesDir = context.getFilesDir();
            Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
            file = new File(filesDir.getAbsoluteFile(), str2);
        } else {
            file = new File(str, str2);
        }
        EncryptedFile build2 = new EncryptedFile.Builder(context, file, build, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build();
        Intrinsics.checkExpressionValueIsNotNull(build2, "EncryptedFile.Builder(\n …KDF_4KB\n        ).build()");
        return build2;
    }

    @JvmStatic
    /* renamed from: a */
    private static final EncryptedFile m36805a(Context context, File file) {
        MasterKey build = new MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "MasterKey.Builder(contex…GCM)\n            .build()");
        EncryptedFile build2 = new EncryptedFile.Builder(context, file, build, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build();
        Intrinsics.checkExpressionValueIsNotNull(build2, "EncryptedFile.Builder(\n …KDF_4KB\n        ).build()");
        return build2;
    }
}
