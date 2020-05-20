package mooc.vandy.java4android.gate.logic;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public OutputInterface mOut;

    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0 ;
    private int mSwing;
    Gate(){
        mSwing = CLOSED;
    }

    public boolean setSwing(int direction)
    {
        mSwing = direction;
        return true;
    }
    public boolean open(int direction)
    {
        if(direction == 1 || direction == -1){
            return setSwing(direction);
        }
        else
        return false;
    }

    public void close()
    {
        mSwing = CLOSED;
    }

    public int getSwingDirection()
    {
        return  mSwing;
    }

    public int thru(int count)
    {
        if(mSwing == IN)
            count += count;
        if(mSwing == OUT)
            count -= count;
        if(mSwing == CLOSED)
            count += 0;
        return count;
    }
    public String toString()
    {
        String str = "";
        if(mSwing == CLOSED)
            str = "This gate is closed";
         else {
            if (mSwing == IN)
                str = "This gate is open and swings to enter the pen only";
            else if (mSwing == OUT)
                str = "This gate is open and swings to exit the pen only";
            else
                str = "This gate has an invalid swing direction";
        }
         return str;
    }
}
