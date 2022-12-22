package com.microblink.blinkbarcode.secured;

/* compiled from: line */
class IllIIlllIl {
    private final llIIlIlIIl IlIllIlIIl;
    private final String llIIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl {
        private final String IlIllIlIIl;
        private final String IllIIIllII;
        private final String llIIlIlIIl;

        public llIIlIlIIl(String str, String str2, String str3) {
            this.llIIlIlIIl = str;
            this.IlIllIlIIl = str2;
            this.IllIIIllII = str3;
        }

        public String IlIllIlIIl() {
            return this.IlIllIlIIl;
        }

        public String IllIIIllII() {
            return this.IllIIIllII;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || llIIlIlIIl.class != obj.getClass()) {
                return false;
            }
            llIIlIlIIl lliililiil = (llIIlIlIIl) obj;
            if (this.llIIlIlIIl.equals(lliililiil.llIIlIlIIl) && this.IlIllIlIIl.equals(lliililiil.IlIllIlIIl)) {
                return this.IllIIIllII.equals(lliililiil.IllIIIllII);
            }
            return false;
        }

        public int hashCode() {
            return (((this.llIIlIlIIl.hashCode() * 31) + this.IlIllIlIIl.hashCode()) * 31) + this.IllIIIllII.hashCode();
        }

        public String llIIlIlIIl() {
            return this.llIIlIlIIl;
        }
    }

    public IllIIlllIl(String str, llIIlIlIIl lliililiil) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = lliililiil;
    }

    public String IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IllIIlllIl.class != obj.getClass()) {
            return false;
        }
        IllIIlllIl illIIlllIl = (IllIIlllIl) obj;
        String str = this.llIIlIlIIl;
        if (str == null ? illIIlllIl.llIIlIlIIl != null : !str.equals(illIIlllIl.llIIlIlIIl)) {
            return false;
        }
        llIIlIlIIl lliililiil = this.IlIllIlIIl;
        llIIlIlIIl lliililiil2 = illIIlllIl.IlIllIlIIl;
        if (lliililiil != null) {
            return lliililiil.equals(lliililiil2);
        }
        if (lliililiil2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.llIIlIlIIl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        llIIlIlIIl lliililiil = this.IlIllIlIIl;
        if (lliililiil != null) {
            i = lliililiil.hashCode();
        }
        return hashCode + i;
    }

    public llIIlIlIIl llIIlIlIIl() {
        return this.IlIllIlIIl;
    }
}
