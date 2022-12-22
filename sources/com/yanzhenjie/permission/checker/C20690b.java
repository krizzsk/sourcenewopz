package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.didi.security.uuid.share.ShareDBHelper;
import com.yanzhenjie.permission.checker.PermissionTest;

/* renamed from: com.yanzhenjie.permission.checker.b */
/* compiled from: CalendarReadTest */
class C20690b implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f56176a;

    C20690b(Context context) {
        this.f56176a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        Cursor query = this.f56176a.query(CalendarContract.Calendars.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "name"}, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return false;
        }
        try {
            PermissionTest.CursorTest.read(query);
            query.close();
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}
