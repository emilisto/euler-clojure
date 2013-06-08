(ns euler.p2
  (:require [clojure [test :as test]]))

(defn llast [coll]
  (last (butlast coll)))

(test/with-test
  (defn fibonacci-til [max]
    "Gives the Fibonacci sequence whose terms go up to, but not equal to, max"
    (if (<= max 1)
      '(0)
      (loop [ seq '(0 1) ]
        (let [term (+ (last seq) (llast seq))]
          (if (< term max)
            (recur (concat seq (list term)) )
            seq)))))
  
  (test/is ( = (fibonacci-til 1) '(0 1)))
  (test/is ( = (fibonacci-til 2) '(0 1 1 2)))
  (test/is ( = (fibonacci-til 15) '(0 1 1 2 3 5 8 13))))

(defn euler-p2 []
  (reduce + (filter even? (fibonacci-til 4000000))))
