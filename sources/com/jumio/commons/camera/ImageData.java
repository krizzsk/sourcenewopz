package com.jumio.commons.camera;

import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0004/012B\t\b\u0016¢\u0006\u0004\b*\u0010+B\u0011\b\u0012\u0012\u0006\u0010,\u001a\u00020\u0007¢\u0006\u0004\b*\u0010-J\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016R$\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R,\u0010&\u001a\u00060%R\u00020\u00002\n\u0010\f\u001a\u00060%R\u00020\u00008\u0006@BX\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u00063"}, mo175978d2 = {"Lcom/jumio/commons/camera/ImageData;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "clear", "", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "Lcom/jumio/commons/camera/Size;", "<set-?>", "imageSize", "Lcom/jumio/commons/camera/Size;", "getImageSize", "()Lcom/jumio/commons/camera/Size;", "", "isFlashMode", "Z", "()Z", "setFlashMode", "(Z)V", "Lcom/jumio/commons/enums/ScreenAngle;", "orientationMode", "Lcom/jumio/commons/enums/ScreenAngle;", "getOrientationMode", "()Lcom/jumio/commons/enums/ScreenAngle;", "setOrientationMode", "(Lcom/jumio/commons/enums/ScreenAngle;)V", "Lcom/jumio/commons/camera/ImageData$CameraPosition;", "cameraPosition", "Lcom/jumio/commons/camera/ImageData$CameraPosition;", "getCameraPosition", "()Lcom/jumio/commons/camera/ImageData$CameraPosition;", "setCameraPosition", "(Lcom/jumio/commons/camera/ImageData$CameraPosition;)V", "Lcom/jumio/commons/camera/ImageData$Image;", "image", "Lcom/jumio/commons/camera/ImageData$Image;", "getImage", "()Lcom/jumio/commons/camera/ImageData$Image;", "<init>", "()V", "in", "(Landroid/os/Parcel;)V", "CREATOR", "a", "CameraPosition", "FileType", "Image", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ImageData.kt */
public final class ImageData implements Parcelable, Serializable {
    public static final C19940a CREATOR = new C19940a((DefaultConstructorMarker) null);
    private CameraPosition cameraPosition;
    private Image image;
    private Size imageSize;
    private boolean isFlashMode;
    private ScreenAngle orientationMode;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/jumio/commons/camera/ImageData$CameraPosition;", "", "<init>", "(Ljava/lang/String;I)V", "FRONT", "BACK", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ImageData.kt */
    public enum CameraPosition {
        FRONT,
        BACK
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/commons/camera/ImageData$FileType;", "", "<init>", "(Ljava/lang/String;I)V", "JPG", "WEBP", "PNG", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ImageData.kt */
    public enum FileType {
        JPG,
        WEBP,
        PNG
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001b\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, mo175978d2 = {"Lcom/jumio/commons/camera/ImageData$Image;", "Ljava/io/Serializable;", "", "clear", "", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "Lcom/jumio/commons/camera/ImageData$FileType;", "type", "Lcom/jumio/commons/camera/ImageData$FileType;", "getType", "()Lcom/jumio/commons/camera/ImageData$FileType;", "setType", "(Lcom/jumio/commons/camera/ImageData$FileType;)V", "Lcom/jumio/commons/camera/Size;", "<set-?>", "size", "Lcom/jumio/commons/camera/Size;", "getSize", "()Lcom/jumio/commons/camera/Size;", "", "getHasPath", "()Z", "hasPath", "<init>", "(Lcom/jumio/commons/camera/ImageData;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ImageData.kt */
    public final class Image implements Serializable {
        private String path = "";
        private Size size = new Size(0, 0);
        public final /* synthetic */ ImageData this$0;
        private FileType type = FileType.WEBP;

        public Image(ImageData imageData) {
            Intrinsics.checkNotNullParameter(imageData, "this$0");
            this.this$0 = imageData;
        }

        public final void clear() {
            try {
                if (getHasPath()) {
                    new File(this.path).delete();
                }
                this.path = "";
                Size size2 = this.size;
                size2.width = 0;
                size2.height = 0;
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        }

        public final boolean getHasPath() {
            return this.path.length() != 0;
        }

        public final String getPath() {
            return this.path;
        }

        public final Size getSize() {
            return this.size;
        }

        public final FileType getType() {
            return this.type;
        }

        public final void setPath(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.path = str;
        }

        public final void setType(FileType fileType) {
            Intrinsics.checkNotNullParameter(fileType, "<set-?>");
            this.type = fileType;
        }
    }

    /* renamed from: com.jumio.commons.camera.ImageData$a */
    /* compiled from: ImageData.kt */
    public static final class C19940a implements Parcelable.Creator<ImageData> {
        public C19940a() {
        }

        public /* synthetic */ C19940a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public ImageData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageData(parcel, (DefaultConstructorMarker) null);
        }

        /* renamed from: a */
        public ImageData[] newArray(int i) {
            return new ImageData[i];
        }
    }

    public ImageData() {
        this.imageSize = new Size(0, 0);
        this.image = new Image(this);
    }

    public /* synthetic */ ImageData(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public final void clear() {
        this.image.clear();
    }

    public int describeContents() {
        return 0;
    }

    public final CameraPosition getCameraPosition() {
        return this.cameraPosition;
    }

    public final Image getImage() {
        return this.image;
    }

    public final Size getImageSize() {
        return this.imageSize;
    }

    public final ScreenAngle getOrientationMode() {
        return this.orientationMode;
    }

    public final boolean isFlashMode() {
        return this.isFlashMode;
    }

    public final void setCameraPosition(CameraPosition cameraPosition2) {
        this.cameraPosition = cameraPosition2;
    }

    public final void setFlashMode(boolean z) {
        this.isFlashMode = z;
    }

    public final void setOrientationMode(ScreenAngle screenAngle) {
        this.orientationMode = screenAngle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(this.imageSize.width);
        parcel.writeInt(this.imageSize.height);
        parcel.writeByte(this.isFlashMode ? (byte) 1 : 0);
        ScreenAngle screenAngle = this.orientationMode;
        String str2 = "";
        if (screenAngle == null) {
            str = str2;
        } else {
            Intrinsics.checkNotNull(screenAngle);
            str = screenAngle.name();
        }
        parcel.writeString(str);
        CameraPosition cameraPosition2 = this.cameraPosition;
        if (cameraPosition2 != null) {
            Intrinsics.checkNotNull(cameraPosition2);
            str2 = cameraPosition2.name();
        }
        parcel.writeString(str2);
        parcel.writeSerializable(this.image);
    }

    private ImageData(Parcel parcel) {
        boolean z = false;
        this.imageSize = new Size(0, 0);
        this.image = new Image(this);
        this.imageSize = new Size(parcel.readInt(), parcel.readInt());
        this.isFlashMode = parcel.readByte() == 1 ? true : z;
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        CameraPosition cameraPosition2 = null;
        this.orientationMode = readString.length() != 0 ? ScreenAngle.valueOf(readString) : null;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        this.cameraPosition = readString2.length() != 0 ? CameraPosition.valueOf(readString2) : cameraPosition2;
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable != null) {
            this.image = (Image) readSerializable;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.jumio.commons.camera.ImageData.Image");
    }
}
