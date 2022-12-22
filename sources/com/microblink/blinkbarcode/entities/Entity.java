package com.microblink.blinkbarcode.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity.Result;

/* compiled from: line */
public abstract class Entity<T extends Result> implements Parcelable {
    private T IlIllIlIIl = null;
    private long llIIlIlIIl = 0;

    /* compiled from: line */
    public static abstract class Result implements Parcelable {
        public Object IlIllIlIIl = null;
        private long llIIlIlIIl = 0;

        public Result(long j) {
            this.llIIlIlIIl = j;
        }

        public abstract byte[] IlIllIlIIl();

        public abstract Result clone();

        public final int describeContents() {
            return 0;
        }

        public void finalize() throws Throwable {
            super.finalize();
            if (this.IlIllIlIIl == null) {
                llIIlIlIIl(this.llIIlIlIIl);
            }
        }

        public final long getNativeContext() {
            return this.llIIlIlIIl;
        }

        public abstract void llIIlIlIIl(long j);

        public void llIIlIlIIl(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                llIIlIlIIl(bArr);
            }
        }

        public abstract void llIIlIlIIl(byte[] bArr);

        public abstract boolean llIIlIlIIl();

        public void writeToParcel(Parcel parcel, int i) {
            byte[] IlIllIlIIl2 = IlIllIlIIl();
            if (IlIllIlIIl2 != null) {
                parcel.writeInt(IlIllIlIIl2.length);
                parcel.writeByteArray(IlIllIlIIl2);
                return;
            }
            parcel.writeInt(0);
        }
    }

    public Entity(long j, T t) {
        llIIlIlIIl(j, t);
    }

    private void llIIlIlIIl(long j, T t) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = t;
        t.IlIllIlIIl = this;
    }

    public static native long nativeGetNativeResultContext(long j);

    public abstract Entity clone();

    public abstract void consumeResultFrom(Entity entity);

    public int describeContents() {
        return 0;
    }

    public void finalize() throws Throwable {
        super.finalize();
        llIIlIlIIl(this.llIIlIlIIl);
    }

    public final long getNativeContext() {
        return this.llIIlIlIIl;
    }

    public final T getResult() {
        return this.IlIllIlIIl;
    }

    public abstract void llIIlIlIIl(long j);

    public abstract void llIIlIlIIl(byte[] bArr);

    public abstract byte[] llIIlIlIIl();

    public void writeToParcel(Parcel parcel, int i) {
        byte[] llIIlIlIIl2 = llIIlIlIIl();
        if (llIIlIlIIl2 != null) {
            parcel.writeInt(llIIlIlIIl2.length);
            parcel.writeByteArray(llIIlIlIIl2);
        } else {
            parcel.writeInt(0);
        }
        boolean z = !this.IlIllIlIIl.llIIlIlIIl();
        parcel.writeByte(z ? (byte) 1 : 0);
        if (z) {
            this.IlIllIlIIl.writeToParcel(parcel, i);
        }
    }

    public void llIIlIlIIl(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            llIIlIlIIl(bArr);
        }
        if (parcel.readByte() != 0) {
            this.IlIllIlIIl.llIIlIlIIl(parcel);
        }
    }

    public Entity(long j, T t, Parcel parcel) {
        llIIlIlIIl(j, t);
        llIIlIlIIl(parcel);
    }
}
