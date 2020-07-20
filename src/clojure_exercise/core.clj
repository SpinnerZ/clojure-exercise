(ns clojure-exercise.core)

(def file-origin "resources/walls-input.txt")
(def file-destiny "resources/walls-output.txt")

(defn parse
  "Takes a String and split it to create a seq of ints"
  [all-inputs]
  (reduce #(conj %1 (Integer. %2))
          []
          (clojure.string/split all-inputs #"\n"))
  )

(def walls-seq (parse (slurp file-origin)))

(defn how-much-chocolate
  "Calculate how many chocolate is solid between 3 walls"
  [left middle right]
  (let [solid-chocolate (- (min left right) middle)]
    (if (> solid-chocolate 0)
      solid-chocolate
      0)))

(defn print-chocolate
  "Prints chocolate on screen and record on file-destiny.txt"
  [instant chocolate-amount]
  (spit file-destiny (print-str "Instante" instant "contém" chocolate-amount "unidades de chocolate. \n") :append true))