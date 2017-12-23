package com.sharath.bits;

public class Arithmetic
{
    public static void main(String[] args)
    {
        System.out.println("Additions.......");
        System.out.println(add(13, 18));
        System.out.println(add(23, 27));
        System.out.println(add(14, -57));

        System.out.println("Subtractions........");
        System.out.println(subtract(5, 3));
        System.out.println(subtract(3, 5));
        System.out.println(subtract(-3, -5));

        System.out.println("Subtractions using addition........");
        System.out.println(subtractUsingAdd(5, 3));
        System.out.println(subtractUsingAdd(3, 5));
        System.out.println(subtractUsingAdd(-3, -5));

        System.out.println("multiplications.......");
        System.out.println(multiply(11, 5));
        System.out.println(multiply(11, -5));
        System.out.println(multiply(-12, 5));

        System.out.println("divisions........");
        System.out.println(divide(16, 8));
        System.out.println(divide(0, 243));
        System.out.println(divide(-55, 11));
        System.out.println(divide(-55, -11));
        System.out.println(divide(-11, 55));
        System.out.println(divide(16, 3));
    }

    private static int add(int a, int b)
    {
        if (b == 0)
            return a;
        if (a == 0)
            return b;
        int sum = a ^ b; // sum without carry.
        int carry = (a & b) << 1; // initial carry.

        // After the above two steps the next process would be adding sum and
        // carry until carry is 0. Once there is no more carry that
        // answer will be the final answer.
        while (carry != 0)
        {
            int nextCarry = (sum & carry) << 1; // Next carry that might come
                                                // when we try to add sum and
                                                // present carry.
            sum = sum ^ carry;
            carry = nextCarry;
        }
        return sum;
    }

    private static int subtract(int a, int b)
    {
        int diff = a ^ b;
        int borrow = (~a & b) << 1;

        while (borrow != 0)
        {
            int nextBorrow = (~diff & borrow) << 1;
            diff = diff ^ borrow;
            borrow = nextBorrow;
        }
        return diff;
    }

    /**
     * a - b means a + (-b). Hence convert b to a negative number and then
     * perform the add operation.
     * 
     * @param a
     * @param b
     * @return
     */
    private static int subtractUsingAdd(int a, int b)
    {
        b = add(~b, 1); // 2's compliment for b.
        return add(a, b);
    }

    private static int multiply(int a, int b)
    {
        if (a == 0 || b == 0)
            return 0;
        int i = 0;
        int res = 0;
        if (b < 0)
        {
            a = add(~a, 1); // convert a to negative
            b = add(~b, 1); // convert b to positive.
        }
        while (i < b)
        {
            res = add(res, a); // a times b means adding a + a + a + a + a ....
                               // b times.
            i = add(i, 1); // increment i.
        }
        return res;
    }

    /**
     * Dividing is the process of grouping. For example divide 6 by 2 means how
     * many groups of 2 are formed in 6 (1, 1); (1, 1); (1, 1) - total 3 groups.
     * Similar logic is applied here.
     * 
     * @param a
     * @param b
     * @return
     */
    private static int divide(int a, int b)
    {
        int x = a;
        int y = b;
        if (x == y)
            return 1;
        if (x == 0)
            return 0;
        if (x < 0)
            x = add(~a, 1);
        if (b < 0)
            y = add(~b, 1);
        if (x < y && (x > 0) && (y > 0))
            return 0;
        if (y == 0)
            return Integer.MAX_VALUE;

        int i = 1;
        int res = 0;
        int group = 0;
        while (i <= x)
        {
            group = add(group, 1);
            if (group == y)
            {
                res = add(res, 1);
                group = 0;
            }
            i = add(i, 1);
        }
        if ((a < 0 && b > 0) || (a > 0 && b < 0))
            return add(~res, 1);
        return res;
    }
}
