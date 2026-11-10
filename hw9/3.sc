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

Deduce(
    1( a == Old(a) + b) by Premise,
    2 (aOrig == Old(a)) by Premise,
    3 (Old(a) >= 5) by Premise,
    4 (Old(a) <= 10) by Premise,
    5 (b >= 5 ) by Premise,
    6 (b <= 10) by Premise,
    7 (a == aOrig + b) by Algebra*(1,2),
    8 (a >= 10) by Algebra*(1,3,5),
    9 (a <= 20) by Algebra*(1,4,6),
    10 (a >= 10 & a <= 20) by AndI(8,9)
)

assert(a == aOrig + b)
assert(a >= 10 & a <= 20)

a = a + c

Deduce(
    1( a == Old(a) + c) by Premise,
    2 (Old(a) == aOrig + b) by Premise,
    3 (Old(a) >= 10) by Premise,
    4 (Old(a) <= 20) by Premise,
    5 (c >= 5 ) by Premise,
    6 (c <= 10) by Premise,
    7(a == aOrig + b + c) by Subst_<(2,1),
    8( a >= 15) by Algebra*(1,3,5),
    9(a <= 30) by Algebra*(1,4,6),
    10(a >=15 & a <= 30) by AndI(8,9)
)

assert(a == aOrig + b + c)
assert(a >= 15 & a <= 30)
