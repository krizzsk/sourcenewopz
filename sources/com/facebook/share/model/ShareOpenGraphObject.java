package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\b\tB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u0011\b\u0010\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\n"}, mo175978d2 = {"Lcom/facebook/share/model/ShareOpenGraphObject;", "Lcom/facebook/share/model/ShareOpenGraphValueContainer;", "Lcom/facebook/share/model/ShareOpenGraphObject$Builder;", "builder", "(Lcom/facebook/share/model/ShareOpenGraphObject$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "Builder", "Companion", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Deprecated(message = "Effective May 1st 2019, all newly published Open Graph stories will render as a plain link share in newsfeed. This means that Open Graph actions will not appear when posting.")
/* compiled from: ShareOpenGraphObject.kt */
public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new ShareOpenGraphObject$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ ShareOpenGraphObject(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ShareOpenGraphObject(Builder builder) {
        super((ShareOpenGraphValueContainer.Builder) builder);
    }

    public ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/facebook/share/model/ShareOpenGraphObject$Builder;", "Lcom/facebook/share/model/ShareOpenGraphValueContainer$Builder;", "Lcom/facebook/share/model/ShareOpenGraphObject;", "()V", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShareOpenGraphObject.kt */
    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
        }

        public ShareOpenGraphObject build() {
            return new ShareOpenGraphObject(this, (DefaultConstructorMarker) null);
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return (Builder) readFrom((ShareOpenGraphValueContainer) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/facebook/share/model/ShareOpenGraphObject$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareOpenGraphObject;", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShareOpenGraphObject.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
