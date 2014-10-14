Meta:

Narrative:
As a user
I want to determine the area of all shapes placed on a board
So that I can impress my instructor

Scenario: empty board has covered area of zero
Given an empty board
When no shapes are added
Then the area of shapes on the board is 0

Scenario: determine area for board with a square
Given an empty board
When a square with a side of length 2 is added
Then the area of shapes on the board is 4

Scenario: determine area for board with a circle
Given an empty board
When a circle with a radius of length 3 is added
Then the area of shapes on the board is 28.27

Scenario: determine area for board with multiple objects
Given an empty board
When a circle with a radius of length 4 is added
And a square with a side of length 5 is added
Then the area of shapes on the board is 75.27

Scenario: determine area for board after removing an object
Given a board with a circle with radius 100 and two squares of length 10 and 5
When the circle is removed
Then the area of shapes on the board is 125
