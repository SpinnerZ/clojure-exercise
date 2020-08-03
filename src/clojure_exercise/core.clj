(ns clojure-exercise.core
  (:require [clojure-exercise.file-io :refer :all])
  (:gen-class))

(defn chocolate-at-position
  "Returns how much solid chocolate are in one specific wall"
  [position walls-vec]
  (- (min (apply max (take (inc position) walls-vec))
          (apply max (nthnext walls-vec position)))
     (nth walls-vec position)))

(defn chocolate-count
  "Count how many solid chocolate are there in the input vector of walls"
  ([walls-vec] (chocolate-count 0 0 walls-vec))
  ([position chocolate walls-vec]
   (if (> (count walls-vec) (inc position))
     (recur (inc position) (+ chocolate (chocolate-at-position position walls-vec)) walls-vec)
     chocolate)))

(defn -main
  []
  (loop [instant 1
         head (conj [] (first walls-int-vec))
         tail (vec (rest walls-int-vec))]
    (if (first tail)
      (do (print-chocolate instant (chocolate-count head))
        (recur (inc instant) (conj head (first tail)) (rest tail)))
      (print-chocolate instant (chocolate-count head)))))