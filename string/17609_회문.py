from sys import stdin
def judge(temp):
    rev_temp = temp[::-1]
    if rev_temp == temp:
        return 1
    else: return 0

def check(temp_word):
    start_point = 0
    end_point = len(temp_word) - 1
    while True:
        if start_point > end_point : break
    
        if temp_word[start_point] == temp_word[end_point]:
            start_point+=1
            end_point -=1
        else:
            if temp_word[start_point+1] == temp_word[end_point] and temp_word[start_point] == temp_word[end_point-1]:
                a=judge(temp_word[start_point+1:end_point+1])
                b=judge(temp_word[start_point:end_point])
                if a==1 or b==1: return 1
                else: return 2
                
            elif temp_word[start_point+1] == temp_word[end_point]:
                a=judge(temp_word[start_point+1:end_point+1])
                if a==1: return 1
                else: return 2                
            elif temp_word[start_point] == temp_word[end_point-1]:
                b=judge(temp_word[start_point:end_point])
                if b==1: return 1
                else: return 2 
            else: return 2
            
    return 0

n = int(input())
word_list = []
for i in range(n):
    temp_word = input()
    word_list.append(temp_word)
    

for i in range(len(word_list)):
    temp_word = word_list[i]
    result = check(temp_word)
    print(result)
    
    