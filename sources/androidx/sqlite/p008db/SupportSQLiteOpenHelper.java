package androidx.sqlite.p008db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.Closeable;
import java.io.File;

/* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Factory */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Callback */
    public static abstract class Callback {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);

        public Callback(int i) {
            this.version = i;
        }

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
            if (r0 != null) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
            r9 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
            if (r9.hasNext() != false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
            deleteDatabaseFile((java.lang.String) r9.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
            deleteDatabaseFile(r9.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0036 */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0034 A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v9 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x002f, B:8:0x0036, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x002f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(androidx.sqlite.p008db.SupportSQLiteDatabase r9) {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Corruption reported by sqlite on database: "
                r0.append(r1)
                java.lang.String r1 = r9.getPath()
                r0.append(r1)
                java.lang.String r4 = r0.toString()
                r2 = 6
                java.lang.String r3 = "SupportSQLite"
                r5 = 0
                java.lang.String r6 = "androidx.sqlite.db.SupportSQLiteOpenHelper$Callback"
                r7 = 236(0xec, float:3.31E-43)
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
                boolean r0 = r9.isOpen()
                if (r0 != 0) goto L_0x002e
                java.lang.String r9 = r9.getPath()
                r8.deleteDatabaseFile(r9)
                return
            L_0x002e:
                r0 = 0
                java.util.List r0 = r9.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0036, all -> 0x0034 }
                goto L_0x0036
            L_0x0034:
                r1 = move-exception
                goto L_0x003a
            L_0x0036:
                r9.close()     // Catch:{ IOException -> 0x005c, all -> 0x0034 }
                goto L_0x005d
            L_0x003a:
                if (r0 == 0) goto L_0x0054
                java.util.Iterator r9 = r0.iterator()
            L_0x0040:
                boolean r0 = r9.hasNext()
                if (r0 == 0) goto L_0x005b
                java.lang.Object r0 = r9.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r8.deleteDatabaseFile(r0)
                goto L_0x0040
            L_0x0054:
                java.lang.String r9 = r9.getPath()
                r8.deleteDatabaseFile(r9)
            L_0x005b:
                throw r1
            L_0x005c:
            L_0x005d:
                if (r0 == 0) goto L_0x0077
                java.util.Iterator r9 = r0.iterator()
            L_0x0063:
                boolean r0 = r9.hasNext()
                if (r0 == 0) goto L_0x007e
                java.lang.Object r0 = r9.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r8.deleteDatabaseFile(r0)
                goto L_0x0063
            L_0x0077:
                java.lang.String r9 = r9.getPath()
                r8.deleteDatabaseFile(r9)
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.p008db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        private void deleteDatabaseFile(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                SystemUtils.log(5, TAG, "deleting the database file: " + str, (Throwable) null, "androidx.sqlite.db.SupportSQLiteOpenHelper$Callback", 281);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                        return;
                    }
                    try {
                        if (!new File(str).delete()) {
                            SystemUtils.log(6, TAG, "Could not delete the database file " + str, (Throwable) null, "androidx.sqlite.db.SupportSQLiteOpenHelper$Callback", 289);
                        }
                    } catch (Exception e) {
                        SystemUtils.log(6, TAG, "error while deleting corrupted database file", e, "androidx.sqlite.db.SupportSQLiteOpenHelper$Callback", 292);
                    }
                } catch (Exception e2) {
                    SystemUtils.log(5, TAG, "delete failed: ", e2, "androidx.sqlite.db.SupportSQLiteOpenHelper$Callback", 297);
                }
            }
        }
    }

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration */
    public static class Configuration {
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        Configuration(Context context2, String str, Callback callback2) {
            this(context2, str, callback2, false);
        }

        Configuration(Context context2, String str, Callback callback2, boolean z) {
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z;
        }

        public static Builder builder(Context context2) {
            return new Builder(context2);
        }

        /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder */
        public static class Builder {
            Callback mCallback;
            Context mContext;
            String mName;
            boolean mUseNoBackUpDirectory;

            public Configuration build() {
                if (this.mCallback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.mContext == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.mUseNoBackUpDirectory || !TextUtils.isEmpty(this.mName)) {
                    return new Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackUpDirectory);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            Builder(Context context) {
                this.mContext = context;
            }

            public Builder name(String str) {
                this.mName = str;
                return this;
            }

            public Builder callback(Callback callback) {
                this.mCallback = callback;
                return this;
            }

            public Builder noBackupDirectory(boolean z) {
                this.mUseNoBackUpDirectory = z;
                return this;
            }
        }
    }
}
