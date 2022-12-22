package com.didi.component.never.core.node;

import java.util.Stack;

public class NodeStack extends Stack<Node> {

    public interface NodeStackListener {
        void onNodePop(Node node);
    }

    public Node push(Node node) {
        return (Node) super.push(node);
    }

    public synchronized Node pop() {
        return (Node) super.pop();
    }

    public synchronized Node root(NodeStackListener nodeStackListener) {
        for (int size = size(); size > 1; size--) {
            Node pop = pop();
            if (nodeStackListener != null) {
                nodeStackListener.onNodePop(pop);
            }
        }
        return (Node) peek();
    }

    public synchronized Node rootTo(Node node, NodeStackListener nodeStackListener) {
        if (contains(node)) {
            if (node != null) {
                while (!((Node) peek()).getClass().equals(node.getClass())) {
                    Node pop = pop();
                    if (nodeStackListener != null) {
                        nodeStackListener.onNodePop(pop);
                    }
                }
                return node;
            }
        }
        return null;
    }

    public synchronized Node root() {
        return root((NodeStackListener) null);
    }
}
