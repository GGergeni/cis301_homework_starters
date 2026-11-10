// #Sireum #Logika
//@Logika: --manual

//YOU DO THIS
//FIRST, write a function contract that promises that findMin returns the smallest of its two parameters.
//NEXT, add proof blocks in the findMin function and the test code
//When you finish, the assert statement should be verified

//You should not make any changes other than adding the function contract and the proof blocks


import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def findMin(x: Z, y: Z): Z = {
  //ADD FUNCTION CONTRACT

  var min: Z = 0

  if (x <= y) {
    min = x
  } else {
    min = y
  }

  return min
}

//////////// Test code (assert should hold when you finish) /////////////

val num1: Z = 6
val num2: Z = 4


val small: Z = findMin(num1, num2)

assert(small == 4)
