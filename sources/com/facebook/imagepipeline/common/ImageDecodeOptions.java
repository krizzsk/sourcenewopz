package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Locale;
import javax.annotation.Nullable;

public class ImageDecodeOptions {
    private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
    public final Bitmap.Config bitmapConfig;
    @Nullable
    public final BitmapTransformation bitmapTransformation;
    @Nullable
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    public final boolean forceStaticImage;
    public final int minDecodeIntervalMs;
    public final boolean transformToSRGB;
    public final boolean useLastFrameForPreview;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.getMinDecodeIntervalMs();
        this.decodePreviewFrame = imageDecodeOptionsBuilder.getDecodePreviewFrame();
        this.useLastFrameForPreview = imageDecodeOptionsBuilder.getUseLastFrameForPreview();
        this.decodeAllFrames = imageDecodeOptionsBuilder.getDecodeAllFrames();
        this.forceStaticImage = imageDecodeOptionsBuilder.getForceStaticImage();
        this.bitmapConfig = imageDecodeOptionsBuilder.getBitmapConfig();
        this.customImageDecoder = imageDecodeOptionsBuilder.getCustomImageDecoder();
        this.transformToSRGB = imageDecodeOptionsBuilder.getTransformToSRGB();
        this.bitmapTransformation = imageDecodeOptionsBuilder.getBitmapTransformation();
    }

    public static ImageDecodeOptions defaults() {
        return DEFAULTS;
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        return new ImageDecodeOptionsBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        return this.decodePreviewFrame == imageDecodeOptions.decodePreviewFrame && this.useLastFrameForPreview == imageDecodeOptions.useLastFrameForPreview && this.decodeAllFrames == imageDecodeOptions.decodeAllFrames && this.forceStaticImage == imageDecodeOptions.forceStaticImage && this.transformToSRGB == imageDecodeOptions.transformToSRGB && this.bitmapConfig == imageDecodeOptions.bitmapConfig && this.customImageDecoder == imageDecodeOptions.customImageDecoder && this.bitmapTransformation == imageDecodeOptions.bitmapTransformation;
    }

    public int hashCode() {
        int ordinal = ((((((((((((this.minDecodeIntervalMs * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0)) * 31) + (this.transformToSRGB ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31;
        ImageDecoder imageDecoder = this.customImageDecoder;
        int i = 0;
        int hashCode = (ordinal + (imageDecoder != null ? imageDecoder.hashCode() : 0)) * 31;
        BitmapTransformation bitmapTransformation2 = this.bitmapTransformation;
        if (bitmapTransformation2 != null) {
            i = bitmapTransformation2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return String.format((Locale) null, "%d-%b-%b-%b-%b-%b-%s-%s-%s", new Object[]{Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), Boolean.valueOf(this.transformToSRGB), this.bitmapConfig.name(), this.customImageDecoder, this.bitmapTransformation});
    }
}
