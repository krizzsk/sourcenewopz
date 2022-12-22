package com.microblink.blinkbarcode.entities.recognizers;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.image.highres.HighResImageWrapper;
import com.microblink.blinkbarcode.intent.llIIlIlIIl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: line */
public class HighResImagesBundle extends llIIlIlIIl<HighResImagesBundle> {
    public static final Parcelable.Creator<HighResImagesBundle> CREATOR = new Parcelable.Creator<HighResImagesBundle>() {
        public HighResImagesBundle createFromParcel(Parcel parcel) {
            return new HighResImagesBundle(parcel);
        }

        public HighResImagesBundle[] newArray(int i) {
            return new HighResImagesBundle[i];
        }
    };
    private List<HighResImageWrapper> IlIllIlIIl;

    public String IlIllIlIIl() {
        return "com.microblink.blinkbarcode.intent.constants.HighResImages.id";
    }

    public void addImage(HighResImageWrapper highResImageWrapper) {
        this.IlIllIlIIl.add(highResImageWrapper);
    }

    public void clearImages() {
        this.IlIllIlIIl.clear();
    }

    public List<HighResImageWrapper> getImages() {
        return this.IlIllIlIIl;
    }

    public void llIIlIlIIl(llIIlIlIIl lliililiil) {
        this.IlIllIlIIl = ((HighResImagesBundle) lliililiil).IlIllIlIIl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((Parcelable[]) this.IlIllIlIIl.toArray(new HighResImageWrapper[0]), i);
    }

    public HighResImagesBundle() {
        this.IlIllIlIIl = new ArrayList();
    }

    public Parcelable.Creator<? extends HighResImagesBundle> llIIlIlIIl() {
        return CREATOR;
    }

    public HighResImagesBundle(Intent intent) {
        this.IlIllIlIIl = new ArrayList();
        loadFromIntent(intent);
    }

    public void llIIlIlIIl(Parcel parcel) {
        super.llIIlIlIIl(parcel);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(HighResImageWrapper.class.getClassLoader());
        this.IlIllIlIIl = new ArrayList();
        for (Parcelable parcelable : readParcelableArray) {
            this.IlIllIlIIl.add((HighResImageWrapper) parcelable);
        }
    }

    private HighResImagesBundle(Parcel parcel) {
        this.IlIllIlIIl = new ArrayList();
        llIIlIlIIl(parcel);
    }
}
