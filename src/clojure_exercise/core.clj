(ns clojure-exercise.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(def file-origin "resources/large.txt")

(def walls (with-open [rdr (io/reader file-origin)]
             (reduce
               #(conj %1 (Integer/parseInt %2))
               []
               (line-seq rdr))))

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
  (print (chocolate-count walls)))