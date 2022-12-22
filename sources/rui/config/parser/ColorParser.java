package rui.config.parser;

import rui.config.RConfigEngine;
import rui.config.model.IRModel;
import rui.config.model.color.ColorFill;
import rui.config.model.color.ColorGradient;
import rui.config.model.color.ColorName;

public class ColorParser implements IRParser {
    public String type() {
        return "color";
    }

    public IRModel parse(String str) throws RConfigEngine.ConfigParseException {
        if (str == null || str.isEmpty()) {
            throw new RConfigEngine.ConfigParseException("modelString cannot be null or empty");
        } else if (C3016a.m3848b(str)) {
            return new ColorFill(str);
        } else {
            if (C3016a.m3847a(str)) {
                return new ColorGradient(str);
            }
            if (C3016a.m3849c(str)) {
                return new ColorName(str);
            }
            throw new RConfigEngine.ConfigParseException("color parse error: " + str);
        }
    }
}
