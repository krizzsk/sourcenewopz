package com.didichuxing.omega.sdk.perfromacedetect.cpu;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.utils.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigDecimal;

public class CpuUtils {
    private static double aCpu = 0.0d;
    private static boolean initCpu = true;
    private static double o_aCpu;
    private static double o_cpu;
    private static double o_idle;
    private static double o_pCpu;
    private static double pCpu;
    private static double p_jif;

    public static long getJif() {
        return (long) p_jif;
    }

    public static double getCpuUsage() {
        RandomAccessFile randomAccessFile = null;
        double d = 0.0d;
        if (initCpu) {
            initCpu = false;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/stat", "r");
                try {
                    String[] split = randomAccessFile2.readLine().split(" ");
                    o_idle = Double.parseDouble(split[5]);
                    o_cpu = Double.parseDouble(split[2]) + Double.parseDouble(split[3]) + Double.parseDouble(split[4]) + Double.parseDouble(split[6]) + Double.parseDouble(split[8]) + Double.parseDouble(split[7]);
                    FileUtil.closeRandomAccessFile(randomAccessFile2);
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    try {
                        e.printStackTrace();
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        return d;
                    } catch (Throwable th) {
                        th = th;
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    FileUtil.closeRandomAccessFile(randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                FileUtil.closeRandomAccessFile(randomAccessFile);
                return d;
            }
        } else {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile("/proc/stat", "r");
                try {
                    String[] split2 = randomAccessFile3.readLine().split(" ");
                    double parseDouble = Double.parseDouble(split2[5]);
                    double parseDouble2 = Double.parseDouble(split2[2]) + Double.parseDouble(split2[3]) + Double.parseDouble(split2[4]) + Double.parseDouble(split2[6]) + Double.parseDouble(split2[8]) + Double.parseDouble(split2[7]);
                    double d2 = parseDouble2 + parseDouble;
                    if (0.0d != d2 - (o_cpu + o_idle)) {
                        double div = div((parseDouble2 - o_cpu) * 100.0d, d2 - (o_cpu + o_idle), 2);
                        if (div >= 0.0d) {
                            d = div > 100.0d ? 100.0d : div;
                        }
                    }
                    o_cpu = parseDouble2;
                    o_idle = parseDouble;
                    FileUtil.closeRandomAccessFile(randomAccessFile3);
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile3;
                    try {
                        e.printStackTrace();
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        return d;
                    } catch (Throwable th3) {
                        th = th3;
                        FileUtil.closeRandomAccessFile(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = randomAccessFile3;
                    FileUtil.closeRandomAccessFile(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                FileUtil.closeRandomAccessFile(randomAccessFile);
                return d;
            }
        }
        return d;
    }

    public static String[] getProcessCpuAction(int i) {
        BufferedReader bufferedReader;
        Exception e;
        String[] strArr = new String[3];
        File file = new File("/proc/" + i + "/stat");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" ");
                        strArr[0] = split[1];
                        strArr[1] = split[13];
                        strArr[2] = split[14];
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                }
            } catch (Exception e3) {
                Exception exc = e3;
                bufferedReader = null;
                e = exc;
                e.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            }
            FileUtil.closeReader(bufferedReader);
        }
        return strArr;
    }

    public CpuUtils() {
        initCpuData();
    }

    private void initCpuData() {
        o_pCpu = 0.0d;
        pCpu = 0.0d;
        o_aCpu = 0.0d;
        aCpu = 0.0d;
    }

    public static double getProcessCpuUsage(int i) {
        double d = 0.0d;
        if (i >= 0) {
            try {
                String[] processCpuAction = getProcessCpuAction(i);
                if (processCpuAction != null) {
                    pCpu = Double.parseDouble(processCpuAction[1]) + Double.parseDouble(processCpuAction[2]);
                }
                String[] cpuAction = getCpuAction();
                if (cpuAction != null) {
                    aCpu = 0.0d;
                    for (int i2 = 2; i2 < cpuAction.length; i2++) {
                        if (cpuAction[i2] != null) {
                            aCpu += Double.parseDouble(cpuAction[i2]);
                        }
                    }
                }
                if (aCpu - o_aCpu != 0.0d) {
                    double div = div((pCpu - o_pCpu) * 100.0d, aCpu - o_aCpu, 2);
                    if (div >= 0.0d) {
                        d = div > 100.0d ? 100.0d : div;
                    }
                }
                o_pCpu = pCpu;
                o_aCpu = aCpu;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        p_jif = pCpu;
        return d;
    }

    public static String[] getCpuAction() {
        BufferedReader bufferedReader;
        FileNotFoundException e;
        IOException e2;
        Exception e3;
        String[] strArr = new String[7];
        File file = new File("/proc/stat");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        strArr = readLine.split(" ");
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                } catch (IOException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                } catch (Exception e6) {
                    e3 = e6;
                    e3.printStackTrace();
                    FileUtil.closeReader(bufferedReader);
                    return strArr;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                e.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            } catch (IOException e8) {
                e2 = e8;
                bufferedReader = null;
                e2.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            } catch (Exception e9) {
                e3 = e9;
                bufferedReader = null;
                e3.printStackTrace();
                FileUtil.closeReader(bufferedReader);
                return strArr;
            }
            FileUtil.closeReader(bufferedReader);
        }
        return strArr;
    }

    public static synchronized String getTopCpuUseThreadInfo() {
        String sb;
        synchronized (CpuUtils.class) {
            StringBuilder sb2 = new StringBuilder();
            try {
                InputStream inputStream = Runtime.getRuntime().exec("top -m 10 -t -s cpu -n 1").getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (!readLine.contains("top")) {
                            sb2.append(readLine);
                            sb2.append("\r\n");
                        }
                    }
                }
                if (inputStream != null) {
                    bufferedReader.close();
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static double div(double d, double d2, int i) {
        try {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 1).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }
}
