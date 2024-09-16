my_str = input()

my_number = []
my_operator = []

i=0
while i <len(my_str):
    temp = ''
    if my_str[i] == '+' or my_str[i] =='-':
        temp_operator = my_str[i]
    while my_str[i]>='0' and my_str[i]<='9':
        if i >= len(my_str) -1: 
            temp += str(my_str[i])
            break
        temp= temp + str(my_str[i])
        i+=1
    
    if i >= len(my_str):
        break
    my_number.append(int(temp))
    if i < len(my_str)-1: my_operator.append(my_str[i])
    i+=1

result = my_number[0]

i = 1

while i <len(my_number):
    
    if len(my_operator) ==1:
        if my_operator[0] == '+':
            result +=my_number[1]
        else:
            result -=my_number[1]
            
        break
    
    if my_operator[i-1] == '-':
        temp_num = 0
         
        if i >= len(my_number)-1:
            temp_num+= my_number[i]
            i+=1   
            result -= temp_num
            continue
        
        while True:
            temp_num+=my_number[i]
            i+=1
            if i >= len(my_number)-1:
                temp_num+= my_number[i]
                i+=1
                break
            if my_operator[i-1]=='-' : break
        result -= temp_num
    else:
        result +=my_number[i]
        i+=1
print(result)
        
    