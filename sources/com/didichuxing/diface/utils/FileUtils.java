package com.didichuxing.diface.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileUtils {
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

    public static String byteToMD5(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return m34020a(instance.digest());
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String strToMD5(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return m34020a(instance.digest());
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return "";
        }
    }

    /* renamed from: a */
    private static String m34020a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }

    public static String strToMD5_16(String str) {
        String strToMD5 = strToMD5(str);
        return (TextUtils.isEmpty(strToMD5) || strToMD5.length() < 32) ? "" : strToMD5.substring(8, 24);
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
                        String a = m34020a(instance.digest());
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

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean delete(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            return delete(new File(str));
        }
        return false;
    }
}
