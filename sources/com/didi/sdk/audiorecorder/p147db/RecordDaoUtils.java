package com.didi.sdk.audiorecorder.p147db;

import android.content.Context;
import com.didi.sdk.audiorecorder.model.RecordResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.audiorecorder.db.RecordDaoUtils */
public class RecordDaoUtils {
    public static List<RecordResult> getAll(Context context) {
        try {
            return RecordDatabase.getInstance(context).recordDao().getAll();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public static void insert(Context context, RecordResult recordResult) {
        try {
            RecordDatabase.getInstance(context).recordDao().insert(recordResult);
        } catch (Throwable unused) {
        }
    }

    public static void del(Context context, long j) {
        try {
            RecordDatabase.getInstance(context).recordDao().del(j);
        } catch (Throwable unused) {
        }
    }

    public static void update(Context context, RecordResult recordResult) {
        try {
            RecordDatabase.getInstance(context).recordDao().update(recordResult);
        } catch (Throwable unused) {
        }
    }
}
