package com.didi.component.core;

public class ComponentLoader {
    public static void load(String str) {
        try {
            Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
