// #Sireum #Logika
//@Logika: --manual
import org.sireum._
import org.sireum.justification._

//YOU DO THIS:
//Add deduce blocks so each assert holds

//Do not change anything in the program or asserts.

//this block is needed in order to divide by 3
Deduce(
    1 ( 3 != 0 ) by Algebra T
)

var x: Z = Z.prompt("Enter a number: ")
val xOrig: Z = x

x = x * 2

assert(x == xOrig*2)

x = x + xOrig

assert(x == xOrig*3)

x = x / 3

assert(x == xOrig )

x = x - xOrig

print("No matter what you entered, you are back to 0")
assert(x == 0)
