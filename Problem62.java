//Time Complexity: O(n)
//Space Complexity: O(n) for queue
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.*;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class Problem62 {
    public int getImportance(List<Employee> employees, int id) {

        //create a hashmap to keep track of importance of each employee
        //and another for subordinates
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for(Employee emp:employees){
            map1.put(emp.id, emp.importance);
            map2.put(emp.id, emp.subordinates);
        }

        //A queue to keep all the subordinates of the given employee
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);

        int totalImp = 0;

        while(!queue.isEmpty()){
            int empId = queue.poll();
            totalImp += map1.get(empId);
            if(map2.get(empId)!=null){
                for(int emp:map2.get(empId))
                    queue.add(emp);
            }
        }

        return totalImp;
    }
}
