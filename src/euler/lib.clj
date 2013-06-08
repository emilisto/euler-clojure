(ns euler.lib
  (:require [clojure [test :as test]]))

(test/with-test

  (defn divisible-by? [n divisors]
    (some #(= 0 (rem n %1)) divisors))

  (test/is (divisible-by? 6 [3 7]))
  (test/is (divisible-by? 6 [3 2]))
  (test/is (not (divisible-by? 10 [ 7 3 ]))))
