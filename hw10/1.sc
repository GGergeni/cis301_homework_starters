// #Sireum #Logika
//@Logika: --manual

//YOU DO THIS
//Add proof blocks in the minus function and the test code
//When you finish, the assert statements should be verified

//You should not make any changes other than adding proof blocks

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def fourTimes(x: Z, y: Z): Z = {
  Contract(
    Requires(x == y & y > 0),
    Ensures(
      Res[Z] == 4*x,
      Res[Z] >= 4
    )
  )

  var sub: Z = x + y

  Deduce(
    1 ( sub == x + y) by Premise
  )

  sub = sub * 2

  Deduce(
    1 ( x == y & y > 0) by Premise,
    2 ( x == y) by AndE1(1),
    3 ( y > 0) by AndE2(1),
    4 (sub == Old(sub) * 2) by Premise,
    5 (Old(sub) == x + y) by Premise,
    6 ( sub == 4 * x) by Algebra*(2,4,5),
    7 ( x > 0) by Algebra*(2,3),
    8(sub >= 4) by Algebra*(6,7),
  )

  return sub
}

//////////// Test code (asserts should hold when you finish) /////////////

val a: Z = Z.read()
val b: Z = Z.read()

assume(a == 4)
assume(b > 4 & b < 6)

Deduce(
  1 ( a == 4) by Premise,
  2 ( b > 4 & b < 6) by Premise,
  3 ( b > 4) by AndE1(2),
  4 ( b < 6) by AndE2(2),
  5 (b == 5) by Algebra*(3,4),
  6 ( a == b -1) by Algebra*(1,5),
  7 (b - 1 > 0) by Algebra*(3),
  8 (a == b - 1 & b -1 > 0 ) by AndI(6,7)
)

var test: Z = fourTimes(a, b-1)

Deduce(
  1 ( test == 4 * a) by Premise,
  2 ( a == 4 ) by Premise,
  3 ( test == 16) by Algebra*(1,2)
)

assert(test == 16)


/////////

val j: Z = 7
val k: Z = 4

Deduce(
  1 ( j == 7) by Premise,
  2 ( k == 4) by Premise,
  3 (j - 3 ==k) by Algebra*(1,2),
  4(k>0) by Algebra*(2),
  5(j - 3 ==k&k>0) by AndI(3,4)
)

test = fourTimes(j-3, k)

Deduce(
  1 (test == 4 * (j-3)) by Premise,
  2 (j == 7) by Premise,
  3 (test == 16) by Algebra*(1,2),
)

assert(test == 16)
