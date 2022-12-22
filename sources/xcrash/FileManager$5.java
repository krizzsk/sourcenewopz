package xcrash;

import java.io.File;
import java.io.FilenameFilter;

class FileManager$5 implements FilenameFilter {
    final /* synthetic */ C3165c this$0;
    final /* synthetic */ String val$logSuffix;

    FileManager$5(C3165c cVar, String str) {
        this.this$0 = cVar;
        this.val$logSuffix = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith("tombstone_") && str.endsWith(this.val$logSuffix);
    }
}
