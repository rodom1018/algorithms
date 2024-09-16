#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

/*
int main() {}
 */
int info[1002][1002];
char a[1002];
char b[1002];
char my_print[1002];

int main(){
    scanf("%s", a);
    scanf("%s", b);

    int len_a = strlen(a);
    int len_b = strlen(b);
    for(int i=1; i<= len_a; i++){
        for(int j=1; j<= len_b ; j++){
            if(a[i-1] == b[j-1])info[i][j] = info[i-1][j-1] + 1;
            else info[i][j] = max(info[i-1][j], info[i][j-1]);
        }
    }

    int result = info[len_a][len_b];

    printf("%d\n", result);
    /*
    printf("\n");
    for(int i=0 ; i<= len_b ; i++){
        for(int j=0; j<= len_a ; j++){
            printf("%d ", info[i][j]);
        }
        printf("\n");
    }*/
    int point = 0;
    int b_p = len_b;
    int a_p = len_a;

    while(a_p>=1 && b_p>=1){

        if(info[a_p][b_p] == info[a_p-1][b_p]){
            a_p--;
        }else if(info[a_p][b_p] == info[a_p][b_p-1]){
            b_p--;
        }else if(info[a_p][b_p] > info[a_p-1][b_p-1]){
            my_print[point++] = a[a_p-1];
            //printf("%d %c\n", a_p,a[a_p-1]);
            a_p--; b_p--;
        }
    }
    for(int i = point-1 ; i>=0 ; i--){
        printf("%c", my_print[i]);
    }

}
