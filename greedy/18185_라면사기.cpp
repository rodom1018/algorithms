#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

int info[10010];
int memory[10010];
using namespace std;

int main(void) {

    int n;
    int total_cost = 0;
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        int temp;
        scanf("%d", &temp);
        info[i] = temp;
    }

    int a,b,c;
    int temp_min;
    for (int i = 3; i <= n; i++) {
        a = info[i];
        b = info[i - 1];
        c = info[i - 2];

        if (b > a && i!=n) {
            temp_min = min(c,b-a);
            total_cost += temp_min *5;
            info[i-1] -= temp_min;
            info[i-2] -= temp_min;
        }

        a = info[i];
        b = info[i - 1];
        c = info[i - 2];

        temp_min = min(min(a, b), c);
        total_cost += temp_min * 7;
        info[i] -= temp_min;
        info[i - 1] -= temp_min;
        info[i - 2] -= temp_min;
    }

    for(int i=2 ; i<=n ;i++){
        a = info[i];
        b = info[i-1];

        temp_min = min(a,b);
        total_cost += temp_min * 5;
        info[i] -= temp_min;
        info[i-1] -= temp_min;
    }

    for(int i=1 ; i<=n ; i++){
        total_cost += info[i] * 3;
    }

    printf("%d",total_cost);
}

