package com.firebase.jobdispatcher;

import java.util.List;

public class JobTrigger {

    public static final class ImmediateTrigger extends JobTrigger {
        ImmediateTrigger() {
        }
    }

    public static final class ExecutionWindowTrigger extends JobTrigger {
        private final int windowEnd;
        private final int windowStart;

        ExecutionWindowTrigger(int i, int i2) {
            this.windowStart = i;
            this.windowEnd = i2;
        }

        public int getWindowStart() {
            return this.windowStart;
        }

        public int getWindowEnd() {
            return this.windowEnd;
        }
    }

    public static final class ContentUriTrigger extends JobTrigger {
        private final List<ObservedUri> uris;

        ContentUriTrigger(List<ObservedUri> list) {
            this.uris = list;
        }

        public List<ObservedUri> getUris() {
            return this.uris;
        }
    }
}
