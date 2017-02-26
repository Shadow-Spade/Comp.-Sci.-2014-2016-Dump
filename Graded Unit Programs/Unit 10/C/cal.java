import java.util.Scanner;

public class cal {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int y, m;
        do {
            System.out.print("Enter a year (1900 or higher): ");
            y = kb.nextInt();
            if (y < 1900) {
                System.out.print("\nInvalid Input\n");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("Enter a month number(1-12): ");
            m = kb.nextInt();
            if (m < 1 || m > 12) {
                System.out.print("\nInvalid Input\n");

                continue;
            }
            break;
        } while (true);
        prntCal(y, m);
    }

    public static boolean leap(int y) {
        boolean lep = false;
        if (y % 4 == 0) {
            lep = true;
            if (y % 100 == 0) {
                lep = false;
                //noinspection RedundantIfStatement
                if (y % 400 == 0) {
                    lep = true;
                }
            }
        }
        return lep;
    }

    public static int days(int y, int m) {
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            return 31;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        } else if (m == 2) {
            //noinspection PointlessBooleanExpression
            if (leap(y) == false) {
                return 28;
            } else //noinspection PointlessBooleanExpression
                if (leap(y) == true) {
                    return 29;
                }
        }
        return 0;
    }

    public static int strtDay(int y, int m) {

        int d, bigd = 0;
        for (int x = 1900; x < y; x++) {
            if (leap(x)) {
                bigd += 366;
            } else {
                bigd += 365;
            }
        }
        for (int x = 1; x < m; x++) {
            bigd += days(y, x);
        }
        d = bigd % 7;
        return d;
    }

    public static void prntCal(int y, int m) {
        String mn = mnthNm(m), c = " ";
        int dn = days(y, m), sd = strtDay(y, m), h = 1;
        System.out.printf("%s %d\n\n", mn, y);
        print:
        for (int x = 0; x < 7; x++) {
            for (int p = 0; p < 7; p++) {
                if (x == 0) {
                    System.out.printf("%-10s", dayltr(p));
                } else if (x == 1) {
                    if (p <= sd) {
                        System.out.printf("%-10s", c);
                    } else if (p > sd) {
                        System.out.printf("%-10d", h);
                        h++;
                    }
                } else if (x > 1) {
                    System.out.printf("%-10d", h);
                    h++;
                }
                if (h > dn) {
                    break print;
                }
                if (p == 6) {
                    System.out.print("\n\n");
                }
            }
        }
    }

    public static String mnthNm(int m) {
        switch (m) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }

    }

    public static String dayltr(int p) {
        switch (p) {
            case 0:
                return "Sun";
            case 1:
                return "Mon";
            case 2:
                return "Tue";
            case 3:
                return "Wed";
            case 4:
                return "Thu";
            case 5:
                return "Fri";
            case 6:
                return "Sat";
            default:
                return "";
        }
    }
}