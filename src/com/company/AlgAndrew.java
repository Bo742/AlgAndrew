package com.company;

import java.util.ArrayList;

public class AlgAndrew {
    private ArrayList<Dat> stackDat = new ArrayList<>() ;
    private long number = -1;
    private long flag = -1;

    public AlgAndrew(long flag) {
        this.flag = flag;
    }

    public void push(Dat dat){
        ++number;
        stackDat.add(dat);
    }

    public void pop(){
        stackDat.remove((int)number);
        number--;
    }

    public void alg(Dat dat){
        long v1x = getVectorX();
        long v1y = getVectorY();
        push(dat);
        long v2x = getVectorX();
        long v2y = getVectorY();

        long vectorPr = v1x*v2y-v2x*v1y;
        if(flag==0){
            if(vectorPr<=0){
                if(stackDat.size()>2){
                    pop();
                    pop();
                    push(dat);
                    algSecond(dat);
                }
            }
        }
        if(flag==1){
            if(vectorPr>=0){
                if(stackDat.size()>2){
                    pop();
                    pop();
                    push(dat);
                    algSecond(dat);
                }
            }
        }
    }

    private void algSecond(Dat dat){
        if(stackDat.size()>2) {
            pop();
            long v1x = getVectorX();
            long v1y = getVectorY();
            push(dat);
            long v2x = getVectorX();
            long v2y = getVectorY();

            long vectorPr = v1x * v2y - v2x * v1y;

            if (flag == 0) {
                if (vectorPr <= 0) {
                    if (stackDat.size() > 2) {
                        pop();
                        pop();
                        push(dat);
                        algSecond(dat);
                    }
                }
            }
            if (flag == 1) {
                if (vectorPr >= 0) {
                    if (stackDat.size() > 2) {
                        pop();
                        pop();
                        push(dat);
                        algSecond(dat);
                    }
                }
            }
        }
    }

    public ArrayList<Dat> getStackDat() {
        return stackDat;
    }

    public long getVectorX(){
        return stackDat.get((int)number).getX()-stackDat.get((int)number-1).getX();
    }

    public long getVectorY(){
        return stackDat.get((int)number).getY()-stackDat.get((int)number-1).getY();
    }
}
