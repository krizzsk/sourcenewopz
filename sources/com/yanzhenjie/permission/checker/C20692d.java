package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import com.didi.security.uuid.share.ShareDBHelper;
import com.yanzhenjie.permission.checker.PermissionTest;

/* renamed from: com.yanzhenjie.permission.checker.d */
/* compiled from: CallLogReadTest */
class C20692d implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f56180a;

    C20692d(Context context) {
        this.f56180a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        Cursor query = this.f56180a.query(CallLog.Calls.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "number", "type"}, (String) null, (String[]) null, (String) null);
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
