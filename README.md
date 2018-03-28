# ogmazesolver
Maze solver.

## personnel
Bhavesh Shah, George Shey

## statement of problem
Does the boolean value of whether or not a path between the start and 'treasure' of the maze exists return true?

## recursive abstraction
If asked to solve a maze, the recursive abstraction can solve a maze of size n-1 hallways. 

## base case
A maze of size 1 hallway would be the base case. 

## English or pseudocode description of algorithm
Base case would solve a maze with only 1 hallway. For mazes that have more than 1 hallway, there would be an if statement that recognizes whether the current position is at a junction. If the if statement returns true, the object would travel up the North path first, and would continue forwards. If the object ultimately hits a barrier, it would recursively backtrack to the previous junction. Once the object is at the junction, it would then take the Eastwards pathway, and would repeat the same procedure. If this also fails, the user would return to the junction and take the Southward path, and if that also fails, then the user would take the Westwards path (in other words, the path the user chooses at the junction would be picked in a clockwise manner).

## class(es), with fields and methods


## version*n* wish list
Version 0:
  -find and express if a path between start and destination exists with a boolean value
  -identify key parts of recursion
