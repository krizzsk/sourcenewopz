package com.didichuxing.mas.sdk.quality.report.utils;

import java.util.ArrayList;
import java.util.Stack;

public class FilenameUtils {
    public static boolean wildcardMatch(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        String[] splitOnTokens = splitOnTokens(str2);
        Stack stack = new Stack();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        do {
            if (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                i2 = iArr[0];
                i = iArr[1];
                z = true;
            }
            while (i2 < splitOnTokens.length) {
                if (splitOnTokens[i2].equals("?")) {
                    i++;
                    if (i > str.length()) {
                        break;
                    }
                } else if (splitOnTokens[i2].equals("*")) {
                    if (i2 == splitOnTokens.length - 1) {
                        i = str.length();
                    }
                    z = true;
                    i2++;
                } else {
                    if (!z) {
                        if (!checkRegionMatches(str, i, splitOnTokens[i2])) {
                            break;
                        }
                    } else {
                        i = checkIndexOf(str, i, splitOnTokens[i2]);
                        if (i == -1) {
                            break;
                        }
                        int checkIndexOf = checkIndexOf(str, i + 1, splitOnTokens[i2]);
                        if (checkIndexOf >= 0) {
                            stack.push(new int[]{i2, checkIndexOf});
                        }
                    }
                    i += splitOnTokens[i2].length();
                }
                z = false;
                i2++;
            }
            if (i2 == splitOnTokens.length && i == str.length()) {
                return true;
            }
        } while (stack.size() > 0);
        return false;
    }

    public static int checkIndexOf(String str, int i, String str2) {
        int length = str.length() - str2.length();
        if (length < i) {
            return -1;
        }
        while (i <= length) {
            if (checkRegionMatches(str, i, str2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean checkRegionMatches(String str, int i, String str2) {
        return str.regionMatches(false, i, str2, 0, str2.length());
    }

    static String[] splitOnTokens(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 == '?' || c2 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c2 == '?') {
                    arrayList.add("?");
                } else if (c != '*') {
                    arrayList.add("*");
                }
            } else {
                sb.append(c2);
            }
            i++;
            c = c2;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
