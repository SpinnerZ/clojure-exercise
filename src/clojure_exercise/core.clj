(ns clojure-exercise.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(def file-origin "resources/medium.txt")

(def walls (with-open [rdr (io/reader file-origin)]
             (reduce
               #(conj %1 (Integer/parseInt %2))
               []
               (line-seq rdr))))

(def walls-length (count walls))

(defn chocolate-at-position
  "Returns how much solid chocolate are in one specific wall"
  [position]
  (- (min (apply max (take (inc position) walls))
          (apply max (nthnext walls position)))
     (nth walls position)))

(defn chocolate-count
  "Count how many solid chocolate are there in the input vector of walls"
  ([position chocolate]
   (if (> walls-length (inc position))
     (recur (inc position) (+ chocolate (chocolate-at-position position)))
     chocolate)))

(defn -main
  []
  (time (print (chocolate-count 0 0))))