package rui.config.model.color;

import java.util.Objects;
import rui.config.RConfigEngine;

public class ColorGradient implements IRModelColor<ColorGradient> {

    /* renamed from: a */
    private static final int f6754a = 3;

    /* renamed from: b */
    private String f6755b;

    /* renamed from: c */
    private String f6756c;

    public ColorGradient(String str) throws RConfigEngine.ConfigParseException {
        String[] split = str.split(":");
        if (split.length == 3) {
            this.f6755b = split[1];
            this.f6756c = split[2];
            return;
        }
        throw new RConfigEngine.ConfigParseException("gradient syntax error: " + str);
    }

    public String getGradientStart() {
        return this.f6755b;
    }

    public String getGradientEnd() {
        return this.f6756c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorGradient colorGradient = (ColorGradient) obj;
        if (!this.f6755b.equals(colorGradient.f6755b) || !this.f6756c.equals(colorGradient.f6756c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f6755b, this.f6756c});
    }
}
