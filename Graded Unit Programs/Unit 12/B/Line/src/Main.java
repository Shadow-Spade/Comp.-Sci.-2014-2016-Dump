import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {
    public static void main(String []args) {

        Scanner kb = new Scanner(System.in);
        int x,y,i;
        System.out.println("Line 1 point 1");
        System.out.println("Enter the X value:");
        x=kb.nextInt();
        System.out.println("Enter the Y value:");
        y=kb.nextInt();
        //point 1 line 1
        Mypoint p1L1 = new Mypoint(x,y);
        System.out.println("Line 1 point 2");
        System.out.println("Enter the X value:");
        x=kb.nextInt();
        System.out.println("Enter the Y value:");
        y=kb.nextInt();
        //point 2 line 1
        Mypoint p2L1 = new Mypoint(x,y);
        System.out.println("Line 2 point 1");
        System.out.println("Enter the X value:");
        x=kb.nextInt();
        System.out.println("Enter the Y value:");
        y=kb.nextInt();
        //point 1 line 2
        Mypoint p1L2 = new Mypoint(x,y);
        System.out.println("Line 2 point 2");
        System.out.println("Enter the X value:");
        x=kb.nextInt();
        System.out.println("Enter the Y value:");
        y=kb.nextInt();
        //point 2 line 2
        Mypoint p2L2 = new Mypoint(x,y);
        Line ln1= new Line(p1L1,p2L1);
        Line ln2= new Line(p1L2,p2L2);
        do {
            System.out.println("--Menu--");
            System.out.println("1.) Change Line 1");
            System.out.println("2.) Change Line 2");
            System.out.println("3.) View Line 1");
            System.out.println("4.) View Line 2");
            System.out.println("5.) View Line Intersection");
            System.out.println("6.) Exit");
            i=kb.nextInt();
            switch (i)
            {
                case 1:
                    System.out.println(ln1.toString());
                    poop:
                    do {
                        System.out.println("\n\n--Menu--");
                        System.out.println("1) Replace point 1");
                        System.out.println("2) Replace point 2");
                        System.out.println("3) Replace both points");
                        System.out.println("4) Cancel");
                        i=kb.nextInt();
                        switch(i)
                        {
                            case 1:
                                System.out.println("Enter new x for point 1");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 1");
                                y=kb.nextInt();
                                p1L1 = new Mypoint(x,y);
                                ln1= new Line(p1L1,p2L1);
                                break;
                            case 2:
                                System.out.println("Enter new x for point 2");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 2");
                                y=kb.nextInt();
                                p2L1 = new Mypoint(x,y);
                                ln1= new Line(p1L1,p2L1);
                                break;
                            case 3:
                                System.out.println("Enter new x for point 1");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 1");
                                y=kb.nextInt();
                                p1L1 = new Mypoint(x,y);
                                System.out.println("Enter new x for point 2");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 2");
                                y=kb.nextInt();
                                p2L1 = new Mypoint(x,y);
                                ln1= new Line(p1L1,p2L1);
                                break;
                            case 4:
                                break poop;
                            default:
                                break;
                        }
                    }while(true);
                    break;
                case 2:
                    System.out.println(ln2.toString());
                    poop:
                    do {
                        System.out.println("\n\n--Menu--");
                        System.out.println("1) Replace point 1");
                        System.out.println("2) Replace point 2");
                        System.out.println("3) Replace both points");
                        System.out.println("4) Cancel");
                        i=kb.nextInt();
                        switch(i)
                        {
                            case 1:
                                System.out.println("Enter new x for point 1");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 1");
                                y=kb.nextInt();
                                p1L2 = new Mypoint(x,y);
                                ln2= new Line(p1L2,p2L2);
                                break;
                            case 2:
                                System.out.println("Enter new x for point 2");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 2");
                                y=kb.nextInt();
                                p2L2 = new Mypoint(x,y);
                                ln2= new Line(p1L2,p2L2);
                                break;
                            case 3:
                                System.out.println("Enter new x for point 1");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 1");
                                y=kb.nextInt();
                                p1L2 = new Mypoint(x,y);
                                System.out.println("Enter new x for point 2");
                                x=kb.nextInt();
                                System.out.println("Enter new y for point 2");
                                y=kb.nextInt();
                                p2L2 = new Mypoint(x,y);
                                ln2= new Line(p1L2,p2L2);
                                break;
                            case 4:
                                break poop;
                            default:
                                break;
                        }
                    }while(true);
                    break;
                case 3:
                    System.out.println(ln1.toString());
                    break;
                case 4:
                    System.out.println(ln2.toString());
                    break;
                case 5:
                    if(ln1.getSlope()==ln2.getSlope())
                    {
                        System.out.println("Lines never intersect");
                    }
                    else
                    {
                        double xIntersection = (ln2.getyInt()-ln1.getyInt())/(ln1.getSlope()-ln2.getSlope());
                        double yIntersection = (ln1.getSlope()*xIntersection)+ln1.getyInt();
                        System.out.println("your two lines intersect at point ("+xIntersection+","+yIntersection+")");
                    }
                    break;
                case 6:
                    System.out.println("Goo Bai");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid Input");
                    break;
            }

        }while (true);


    }
    public Mypoint makePoint() {
        return null;
    }
}
