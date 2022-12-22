package com.didi.quicksilver.ext;

public class StructStat {
    public long st_mtime;
    public long st_size;

    public StructStat(long j, long j2) {
        this.st_size = j;
        this.st_mtime = j2;
    }
}
