//
//  main.cpp
//  배추
//
//  Created by sawon on 19/12/2018.
//  Copyright © 2018 sawon. All rights reserved.
//

#include <iostream>
int land[50][50];
int w,h;
int count;
struct point{
    int x;
    int y;
};
point bae[2500];
int plusx[4]={1,0,-1,0};
int plusy[4]={0,-1,0,1};
void DFS(int X,int Y)
{
    if(land[Y][X]==0) return;
    else{
        land[Y][X]=0;
        for(int k=0;k<4;k++)
        {
            int xx=X+plusx[k];
            int yy=Y+plusy[k];
            if(xx<0||xx>=w||yy<0||yy>=h) continue;
            if(land[yy][xx]==0) continue;
            DFS(xx,yy);
        }
    }
    
}
int main(int argc, const char * argv[]) {
    int test=0;
    scanf("%d",&test);
    for(int i=0;i<test;i++)
    {
        int bug=0;
        for(int k=0;k<50;k++)
            for(int j=0;j<50;j++)
                land[k][j]=0;
        int x,y;
        scanf("%d %d %d",&w,&h,&count);
        for(int j=0;j<count;j++)
        {
            scanf("%d %d",&x,&y);
            land[y][x]=1;
            bae[j].x=x;
            bae[j].y=y;
            
        }
        for(int k=0;k<count;k++)
        {
            if(land[bae[k].y][bae[k].x]==0) continue;
            DFS(bae[k].x,bae[k].y);
            bug++;
        }
        
        printf("%d",bug);
        
    }
    return 0;
}


