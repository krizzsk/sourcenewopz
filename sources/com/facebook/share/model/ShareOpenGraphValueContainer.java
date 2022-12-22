package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@Deprecated
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder> implements ShareModel {
    private final Bundle bundle;

    public int describeContents() {
        return 0;
    }

    protected ShareOpenGraphValueContainer(Builder builder) {
        this.bundle = (Bundle) builder.bundle.clone();
    }

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.bundle = parcel.readBundle(Builder.class.getClassLoader());
    }

    public Object get(String str) {
        return this.bundle.get(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.bundle.getBoolean(str, z);
    }

    public boolean[] getBooleanArray(String str) {
        return this.bundle.getBooleanArray(str);
    }

    public double getDouble(String str, double d) {
        return this.bundle.getDouble(str, d);
    }

    public double[] getDoubleArray(String str) {
        return this.bundle.getDoubleArray(str);
    }

    public int getInt(String str, int i) {
        return this.bundle.getInt(str, i);
    }

    public int[] getIntArray(String str) {
        return this.bundle.getIntArray(str);
    }

    public long getLong(String str, long j) {
        return this.bundle.getLong(str, j);
    }

    public long[] getLongArray(String str) {
        return this.bundle.getLongArray(str);
    }

    public ShareOpenGraphObject getObject(String str) {
        Object obj = this.bundle.get(str);
        if (obj instanceof ShareOpenGraphObject) {
            return (ShareOpenGraphObject) obj;
        }
        return null;
    }

    public ArrayList<ShareOpenGraphObject> getObjectArrayList(String str) {
        ArrayList parcelableArrayList = this.bundle.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList<ShareOpenGraphObject> arrayList = new ArrayList<>();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable instanceof ShareOpenGraphObject) {
                arrayList.add((ShareOpenGraphObject) parcelable);
            }
        }
        return arrayList;
    }

    public SharePhoto getPhoto(String str) {
        Parcelable parcelable = this.bundle.getParcelable(str);
        if (parcelable instanceof SharePhoto) {
            return (SharePhoto) parcelable;
        }
        return null;
    }

    public ArrayList<SharePhoto> getPhotoArrayList(String str) {
        ArrayList parcelableArrayList = this.bundle.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList<SharePhoto> arrayList = new ArrayList<>();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable instanceof SharePhoto) {
                arrayList.add((SharePhoto) parcelable);
            }
        }
        return arrayList;
    }

    public String getString(String str) {
        return this.bundle.getString(str);
    }

    public ArrayList<String> getStringArrayList(String str) {
        return this.bundle.getStringArrayList(str);
    }

    public Bundle getBundle() {
        return (Bundle) this.bundle.clone();
    }

    public Set<String> keySet() {
        return this.bundle.keySet();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.bundle);
    }

    public static abstract class Builder<M extends ShareOpenGraphValueContainer, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        /* access modifiers changed from: private */
        public Bundle bundle = new Bundle();

        public B putBoolean(String str, boolean z) {
            this.bundle.putBoolean(str, z);
            return this;
        }

        public B putBooleanArray(String str, boolean[] zArr) {
            this.bundle.putBooleanArray(str, zArr);
            return this;
        }

        public B putDouble(String str, double d) {
            this.bundle.putDouble(str, d);
            return this;
        }

        public B putDoubleArray(String str, double[] dArr) {
            this.bundle.putDoubleArray(str, dArr);
            return this;
        }

        public B putInt(String str, int i) {
            this.bundle.putInt(str, i);
            return this;
        }

        public B putIntArray(String str, int[] iArr) {
            this.bundle.putIntArray(str, iArr);
            return this;
        }

        public B putLong(String str, long j) {
            this.bundle.putLong(str, j);
            return this;
        }

        public B putLongArray(String str, long[] jArr) {
            this.bundle.putLongArray(str, jArr);
            return this;
        }

        public B putObject(String str, ShareOpenGraphObject shareOpenGraphObject) {
            this.bundle.putParcelable(str, shareOpenGraphObject);
            return this;
        }

        public B putObjectArrayList(String str, ArrayList<ShareOpenGraphObject> arrayList) {
            this.bundle.putParcelableArrayList(str, arrayList);
            return this;
        }

        public B putPhoto(String str, SharePhoto sharePhoto) {
            this.bundle.putParcelable(str, sharePhoto);
            return this;
        }

        public B putPhotoArrayList(String str, ArrayList<SharePhoto> arrayList) {
            this.bundle.putParcelableArrayList(str, arrayList);
            return this;
        }

        public B putString(String str, String str2) {
            this.bundle.putString(str, str2);
            return this;
        }

        public B putStringArrayList(String str, ArrayList<String> arrayList) {
            this.bundle.putStringArrayList(str, arrayList);
            return this;
        }

        public B readFrom(M m) {
            if (m != null) {
                this.bundle.putAll(m.getBundle());
            }
            return this;
        }
    }
}
