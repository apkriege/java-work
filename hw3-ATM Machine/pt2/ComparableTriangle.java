

public class ComparableTriangle extends GeometricObject{
    
    private double s1;
    private double s2;
    private double s3;
    
    public ComparableTriangle(){}
    
    public ComparableTriangle(double s1, double s2, double s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    
    public ComparableTriangle(double s1, double s2, double s3, String color, boolean filled){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        setColor(color);
        setFilled(filled);
    }
    
    /**
    * This method returns side 1 of the triangle
    * @return double  Returns s1
    */
    public double getSide1(){
        return s1;
    }
    
    /**
    * This method returns side 2 of the triangle
    * @return double  Returns s2
    */
    public double getSide2(){
        return s2;
    }
    
    /**
    * This method returns side 3 of the triangle
    * @return double  Returns s3
    */
    public double getSide3(){
        return s3;
    }
    
    /**
    * This method returns the calculated areo of triangle
    * @return double  Returns area
    */
    public double getArea(){
        double s = (s1+s2+s3)/2;
        return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
    }
    
    /**
    * This method returns the calculated perimeter
    * @return double  Returns perimeter
    */
    public double getPerimeter(){
        return s1 + s2 + s3;
    }
    
    @Override
    public String toString(){
        return String.format("%.2f",getArea());
    }
    
}