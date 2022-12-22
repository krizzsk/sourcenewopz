package org.mozilla.javascript.ast;

public class ObjectProperty extends InfixExpression {
    public void setNodeType(int i) {
        if (i == 103 || i == 151 || i == 152 || i == 163) {
            setType(i);
            return;
        }
        throw new IllegalArgumentException("invalid node type: " + i);
    }

    public ObjectProperty() {
        this.type = 103;
    }

    public ObjectProperty(int i) {
        super(i);
        this.type = 103;
    }

    public ObjectProperty(int i, int i2) {
        super(i, i2);
        this.type = 103;
    }

    public void setIsGetterMethod() {
        this.type = 151;
    }

    public boolean isGetterMethod() {
        return this.type == 151;
    }

    public void setIsSetterMethod() {
        this.type = 152;
    }

    public boolean isSetterMethod() {
        return this.type == 152;
    }

    public void setIsNormalMethod() {
        this.type = 163;
    }

    public boolean isNormalMethod() {
        return this.type == 163;
    }

    public boolean isMethod() {
        return isGetterMethod() || isSetterMethod() || isNormalMethod();
    }

    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        int i2 = i + 1;
        sb.append(makeIndent(i2));
        if (isGetterMethod()) {
            sb.append("get ");
        } else if (isSetterMethod()) {
            sb.append("set ");
        }
        AstNode astNode = this.left;
        if (getType() == 103) {
            i = 0;
        }
        sb.append(astNode.toSource(i));
        if (this.type == 103) {
            sb.append(": ");
        }
        AstNode astNode2 = this.right;
        if (getType() == 103) {
            i2 = 0;
        }
        sb.append(astNode2.toSource(i2));
        return sb.toString();
    }
}
