package com.didi.map.utils.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiskLogStrategy implements LogStrategy {

    /* renamed from: a */
    private final Handler f29043a;

    public DiskLogStrategy(Handler handler) {
        this.f29043a = (Handler) C10238b.m20477b(handler);
    }

    public void log(int i, String str, String str2) {
        C10238b.m20477b(str2);
        Handler handler = this.f29043a;
        handler.sendMessage(handler.obtainMessage(i, str2));
    }

    static class WriteHandler extends Handler {
        private final String folder;
        private final int maxFileSize;

        WriteHandler(Looper looper, String str, int i) {
            super((Looper) C10238b.m20477b(looper));
            this.folder = (String) C10238b.m20477b(str);
            this.maxFileSize = i;
        }

        public void handleMessage(Message message) {
            String str = (String) message.obj;
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(getLogFile(this.folder, "logs"), true);
                try {
                    writeLog(fileWriter2, str);
                    fileWriter2.flush();
                    fileWriter2.close();
                } catch (IOException unused) {
                    fileWriter = fileWriter2;
                }
            } catch (IOException unused2) {
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        }

        private void writeLog(FileWriter fileWriter, String str) throws IOException {
            C10238b.m20477b(fileWriter);
            C10238b.m20477b(str);
            fileWriter.append(str);
        }

        private File getLogFile(String str, String str2) {
            File file;
            C10238b.m20477b(str);
            C10238b.m20477b(str2);
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = null;
            File file4 = new File(file2, String.format("%s_%s.csv", new Object[]{str2, 0}));
            int i = 0;
            while (true) {
                File file5 = file4;
                file = file3;
                file3 = file5;
                if (!file3.exists()) {
                    break;
                }
                i++;
                file4 = new File(file2, String.format("%s_%s.csv", new Object[]{str2, Integer.valueOf(i)}));
            }
            return (file == null || file.length() >= ((long) this.maxFileSize)) ? file3 : file;
        }
    }
}
