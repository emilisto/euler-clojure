(ns euler.p3
  (:require [clojure [test :as test]])
  (:require [clojure [core]]))

(test/with-test
  (defn generate-primes [limit]
    "Find primes < limit using Eratosthenes Sieve"
    [limit]
    (loop
        ;; The discovered primes, with 2 as the initial prime.
        [ primes '(2)
         ;; Collection of numbers that we "sieve through"
         numbers (apply sorted-set (range 3 limit 2))]
      (let [factor (first numbers)]
        ;; Loop as long as we have more numbers
        (if (seq numbers)
          (let [sieve (range factor limit factor)]
            (recur (cons factor primes) (apply disj (cons numbers sieve))))
          primes)))
  ))

(defn euler-p3 []
  )
