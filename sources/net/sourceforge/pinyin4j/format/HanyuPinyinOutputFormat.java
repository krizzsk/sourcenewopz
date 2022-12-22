package net.sourceforge.pinyin4j.format;

public final class HanyuPinyinOutputFormat {

    /* renamed from: a */
    private HanyuPinyinVCharType f5065a;

    /* renamed from: b */
    private HanyuPinyinCaseType f5066b;

    /* renamed from: c */
    private HanyuPinyinToneType f5067c;

    public HanyuPinyinOutputFormat() {
        restoreDefault();
    }

    public void restoreDefault() {
        this.f5065a = HanyuPinyinVCharType.WITH_U_AND_COLON;
        this.f5066b = HanyuPinyinCaseType.LOWERCASE;
        this.f5067c = HanyuPinyinToneType.WITH_TONE_NUMBER;
    }

    public HanyuPinyinCaseType getCaseType() {
        return this.f5066b;
    }

    public void setCaseType(HanyuPinyinCaseType hanyuPinyinCaseType) {
        this.f5066b = hanyuPinyinCaseType;
    }

    public HanyuPinyinToneType getToneType() {
        return this.f5067c;
    }

    public void setToneType(HanyuPinyinToneType hanyuPinyinToneType) {
        this.f5067c = hanyuPinyinToneType;
    }

    public HanyuPinyinVCharType getVCharType() {
        return this.f5065a;
    }

    public void setVCharType(HanyuPinyinVCharType hanyuPinyinVCharType) {
        this.f5065a = hanyuPinyinVCharType;
    }
}
