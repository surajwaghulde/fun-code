package LinkedList;

import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.Stack;


public class SpreadSheet {
	
	private String [] [] expressions;
	
	private int rows;
	private int columns;

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	private class Expression {
		
		private StringTokenizer strtok;
		private String inputExpression;
		private Stack<Float> expressionStack = new Stack<Float>(); 
		
	    private static final int EOL     = 0;
	    private static final int OPERAND   = 1;
	    private static final int MULTIPLICATION   = 2;
	    private static final int DIVISION     = 3;
	    private static final int ADD    = 4;
	    private static final int MINUS   = 5;
	    private static final int REFERENCE = 6;
	    private static final int UNARYADD = 7;
	    private static final int UNARYMINUS = 8;
	    
	    private class Precedence    {
	        public int prec;
	        public Precedence( int prec)
	        {
	        	this.prec = prec;
	        }
	    }
	    
	    private Precedence [ ] precTable = new Precedence[ ]
	    {
	        new Precedence(-1), 
	        new Precedence(0),  
	        new Precedence(2),  
	        new Precedence(2),  
	        new Precedence(2),  
	        new Precedence(2),
	        new Precedence(1),
	        new Precedence(10),
	        new Precedence(10)
	    };

	    private class Token {
	        public Token() {
	            this(EOL);
	        }
	        
	        public Token(int t) {
	            this(t, 0);
	        }
	        
	        public Token( int t, float v ) {
	            type = t;
	            value = v;
	        }
	        
	        public int getType() {
	            return type;
	        }
	        
	        public float getValue( ) {
	            return value;
	        }
	        
	        private int type = EOL;
	        private float value = 0.0f;
	    } 

	    
	    
	    public Expression(String str) {
	    	this.inputExpression = str;
	    	strtok = new StringTokenizer(str, " ", true);
	    }
	    
        public Token getToken( )
        {
            float theValue;           

            if( !strtok.hasMoreTokens( ) )
                return new Token(EOL);

            String s = strtok.nextToken( );
            if( s.equals( " " ) ) return getToken();
            if( s.equals( "/" ) ) return new Token(DIVISION);
            if( s.equals( "*" ) ) return new Token(MULTIPLICATION);
            if( s.equals( "+" ) ) return new Token(ADD);
            if( s.equals( "-" ) ) return new Token(MINUS);
            if( (s.charAt(0) > 64 && s.charAt(0) < 91)) {
            	s = getReference(s);
            	if ( s.equals( " " ) ) {
            		return new Token(REFERENCE);
            	}
            }

            try {
            	theValue = Float.parseFloat(s); 
            }
            catch( NumberFormatException e )
            {
                System.err.println("Parse error NumberFormatException ");
                return new Token( );
            }
            
            return new Token(OPERAND, theValue);
        }
	    
        public String evaluate() {
        	Token token = getToken();
        	int operation = token.getType();
        	while (operation != EOL) {
        		if (operation == OPERAND) {
            		expressionStack.push(token.getValue());
            	}
            	else {
            		switch(operation) {
            			case DIVISION : 
            				expressionStack.push(expressionStack.pop() / expressionStack.pop());
            				break;
            			case MULTIPLICATION : 
            				expressionStack.push(expressionStack.pop() * expressionStack.pop());
            				break;
            			case ADD :
            				expressionStack.push(expressionStack.pop() + expressionStack.pop());
            				break;
            			case MINUS :
            				expressionStack.push(expressionStack.pop() - expressionStack.pop());
            				break;
            			case UNARYADD :
            				expressionStack.push(expressionStack.pop()+1);
            				break;
            			case UNARYMINUS :
            				expressionStack.push(expressionStack.pop()-1);
            				break;
            			default :
            				return inputExpression;
            		}	
            	}	
        		token = getToken();
            	operation = token.getType();
        	}
        	return String.format("%.5f", expressionStack.pop());
        }		
	}    

	
	public void createSpreadSheet(String str) {
		StringTokenizer strtok = new StringTokenizer(str);
		if (strtok.hasMoreTokens()) {
			rows = Integer.parseInt(strtok.nextToken());
		}
		else {
			System.err.println("Please enter the number of rows");
		}
		if (strtok.hasMoreTokens()) {
			columns = Integer.parseInt(strtok.nextToken());
		}
		else {
			System.err.println("Please enter the number of columns");
		}
		expressions = new String [rows] [columns];
	}
	
	public void putValue(int i, String value) {
		int row = i / rows;
		int column = i % rows;
		expressions [row] [column] = value;
	}
	
	public void print() {
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println(expressions [i] [j]);
			}
		}
	}
	
	private String getReference(String s) {
		char startChar = s.charAt(0);
		int row = startChar - 'A';
		int column = Integer.parseInt(s.substring(1));
		String value = expressions[row] [column];
		if (value == null) {
			return " ";
		}
		if (value.charAt(0) > 64 && value.charAt(0) < 91) {
			return getReference(value);
		}
		else {
			return value;
		}
	}
	
	public void solveExressions() {
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				String e = expressions [i] [j];
				String expression = null;
				char startChar = e.charAt(0);
				int row = startChar - 'A';
				int column = Integer.parseInt(e.substring(1));
			}
		}
	}
	
	public static void main(String[] args) {
		SpreadSheet spreadSheet = new SpreadSheet();
        String inputString;
        Scanner in = new Scanner( System.in );

        // Read the size of the spreadsheet
        inputString = in.nextLine( );
        spreadSheet.createSpreadSheet(inputString);
        
        int i = 0;
        while( in.hasNextLine( ) )
        {
            inputString = in.nextLine( );
            Expression expression = spreadSheet.new Expression(inputString);
            spreadSheet.putValue(i++, expression.evaluate());
            if (i == spreadSheet.getColumns() * spreadSheet.getRows()) {
            	spreadSheet.print();
            	
            	break;
            }                        
        }        
	}
}
