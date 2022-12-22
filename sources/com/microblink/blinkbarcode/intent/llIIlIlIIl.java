package com.microblink.blinkbarcode.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.intent.llIIlIlIIl;
import java.util.UUID;

/* compiled from: line */
public abstract class llIIlIlIIl<T extends llIIlIlIIl> implements llIIIlllll {
    private String llIIlIlIIl;

    private String llIIlIlIIl(Intent intent) {
        String stringExtra = intent.getStringExtra(IlIllIlIIl());
        if (stringExtra == null) {
            return null;
        }
        String str = this.llIIlIlIIl;
        if (str == null || stringExtra.equals(str)) {
            return stringExtra;
        }
        return null;
    }

    public abstract String IlIllIlIIl();

    public void clearSavedState() {
        String str = this.llIIlIlIIl;
        if (str != null) {
            IllIIIllII.llIIlIlIIl(str);
        }
    }

    public int describeContents() {
        return 0;
    }

    public final boolean existsInIntent(Intent intent) {
        return llIIlIlIIl(intent) != null;
    }

    public abstract Parcelable.Creator<? extends T> llIIlIlIIl();

    public abstract void llIIlIlIIl(T t);

    public final void loadFromIntent(Intent intent) {
        String llIIlIlIIl2 = llIIlIlIIl(intent);
        if (llIIlIlIIl2 != null) {
            llIIlIlIIl lliililiil = (llIIlIlIIl) IllIIIllII.llIIlIlIIl(intent, llIIlIlIIl2, llIIlIlIIl());
            if (lliililiil != null) {
                this.llIIlIlIIl = lliililiil.llIIlIlIIl;
                llIIlIlIIl(lliililiil);
                return;
            }
            throw new IllegalStateException("Intent transferable object cannot be loaded.");
        }
        throw new IllegalStateException("Expected intent transferable object does not exist in the intent!");
    }

    public void saveState() {
        String str = this.llIIlIlIIl;
        if (str != null) {
            IllIIIllII.llIIlIlIIl(str, this);
        }
    }

    public void saveToIntent(Intent intent) {
        if (this.llIIlIlIIl == null) {
            this.llIIlIlIIl = UUID.randomUUID().toString();
        }
        intent.putExtra(IlIllIlIIl(), this.llIIlIlIIl);
        IllIIIllII.llIIlIlIIl(intent, this.llIIlIlIIl, (llIIIlllll) this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.llIIlIlIIl);
    }

    public void llIIlIlIIl(Parcel parcel) {
        this.llIIlIlIIl = parcel.readString();
    }
}
