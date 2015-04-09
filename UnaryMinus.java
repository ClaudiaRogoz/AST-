
public class UnaryMinus implements AST {
	AST node;
	
	UnaryMinus(AST node){
		assert node != null;
		this.node = node;
	}
	
	@Override
	public double getValue() {
		return -node.getValue();
	
	}

	@Override
	public double accept(ASTVisitor visitor) {
		return visitor.visit(this);
		
	}
	

}
