
Project: mazeGenerator
Author: Kienen Wayrynen
Student ID: 11430827
Contact: kienen.wayrynen@wsu.edu
Created: December 9, 2015

Description:
The mazeGenerator project uses a depth first search algorithm to create random maze for the specified parameter.

Included in this JAR File:
- Graph.java
	- This .java file included features a interface with functions that the mazeGraph.java file provides. 	
	The methods included in this interface include numVerts and adjacent, taking a integer v, 	
	which is a vertex of a particular node in an undirected graph.
- mazeGraph.java
	- This .java file includes functions regarding the adjacent and numVerts methods in the interface 	
	Graph. Also provided in this function are constructors which help numVerts and adjacent.
- graphSearch.java:
	- The graphSearch.java file includes a depth first search algorithm similar to Dijkstra\'92s algorithm. 	
	Depth first search basically steps through a given undirected graph at a particular starting point 	
	and explores as far as possible along each node in the graph before backtracking.
- mazeGen.java:
	- This .java file incorporates a function mazeEncodeAndDecode. This function takes care of adding and 	
	deleting the walls in the provided graph. mazeEncodeAndDecode takes the parameters height width and an 
	integer array. This file also includes a main method that outputs a text file with an array of numbers that 	
	identifies how many walls the generated maze will have.