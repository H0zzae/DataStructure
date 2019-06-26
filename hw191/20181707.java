import java.util.*;

 

/**

 * Maze Class

 * 

 */

 

class Maze {

   private int[][] maze;   // 2 dim array for maze
   private int[][] mark;   // 2 dim array for visit marking

   
   public Maze(int m, int p) {
      maze = new int[m + 2][p + 2];
      mark = new int[m + 2][p + 2];
      for(int i = 0; i < m + 2; i++)
         for(int j = 0; j < p + 2; j++) {
            maze[i][j] = 1;
            mark[i][j] = 0;
         }
   }

 

   // create the maze structure

   public void SetWall(int i, int j, int val) {
      maze[i][j] = val;
	}

 

   public void Path(int m, int p) {
       int MAXD = 8;
       int direction[][] = { {0,1}, {1,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0} };
       Stack<Integer> mp = new Stack<> ();   
       Stack<Integer> mm = new Stack<> ();  
       Stack<Integer> y = new Stack<> ();   
       Stack<Integer> x = new Stack<> ();   

       int i=1, j=1;   
       int g=0, h=0; 

       boolean goal = false, goal1 = false;   

       mm.push(j);

       mp.push(i);  

       while((goal!=true) && (goal1!=true)) {  
      	for(int n=0; n<MAXD; n++) {
	  g = i + direction[n][0]; 
	  h = j + direction[n][1]; 
          if(g==m && h==p) { 
         	if(maze[m][p]==1) {   
             		goal1 = true;
             		break;
         		}
         	mp.push(g); 
		mm.push(h);   
         	while(!mp.empty() && !mm.empty()) {   
                   y.push(mp.pop()); 
		   x.push(mm.pop());

                  }

                while(!y.empty() && !x.empty()) { 
                   System.out.println("(" + y.pop() + "," + x.pop() + ")");
                  }
         goal=true;  

         break;

          }

        if((maze[g][h]==0) && (mark[g][h]==0)) { 

         mark[g][h]=1;   

         mp.push(g); 
	 mm.push(h);  

         i = g; 
	 j = h;   

         break;

          }

          if(n==MAXD-1) {    
         mp.pop(); 
	 mm.pop();   

         i = mp.peek();  
	 j = mm.peek(); 
         break;
          }
      }       

    }
       if((goal==false) || (goal1==true)) {
	System.out.println("No path in the maze.");}   
   }
};
