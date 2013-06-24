(ns euler-p14)

(defn create-collatz-sequence
  [start]
  (loop [n start, chain []]
    (if (<= n 1)
      (conj chain 1)
      (let [next (if (even? n)
                   (/ n 2)
                   (+ 1 (* 3 n)))]
        (recur next (conj chain n))))))

(defn collatz-chain-length [n]
  (count (create-collatz-sequence n)))

(defn index-of-max [arr]
  (.indexOf arr (apply max arr)))

;; Solution runs in 27 seconds, but doesn't feel beautiful.
(defn longest-collatz-up-to [n]
  (inc (index-of-max (map collatz-chain-length (range 1 n)))))

(defn euler-p14 []
  (longest-collatz-up-to 1000000))
