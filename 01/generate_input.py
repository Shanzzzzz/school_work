from random import randint
from xml.etree.ElementTree import tostring

sizes = [1000, 5000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000]
limit = (pow(2,32)-1) // 2

for s in sizes:
    filename = "01/input/" + str(s) + ".txt"
    f = open(filename, "w")
    
    for i in range(0, s):
        temp = randint(1, limit)
        f.write(str(temp) + ",")
    f.close()

