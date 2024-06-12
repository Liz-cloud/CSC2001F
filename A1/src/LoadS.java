public class LoadS implements Comparable<LoadS> {
    /**
    * Declare LoadS object instance variables
     */
    public String key;
    public String area;
    /**
     * @param a
     * @param k
    * Create LoadS constructor
     */
    public LoadS(String k, String a){
        this.key=k;
        this.area=a;

    }
    /**
    * Make a toString() to return the LoadS object by value
     */
    public String toString(){
        return (this.key+" "+this.area);
    }
    /**
    * access the LoadS object key instance variable
     */
    public String getKey(){
        return this.key;
    }
    /**
     * access the LoadS object area instance variable
     */
    public String getArea(){
        return this.area;
    }
    /**
     * @param o
     * @return integerS
    * Override the compareTo method in order to compare the param LoadS Object keys against each other
     */

    @Override
    public int compareTo(LoadS o) {
        //System.out.println("Comparing "+this.key+" to "+o.getKey());
            return (this.key.compareTo(o.getKey()));

    }
}
