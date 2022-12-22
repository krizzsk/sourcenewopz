package com.didi.remotereslibrary.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileUtils {
    public static void readToBuffer(StringBuffer stringBuffer, String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuffer.append(readLine);
            stringBuffer.append("\n");
        }
        bufferedReader.close();
        fileInputStream.close();
    }

    public static String readFile(String str) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        readToBuffer(stringBuffer, str);
        return stringBuffer.toString();
    }

    public static void getFiles(List<String> list, String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    getFiles(list, file.getAbsolutePath());
                } else {
                    list.add(file.getPath());
                }
            }
        }
    }

    public static File getDownLoadFileDirectory(Context context) {
        if (!isMediaMounted()) {
            return new File("/data/data/com.android.providers.downloads/cache/", Constants.DIRECTORY_DOWNLOADS_SUBPATH);
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (externalFilesDir.exists()) {
                if (!externalFilesDir.isDirectory()) {
                    throw new IllegalStateException(externalFilesDir.getAbsolutePath() + " already exists and is not a directory");
                }
            } else if (!externalFilesDir.mkdirs()) {
                throw new IllegalStateException("Unable to create directory: " + externalFilesDir.getAbsolutePath());
            }
            return new File(externalFilesDir, Constants.DIRECTORY_DOWNLOADS_SUBPATH);
        }
        throw new IllegalStateException("Failed to get external storage files directory");
    }

    public static File getDownLoadFileBySubPath(Context context, String str) {
        return new File(Uri.withAppendedPath(Uri.fromFile(getDownLoadFileDirectory(context)), str).getPath());
    }

    public static void unZip(String str, String str2) {
        DLog.m23371d(C11505Util.TAG, "正在解压");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    nextEntry = zipInputStream.getNextEntry();
                }
                while (nextEntry != null && !nextEntry.isDirectory()) {
                    if (!nextEntry.getName().contains("...")) {
                        if (!nextEntry.getName().contains(".../")) {
                            File file = new File(str2, nextEntry.getName());
                            if (file.getCanonicalPath().startsWith(str2)) {
                                if (!file.exists()) {
                                    new File(file.getParent()).mkdirs();
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                while (true) {
                                    int read = bufferedInputStream.read();
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(read);
                                }
                                bufferedOutputStream.close();
                                fileOutputStream.close();
                                nextEntry = zipInputStream.getNextEntry();
                                DLog.m23371d(C11505Util.TAG, file + "解压成功");
                            } else {
                                throw new IllegalStateException("Zip entry tried to write outside destination directory");
                            }
                        }
                    }
                }
                bufferedInputStream.close();
                zipInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            DLog.m23371d(C11505Util.TAG, "没有找到源文件");
        } catch (Exception e3) {
            e3.printStackTrace();
            DLog.m23374w(C11505Util.TAG, "解压出现错误");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        DLog.m23371d(C11505Util.TAG, "耗费时间： " + (currentTimeMillis2 - currentTimeMillis) + " ms");
    }

    public static List<String> getFilesOfZipAndRar(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(str);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            String name = ((ZipEntry) entries.nextElement()).getName();
            if (name.contains("../")) {
                DLog.m23374w(C11505Util.TAG, "Unsecurity zip file!!");
            } else {
                arrayList.add(name);
            }
        }
        zipFile.close();
        return arrayList;
    }

    public static boolean isMediaMounted() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
