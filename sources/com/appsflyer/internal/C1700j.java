package com.appsflyer.internal;

import android.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.appsflyer.internal.j */
public final class C1700j {

    /* renamed from: ı */
    public String f1992;

    /* renamed from: ǃ */
    public String f1993;

    /* renamed from: ɩ */
    public String f1994;

    /* renamed from: ι */
    private byte[] f1995;

    C1700j() {
    }

    public C1700j(String str, byte[] bArr, String str2) {
        this.f1992 = str;
        this.f1995 = bArr;
        this.f1994 = str2;
    }

    C1700j(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i = 0;
        int i2 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.f1992 = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.f1994 = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.f1994);
                if (matcher.matches()) {
                    i = Integer.parseInt(matcher.group(1));
                    i2 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.f1995 = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            }
        }
        scanner.close();
    }

    /* renamed from: ǃ */
    public final byte[] mo16138() {
        return this.f1995;
    }
}
