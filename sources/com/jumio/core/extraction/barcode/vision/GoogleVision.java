package com.jumio.core.extraction.barcode.vision;

public class GoogleVision {

    public enum Status {
        OPERATIONAL,
        NOT_OPERATIONAL,
        DIALOG_PENDING
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0043, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r5 = com.jumio.core.extraction.barcode.vision.GoogleVision.Status.NOT_OPERATIONAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r0 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r0 != null) goto L_0x0049;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.jumio.core.extraction.barcode.vision.GoogleVision.Status isOperational(android.app.Activity r5, int r6) {
        /*
            r0 = 0
            com.jumio.core.network.ErrorMock.onGoogleVisionMock()     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.common.GoogleApiAvailability r1 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ Exception -> 0x0045 }
            int r2 = r1.isGooglePlayServicesAvailable(r5)     // Catch:{ Exception -> 0x0045 }
            r3 = 0
            if (r2 == 0) goto L_0x0025
            boolean r4 = r1.isUserResolvableError(r2)     // Catch:{ Exception -> 0x0045 }
            if (r4 == 0) goto L_0x0022
            android.app.Dialog r5 = r1.getErrorDialog((android.app.Activity) r5, (int) r2, (int) r6)     // Catch:{ Exception -> 0x0045 }
            r5.setCancelable(r3)     // Catch:{ Exception -> 0x0045 }
            com.didi.sdk.apm.SystemUtils.showDialog(r5)     // Catch:{ Exception -> 0x0045 }
            com.jumio.core.extraction.barcode.vision.GoogleVision$Status r5 = com.jumio.core.extraction.barcode.vision.GoogleVision.Status.DIALOG_PENDING     // Catch:{ Exception -> 0x0045 }
            goto L_0x0040
        L_0x0022:
            com.jumio.core.extraction.barcode.vision.GoogleVision$Status r5 = com.jumio.core.extraction.barcode.vision.GoogleVision.Status.NOT_OPERATIONAL     // Catch:{ Exception -> 0x0045 }
            goto L_0x0040
        L_0x0025:
            com.google.mlkit.vision.barcode.BarcodeScannerOptions$Builder r5 = new com.google.mlkit.vision.barcode.BarcodeScannerOptions$Builder     // Catch:{ Exception -> 0x0045 }
            r5.<init>()     // Catch:{ Exception -> 0x0045 }
            r6 = 2048(0x800, float:2.87E-42)
            r1 = 1
            int[] r1 = new int[r1]     // Catch:{ Exception -> 0x0045 }
            r2 = -1
            r1[r3] = r2     // Catch:{ Exception -> 0x0045 }
            com.google.mlkit.vision.barcode.BarcodeScannerOptions$Builder r5 = r5.setBarcodeFormats(r6, r1)     // Catch:{ Exception -> 0x0045 }
            com.google.mlkit.vision.barcode.BarcodeScannerOptions r5 = r5.build()     // Catch:{ Exception -> 0x0045 }
            com.google.mlkit.vision.barcode.BarcodeScanner r0 = com.google.mlkit.vision.barcode.BarcodeScanning.getClient(r5)     // Catch:{ Exception -> 0x0045 }
            com.jumio.core.extraction.barcode.vision.GoogleVision$Status r5 = com.jumio.core.extraction.barcode.vision.GoogleVision.Status.OPERATIONAL     // Catch:{ Exception -> 0x0045 }
        L_0x0040:
            if (r0 == 0) goto L_0x004c
            goto L_0x0049
        L_0x0043:
            r5 = move-exception
            goto L_0x004d
        L_0x0045:
            com.jumio.core.extraction.barcode.vision.GoogleVision$Status r5 = com.jumio.core.extraction.barcode.vision.GoogleVision.Status.NOT_OPERATIONAL     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x004c
        L_0x0049:
            r0.close()
        L_0x004c:
            return r5
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            r0.close()
        L_0x0052:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.barcode.vision.GoogleVision.isOperational(android.app.Activity, int):com.jumio.core.extraction.barcode.vision.GoogleVision$Status");
    }
}
