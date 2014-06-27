package metrics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ast.ClassObject;
import ast.SystemObject;
import ast.inheritance.InheritanceDetection;
import ast.inheritance.InheritanceTree;
/**
 * 
 * @class NOC
 * @version 1.1
 * @author SOHAN
 */
public class NOC 
{	
	// java.util.Map to store NOC of each class
	private Map<String,Integer> nocMap;
		
	/**
	 *constructor which takes system object 
	 * @param system
	 */
	public NOC(SystemObject system)
	{
		//create instance of java.util.Map
		nocMap = new HashMap<String, Integer>();
		
		Set<ClassObject> classes = system.getClassObjects();
		
		// for each class in system compute the NOC of class
		for(ClassObject classObject : classes) 
		{
			int noc = ComputeNOC(classObject, system);
			nocMap.put(classObject.getName(), noc);
		}
	}
	/**
	 * Computes the NOC of class
	 * @param classObj
	 * @param systemObj
	 * @return NOC count
	 */
	public int ComputeNOC(ClassObject classObj, SystemObject systemObj)
	{
		int count = 0;
		//create InheritanceDectection class object to generate Inheritance hierarchy
		InheritanceDetection dect = new InheritanceDetection(systemObj);
		
		//returns the InheritanceTree object for a className passed as parameter
		InheritanceTree tree = dect.getTree(classObj.getName());
		
		//check if there is inheritance to avoid run time null pointer exception
		if(tree !=null)
		{
			count = tree.getRootNode().getChildCount();
		}
		return count;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String key : nocMap.keySet()) {
			sb.append(key).append("\t").append(nocMap.get(key)).append("\n");
		}
		return sb.toString();
	}

}
