(ns euler-p10
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
 (defn sum-primes-below
   [n]
   (apply + (generate-primes n))
   )
 (test/is (= (sum-primes-below 10) 17)))

(defn euler-p10
  []
  (sum-primes-below 2000000)
  )
