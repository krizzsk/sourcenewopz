package com.didi.raven.config;

public class RavenEvent {

    public static class DefaultEvent {
        public static final String ERROR = "error";
        public static final String ERROR_NAME = "undef";
        public static final String REQUEST = "_r";
        public static final String TIME = "_time";
    }

    public static class EventType {
        public static final int DEFAULT = 0;
        public static final int ERROR = 2;
        public static final int INFO = 1;
        public static final int REQUEST = 3;
        public static final int TIME = 7;
    }
}
