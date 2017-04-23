import java.lang.Math;

public class Circle1 extends Circle
{

public Circle1(double x, double y, double radius)
{
   super(x,y,radius);
}

public boolean intersects(Circle other)
{
	double lowerLimit = Math.pow(radius-other.radius,2);
	double upperLimit = Math.pow(radius+other.radius,2);
	double squareDist = Math.pow(center.x-other.center.x,2)
							+ Math.pow(center.y-other.center.y,2);
   if (lowerLimit<=squareDist && squareDist<=upperLimit)
      return true;
   return false;
}

}

