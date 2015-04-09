
public class EvalVisitor implements ASTVisitor{

	@Override
	public double visit(Constant node) {
		return node.getValue();	
	}

	@Override
	public double visit(Operator node) {
		double left = node.getLeft().accept(this);
		double right = node.getRight().accept(this);
		return node.getOp().apply(left,right);
		
	}
	
	@Override
	public double visit(ExponentationOperator node){
		double left = node.getLeft().accept(this);
		double right = node.getRight().accept(this);
		return node.getOp().apply(right,left);
		
	}
	
	@Override
	public double visit(Function node){
		double argument = node.getArg().accept(this);
		return node.getOp().apply(argument);
		
	}

	@Override
	public double visit(UnaryMinus node) {
		return node.getValue();	
	
	}
	
	

}
