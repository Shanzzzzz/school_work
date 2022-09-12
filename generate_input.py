from random import randint
from xml.etree.ElementTree import tostring

sizes = [1000, 5000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000]

for s in sizes:
    filename = str(s) + ".txt"
    f = open(filename, "w")
    
    for i in range(0, s):
        temp = randint(1, s)
        f.write(str(temp) + ",")
    f.close()

    #print("Generating dataset of",s,"integers")

f = open("1000.txt", "r")
text = f.read()
