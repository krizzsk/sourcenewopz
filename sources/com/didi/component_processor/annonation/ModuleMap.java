package com.didi.component_processor.annonation;

import java.util.HashMap;

public class ModuleMap {
    public static HashMap<String, Class<?>> childMap = new HashMap<>();
    public static HashMap<String, Class<?>> containerMap = new HashMap<>();
    public static HashMap<String, Class<?>> nodeMap = new HashMap<>();
    public static HashMap<String, Class<?>> standardMap = new HashMap<>();

    public static void addStandard(String str, Class<?> cls) {
        standardMap.put(str, cls);
    }

    public static void addChild(String str, Class<?> cls) {
        childMap.put(str, cls);
    }

    public static void addNode(String str, Class<?> cls) {
        nodeMap.put(str, cls);
    }

    public static void addContainer(String str, Class<?> cls) {
        containerMap.put(str, cls);
    }

    public static Class<?> getStandardComponent(String str) {
        return standardMap.get(str);
    }

    public static Class<?> getChildComponent(String str) {
        return childMap.get(str);
    }

    public static Class<?> getNode(String str) {
        return nodeMap.get(str);
    }

    public static Class<?> getContainer(String str) {
        return containerMap.get(str);
    }

    public static boolean containerContains(String str) {
        return containerMap.containsKey(str);
    }
}
