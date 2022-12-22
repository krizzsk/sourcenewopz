package com.didi.sdk.sidebar.data;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.didi.sdk.component.search.city.p148db.DIDIDbTables;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.p150db.ContentResolverWrapper;
import com.didi.sdk.sidebar.model.RedPoints;
import java.util.HashMap;
import java.util.List;

public class SideBarDbUtil {
    public static final String SUFFIX = "SUFFIX";

    /* renamed from: a */
    private static final String f37239a = "new-sidebar";

    /* renamed from: b */
    private static final Logger f37240b = LoggerFactory.getLogger(f37239a);

    public static void bulkInsert(Context context, List<RedPoints> list, Uri uri) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            ContentValues[] contentValuesArr = new ContentValues[size];
            for (int i = 0; i < size; i++) {
                contentValuesArr[i] = m26440a(list.get(i));
            }
            int bulkInsert = ContentResolverWrapper.bulkInsert(context.getContentResolver(), uri, contentValuesArr);
            Logger logger = f37240b;
            logger.infoEvent(f37239a, f37239a, "RedDotDbUtil bulkInsert count = " + bulkInsert);
        }
    }

    public static int delete(Context context, String str, String[] strArr, Uri uri) {
        int delete = ContentResolverWrapper.delete(context.getContentResolver(), uri, str, strArr);
        Logger logger = f37240b;
        logger.infoEvent(f37239a, f37239a, "SideBarDbUtil delete count = " + delete);
        return delete;
    }

    public static int update(Context context, long j, int i, Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DIDIDbTables.BaseSideBarNewColumn.IS_CLICKED, Integer.valueOf(i));
        int update = ContentResolverWrapper.update(context.getContentResolver(), uri, contentValues, "id =? ", new String[]{String.valueOf(j)});
        Logger logger = f37240b;
        logger.infoEvent(f37239a, f37239a, "RedDotDbUtil update count = " + update);
        return update;
    }

    /* renamed from: a */
    private static ContentValues m26440a(RedPoints redPoints) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("endTime", Long.valueOf(redPoints.getEndTime()));
        contentValues.put(DIDIDbTables.BaseSideBarNewColumn.START_TIME, Long.valueOf(redPoints.getStartTime()));
        contentValues.put("id", Long.valueOf(redPoints.getId()));
        contentValues.put(DIDIDbTables.BaseSideBarNewColumn.COMPONENT_ID, Long.valueOf(redPoints.getComponentId()));
        contentValues.put(DIDIDbTables.BaseSideBarNewColumn.IS_CLICKED, Integer.valueOf(redPoints.getIsCLicked()));
        contentValues.put("page", redPoints.getPage());
        contentValues.put("level", redPoints.getLevel());
        return contentValues;
    }

    public static HashMap<String, RedPoints> queryValid(Context context, Uri uri) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        return query(uri, context, (String[]) null, "startTime<=? AND endTime >=? ", new String[]{valueOf, valueOf});
    }

    public static HashMap<String, RedPoints> queryAll(Context context, Uri uri) {
        return query(uri, context, (String[]) null, (String) null, (String[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0091, code lost:
        if (r2 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0094, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0075, code lost:
        if (r2 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0077, code lost:
        r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, com.didi.sdk.sidebar.model.RedPoints> query(android.net.Uri r9, android.content.Context r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13) {
        /*
            java.lang.String r0 = "new-sidebar"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = 0
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x007d }
            r8 = 0
            r4 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            android.database.Cursor r2 = com.didi.sdk.p150db.ContentResolverWrapper.query(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x007d }
            if (r2 == 0) goto L_0x0075
            boolean r9 = r2.moveToFirst()     // Catch:{ Exception -> 0x007d }
            if (r9 == 0) goto L_0x0075
        L_0x001d:
            com.didi.sdk.sidebar.model.RedPoints r9 = new com.didi.sdk.sidebar.model.RedPoints     // Catch:{ Exception -> 0x007d }
            r9.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r10 = "endTime"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ Exception -> 0x007d }
            long r10 = r2.getLong(r10)     // Catch:{ Exception -> 0x007d }
            r9.setStartTime(r10)     // Catch:{ Exception -> 0x007d }
            java.lang.String r10 = "startTime"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ Exception -> 0x007d }
            long r10 = r2.getLong(r10)     // Catch:{ Exception -> 0x007d }
            r9.setEndTime(r10)     // Catch:{ Exception -> 0x007d }
            java.lang.String r10 = "id"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ Exception -> 0x007d }
            long r10 = r2.getLong(r10)     // Catch:{ Exception -> 0x007d }
            r9.setId(r10)     // Catch:{ Exception -> 0x007d }
            java.lang.String r10 = "component_id"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ Exception -> 0x007d }
            long r10 = r2.getLong(r10)     // Catch:{ Exception -> 0x007d }
            r9.setComponentId(r10)     // Catch:{ Exception -> 0x007d }
            java.lang.String r10 = "is_clicked"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ Exception -> 0x007d }
            int r10 = r2.getInt(r10)     // Catch:{ Exception -> 0x007d }
            r9.setIsCLicked(r10)     // Catch:{ Exception -> 0x007d }
            long r10 = r9.getId()     // Catch:{ Exception -> 0x007d }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x007d }
            r1.put(r10, r9)     // Catch:{ Exception -> 0x007d }
            boolean r9 = r2.moveToNext()     // Catch:{ Exception -> 0x007d }
            if (r9 != 0) goto L_0x001d
        L_0x0075:
            if (r2 == 0) goto L_0x0094
        L_0x0077:
            r2.close()
            goto L_0x0094
        L_0x007b:
            r9 = move-exception
            goto L_0x0095
        L_0x007d:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x007b }
            com.didi.sdk.logging.Logger r9 = f37240b     // Catch:{ all -> 0x007b }
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x007b }
            r11 = 0
            r10[r11] = r0     // Catch:{ all -> 0x007b }
            r11 = 1
            java.lang.String r12 = "RedDotDbUtil get red dot form db failed;"
            r10[r11] = r12     // Catch:{ all -> 0x007b }
            r9.infoEvent((java.lang.String) r0, (java.lang.Object[]) r10)     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0094
            goto L_0x0077
        L_0x0094:
            return r1
        L_0x0095:
            if (r2 == 0) goto L_0x009a
            r2.close()
        L_0x009a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.sidebar.data.SideBarDbUtil.query(android.net.Uri, android.content.Context, java.lang.String[], java.lang.String, java.lang.String[]):java.util.HashMap");
    }
}
