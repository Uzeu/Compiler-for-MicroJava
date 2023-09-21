// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private VarDeclNameBrackets VarDeclNameBrackets;
    private BracketList BracketList;

    public VarDecl (Type Type, VarDeclNameBrackets VarDeclNameBrackets, BracketList BracketList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclNameBrackets=VarDeclNameBrackets;
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.setParent(this);
        this.BracketList=BracketList;
        if(BracketList!=null) BracketList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclNameBrackets getVarDeclNameBrackets() {
        return VarDeclNameBrackets;
    }

    public void setVarDeclNameBrackets(VarDeclNameBrackets VarDeclNameBrackets) {
        this.VarDeclNameBrackets=VarDeclNameBrackets;
    }

    public BracketList getBracketList() {
        return BracketList;
    }

    public void setBracketList(BracketList BracketList) {
        this.BracketList=BracketList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.accept(visitor);
        if(BracketList!=null) BracketList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.traverseTopDown(visitor);
        if(BracketList!=null) BracketList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.traverseBottomUp(visitor);
        if(BracketList!=null) BracketList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclNameBrackets!=null)
            buffer.append(VarDeclNameBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BracketList!=null)
            buffer.append(BracketList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
