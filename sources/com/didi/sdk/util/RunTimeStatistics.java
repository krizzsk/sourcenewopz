package com.didi.sdk.util;

import java.util.HashMap;
import java.util.LinkedList;

public class RunTimeStatistics {

    /* renamed from: a */
    private static volatile HashMap<String, SliceData> f37679a = new HashMap<>();

    public static synchronized SliceData getSliceTimesByGroup(SliceGroup sliceGroup) {
        SliceData sliceData;
        synchronized (RunTimeStatistics.class) {
            sliceData = f37679a.get(sliceGroup.getName());
            if (sliceData == null) {
                sliceData = new SliceData();
            }
        }
        return sliceData;
    }

    public static synchronized void reset(SliceGroup sliceGroup) {
        synchronized (RunTimeStatistics.class) {
            if (f37679a.get(sliceGroup.getName()) != null) {
                f37679a.get(sliceGroup.getName()).setReset(true);
            }
        }
    }

    public static synchronized boolean isReset(SliceGroup sliceGroup) {
        synchronized (RunTimeStatistics.class) {
            if (f37679a.get(sliceGroup.getName()) == null || !f37679a.get(sliceGroup.getName()).isReset()) {
                return false;
            }
            return true;
        }
    }

    public static synchronized void addSliceTime(SliceGroup sliceGroup, SliceTime sliceTime) {
        synchronized (RunTimeStatistics.class) {
            SliceData sliceData = f37679a.get(sliceGroup.getName());
            if (sliceData == null) {
                sliceData = new SliceData();
                f37679a.put(sliceGroup.getName(), sliceData);
            }
            sliceData.getListSliceTime().add(sliceTime);
        }
    }

    public enum SliceGroup {
        APP_LAUNCHING_TIME("APP_LAUNCHING_TIME");
        
        private String name;

        private SliceGroup(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class SliceData {
        private boolean isReset = false;
        private LinkedList<SliceTime> listSliceTime = new LinkedList<>();

        public boolean isReset() {
            return this.isReset;
        }

        public void setReset(boolean z) {
            this.isReset = z;
        }

        public LinkedList<SliceTime> getListSliceTime() {
            return this.listSliceTime;
        }

        public void setListSliceTime(LinkedList<SliceTime> linkedList) {
            this.listSliceTime = linkedList;
        }
    }

    public static class SliceTime {
        private long end;
        private String sliceName;
        private long start;

        public long getStart() {
            return this.start;
        }

        public void setStart(long j) {
            this.start = j;
        }

        public long getEnd() {
            return this.end;
        }

        public void setEnd(long j) {
            this.end = j;
        }

        public String getSliceName() {
            return this.sliceName;
        }

        public void setSliceName(String str) {
            this.sliceName = str;
        }
    }
}
