(ns gen2.genetics)


(defn gene [start length]
  (let [end (+ start length)]
    (fn [chromosome] (subvec chromosome start end))))
