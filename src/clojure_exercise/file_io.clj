(ns clojure-exercise.file-io)

(def file-origin "resources/medium.txt")
(def file-destiny "resources/chocolate-output.txt")

(defn txt-vec->int-vec
  "Transforms a vector of strings to a vector of ints"
  [txt-vec]
  (reduce #(conj %1 (Integer/parseInt %2)) [] txt-vec))

(def walls (with-open [rdr (clojure.java.io/reader file-origin)]
             (vec (line-seq rdr))))

(def walls-int-vec (txt-vec->int-vec walls))

(defn print-chocolate
  "Prints chocolate on screen and record on file-destiny.txt"
  [instant chocolate-amount]
  (let [text (str "Instante " instant " contém " chocolate-amount " unidades de chocolate.")]
    (do (spit file-destiny text :append true)
        (println text))))