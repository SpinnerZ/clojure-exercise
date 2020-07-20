(ns clojure-exercise.core)

(def filename "resources/walls-input.txt")

(defn parse
  "Takes a String and split it to create a seq of ints"
  [all-inputs]
  (reduce #(conj %1 (Integer. %2))
          []
          (clojure.string/split all-inputs #"\n"))
  )

(def walls-seq (parse (slurp filename)))

(defn how-much-chocolate
  "Calculate how many chocolate is solid between 3 walls"
  [left middle right]
  (let [solid-chocolate (- (min left right) middle)]
    (if (> solid-chocolate 0)
      solid-chocolate
      0)))