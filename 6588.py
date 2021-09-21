import sys
import math

primes = [True for _ in range(1000001)]

for i in range(2, int(math.sqrt(1000001))+1):
        if primes[i] == True:
            for j in range(i + i, 1000001, i):
                primes[j] = False

while True:
    isprint = False;
    n = int(input())
    if n==0 : break

    for i in range(3,int((n/2)+1),2) :
        if primes[i] and primes[n-i] :
            print("%d = %d + %d" %(n,i,n-i))
            isprint=True
            break

    
    if isprint == False :
        print("Goldbach's conjecture is wrong")
