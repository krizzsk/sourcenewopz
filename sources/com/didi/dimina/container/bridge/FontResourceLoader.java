package com.didi.dimina.container.bridge;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.util.TextUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FontResourceLoader {
    public static final String FONT_DIR = (DMSandboxHelper.DIMINA + File.separator + "font");

    public static InputStream readFontFile(Context context, String str) {
        try {
            return new FileInputStream(context.getFilesDir() + File.separator + FONT_DIR + File.separator + str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void load(Context context) {
        try {
            AssetManager assets = context.getAssets();
            String[] list = assets.list(FONT_DIR);
            if (list != null) {
                for (String r4 : list) {
                    DMThreadPool.getExecutor().execute(new Runnable(assets, r4, context) {
                        public final /* synthetic */ AssetManager f$0;
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ Context f$2;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            FontResourceLoader.m12188a(this.f$0, this.f$1, this.f$2);
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m12188a(AssetManager assetManager, String str, Context context) {
        InputStream inputStream;
        try {
            inputStream = assetManager.open(FONT_DIR + File.separator + str);
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        m12187a(context, inputStream, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006a A[SYNTHETIC, Splitter:B:38:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006f A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0074 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007a A[SYNTHETIC, Splitter:B:45:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0082 A[Catch:{ IOException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0087 A[Catch:{ IOException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m12187a(android.content.Context r2, java.io.InputStream r3, java.lang.String r4) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.io.File r0 = new java.io.File
            java.io.File r2 = r2.getFilesDir()
            java.lang.String r1 = FONT_DIR
            r0.<init>(r2, r1)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0017
            r0.mkdirs()
        L_0x0017:
            java.io.File r2 = new java.io.File
            r2.<init>(r0, r4)
            boolean r4 = r2.exists()
            if (r4 == 0) goto L_0x0025
            r2.delete()
        L_0x0025:
            r4 = 0
            boolean r0 = r2.createNewFile()     // Catch:{ IOException -> 0x0064 }
            if (r0 == 0) goto L_0x004b
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0064 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0064 }
            int r2 = r3.available()     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
        L_0x0037:
            int r4 = r3.read(r2)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r1 = -1
            if (r4 == r1) goto L_0x0043
            r1 = 0
            r0.write(r2, r1, r4)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            goto L_0x0037
        L_0x0043:
            r4 = r0
            goto L_0x004b
        L_0x0045:
            r2 = move-exception
            r4 = r0
            goto L_0x0078
        L_0x0048:
            r2 = move-exception
            r4 = r0
            goto L_0x0065
        L_0x004b:
            if (r4 == 0) goto L_0x0053
            r4.flush()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0053
        L_0x0051:
            r2 = move-exception
            goto L_0x005e
        L_0x0053:
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0058:
            if (r4 == 0) goto L_0x0077
            r4.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0077
        L_0x005e:
            r2.printStackTrace()
            goto L_0x0077
        L_0x0062:
            r2 = move-exception
            goto L_0x0078
        L_0x0064:
            r2 = move-exception
        L_0x0065:
            r2.printStackTrace()     // Catch:{ all -> 0x0062 }
            if (r4 == 0) goto L_0x006d
            r4.flush()     // Catch:{ IOException -> 0x0051 }
        L_0x006d:
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0072:
            if (r4 == 0) goto L_0x0077
            r4.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0077:
            return
        L_0x0078:
            if (r4 == 0) goto L_0x0080
            r4.flush()     // Catch:{ IOException -> 0x007e }
            goto L_0x0080
        L_0x007e:
            r3 = move-exception
            goto L_0x008b
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3.close()     // Catch:{ IOException -> 0x007e }
        L_0x0085:
            if (r4 == 0) goto L_0x008e
            r4.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x008e
        L_0x008b:
            r3.printStackTrace()
        L_0x008e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.FontResourceLoader.m12187a(android.content.Context, java.io.InputStream, java.lang.String):void");
    }

    public static boolean isFontRequest(String str) {
        return !TextUtil.isEmpty(str) && str.startsWith(DMSandboxHelper.DIMINA_FONT);
    }

    public static WebResourceResponse getFontResourceResponse(Context context, Uri uri) {
        return new WebResourceResponse("application/octet-stream", "UTF8", readFontFile(context, uri.getQueryParameter("family")));
    }
}
