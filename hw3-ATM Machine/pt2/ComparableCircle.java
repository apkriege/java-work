

public class ComparableCircle extends GeometricObject{
    private double radius;
    
    /** Default Constructor */
    public ComparableCircle(){}
    
    public ComparableCircle(double radius){
        this.radius = radius;
    }
    
    public ComparableCircle(double radius, String color, boolean filled){
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }
    
    /**
    * This method returns the radius of circle
    * @return double  Returns radius
    */
    public double getRadius(){
        return radius;
    }
    
    /**
    * This method sets the radius of circle
    * @param radius  First param is radius
    */
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    /**
    * This method calculates and returns the area
    * @return double  Returns area
    */
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    /**
    * This method calculates and returns the diameter
    * @return double Returns diameter
    */
    public double getDiameter(){
        return 2 * radius;
    }
    
    /**
    * This method calculates and reutrns perimeter
    * @return double  Returns perimeter
    */
    public double getPerimeter(){
        return 2* radius * Math.PI;
    }

    @Override
    public String toString(){
        return String.format("%.2f",getArea());
    }
    
}