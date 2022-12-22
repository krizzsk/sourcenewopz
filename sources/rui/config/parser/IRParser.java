package rui.config.parser;

import rui.config.RConfigEngine;
import rui.config.model.IRModel;

public interface IRParser {
    IRModel parse(String str) throws RConfigEngine.ConfigParseException;

    String type();
}
