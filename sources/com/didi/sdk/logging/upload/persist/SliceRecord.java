package com.didi.sdk.logging.upload.persist;

import java.util.Arrays;

public class SliceRecord {
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_UNSTARTED = -1;
    public static final int STATUS_UPLOADING = 0;
    private long endPos;
    private String file;
    private long fileSize;
    private int sliceCount;
    private int sliceId;
    private long startPos;
    private int status = -1;
    private String taskId;
    private int uploadCount;

    public SliceRecord(String str, int i, int i2, String str2, long j, long j2, long j3) {
        this.taskId = str;
        this.sliceCount = i;
        this.sliceId = i2;
        this.file = str2;
        this.fileSize = j;
        this.startPos = j2;
        this.endPos = j3;
    }

    public int getSliceId() {
        return this.sliceId;
    }

    public void setSliceId(int i) {
        this.sliceId = i;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getStartPos() {
        return this.startPos;
    }

    public void setStartPos(long j) {
        this.startPos = j;
    }

    public long getEndPos() {
        return this.endPos;
    }

    public void setEndPos(long j) {
        this.endPos = j;
    }

    public int getUploadCount() {
        return this.uploadCount;
    }

    public void setUploadCount(int i) {
        this.uploadCount = i;
    }

    public void increaseUploadCount() {
        this.uploadCount++;
    }

    public int getSliceCount() {
        return this.sliceCount;
    }

    public void setSliceCount(int i) {
        this.sliceCount = i;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SliceRecord sliceRecord = (SliceRecord) obj;
        if (this.sliceId == sliceRecord.sliceId && this.startPos == sliceRecord.startPos && this.endPos == sliceRecord.endPos && this.status == sliceRecord.status && equals(this.taskId, sliceRecord.taskId) && equals(this.file, sliceRecord.file)) {
            return true;
        }
        return false;
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return hash(this.taskId, Integer.valueOf(this.sliceId), this.file, Long.valueOf(this.startPos), Long.valueOf(this.endPos), Integer.valueOf(this.status));
    }

    private static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public String toString() {
        return "SliceRecord{taskId='" + this.taskId + '\'' + ", sliceId=" + this.sliceId + ", file='" + this.file + '\'' + ", startPos=" + this.startPos + ", endPos=" + this.endPos + ", status=" + this.status + ", uploadCount=" + this.uploadCount + '}';
    }
}
