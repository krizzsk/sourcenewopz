package com.didi.sdk.util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileUtil {

    /* renamed from: a */
    private static ZipInputStream f37591a;

    public static String cutTheTailOfTheFile(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile() || !str.endsWith(DefaultDiskStorage.FileType.TEMP)) {
            return str;
        }
        String substring = str.substring(0, str.lastIndexOf(DefaultDiskStorage.FileType.TEMP));
        file.renameTo(new File(substring));
        return substring;
    }

    public static boolean create(String str, boolean z) {
        boolean createNewFile;
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (z) {
            try {
                createNewFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else if (file.exists()) {
            return false;
        } else {
            createNewFile = file.createNewFile();
        }
        return createNewFile;
    }

    public static boolean isExists(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* renamed from: a */
    private static boolean m26688a(String str) {
        return TextUtil.isEmpty(str);
    }

    public static boolean delete(String str) {
        if (m26688a(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean mkDir(String str) {
        if (m26688a(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void writeString(String str, String str2) {
        if (!m26688a(str) && !m26688a(str2)) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void appString(String str, String str2) {
        if (!m26688a(str) && !m26688a(str2)) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str), true);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String readFile(String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readFileToByte(String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString("UTF-8");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void saveFile(String str, InputStream inputStream) {
        saveFile(str, inputStream, false);
    }

    public static void saveFile(String str, InputStream inputStream, boolean z) {
        if (!TextUtil.isEmpty(str) && inputStream != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str, z);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        inputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveFile(String str, String str2, boolean z) {
        if (!TextUtil.isEmpty(str2)) {
            saveFile(str, (InputStream) new ByteArrayInputStream(str2.getBytes()), z);
        }
    }

    public static void sequenceFile(String str, String str2, String str3) {
        if (!TextUtil.isEmpty(str) && !TextUtil.isEmpty(str2) && !TextUtil.isEmpty(str2)) {
            File file = new File(str);
            File file2 = new File(str2);
            File file3 = new File(str3);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream, fileInputStream2);
                while (true) {
                    int read = sequenceInputStream.read();
                    if (read != -1) {
                        fileOutputStream.write(read);
                    } else {
                        fileInputStream.close();
                        fileInputStream2.close();
                        fileOutputStream.close();
                        sequenceInputStream.close();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String zipFile(File[] fileArr, String str) {
        if (fileArr == null || m26688a(str)) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(str)));
            for (int i = 0; i < fileArr.length; i++) {
                FileInputStream fileInputStream = new FileInputStream(fileArr[i]);
                zipOutputStream.putNextEntry(new ZipEntry(fileArr[i].getName()));
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                fileInputStream.close();
            }
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String zipFile(String str, String str2) {
        if (m26688a(str) || m26688a(str2)) {
            return null;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            zipOutputStream.setComment("Zip File");
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(read);
            }
            fileInputStream.close();
            zipOutputStream.finish();
            zipOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static void unZipFile(String str, String str2) {
        if (!m26688a(str2) && !m26688a(str)) {
            File file = new File(str);
            File file2 = new File(str2);
            try {
                ZipFile zipFile = new ZipFile(file);
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
                f37591a = zipInputStream;
                InputStream inputStream = zipFile.getInputStream(zipInputStream.getNextEntry());
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    int read = inputStream.read();
                    if (read != -1) {
                        fileOutputStream.write(read);
                    } else {
                        inputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static long getLogFileSize(String str) {
        if (TextUtil.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        if (file.isFile()) {
            return file.length() / 1024;
        }
        return 0;
    }

    public static long getFileSize(String str) {
        if (TextUtil.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        try {
            return (long) new FileInputStream(file).available();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, instance.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws Exception {
        if (inputStream != null && outputStream != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] bArr = new byte[m26687a((InputStream) bufferedInputStream)];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private static int m26687a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return 0;
        }
        int available = inputStream.available();
        if (available <= 0) {
            return 1024;
        }
        return available;
    }

    public static void save(Uri uri, byte[] bArr) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(uri.getPath()));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeOutStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String byte2AudioFile(Context context, byte[] bArr, String str) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str + ".mp3", 0);
            openFileOutput.write(bArr);
            openFileOutput.flush();
            openFileOutput.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static InputStream getInputStream(Context context, Uri uri) {
        try {
            if (uri.getScheme().equals("file")) {
                return new FileInputStream(uri.getPath());
            }
            return context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static String getFilePath(Context context, Uri uri) {
        if (uri.getScheme().equals("file")) {
            return uri.getPath();
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        query.moveToFirst();
        String string = query.getString(1);
        closeCursor(query);
        return string;
    }

    public static void closeCursor(Cursor cursor) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) < 14) {
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    public static void deleteDir(File file) {
        deleteFile(file);
    }

    public static File[] getFiles4Filter(String str, final String str2) {
        if (TextUtil.isEmpty(str) || TextUtil.isEmpty(str2)) {
            return null;
        }
        return new File(str).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(str2);
            }
        });
    }

    public static void save(File file, Object obj) {
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
            try {
                objectOutputStream2.writeObject(obj);
                closeOutStream(objectOutputStream2);
            } catch (Exception e) {
                e = e;
                objectOutputStream = objectOutputStream2;
                try {
                    e.printStackTrace();
                    closeOutStream(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    closeOutStream(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
                closeOutStream(objectOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            closeOutStream(objectOutputStream);
        }
    }

    public static void deleteDir(String str) {
        delete(str);
    }

    public static boolean delete(Context context, String str) {
        File file = new File(context.getFilesDir() + File.separator + str);
        return !file.exists() || file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC, Splitter:B:24:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0055 A[SYNTHETIC, Splitter:B:31:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c A[SYNTHETIC, Splitter:B:36:0x005c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0050=Splitter:B:28:0x0050, B:21:0x0045=Splitter:B:21:0x0045} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] getUrlFromTxt(java.lang.String r6) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, all -> 0x003e }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, all -> 0x003e }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, all -> 0x003e }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, all -> 0x003e }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, all -> 0x003e }
            r6.<init>(r2)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, all -> 0x003e }
            java.lang.String r1 = ""
        L_0x0012:
            java.lang.String r2 = r6.readLine()     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            java.lang.String r3 = ","
            if (r2 == 0) goto L_0x002d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            r4.append(r1)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            r4.append(r3)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            java.lang.String r1 = r4.toString()     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            goto L_0x0012
        L_0x002d:
            java.lang.String[] r0 = r1.split(r3)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
            r6.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0058
        L_0x0035:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0058
        L_0x003a:
            r1 = move-exception
            goto L_0x0045
        L_0x003c:
            r1 = move-exception
            goto L_0x0050
        L_0x003e:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L_0x005a
        L_0x0043:
            r1 = move-exception
            r6 = r0
        L_0x0045:
            r1.printStackTrace()     // Catch:{ all -> 0x0059 }
            if (r6 == 0) goto L_0x0058
            r6.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0058
        L_0x004e:
            r1 = move-exception
            r6 = r0
        L_0x0050:
            r1.printStackTrace()     // Catch:{ all -> 0x0059 }
            if (r6 == 0) goto L_0x0058
            r6.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0058:
            return r0
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            if (r6 == 0) goto L_0x0064
            r6.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0064:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.FileUtil.getUrlFromTxt(java.lang.String):java.lang.String[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getExtensionName(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x001f
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x001f
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 <= r1) goto L_0x001f
            int r1 = r2.length()
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x001f
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.FileUtil.getExtensionName(java.lang.String):java.lang.String");
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2;
        Uri uri3 = null;
        if (uri == null) {
            return null;
        }
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, (String) null, (String[]) null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return SystemUtils.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            try {
                uri2 = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue());
            } catch (Exception unused) {
                uri2 = Uri.parse(documentId);
            }
            return getDataColumn(context, uri2, (String) null, (String[]) null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri3 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri3, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    public static boolean copyFile(String str, String str2) {
        try {
            if (!new File(str).exists()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1444];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    i += read;
                    System.out.println(i);
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: android.database.Cursor} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r8 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r8 != null) goto L_0x0041;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[Catch:{ IllegalArgumentException -> 0x003a, UnsupportedOperationException -> 0x0032, all -> 0x0030, all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x003a, UnsupportedOperationException -> 0x0032, all -> 0x0030 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x003a, UnsupportedOperationException -> 0x0032, all -> 0x0030 }
            if (r8 == 0) goto L_0x002d
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x002b, UnsupportedOperationException -> 0x0029 }
            if (r9 == 0) goto L_0x002d
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x002b, UnsupportedOperationException -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x002b, UnsupportedOperationException -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            goto L_0x0034
        L_0x002b:
            r9 = move-exception
            goto L_0x003c
        L_0x002d:
            if (r8 == 0) goto L_0x0044
            goto L_0x0041
        L_0x0030:
            r9 = move-exception
            goto L_0x0047
        L_0x0032:
            r9 = move-exception
            r8 = r7
        L_0x0034:
            r9.printStackTrace()     // Catch:{ all -> 0x0045 }
            if (r8 == 0) goto L_0x0044
            goto L_0x0041
        L_0x003a:
            r9 = move-exception
            r8 = r7
        L_0x003c:
            r9.printStackTrace()     // Catch:{ all -> 0x0045 }
            if (r8 == 0) goto L_0x0044
        L_0x0041:
            r8.close()
        L_0x0044:
            return r7
        L_0x0045:
            r9 = move-exception
            r7 = r8
        L_0x0047:
            if (r7 == 0) goto L_0x004c
            r7.close()
        L_0x004c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.FileUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static byte[] readRandomByte(String str) {
        byte[] bArr = new byte[51200];
        byte[] bArr2 = new byte[51200];
        byte[] bArr3 = new byte[51200];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            int available = fileInputStream.available();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedInputStream.skip(-1);
            bufferedInputStream.read(bArr, 0, 51200);
            bufferedInputStream.skip((long) (available / 2));
            bufferedInputStream.read(bArr2, 0, 51200);
            bufferedInputStream.skip((long) (available - 51200));
            bufferedInputStream.read(bArr3, 0, 51200);
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        byte[] bArr4 = new byte[153600];
        for (int i = 0; i < 51200; i++) {
            bArr4[i] = bArr[i];
        }
        for (int i2 = 0; i2 < 51200; i2++) {
            bArr4[i2 + 51200] = bArr2[i2];
        }
        for (int i3 = 0; i3 < 51200; i3++) {
            bArr4[i3 + 51200 + 51200] = bArr3[i3];
        }
        return bArr4;
    }
}
