package com.didichuxing.mas.sdk.quality.report.record;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.util.List;

public class FileRecord {
    private List<FileRecord> children;
    private String displayPath;
    private boolean isDirectory;
    private FileRecord parent;
    private File path;
    private long size;

    public FileRecord(File file, boolean z) {
        this.path = file;
        this.isDirectory = z;
    }

    public long getSize() {
        return this.size;
    }

    public FileRecord setSize(long j) {
        this.size = j;
        return this;
    }

    public List<FileRecord> getChildren() {
        return this.children;
    }

    public FileRecord setChildren(List<FileRecord> list) {
        this.children = list;
        return this;
    }

    public FileRecord getParent() {
        return this.parent;
    }

    public void setParent(FileRecord fileRecord) {
        this.parent = fileRecord;
    }

    public File getPath() {
        return this.path;
    }

    public void setPath(File file) {
        this.path = file;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public FileRecord setDisplayPath(String str) {
        this.displayPath = str;
        return this;
    }

    private String getDisplayPath() {
        String str = this.displayPath;
        return str == null ? this.path.getAbsolutePath() : str;
    }

    public String toJSONString() {
        String replace = (this.isDirectory ? "{'path':'${path}','size':${size},'children':[${children}]}" : "{'path':'${path}','size':${size}}").replace("${path}", getDisplayPath()).replace("${size}", String.valueOf(this.size));
        if (!this.isDirectory) {
            return replace;
        }
        StringBuilder sb = new StringBuilder();
        List<FileRecord> list = this.children;
        if (list == null || list.isEmpty()) {
            return replace.replace("${children}", "");
        }
        int size2 = this.children.size();
        for (int i = 0; i < size2; i++) {
            sb.append(this.children.get(i).toJSONString());
            if (i < size2 - 1) {
                sb.append(",");
            }
        }
        return replace.replace("${children}", sb.toString());
    }

    public static String toJSONString(List<FileRecord> list) {
        if (list == null) {
            return "null";
        }
        if (list.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        int size2 = list.size();
        for (int i = 0; i < size2; i++) {
            sb.append(list.get(i).toJSONString());
            if (i < size2 - 1) {
                sb.append(",");
            }
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public String toString() {
        return "FileRecord{path='" + this.path + '\'' + ", size=" + this.size + '}';
    }
}
