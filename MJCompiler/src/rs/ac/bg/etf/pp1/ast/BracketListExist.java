// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class BracketListExist extends BracketList {

    private BracketList BracketList;
    private VarDeclNameBrackets VarDeclNameBrackets;

    public BracketListExist (BracketList BracketList, VarDeclNameBrackets VarDeclNameBrackets) {
        this.BracketList=BracketList;
        if(BracketList!=null) BracketList.setParent(this);
        this.VarDeclNameBrackets=VarDeclNameBrackets;
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.setParent(this);
    }

    public BracketList getBracketList() {
        return BracketList;
    }

    public void setBracketList(BracketList BracketList) {
        this.BracketList=BracketList;
    }

    public VarDeclNameBrackets getVarDeclNameBrackets() {
        return VarDeclNameBrackets;
    }

    public void setVarDeclNameBrackets(VarDeclNameBrackets VarDeclNameBrackets) {
        this.VarDeclNameBrackets=VarDeclNameBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BracketList!=null) BracketList.accept(visitor);
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BracketList!=null) BracketList.traverseTopDown(visitor);
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BracketList!=null) BracketList.traverseBottomUp(visitor);
        if(VarDeclNameBrackets!=null) VarDeclNameBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BracketListExist(\n");

        if(BracketList!=null)
            buffer.append(BracketList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclNameBrackets!=null)
            buffer.append(VarDeclNameBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BracketListExist]");
        return buffer.toString();
    }
}
