(ns gen2.genetics)

;; (defn combine [mother-genome father-genome])

(defn creature [mother father]
  (combine (:genome mother) (:genome father)))

