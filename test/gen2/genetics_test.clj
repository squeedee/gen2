(ns gen2.genetics-test
  (:use midje.sweet
        clojure.test
        gen2.genetics))

(facts "about a gene"
       (fact "a gene is a start-length vector on the chromosome"
             (let [chromosome (vec "aeiou1234567890")
                   gene-1 (gene 0 3)
                   gene-2 (gene 3 2)
                   gene-3 (gene 5 5)]

               (gene-1 chromosome) => (vec "aei")
               (gene-2 chromosome) => (vec "ou")
               (gene-3 chromosome) => (vec "12345")))

       (fact "any gene can easily overlap another"
             (let [chromosome (vec "aeiou1234567890")
                   gene-1 (gene 0 10)
                   gene-2 (gene 5 10)]

               (gene-1 chromosome) => (vec "aeiou12345")
               (gene-2 chromosome) => (vec "1234567890"))))



