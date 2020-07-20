(ns clojure-exercise.core)

(def filename "resources/walls-input.txt")

(defn parse
  "Takes a String and split it to create a seq of ints"
  [all-inputs]
  (reduce #(conj %1 (Integer. %2))
          []
          (clojure.string/split all-inputs #"\n"))
  )

(def input-seq (parse (slurp filename)))