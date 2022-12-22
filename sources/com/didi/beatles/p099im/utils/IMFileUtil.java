package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.net.IMThreadHelper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.didi.beatles.im.utils.IMFileUtil */
public class IMFileUtil {
    public static final int TYPE_AUDIO = 101;
    public static final int TYPE_FILE = 103;
    public static final int TYPE_IMAGE = 102;

    /* renamed from: a */
    private static final String f9768a = "IMFileUtil";

    /* renamed from: com.didi.beatles.im.utils.IMFileUtil$FileSaveCallBack */
    public interface FileSaveCallBack {
        void onFinish(String str);
    }

    /* renamed from: a */
    private static String m6621a() {
        return "1.0/Audio/";
    }

    public static String saveFile(Context context, File file, String str) {
        File file2 = new File(getFilePath(context, str));
        if (file.renameTo(file2)) {
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static void saveFileAsync(final Context context, final File file, final String str, final FileSaveCallBack fileSaveCallBack) {
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                final String saveFile = IMFileUtil.saveFile(context, file, str);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        fileSaveCallBack.onFinish(saveFile);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m6624b(File file, File file2) {
        File file3 = new File(file2.getAbsolutePath() + DefaultDiskStorage.FileType.TEMP);
        if (!file3.exists() || file3.delete()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (fileInputStream.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                fileOutputStream.flush();
                fileInputStream.close();
                fileOutputStream.close();
                if (!file3.renameTo(file2)) {
                    return null;
                }
                if (file.exists()) {
                    file.delete();
                }
                return file2.getAbsolutePath();
            } catch (IOException unused) {
                return null;
            }
        } else {
            throw new IllegalStateException("moveFileOuter temp delete fail");
        }
    }

    public static void moveFileAsync(final File file, final File file2, final FileSaveCallBack fileSaveCallBack) {
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                final String a = IMFileUtil.m6624b(file, file2);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        fileSaveCallBack.onFinish(a);
                    }
                });
            }
        });
    }

    public static String getFilePath(Context context, String str) {
        return getFileFolder(context) + IMEncryptionUtil.encrypt(str);
    }

    /* renamed from: a */
    private static String m6622a(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/im";
    }

    public static String getFileFolder(Context context) {
        String str = m6622a(context) + "/" + m6621a();
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getTmpPath(Context context) {
        return m6622a(context) + "/tmp";
    }

    public static boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean isFolderExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).isDirectory();
    }
}
