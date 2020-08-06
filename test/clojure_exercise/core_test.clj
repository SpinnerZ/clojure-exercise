(ns clojure-exercise.core-test
  (:require [midje.sweet :refer :all]
            [clojure-exercise.core :refer :all]))

(def medium-sample [26 28 6 69 91 64 35 65 71 49 69 67])
(def example [0 2 0 1 2 0 1 0 3 0])

(facts "It should load the file input as a int vector"
       (fact "Testing filenames"
             (walls-instant small) => truthy
             (walls-instant medium) => truthy
             (walls-instant large) => truthy)

      (fact "Testing content"
            (walls-instant small) => [1 2 3 7 7 3 8 0 8 2]
            (take 12 (walls-instant medium)) => medium-sample))

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
             (nth (walls-instant small) (position-max-right (walls-instant small))) => (apply max (walls-instant small))
             (nth (walls-instant medium) (position-max-right (walls-instant medium))) => (apply max (walls-instant medium))
             (nth (walls-instant large) (position-max-right (walls-instant large))) => (apply max (walls-instant large))
             (position-max-right (take 4 example)) => 1)

       (fact "It should pass the any position arity"
             (position-max-right (take 4 example) 1 1) => 1
             (position-max-right (take 4 example) 2 1) => 3
             (position-max-right (take 4 example) 3 3) => 3
             (nth (walls-instant small) (position-max-right (walls-instant small) 7 8)) => 8
             (nth (walls-instant small) (position-max-right (walls-instant small) 8 8)) => 8
             (nth (walls-instant small) (position-max-right (walls-instant small) 9 8)) => 2
             (nth medium-sample (position-max-right medium-sample 3 4)) => 91
             (nth medium-sample (position-max-right medium-sample 4 4)) => 91
             (nth medium-sample (position-max-right medium-sample 5 4)) => 71
             (nth medium-sample (position-max-right medium-sample 7 8)) => 71
             (nth medium-sample (position-max-right medium-sample 8 8)) => 71
             (nth medium-sample (position-max-right medium-sample 9 10)) => 69)

       (fact "It should pass the any position arity from position 0"
             (position-max-right (walls-instant small) 0 -1) => (position-max-right (walls-instant small))
             (position-max-right (walls-instant medium) 0 -1) => (position-max-right (walls-instant medium))
             (position-max-right (walls-instant large) 0 -1) => (position-max-right (walls-instant large))
             (position-max-right (walls-instant small) 0 0) => (position-max-right (walls-instant small))
             (position-max-right (walls-instant medium) 0 0) => (position-max-right (walls-instant medium))
             (position-max-right (walls-instant large) 0 0) => (position-max-right (walls-instant large))))

(facts "Program overall comportment"
       (fact "Testing chocolate-count with know results"
             (chocolate-count (take 4 example)) => 1
             (chocolate-count (take 5 example)) => 3
             (chocolate-count example) => 8
             (chocolate-count (walls-instant small)) => 12
             (chocolate-count (walls-instant medium)) => 4055))