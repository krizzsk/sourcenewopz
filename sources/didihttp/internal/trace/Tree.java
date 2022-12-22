package didihttp.internal.trace;

import android.os.SystemClock;
import didihttp.Interceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

    /* renamed from: a */
    private Node f56910a;

    /* renamed from: b */
    private Node f56911b;

    public void push(Node node) {
        if (IcpStatStrategy.m40852a().mo170361b()) {
            node.startTime = SystemClock.uptimeMillis();
            Node node2 = this.f56910a;
            if (node2 == null) {
                this.f56910a = node;
                this.f56911b = node;
                return;
            }
            node2.children.add(node);
            node.parent = this.f56910a;
            this.f56910a = node;
        }
    }

    public void pop(Node node) {
        if (IcpStatStrategy.m40852a().mo170361b()) {
            node.endTime = SystemClock.uptimeMillis();
            Node node2 = this.f56910a;
            if (node == node2) {
                this.f56910a = node2.parent;
            }
        }
    }

    public void popTo(Interceptor interceptor) {
        if (IcpStatStrategy.m40852a().mo170361b()) {
            while (true) {
                Node node = this.f56910a;
                if (node != null && node.value != interceptor) {
                    this.f56910a.endTime = SystemClock.uptimeMillis();
                    this.f56910a = this.f56910a.parent;
                } else {
                    return;
                }
            }
        }
    }

    public void popAll() {
        if (IcpStatStrategy.m40852a().mo170361b()) {
            while (true) {
                Node node = this.f56910a;
                if (node != null) {
                    node.endTime = SystemClock.uptimeMillis();
                    this.f56910a = this.f56910a.parent;
                } else {
                    return;
                }
            }
        }
    }

    public List<Node> transformToList() {
        ArrayList arrayList = new ArrayList();
        if (IcpStatStrategy.m40852a().mo170361b() && this.f56911b != null) {
            Stack stack = new Stack();
            stack.push(this.f56911b);
            while (!stack.isEmpty()) {
                Node node = (Node) stack.pop();
                if (node != null) {
                    arrayList.add(node);
                    node.cost = node.endTime - node.startTime;
                    for (int size = node.children.size() - 1; size >= 0; size--) {
                        Node node2 = node.children.get(size);
                        node.cost -= node2.endTime - node2.startTime;
                        stack.push(node2);
                    }
                }
            }
        }
        return arrayList;
    }

    public String getIcpCost() {
        return IcpStatStrategy.m40852a().mo170360a(this);
    }
}
