// #Sireum #Logika
//@Logika: --manual
import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//YOU DO THIS:
//Add deduce blocks so each assert holds.

//Do not change anbthing in the program or asserts.


var a: Z = Z.prompt("Enter a an integer between 5-10: ")
var b: Z = Z.prompt("Enter a an integer between 5-10: ")
var c: Z = Z.prompt("Enter a an integer between 5-10: ")

val aOrig: Z = a

assume(a >= 5)
assume(a <= 10)
assume(b >= 5)
assume(b <= 10)
assume(c >= 5)
assume(c <= 10)

a = a + b

assert(a == aOrig + b)
assert(a >= 10 & a <= 20)

a = a + c

assert(a == aOrig + b + c)
assert(a >= 15 & a <= 30)
