//Anas Khelifa
//300257055
//Class Main implementation
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
    //Main method runs the three classes Point3D, Plane3D, PointCloud, PlaneRANSAC
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String filename = "PointCloud1.xyz";
        PointCloud cloud = new PointCloud("C:\\Anas\\Uottawa\\Classes\\ProgrammingParadimes\\Case1");
        PlaneRANSAC RANSAC = new PlaneRANSAC(cloud);
        RANSAC.setEps(1.2);
        RANSAC.run(0,"C:\\Anas\\Uottawa\\Classes\\ProgrammingParadimes\\Case1");
        cloud.save(filename);
    }

}