import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;


public class ExpressionParser {


	public static AST parse(String expression) throws SyntacticException{
		
		int i = 0;
		boolean ok = false;
		Stack<String> operators = new Stack<String>();
		Stack<AST> operands = new Stack<AST>();
		
		
		for (String t : tokenize(expression)){
			
			if ( Operators.parsePrior(t) == -1)
			{	
				
				operands.add(new Constant(Integer.parseInt(t)));
				
				
            }
            else 
            {	
                processOperator(t, Operators.parsePrior(expression), operators, operands);
            }
           
        }
        processRemainingOperators(operators, operands);

        // all operators handled, should be only one operand left, the result
        if (operands.size() !=0)  
        	//throw new SyntacticException("Bad_syntax");
        	System.out.println("no");
		return null;
	}
	
	private static void processRemainingOperators(Stack<String> operators,
			Stack<AST> operands) {
		while (operators.size() > 0)
        {
            String op = operators.pop();
            if (!Operators.isOpenBracket(op))
            {
                operands.add(createExpression(op, operands));
            }
        }
		
	}

	private static void processOperator(String t, int order, Stack<String> operators,
			Stack<AST> operands) throws SyntacticException {
		
		 if (!Operators.isOpenBracket(t))
	        {
	            while (operators.size() > 0 &&
	                   Operators.parsePrior(operators.peek().toString()) >= order)
	            {
	                String op = operators.pop().toString();
	                if (Operators.isOpenBracket(op))
	                {
	                    break;
	                }
	                else
	                {
	                    operands.add(createExpression(op, operands));
	                }
	            }
	        }
		 
	        if (!Operators.isOpenBracket(t))
	        {
	            if (operands.size() > 0 && operands.size() >= operators.size())
	            {
	                operators.push(t);
	            }
	            else
	            {
	                throw new SyntacticException();
	            }
	        }
		
	}


	private static AST createExpression(String op, Stack<AST> operands) {
		// convert operator into expression
		System.out.println("SIZW " + operands.size());
        if (operands.size() > 1)
        {
            AST right = operands.pop();
            AST left = operands.pop();
            //return new AST(op, left, right);
            return null;
        }
        System.out.println("niet");
		return null;
       
	}


	private static AST createExpression(String t) {
		//System.out.println(t);
		return new Constant(Integer.parseInt(t));
	}


	protected static Iterable<String> tokenize( String expression ) {
		return Arrays.asList(expression.split(" "));
		
	}
	
	public float eval(String expression) throws SyntacticException, EvaluatorException{
		
			
		try {
			AST node = parse(expression);
			//System.out.println(node.getValue());
		}
		
		catch (EvaluatorException e){
			System.out.println(e.getMessage());
		}
		
		return 0f;
	}
	
	public static void main(String[] args){
		ExpressionParser p = new ExpressionParser();
		try {
			p.eval("5 - 3");
		} catch (EvaluatorException | SyntacticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
