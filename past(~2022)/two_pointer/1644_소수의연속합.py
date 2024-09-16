n = int(input())

prime_array= [1 for i in range(4000001)]

prime_array[0]=0
prime_array[1]=0

for i in range(2,4000001):
    if prime_array[i] == 1:
        j=i
        while True:
            j+=i
            if j >=4000001: break
            prime_array[j] = 0
start = 0
end = 0
result = 0
temp = 0

while True:
    if temp >= n:
        
        if temp == n : result+=1
        
        while True:
            start+=1
            
            if start >=len(prime_array):
                print(result)
                exit()
                
            if start > n : 
                print(result)
                exit()
                
            if prime_array[start] ==1 : break
        
        temp-=start
        
    else:
        while True:
            end+=1
            
            if end >= len(prime_array) : 
                print(result)
                exit()
        
            if end > n :
                print(result)
                exit()
            
            if prime_array[end] ==1 : break
        
        temp+=end

print(result)