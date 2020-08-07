(defproject clojure-exercise "1.0"
  :description "A clojure skill test to learn the basics of the language and the functional paradigm"
  :url "https://github.com/SpinnerZ/clojure-exercise"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [midje "1.9.9"]]
  :plugins [[lein-midje "3.2.1"]
            [lein-cloverage "1.2.0"]]
  :repl-options {:init-ns clojure-exercise.core}
  :main clojure-exercise.core/-main)
