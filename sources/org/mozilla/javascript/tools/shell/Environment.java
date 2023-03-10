package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.osgi.framework.Constants;

public class Environment extends ScriptableObject {
    static final long serialVersionUID = -430727378460177065L;
    private Environment thePrototypeInstance = null;

    public String getClassName() {
        return "Environment";
    }

    public static void defineClass(ScriptableObject scriptableObject) {
        try {
            ScriptableObject.defineClass(scriptableObject, Environment.class);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Environment() {
        if (0 == 0) {
            this.thePrototypeInstance = this;
        }
    }

    public Environment(ScriptableObject scriptableObject) {
        setParentScope(scriptableObject);
        Object topLevelProp = ScriptRuntime.getTopLevelProp(scriptableObject, "Environment");
        if (topLevelProp != null && (topLevelProp instanceof Scriptable)) {
            Scriptable scriptable = (Scriptable) topLevelProp;
            setPrototype((Scriptable) scriptable.get(Constants.SCOPE_PROTOTYPE, scriptable));
        }
    }

    public boolean has(String str, Scriptable scriptable) {
        if (this == this.thePrototypeInstance) {
            return super.has(str, scriptable);
        }
        return System.getProperty(str) != null;
    }

    public Object get(String str, Scriptable scriptable) {
        if (this == this.thePrototypeInstance) {
            return super.get(str, scriptable);
        }
        String property = System.getProperty(str);
        if (property != null) {
            return ScriptRuntime.toObject(getParentScope(), property);
        }
        return Scriptable.NOT_FOUND;
    }

    public void put(String str, Scriptable scriptable, Object obj) {
        if (this == this.thePrototypeInstance) {
            super.put(str, scriptable, obj);
        } else {
            System.getProperties().put(str, ScriptRuntime.toString(obj));
        }
    }

    private Object[] collectIds() {
        return System.getProperties().keySet().toArray();
    }

    public Object[] getIds() {
        if (this == this.thePrototypeInstance) {
            return super.getIds();
        }
        return collectIds();
    }

    public Object[] getAllIds() {
        if (this == this.thePrototypeInstance) {
            return super.getAllIds();
        }
        return collectIds();
    }
}
