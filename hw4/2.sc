// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, run a Logika check (Ctrl-Shift-W or Command-Shift-W)
//Your file should say "Logika verified".


//(p → q) ∨ (p → r) ⊢ p → q ∨ r

@pure def hw4_prob2(p: B, q: B, r: B): Unit = {
  Deduce(
    ((p __>: q) | (p __>: r) ) |- ( (p __>: q | r ) )
      Proof(
        //COMPLETE PROOF HERE
        1 ((p __>: q) | (p __>: r)) by Premise,

        //case 1: assume p __>: q
        2 SubProof(
          3 Assume ( p __>: q),
          4 SubProof(
            5 Assume (p),
            6 (q) by ImplyE(3, 5),
            7 (q | r) by OrI1(6),
          ),
          8 (p __>: q | r) by ImplyI(4),
        ),

        //case 2: assume p __>: r
        9 SubProof(
          10 Assume(p __>: r),
          11 SubProof(
            12 Assume(p),
            13 (r) by ImplyE(10, 12),
            14 (q | r) by OrI2(13),
          ),
          15 (p __>: q | r) by ImplyI(11),
        ),
        16 (p __>: q | r) by OrE(1, 2, 9)
      )
  )
}
