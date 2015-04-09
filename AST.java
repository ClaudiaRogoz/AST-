public interface AST {

	public abstract double getValue();
	public double accept(ASTVisitor visitor);

}
