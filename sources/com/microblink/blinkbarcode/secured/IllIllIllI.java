package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class IllIllIllI {
    private int IlIllIlIIl = -1;
    private CameraType llIIlIlIIl;

    public void IlIllIlIIl() {
        this.llIIlIlIIl = null;
    }

    public int IllIIIllII() {
        return this.IlIllIlIIl;
    }

    public CameraType llIIIlllll() {
        return this.llIIlIlIIl;
    }

    public boolean llIIlIlIIl() {
        return this.IlIllIlIIl == 270;
    }

    public String llIIlIlIIl(CameraManager cameraManager, CameraType cameraType) throws CameraAccessException {
        String str;
        int i;
        Boolean bool;
        int intValue;
        CameraType cameraType2 = cameraType;
        String[] cameraIdList = cameraManager.getCameraIdList();
        Log.m40231i(this, "Available camera count: " + cameraIdList.length, new Object[0]);
        int length = cameraIdList.length;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        String str2 = null;
        String str3 = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        while (i4 < length) {
            String str4 = cameraIdList[i4];
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str4);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                String[] strArr = cameraIdList;
                if (num.intValue() == 0) {
                    if (str3 == null) {
                        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                        if (num2 != null) {
                            int intValue2 = num2.intValue();
                            Log.m40231i(this, "Front facing orientation is {}", Integer.valueOf(intValue2));
                            Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                            bool2 = Boolean.valueOf((f == null || f.floatValue() == 0.0f) ? false : true);
                            i3 = intValue2;
                            i = length;
                        } else {
                            throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                        }
                    } else {
                        if (!bool2.booleanValue()) {
                            i = length;
                            Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                            if ((f2 == null || f2.floatValue() == 0.0f) ? false : true) {
                                Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                                if (num3 != null) {
                                    int intValue3 = num3.intValue();
                                    Log.m40231i(this, "Front facing orientation is {}", Integer.valueOf(intValue3));
                                    bool2 = Boolean.TRUE;
                                    i3 = intValue3;
                                } else {
                                    throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                                }
                            }
                        } else {
                            i = length;
                            Log.m40235w(this, "Handling multiple front cameras with autofocus currently not supported! Will use the first found '{}'", str3);
                        }
                        bool = bool2;
                    }
                    str3 = str4;
                    i4++;
                    length = i;
                    cameraIdList = strArr;
                } else {
                    i = length;
                    bool = bool2;
                    if (num.intValue() == 1) {
                        Log.m40231i(this, "Back face camera found", new Object[0]);
                        if (str2 == null) {
                            Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                            if (num4 != null) {
                                intValue = num4.intValue();
                                Log.m40231i(this, "Back facing orientation is {}", Integer.valueOf(intValue));
                                Float f3 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                                bool3 = Boolean.valueOf((f3 == null || f3.floatValue() == 0.0f) ? false : true);
                            } else {
                                throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                            }
                        } else if (!bool3.booleanValue()) {
                            Float f4 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
                            if ((f4 == null || f4.floatValue() == 0.0f) ? false : true) {
                                Integer num5 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                                if (num5 != null) {
                                    intValue = num5.intValue();
                                    Log.m40231i(this, "Back facing orientation is {}", Integer.valueOf(intValue));
                                    bool3 = Boolean.TRUE;
                                } else {
                                    throw new RuntimeException("Device returned null for sensor orientation of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
                                }
                            }
                        } else {
                            Log.m40235w(this, "Handling multiple back cameras with autofocus currently not supported. Will use the first found '{}'", str2);
                        }
                        i2 = intValue;
                        str2 = str4;
                    }
                }
                bool2 = bool;
                i4++;
                length = i;
                cameraIdList = strArr;
            } else {
                throw new RuntimeException("Device returned null for lens facing of camera '" + str4 + "'. This is a bug in device, as it does not implement Camera API as it is supposed to.");
            }
        }
        if (cameraType2 == CameraType.CAMERA_DEFAULT) {
            if (str2 != null) {
                this.llIIlIlIIl = CameraType.CAMERA_BACKFACE;
                this.IlIllIlIIl = i2;
            } else {
                this.llIIlIlIIl = CameraType.CAMERA_FRONTFACE;
                this.IlIllIlIIl = i3;
                str2 = str3;
            }
            if (str2 == null) {
                this.llIIlIlIIl = null;
                throw new RuntimeException("Device does not have cameras!");
            }
        } else {
            CameraType cameraType3 = CameraType.CAMERA_BACKFACE;
            if (cameraType2 == cameraType3) {
                this.llIIlIlIIl = cameraType3;
                this.IlIllIlIIl = i2;
                if (str2 == null) {
                    this.llIIlIlIIl = null;
                    throw new RuntimeException("Device does not have back facing camera!");
                }
            } else {
                CameraType cameraType4 = CameraType.CAMERA_FRONTFACE;
                if (cameraType2 == cameraType4) {
                    this.llIIlIlIIl = cameraType4;
                    this.IlIllIlIIl = i3;
                    if (str3 != null) {
                        str = str3;
                    } else {
                        this.llIIlIlIIl = null;
                        throw new RuntimeException("Device does not have front facing camera!");
                    }
                } else {
                    str = null;
                }
                Log.m40231i(this, "Selected camera ID is {}", str);
                Log.m40231i(this, "Camera sensor orientation is {}", Integer.valueOf(this.IlIllIlIIl));
                return str;
            }
        }
        str = str2;
        Log.m40231i(this, "Selected camera ID is {}", str);
        Log.m40231i(this, "Camera sensor orientation is {}", Integer.valueOf(this.IlIllIlIIl));
        return str;
    }
}
