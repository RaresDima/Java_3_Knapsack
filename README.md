# Java_3_Knapsack

Consider a knapsack of a given capacity and a set of items that could be added in the knapsack, for example books, food, weapons, etc. Each item has at least the following properites: a name, a weight and a value. The profit factor of an item is defined as value / weight. The problem is to determine what items to include in the knapsack such that:

the total weight of the selected items is less than or equal to the capacity and
the total value is as large as possible.

The implementation contanins a simple greedy algorithm, a random one, and a more complex, 0/1 pseudo-polynomial time using dynamic programming to eliminate time lost on recursivity.

A method for a sample population is fiven for testing purposes, along with a random object generator to test time and space usage on large instances. 
