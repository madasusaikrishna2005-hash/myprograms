class Data
{
int s=10;
int l=20;
int b=35;
int s1=20,s2=25,s3=35;
}
class Square extends Data
{
 int area;
 void calarea()
 {
  area=s*s;
  System.out.println(area);
  }
}
class Rectangle extends Data
 {
 int p,area;
 void calculate()
 {
 p=2*(l+b);
 area=l*b;
 {
System.out.println(p);
System.out.println(area);
}
}}
class main
{
public static void main(String args[])
{
Square s=new Square();
Rectangle r=new Rectangle();
  s.calarea();
  r.calculate();
 }
}

 
 