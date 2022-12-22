package xcrash;

import java.io.File;
import java.io.FilenameFilter;

class FileManager$3 implements FilenameFilter {
    final /* synthetic */ C3165c this$0;

    FileManager$3(C3165c cVar) {
        this.this$0 = cVar;
    }

    public boolean accept(File file, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.this$0.f7071a);
        sb.append("_");
        return str.startsWith(sb.toString()) && str.endsWith(this.this$0.f7072b);
    }
}
