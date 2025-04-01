The Mars Rover
The surface of Mars is represented by a Plateau and the Rover navigates the Plateau by following a sequence of commands from the user.

The Plateau
The Plateau is divided into a grid.

The lower-left coordinate is (0, 0).

The Rover position
The Rover's position is represented by x and y co-ordinates and the letters N, S, W, E to represent North, South, West, East (the four cardinal compass points) respectively.

Example
input: 0 0 N
output: the Rover is at the bottom-left corner facing in the North direction.

The square directly North from (x, y) is (x, y + 1), and the square directly East from (x, y) is (x + 1, y)

Program Inputs
First Line: Plateau Creation
The first line inputted into the program represents the upper-right coordinates of the Plateau.

Example: 
input: 5 5
output: plateau has maximum (x, y) co-ordinates of (5, 5), and is therefore a Plateau of size (6,6).

Subsequent lines: Rover Creation & Instructions
Following the plateau creation, each Rover receives two lines of input. 

(1) Input places the Rover at a particular starting position, e.g. 1 2 N lands the Rover at position (1,2) facing North.
(2) String of letters input represents instructions to move the Rover around the Plateau.

Instructions
To move a Rover around the Plateau, a string of letters is sent to a Rover.

Letter	Action
L	Spins the Rover 90 degrees left without moving from the current coordinate point
R	Spins the Rover 90 degrees right without moving from the current coordinate point
M	Moves the Rover forward by one grid point, maintaining the same heading/orientation

Output
The output represents the Rover's position: the coordinates and where it is facing.