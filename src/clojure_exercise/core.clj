(ns clojure-exercise.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(def file-origin "resources/medium.txt")

(defn print-chocolate
  "Prints the amount of chocolate in a instant on screen"
  [instant chocolate-amount]
  (println (str "Instante " instant " contém " chocolate-amount " unidades de chocolate.")))

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
  (with-open [rdr (io/reader file-origin)]
    (reduce
      (fn [previous-walls new-wall]
        (let [walls (conj previous-walls (Integer/parseInt new-wall))]
          (print-chocolate (count walls) (chocolate-count walls))
          walls))
      []
      (line-seq rdr))))