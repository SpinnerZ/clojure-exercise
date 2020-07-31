(ns clojure-exercise.file-io)

(def file-origin "resources/walls-input.txt")
(def file-destiny "resources/chocolate-output.txt")

(defn str-input->units-int-vec
  "Transform a string input to a units int output"
  [string-input]
  (reduce #(conj %1 (Character/digit %2 10)) [] string-input))

(defn txt-vec->int-vec
  "Transforms a vector of strings to a vector of ints separate by units"
  [txt-vec]
  (map str-input->units-int-vec txt-vec))

(def walls (with-open [rdr (clojure.java.io/reader file-origin)]
                 (vec (line-seq rdr))))

(def walls-int-vec (txt-vec->int-vec walls))

(defn print-chocolate
  "Prints chocolate on screen and record on file-destiny.txt"
  [instant chocolate-amount]
  (spit file-destiny (println-str "Instante" instant "contém" chocolate-amount "unidades de chocolate.") :append true))