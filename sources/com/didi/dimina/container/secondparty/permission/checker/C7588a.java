package com.didi.dimina.container.secondparty.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.didi.dimina.container.secondparty.permission.checker.PermissionTest;
import com.didi.security.uuid.share.ShareDBHelper;

/* renamed from: com.didi.dimina.container.secondparty.permission.checker.a */
/* compiled from: ContactsReadTest */
class C7588a implements PermissionTest {

    /* renamed from: a */
    private final ContentResolver f17351a;

    C7588a(Context context) {
        this.f17351a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo55894a() throws Throwable {
        Cursor query = this.f17351a.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "data1"}, (String) null, (String[]) null, (String) null);
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
