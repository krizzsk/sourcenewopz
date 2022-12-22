package com.kwai.koom.javaoom.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.IOException;

public class KHeapFile implements Parcelable {
    public static final Parcelable.Creator<KHeapFile> CREATOR = new Parcelable.Creator<KHeapFile>() {
        public KHeapFile createFromParcel(Parcel parcel) {
            return new KHeapFile(parcel);
        }

        public KHeapFile[] newArray(int i) {
            return new KHeapFile[i];
        }
    };

    /* renamed from: a */
    private static KHeapFile f55598a = null;

    /* renamed from: c */
    private static final String f55599c = ".hprof";

    /* renamed from: d */
    private static final String f55600d = ".json";

    /* renamed from: e */
    private static final String f55601e = "KHeapFile";

    /* renamed from: b */
    private String f55602b;
    public Hprof hprof;
    public Report report;

    public int describeContents() {
        return 0;
    }

    public static void buildInstance(KHeapFile kHeapFile) {
        f55598a = kHeapFile;
    }

    public static KHeapFile buildInstance(File file, File file2) {
        KHeapFile kHeapFile = getKHeapFile();
        f55598a = kHeapFile;
        kHeapFile.hprof = new Hprof(file.getAbsolutePath());
        f55598a.report = new Report(file2.getAbsolutePath());
        return f55598a;
    }

    public KHeapFile() {
    }

    public static KHeapFile getKHeapFile() {
        KHeapFile kHeapFile = f55598a;
        if (kHeapFile != null) {
            return kHeapFile;
        }
        KHeapFile kHeapFile2 = new KHeapFile();
        f55598a = kHeapFile2;
        return kHeapFile2;
    }

    public static void delete() {
        KHeapFile kHeapFile = f55598a;
        if (kHeapFile != null) {
            kHeapFile.report.file().delete();
            f55598a.hprof.file().delete();
        }
    }

    /* renamed from: a */
    private String m40096a() {
        String str = this.f55602b;
        if (str != null) {
            return str;
        }
        String timeStamp = KUtils.getTimeStamp();
        this.f55602b = timeStamp;
        return timeStamp;
    }

    public void buildFiles() {
        this.hprof = m40098b();
        this.report = m40099c();
    }

    /* renamed from: a */
    private void m40097a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: b */
    private Hprof m40098b() {
        String str = m40096a() + f55599c;
        m40097a(KGlobalConfig.getHprofDir());
        return new Hprof(KGlobalConfig.getHprofDir() + File.separator + str);
    }

    /* renamed from: c */
    private Report m40099c() {
        m40097a(KGlobalConfig.getReportDir());
        Report report2 = new Report(KGlobalConfig.getReportDir() + File.separator + (m40096a() + f55600d));
        if (!report2.file().exists()) {
            try {
                report2.file().createNewFile();
                report2.file().setWritable(true);
                report2.file().setReadable(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return report2;
    }

    public static class Hprof extends BaseFile implements Parcelable {
        public static final Parcelable.Creator<Hprof> CREATOR = new Parcelable.Creator<Hprof>() {
            public Hprof createFromParcel(Parcel parcel) {
                return new Hprof(parcel);
            }

            public Hprof[] newArray(int i) {
                return new Hprof[i];
            }
        };
        public boolean stripped;

        public int describeContents() {
            return 0;
        }

        public /* bridge */ /* synthetic */ void delete() {
            super.delete();
        }

        public /* bridge */ /* synthetic */ File file() {
            return super.file();
        }

        public /* bridge */ /* synthetic */ String path() {
            return super.path();
        }

        public Hprof(String str) {
            super(str);
        }

        public static Hprof file(String str) {
            return new Hprof(str);
        }

        protected Hprof(Parcel parcel) {
            super(parcel);
            this.stripped = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.stripped ? (byte) 1 : 0);
        }
    }

    public static class Report extends BaseFile {
        public static final Parcelable.Creator<Report> CREATOR = new Parcelable.Creator<Report>() {
            public Report createFromParcel(Parcel parcel) {
                return new Report(parcel);
            }

            public Report[] newArray(int i) {
                return new Report[i];
            }
        };

        public /* bridge */ /* synthetic */ void delete() {
            super.delete();
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ File file() {
            return super.file();
        }

        public /* bridge */ /* synthetic */ String path() {
            return super.path();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public Report(String str) {
            super(str);
        }

        public static Report file(String str) {
            return new Report(str);
        }

        protected Report(Parcel parcel) {
            super(parcel);
        }
    }

    private static class BaseFile implements Parcelable {
        public static final Parcelable.Creator<BaseFile> CREATOR = new Parcelable.Creator<BaseFile>() {
            public BaseFile createFromParcel(Parcel parcel) {
                return new BaseFile(parcel);
            }

            public BaseFile[] newArray(int i) {
                return new BaseFile[i];
            }
        };
        private File file;
        public String path;

        public int describeContents() {
            return 0;
        }

        private BaseFile(String str) {
            this.path = str;
        }

        public String path() {
            return this.path;
        }

        public File file() {
            File file2 = this.file;
            if (file2 != null) {
                return file2;
            }
            File file3 = new File(this.path);
            this.file = file3;
            return file3;
        }

        public void delete() {
            File file2 = file();
            this.file = file2;
            if (file2 != null) {
                file2.delete();
            }
        }

        protected BaseFile(Parcel parcel) {
            this.path = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.path);
        }
    }

    protected KHeapFile(Parcel parcel) {
        this.hprof = (Hprof) parcel.readParcelable(Hprof.class.getClassLoader());
        this.report = (Report) parcel.readParcelable(Report.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.hprof, i);
        parcel.writeParcelable(this.report, i);
    }
}
