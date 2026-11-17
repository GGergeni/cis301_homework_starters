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
  Contract(
    Ensures(
      Res[Z] == 5 * x 
    )
  )

  var total: Z = x

  total = total + x*11

  Deduce(
    1 ( total == Old (total) + x*11) by Premise,
    2 (Old(total) == x) by Premise,
    3 (total == 12 * x) by Algebra*(1,2)
  )

  total = total - 7*x

  Deduce(
    1 ( total == Old(total) - 7*x) by Premise,
    2 ( Old(total) == 12 * x) by Premise,
    3 (total == 5 * x) by Algebra*(1,2)
  )

  return total
}

//////////// Test code (assert should hold when you finish) /////////////

val a: Z = 8

var addTest: Z = addFive(12-a)

Deduce(
  1 ( addTest == 5 * (12 - a)) by Premise,
  2 ( a == 8) by Premise,
  3 ( addTest == 20 ) by Algebra*(1,2)
)

assert(addTest == 20)
