package com.didi.beatles.p099im.picture.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.config.IMPictureSelectionConfig */
public final class IMPictureSelectionConfig implements Parcelable {
    public static final Parcelable.Creator<IMPictureSelectionConfig> CREATOR = new Parcelable.Creator<IMPictureSelectionConfig>() {
        public IMPictureSelectionConfig createFromParcel(Parcel parcel) {
            return new IMPictureSelectionConfig(parcel);
        }

        public IMPictureSelectionConfig[] newArray(int i) {
            return new IMPictureSelectionConfig[i];
        }
    };
    public int aspect_ratio_x;
    public int aspect_ratio_y;
    public boolean camera;
    public boolean circleDimmedLayer;
    public String compressSavePath;
    public int cropCompressQuality;
    public int cropHeight;
    public int cropWidth;
    public boolean enPreviewVideo;
    @Deprecated
    public boolean enableCrop;
    public boolean enablePreview;
    public boolean enablePreviewAudio;
    public boolean enableSelectOverlay;
    public boolean freeStyleCropEnabled;
    public boolean hideBottomControls;
    public int imageSpanCount;
    public boolean isCompress;
    public boolean isDragFrame;
    public boolean isGif;
    public int maxImageSize;
    public int maxSelectNum;
    public int mimeType;
    public int minSelectNum;
    public int minimumCompressSize;
    public String outputCameraPath;
    public int overrideHeight;
    public int overrideWidth;
    public boolean previewEggs;
    public int recordVideoSecond;
    public boolean rotateEnabled;
    public boolean scaleEnabled;
    public List<IMLocalMedia> selectionMedias;
    public int selectionMode;
    public boolean showCameraInGallery;
    public boolean showCropFrame;
    public boolean showCropGrid;
    public float sizeMultiplier;
    public String suffixType;
    public boolean synOrAsy;
    public int videoMaxSecond;
    public int videoMinSecond;
    public int videoQuality;
    public boolean zoomAnim;

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    private void m6379a() {
        this.mimeType = 1;
        this.camera = false;
        this.maxImageSize = 200;
        this.selectionMode = 2;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.videoQuality = 1;
        this.cropCompressQuality = 90;
        this.videoMaxSecond = 0;
        this.videoMinSecond = 0;
        this.recordVideoSecond = 60;
        this.minimumCompressSize = 100;
        this.imageSpanCount = 4;
        this.overrideWidth = 0;
        this.overrideHeight = 0;
        this.isCompress = false;
        this.aspect_ratio_x = 0;
        this.aspect_ratio_y = 0;
        this.cropWidth = 0;
        this.cropHeight = 0;
        this.showCameraInGallery = true;
        this.isGif = false;
        this.enablePreview = true;
        this.enPreviewVideo = true;
        this.enablePreviewAudio = true;
        this.enableSelectOverlay = false;
        this.enableCrop = false;
        this.freeStyleCropEnabled = false;
        this.circleDimmedLayer = false;
        this.showCropFrame = true;
        this.showCropGrid = true;
        this.hideBottomControls = true;
        this.rotateEnabled = true;
        this.scaleEnabled = true;
        this.previewEggs = false;
        this.synOrAsy = true;
        this.zoomAnim = true;
        this.isDragFrame = true;
        this.outputCameraPath = "";
        this.compressSavePath = "";
        this.suffixType = ".JPEG";
        this.sizeMultiplier = 0.5f;
        this.selectionMedias = new ArrayList();
    }

    public static IMPictureSelectionConfig getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static IMPictureSelectionConfig getCleanInstance() {
        IMPictureSelectionConfig instance = getInstance();
        instance.m6379a();
        return instance;
    }

    /* renamed from: com.didi.beatles.im.picture.config.IMPictureSelectionConfig$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IMPictureSelectionConfig INSTANCE = new IMPictureSelectionConfig();

        private InstanceHolder() {
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mimeType);
        parcel.writeByte(this.camera ? (byte) 1 : 0);
        parcel.writeString(this.outputCameraPath);
        parcel.writeString(this.compressSavePath);
        parcel.writeString(this.suffixType);
        parcel.writeInt(this.maxImageSize);
        parcel.writeInt(this.selectionMode);
        parcel.writeInt(this.maxSelectNum);
        parcel.writeInt(this.minSelectNum);
        parcel.writeInt(this.videoQuality);
        parcel.writeInt(this.cropCompressQuality);
        parcel.writeInt(this.videoMaxSecond);
        parcel.writeInt(this.videoMinSecond);
        parcel.writeInt(this.recordVideoSecond);
        parcel.writeInt(this.minimumCompressSize);
        parcel.writeInt(this.imageSpanCount);
        parcel.writeInt(this.overrideWidth);
        parcel.writeInt(this.overrideHeight);
        parcel.writeInt(this.aspect_ratio_x);
        parcel.writeInt(this.aspect_ratio_y);
        parcel.writeFloat(this.sizeMultiplier);
        parcel.writeInt(this.cropWidth);
        parcel.writeInt(this.cropHeight);
        parcel.writeByte(this.zoomAnim ? (byte) 1 : 0);
        parcel.writeByte(this.isCompress ? (byte) 1 : 0);
        parcel.writeByte(this.showCameraInGallery ? (byte) 1 : 0);
        parcel.writeByte(this.isGif ? (byte) 1 : 0);
        parcel.writeByte(this.enablePreview ? (byte) 1 : 0);
        parcel.writeByte(this.enPreviewVideo ? (byte) 1 : 0);
        parcel.writeByte(this.enablePreviewAudio ? (byte) 1 : 0);
        parcel.writeByte(this.enableSelectOverlay ? (byte) 1 : 0);
        parcel.writeByte(this.enableCrop ? (byte) 1 : 0);
        parcel.writeByte(this.freeStyleCropEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.circleDimmedLayer ? (byte) 1 : 0);
        parcel.writeByte(this.showCropFrame ? (byte) 1 : 0);
        parcel.writeByte(this.showCropGrid ? (byte) 1 : 0);
        parcel.writeByte(this.hideBottomControls ? (byte) 1 : 0);
        parcel.writeByte(this.rotateEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.scaleEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.previewEggs ? (byte) 1 : 0);
        parcel.writeByte(this.synOrAsy ? (byte) 1 : 0);
        parcel.writeByte(this.isDragFrame ? (byte) 1 : 0);
        parcel.writeTypedList(this.selectionMedias);
    }

    public IMPictureSelectionConfig() {
    }

    protected IMPictureSelectionConfig(Parcel parcel) {
        this.mimeType = parcel.readInt();
        boolean z = true;
        this.camera = parcel.readByte() != 0;
        this.outputCameraPath = parcel.readString();
        this.compressSavePath = parcel.readString();
        this.suffixType = parcel.readString();
        this.maxImageSize = parcel.readInt();
        this.selectionMode = parcel.readInt();
        this.maxSelectNum = parcel.readInt();
        this.minSelectNum = parcel.readInt();
        this.videoQuality = parcel.readInt();
        this.cropCompressQuality = parcel.readInt();
        this.videoMaxSecond = parcel.readInt();
        this.videoMinSecond = parcel.readInt();
        this.recordVideoSecond = parcel.readInt();
        this.minimumCompressSize = parcel.readInt();
        this.imageSpanCount = parcel.readInt();
        this.overrideWidth = parcel.readInt();
        this.overrideHeight = parcel.readInt();
        this.aspect_ratio_x = parcel.readInt();
        this.aspect_ratio_y = parcel.readInt();
        this.sizeMultiplier = parcel.readFloat();
        this.cropWidth = parcel.readInt();
        this.cropHeight = parcel.readInt();
        this.zoomAnim = parcel.readByte() != 0;
        this.isCompress = parcel.readByte() != 0;
        this.showCameraInGallery = parcel.readByte() != 0;
        this.isGif = parcel.readByte() != 0;
        this.enablePreview = parcel.readByte() != 0;
        this.enPreviewVideo = parcel.readByte() != 0;
        this.enablePreviewAudio = parcel.readByte() != 0;
        this.enableSelectOverlay = parcel.readByte() != 0;
        this.enableCrop = parcel.readByte() != 0;
        this.freeStyleCropEnabled = parcel.readByte() != 0;
        this.circleDimmedLayer = parcel.readByte() != 0;
        this.showCropFrame = parcel.readByte() != 0;
        this.showCropGrid = parcel.readByte() != 0;
        this.hideBottomControls = parcel.readByte() != 0;
        this.rotateEnabled = parcel.readByte() != 0;
        this.scaleEnabled = parcel.readByte() != 0;
        this.previewEggs = parcel.readByte() != 0;
        this.synOrAsy = parcel.readByte() != 0;
        this.isDragFrame = parcel.readByte() == 0 ? false : z;
        this.selectionMedias = parcel.createTypedArrayList(IMLocalMedia.CREATOR);
    }
}
