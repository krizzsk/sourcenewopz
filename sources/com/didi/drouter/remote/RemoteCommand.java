package com.didi.drouter.remote;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

class RemoteCommand implements Parcelable {
    public static final Parcelable.Creator<RemoteCommand> CREATOR = new Parcelable.Creator<RemoteCommand>() {
        public RemoteCommand createFromParcel(Parcel parcel) {
            return new RemoteCommand(parcel);
        }

        public RemoteCommand[] newArray(int i) {
            return new RemoteCommand[i];
        }
    };

    /* renamed from: a */
    static final int f19138a = 0;

    /* renamed from: b */
    static final int f19139b = 1;

    /* renamed from: c */
    static final int f19140c = 2;

    /* renamed from: d */
    static final int f19141d = 3;

    /* renamed from: e */
    int f19142e;

    /* renamed from: f */
    RemoteBridge f19143f;

    /* renamed from: g */
    WeakReference<LifecycleOwner> f19144g;

    /* renamed from: h */
    String f19145h;

    /* renamed from: i */
    IBinder f19146i;

    /* renamed from: j */
    boolean f19147j;

    /* renamed from: k */
    int f19148k;

    /* renamed from: l */
    Bundle f19149l;

    /* renamed from: m */
    Map<String, Object> f19150m;

    /* renamed from: n */
    Class<?> f19151n;

    /* renamed from: o */
    String f19152o;

    /* renamed from: p */
    Object f19153p;

    /* renamed from: q */
    String f19154q;

    /* renamed from: r */
    Object[] f19155r;

    /* renamed from: s */
    Object[] f19156s;

    /* renamed from: t */
    Object[] f19157t;

    /* renamed from: u */
    private final int f19158u;

    public int describeContents() {
        return 0;
    }

    RemoteCommand(int i) {
        this.f19158u = i;
    }

    RemoteCommand(Parcel parcel) {
        Class<RemoteCommand> cls = RemoteCommand.class;
        int readInt = parcel.readInt();
        this.f19158u = readInt;
        if (readInt == 0) {
            this.f19145h = parcel.readString();
            this.f19146i = parcel.readStrongBinder();
            this.f19149l = parcel.readBundle(Bundle.class.getClassLoader());
            this.f19150m = (Map) RemoteStream.m14344b(parcel.readValue(cls.getClassLoader()));
        }
        boolean z = true;
        if (this.f19158u == 1) {
            this.f19147j = parcel.readInt() != 1 ? false : z;
            this.f19148k = parcel.readInt();
            this.f19149l = parcel.readBundle(Bundle.class.getClassLoader());
            this.f19150m = (Map) RemoteStream.m14344b(parcel.readValue(cls.getClassLoader()));
        }
        if (this.f19158u == 2) {
            this.f19151n = (Class) parcel.readSerializable();
            this.f19152o = parcel.readString();
            this.f19153p = RemoteStream.m14344b(parcel.readValue(cls.getClassLoader()));
            this.f19154q = parcel.readString();
            this.f19155r = (Object[]) RemoteStream.m14344b(parcel.readValue(cls.getClassLoader()));
            this.f19156s = (Object[]) RemoteStream.m14344b(parcel.readValue(cls.getClassLoader()));
        }
        if (this.f19158u == 3) {
            this.f19157t = (Object[]) RemoteStream.m14344b(parcel.readValue(cls.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19158u);
        if (this.f19158u == 0) {
            parcel.writeString(this.f19145h);
            parcel.writeStrongBinder(this.f19146i);
            parcel.writeBundle(this.f19149l);
            parcel.writeValue(RemoteStream.m14342a(this.f19150m));
        }
        if (this.f19158u == 1) {
            parcel.writeInt(this.f19147j ? 1 : 0);
            parcel.writeInt(this.f19148k);
            parcel.writeBundle(this.f19149l);
            parcel.writeValue(RemoteStream.m14342a(this.f19150m));
        }
        if (this.f19158u == 2) {
            parcel.writeSerializable(this.f19151n);
            parcel.writeString(this.f19152o);
            parcel.writeValue(RemoteStream.m14342a(this.f19153p));
            parcel.writeString(this.f19154q);
            parcel.writeValue(RemoteStream.m14342a(this.f19155r));
            parcel.writeValue(RemoteStream.m14342a(this.f19156s));
        }
        if (this.f19158u == 3) {
            parcel.writeValue(RemoteStream.m14342a(this.f19157t));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteCommand)) {
            return false;
        }
        RemoteCommand remoteCommand = (RemoteCommand) obj;
        if (this.f19158u != remoteCommand.f19158u || !m14341a(this.f19145h, remoteCommand.f19145h) || !m14341a(this.f19151n, remoteCommand.f19151n) || !m14341a(this.f19152o, remoteCommand.f19152o) || !m14341a(this.f19153p, remoteCommand.f19153p) || !m14341a(this.f19154q, remoteCommand.f19154q) || !m14341a(this.f19143f, remoteCommand.f19143f)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m14341a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f19158u), this.f19145h, this.f19151n, this.f19152o, this.f19153p, this.f19154q, this.f19143f});
    }

    public String toString() {
        int i = this.f19158u;
        if (i == 0) {
            return "request uri: " + this.f19145h;
        } else if (i == 1) {
            return "request result";
        } else {
            if (i == 2) {
                return "service:" + this.f19151n.getSimpleName() + " methodName:" + this.f19154q;
            } else if (i == 3) {
                return "service_callback";
            } else {
                return super.toString();
            }
        }
    }
}
