# ogmazesolver
Maze solver.

## personnel
Bhavesh Shah, George Shey

## statement of problem
Return a boolean value of whether there is a path between the start and 'treasure'.

## recursive abstraction
When I am asked to find a path between the start and the 'treasure', the recursive abstraction can find a path to the treasure from the next point. 

## base case
The base case would be when the explorer is on a wall (return false), or if the explorer is on the treasure (return true). 

## English or pseudocode description of algorithm
Base case would solve a maze of size 1. For other mazes, the explorer would check to see if the next point is a legal point (not a wall, inside maze, etc.). The next point would be chosen in a clockwise manner (North, East, South, West). Once the explorer is on the next point, the recursive solution would try to find a path to the treasure from that new point. There would also be a variable called wasHere that would be set as true when an explorer leaves a point, so that if the explorer ends up at that point once again, the function would terminate. 

## class(es), with fields and methods
Maze Class:
1) Constructor that creates a board of size n.
2) Size method.
3) Conditions method (checks to see if object hits wall or not).
4) Tostring method that prints solution to maze.

UserOfMazeSolver Class:
1) Recursive method to find if there is a solution to the treasure in the maze.

## version*n* wish list
Version 0:
  -find and express if a path between start and destination exists with a boolean value
  -identify key parts of recursion
Version 1:
  -establish code for the recursive case, invoked if the explorer is on a stepping stone
  -create a section of recursiveSolve that takes a snapshot of the current maze

## known bugs
Version 0's base cases work. The recursive solution still needs some modification and is under development.
