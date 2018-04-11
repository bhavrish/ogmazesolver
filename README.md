# ogmazesolver
Maze solver.

## personnel
Bhavesh Shah, George Shey

## statement of problem
Return a boolean value of whether there is a path between the start and 'treasure'.

## recursive abstraction
When I am asked to find a path between the start and the 'treasure', the recursive abstraction can find a path to the treasure from the next point. 

## base case
A maze of size 1 hallway would be the base case. 

## English or pseudocode description of algorithm
Base case would solve a maze with only 1 hallway. For mazes that have more than 1 hallway, there would be an if statement that recognizes whether the current position is at a junction. If the if statement returns true, the object would travel up the North path first, and would continue forwards. If the object ultimately hits a barrier, it would recursively backtrack to the previous junction. Once the object is at the junction, it would then take the Eastwards pathway, and would repeat the same procedure. If this also fails, the user would return to the junction and take the Southward path, and if that also fails, then the user would take the Westwards path (in other words, the path the user chooses at the junction would be picked in a clockwise manner).

## class(es), with fields and methods
Maze Class:
1) Constructor that creates a board of size n.
2) Size method.
3) Conditions method (checks to see if object hits wall or not).
4) Tostring method that prints solution to maze.

Maze Solver Class:
1) Method that solves tha maze.

## version*n* wish list
Version 0:
  -find and express if a path between start and destination exists with a boolean value
  -identify key parts of recursion
