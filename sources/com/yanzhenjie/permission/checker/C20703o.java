package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony;
import com.didi.security.uuid.share.ShareDBHelper;
import com.yanzhenjie.permission.checker.PermissionTest;

/* renamed from: com.yanzhenjie.permission.checker.o */
/* compiled from: SmsReadTest */
class C20703o implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f56195a;

    C20703o(Context context) {
        this.f56195a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        Cursor query = this.f56195a.query(Telephony.Sms.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "address", "person", "body"}, (String) null, (String[]) null, (String) null);
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
