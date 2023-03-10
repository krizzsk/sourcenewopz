package org.mozilla.javascript.ast;

import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

public class Symbol {
    private Scope containingTable;
    private int declType;
    private int index = -1;
    private String name;
    private Node node;

    public Symbol() {
    }

    public Symbol(int i, String str) {
        setName(str);
        setDeclType(i);
    }

    public int getDeclType() {
        return this.declType;
    }

    public void setDeclType(int i) {
        if (i == 109 || i == 87 || i == 122 || i == 153 || i == 154) {
            this.declType = i;
            return;
        }
        throw new IllegalArgumentException("Invalid declType: " + i);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Node getNode() {
        return this.node;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setNode(Node node2) {
        this.node = node2;
    }

    public Scope getContainingTable() {
        return this.containingTable;
    }

    public void setContainingTable(Scope scope) {
        this.containingTable = scope;
    }

    public String getDeclTypeName() {
        return Token.typeToName(this.declType);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol (");
        sb.append(getDeclTypeName());
        sb.append(") name=");
        sb.append(this.name);
        if (this.node != null) {
            sb.append(" line=");
            sb.append(this.node.getLineno());
        }
        return sb.toString();
    }
}
