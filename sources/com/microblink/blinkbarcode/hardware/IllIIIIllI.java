package com.microblink.blinkbarcode.hardware;

/* compiled from: line */
public class IllIIIIllI {
    private int IlIllIlIIl = -1;
    private int IllIIIllII = -1;
    private int llIIlIlIIl = -1;

    public IllIIIIllI(String str) {
        llIIlIlIIl(str);
    }

    private void llIIlIlIIl(String str) {
        if (str != null) {
            String[] split = str.split("\\.");
            if (split.length == 0) {
                throw new IllegalArgumentException("Invalid version string " + str);
            } else if (split.length >= 1) {
                this.llIIlIlIIl = Integer.parseInt(split[0]);
                if (split.length >= 2) {
                    this.IlIllIlIIl = Integer.parseInt(split[1]);
                    if (split.length >= 3) {
                        this.IllIIIllII = Integer.parseInt(split[2]);
                    }
                }
            }
        } else {
            throw new NullPointerException("Cannot parse null version string!");
        }
    }

    public boolean IlIllIlIIl(IllIIIIllI illIIIIllI) {
        if (illIIIIllI != null) {
            int i = this.llIIlIlIIl;
            int i2 = illIIIIllI.llIIlIlIIl;
            if (i < i2) {
                return false;
            }
            if (i > i2) {
                return true;
            }
            int i3 = this.IlIllIlIIl;
            if (i3 == -1) {
                return false;
            }
            int i4 = illIIIIllI.IlIllIlIIl;
            if (i4 == -1) {
                if (i3 != 0) {
                    return true;
                }
                return false;
            } else if (i3 < i4) {
                return false;
            } else {
                if (i3 > i4) {
                    return true;
                }
                int i5 = this.IllIIIllII;
                if (i5 == -1) {
                    return false;
                }
                int i6 = illIIIIllI.IllIIIllII;
                if (i6 == -1) {
                    if (i5 != 0) {
                        return true;
                    }
                    return false;
                } else if (i5 > i6) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            throw new NullPointerException("Cannot compare with null version!");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.llIIlIlIIl);
        if (this.IlIllIlIIl != -1) {
            sb.append('.');
            sb.append(this.IlIllIlIIl);
            if (this.IllIIIllII != -1) {
                sb.append('.');
                sb.append(this.IllIIIllII);
            }
        }
        return sb.toString();
    }

    public boolean llIIlIlIIl(IllIIIIllI illIIIIllI) {
        if (illIIIIllI != null) {
            int i = this.llIIlIlIIl;
            int i2 = illIIIIllI.llIIlIlIIl;
            if (i < i2) {
                return false;
            }
            if (i > i2) {
                return true;
            }
            int i3 = this.IlIllIlIIl;
            if (i3 == -1) {
                int i4 = illIIIIllI.IlIllIlIIl;
                if (i4 == -1 || i4 == 0) {
                    return true;
                }
                return false;
            }
            int i5 = illIIIIllI.IlIllIlIIl;
            if (i5 == -1) {
                return true;
            }
            if (i3 < i5) {
                return false;
            }
            if (i3 > i5) {
                return true;
            }
            int i6 = this.IllIIIllII;
            if (i6 == -1) {
                int i7 = illIIIIllI.IllIIIllII;
                if (i7 == -1 || i7 == 0) {
                    return true;
                }
                return false;
            }
            int i8 = illIIIIllI.IllIIIllII;
            if (i8 != -1 && i6 < i8) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("Cannot compare with null version!");
    }
}
