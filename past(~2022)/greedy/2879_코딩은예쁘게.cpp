#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

int info[1010];

using namespace std;

int main(void) {
    int n, result =0;
    scanf("%d", &n);

    for(int i=1; i<=n; i++){
        int temp;
        scanf("%d", &temp);
        info[i] = temp;
    }

    for(int i=1; i<=n; i++){
        int temp;
        scanf("%d", &temp);
        info[i] = temp - info[i];
    }
    int  flag = 1;
    for(int i=1 ;i<=n;i++){

        if(flag == 1){
            //flag == 1 양수 훑고있음
            if(info[i] <=0){
                result+=abs(info[i-1]);
                flag = -1;
            }else{
                if(abs(info[i-1]) > abs(info[i])) result += abs(info[i-1]) - abs(info[i]);
            }
        }else if(flag == -1){
            if(info[i] >=0){
                result+=abs(info[i-1]);
                flag = 1;
            }else{
                if(abs(info[i-1]) > abs(info[i])) result += abs(info[i-1]) - abs(info[i]);
            }
        }
    }

    result += abs(info[n]);
    printf("%d",result);
}

