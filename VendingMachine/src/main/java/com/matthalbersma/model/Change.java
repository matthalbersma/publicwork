package com.matthalbersma.model;

/**
 * Created by walter on 9/17/16.
 */
public class Change {
    private int quarter;
    private int dime;
    private int nickel;
    private int penny;

    public Change(int a){
        quarter=(int)(a/25);
        dime=(int)((a-(quarter*25)))/10;
        nickel=(int)(a-(quarter*25)-(dime*10))/5;
        penny=(a-(quarter*25)-(dime*10)-(nickel*5));

    }
    public String toString(){
        String quarters, dimes, nickels, pennies;
        if (getQuarter()>1) quarters= getQuarter() +" quarters";
        else if (getQuarter()==0) quarters="";
        else quarters=getQuarter()+" quarter ";
        if(getDime()>1) dimes="\n"+getDime()+" dimes";
        else if (getDime()==0) dimes="";
        else dimes="\n"+getDime()+" dime";
        if(getNickel()>1) nickels="\n"+getNickel()+" nickels";
        else if (getNickel()==0) nickels="";
        else nickels="\n"+getNickel()+" nickel";
        if(getPenny()>1) pennies="\n"+getPenny()+" pennies";
        else if (getPenny()==0) pennies="";
        else pennies="\n"+getPenny()+" penny";

        return quarters+dimes+nickels+pennies;

    }

    /**
     * @return the quarter
     */
    public int getQuarter() {
        return quarter;
    }

    /**
     * @param quarter the quarter to set
     */
    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    /**
     * @return the dime
     */
    public int getDime() {
        return dime;
    }

    /**
     * @param dime the dime to set
     */
    public void setDime(int dime) {
        this.dime = dime;
    }

    /**
     * @return the nickel
     */
    public int getNickel() {
        return nickel;
    }

    /**
     * @param nickel the nickel to set
     */
    public void setNickel(int nickel) {
        this.nickel = nickel;
    }

    /**
     * @return the penny
     */
    public int getPenny() {
        return penny;
    }

    /**
     * @param penny the penny to set
     */
    public void setPenny(int penny) {
        this.penny = penny;
    }

}
