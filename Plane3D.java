//Anas Khelifa
//300257055
//Class Plane3D implementation

import java.lang.Math;

public class Plane3D {
    //Creating a,b,c,d variables for the plane equation
    private double a;
    private double b;
    private double c;
    private double d;

    //Takes in 3 points and calculates the plane equation coefficients
    public Plane3D(Point3D p1, Point3D p2, Point3D p3){
        double e = p2.getX()-p1.getX();
        double f = p2.getY()-p1.getY();
        double g = p2.getZ()-p1.getZ();
        double h = p3.getX()-p1.getX();
        double i = p3.getY()-p1.getY();
        double j = p3.getZ()-p1.getZ();
        a = (f*j)-(g*i);
        b = -((e*j)-(g*h));
        c = (e*i)-(f*h);
        d = -((a*(p1.getX()))+(b*(p1.getY()))+(c*(p1.getZ())));
    }
    //Constructor initialising the plane equation coefficients
    public Plane3D(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    //Method getDistance calculates and returns the distance between the plane and the point given
    public double getDistance (Point3D pt){
        double dist = Math.abs((a*(pt.getX())+b*(pt.getY())+c*(pt.getZ())+d))/(Math.sqrt((a*a)+(b*b)+(c*c)));
        return dist;
    }
}
