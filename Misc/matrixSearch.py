# Integers in each row are sorted from left to right.
# The first integer of each row is greater than or equal to the last integer of the previous row.

from __future__ import print_function
import sys
import os




def printMatrix(matrix):
	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			print(matrix[i][j], end="  ")
		print()

def searchMatrix(matrix, number):
	if not matrix:
		return 0
	printMatrix(matrix)

	rows = len(matrix)
	cols = len(matrix[0])
	list = []

	for i in range(rows):
		for j in range(cols):
			list.append(matrix[i][j])

	start = 0
	end = len(list) - 1
	while start <= end:
		mid = (start  + end ) / 2
		if list[mid] == number:
			return 1
		elif list[mid] < number:
			start = mid + 1
		else:
			end = mid - 1
	return 0


matrix = [[1,   3,  5,  7],[10, 11, 16, 20], [23, 30, 34, 50]]
number = 20
res = searchMatrix(matrix, number)

resStr = "Number found!" if res == 1 else "Number not found"

print(resStr)