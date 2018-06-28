import os
import sys


def countScripts(path):
	total = 0
	for root, dirs, files in os.walk(path):
		total += len(files)
	print(total)
	# cpt = sum([len(files) for r, d, files in os.walk(path)])
	# print("Algorithm Count: " + str(cpt))



countScripts(sys.argv[1])