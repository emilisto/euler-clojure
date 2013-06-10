(ns euler.lib
  (:require [clojure [test :as test]])
  (:require [clojure.math.numeric-tower :as math]))

(test/with-test
  (defn generate-primes [limit]
    "Find primes that are < limit using Eratosthenes Sieve, see
    http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes"
    [limit]
    (loop
        ;; The discovered primes, with 2 as the initial prime.
        [ primes '(2)
         ;; Collection of numbers that we "sieve through"
         numbers (apply sorted-set (range 3 limit 2))]
      (let [factor (first numbers)]
        ;; Loop as long as we have more numbers
        (if (and (seq numbers) (< factor (Math/sqrt limit)))
          ;; Construct a sieve set of numbers that are multiple of
          ;; factor, that will all be removed from the numbers set,
          ;; to give us the next prime number, as the first remaining
          ;; number in numbers.
          (let [sieve (range factor limit (* 2 factor))]
            ;; Apply the sieve, collect the new prime and repeat.
            (recur (cons factor primes) (apply disj (cons numbers sieve))))
          (apply conj (cons numbers primes)))))
    ))

(test/with-test
  (defn is-divisor?
   [num, divisor]
   (= 0 (rem num divisor)))
  (test/is (is-divisor? 8 2))
  )

(test/with-test
  (defn prime-factor [n]
    (loop [factors []
           n n,
           candidates (generate-primes (Math/ceil (Math/sqrt n)))]
      (let [candidate (first candidates)]
        (cond
         (= n 1) factors
         (= nil candidate) (conj factors n)
         (is-divisor? n candidate) (recur (conj factors candidate)
                                          (/ n candidate)
                                          candidates)
         :else (recur factors n (nthrest candidates 1))
         ))))
  (test/is (= '(2 3 3 5 7 19) (prime-factor 11970))))

(test/with-test
  (defn factor [n]
    ))

(test/with-test
  
  (defn divisible-by? [n divisors]
    (some #(= 0 (rem n %1)) divisors))
  
  (test/is (divisible-by? 6 [3 7]))
  (test/is (divisible-by? 6 [3 2]))
  (test/is (not (divisible-by? 10 [ 7 3 ]))))

(defn square [n] (math/expt n 2))
