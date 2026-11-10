// #Sireum #Logika
//@Logika: --manual

//YOU DO THIS
//Add proof blocks in the sumUp function and the test code
//When you finish, the assert statement should be verified

//You should not make any changes other than adding proof blocks

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def sumUp(n: Z): Z = {
  Contract(
    Requires ( n >= 1, 2 != 0 ),
    Ensures (Res[Z] == n*(n+1)/2)
  )

  var sum: Z = 0
  var i: Z = 0

  //the invariant holds before the loop begins
  //(you need to prove this)
  assert(sum == i * (i+1)/2)

  while (i != n) {
    Invariant(
      Modifies(sum, i),
      sum == (i * (i+1))/2
    )

    i = i + 1

    sum = sum + i

    //the invariant holds at the end of the iteration
    //(you need to prove this)
    assert(sum == i * (i+1)/2)
  }

  return sum
}

//////////// Test code /////////////

var num: Z = 6

val sumTo6: Z = sumUp(num)
println("The sum from 1 up to 6 is ", sumTo6)

assert(sumTo6 == 21)