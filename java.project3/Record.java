package project3;
/**
 * This class is the Record class. 
 * Implements Comparable<Record> interface.
 * 
 * @author Rohan Sharma
 * @version 03/21/2023
 * 
 * Fields include a Name object as name, a String for business name, and Location object for the location value.
 * 
 */

public class Record implements Comparable<Record> {
    //Record variables
    public Name na;
    public String bu;
    public Location lo;

    /*
     * There is a single constructor, with no return value. 
     * @param Name object, String for business name, Location object
     */

    public Record(Name name, String business, Location location) {
        na = name;
        bu = business;
        lo = location;
    }
   
    /*
     * Getter methods, no parameters
     * @return Name object for getName, business string for getBusiness, Location object for getLocation
     */
    public Name getName() {
        return(this.na);
    }
    public String getBusiness() {
        return(this.bu);
    }
    public Location getLocation() {
        return(this.lo);
    }

    /*
     * Equals method; checks for equality among two Record objects
     * @param Record object
     * @return true if all objects involved are equal, false otherwise
     */
    public Boolean equals(Record other) {
        if ((this.na).equals(other.na) && (this.bu).equalsIgnoreCase(other.bu) && (this.lo).equals(other.lo))
            return(true);
        else {
            return(false);
        }
    }

    
    /*
     * No parameter toString method
     * Returns a string representation of the object, using the name, business, and location.
     */
    public String toString() {
        String topLine;
        String bottomLine;
        String finResult;

        topLine = this.na.lastName + "," + this.na.firstName + "," + this.na.mInitial;
        bottomLine = this.bu + "," + this.lo.ci + "," + this.lo.st + "," + this.lo.co + "," + this.lo.zi;

        finResult = topLine + "\n\t" + bottomLine;
        return(finResult);
    }

    
    /*
     * Compare to method, overrides the object's compare to method.
     * @param Record object for the other value
     * @return 0 if the two are equal, and a negative or positive integer depending on the comparison
     */
    public int compareTo(Record nOther) {
        if (this.na.compareTo(nOther.na) != 0) {
            return(this.na.compareTo(nOther.na));
        }
        else if(this.lo.compareTo(nOther.lo) != 0) {
            return(this.lo.compareTo(nOther.lo));
        }

        return(0);
    }
}

