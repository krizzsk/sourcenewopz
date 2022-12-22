package rui.config.model.color;

import android.graphics.Color;
import java.util.Objects;

public class ColorFill implements IRModelColor<ColorFill> {

    /* renamed from: a */
    private String f6753a;

    public ColorFill(String str) {
        this.f6753a = str;
    }

    public int getColorValue() {
        return Color.parseColor(this.f6753a);
    }

    public String getColor() {
        return this.f6753a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6753a.equals(((ColorFill) obj).f6753a);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f6753a});
    }
}
