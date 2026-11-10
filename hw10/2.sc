// #Sireum #Logika
//@Logika: --manual 

//YOU DO THIS
//FIRST, write an appropriate function contract (think about what addFive returns in terms of
  //its parameter.
//NEXT, add proof blocks in the addFive function and the test code
//When you finish, the assert statement should be verified

//You should not make any changes other than adding the function contract and the proof blocks

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def addFive(x: Z): Z = {
  //WRITE FUNCTION CONTRACT

  var total: Z = x

  total = total + x*11

  total = total - 7*x

  return total
}

//////////// Test code (assert should hold when you finish) /////////////

val a: Z = 8

var addTest: Z = addFive(12-a)

assert(addTest == 20)
