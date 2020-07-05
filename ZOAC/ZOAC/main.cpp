//
//  main.cpp
//  ZOAC
//
//  Created by sawon on 02/01/2019.
//  Copyright © 2019 sawon. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include<vector>
using namespace std;
vector <char> sent;
int size;
bool tf[100]={0,};
char sentence[100];

void print(int st, int ed)
{
    if(st>ed) return;
    
    char min=*min_element(sent.begin()+st,sent.begin()+ed+1);
    int pivot;
    for(pivot=st;pivot<=ed;pivot++)
    {
        if(sentence[pivot]==min)
        {
            if(tf[pivot]==1) continue;
            tf[pivot]=1;
            break;
        }
    }
    
    for(int i=0;i<size;i++)
    {
        if(tf[i]==1)
            printf("%c",sentence[i]);
    }
    printf("\n");
    
    print(pivot+1,ed);
    print(st,pivot-1);
    
}
int main(int argc, const char * argv[]) {
    
    scanf("%s",sentence);
    size=(int)strlen(sentence);
   
    for(int i=0;i<size;i++)
        sent.push_back(sentence[i]);
   
   print(0,size-1);
    return 0;
}
