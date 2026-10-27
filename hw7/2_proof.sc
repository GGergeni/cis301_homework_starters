// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, run a Logika check -- your file should say "Logika verified".

//∀ x (student(x) → csharp(x)), ∃ x ¬csharp(x) ⊢ ∃ x ¬student(x)

@pure def proof2[T](student: T=>B @pure, csharp: T=>B @pure): Unit = {
  Deduce(
    (
      ∀((x: T) => (student(x) __>: csharp(x))),
      ∃((x: T) => !csharp(x))
    )
      |-
      (
        ∃((x: T) => !student(x))
      )
      Proof(
        //COMPLETE PROOF HERE
        1 (∀((x: T) => (student(x) __>: csharp(x)))) by Premise,
        2 ( ∃((x: T) => !csharp(x)) ) by Premise,
        3 Let((c: T) => SubProof(
          4 Assume (!csharp(c) ),
          5 ( student(c) __>: csharp(c)) by AllE[T](1),
          6 SubProof(
            7 Assume(student(c)),
            8 (csharp(c)) by ImplyE(5,7),
            9 (F) by NegE(8,4)
          ),
          10 (!student(c)) by NegI(6),
          11(∃((x: T) => !student(x))) by ExistsI[T](10),
        )),
        12 (∃((x: T) => !student(x))) by ExistsE[T](2,3)
      )
  )
}
