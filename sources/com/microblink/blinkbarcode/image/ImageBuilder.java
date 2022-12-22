package com.microblink.blinkbarcode.image;

import android.graphics.ImageFormat;
import android.media.Image;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import java.nio.ByteBuffer;

/* compiled from: line */
public class ImageBuilder {
    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    public static Image buildImageFromCamera1NV21Frame(byte[] bArr, int i, int i2, Orientation orientation, Rectangle rectangle) {
        int bitsPerPixel = ((i * i2) * ImageFormat.getBitsPerPixel(17)) / 8;
        if (bArr.length != bitsPerPixel) {
            throw new IllegalArgumentException("Wrong size of imageBuffer! For image size " + i + "x" + i2 + ", the expected buffer size is " + Integer.toString(bitsPerPixel));
        } else if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
        } else {
            if (rectangle == null) {
                rectangle = Rectangle.getDefaultROI();
            }
            if (rectangle.isRelative()) {
                long buildNativeImageFromCamera1Buffer = buildNativeImageFromCamera1Buffer(i, i2, bArr, orientation.intValue(), rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
                if (buildNativeImageFromCamera1Buffer != 0) {
                    return buildImageFromNativeContext(buildNativeImageFromCamera1Buffer, true, bArr);
                }
                throw new RuntimeException("Failed to create native image. Please check log for details.");
            }
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
    }

    public static Image buildImageFromCamera2Image(Image image, Orientation orientation, Rectangle rectangle) {
        Orientation orientation2 = orientation;
        if (image.getFormat() != 35) {
            throw new IllegalArgumentException("Camera2 image must be in YUV_420_888 format. Other formats are not supported!");
        } else if (orientation2 == null || orientation2 == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
        } else {
            Rectangle defaultROI = rectangle == null ? Rectangle.getDefaultROI() : rectangle;
            if (defaultROI.isRelative()) {
                long buildNativeImageFromCamera2Image = buildNativeImageFromCamera2Image(image.getWidth(), image.getHeight(), orientation.intValue(), defaultROI.getX(), defaultROI.getY(), defaultROI.getWidth(), defaultROI.getHeight(), image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), image.getPlanes()[0].getPixelStride(), image.getPlanes()[1].getBuffer(), image.getPlanes()[1].getRowStride(), image.getPlanes()[1].getPixelStride(), image.getPlanes()[2].getBuffer(), image.getPlanes()[2].getRowStride(), image.getPlanes()[2].getPixelStride());
                if (buildNativeImageFromCamera2Image != 0) {
                    return buildImageFromNativeContext(buildNativeImageFromCamera2Image, true, image);
                }
                throw new RuntimeException("Failed to create native image. Please check log for details.");
            }
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
    }

    public static Image buildImageFromJpegBytes(byte[] bArr, int i) {
        if (bArr != null) {
            long buildNativeImageFromJpegBytes = buildNativeImageFromJpegBytes(bArr, bArr.length, i);
            if (buildNativeImageFromJpegBytes != 0) {
                return buildImageFromNativeContext(buildNativeImageFromJpegBytes, true, bArr);
            }
            throw new RuntimeException("Failed to create native image. Please check log for details.");
        }
        throw new RuntimeException("Failed to create native image. Jpeg bytes null.");
    }

    public static Image buildImageFromNativeContext(long j, boolean z, Object obj) {
        Image image = new Image(j, z);
        image.lllIlIlIIl = obj;
        return image;
    }

    private static native long buildNativeImageFromCamera1Buffer(int i, int i2, byte[] bArr, int i3, float f, float f2, float f3, float f4);

    private static native long buildNativeImageFromCamera2Image(int i, int i2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    private static native long buildNativeImageFromJpegBytes(byte[] bArr, int i, int i2);
}
