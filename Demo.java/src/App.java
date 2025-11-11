class Data{
    int s=10;
}
class Square extends Data
{
    int area;
    void calarea()
    {
        System.out.println(s*s);
    }
}
class Main{
    public static void main(String[] args) {
        Square s =new Square();
        s.calarea();
    }
}