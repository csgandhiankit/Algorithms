import sys



def minWindow(s, t):
	lenS = len(s)
	lenT = len(t)
	dicT = {}
	dicS = {}
	
	numChars = 0
	while numChars < 128:
		dicT[numChars] = 0
		dicS[numChars] = 0
		numChars += 1

	for i in t:
		idx = ord(i)
		if idx in dicT:
			dicT[idx] = dicT.get(idx) + 1
		else:
			dicT[idx] = 1


	count = 0
	start = 0
	startIdx = -1
	lenMin = sys.maxint
	for I , i in enumerate(s):
		idx = ord(i)
		#print i, " => ", idx
		if idx in dicS:
			dicS[idx] = dicS[idx] + 1
		else:
			dicS[idx] = 1
		
		if  dicT.get(idx) != 0  and  dicS.get(idx) <= dicT.get(idx):
			count += 1

		if count == lenT:
			charIdx = ord(s[start])
			print dicS.get(charIdx), dicT.get(charIdx)
			while dicS.get(charIdx) > dicT.get(charIdx) or dicT.get(charIdx) == 0:
				if dicS.get(charIdx) > dicT.get(charIdx):
					dicS[charIdx] -= 1
				start += 1
				charIdx = ord(s[start])

			len_window = I - start + 1

			if len_window < lenMin:
				lenMin = len_window
				startIdx = start
		

	if startIdx == -1:
		return ""

	
	return s[startIdx : startIdx + lenMin]



s = "ADOBECODEBANC";
t = "ABC";

win = minWindow(s, t)

print "Min Window:", win


		
	