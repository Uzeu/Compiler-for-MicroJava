package rs.ac.bg.etf.pp1;

import java.nio.file.WatchEvent.Kind;
import java.util.IllegalFormatCodePointException;

import java_cup.internal_error;

//import java.sql.Struct;

import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
//import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
//import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	private int mainPc;
	private Obj pomocna;
	private int p1;
	private int p2;
	
	
	private int brojacStmt2=0;
	private int brojacniz=0;
	private Obj nizStmt2[]= new Obj[100];
	
	
	
	
	public int getMainPc() {
		return mainPc;
	}
	
	
	public void visit(ReadStmt readStmt) {
		Code.put(Code.read);
		Code.store(readStmt.getDesignator().obj);
		
		
		
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		Code.put(Code.pop);
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		//AKO NE RADI NESTO OVO IZBRISI !!!!!!!!!!!!!!!
		
	}
	
	
	@Override
	public void visit(PrintStmtComma printStmt) {
		if(printStmt.getExpr().struct.getKind() == Struct.Int) {
			//printStmt.getN2();
			Code.loadConst(printStmt.getN2());
			Code.put(Code.print);
		}
		else if(printStmt.getExpr().struct.getKind()==Struct.Char) {
			Code.loadConst(printStmt.getN2());
			Code.put(Code.bprint);
		}
		else {
			Code.loadConst(printStmt.getN2());
			Code.put(Code.print);
		}
	}
	
	public void visit(PrintStmt printStmt) {
		if(printStmt.getExpr().struct.getKind() == Struct.Int) {
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else if(printStmt.getExpr().struct.getKind()==Struct.Char) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		else {
			Code.loadConst(5);
			Code.put(Code.print);
			/*int a=Code.get(Code.pop);
			if(a==1) {
				Code.loadConst('t');
				Code.loadConst(1);
				Code.put(Code.bprint);

				Code.loadConst('r');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.loadConst('u');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.loadConst('e');
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
			else if(a==0){
				Code.loadConst('f');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.loadConst('a');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.loadConst('l');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.loadConst('s');
				Code.loadConst(1);
				Code.put(Code.bprint);
				
				Code.loadConst('e');
				Code.loadConst(1);
				Code.put(Code.bprint);
			}*/
			
		}
	}
	
	public void visit(FindAnyStmt findAny) {
		Obj obj=findAny.getRightDesignator().getDesignator().obj;
		Code.loadConst(0);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		//--------------
		Code.put(Code.arraylength);
		Code.loadConst(0);
		Code.put(Code.dup_x1);
		int offset=Code.pc;
		
		//WHILE (i<niz.length)
		
		Code.putFalseJump(Code.gt,0);
		int adr=Code.pc-2;
		
		Code.load(obj);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.dup_x1);
		
		if(obj.getType().getElemType().getKind()==Struct.Int) {
			Code.put(Code.aload);
		}
		else {
			Code.put(Code.baload);
		}
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		
		Code.put(Code.dup_x2);
		
		//IF
		Code.putFalseJump(Code.eq, 0);
		int adr2=Code.pc-2;
		
		//if statement
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		
		Code.loadConst(1);
		Code.put(Code.add);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		//if statement
		
		Code.putJump(0);
		int adr3=Code.pc-2;
		Code.fixup(adr2);
		
		//else statement
		Code.fixup(adr3);
		
		
		Code.load(obj);
		Code.put(Code.arraylength);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.put(Code.dup_x1);
		
		
		Code.putJump(offset);
		Code.fixup(adr);
		//WHILE (i<niz.length)
		
		Code.put(Code.pop);
		Code.put(Code.pop);
		
		Obj obj2=findAny.getDesignator().obj;
		Code.store(obj2);
		Code.put(Code.pop);
		
		
	}
	
	public void visit(NumFactor num) {
		Obj con=Tab.insert(Obj.Con, "$", num.struct);
		con.setLevel(0);
		con.setAdr(num.getN1());
		Code.load(con);
	}
	
	public void visit(CharFactor c) {
		Obj con=Tab.insert(Obj.Con, "$", c.struct);
		con.setLevel(0);
		con.setAdr(c.getC1());
		Code.load(con);
	}
	
	public void visit(BoolFactor c) {
		Obj con=Tab.insert(Obj.Con, "$", c.struct);
		con.setLevel(0);
		if(c.getB1()==true)
			con.setAdr(1);
		else 
			con.setAdr(0);
		
		Code.load(con);
	}
	
	public void visit(ConstValNum num) {
		
	}
	public void visit(ConstValChar c) {
		
	}
	public void visit(ConstValBool b) {
		
	}

	
	
	
	@Override
	public void visit(MethodName MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.getMethodName())) {
			mainPc = Code.pc;
		}
		MethodTypeName.obj.setAdr(Code.pc);
		
		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		//FormParamCounter fpCnt = new FormParamCounter();
		//methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry.
		Code.put(Code.enter);
		//Code.put(fpCnt.getCount());
		//Code.put(varCnt.getCount() + fpCnt.getCount());
		Code.put(0);
		Code.put(0+varCnt.getCount());
	}
	
	
	public void visit(NewFactor newf) {
		Code.put(Code.newarray);
		if(newf.getType().struct.getKind()==Struct.Int)
			Code.put(1);
		else
			Code.put(0);
		
	}
	
	public void visit(DesignatorStmt3 Assignment) {
		
		if(Assignment.getDesignator().obj.getType().getKind()==Struct.Array) {
			//Code.load(Assignment.getDesignator().obj);
			Code.store(Assignment.getDesignator().obj);
			//Code.store(Assignment.getDesignator().obj);
			pomocna=Assignment.getDesignator().obj;
			
			
		}
		else {
			Code.store(Assignment.getDesignator().obj);
			
			
		}
		
		
	}
	
	public void visit(DesignatorNoExpr Designator) {
		SyntaxNode parent = Designator.getParent();
		if (DesignatorStmt3.class != parent.getClass() && DesignatorStmt2.class!=parent.getClass()) {
			Code.load(Designator.obj);
		}
	}
	
	public void visit(DesignatorExpr Designator) {
		
		//Code.load(Designator.obj);
		SyntaxNode parent = Designator.getParent();
		//Designator.obj=Designator.getDesignatorName().obj;
		//if(Designator.getParent().getParent().getParent().getParent().getClass()==DesignatorStmt3.class) {
		//if(Designator.getParent().getClass()!=DesignatorStmt3.class)
			//Code.load(Designator.obj);
		if(Designator.obj.getKind()==Obj.Elem && Designator.getParent().getClass()!=DesignatorStmt3.class && Designator.getParent().getClass()!=DesignatorFormExist.class)
			Code.load(Designator.obj);
		//}
			
		
	}
	
	public void visit(DesignatorName designator) {
		/*SyntaxNode parent = designator.getParent();
		if(designator.getParent().getParent().getParent().getParent().getClass()==PrintStmt.class) {
			Code.load(designator.obj);
		}*/
		
		Code.load(designator.obj);
			
			
	}
	
	

	
	@Override
	public void visit(VarDecl VarDecl) {
		varCount++;
	}
	/*
	@Override
	public void visit(FormalParamDecl FormalParam) {
		paramCnt++;
	}	*/
	
	@Override
	public void visit(MethodDecl MethodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
		
	}
	/*
	@Override
	public void visit(ReturnExpr ReturnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(ReturnNoExpr ReturnNoExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Assignment Assignment) {
		Code.store(Assignment.getDesignator().obj);
	}
	
	@Override
	public void visit(Const Const) {
		Code.load(new Obj(Obj.Con, "$", Const.struct, Const.getN1(), 0));
	}
	
	@Override
	public void visit(Designator Designator) {
		SyntaxNode parent = Designator.getParent();
		if (Assignment.class != parent.getClass() && FuncCall.class != parent.getClass()) {
			Code.load(Designator.obj);
		}
	}
	
	@Override
	public void visit(FuncCall FuncCall) {
		Obj functionObj = FuncCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc; 
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	@Override
	public void visit(PrintStmt PrintStmt) {
		Code.put(Code.const_5);
		Code.put(Code.print);
	}
	
	@Override
	public void visit(AddExpr AddExpr) {
		Code.put(Code.add);
	}*/
	
	
	
	public void visit(AddopTermListExist addop) {
		
		if(addop.getAddop().getClass()==AddopPlus.class) {
			Code.put(Code.add);
		}
		else if(addop.getAddop().getClass()==AddopMinus.class) {
			Code.put(Code.sub);
		}
		
		/*if(p1==sym.PLUS)
			Code.put(Code.add);
		else if(p1==sym.MINUS)
			Code.put(Code.sub);*/
	}
	
	public void visit(NoAddopTerm addop) {
		
		if(addop.getAddop().getClass()==AddopPlus.class) {
			Code.put(Code.add);
		}
		else if(addop.getAddop().getClass()==AddopMinus.class) {
			Code.put(Code.sub);
		}
		/*if(p1==sym.PLUS)
			Code.put(Code.add);
		else if(p1==sym.MINUS)
			Code.put(Code.sub);*/
	}
	
	public void visit(AddopPlus addop) {
		p1=sym.PLUS;
	}
	
	public void visit(AddopMinus addop) {
		p1=sym.MINUS;
	}
	
	public void visit(MulopFactorListExist mulop) {
		
		if(mulop.getMulop().getClass()==MulopMul.class) {
			Code.put(Code.mul);
		}
		else if(mulop.getMulop().getClass()==MulopDiv.class) {
			Code.put(Code.div);
		}
		else if(mulop.getMulop().getClass()==MulopMod.class) {
			Code.put(Code.rem);
		}
		
		/*if(p2==sym.MUL)
			Code.put(Code.mul);
		else if(p2==sym.DIV)
			Code.put(Code.div);
		else if(p2==sym.MOD)
			Code.put(Code.rem);*/
	}
	public void visit(NoMulopFactor mulop) {
		
		if(mulop.getMulop().getClass()==MulopMul.class) {
			Code.put(Code.mul);
		}
		else if(mulop.getMulop().getClass()==MulopDiv.class) {
			Code.put(Code.div);
		}
		else if(mulop.getMulop().getClass()==MulopMod.class) {
			Code.put(Code.rem);
		}
		
		/*if(p2==sym.MUL)
			Code.put(Code.mul);
		else if(p2==sym.DIV)
			Code.put(Code.div);
		else if(p2==sym.MOD)
			Code.put(Code.rem);*/
	}
	
	
	public void visit(MulopMul mul) {
		p2=sym.MUL;
	}
	public void visit(MulopDiv mul) {
		p2=sym.DIV;
	}
	public void visit(MulopMod mul) {
		p2=sym.MOD;
	}
	
	public void visit(ExprMinusNoTermList a) {
		Code.put(Code.neg);
	}
	
	public void visit(ExprMinus a) {
		//Code.put(Code.neg);
	}
	
	public void visit(TermNoMulop term) {
		if(term.getParent().getClass()==ExprMinus.class) {
			Code.put(Code.neg);
		}
	}
	public void visit(TermYesMulop term) {
		if(term.getParent().getClass()==ExprMinus.class) {
			Code.put(Code.neg);
		}
	}
	
	
	public void visit(DesignatorStmt1 designator) {
		if(designator.getOpp().getClass()==Opp3.class) {
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(designator.getDesignator().obj);
		}
		if(designator.getOpp().getClass()==Opp4.class) {
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.store(designator.getDesignator().obj);
		}
	}
	
	
	public void visit(DesignatorStmt2 designator) {
		
		//Code.load(designator.getDesignator().obj);
		//Code.put(Code.arraylength);
		//Obj pomocni=new Obj(Obj.Var, "skrt",new Struct(Struct.Int ));
		//Code.store(pomocni);
		Obj obj2=new Obj(Obj.Elem, "$", new Struct(Struct.Int) );
		Obj obj=designator.getDesignator().obj;
		for(int i=brojacStmt2-1;i>=0;i--) {
			if(nizStmt2[i]==Tab.noObj) {
				
			}
			else{
				
				Code.load(obj);
				Code.loadConst(i);
				Code.load(obj2);
				Code.store(nizStmt2[i]);
			}
		}
		
		
		brojacniz=0;
		brojacStmt2=0;
		//Code.loadConst(brojacniz);
		//Code.loadConst(brojacStmt2);
	}
	
	public void visit(DesignatorFormExist designatorForm) {
		if(designatorForm.getParent().getClass()==DesignatorStmt2.class) {
			nizStmt2[brojacStmt2]=designatorForm.getDesignator().obj;
			brojacniz++;
			brojacStmt2++;
		}
		
		if(designatorForm.getParent().getClass()==DesignatorFormListExist.class) {
			nizStmt2[brojacStmt2]=designatorForm.getDesignator().obj;
			brojacniz++;
			brojacStmt2++;
		}
	}
	
	/*if(designatorForm.getParent().getClass()==DesignatorStmt2.class) {
			if(designatorForm.getDesignator().obj==Tab.noObj) {
				brojacStmt2++;
			}
			else {
				nizStmt2[brojacniz]=designatorForm.getDesignator().obj;
				brojacniz++;
			}
		}*/
	public void visit(NoDesignator designatorForm) {
		if(designatorForm.getParent().getClass()==DesignatorStmt2.class) {
			nizStmt2[brojacStmt2]=Tab.noObj;
			brojacStmt2++;
		}
		if(designatorForm.getParent().getClass()==DesignatorFormListExist.class) {
			nizStmt2[brojacStmt2]=Tab.noObj;
			brojacStmt2++;
		}
	}
}
