package org.xidea.lite;

import java.io.Writer;
import org.xidea.p087el.ValueStack;

public interface Plugin {
    void execute(ValueStack valueStack, Writer writer);

    void initialize(Template template, Object[] objArr);
}
