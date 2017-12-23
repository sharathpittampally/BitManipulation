## Bit Manipulations
#### & - bit wise AND.
#### | - bit wise OR.
#### ~ - bit wise NEGATE.
#### ^ - bit wise XOR.

### Important points:
 - NEGATE will flip bits (0 becomes 1 and vice versa).
 - XOR will result in 1 if two operands are not same else 0. 
 - We can get the negative of a number by calculating its 2's compliment.
 - Whenever we want to subtract two numbers say x and y:
 - > s = x - y
   > s = x + (-y)
   > s = x + (2's compliment of y).
   > - If there is a carry in the above operation discard it.(Since in this case the subtraction is lower value from a higher value)
   > - If there is no carry in the above step it means that the negative number is higher than the positive number so the answer must be a negative number, hence you have to again conver the obtained result to its 2's compliment and that is the final answer. 

#### 2's Compliment calculation:
> First flip the bits and then add 1 to it. This is the 2's complement and its equal to the negative of the number.
#### How is 2's compliment a negative number?
>*If you are curious about how is the 2's compliment a negative of the number, its because, lets say you are working on a 32bit machine, then each number is represented using 32bits. For example 5 is represented as:
 `00000000 00000000 00000000 00000101` - this value will evaluate to 5 as expected.
 But when you flip bits like the way you do it in the 2's compliment calculation the above number will become:
 `11111111 11111111 11111111 11111010` - this will evaluate to a very huge number so the programming language like java will move it over to the negative range of the Integer and that would be evaluated to `-5` when you add 1 to the above number.*
#### 1's Compliment calculation:
> Just flip the bits in the given number. That is the 1's compliment.