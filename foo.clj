;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(ns quil-sketches.gen-art.03-concentric-circles
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [gen2.genetics :as gen]))

(def chromosome (vec (take 400 (repeatedly #(rand-int 256)))))

(def start-bg (gen/gene 0 3))
(def start-center (gen/gene 3 2))
(def branching-limits (gen/gene 5 2))
(def branching-angle-limits (gen/gene 7 2))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (apply q/background (start-bg chromosome))
  {:genes {:branching-limits (branching-limits chromosome)
           :branching-angle-limits (branching-angle-limits chromosome)}
   :current-branches [(start-center chromosome)]
   })

(defn update-state [state]
  {:genes (:genes state)
   :current-branches (:current-branches state)})

(defn draw-state [state]
  )

(q/defsketch genetic1
  :title "Gosh"
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode]
  :size [500 500])

(defn -main [& args])
