package com.didi.sdk.logging.upload;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class FileTree {
    @SerializedName("data")
    private List<FileEntry> fileEntries = new ArrayList();
    @SerializedName("timestamp")
    private String timestamp = String.valueOf(System.currentTimeMillis());

    public void addSubTree(FileEntry fileEntry) {
        this.fileEntries.add(fileEntry);
    }

    public String toJson() {
        return new Gson().toJson((Object) this);
    }
}
