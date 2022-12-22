package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Handler */
class Handler {
    String desc;
    Label end;
    Label handler;
    Handler next;
    Label start;
    int type;

    Handler() {
    }

    static Handler remove(Handler handler2, Label label, Label label2) {
        int i;
        if (handler2 == null) {
            return null;
        }
        handler2.next = remove(handler2.next, label, label2);
        int i2 = handler2.start.position;
        int i3 = handler2.end.position;
        int i4 = label.position;
        if (label2 == null) {
            i = Integer.MAX_VALUE;
        } else {
            i = label2.position;
        }
        if (i4 >= i3 || i <= i2) {
            return handler2;
        }
        if (i4 <= i2) {
            if (i >= i3) {
                return handler2.next;
            }
            handler2.start = label2;
            return handler2;
        } else if (i >= i3) {
            handler2.end = label;
            return handler2;
        } else {
            Handler handler3 = new Handler();
            handler3.start = label2;
            handler3.end = handler2.end;
            handler3.handler = handler2.handler;
            handler3.desc = handler2.desc;
            handler3.type = handler2.type;
            handler3.next = handler2.next;
            handler2.end = label;
            handler2.next = handler3;
            return handler2;
        }
    }
}
