// #Sireum #Logika
//@Logika: --manual

//YOU DO THIS
//Add proof blocks in the sumUp function and the test code
//When you finish, the assert statements should be verified

//You will need to prove the preconditions before ANY function call
//(recursive or otherwise) and prove the postcondition by the end
//of the function. Be sure to use what you know about proving if/else
//statements to show the postcondition holds in BOTH branches of the function.

//You can use the postcondition after a function call in the test code
//to help prove the next assert statement.

//You should not make any changes other than adding proof blocks


import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def sumUp(n: Z): Z = {
  Contract(
    Requires (n >= 1, 2 != 0),      //preconditions (the 2 != 0 is needed to use division in the postcondition)
    Ensures (Res[Z] == n*(n+1)/2)   //postcondition
  )

  var answer: Z = 0

  if (n == 1)  {
    answer = 1

  } else {

    answer = sumUp(n-1)

    answer = answer + n
  }

  return answer
}

//////////// Test code (asserts should hold when you finish) /////////////

var num: Z = 4

Deduce(
  1  ( 2 != 0 ) by Algebra T //needed for precondition
)

val sumTo4: Z = sumUp(num)
println("The sum from 1 up to 4 is ", sumTo4)

assert(sumTo4 == 10)

///

num = 6

val sumTo6: Z = sumUp(num)
println("The sum from 1 up to 6 is ", sumTo6)

assert(sumTo6 == 21)
