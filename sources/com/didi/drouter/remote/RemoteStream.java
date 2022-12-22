package com.didi.drouter.remote;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.remote.IClientService;
import com.didi.drouter.utils.JsonConverter;
import com.didi.drouter.utils.ReflectUtil;
import com.didi.drouter.utils.RouterLogger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

class RemoteStream {
    RemoteStream() {
    }

    /* renamed from: a */
    static Object m14342a(Object obj) {
        if (m14346c(obj)) {
            return obj;
        }
        if (obj.getClass().isArray()) {
            return new ArrayParcelable(obj);
        }
        if (obj instanceof Map) {
            return new MapParcelable(obj);
        }
        if (obj instanceof Collection) {
            return new CollectionParcelable(obj);
        }
        if (obj instanceof IRemoteCallback) {
            return new CallbackParcelable(obj);
        }
        return new ObjectParcelable(obj);
    }

    /* renamed from: b */
    static Object m14344b(Object obj) {
        if (obj instanceof ArrayParcelable) {
            return ((ArrayParcelable) obj).getArray();
        }
        if (obj instanceof MapParcelable) {
            return ((MapParcelable) obj).getMap();
        }
        if (obj instanceof CollectionParcelable) {
            return ((CollectionParcelable) obj).getCollection();
        }
        if (obj instanceof ObjectParcelable) {
            return ((ObjectParcelable) obj).getObject();
        }
        return obj instanceof CallbackParcelable ? ((CallbackParcelable) obj).getObject() : obj;
    }

    /* renamed from: c */
    private static boolean m14346c(Object obj) {
        return obj == null || (obj instanceof Boolean) || (obj instanceof boolean[]) || (obj instanceof Byte) || (obj instanceof byte[]) || (obj instanceof Character) || (obj instanceof char[]) || (obj instanceof Short) || (obj instanceof short[]) || (obj instanceof Integer) || (obj instanceof int[]) || (obj instanceof Long) || (obj instanceof long[]) || (obj instanceof Float) || (obj instanceof float[]) || (obj instanceof Double) || (obj instanceof double[]) || (obj instanceof CharSequence) || (obj instanceof CharSequence[]) || (obj instanceof Parcelable) || (obj instanceof Parcelable[]) || (obj instanceof Class) || (obj instanceof IBinder);
    }

    static class ArrayParcelable implements Parcelable {
        public static final Parcelable.Creator<ArrayParcelable> CREATOR = new Parcelable.Creator<ArrayParcelable>() {
            public ArrayParcelable createFromParcel(Parcel parcel) {
                return new ArrayParcelable(parcel);
            }

            public ArrayParcelable[] newArray(int i) {
                return new ArrayParcelable[i];
            }
        };
        Object[] array;

        public int describeContents() {
            return 0;
        }

        ArrayParcelable(Object obj) {
            this.array = (Object[]) obj;
        }

        ArrayParcelable(Parcel parcel) {
            Object[] readArray = parcel.readArray(ArrayParcelable.class.getClassLoader());
            this.array = (Object[]) Array.newInstance((Class) parcel.readSerializable(), readArray.length);
            for (int i = 0; i < readArray.length; i++) {
                this.array[i] = RemoteStream.m14344b(readArray[i]);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            Object[] objArr = new Object[this.array.length];
            int i2 = 0;
            while (true) {
                Object[] objArr2 = this.array;
                if (i2 < objArr2.length) {
                    objArr[i2] = RemoteStream.m14342a(objArr2[i2]);
                    i2++;
                } else {
                    RemoteStream.m14345b(parcel, objArr2.getClass().getComponentType());
                    parcel.writeArray(objArr);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Object[] getArray() {
            return this.array;
        }
    }

    static class MapParcelable implements Parcelable {
        public static final Parcelable.Creator<MapParcelable> CREATOR = new Parcelable.Creator<MapParcelable>() {
            public MapParcelable createFromParcel(Parcel parcel) {
                return new MapParcelable(parcel);
            }

            public MapParcelable[] newArray(int i) {
                return new MapParcelable[i];
            }
        };
        Map<Object, Object> map;

        public int describeContents() {
            return 0;
        }

        MapParcelable(Object obj) {
            this.map = (Map) obj;
        }

        MapParcelable(Parcel parcel) {
            this.map = (Map) ReflectUtil.getInstance((Class<?>) (Class) parcel.readSerializable(), new Object[0]);
            for (Map.Entry entry : parcel.readHashMap(MapParcelable.class.getClassLoader()).entrySet()) {
                this.map.put(RemoteStream.m14344b(entry.getKey()), RemoteStream.m14344b(entry.getValue()));
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            Class<?> cls = this.map.getClass();
            HashMap hashMap = new HashMap();
            for (Map.Entry next : this.map.entrySet()) {
                hashMap.put(RemoteStream.m14342a(next.getKey()), RemoteStream.m14342a(next.getValue()));
            }
            RemoteStream.m14345b(parcel, cls);
            parcel.writeMap(hashMap);
        }

        /* access modifiers changed from: package-private */
        public Map<Object, Object> getMap() {
            return this.map;
        }
    }

    static class CollectionParcelable implements Parcelable {
        public static final Parcelable.Creator<CollectionParcelable> CREATOR = new Parcelable.Creator<CollectionParcelable>() {
            public CollectionParcelable createFromParcel(Parcel parcel) {
                return new CollectionParcelable(parcel);
            }

            public CollectionParcelable[] newArray(int i) {
                return new CollectionParcelable[i];
            }
        };
        Collection<Object> collection;

        public int describeContents() {
            return 0;
        }

        CollectionParcelable(Object obj) {
            this.collection = (Collection) obj;
        }

        CollectionParcelable(Parcel parcel) {
            this.collection = (Collection) ReflectUtil.getInstance((Class<?>) (Class) parcel.readSerializable(), new Object[0]);
            for (Object b : parcel.readArrayList(CollectionParcelable.class.getClassLoader())) {
                this.collection.add(RemoteStream.m14344b(b));
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            Class<?> cls = this.collection.getClass();
            ArrayList arrayList = new ArrayList();
            for (Object a : this.collection) {
                arrayList.add(RemoteStream.m14342a(a));
            }
            RemoteStream.m14345b(parcel, cls);
            parcel.writeList(arrayList);
        }

        /* access modifiers changed from: package-private */
        public Collection<Object> getCollection() {
            return this.collection;
        }
    }

    static class ObjectParcelable implements Parcelable {
        public static final Parcelable.Creator<ObjectParcelable> CREATOR = new Parcelable.Creator<ObjectParcelable>() {
            public ObjectParcelable createFromParcel(Parcel parcel) {
                return new ObjectParcelable(parcel);
            }

            public ObjectParcelable[] newArray(int i) {
                return new ObjectParcelable[i];
            }
        };
        Object object;

        public int describeContents() {
            return 0;
        }

        ObjectParcelable(Object obj) {
            this.object = obj;
        }

        ObjectParcelable(Parcel parcel) {
            if (parcel.readInt() == 0) {
                this.object = DRouter.getContext();
                return;
            }
            this.object = JsonConverter.toObject(parcel.readString(), (Class) parcel.readSerializable());
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (this.object instanceof Context) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            RemoteStream.m14345b(parcel, this.object.getClass());
            parcel.writeString(JsonConverter.toString(this.object));
        }

        /* access modifiers changed from: package-private */
        public Object getObject() {
            return this.object;
        }
    }

    static class CallbackParcelable implements Parcelable {
        public static final Parcelable.Creator<CallbackParcelable> CREATOR = new Parcelable.Creator<CallbackParcelable>() {
            public CallbackParcelable createFromParcel(Parcel parcel) {
                return new CallbackParcelable(parcel);
            }

            public CallbackParcelable[] newArray(int i) {
                return new CallbackParcelable[i];
            }
        };
        static Map<IRemoteCallback, IClientService> callbackPool = Collections.synchronizedMap(new WeakHashMap());
        IBinder binder;

        public int describeContents() {
            return 0;
        }

        CallbackParcelable(Object obj) {
            final IRemoteCallback iRemoteCallback = (IRemoteCallback) obj;
            IClientService iClientService = callbackPool.get(iRemoteCallback);
            if (iClientService == null) {
                iClientService = new IClientService.Stub() {
                    public RemoteResult callback(RemoteCommand remoteCommand) throws RemoteException {
                        RouterLogger.getCoreLogger().mo59000d("[Client] receive callback success and start invoke", new Object[0]);
                        iRemoteCallback.callback(remoteCommand.f19157t);
                        return null;
                    }
                };
                callbackPool.put(iRemoteCallback, iClientService);
            }
            this.binder = iClientService.asBinder();
        }

        CallbackParcelable(Parcel parcel) {
            this.binder = parcel.readStrongBinder();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStrongBinder(this.binder);
        }

        /* access modifiers changed from: package-private */
        public Object getObject() {
            for (Map.Entry next : callbackPool.entrySet()) {
                if (((IClientService) next.getValue()).asBinder() == this.binder) {
                    return next.getKey();
                }
            }
            final IClientService asInterface = IClientService.Stub.asInterface(this.binder);
            C79302 r1 = new IRemoteCallback() {
                public void callback(Object... objArr) throws RemoteException {
                    if (objArr == null) {
                        objArr = new Object[]{null};
                    }
                    RouterLogger.getCoreLogger().mo59002w("[Service] command start callback", new Object[0]);
                    RemoteCommand remoteCommand = new RemoteCommand(3);
                    remoteCommand.f19157t = objArr;
                    try {
                        asInterface.callback(remoteCommand);
                    } catch (RemoteException e) {
                        RouterLogger.getCoreLogger().mo59001e("[Service] command callback Exception %s", e);
                        throw e;
                    }
                }
            };
            callbackPool.put(r1, asInterface);
            return r1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14345b(Parcel parcel, Class<?> cls) {
        if ((!cls.isLocalClass() && !cls.isMemberClass() && !cls.isAnonymousClass()) || (cls.getModifiers() & 8) != 0) {
            parcel.writeSerializable(cls);
            return;
        }
        throw new IllegalArgumentException(String.format("non static inner class \"%s\" can not be serialized", new Object[]{cls.getName()}));
    }
}
