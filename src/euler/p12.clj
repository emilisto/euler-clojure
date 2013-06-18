(ns euler-p12
  (:require [clojure [test :as test]])
  (:require [clojure.math.combinatorics :as combo])
  (:use euler.lib))

;; Trying out the threading macro - enables you to write expression
;; outside-in instead of inside out, which more resembles the
;; imperative style programming. Not sure which one I like the best.
(defn divisors [n]
  (->>
   (prime-factor n)
   ;; Get all combinations of prime non-unique factors
   combo/subsets
   ;; except for the empty set
   (filter #(not (empty? %)))
   ;; multiply them together
   (map #(apply * %))
   ;; and exclude duplicates
   set))

(defn nth-triangular-number [n]
  (/ (* n (+ n 1)) 2))

(defn first-triangular-number-with-n-divisors [n-divisors]
  (loop [n 1]
    (if (>= (count (divisors (nth-triangular-number n))) n-divisors)
      n
      (recur (inc n)))))

;; This takes 117 seconds to run on my MacBook, not an okay solution.
(defn euler-p12 []
  (time
   (nth-triangular-number (first-triangular-number-with-n-divisors 500))))


