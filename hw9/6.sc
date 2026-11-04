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
} else {
    if (x == 2) {
        result = result * 3
    } else {
        result = result + 3
    }

    //add a Deduce block here to summarize what you learned in the inner if/else
}

//add a Deduce block here to summarize what you learned in the outer if/else


assert(result == 6)
