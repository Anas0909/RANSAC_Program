//Anas Khelifa
//300257055
//Class PointCloud implementation

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class PointCloud {

    //Creating an ArrayList of type Point3D
    private ArrayList<Point3D> arraylist;


    //Constructor initialising arraylist and storing the file information in arraylist
    public PointCloud (String filename) throws FileNotFoundException{
        this.arraylist = arraylist;
        File m = new File(filename);
        Scanner r = new Scanner(m);
        r.nextLine();
        while (r.hasNextLine()) {
            String[] t = r.nextLine().split(",");
            Point3D p = new Point3D(Double.parseDouble(t[0]), Double.parseDouble(t[1]), Double.parseDouble(t[2]));
            arraylist.add(p);
        }
        r.close();
    }
    //Returns arraylist when called
    public ArrayList<Point3D> getArray(){
        return arraylist;
    }
    //Creating an empty constructor
    public PointCloud(){}
    
    //Adds a point to the arraylist
    public void addPoint(Point3D pt){
        arraylist.add(pt);
    }
    //Returns a random point from the arraylist AKA the pointcloud
    public Point3D getPoint(){
        Random rand = new Random();
        int index = rand.nextInt(arraylist.size());
        return arraylist.get(index);
    }
    //Creates and saves the file given
    public void save(String filename) throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter pw = new PrintWriter(filename);
        pw.println("x,y,z");
        for(Point3D p: arraylist){
            String xyz = p.getX()+","+p.getY()+","+p.getZ()+",";
            pw.println(xyz);
        }
        pw.close();
    }
    //Iterator of Point3D iterating the arraylist
    Iterator<Point3D> iterator(){
        return arraylist.iterator();
    }

}
