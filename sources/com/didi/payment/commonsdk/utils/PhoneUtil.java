package com.didi.payment.commonsdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.didi.payment.pix.contacts.p134vm.model.PhoneContacts;
import java.util.ArrayList;
import java.util.List;

public class PhoneUtil {
    public static List<PhoneContacts> getPhoneRecords(Context context) {
        ArrayList arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        while (query.moveToNext()) {
            arrayList.add(new PhoneContacts(query.getString(query.getColumnIndex("display_name")), query.getString(query.getColumnIndex("data1"))));
        }
        return arrayList;
    }
}
