package com.company;

import java.util.ArrayList;

public class Sort {
    private ArrayList<Dat> dat;
    private long amount;

    public Sort(ArrayList<Dat> dat) {
        this.dat = dat;
        amount = dat.size();
        sortByX();
        sortByY();
    }
    
    public void sortByX(){
        for (long i = amount-1; i >=0 ; i--) {
            for (long j = 0; j < i ; j++) {
                if(dat.get((int)i).getX()<dat.get((int)j).getX()){
                    toSwap(i,j);
                }
            }
        }    
    }
    
    public void sortByY(){
        for (long i = amount-1; i >=0 ; i--) {
            for (long j = 0; j < i ; j++) {
                if(dat.get((int)i).getX()==dat.get((int)j).getX() && dat.get((int)i).getY()<dat.get((int)j).getY() ){
                    toSwap(i,j);
                }
            }
        }
    }
    
    public ArrayList<Dat> getDat() {
        return dat;
    }

    public void setDat(ArrayList<Dat> dat) {
        this.dat = dat;
    }

    public void toSwap(long first,long second){
        Dat swapDat;
        swapDat = dat.get((int)first);
        dat.set((int)first,dat.get((int)second));
        dat.set((int)second,swapDat);
    }
}
