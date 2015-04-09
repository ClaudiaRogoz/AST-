public class Operator implements AST{

	private Operators op;
	private AST left;
	private AST right;
	
	public double getValue(){
		return op.apply(left.getValue(), right.getValue());
	}
	
	public Operator(AST left, Operators op, AST right){
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	public Operators getOp(){
		return op;
	}
	
	@Override
	public double accept(ASTVisitor visitor) {
		return visitor.visit(this);		
	}

	public AST getLeft() {
		return left;
	}

	public void setLeft(AST left) {
		this.left = left;
	}

	public AST getRight() {
		return right;
	}

	public void setRight(AST right) {
		this.right = right;
	}
}
