(ns clojure-exercise.core-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise.core :refer :all]))

(def medium-sample [26 28 6 69 91 64 35 65 71 49 69 67])

(facts "It should calculate the amount of chocolate per wall"
       (fact "It should work correctly with these little values"
             (chocolate-calculator 1 1 8) => 0
             (chocolate-calculator 2 2 8) => 0
             (chocolate-calculator 3 3 8) => 0
             (chocolate-calculator 7 7 8) => 0
             (chocolate-calculator 7 7 8) => 0
             (chocolate-calculator 3 7 8) => 4
             (chocolate-calculator 8 8 8) => 0
             (chocolate-calculator 0 8 8) => 8
             (chocolate-calculator 8 8 8) => 0
             (chocolate-calculator 2 8 2) => 0)

       (fact "It should work correctly with these medium values"
             (chocolate-calculator 26 26 91) => 0
             (chocolate-calculator 28 28 91) => 0
             (chocolate-calculator 6 28 91) => 22
             (chocolate-calculator 69 69 91) => 0
             (chocolate-calculator 91 91 91) => 0
             (chocolate-calculator 64 91 71) => 7
             (chocolate-calculator 35 91 71) => 36
             (chocolate-calculator 65 91 71) => 6
             (chocolate-calculator 71 91 71) => 0
             (chocolate-calculator 49 91 49) => 0))

(facts "It should return the position of the biggest right wall"
       (fact "It should pass the only vector arity"
             (nth (walls-instant small) (position-max-right (walls-instant small))) => (apply max small)
             (nth (walls-instant medium) (position-max-right (walls-instant medium))) => (apply max medium)
             (nth (walls-instant large) (position-max-right (walls-instant large))) => (apply max large))

       (fact "It should pass the any position arity"
             (nth (walls-instant small) (position-max-right (walls-instant small) 7 8)) => 8
             (nth (walls-instant small) (position-max-right (walls-instant small) 8 8)) => 2
             (nth (walls-instant small) (position-max-right (walls-instant small) 9 8)) => 2
             (nth medium-sample (position-max-right medium-sample 3 4)) => 91
             (nth medium-sample (position-max-right medium-sample 4 4)) => 91
             (nth medium-sample (position-max-right medium-sample 5 4)) => 71
             (nth medium-sample (position-max-right medium-sample 7 8)) => 71
             (nth medium-sample (position-max-right medium-sample 8 8)) => 69
             (nth medium-sample (position-max-right medium-sample 9 10)) => 69)

       (fact "It should pass the any position arity from position 0"
             (nth (walls-instant small) (position-max-right (walls-instant small) 0 -1)) => (position-max-right (walls-instant small))
             (nth (walls-instant medium) (position-max-right (walls-instant medium) 0 -1)) => (position-max-right (walls-instant medium))
             (nth (walls-instant large) (position-max-right (walls-instant large) 0 -1)) => (position-max-right (walls-instant large))
             (nth (walls-instant small) (position-max-right (walls-instant small) 0 0)) => (position-max-right (walls-instant small))
             (nth (walls-instant medium) (position-max-right (walls-instant medium) 0 0)) => (position-max-right (walls-instant medium))
             (nth (walls-instant large) (position-max-right (walls-instant large) 0 0)) => (position-max-right (walls-instant large))))