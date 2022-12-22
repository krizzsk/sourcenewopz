package com.didi.dcrypto.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.didi.sdk.apm.SystemUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static final String EMPTY_FILE = "";

    public void onWriteToFile(Context context, String str, String str2) {
        String str3 = "ChartData_" + str2 + ".txt";
        try {
            File file = new File(context.getExternalFilesDir((String) null), str3);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(str);
            bufferedWriter.close();
            MediaScannerConnection.scanFile(context, new String[]{file.toString()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
        } catch (IOException unused) {
            SystemUtils.log(6, "ReadWriteFile", "Dcrypto exception: Unable to write to the" + str3 + " file.", (Throwable) null, "com.didi.dcrypto.util.FileUtils", 43);
        } catch (OutOfMemoryError unused2) {
            SystemUtils.log(6, "ReadWriteFile", "Dcrypto error: OutOfMemoryError for writing file " + str3, (Throwable) null, "com.didi.dcrypto.util.FileUtils", 45);
        }
        SystemUtils.log(2, "ReadWriteFile", "Dcrypto success: Write to TestFile.txt file.", (Throwable) null, "com.didi.dcrypto.util.FileUtils", 47);
    }

    public String onReadFromFile(Context context, String str) {
        String str2 = "ChartData_" + str + ".txt";
        try {
            StringBuilder sb = new StringBuilder();
            File file = new File(context.getExternalFilesDir((String) null), str2);
            new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine.toString());
                        sb.append("\n");
                    } else {
                        bufferedReader.close();
                        SystemUtils.log(2, "ReadWriteFile", "Read from TestFile.txt file.", (Throwable) null, "com.didi.dcrypto.util.FileUtils", 82);
                        return sb.toString();
                    }
                }
            } catch (Exception unused) {
                SystemUtils.log(6, "ReadWriteFile", "Unable to read the TestFile.txt file.", (Throwable) null, "com.didi.dcrypto.util.FileUtils", 79);
                return "";
            }
        } catch (OutOfMemoryError unused2) {
            SystemUtils.log(6, "ReadWriteFile", "Dcrypto error: OutOfMemoryError for writing file " + str2, (Throwable) null, "com.didi.dcrypto.util.FileUtils", 87);
            return "";
        }
    }
}
