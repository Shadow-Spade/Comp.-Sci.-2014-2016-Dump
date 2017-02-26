import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] names;
        int[] scores;
        int pnum, nplr=0,selection;
        ArrayList<ZombieDie>turnSummary =new ArrayList<ZombieDie>();
        ArrayList<ZombieDie>brains=new ArrayList<ZombieDie>();
        ArrayList<ZombieDie>shots=new ArrayList<ZombieDie>();
        ArrayList<ZombieDie>runners=new ArrayList<ZombieDie>();
        ZombieDiceBucket dearGod=new ZombieDiceBucket();
        //This ^^^, is a Bucket.
        //Dear God.
        //There's more vvv
        //No!
        Scanner kb = new Scanner(System.in);
        do {
            System.out.print("How many players are going to play? <2-5>: ");
            pnum=kb.nextInt();
            if(pnum>5||pnum<2) {continue;}
            names=new String[pnum];
            scores=new int[pnum];
            for(int x=0; x<pnum;x++) {
                System.out.print("Enter a player's name: ");
                names[x]=kb.next();
            }
            break;
        }while(true);
        shuffleNames(names);
        do {
            if (nplr>names.length-1) {nplr=0;}
            dearGod.loadBucket();
            turn:
            do {
                System.out.println(names[nplr] + " it's your turn, and your current brain score is " + scores[nplr]);
                System.out.println("\nTurn Summary:");
                System.out.println("\tBrains: "+brains);
                System.out.println("\tShots: "+shots);
                System.out.println("\tRunners: "+runners);
                if(shots.size()>=3) {
                    System.out.println("You died from the Ebolas!!!\n\n");
                    shots.clear();
                    brains.clear();
                    runners.clear();
                    break;
                }
                System.out.println("1.) Keep Going");
                System.out.println("2.) Stop & Add to Bank");
                System.out.print("Enter Selection: ");
                selection=kb.nextInt();
                if(selection==1) {
                    while(runners.size()>0) {turnSummary.add(runners.remove(0));}
                    for(int x=turnSummary.size();x<3;x++) {
                        ZombieDie d= dearGod.draw();
                        if(d==null) {
                            turnSummary.clear();
                            dearGod.loadBucket();
                            break turn;
                        }
                        else {turnSummary.add(d);}
                    }
                    System.out.println("Current Dice: "+turnSummary);
                    for(int x=0;x<turnSummary.size();x++) {
                        turnSummary.get(x).roll();
                        if(turnSummary.get(x).getValue()==ZombieDie.BRAIN) {
                            brains.add(turnSummary.remove(x));
                        }
                        else if(turnSummary.get(x).getValue()==ZombieDie.RUNNER) {
                            runners.add(turnSummary.remove(x));
                        }
                        else if(turnSummary.get(x).getValue()==ZombieDie.SHOT) {
                            shots.add(turnSummary.remove(x));
                        }
                        if(turnSummary.size()==0) {
                            break;
                        }
                        x--;
                    }
                }
                else if(selection==2) {
                    scores[nplr]+=brains.size();
                    System.out.println("You ate "+brains.size()+" Brains this turn and now have the score of "+scores[nplr]);
                    brains.clear();
                    runners.clear();
                    shots.clear();
                    break;
                }
                else {System.out.println("Invalid Input");}
            }while(true);
            if(findWinners(names, scores)!=null) {
                System.out.println(findWinners(names, scores));
                System.exit(0);
            }
            nplr++;
        }while(true);
    }
    public static void shuffleNames(String[] names) {
        String temp;
        int r1, r2;
        for(int x=0; x<names.length;x++) {
            r1=(int)(Math.random()*names.length);
            r2=(int)(Math.random()*names.length);
            if(r1==r2) {continue;}
            temp=names[r1];
            names[r1]=names[r2];
            names[r2]=temp;
        }
    }
    public static String findWinners(String[] names, int[] scores) {
        for(int x=0; x<scores.length; x++)
        {
            if(scores[x]>=13)
            {
                return ""+ names[x]+" Wins";
            }
        }
        return null;
    }
}
