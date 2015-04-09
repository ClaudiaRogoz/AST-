
public class Test {
	public static void main(String[] args){
		AST tree = new Operator(new Constant(8),Operators.MULT,	new Operator( new Constant(5) ,Operators.PLUS, new Constant(2 ) ));
		System.out.println(tree.accept(new EvalVisitor()));
		System.out.println("asjcx");
		AST t = new Operator(new Constant(3),Operators.PLUS,new ExponentationOperator(new Constant(2),Operators.POW,new ExponentationOperator(new Constant(3),Operators.POW,new Constant(1))));
		System.out.println(t.accept(new EvalVisitor()));
		AST tr = new Operator(new Constant(1), Operators.PLUS, new Operator (new Constant (2), Operators.MINUS, new Operator(new Constant(3) , Operators.MULT, new Operator(new Constant(4), Operators.PLUS,new Constant(5))) ));
		System.out.println(tr.accept(new EvalVisitor()));
		AST te = new Operator (new Constant(-2), Operators.MULT,new Function(new Operator(new Constant(-1),Operators.DIV,new Constant(1)),Operators.SIN));
		System.out.println(te.accept(new EvalVisitor()));
	}
}
