(ns euler-p7
  (:use euler.lib))

(defn estimate-primes-below
  [n]
  (/ n (Math/log n)))

;;
;; Playing with this yields
;;
;;    (estimate-primes-below 150000) => ~ 12500
;;
;; #_(could-have-implemented "newton's method" (but "who" "cares" "at"
;; "this" "stage"))
;;

(defn euler-p7
  []
  (nth (seq (generate-primes 150000)) 10000))
