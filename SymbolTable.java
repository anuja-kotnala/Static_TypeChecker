import java.util.*;

public class SymbolTable {
    
    HashMap<String,String>table= new HashMap<>();

    public boolean add(String var, String type){

        if(table.containsKey(var)){
            return false;
        }
        table.put(var,type);
        return true;
    }

    public String get(String var){
        return table.get(var);
    }

    public boolean exists(String var){
        return table.containsKey(var);
    }
}
