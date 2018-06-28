import sys
import pdb

def sqrtFn(number):
	if number == 0 or number == 1:
		return number
	start = 0
	end = number / 2
	ans = 0
	while start <= end:
		mid = (start + end) / 2
		sq = mid * mid 
		if sq == number:
			return mid
		elif sq < number:
			start = mid + 1
			ans = mid
		else:
			end = mid - 1
	return ans


print "Please enter an integer: "
number = int(sys.stdin.readline())
sq = sqrtFn(number)
print "Sqrt of", number, "is ", sq