package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;

/* renamed from: com.yanzhenjie.permission.checker.h */
/* compiled from: ContactsWriteTest */
class C20696h implements PermissionTest {

    /* renamed from: a */
    private static final String f56185a = "PERMISSION";

    /* renamed from: b */
    private ContentResolver f56186b;

    C20696h(ContentResolver contentResolver) {
        this.f56186b = contentResolver;
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        Cursor query = this.f56186b.query(ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id"}, "mimetype=? and data1=?", new String[]{"vnd.android.cursor.item/name", f56185a}, (String) null);
        if (query == null) {
            return false;
        }
        if (query.moveToFirst()) {
            long j = query.getLong(0);
            query.close();
            return m40455a(j);
        }
        query.close();
        return m40456b();
    }

    /* renamed from: b */
    private boolean m40456b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("raw_contact_id", Long.valueOf(ContentUris.parseId(this.f56186b.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues))));
        contentValues.put("data1", f56185a);
        contentValues.put("data2", f56185a);
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        return ContentUris.parseId(this.f56186b.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0;
    }

    /* renamed from: a */
    private void m40454a(long j, long j2) {
        this.f56186b.delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{Long.toString(j)});
        this.f56186b.delete(ContactsContract.Data.CONTENT_URI, "_id=?", new String[]{Long.toString(j2)});
    }

    /* renamed from: a */
    private boolean m40455a(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("raw_contact_id", Long.valueOf(j));
        contentValues.put("data1", f56185a);
        contentValues.put("data2", f56185a);
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        return ContentUris.parseId(this.f56186b.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0;
    }
}
