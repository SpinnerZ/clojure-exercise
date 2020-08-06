(ns clojure-exercise.core
  (:gen-class))

(def small "resources/small.txt")
(def medium "resources/medium.txt")
(def large "resources/large.txt")

(defn walls-instant
  "Returns a int vector of numbers from txt-input"
  [file-origin]
  (let [walls (slurp file-origin)]
    (vec (map #(Integer/parseInt %) (clojure.string/split walls #"\n")))))

(defn position-max-right
  "Returns the position of the biggest value after the position input"
  ([walls] (.indexOf walls (apply max walls)))
  ([walls position previous-biggest-value-position]
   (if (< position previous-biggest-value-position)
     previous-biggest-value-position
     (+ position
        (position-max-right (drop position walls))))))

(defn chocolate-calculator
  "Returns how much solid chocolate are in one specific wall"
  [position-value left-biggest-value right-biggest-value]
  (- (min left-biggest-value right-biggest-value)
     position-value))

(defn chocolate-count
  "Count how many solid chocolate are there in the input vector of walls"
  ([walls]
   (chocolate-count walls (count walls) 0 (first walls) (position-max-right walls) 0))
  ([walls length position left-value right-position chocolate]
   (if (> length (inc position))
     (recur walls
            length
            (inc position)
            (max left-value
                 (nth walls (inc position)))
            (position-max-right walls (inc position) right-position)
            (+ chocolate
               (chocolate-calculator
                 (nth walls position)
                 left-value
                 (nth walls right-position))))
     chocolate)))

(defn -main
  [walls]
  (println (chocolate-count (walls-instant walls))))