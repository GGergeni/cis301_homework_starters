// #Sireum #Logika
import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, run a Logika check -- your file should say "Logika verified".


//∃ x (ksu(x) ∨ ku(x)), ¬(∃ x ku(x)) ⊢ ∃ x ksu(x)

@pure def proof1[T](ksu: T=>B @pure, ku: T=>B @pure): Unit = {
  Deduce(
    (
      ∃((x: T) => (ksu(x) | ku(x))),
      !(∃((x: T) => ku(x)))
    )
      |-
    (
      ∃((x: T) => ksu(x))
    )
    Proof(
        //COMPLETE PROOF HERE
      1 ( ∃((x: T) => (ksu(x) | ku(x))) ) by Premise,
      2 (!(∃((x: T) => ku(x)))) by Premise,
      3 Let((c:T) => SubProof(
        4 Assume( ksu(c) | ku(c)),
        5 SubProof(

          6 Assume( ksu(c)),
          7 (∃((x: T) => ksu(x)) ) by ExistsI[T](6)
          
        ),
        8 SubProof(
          9 Assume (ku(c)),
          10 (∃((x: T) => ku(x))) by ExistsI[T](9),
          11 (F) by NegE(10,2),
          12 (∃((x: T) => ksu(x))) by BottomE(11)
        ),
        13 (∃((x: T) => ksu(x))) by OrE(4, 5, 8)
      )),
      14 (∃((x: T) => ksu(x))) by ExistsE[T](1,3)
    )
  )
}
