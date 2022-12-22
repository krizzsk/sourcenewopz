package com.didi.hawaii.utils;

import com.didi.hawaii.log.HWLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class ZipUtil {
    public static final String TAG = "ZipUtil";

    private ZipUtil() {
    }

    public static void zipFolder(String str, String str2) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        zipFiles(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }

    private static void zipFiles(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream != null) {
            File file = new File(str + str2);
            FileInputStream fileInputStream = null;
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        zipOutputStream.putNextEntry(zipEntry);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read != -1) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                zipOutputStream.closeEntry();
                                C9266IO.safeClose(fileInputStream2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            HWLog.m16761i("hw", e.getMessage());
                            C9266IO.safeClose(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            C9266IO.safeClose(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        C9266IO.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    HWLog.m16761i("hw", e.getMessage());
                    C9266IO.safeClose(fileInputStream);
                }
            } else {
                String[] list = file.list();
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (String str3 : list) {
                    zipFiles(str, str2 + File.separator + str3, zipOutputStream);
                }
            }
        }
    }

    public static boolean unzipFile(String str, String str2) {
        FileInputStream fileInputStream;
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        byte[] bArr = new byte[1024];
        ZipInputStream zipInputStream = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    while (nextEntry != null) {
                        String name = nextEntry.getName();
                        File file2 = new File(str2 + name);
                        if (name.endsWith("/")) {
                            HWLog.m16761i(TAG, "Unzipping " + file2.getAbsolutePath() + " is a directory,continue");
                            if (file2.mkdirs()) {
                                zipInputStream2.closeEntry();
                                nextEntry = zipInputStream2.getNextEntry();
                            }
                        } else if (file2.createNewFile()) {
                            HWLog.m16761i(TAG, "Unzipping to " + file2.getAbsolutePath());
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            while (true) {
                                int read = zipInputStream2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            zipInputStream2.closeEntry();
                            nextEntry = zipInputStream2.getNextEntry();
                        }
                        C9266IO.safeClose(zipInputStream2);
                        C9266IO.safeClose(fileInputStream);
                        return false;
                    }
                    zipInputStream2.closeEntry();
                    C9266IO.safeClose(zipInputStream2);
                    C9266IO.safeClose(fileInputStream);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    zipInputStream = zipInputStream2;
                    e.printStackTrace();
                    C9266IO.safeClose(zipInputStream);
                    C9266IO.safeClose(fileInputStream);
                    return false;
                } catch (IOException e2) {
                    e = e2;
                    zipInputStream = zipInputStream2;
                    e.printStackTrace();
                    C9266IO.safeClose(zipInputStream);
                    C9266IO.safeClose(fileInputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipInputStream = zipInputStream2;
                    C9266IO.safeClose(zipInputStream);
                    C9266IO.safeClose(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                C9266IO.safeClose(zipInputStream);
                C9266IO.safeClose(fileInputStream);
                return false;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                C9266IO.safeClose(zipInputStream);
                C9266IO.safeClose(fileInputStream);
                return false;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream = null;
            e.printStackTrace();
            C9266IO.safeClose(zipInputStream);
            C9266IO.safeClose(fileInputStream);
            return false;
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
            e.printStackTrace();
            C9266IO.safeClose(zipInputStream);
            C9266IO.safeClose(fileInputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            C9266IO.safeClose(zipInputStream);
            C9266IO.safeClose(fileInputStream);
            throw th;
        }
    }

    private static boolean deleteDirAndSub(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        for (File deleteDirAndSub : file.listFiles()) {
            if (!deleteDirAndSub(deleteDirAndSub)) {
                return false;
            }
        }
        return file.delete();
    }
}
