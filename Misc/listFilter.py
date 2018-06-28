import sys
import os



#uInput = raw_input("Please enter you name: ")
# print "Enter x: "
# x = int(sys.stdin.readline())
# print "Enter y: "
# y = int(sys.stdin.readline())

def lambdaFn(x, y):
	mx = lambda x, y: x if x > y else y
	return mx(x, y)


#print "Max is : ", lambdaFn(x, y)


l = [4, 3, 2, 1]

def mapFn(l):
	print list(map(lambda x: x**2, l))

#mapFn(l)

def filterFn(l):
	print list(filter(lambda x: x > 2, l))

#filterFn(l)

def reduceFn(l):
	print reduce(lambda x, y: x*y, l)

#reduceFn(l)

def show_balances(daily_balances):
	l = len(daily_balances)
	for i in range(l - 3, l - 1):
		print i
		balance = daily_balances[i: i + 2]
		days_ago = l - i
		print days_ago, balance

daily_balances = [107.92, 108.67, 109.86, 110.15]

show_balances(daily_balances)