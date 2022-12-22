package rui.config.model.color;

import rui.config.RConfigEngine;
import rui.config.model.IRModel;

public class ColorName implements IRModelColor<ColorName> {

    /* renamed from: a */
    private static final String f6757a = "color name not found: ";

    /* renamed from: b */
    private static final String f6758b = "parent name type is not color: ";

    /* renamed from: c */
    private IRModelColor f6759c;

    public ColorName(String str) throws RConfigEngine.ConfigParseException {
        try {
            IRModel iRModel = RConfigEngine.get(str);
            if (iRModel instanceof IRModelColor) {
                this.f6759c = (IRModelColor) iRModel;
                return;
            }
            throw new RConfigEngine.ConfigParseException(f6758b + str);
        } catch (RConfigEngine.ConfigParseException unused) {
            throw new RConfigEngine.ConfigParseException(f6757a + str);
        }
    }

    public IRModelColor getParent() {
        return this.f6759c;
    }
}
