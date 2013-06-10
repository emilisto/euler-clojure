(ns euler-p9
  (:require [clojure [test :as test]])
  (:require [clojure.math.numeric-tower :as math])
  (:use euler.lib))

(defn make-increasing-triples-summing-to
  [limit]
  ;; This one's real slow and could definately use some improved efficiency
  (for [a (range limit) b (range limit)
        :when (< a b)
        :let [c (apply - [ 1000 a b])]
        :when (< b c)]
    [a b c ]))

(test/with-test
 (defn pythagorean-triplet?
   [triplet]
   (= (+ (square (nth triplet 0))
         (square (nth triplet 1)))
      (square (nth triplet 2))))
 
 (test/is (pythagorean-triplet? [3 4 5])))

(defn euler-p9
  []
  (apply * (first (filter pythagorean-triplet? (make-increasing-triples-summing-to 1000)))))
