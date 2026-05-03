import java.util.Arrays;

public class TypeChecker {
    SymbolTable st= new SymbolTable();

    public void process(String line){
        line=line.trim();
        if (line.isEmpty()){
            System.out.println("Empty input cannot be processed");
            return;
        }

        if(line.startsWith("int")|| line.startsWith("float") || line.startsWith("String")){
            handleDeclaration(line);
        }

        else if(line.contains("=")){
            handleAssignment(line);
        }

        else {
            System.out.println("Not a valid datatype!");
        }
    }

    public void handleDeclaration(String line){
        String[] parts=line.split(" +");  // Handle multiple spaces
        // System.out.println(Arrays.toString(parts));
        if(parts.length < 2 || parts[1].isEmpty()){
            System.out.println("Error: Invalid declaration format");
            return;
        }

        String type=parts[0];
        String var=parts[1].replace(";", "");
        
        if(var.isEmpty()){
            System.out.println("Error: Variable name cannot be empty");
            return;
        }

        boolean added=st.add(var,type);

        if(!added){
            System.out.println("Error: Variable '" + var + "' already declared");
        }

        
    }

    public void handleAssignment(String line){
        String parts[]=line.split("=");
        
        if(parts.length < 2){
            System.out.println("Error: Invalid assignment format - missing '='");
            return;
        }
        
        String left=parts[0].trim();
        String right=parts[1].replace(";","").trim();
        
        if(left.isEmpty() || right.isEmpty()){
            System.out.println("Error: Assignment must have variable on both sides");
            return;
        }

        if(!st.exists(left)){
            System.out.println("Error: "+left +" not declared");
            return;
        }
        
        if(!st.exists(right) && !isLiteral(right)){
            System.out.println("Error: "+right +" not declared");
            return;
        }
        
        String leftType=st.get(left);
        String rightType=inferType(right);
        
        if(rightType.equals("unknown")){
            System.out.println("Error: Cannot infer type of '" + right + "'");
            return;
        }

        if(!isCompatible(leftType,rightType)){
            System.out.println("Type Error: cannot assign "+rightType+ " to "+ leftType);
        }
    }

    public boolean isCompatible(String a, String b){
        if(a == null || b == null)return false;

        if(a.equals(b))return true;

        if(a.equals("float") && b.equals("int"))return true;

        return false;
    }

    public boolean isLiteral(String value){
        return value.matches("[0-9]+") || 
               value.matches("[0-9]+\\.[0-9]+") || 
               value.startsWith("\"");
    }
    
    public String inferType(String value){
        if(value.matches("[0-9]+"))return "int";
        if(value.matches("[0-9]+\\.[0-9]+"))return "float";
        if(value.startsWith("\""))return "String";

        if(st.exists(value))return st.get(value);

        return "unknown";
    }
}
