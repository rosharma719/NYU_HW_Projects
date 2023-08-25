package project3;

/**
 * This class is the Name class. It provides fields for first and last names, and the middle initial.
 * It is intended to store this information and make it easily retrievable by Record. 
 * It implements Comparable<Name> interface.
 * @author Rohan Sharma
 * @version 03/21/2023
 * 
 */
public class Name implements Comparable<Name> {
    //local variables
    public String firstName;
    public String lastName;
    public String mInitial;

    /* 
     * There are three separate constructors here for last name only, last/first name, and all three possible arguments.
     * These accept Strings for the first and last name, and Character objects for the middle initial.
     * No return value, as they are constructors.
     */
 
    //last name constructor
    public Name(String lName) throws IllegalArgumentException {
        if (lName == null || lName.equals("")) {
            throw new IllegalArgumentException("Null or empty string");
        }
        this.lastName = lName;
    }

    //first and last name constructor
    public Name(String lName, String fName) throws IllegalArgumentException {
        if ((fName == null || lName == null) || lName.equals("")) {
            
            throw new IllegalArgumentException("Null or empty string");
        }
        this.lastName = lName;
        this.firstName = fName;
    }

    //first name, last name, and middle initial constructor
    public Name(String lName, String fName, Character mInitial) throws IllegalArgumentException {
        if ((lName == null) || (lName.equals("") )) {
            throw new IllegalArgumentException("Null or empty string");
        }
        if (fName != null)
            this.firstName = fName;
        if (mInitial.toString() != null)
            this.mInitial = mInitial.toString();
        this.lastName = lName;
        
    }

    /*
     * This is the equals method, which checks for equality among all fields.
     * @param name object
     * @return true if all involved fields are equal, false otherwise.
     */
    public boolean equals(Name nOther) {
        if ((this.lastName).equalsIgnoreCase(nOther.lastName) && (this.firstName).equalsIgnoreCase(nOther.firstName) && (this.mInitial).equalsIgnoreCase(nOther.mInitial))
            return(true);
        else {
            return(false);
        }
    }

    /*
     * Compare to method, overrides the object's compare to method.
     * @param Name object for the other value
     * @return 0 if the two are equal, and a negative or positive integer depending on the comparison
     */
    @Override
    public int compareTo(Name nOther) {
        if (this.lastName.compareToIgnoreCase(nOther.lastName) != 0) {
            return(lastName.compareToIgnoreCase(nOther.lastName));
        }
        if (this.firstName != null && nOther.firstName != null) {
            if (this.firstName.compareToIgnoreCase(nOther.firstName) != 0) {
                return(firstName.compareToIgnoreCase(nOther.firstName));
            }
        }

        if (!(this.mInitial.isEmpty() && nOther.mInitial.isEmpty())){
            if (this.mInitial.compareToIgnoreCase(nOther.mInitial) != 0) {
                return(this.mInitial.compareToIgnoreCase(nOther.mInitial));
            }
        }
        return(0);
    }
}
