(ns euler.p4
  (:require  [clojure [string]]))


(defn palindrome?
  [num]
  (= (seq (str num)) (reverse (str num))))

(defn n-digit-range
  [digits]
  (map int (range (Math/pow 10 (- digits 1))
                  (Math/pow 10 digits))))
(defn products-of-n-digit-numbers
  [digits]
  (set (for [ a (n-digit-range digits) b (n-digit-range digits) ] (* a b))))

(defn euler-p4
  []
  (apply max (filter palindrome? (products-of-n-digit-numbers 3))))
