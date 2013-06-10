(ns euler.p5
  (:use euler.lib))

;; I solved this one without any coding - just find the prime factors of every
;; number from 1 to 20, and then find the maximum exponent for each
;; prime involved, this eventually leads to:
;;

(apply * [2 2 2 3 3 5 7 11 13 17 19])


