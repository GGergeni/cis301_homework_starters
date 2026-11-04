// #Sireum #Logika
//@Logika: --manual

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//YOU DO THIS:
//Add proof blocks so the asserts hold.

//Do not change anything in the program or asserts.

val a: Z = Z.read()
val b: Z = Z.read()
var small: Z = 0

if (a < b) {
  small = a
} else {
  small = b
}

print("small of ", a, " and ", b, " is ", small)
assert(small <= a)
assert(small <= b)
assert(small == a | small == b)
