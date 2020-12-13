import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class Code
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
    	Scanner s=new Scanner(System.in);
        //First Employee
    	System.out.println("Enter employee_id");
    	String id=s.next();
    	System.out.println("Enter employee_name");
    	String name=s.next();
    	
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("id", id);
        employeeDetails.put("name",name);
        
        
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        
        //Write JSON file
        try (FileWriter file = new FileWriter(id+".json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
       //to get value
       System.out.print("Enter key to retrieve value");
       String key_name=s.next();
       System.out.println(employeeDetails.get(key_name));
       
       //to delete key value pair
       System.out.println("Enter key that needs to be removed");
       String del=s.next();
       if (employeeDetails.containsKey(del)) {
    	   employeeDetails.remove(del);
       }
       else 
       {
    	   System.out.println("No such key found");
       }
       
       
       
    }
}

