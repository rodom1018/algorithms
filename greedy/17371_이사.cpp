#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

double x[1010];
double y[1010];

int main(void) {

    double print_x = -1;
    double print_y = -1;

    double result = 0;
    int n;
    scanf("%d", &n);

    for(int i=1 ; i<=n ; i++){
        double temp_x, temp_y;
        scanf("%lf %lf", &temp_x, &temp_y);
        x[i] = temp_x;
        y[i] = temp_y;
    }
    int first = 1;

    for(int i=1 ; i<=n ; i++){

        double temp_max = 0 ;

        for(int j=1 ; j<=n ; j++){

            if(i==j) continue;

            double diff_x = (x[j] - x[i] ) * ( x[j] - x[i]);
            double diff_y = (y[j] - y[i]) * (y[j] - y[i]);

            if(diff_x + diff_y > temp_max ) temp_max = diff_x + diff_y;
        }

        if(first == 1){
            result = temp_max;
            print_x = x[i];
            print_y = y[i];
            first = 0;
        }else if(temp_max < result){
            result = temp_max;
            print_x = x[i];
            print_y = y[i];
        }
    }

    printf("%lf %lf", print_x, print_y);
}

