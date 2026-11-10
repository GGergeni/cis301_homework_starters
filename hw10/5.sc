// #Sireum #Logika
//@Logika: --manual

//YOU DO THIS
//Add proof blocks in the subByOnes function and the test code
//When you finish, the assert statements should be verified

//You should not make any changes other than adding proof blocks

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//subtraction by ones
def subByOnes(a: Z, b: Z): Z = {
  Contract(
    Requires( b >= 0 ),
    Ensures( Res[Z] == a-b)
  )

  var answer: Z = a
  var i: Z = 0

  //the invariant holds before the loop begins
  //(you need to prove this)
  assert(answer == a - i)

  while (i != b) {
    Invariant(
      Modifies(i, answer),
      answer == a - i
    )

    answer = answer - 1

    i = i + 1

    //the invariant holds at the end of the iteration
    //(you need to prove this)
    assert(answer == a - i)
  }

  return answer
}

//////////// These assertions should hold when you are done /////////////

var test1: Z = 10
var test2: Z = 7

var sub: Z = subByOnes(test1, test2)

assert(sub == 3)

///

test1 = 2
test2 = 4

sub = subByOnes(test1, test2)

assert(sub == -2)