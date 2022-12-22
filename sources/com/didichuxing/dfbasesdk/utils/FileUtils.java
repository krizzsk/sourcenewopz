package com.didichuxing.dfbasesdk.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import okio.Okio;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileUtils {
    public static void saveFile(byte[] bArr, String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(ensureDirectory(str), str2));
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String ensureDirectory(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean rename(File file, File file2) {
        if (!file.exists()) {
            return false;
        }
        try {
            return file.renameTo(file2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static boolean delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return delete(new File(str));
    }

    public static void copy(String str, String str2) {
        try {
            Okio.buffer(Okio.sink(new File(str2))).writeAll(Okio.buffer(Okio.source(new File(str))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean copyFile(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                LogUtils.m33566e("--Method--", "copyFile:  oldFile not exist.");
                return false;
            } else if (!file.isFile()) {
                LogUtils.m33566e("--Method--", "copyFile:  oldFile not file.");
                return false;
            } else if (!file.canRead()) {
                LogUtils.m33566e("--Method--", "copyFile:  oldFile cannot read.");
                return false;
            } else {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String fileToMD5(File file) {
        if (file == null || !file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    } else {
                        String a = m33556a(instance.digest());
                        closeQuietly(fileInputStream2);
                        return a;
                    }
                }
            } catch (Exception e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    LogUtils.logStackTrace(e);
                    closeQuietly(fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            LogUtils.logStackTrace(e);
            closeQuietly(fileInputStream);
            return "";
        }
    }

    public static String bytesToMD5(byte[] bArr) {
        try {
            return m33556a(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    private static String m33556a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }

    public static File getDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getFilePathFromContentUri(Uri uri, ContentResolver contentResolver) {
        String[] strArr = {"_data"};
        Cursor query = contentResolver.query(uri, strArr, (String) null, (String[]) null, (String) null);
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex(strArr[0]));
        query.close();
        return string;
    }

    public static Uri getImageContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{ShareDBHelper.ID_NAME}, "_data=? ", new String[]{absolutePath}, (String) null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex(ShareDBHelper.ID_NAME));
            Uri parse = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(parse, "" + i);
        } else if (!file.exists()) {
            return null;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
    }

    public static boolean deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            return delete(new File(str));
        }
        return false;
    }
}
