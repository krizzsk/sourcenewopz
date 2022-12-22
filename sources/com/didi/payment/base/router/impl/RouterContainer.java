package com.didi.payment.base.router.impl;

import java.util.Iterator;
import java.util.Stack;

public class RouterContainer {

    /* renamed from: a */
    private static Stack<IPayRouter> f29936a = new Stack<>();

    public static void push(IPayRouter iPayRouter) {
        if (!f29936a.contains(iPayRouter)) {
            f29936a.push(iPayRouter);
        }
    }

    public static void pop(boolean z) {
        if (!f29936a.empty()) {
            f29936a.pop().destroy();
        }
    }

    public static IPayRouter peek() {
        if (!f29936a.empty()) {
            return f29936a.peek();
        }
        return null;
    }

    public static Iterator<IPayRouter> iterator() {
        if (!f29936a.empty()) {
            return f29936a.iterator();
        }
        return null;
    }

    public static boolean isEmpty() {
        return f29936a.empty();
    }

    public static int size() {
        return f29936a.size();
    }

    public static void clear() {
        if (!f29936a.empty()) {
            f29936a.clear();
        }
    }
}
