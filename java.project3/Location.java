package project3;

/**
 * This class is the Location class. It has String fields for the city, state, country, and zip code.
 * It is intended to store this information and make it easily retrievable by Record.   
 * Implements Comparable<Location>
 * @author Rohan Sharma
 * @version 03/21/2023
 * 
 */
public class Location implements Comparable<Location> {
    //local variables, made public for ease of access 
    public String ci;
    public String st;
    public String co;
    public String zi;

    /*
     * Only one constructor exists
     * @param Strings for city name, state name, country name, zip code name
     * Performs validity checks and sets equal to local variable
     * @throws IllegalArgumentException for null or illegal values
     */
    public Location(String city, String state, String country, String zip) throws IllegalArgumentException {
        String splus = "0";

        if (city == null) {
            throw new IllegalArgumentException("City input is null");
        }
        else {
            //prepending zeros to zip codes 
            if (zip.length() > 5) {
                throw new IllegalArgumentException("Zip code input must be five numerical digit characters");
            }
            else if (zip.length() < 5) {
                zi = zip;
                while (zi.length() < 5) {
                    zi = splus + zi;
                }
            }
            else {
                zi = zip;
                ci = city;
                st = state;
                co = country;
            }
        }
    }

    /*
     * This is the equals method, which checks for equality among all fields.
     * @param Location object
     * @return true if all involved fields are equal, false otherwise.
     */
    public Boolean equals(Location nOther) {
        //equals method checking each string for equality 
        if ((this.zi).equals(nOther.zi) && (this.ci).equalsIgnoreCase(nOther.ci) && (this.co).equalsIgnoreCase(nOther.co) && (this.st).equalsIgnoreCase(nOther.st))
            return(true);
        else {
            return(false);
        }
    }

    /*
     * Compare to method, overrides the object's compare to method.
     * @param Location object for the other value
     * @return 0 if the two are equal, and a negative or positive integer depending on the comparison
     */
    public int compareTo(Location nOther) {
        //comparing each string, going from zip code to city to state to country
        if (this.zi != null && nOther.zi != null) {
            if (this.zi.compareTo(nOther.zi) != 0) {
                return(this.zi.compareTo(nOther.zi));
            }
        }
        if (this.ci != null && nOther.ci != null) {
            if (this.ci.compareToIgnoreCase(nOther.ci) != 0) {
                return(this.ci.compareToIgnoreCase(nOther.ci));
            }
        }
        if (this.st != null && nOther.st != null) {
            if (this.st.compareToIgnoreCase(nOther.st) != 0) {
                return(this.st.compareToIgnoreCase(nOther.st));
            }
        }
        if (this.co != null && nOther.co != null) {
            if (this.co.compareToIgnoreCase(nOther.co) != 0) {
                return(this.co.compareToIgnoreCase(nOther.co));
            }
        }
        return(0);
    }
}

