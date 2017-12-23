package com.sharath.bits;

public class IsNumberAPowerOfTwo
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(isPowOfTwo(0));
        System.out.println(isPowOfTwo(4));
        System.out.println(isPowOfTwo(6));
    }

    private static boolean isPowOfTwo(int x)
    {
        if (x == 0)
            return false;
        int check = x & (x - 1);
        if (check == 0)
            return true;
        return false;
    }

}
