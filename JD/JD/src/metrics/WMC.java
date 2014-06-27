package metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ast.ClassObject;
import ast.MethodObject;
import ast.SystemObject;
import ast.decomposition.CompositeStatementObject;
/**
 * implements Weighted methods per class. 
 * @author Hiren
 *
 */
public class WMC {
	
	
	
	 // wmcMap is HashMap which is used to store class name and its value of WMC. 
	 
	private Map<String, Integer> wmcMap;
	

	public WMC(SystemObject system) {
		// TODO Auto-generated constructor stub
		wmcMap=new HashMap<String,Integer>();
		
		Set<ClassObject> classes = system.getClassObjects();
		
		for(ClassObject classObject : classes) {
			int value_of_wmc = computationOfWMC(classObject);
			if(value_of_wmc != -1) {
				wmcMap.put(classObject.getName(), value_of_wmc);
			}
		}
	}
/**
 *  computes CyclomaticComplexity of each class.
 * 1.1 
 * @param classObject
 * @return total CyclomaticComplexity of each class 
 */
	private int computationOfWMC(ClassObject classObject) {
		// TODO Auto-generated method stub
		// totalCyclomaticComplexity is defined to store total CyclomaticComplexity of class. 
		int totalCyclomaticComplexity=0;
		//list named as methods stores all methods list in class.
		
		List<MethodObject> methods = classObject.getMethodList();
		
		/*
		 * no need to find complexity if there is no methods in class.
		 */
		if(methods.size()==0)
			System.out.println("no methods available.doesn't make sence for cyclomatic complexity");
		int k=0,D=0;
	/*
	 * traversing entire list of all methods to find CyclomaticComplexity of each method
	 */
		while(k!=methods.size())
		{
			MethodObject mI = methods.get(k);
			// eachMethodCC variable stores CyclomaticComplexity of each method 
			int eachMethodCC=0;
			if(mI.getMethodBody()!=null)
			{
					CompositeStatementObject cobj=mI.getMethodBody().getCompositeStatement();
					/*
					 * list of list named ctrl_state_List store list of all control statements as if,for,while,switch etc.
					 */
					List<List<CompositeStatementObject>> ctrl_state_List=new ArrayList<List<CompositeStatementObject>>();
					ctrl_state_List.add(cobj.getIfStatements());
					ctrl_state_List.add(cobj.getSwitchStatements());
					ctrl_state_List.add(cobj.getWhileStatement());
					ctrl_state_List.add(cobj.getDoStatements());
					ctrl_state_List.add(cobj.getForStatements());
					//computing size of each individual list of all control statements 
					for(int i=0;i<ctrl_state_List.size();i++)
					{
							D=D+ctrl_state_List.get(i).size();
					}
					eachMethodCC=D+1;
					
			}
			totalCyclomaticComplexity=totalCyclomaticComplexity+eachMethodCC;
			k++;
		}
		return totalCyclomaticComplexity;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String key : wmcMap.keySet()) {
			sb.append(key).append("\t").append(wmcMap.get(key)).append("\n");
		}
		return sb.toString();
	}

	
}
