package com.didi.soda.compose.log;

public class ComposeLogConst {

    public static class Identifier {
        public static final String IDENTIFIER_MSG = "msg- %s | ";
        public static final String IDENTIFIER_PARAMS = "params- %s |";
        public static final String IDENTIFIER_TAG = "tag- %s |";
        public static final String IDENTIFIER_TIME = "time- %s |";
    }

    public static class Level {
        public static final String LEVEL_ERROR = "l-ERROR|";
        public static final String LEVEL_INFO = "l-INFO|";
        public static final String LEVEL_WARNING = "l-WARNING|";
    }

    public static class System {
        public static final String SYSTEM_TYPE = "SodaAnd_p";
    }
}
