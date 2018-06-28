def findDiff(arr):
	min = arr[0]
	max = arr[0]

	for num in arr:
		if num < min:
			min = num
		elif num > max:
			max = num

	return max - min

arr = [9, 2, 3, 4 ,2, 12, 3,4]

print(findDiff(arr))
