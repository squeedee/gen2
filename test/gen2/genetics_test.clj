(ns gen2.genetics-test
  (:use midje.sweet
        clojure.test
        gen2.genetics))

(facts "about creatures"
       (fact "creatures express a combination of two parents genes"
           (let [mother {:genome ---mother-genome---}
                 father {:genome ---father-genome---}
                 child (creature mother father)]
             (:genome child) => ---child-genome---
             (provided
              (combine ---mother-genome--- ---father-genome---) => ---child-genome---))))