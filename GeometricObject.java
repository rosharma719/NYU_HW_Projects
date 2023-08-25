
public class GeoObjectClass {

    public static void main(String[] args) {

        Circle c1 = new Circle(10);
        Circle c2 = new Circle(10);
        MyRectangle2D r1 = new MyRectangle2D(0, 0, 5, 5);

        System.out.println("c1 equals c2? " + c1.equals(c2));
        System.out.println("c1 equals r1? " + c1.equals(r1));
    }
}

abstract class GeometricObject {
    public static void main(String[] args) {

        GeometricObject g1 = new Circle(8, "white", true);
        GeometricObject g2 = new Circle(8, "white", true); 
        System.out.println(g1.equals(g2)); 
    }
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    /** Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
     /** Return color */
    public String getColor() {
        return color;

    }
    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }

    /** Return filled. Since filled is boolean,
     * the get method is named isFilled */
    public boolean isFilled() {
        return filled;
    }
    /** Set a new filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
    public abstract boolean equals(); 
    
    public class Circle extends GeometricObject implements Comparable{
        private double radius; 
        public Circle(double r, String c, boolean f) {
            this.radius = r;
            setColor(c);
            setFilled(f);
        }

        public double getArea() {
            return(Math.PI * (radius*radius)); 
        }
        public double getPerimeter() {
            return(Math.PI * 2 * radius); 
        }
        public boolean equals(Object obj) {
            return obj instanceof Circle && radius == ((Circle) obj).radius;
        }
    
    }
    
    public interface Comparable {
        @Override
        boolean equals(Object obj);

    }
}