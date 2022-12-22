package com.didi.sdk.onehotpatch.installer.dexopt;

import android.os.FileObserver;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import java.io.File;
import java.util.HashMap;

public class DexOptFileObserver extends FileObserver {
    String mBase;
    HashMap<File, FileObserver> mMap = new HashMap<>();
    File mOdexFile;
    String mPath;
    DexOptFileObserver mRoot;
    int mStatus = -1;

    public DexOptFileObserver(String str) {
        super(str);
        this.mBase = str;
        this.mPath = str;
        this.mRoot = this;
    }

    public DexOptFileObserver(DexOptFileObserver dexOptFileObserver, String str, String str2) {
        super(str2);
        this.mBase = str;
        this.mPath = str2;
        this.mRoot = dexOptFileObserver;
    }

    public void onEvent(int i, String str) {
        if (str != null) {
            File file = new File(this.mPath, str);
            if (file.isDirectory() && !this.mMap.containsKey(file)) {
                DexOptFileObserver dexOptFileObserver = new DexOptFileObserver(this.mRoot, this.mBase, file.getAbsolutePath());
                this.mMap.put(file, dexOptFileObserver);
                dexOptFileObserver.startWatching();
            }
            if (str.endsWith(DexOptService.ODEX_SUFFIX)) {
                DexOptFileObserver dexOptFileObserver2 = this.mRoot;
                dexOptFileObserver2.mStatus++;
                if (i == 8) {
                    dexOptFileObserver2.mOdexFile = file;
                }
                Logger.dex2oatInfo("event: " + i + "    path: " + getRelativedPath(file.getAbsolutePath()) + "  " + this.mRoot.mStatus);
            }
        }
    }

    public void startWatching() {
        super.startWatching();
        Logger.dex2oatInfo("startWatching!!!");
        startWatching(new File(this.mPath));
    }

    private void startWatching(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    DexOptFileObserver dexOptFileObserver = new DexOptFileObserver(this.mRoot, this.mBase, file2.getAbsolutePath());
                    this.mMap.put(file2, dexOptFileObserver);
                    dexOptFileObserver.startWatching();
                    startWatching(file2);
                }
            }
        }
    }

    private String getRelativedPath(String str) {
        int indexOf = str.indexOf(this.mBase);
        return indexOf >= 0 ? str.substring(indexOf + this.mBase.length(), str.length()) : str;
    }

    public void stopWatching() {
        for (FileObserver stopWatching : this.mMap.values()) {
            stopWatching.stopWatching();
        }
        super.stopWatching();
    }
}
