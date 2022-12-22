package p242io.socket.yeast;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.socket.yeast.Yeast */
public final class Yeast {

    /* renamed from: a */
    private static char[] f59564a;

    /* renamed from: b */
    private static int f59565b;

    /* renamed from: c */
    private static int f59566c = 0;

    /* renamed from: d */
    private static String f59567d;

    /* renamed from: e */
    private static Map<Character, Integer> f59568e = new HashMap(f59565b);

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        f59564a = charArray;
        f59565b = charArray.length;
        for (int i = 0; i < f59565b; i++) {
            f59568e.put(Character.valueOf(f59564a[i]), Integer.valueOf(i));
        }
    }

    private Yeast() {
    }

    public static String encode(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, f59564a[(int) (j % ((long) f59565b))]);
            j /= (long) f59565b;
        } while (j > 0);
        return sb.toString();
    }

    public static long decode(String str) {
        long j = 0;
        for (char valueOf : str.toCharArray()) {
            j = (j * ((long) f59565b)) + ((long) f59568e.get(Character.valueOf(valueOf)).intValue());
        }
        return j;
    }

    public static String yeast() {
        String encode = encode(new Date().getTime());
        if (!encode.equals(f59567d)) {
            f59566c = 0;
            f59567d = encode;
            return encode;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(encode);
        sb.append(".");
        int i = f59566c;
        f59566c = i + 1;
        sb.append(encode((long) i));
        return sb.toString();
    }
}
