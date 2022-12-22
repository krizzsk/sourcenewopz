package global.didi.pay.merchantcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DModelObject;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "Creator", "Serializer", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DModelObject.kt */
public abstract class DModelObject implements Parcelable {

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "T", "Lglobal/didi/pay/merchantcore/model/DModelObject;", "", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lglobal/didi/pay/merchantcore/model/DModelObject;", "serialize", "modelObject", "(Lglobal/didi/pay/merchantcore/model/DModelObject;)Lorg/json/JSONObject;", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DModelObject.kt */
    public interface Serializer<T extends DModelObject> {
        T deserialize(JSONObject jSONObject);

        JSONObject serialize(T t);
    }

    public int describeContents() {
        return 0;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DModelObject$Creator;", "T", "Lglobal/didi/pay/merchantcore/model/DModelObject;", "Landroid/os/Parcelable$Creator;", "mClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "createFromParcel", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Lglobal/didi/pay/merchantcore/model/DModelObject;", "newArray", "", "size", "", "(I)[Lglobal/didi/pay/merchantcore/model/DModelObject;", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DModelObject.kt */
    public static final class Creator<T extends DModelObject> implements Parcelable.Creator<T> {
        private final Class<T> mClass;

        public Creator(Class<T> cls) {
            Intrinsics.checkParameterIsNotNull(cls, "mClass");
            this.mClass = cls;
        }

        public T createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "source");
            try {
                JSONObject readFromParcel = JsonUtils.readFromParcel(parcel);
                if (readFromParcel != null) {
                    return ModelUtils.Companion.deserializeModel(readFromParcel, this.mClass);
                }
                throw new RuntimeException("Failed to create ModelObject from parcel. JSONObject is null.");
            } catch (JSONException e) {
                throw new RuntimeException("Failed to create ModelObject from parcel.", e);
            }
        }

        public T[] newArray(int i) {
            Object newInstance = Array.newInstance(this.mClass, i);
            if (newInstance != null) {
                return (DModelObject[]) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }
}
