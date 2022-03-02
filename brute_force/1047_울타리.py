#include <iostream>
#include <algorithm>
using namespace std;

struct tree{
    int x;
    int y;
    int reward;
}trees[3][41];

bool cmp_x(const tree &t1, const tree &t2){
    if(t1.x < t2.x) return true;
    else return false;
}

bool cmp_y(const tree &t1, const tree &t2){
    if(t1.y < t2.y) return true;
    else return false;
}

bool cmp_r(const tree &t1, const tree &t2){
    if(t1.reward > t2.reward) return true;
    else return false;
}

int main() {
    int n;
    scanf("%d", &n);
    int result = 100;
    int temp1, temp2, temp3;
    for(int i=0; i<n; i++){
        scanf("%d %d %d", &temp1 , &temp2, &temp3);
        for(int j=0 ; j<3 ; j++){
            trees[j][i].x= temp1;
            trees[j][i].y = temp2;
            trees[j][i].reward = temp3;
        }
    }
    sort(trees[0],trees[0]+n, cmp_x);
    sort(trees[1], trees[1]+n, cmp_y);
    sort(trees[2], trees[2]+n, cmp_r);

    for(int x1 = 0; x1<n; x1++){
        for(int x2 = x1; x2<n ; x2++){
            for(int y1 =0 ; y1<n; y1++){
                for(int y2 = y1 ; y2 < n ;y2++){

                    int now_x1 = trees[0][x1].x;
                    int now_x2 = trees[0][x2].x;
                    int now_y1 = trees[1][y1].y;
                    int now_y2 = trees[1][y2].y;

                    int temp_store[40] = {0,};
                    int pointer = 0;

                    int have_wood = 0;
                    int need_tree= ((now_x2-now_x1) + (now_y2-now_y1))*2;
                    int cut_tree = 0;

                    for(int i=0; i<n ; i++){
                        if(trees[2][i].x >=now_x1 && trees[2][i].x<=now_x2 && trees[2][i].y >=now_y1 && trees[2][i].y <=now_y2){
                            temp_store[pointer++] = trees[2][i].reward;
                            continue;
                        }else {
                            cut_tree += 1;
                            have_wood += trees[2][i].reward;
                        }
                    }

                    if(need_tree <= have_wood){
                        if(result > cut_tree) result = cut_tree;
                        continue;
                    }else{
                        for(int i=0; i<pointer; i++){
                            cut_tree +=1;
                            have_wood += temp_store[i];
                            if(result < cut_tree) break;

                            if(need_tree <= have_wood){
                                if(result > cut_tree) result = cut_tree;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    printf("%d\n", result);
}
