package com.didi.aoe.library.logging;

@FunctionalInterface
public interface LoggerBinder {
    Logger getLogger(String str);
}
