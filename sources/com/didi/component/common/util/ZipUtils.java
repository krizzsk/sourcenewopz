package com.didi.component.common.util;

import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.sdk.apm.SystemUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils {

    /* renamed from: a */
    private static final String f11808a = "Car3dHelper";

    public static boolean unpackZip(String str, String str2) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str + str2)));
            byte[] bArr = new byte[1024];
            String str3 = str + getZipName(str2) + "/";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        new File(str3 + name).mkdirs();
                    } else {
                        FileOutputStream fileOutputStream = new FileOutputStream(str3 + name);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        zipInputStream.closeEntry();
                    }
                } else {
                    zipInputStream.close();
                    SystemUtils.log(3, f11808a, "unpackZip: 成功", (Throwable) null, "com.didi.component.common.util.ZipUtils", 59);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            SystemUtils.log(3, f11808a, "unpackZip: 出现了异常 " + e.toString(), (Throwable) null, "com.didi.component.common.util.ZipUtils", 56);
            return false;
        }
    }

    public static String getZipName(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(PmFileConstant.ZIP_SUFFIX, "");
    }
}
