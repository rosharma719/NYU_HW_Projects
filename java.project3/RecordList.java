package project3;
import java.util.ArrayList;

/**
 * This class is the RecordList class. It is intended to store Record objects and inherits ArrayList<Record>
 * 
 * @author Rohan Sharma
 * @version 03/21/2023
 * 
 * 
 */


public class RecordList extends ArrayList<Record> {

    /*
     * No-argument constructor for a new RecordList. Calls ArrayList no-arg constructor.
     */
    public RecordList() {
        super();
    }

    /*
     * Getter method for the Name
     * @param String keyword
     * @throws IllegalArgumentException
     * @return RecordList object of the Record objects that match the Name substring
     */
    public RecordList getByName(String keyword) throws IllegalArgumentException {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Name is null or empty.");
        }

        //creating a new record list 
        RecordList result = new RecordList();
        for (Record record : this) {
            //Checking if a record contains the keyword
            if (record.na.firstName != null)
                if (record.na.firstName.toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(record);
                }
            else if (record.na.firstName != null) {
                if (record.na.lastName.toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(record);
                }
            }
        }
        if (result.isEmpty() || result == null) {
            return(null);
        }
        else {
            return(result);
        }
    }

    
    /*
     * Getter method for the City
     * @param String keyword
     * @throws IllegalArgumentException
     * @return RecordList object of the Record objects that match the City substring
     */
    public RecordList getByCity(String keyword) throws IllegalArgumentException {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("City keyword cannot be null or empty");
        }

        //Checking to see if the city contains the keyword
        RecordList result = new RecordList();
        for (Record record : this) {
            if (record.lo.ci != null)
            if (record.lo.ci.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(record);
            }
        }
        if (result.isEmpty() || result == null) {
            return(null);
        }
        else {
            return(result);
        }
    }
    
    
    /*
     * No parameter toString method
     * Returns a string representation of a list of Record objects, using the name, business, and location.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Record record : this) {
            sb.append(record.toString()).append("\n");
        }
        return(sb.toString());
    }

    
    /*
     * Getter method for the zip code
     * @param String keyword
     * @throws IllegalArgumentException
     * @return RecordList object of the Record objects that match the zip code
     */
    public RecordList getByZip(String zip) throws IllegalArgumentException {
        if (zip.length() != 5 || zip == null) {
            throw new IllegalArgumentException("Zip code input must be five numbers");
        }
        for (int x = 0; x < 5; x++) {
            if (!Character.isDigit(zip.charAt(x))) {
                throw new IllegalArgumentException("Zip code input must be five numbers");
            }
        }

        //checking for matches in the record list 
        RecordList result = new RecordList();
        for (Record record : this) {
            if (zip.equals(record.lo.zi)) {
                result.add(record);
            }
        }
        if (result.isEmpty() || result == null) {
            return(null);
        }
        else {
            return(result);
        }
    }


}