package com.didi.dynamic.manager.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    /* renamed from: a */
    private static final int f19409a = 8192;

    public static void zipFiles(Collection<File> collection, File file) throws IOException {
        zipFiles(collection, file, (String) null);
    }

    public static void zipFiles(Collection<File> collection, File file, String str) throws IOException {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 8192));
            try {
                byte[] bArr = new byte[8192];
                for (File a : collection) {
                    m14520a(a, zipOutputStream2, "", bArr);
                }
                zipOutputStream2.setComment(str);
                m14519a(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                m14519a(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            m14519a(zipOutputStream);
            throw th;
        }
    }

    public static void unZipFile(File file, String str) throws ZipException, IOException {
        unZipSelectedFile(file, str, "");
    }

    public static ArrayList<File> unZipSelectedFile(File file, String str, String str2) throws ZipException, IOException {
        ArrayList<File> arrayList = new ArrayList<>();
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        byte[] bArr = new byte[8192];
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().contains("../")) {
                throw new ZipException("unsecurity zipfile!");
            } else if (zipEntry.getName().contains(str2)) {
                File file3 = new File(new String((str + File.separator + zipEntry.getName()).getBytes("8859_1"), "GB2312"));
                if (!file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                }
                try {
                    inputStream = zipFile.getInputStream(zipEntry);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            m14519a(inputStream);
                            m14519a(fileOutputStream);
                            throw th;
                        }
                    }
                    m14519a(inputStream);
                    m14519a(fileOutputStream2);
                    arrayList.add(file3);
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    m14519a(inputStream);
                    m14519a(fileOutputStream);
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getEntriesNames(File file) throws ZipException, IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Enumeration<?> entriesEnumeration = getEntriesEnumeration(file);
        while (entriesEnumeration.hasMoreElements()) {
            arrayList.add(new String(getEntryName((ZipEntry) entriesEnumeration.nextElement()).getBytes("GB2312"), "8859_1"));
        }
        return arrayList;
    }

    public static Enumeration<?> getEntriesEnumeration(File file) throws ZipException, IOException {
        return new ZipFile(file).entries();
    }

    public static String getEntryComment(ZipEntry zipEntry) throws UnsupportedEncodingException {
        return new String(zipEntry.getComment().getBytes("GB2312"), "8859_1");
    }

    public static String getEntryName(ZipEntry zipEntry) throws UnsupportedEncodingException {
        return new String(zipEntry.getName().getBytes("GB2312"), "8859_1");
    }

    /* renamed from: a */
    private static void m14520a(File file, ZipOutputStream zipOutputStream, String str, byte[] bArr) throws FileNotFoundException, IOException {
        if (bArr == null) {
            bArr = new byte[8192];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String str2 = new String(sb.toString().getBytes("8859_1"), "GB2312");
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    m14520a(a, zipOutputStream, str2, bArr);
                }
                return;
            }
            throw new IOException("List files error. in " + file.getAbsolutePath());
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                zipOutputStream.putNextEntry(new ZipEntry(str2));
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        m14519a(bufferedInputStream2);
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                m14519a(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            m14519a(bufferedInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m14519a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.m14494w("System.err", (Throwable) e);
            }
        }
    }
}
