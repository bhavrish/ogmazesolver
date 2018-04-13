import java.util.Scanner;

public class MazeSolver {
    private final static int[] dirlist = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};
    
    //public MazeSolver () {		
	//	solvedMazes = new ArrayList<Maze>();
	//}
    
    public boolean recursiveSolve(Maze unsolvedMaze) {
        // explorer on a wall
	if(unsolvedMaze.explorerIsOnA() == Maze.WALL) {
		return false;
	}
	
	// explorer on the treasure
	else if(unsolvedMaze.explorerIsOnA() == Maze.TREASURE) {
		return true;
	}
	
	// recursive case
	/**else if(current.explorerIsOnA() == Maze.STEPPING_STONE) {
		
		// create snapshot of unsolvedMaze
		Maze snapshot = new Maze(unsolvedMaze);
		
		// move explorer in every possible direction
		for (int n = 1; n < 9; n = n*2) {
			unsolvedMaze.go(n);
			//explorer on treasure
			if(recursiveSolve(unsolvedMaze)) == true{
				//input code to record solution
				//how do we update n so that when recursiveSolve is recursively called on the snapshot the explorer does not move in the same direction
			}
			recursiveSolve
		}
	}
	return false; //unsolved
	**/
    }

		

        /**else {
            maze.dropA(Maze.WALL);
            Maze snapshot = new Maze(maze);
            for(int dir=0; dir<dirlist.length(); i++) {
                maze.go(dir);	
            	if (recursiveSolve(maze)==false){						
                	maze= new Maze(snapshot);		
                	displayerTest(maze);
            	}
            	else return true;				          																							//					return true :)
            }
            return false;
     }
    }
    **/
}
