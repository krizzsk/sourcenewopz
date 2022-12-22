package net.lingala.zip4j.crypto.PBKDF2;

/* renamed from: net.lingala.zip4j.crypto.PBKDF2.b */
/* compiled from: PBKDF2HexFormatter */
class C2383b {
    C2383b() {
    }

    /* renamed from: a */
    public boolean mo24078a(PBKDF2Parameters pBKDF2Parameters, String str) {
        if (pBKDF2Parameters == null || str == null) {
            return true;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return true;
        }
        byte[] a = C2382a.m3062a(split[0]);
        int parseInt = Integer.parseInt(split[1]);
        byte[] a2 = C2382a.m3062a(split[2]);
        pBKDF2Parameters.setSalt(a);
        pBKDF2Parameters.setIterationCount(parseInt);
        pBKDF2Parameters.setDerivedKey(a2);
        return false;
    }

    /* renamed from: a */
    public String mo24077a(PBKDF2Parameters pBKDF2Parameters) {
        return C2382a.m3061a(pBKDF2Parameters.getSalt()) + ":" + String.valueOf(pBKDF2Parameters.getIterationCount()) + ":" + C2382a.m3061a(pBKDF2Parameters.getDerivedKey());
    }
}
