package com.p222hp.hpl.sparta;

import java.io.PrintStream;

/* renamed from: com.hp.hpl.sparta.c */
/* compiled from: ParseSource */
class C19745c implements ParseLog {
    C19745c() {
    }

    public void error(String str, String str2, int i) {
        PrintStream printStream = System.err;
        printStream.println(str2 + "(" + i + "): " + str + " (ERROR)");
    }

    public void warning(String str, String str2, int i) {
        PrintStream printStream = System.out;
        printStream.println(str2 + "(" + i + "): " + str + " (WARNING)");
    }

    public void note(String str, String str2, int i) {
        PrintStream printStream = System.out;
        printStream.println(str2 + "(" + i + "): " + str + " (NOTE)");
    }
}
