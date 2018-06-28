from __future__ import print_function
import sys
from collections import defaultdict
import os


def parseInput(arr):
	l = []
	charArr = arr.split(" ")
	for i in charArr:
		l.append(int(i))

	return l

def printList(list):
	for i in list:
		print(i, end=" ")

def countSort(arr):
	length = len(arr)
	freq = [0 for i in range(100)]
	res = [0 for i in range(length)]
	count = 0
	for i in arr:
		freq[i] = freq[i] + 1
	
	for i in range(1, 100):
		freq[i] = freq[i] + freq[i-1]
	
	lastIdx = 0
	idx = 0
	
	while idx < 100:
		val = freq[idx]
		for i in range(val-1, lastIdx-1, -1):
			res[i] = idx
		lastIdx = val
		idx += 1

	return res




testCaseStr = "63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33"

arr = parseInput(testCaseStr)
print("Before Sorting...")
printList(arr)
print("After Sorting...")
arr = countSort(arr)
printList(arr)