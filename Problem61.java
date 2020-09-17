//Time Complexity: O(n)
//Space Complexity: O(n) for queue
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.*;
class Pair1{
    int key;
    int value;

    public Pair1(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int get(int key){
        return this.value;
    }
}
public class Problem61 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //use a queue for traversal and add initial rotten oranges
        Queue<Pair1> queue = new LinkedList<>();

        //count total fresh oranges
        int freshOranges = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)
                    freshOranges += 1;
                else if(grid[i][j]==2)
                    queue.add(new Pair1(i,j));
            }
        }

        if(freshOranges==0)
            return 0;

        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        int minutes = -1;
        //level order traversal
        //basically we return no of levels
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair1 top = queue.poll();

                //check if there are any fresh oranges in all the directions
                for(int[] dir:directions){
                    int x = top.key + dir[0];
                    int y = top.value + dir[1];

                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y] = 2;
                        queue.add(new Pair1(x,y));
                        freshOranges -= 1;
                    }
                }
            }

            minutes += 1;

        }

        if(freshOranges==0)
            return minutes;

        return -1;
    }
}
