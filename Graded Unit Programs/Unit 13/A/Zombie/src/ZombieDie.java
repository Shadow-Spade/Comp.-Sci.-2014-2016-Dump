
public abstract class ZombieDie {
    public static final int NOT_ROLLED=0, RUNNER=1, BRAIN=2, SHOT=3, RED=1, GREEN=2, YELLOW=3;
    private int dieColor, value;
    public ZombieDie(int dieColor) {
        this.dieColor=dieColor;
        value=NOT_ROLLED;
    }
    public int getValue() {return value;}
    //public int getDieColor() {return dieColor;}
    //public void setDieColor(int dieColor) {this.dieColor = dieColor;}
    public void setValue(int value) {this.value = value;}
    public String toString() {
        if(value==NOT_ROLLED)
        {
            if(dieColor==RED)
            {
                return "Red";
            }
            else if(dieColor==GREEN)
            {
                return "Green";
            }
            else if(dieColor==YELLOW)
            {
                return "Yellow";
            }
        }
        else
        {
            if(dieColor==RED)
            {
                if(value==1)
                {
                    return "Red - Runner";
                }
                else if(value==2)
                {
                    return "Red - Brain";
                }
                else if(value==3)
                {
                    return "Red - Shot";
                }
            }
            else if(dieColor==GREEN)
            {
                if(value==1)
                {
                    return "Green - Runner";
                }
                else if(value==2)
                {
                    return "Green - Brain";
                }
                else if(value==3)
                {
                    return "Green - Shot";
                }
            }
            else if(dieColor==YELLOW)
            {
                if(value==1)
                {
                    return "Yellow - Runner";
                }
                else if(value==2)
                {
                    return "Yellow - Brain";
                }
                else if(value==3)
                {
                    return "Yellow - Shot";
                }
            }
        }
        return "";
    }
    public abstract void roll();
}
