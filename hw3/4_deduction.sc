// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, your file should say "Logika verified".

//p ∧ q, (((m ∧ n) ∧ r) ∧ t) ⊢ n ∧ t ∧ p


@pure def deduction4(p: B, q: B, m: B, n: B, r: B, t: B): Unit = {
    Deduce(
        //@formatter: off

        (p & q, m & n & r & t) |- (n & t & p)
        Proof(
            1 (  p & q            ) by Premise,
            2 (  m & n & r & t  ) by Premise,
            3 ( p ) by AndE1(1),
            4 ( m & n & r) by AndE1(2),
            5 ( m & n  ) by AndE1(4),
            6 ( n ) by AndE2 (5),
            7 ( t ) by AndE2(2),
            8 ( n & t ) by AndI(6, 7),
            9 ( n & t & p ) by AndI (8, 3),
            //FINISH THE PROOF HERE
        )
        //@formatter:on
    )
}