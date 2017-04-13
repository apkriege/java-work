

public class ComparableRectangle extends GeometricObject{
    
    private double width;
    private double height;
    
    /** Default constructor */
    public ComparableRectangle(){}
    
    public ComparableRectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public ComparableRectangle(double width, double height, String color, boolean filled){
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }
    
    /**
    * This method returns the width of the rectangle
    * @return double  Returns width
    */
    public double getWidth(){
        return width;
    }
    
    /**
    * This method sets the width of the rectangle
    * @param width  First param is width
    */
    public void setWidth(double width){
        this.width = width;
    }
    
    /**
    * This method returns the height of the rectangle
    * @return double  Returns height
    */
    public double getHeight(){
        return height;
    }
    
    /**
    * This method sets the height of the rectangle
    * @param height  First param is height
    */
    public void setHeight(double height){
        this.height = height;
    }
    
    /**
    * This method calculates and returns the area
    * @return double  Returns area
    */
    public double getArea(){
        return width * height;
    }
    
    /**
    * This method calculate and returns the perimeter
    * @return double  Returns perimeter
    */
    public double getPerimeter(){
        return 2* (width + height);
    }
    
    @Override
    public String toString(){
        return String.format("%.2f",getArea());
    }
    
}