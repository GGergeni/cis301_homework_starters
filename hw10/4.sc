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

    Deduce(
      1 ( n == 1) by Premise,
      2 ( answer == 1 ) by Premise,
      3 ( answer == n*(n+1)/2) by Algebra*(1,2)
    )

  } else {

    Deduce(
      1 ( n >= 1) by Premise,
      2 ( !(n==1) ) by Premise,
      3 (n - 1 >= 1) by Algebra*(1,2),
      4 ( 2 != 0) by Premise
    )

    answer = sumUp(n-1)

    Deduce(
      1 (answer == (n-1)*((n-1)+1)/2) by Premise
    )

    answer = answer + n

    Deduce(
      1 (answer == Old(answer) + n) by Premise,
      2 ( Old(answer) == (n-1)*((n-1)+1)/2) by Premise,
      3 (answer == n*(n+1)/2) by Algebra*(1,2)
    )
  }

  Deduce(
    1 (answer == n*(n+1)/2) by Premise
  )

  return answer
}

//////////// Test code (asserts should hold when you finish) /////////////

var num: Z = 4

Deduce(
  1  ( 2 != 0 ) by Algebra T //needed for precondition
)

Deduce(
  1 ( num == 4 ) by Premise,
  2 ( num >= 1) by Algebra*(1)
)

val sumTo4: Z = sumUp(num)
println("The sum from 1 up to 4 is ", sumTo4)

Deduce( 
  1 (sumTo4 == num*(num+1)/2) by Premise,
  2 (num == 4) by Premise,
  3 (sumTo4 == 10) by Algebra*(1,2)
)

assert(sumTo4 == 10)

///

num = 6

Deduce(
  1 (2!=0) by Algebra T,
  2 (num == 6) by Premise,
  3 ( num >= 1) by Algebra*(2)
)

val sumTo6: Z = sumUp(num)
println("The sum from 1 up to 6 is ", sumTo6)

Deduce(
  1 (sumTo6 == num*(num+1)/2) by Premise,
  2 (num == 6) by Premise,
  3 (sumTo6== 21) by Algebra*(1,2)
)

assert(sumTo6 == 21)
