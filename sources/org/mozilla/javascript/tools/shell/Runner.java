package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/* compiled from: Global */
class Runner implements Runnable, ContextAction {
    private Object[] args;

    /* renamed from: f */
    private Function f6674f;
    ContextFactory factory;

    /* renamed from: s */
    private Script f6675s;
    private Scriptable scope;

    Runner(Scriptable scriptable, Function function, Object[] objArr) {
        this.scope = scriptable;
        this.f6674f = function;
        this.args = objArr;
    }

    Runner(Scriptable scriptable, Script script) {
        this.scope = scriptable;
        this.f6675s = script;
    }

    public void run() {
        this.factory.call(this);
    }

    public Object run(Context context) {
        Function function = this.f6674f;
        if (function == null) {
            return this.f6675s.exec(context, this.scope);
        }
        Scriptable scriptable = this.scope;
        return function.call(context, scriptable, scriptable, this.args);
    }
}
