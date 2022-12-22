package com.didichuxing.foundation.util;

import java.io.File;
import java.util.Stack;

public abstract class FileUtil {
    public static final long size(String str) {
        return size(new File(str));
    }

    public static final long size(File file) {
        long j = 0;
        if (file != null && file.exists()) {
            Stack stack = new Stack();
            stack.push(file);
            while (!stack.isEmpty()) {
                File file2 = (File) stack.pop();
                j += file2.length();
                if (file2.isDirectory()) {
                    System.out.println(file2.length());
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File push : listFiles) {
                            stack.push(push);
                        }
                    }
                }
            }
        }
        return j;
    }

    public static boolean delete(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !delete(file)) {
            return false;
        }
        return true;
    }

    public static boolean delete(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(file);
        while (!stack.isEmpty()) {
            File file2 = (File) stack.peek();
            if (file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    ((File) stack.pop()).delete();
                } else {
                    for (File push : listFiles) {
                        stack.push(push);
                    }
                }
            } else if (file2.isFile()) {
                ((File) stack.pop()).delete();
            }
        }
        return true;
    }

    private FileUtil() {
    }
}
