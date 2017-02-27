import java.util.Scanner;
public class Main {
    //TODO Fix problems with entire game,
    //TODO items seem to bee gathered in reverse, please find a solution, because I've been trying too look through the code And I can't figure out what's wrong
    //TODO map seems too be flipped on the Y=-X axis
    public static void main(String[]args){
        Scanner kb = new Scanner(System.in);
        String yorn, yorn2;
        int w,h,m,sub_choice;
        entire:
        do {
            System.out.println("Would you like to use a preset? (Y/N)");
            yorn=kb.next();
            if(yorn.equals("Y")||yorn.equals("y")){
                while(true){
                    System.out.println("Which preset would you like?");
                    System.out.println("1.) 10 X 10, 10 mines");
                    System.out.println("2.) 15 X 15, 15 mines");
                    System.out.println("3.) 20 X 20, 20 mines");
                    System.out.println("0.) Return");
                    sub_choice=kb.nextInt();
                    if(sub_choice==1){
                        w=h=m=10;
                        break entire;
                    }
                    else if(sub_choice==2){
                        w=h=m=15;
                        break entire;
                    }
                    else if(sub_choice==3){
                        w=h=m=20;
                        break entire;
                    }
                    else if(sub_choice==0){
                        System.out.println("Returning to preset choice");
                        break;
                    }
                    else{System.out.println("Invalid Input.");}
                }
            }
            else if(yorn.equals("N")||yorn.equals("n")){
                System.out.println("What width would you like?");
                w=kb.nextInt();
                System.out.println("What height would you like?");
                h=kb.nextInt();
                System.out.println("How many mines would you like?");
                m=kb.nextInt();
                if(m!=0&&m<(w*h)){
                    while(true){
                        System.out.println("Are you okay with the dimensions "+w+" x "+h+" and "+m+" mine(s)? (Y/N)");
                        yorn2=kb.next();
                        if(yorn2.equals("Y")||yorn2.equals("y")){break entire;}
                        else if(yorn2.equals("N")||yorn2.equals("n")){break;}
                        else{System.out.println("Invalid input.");}
                    }
                }
            }
            else{System.out.println("Invalid input.");}
        }while(true);
        new MineSweeperFrame(w,h,m);
    }
}
