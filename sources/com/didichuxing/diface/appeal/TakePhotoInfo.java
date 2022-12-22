package com.didichuxing.diface.appeal;

import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.io.File;

public class TakePhotoInfo {
    public static final String EXTRA_KEY_PHOTO_TYPE = "photo_type";
    public static final String FILE_DOC_CDR = "cdr.jpg";
    public static final String FILE_DOC_CDT = "cdt.jpg";
    public static final String FILE_DOC_PASSPORT = "passport.jpg";
    public static final String FILE_DOC_RG_BACK = "RG_back.jpg";
    public static final String FILE_DOC_RG_FRONT = "RG_front.jpg";
    public static final String FILE_DRIVER_LICENSE = "driver_license.jpg";
    public static final String FILE_DRIVER_QR = "driver_qr.jpg";
    public static final String FILE_SELF_PHOTO = "face.jpg";
    public static final int TYPE_DOC_CDR = 4;
    public static final int TYPE_DOC_CDT = 5;
    public static final int TYPE_DOC_PASSPORT = 6;
    public static final int TYPE_DOC_RG = 3;
    public static final int TYPE_LICENSE_G1 = 1;
    public static final int TYPE_LICENSE_G2_QR = 2;
    public static final int TYPE_SELF_PHOTO = 7;

    public static String getFileName(int i, int i2) {
        switch (i) {
            case 1:
                return FILE_DRIVER_LICENSE;
            case 2:
                return FILE_DRIVER_QR;
            case 3:
                return i2 == 0 ? FILE_DOC_RG_FRONT : FILE_DOC_RG_BACK;
            case 4:
                return FILE_DOC_CDR;
            case 5:
                return FILE_DOC_CDT;
            case 6:
                return FILE_DOC_PASSPORT;
            case 7:
                return FILE_SELF_PHOTO;
            default:
                return "";
        }
    }

    public static boolean isSpecialRGType(int i) {
        return i == 3;
    }

    public static boolean isValidType(int i) {
        return i >= 1 && i <= 7;
    }

    private TakePhotoInfo() {
    }

    public static void delAllPhotos(File file) {
        String[] strArr = {FILE_DRIVER_QR, FILE_DRIVER_LICENSE, FILE_DOC_RG_FRONT, FILE_DOC_RG_BACK, FILE_DOC_CDR, FILE_DOC_CDT, FILE_DOC_PASSPORT, FILE_SELF_PHOTO};
        for (int i = 0; i < 8; i++) {
            String str = strArr[i];
            boolean delete = new File(file, str).delete();
            LogUtils.m33563d("del " + str + " ok? " + delete);
        }
    }
}
