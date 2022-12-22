package com.microblink.blinkbarcode.entities.util;

import android.content.Intent;
import android.os.Parcel;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.intent.llIIlIlIIl;

/* compiled from: line */
public abstract class IntentTransferableEntity<E extends Entity> extends llIIlIlIIl<IntentTransferableEntity<E>> {
    private E IlIllIlIIl;

    public IntentTransferableEntity(E e) {
        if (e != null) {
            this.IlIllIlIIl = e;
            return;
        }
        throw new IllegalArgumentException("Entity must not be null!");
    }

    public void llIIlIlIIl(llIIlIlIIl lliililiil) {
        IntentTransferableEntity intentTransferableEntity = (IntentTransferableEntity) lliililiil;
        E e = this.IlIllIlIIl;
        if (e == null) {
            this.IlIllIlIIl = intentTransferableEntity.IlIllIlIIl;
        } else {
            e.consumeResultFrom(intentTransferableEntity.IlIllIlIIl);
        }
    }

    public void saveToIntent(Intent intent) {
        if (this.IlIllIlIIl != null) {
            super.saveToIntent(intent);
            return;
        }
        throw new IllegalStateException("Unable to save wrapper without entity!");
    }

    public void writeToParcel(Parcel parcel, int i) {
        E e = this.IlIllIlIIl;
        if (e != null) {
            parcel.writeParcelable(e, i);
            super.writeToParcel(parcel, i);
            return;
        }
        throw new IllegalStateException("Unable to parcelize wrapper without entity!");
    }

    public IntentTransferableEntity() {
    }
}
