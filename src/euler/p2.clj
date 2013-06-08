(ns euler.p2
  (:require [clojure [test :as test]]))

(defn llast [coll]
  (last (butlast coll)))

(test/with-test
  (defn fibonacci-til [max]
    (if (= max 0)
      '(0)
      (if (= max 1)
        '(0 1)
        (loop [ seq '(0 1) ]
          (if (< (last seq) max)
            (let [term (+ (last seq) (llast seq))]
              (recur (concat seq (list term)) ))
            seq)))))
  (test/is ( = (fibonacci-til 1) '(0 1)))
  (test/is ( = (fibonacci-til 2) '(0 1 1 2)))
  (test/is ( = (fibonacci-til 13) '(0 1 1 2 3 5 8 13))))

(defn euler-p2 []
  (fibonacci-til 4000000))
