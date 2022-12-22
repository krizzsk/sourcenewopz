package com.didichuxing.alpha.crash.dump;

public enum Reachability {
    REACHABLE,
    UNREACHABLE,
    UNKNOWN;

    public interface Inspector {
        Reachability expectedReachability(LeakTraceElement leakTraceElement);
    }
}
