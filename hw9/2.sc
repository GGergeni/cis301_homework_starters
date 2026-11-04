// #Sireum #Logika
//@Logika: --manual
import org.sireum._
import org.sireum.justification._


//YOU DO THIS:
//Add deduce blocks so both asserts hold

//You should use the Subst rule at least twice in your deduce blocks.

//Do not change anything in the program or asserts.


var num: Z = Z.prompt("Enter a number: ")
val numOrig: Z = num

num = num + num

assert(num == 2*numOrig)

num = 2*num + 1

assert(num == 4*numOrig + 1)
