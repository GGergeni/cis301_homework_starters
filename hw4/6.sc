// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

/*
Use natural deduction to prove that the following two statements are equivalent:
    p → q
    ¬p ∨ q

You will need to complete BOTH proofs below. When you are finished, run a Logika check 
(Ctrl-Shift-W or Command-Shift-W) Your file should say "Logika verified".
*/

@pure def hw4_prob6_part1(p: B, q: B): Unit = {
  Deduce(
    ( p __>: q ) |-  ( !p | q )
      Proof(
        //COMPLETE PROOF HERE
        1 (p __>: q) by Premise,

        2 SubProof(
          3 Assume(!(!p | q)),

          //derive !p from the assumption

          4 SubProof(
            5 Assume(p),
            6 (q) by ImplyE(1, 5),
            7(!p | q) by OrI2(6),
            8 (F) by NegE(7, 3),
          ),
          9 (!p) by NegI(4),
          10 (!p | q) by OrI1(9),
          11(F) by NegE(10, 3),

        ),
        12 (!p | q) by PbC(2)
      )
  )
}

@pure def hw4_prob6_part2(p: B, q: B): Unit = {
  Deduce(
    ( !p | q ) |-  ( p __>: q )
      Proof(
        //COMPLETE PROOF HERE
        1 (!p | q) by Premise,

        2 SubProof(
          3 Assume (!p),
          4 SubProof(
            5 Assume(p),
            6 (F) by NegE(5,3),
            7 (q) by BottomE(6),
          ),
          8 (p __>: q) by ImplyI(4),
        ),

        9 SubProof(
          10 Assume(q),
          11 SubProof(
            12 Assume(p),
            13 (q & p) by AndI (10, 12),
            14 (q) by AndE1(13),
          ),
          15 (p __>: q) by ImplyI(11),
        ),
        16 (p __>: q) by OrE(1, 2, 9)
      )
  )
}
