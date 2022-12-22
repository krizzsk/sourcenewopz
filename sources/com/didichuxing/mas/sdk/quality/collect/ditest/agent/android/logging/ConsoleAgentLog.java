package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.PrintStream;

public class ConsoleAgentLog implements AgentLog {

    /* renamed from: a */
    private int f48002a = 3;

    public void debug(String str) {
        if (this.f48002a == 5) {
            m34266a("DEBUG", str);
        }
    }

    public void verbose(String str) {
        if (this.f48002a >= 4) {
            m34266a("VERBOSE", str);
        }
    }

    public void info(String str) {
        if (this.f48002a >= 5) {
            m34266a("INFO", str);
        }
    }

    public void warning(String str) {
        if (this.f48002a >= 2) {
            m34266a("WARN", str);
        }
    }

    public void error(String str, Throwable th) {
        if (this.f48002a >= 1) {
            m34266a("ERROR", str + " " + th.getMessage());
        }
    }

    public void error(String str) {
        if (this.f48002a >= 1) {
            m34266a("ERROR", str);
        }
    }

    public int getLevel() {
        return this.f48002a;
    }

    public void setLevel(int i) {
        this.f48002a = i;
    }

    /* renamed from: a */
    private static void m34266a(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(Const.jaLeft + str + "] " + str2);
    }
}
