package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.CommandLineSupport */
final class CommandLineSupport {
    private static final char BLANK = ' ';
    private static final int M_ESCAPED = 2;
    private static final int M_PARSEARGUMENT = 1;
    private static final int M_STRIPWHITESPACE = 0;
    private static final char QUOTE = '\"';
    private static final char SLASH = '\\';

    static String quote(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '\"' || c == '\\') {
                sb.append('\\');
            }
            sb.append(c);
        }
        if (!(str.indexOf(32) == -1 && str.indexOf(34) == -1)) {
            sb.insert(0, '\"').append('\"');
        }
        return sb.toString();
    }

    static String quote(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String next : list) {
            if (z) {
                sb.append(BLANK);
            }
            sb.append(quote(next));
            z = true;
        }
        return sb.toString();
    }

    static List<String> split(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char c = 0;
        char c2 = BLANK;
        for (char c3 : str.toCharArray()) {
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        if (c3 == '\"' || c3 == '\\') {
                            sb.setCharAt(sb.length() - 1, c3);
                        } else if (c3 == c2) {
                            addArgument(arrayList, sb);
                        } else {
                            sb.append(c3);
                        }
                    }
                } else if (c3 == c2) {
                    addArgument(arrayList, sb);
                    c = 0;
                } else if (c3 == '\\') {
                    sb.append('\\');
                    c = 2;
                } else {
                    sb.append(c3);
                }
            } else if (Character.isWhitespace(c3)) {
            } else if (c3 == '\"') {
                c2 = '\"';
            } else {
                sb.append(c3);
                c2 = BLANK;
            }
            c = 1;
        }
        addArgument(arrayList, sb);
        return arrayList;
    }

    private static void addArgument(List<String> list, StringBuilder sb) {
        if (sb.length() > 0) {
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private CommandLineSupport() {
    }
}
