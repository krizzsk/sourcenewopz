package com.didi.sdk.logging.upload;

import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileEntry {
    @SerializedName("is_dir")
    private boolean isDir;
    @SerializedName("modified")
    private String lastModified;
    @SerializedName("name")
    private String name;
    @SerializedName("size")
    private String size;
    @SerializedName("subpaths")
    private List<FileEntry> subPaths;

    public FileEntry(File file) {
        this.name = file.getName();
        this.size = String.valueOf(file.length());
        this.lastModified = String.valueOf(file.lastModified());
        boolean isDirectory = file.isDirectory();
        this.isDir = isDirectory;
        if (isDirectory) {
            this.subPaths = new ArrayList();
            for (File fileEntry : file.listFiles()) {
                this.subPaths.add(new FileEntry(fileEntry));
            }
        }
    }
}
