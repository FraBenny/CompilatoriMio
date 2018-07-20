package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FOOLlib {
  
  private static int labCount=0; 
  
  private static int funLabCount=0; 

  private static String funCode=""; 
  
  private static HashMap<String, ArrayList<DispatchTableEntry>> dispatchTables = new HashMap<>();
  
  public static String freshLabel() { 
	return "label"+(labCount++);
  } 

  public static String freshFunLabel() { 
	return "function"+(funLabCount++);
  } 
  
  public static void putCode(String c) { 
    funCode+="\n"+c; //aggiunge una linea vuota di separazione prima di funzione
  } 
  
  public static String getCode() { 
    return funCode;
  } 

public static String freshDispatchTableLabel(String classID) {
        return "class" + classID;
    }
 public static void addDispatchTable(String classID, ArrayList<DispatchTableEntry> dt) {
        dispatchTables.put(classID, dt);
    }
// Viene ritornata una copia della dispatch table (così non si modifica, per riferimento, la dt del padre)
    public static ArrayList<DispatchTableEntry> getDispatchTable(String classID) {
        ArrayList<DispatchTableEntry> copy = new ArrayList<>();
        ArrayList<DispatchTableEntry> original = dispatchTables.get(classID);
        for (DispatchTableEntry originalDtEntry : original) {
            DispatchTableEntry copiedDtEntry = new DispatchTableEntry(originalDtEntry.getMethodID(), originalDtEntry.getMethodLabel());
            copy.add(copiedDtEntry);
        }
        return copy;
    }

    public static String getDispatchTablePointer(String classID) {
        return "push " + freshDispatchTableLabel(classID);
    }

    public static String generateDispatchTablesCode() {
        StringBuilder dtCodes = new StringBuilder();
        // For every class
        for (Map.Entry<String, ArrayList<DispatchTableEntry>> dt : dispatchTables.entrySet()) {
            // Creates a DT label
            dtCodes.append(freshDispatchTableLabel(dt.getKey())).append(":\n");
            // For every entry in the DT
            for (DispatchTableEntry entry : dispatchTables.get(dt.getKey())) {
                dtCodes.append(entry.getMethodLabel());
            }
        }
        return dtCodes.toString();
    }

    public static void reset() {
        labCount = 0;
        funLabCount = 0;
        funCode = "";
        dispatchTables = new HashMap<>();
    }

}