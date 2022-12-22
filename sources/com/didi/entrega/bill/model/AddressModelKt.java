package com.didi.entrega.bill.model;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, mo175978d2 = {"phoneNum", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressModel.kt */
public final class AddressModelKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final String m14611a(AddressEntity addressEntity) {
        CharSequence charSequence = addressEntity.phone;
        boolean z = false;
        String str = "";
        if (charSequence == null || charSequence.length() == 0) {
            return str;
        }
        CharSequence charSequence2 = addressEntity.callingCode;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            String str2 = addressEntity.phone;
            return str2 != null ? str2 : str;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = addressEntity.callingCode;
        if (str3 == null) {
            str3 = str;
        }
        sb.append(str3);
        sb.append(' ');
        String str4 = addressEntity.phone;
        if (str4 != null) {
            str = str4;
        }
        sb.append(str);
        return sb.toString();
    }
}
