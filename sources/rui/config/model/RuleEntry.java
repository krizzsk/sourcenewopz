package rui.config.model;

public class RuleEntry {

    /* renamed from: a */
    private String f6750a;

    /* renamed from: b */
    private String f6751b;

    /* renamed from: c */
    private String f6752c;

    public RuleEntry(String str, String str2, String str3) {
        this.f6750a = str;
        this.f6751b = str2;
        this.f6752c = str3;
    }

    public String getType() {
        return this.f6750a;
    }

    public String getName() {
        return this.f6751b;
    }

    public String getValue() {
        return this.f6752c;
    }
}
