package com.didi.soda.customer.p165h5.hybird.tool;

/* renamed from: com.didi.soda.customer.h5.hybird.tool.WebPermissionUtil */
public class WebPermissionUtil {
    public static final String CAMERA = "Camera";
    public static final String CONTACT = "Contact";
    public static final String LOCATION = "Location";
    public static final int PERMISSION_DENIED = 2;
    public static final int PERMISSION_GRANTED = 1;
    public static final int PERMISSION_UNKNOWN = 0;

    public static int permissionGrantedConvert(int i) {
        return i == 0 ? 1 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String permissionConvert(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1678787584(0xffffffff9befbc00, float:-3.9660725E-22)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1965687765(0x752a03d5, float:2.1551958E32)
            if (r0 == r1) goto L_0x0020
            r1 = 2011082565(0x77deaf45, float:9.0331624E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "Camera"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "Location"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "Contact"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            java.lang.String r4 = ""
            return r4
        L_0x003e:
            java.lang.String r4 = "android.permission.READ_CONTACTS"
            return r4
        L_0x0041:
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            return r4
        L_0x0044:
            java.lang.String r4 = "android.permission.CAMERA"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.p165h5.hybird.tool.WebPermissionUtil.permissionConvert(java.lang.String):java.lang.String");
    }
}
