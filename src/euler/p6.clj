(ns euler.p6
  ;; I learned quiet a bit getting this bastard down, apparently
  ;; clojure.contrib.math has been moved to 'numeric-tower'. This
  ;; required some fiddling with lein and editing of project.clj to
  ;; get it worked.
  (:use euler.lib))



(defn euler-p6
  []
  (let [numbers (range 1 (+ 100 1))]
    (-
     (square (apply + numbers))
     (apply + (map square numbers)))))
