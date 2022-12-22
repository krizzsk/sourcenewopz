package com.microblink.blinkbarcode.secured;

import android.graphics.Point;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Display;
import android.view.WindowManager;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl;
import com.microblink.blinkbarcode.hardware.camera.VideoResolutionPreset;
import com.microblink.blinkbarcode.hardware.camera.llIIIlllll;
import com.microblink.blinkbarcode.secured.IlIIIIIlll;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
class lIlIIIlIll {
    private IllIIIllII IlIllIlIIl;
    private int IllIIIIllI;
    private Size IllIIIllII;
    private Size llIIIlllll;
    private CameraCharacteristics llIIlIlIIl;

    public lIlIIIlIll(IllIIIllII illIIIllII) {
        this.IlIllIlIIl = illIIIllII;
    }

    public Size IlIllIlIIl() {
        return this.llIIIlllll;
    }

    public Size IllIIIllII() {
        return this.IllIIIllII;
    }

    public llIIIlllll llIIIlllll() {
        Size size = this.IllIIIllII;
        if (size == null) {
            return null;
        }
        return new llIIIlllll(size.getWidth(), this.IllIIIllII.getHeight());
    }

    public void llIIlIlIIl(CameraCharacteristics cameraCharacteristics, IlIllIlIIl ilIllIlIIl) {
        boolean z;
        Size size;
        this.llIIlIlIIl = cameraCharacteristics;
        VideoResolutionPreset IIlIIIllIl = ilIllIlIIl.IIlIIIllIl();
        int IllIIIIllI2 = ilIllIlIIl.IllIIIIllI();
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.llIIlIlIIl.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            int[] outputFormats = streamConfigurationMap.getOutputFormats();
            int length = outputFormats.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (outputFormats[i] == 35) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (IIlIIIllIl == VideoResolutionPreset.VIDEO_RESOLUTION_MAX_AVAILABLE) {
                    size = llIIlIlIIl(35);
                } else {
                    Size size2 = outputSizes[0];
                    Integer num = (Integer) this.llIIlIlIIl.get(CameraCharacteristics.LENS_FACING);
                    IlIIIIIlll.llIIlIlIIl lliililiil = null;
                    if (num != null && num.intValue() == 1) {
                        lliililiil = this.IlIllIlIIl.lllIlIlIIl();
                    } else if (num != null && num.intValue() == 0) {
                        lliililiil = this.IlIllIlIIl.IllIIlIIII();
                    }
                    VideoResolutionPreset videoResolutionPreset = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
                    if (IIlIIIllIl != videoResolutionPreset || lliililiil == null) {
                        Display defaultDisplay = ((WindowManager) this.IlIllIlIIl.llIIIlllll().getSystemService("window")).getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getSize(point);
                        int max = Math.max(point.x, point.y);
                        int min = Math.min(point.x, point.y);
                        double d = IIlIIIllIl == videoResolutionPreset ? ((double) max) / ((double) min) : 1.7777777777777777d;
                        Log.m40231i(this, "Expected camera frame aspect ratio is {}", Double.valueOf(d));
                        int idealHeight = IIlIIIllIl.getIdealHeight();
                        long round = Math.round(((double) idealHeight) * d);
                        Log.m40231i(this, "Attempting to choose resolution most similar to {}x{} (screen is {}x{})", Long.valueOf(round), Integer.valueOf(idealHeight), Integer.valueOf(max), Integer.valueOf(min));
                        long j = round * ((long) idealHeight);
                        double llIIlIlIIl2 = llIIlIlIIl(size2, d, j, IllIIIIllI2);
                        int i2 = 1;
                        while (i2 < outputSizes.length) {
                            Log.m40227d(this, "Available preview size is {}", outputSizes[i2]);
                            int i3 = i2;
                            double llIIlIlIIl3 = llIIlIlIIl(outputSizes[i2], d, j, IllIIIIllI2);
                            Log.m40233v(this, "Compatibility for size {} is {}", outputSizes[i3], Double.valueOf(llIIlIlIIl3));
                            if (llIIlIlIIl3 < llIIlIlIIl2) {
                                size2 = outputSizes[i3];
                                llIIlIlIIl2 = llIIlIlIIl3;
                            }
                            i2 = i3 + 1;
                        }
                        size = size2;
                    } else {
                        size = new Size(lliililiil.IlIllIlIIl(), lliililiil.llIIlIlIIl());
                        Log.m40231i(this, "This device will use special preview size because normal default appears to be buggy", size);
                    }
                }
                Log.m40231i(this, "For preset {}, selected preview size is {}", IIlIIIllIl, size);
                Log.m40231i(this, "Output stall duration is {}", Long.valueOf(streamConfigurationMap.getOutputStallDuration(35, size)));
                Log.m40231i(this, "Output min frame duration is {}", Long.valueOf(streamConfigurationMap.getOutputMinFrameDuration(35, size)));
                this.IllIIIllII = size;
                Size llIIlIlIIl4 = llIIlIlIIl(35);
                Size llIIlIlIIl5 = llIIlIlIIl(256);
                if (llIIlIlIIl4.getWidth() * llIIlIlIIl4.getHeight() >= llIIlIlIIl5.getWidth() * llIIlIlIIl5.getHeight()) {
                    this.IllIIIIllI = 35;
                } else {
                    this.IllIIIIllI = 256;
                    llIIlIlIIl4 = llIIlIlIIl5;
                }
                this.llIIIlllll = llIIlIlIIl4;
                return;
            }
            throw new RuntimeException("Expected preview format not supported!");
        }
        throw new RuntimeException("Unable to obtain scaler stream configuration map. This is a bug in device!");
    }

    public int llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    private Size llIIlIlIIl(int i) {
        int i2;
        boolean z;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.llIIlIlIIl.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            int[] outputFormats = streamConfigurationMap.getOutputFormats();
            int length = outputFormats.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                } else if (outputFormats[i3] == i) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(i);
                Size size = outputSizes[0];
                int height = size.getHeight() * size.getWidth();
                for (i2 = 1; i2 < outputSizes.length; i2++) {
                    int width = outputSizes[i2].getWidth() * outputSizes[i2].getHeight();
                    if (width > height) {
                        size = outputSizes[i2];
                        height = width;
                    }
                }
                return size;
            }
            throw new RuntimeException("Expected preview format not supported!");
        }
        throw new RuntimeException("Unable to obtain scaler stream configuration map. This is a bug in device!");
    }

    private double llIIlIlIIl(Size size, double d, long j, int i) {
        if (size.getHeight() * size.getWidth() > i) {
            return (Math.abs(((((double) size.getWidth()) * ((double) size.getHeight())) / ((double) j)) - 1.0d) * 1200.0d) + (Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - d) * 1100.0d);
        }
        return Double.POSITIVE_INFINITY;
    }
}
