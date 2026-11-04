// #Sireum #Logika
//@Logika: --manual

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

val x: Z = Z.prompt("Enter a positive integer: ")
assume(x > 0)

val y: Z = Z.prompt("Enter a positive integer: ")
assume(y > 0)

val answer: Z = x + y


//YOU DO THIS:
//Write a deduce block so that the assert at the end holds.
//Do not change anything in the program or assert.



assert(answer >= x & answer >= y & answer >= 2)
