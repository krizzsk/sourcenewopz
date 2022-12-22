package com.didichuxing.ditest.agent.android.logging;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.PrintStream;

public class ConsoleAgentLog implements AgentLog {
    private int level = 3;

    public void debug(String str) {
        if (this.level == 5) {
            print("DEBUG", str);
        }
    }

    public void verbose(String str) {
        if (this.level >= 4) {
            print("VERBOSE", str);
        }
    }

    public void info(String str) {
        if (this.level >= 5) {
            print("INFO", str);
        }
    }

    public void warning(String str) {
        if (this.level >= 2) {
            print("WARN", str);
        }
    }

    public void error(String str, Throwable th) {
        if (this.level >= 1) {
            print("ERROR", str + " " + th.getMessage());
        }
    }

    public void error(String str) {
        if (this.level >= 1) {
            print("ERROR", str);
        }
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    private static void print(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(Const.jaLeft + str + "] " + str2);
    }
}
