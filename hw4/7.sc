// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

/*
Use natural deduction to prove that the following two statements are equivalent:
    ¬(p → q)
    p ∧ ¬q

You will need to complete BOTH proofs below. When you are finished, run a Logika check 
(Ctrl-Shift-W or Command-Shift-W) Your file should say "Logika verified".
*/

@pure def hw4_prob7_part1(p: B, q: B): Unit = {
  Deduce(
    ( !(p __>: q) ) |-  ( p & !q )
      Proof(
        //COMPLETE PROOF HERE
        1 (!(p __>: q)) by Premise,

        2 SubProof(
          3 Assume(!p),
          4 SubProof(
            5 Assume(p),
            6 (F) by NegE(5, 3),
            7 (q) by BottomE(6),
          ),
          8 (p __>: q) by ImplyI(4),
          9 (F) by NegE(8, 1),
        ),
        10 (p) by PbC(2),

        11 SubProof(
          12 Assume(q),
          13 SubProof(
            14 Assume (p),
            15 (q & p) by AndI (12, 14),
            16 (q) by AndE1(15),
          ),
          17 (p __>: q) by ImplyI(13),
          18 (F) by NegE(17, 1),
        ),
        19  (!q) by NegI(11),

        20 (p & !q) by AndI(10, 19)
      )
  )
}

@pure def hw4_prob7_part2(p: B, q: B): Unit = {
  Deduce(
    ( p & !q ) |-  ( !(p __>: q) )
      Proof(
        //COMPLETE PROOF HERE
        1 (p & !q) by Premise,
        2 (p) by AndE1(1),
        3 (!q) by AndE2(1),

        4 SubProof(
          5 Assume (p __>: q),
          6 (q) by ImplyE(5, 2),
          7 (F) by NegE (6, 3),
        ),
        8 (!(p __>: q)) by NegI(4)
      )
  )
}
