package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.opengl.GLES20;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;

/* renamed from: com.didi.hawaii.ar.utils.ShaderUtil */
public class ShaderUtil {
    public static int loadGLShader(String str, Context context, int i, String str2) throws IOException {
        String a = m16722a(context, str2);
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, a);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            SystemUtils.log(6, str, "Error compiling shader: " + GLES20.glGetShaderInfoLog(glCreateShader), (Throwable) null, "com.didi.hawaii.ar.utils.ShaderUtil", 41);
            GLES20.glDeleteShader(glCreateShader);
            glCreateShader = 0;
        }
        if (glCreateShader != 0) {
            return glCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    public static void checkGLError(String str, String str2) {
        int i = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            SystemUtils.log(6, str, str2 + ": glError " + glGetError, (Throwable) null, "com.didi.hawaii.ar.utils.ShaderUtil", 64);
            i = glGetError;
        }
        if (i != 0) {
            throw new RuntimeException(str2 + ": glError " + i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r7 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        if (r0 == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r7.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        if (r0 != null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007c, code lost:
        r7.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
        throw r8;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m16722a(android.content.Context r7, java.lang.String r8) throws java.io.IOException {
        /*
            android.content.res.AssetManager r0 = r7.getAssets()
            java.io.InputStream r0 = r0.open(r8)
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0072 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0072 }
            r2.<init>(r0)     // Catch:{ all -> 0x0072 }
            r1.<init>(r2)     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r2.<init>()     // Catch:{ all -> 0x0066 }
        L_0x0017:
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0059
            java.lang.String r4 = " "
            r5 = -1
            java.lang.String[] r4 = r3.split(r4, r5)     // Catch:{ all -> 0x0066 }
            r5 = 0
            r5 = r4[r5]     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = "#include"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0066 }
            if (r5 == 0) goto L_0x0050
            r3 = 1
            r3 = r4[r3]     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = "\""
            java.lang.String r5 = ""
            java.lang.String r3 = r3.replace(r4, r5)     // Catch:{ all -> 0x0066 }
            boolean r4 = r3.equals(r8)     // Catch:{ all -> 0x0066 }
            if (r4 != 0) goto L_0x0048
            java.lang.String r3 = m16722a(r7, r3)     // Catch:{ all -> 0x0066 }
            r2.append(r3)     // Catch:{ all -> 0x0066 }
            goto L_0x0017
        L_0x0048:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0066 }
            java.lang.String r8 = "Do not include the calling file."
            r7.<init>(r8)     // Catch:{ all -> 0x0066 }
            throw r7     // Catch:{ all -> 0x0066 }
        L_0x0050:
            r2.append(r3)     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = "\n"
            r2.append(r3)     // Catch:{ all -> 0x0066 }
            goto L_0x0017
        L_0x0059:
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0066 }
            r1.close()     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0065
            r0.close()
        L_0x0065:
            return r7
        L_0x0066:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r8 = move-exception
            r1.close()     // Catch:{ all -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r1 = move-exception
            r7.addSuppressed(r1)     // Catch:{ all -> 0x0072 }
        L_0x0071:
            throw r8     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r8 = move-exception
            if (r0 == 0) goto L_0x007f
            r0.close()     // Catch:{ all -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            r7.addSuppressed(r0)
        L_0x007f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.ShaderUtil.m16722a(android.content.Context, java.lang.String):java.lang.String");
    }
}
