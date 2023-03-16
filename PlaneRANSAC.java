//Anas Khelifa
//300257055
//Class PlaneRANSAC implementation

import java.lang.Math;
import java.util.ArrayList;

public class PlaneRANSAC {
    
    //Creating variables double eps and PointCloud pc
    private double eps;
    private PointCloud pc;

    //Constructor intitializinf PointClound
    public PlaneRANSAC(PointCloud pc){
        this.pc = pc;
    }
    //Setter takes in eps and initializes it
    public void setEps(double eps){
        this.eps = eps;
    }

    //Getter returning eps value
    public double getEps(){
        return eps;
    }
    //Getter takes in confidence and percentageOfPointsOnPlane and returns numberOfIterations
    public int getNumberOfIterations(double confidence, double percentageOfPointsOnPlane){
        return (int) (-Math.log(1 - confidence) / Math.log(1 - Math.pow(percentageOfPointsOnPlane, 3)));
    }

    //Method run takes in numberOfIterations and filename then runs the RANSAC algorithm
    public void run(int numberOfIterations, String filename){
        int t = 0;
        //Set dominant plane to null
        Plane3D Dm = null;
        //Run a while loop for the RANSAC algorith up to numberOfIterations
        while(t<numberOfIterations){
            //Drawing 3 random points from the pointcloud
            Point3D a = pc.getPoint();
            Point3D b = pc.getPoint();
            Point3D c = pc.getPoint();
            //Creating Plane3D using the three random points
            Plane3D m = new Plane3D(a,b,c);
            //Creating current support and best support setting them to 0
            int cs = 0;
            int bs = 0;
            //Putting the arraylist from pc into p then calculating the size of the array
            ArrayList<Point3D> p = pc.getArray();
            int size = pc.getArray().size();
            //for loop to go over all the points in pointcloud to compare the distance with eps
            //to increment the current support if getDistance < eps
            for(int i=0;i<size;i++){
                if(m.getDistance(p.get(i))<eps){
                    cs++;
                }
            }
            //Checking if current support is greater than best to support to change the value of 
            //dominant plane and best support
            if(cs>bs){
                Dm = m;
                bs=cs;
            }
            //Incrementing the while loop
            t++;
        }
        
        ArrayList<Point3D> p = pc.getArray();
        int size = pc.getArray().size();
        PointCloud pc2 = new PointCloud();
        //for loop creating a new pointcloud and removing the points from dominant plane out of
        //the oiginal pointcloud
        for(int i=0;i<size;i++){
            if(Dm.getDistance(p.get(i))<eps){
                pc2.addPoint(p.get(i));
                p.remove(p.get(i));
            }
        }

    }
}
