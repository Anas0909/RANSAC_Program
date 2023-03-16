//Anas Khelifa
//300257055
//Class Point3D implementation

public class Point3D {

    //Creating x,y,z variables
    private double x;
    private double y;
    private double z;

    //Point3D Constructor takes in three co-ordinates
    public Point3D(double x, double y, double z) {
        this.x= x;
        this.y= y;
        this.z= z;
    }
    //Get method return x co-ordinate
    public double getX() {
        return x;
    }
    //Get method return y co-ordinate
    public double getY() {
        return y;
    }	
    //Get method return z co-ordinate
    public double getZ() {
        return z;
    }
}