// #Sireum #Logika
//@Logika: --manual

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//YOU DO THIS:
//Add deduce blocks so the assert holds.

//Do not change anything in the program or assert.

val x: Z = Z.read()

assume (x >= 1 & x <= 3)

var result: Z = x

if (x == 1) {
    result = result * 6

    Deduce(
        1 (result == Old(result) * 6) by Premise,
        2 (Old(result) == x) by Premise,
        3 (x ==1 ) by Premise,
        4 (result == 6) by Algebra*(1,2,3)
    )

} else {
    if (x == 2) {
        result = result * 3

        Deduce(
            1 (result == Old(result) * 3) by Premise,
            2 (Old(result) == x) by Premise,
            3 (x == 2) by Premise,
            4 (result == 6) by Algebra*(1,2,3)
        )

    } else {
        result = result + 3

        Deduce(
            1 (result == Old(result) + 3) by Premise,
            2 (Old(result) == x) by Premise,
            3 ( x >= 1 & x <= 3) by Premise,
            4 (x >= 1) by AndE1(3),
            5 (x <= 3) by AndE2(3),
            6 (!(x == 1)) by Premise,
            7 (!(x == 2)) by Premise,
            8 (x == 3) by Algebra*(4,5,6,7),
            9 (result == 6) by Algebra*(1,2,8)
        )
    }

    Deduce(
        1 (result == 6) by Premise
    )

    //add a Deduce block here to summarize what you learned in the inner if/else
}

Deduce(
    1 (result == 6) by Premise
)

//add a Deduce block here to summarize what you learned in the outer if/else


assert(result == 6)
