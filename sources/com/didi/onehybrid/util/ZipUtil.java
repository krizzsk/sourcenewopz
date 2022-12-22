package com.didi.onehybrid.util;

import android.text.TextUtils;
import com.didi.onehybrid.resource.offline.OfflineBundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {

    /* renamed from: a */
    private static final int f29752a = 2048;

    /* renamed from: b */
    private static final String f29753b = "resource/";

    public static void unzip(File file, File file2) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (!TextUtils.isEmpty(name) && !name.contains("../")) {
                if (zipEntry.isDirectory()) {
                    new File(file2, name).mkdirs();
                } else {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                    File file3 = new File(file2, name);
                    File parentFile = file3.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), 2048);
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                }
            }
        }
        zipFile.close();
    }

    public static OfflineBundle getBundleInfoFromZipFile(File file, File file2) throws IOException {
        OfflineBundle offlineBundle;
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (true) {
            offlineBundle = null;
            try {
                if (!entries.hasMoreElements()) {
                    break;
                }
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.isDirectory()) {
                    String name = zipEntry.getName();
                    if (!name.endsWith(".DS_Store")) {
                        String substring = name.substring(name.lastIndexOf("/") + 1);
                        if (substring.equals("bundle.json")) {
                            File file3 = new File(file2, substring);
                            if (!file3.exists()) {
                                file3.createNewFile();
                            }
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), 2048);
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                            String readFile = FileUtil.readFile(file3);
                            if (!TextUtils.isEmpty(readFile)) {
                                offlineBundle = (OfflineBundle) new Gson().fromJson(readFile, OfflineBundle.class);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SystemUtils.log(3, "BundleInfoFromZipFile", e.getMessage(), (Throwable) null, "com.didi.onehybrid.util.ZipUtil", 129);
                OmegaUtils.offline_error("getBundleInfoFromZipFile:" + e.getMessage());
                e.printStackTrace();
            } catch (Throwable th) {
                zipFile.close();
                throw th;
            }
        }
        zipFile.close();
        return offlineBundle;
    }

    public static void updateResourceFromZipFile(File file, File file2, OfflineBundle offlineBundle) throws IOException {
        if (offlineBundle != null) {
            List<OfflineBundle.ResourceInfo> resouceInfoList = offlineBundle.getResouceInfoList();
            HashMap hashMap = new HashMap();
            for (OfflineBundle.ResourceInfo next : resouceInfoList) {
                hashMap.put(next.getFile(), next);
            }
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                try {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (!name.endsWith(".DS_Store")) {
                        if (!zipEntry.isDirectory()) {
                            String substring = name.substring(name.indexOf(f29753b) + 9);
                            if (hashMap.get(substring) != null) {
                                OfflineBundle.ResourceInfo resourceInfo = (OfflineBundle.ResourceInfo) hashMap.get(substring);
                                File file3 = new File(file2, resourceInfo.getMd5() + resourceInfo.getFileType());
                                if (!file3.exists()) {
                                    file3.createNewFile();
                                }
                                if (resourceInfo.getAction() == 1) {
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), 2048);
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr, 0, 2048);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    }
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    bufferedInputStream.close();
                                } else if (file3.exists()) {
                                    file3.delete();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    OmegaUtils.offline_error("dealBundleInfoFromZipFile:" + e.getMessage());
                    e.printStackTrace();
                    zipFile.close();
                } catch (Throwable th) {
                    zipFile.close();
                    throw th;
                }
            }
            zipFile.close();
        }
    }
}
