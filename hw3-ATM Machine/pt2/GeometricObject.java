import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject>{
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    
    /** Construct default geo object */
    public GeometricObject(){
        dateCreated = new Date();
    }
    
    public GeometricObject(String color, boolean filled){
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }
    
    /**
    * This method returns the color of the geometric shape
    * @return String  Returns color
    */
    public String getColor(){
        return color;
    }
    
    /**
    * This method sets the color of the geometric shape
    * @param color  First param is color
    */
    public void setColor(String color){
        this.color = color;
    }
    
    /**
    * This method returns a status if the shape is filled
    * @return boolean  Returns filled
    */
    public boolean isFilled() { 
        return filled;
    } 
    
    /**
    * This method sets the filled property of the geometric object
    * @param filled  First param is true or false
    */
    public void setFilled(boolean filled) { 
        this.filled = filled; 
    }
    
    /**
    * This method returns the date the object is created
    * @return Date  Returns dateCreated
    */
    public Date getDateCreated() { 
        return dateCreated; 
    }
    
    /**
    * This method returns the string of the created object
    * @return string Returns string of created object
    */
    @Override
    public String toString() { 
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
    
    /**
    * This method compares the two numbers and returns 
    * a number based on the comparison
    * @return int  Returns either -1, 0, or 1
    */
    public int compareTo(GeometricObject obj){
        if (this.getArea() > obj.getArea()) {
          return 1;
        }
        else if(this.getArea() < obj.getArea()) {
          return -1;
        }
        else {
          return 0;
        }
        
    };
    
}