package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract;
import java.util.TimeZone;

/* renamed from: com.yanzhenjie.permission.checker.c */
/* compiled from: CalendarWriteTest */
class C20691c implements PermissionTest {

    /* renamed from: a */
    private static final String f56177a = "PERMISSION";

    /* renamed from: b */
    private static final String f56178b = "permission@gmail.com";

    /* renamed from: c */
    private ContentResolver f56179c;

    C20691c(Context context) {
        this.f56179c = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", f56177a);
            contentValues.put("account_name", f56178b);
            contentValues.put("account_type", "LOCAL");
            contentValues.put("calendar_displayName", f56177a);
            boolean z = true;
            contentValues.put("visible", 1);
            contentValues.put("calendar_color", -16776961);
            contentValues.put("calendar_access_level", 700);
            contentValues.put("sync_events", 1);
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("ownerAccount", f56177a);
            contentValues.put("canOrganizerRespond", 0);
            if (ContentUris.parseId(this.f56179c.insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", f56177a).appendQueryParameter("account_type", "LOCAL").build(), contentValues)) <= 0) {
                z = false;
            }
            return z;
        } finally {
            this.f56179c.delete(CalendarContract.Calendars.CONTENT_URI.buildUpon().build(), "account_name=?", new String[]{f56178b});
        }
    }
}
