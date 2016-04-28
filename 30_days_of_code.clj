                                        ; Day 0, Hello, World.

(println (str "Hello, World.\n" (read-line)))

                                        ; Day 2, Operators

(let [x (Float/parseFloat (read-line))
      y (Float/parseFloat (read-line))
      z (Float/parseFloat (read-line))
      ] (println (str
        "The total meal cost is "
        (str( int (Math/round (* x (+ 1 (/ y 100) (/ z 100)))))))
        "dollars."
        ))

                                        ; Day 3, Conditional statements

(use '[clojure.string :only (split triml)])
(
  let [
    N_t (read-line)
    N (Integer/parseInt N_t)
  ]

  ((if (= (mod N 2) 1)
    (println "Weird")
    (if (<= 2 N 5) (println "Not Weird") (if (<= 6 N 20) (println "Weird") (if (> N 20) (println "Not Weird"))))))
)

                                        ; Day 5, Loops

(use '[clojure.string :only (split triml)])
(
  let [
    N_t (read-line)
    N (Integer/parseInt N_t)
  ]
  (doseq [x (range 1 11)] (println (str N " x " x " = " (* N x))))
)

                                        ;Day 6 Review

(defn splitString [s]
  (println
    (str
      (apply str (map #(str (nth s %)) (range 0 (count s) 2)))
      " "
      (apply str (map #(str (nth s %)) (range 1 (count s) 2))))))

(
  let [
    N_t (read-line)
    N (Integer/parseInt N_t)
  ]
  (doseq [x (range 1 (+ N 1))] (splitString (read-line)))
)

                                        ;Day 7

(use '[clojure.string :only (split triml)])

(
  let [
    n_t (read-line)
    n (Integer/parseInt n_t)
  ]
  (let [
      arr_temp (read-line)
      arr_t (split arr_temp #"\s+")
      arr (map #(Integer/parseInt %) arr_t)
    ]
    (println
      (apply str
        (interpose
          " "
          (reverse arr))))))

                                        ;Day 9, Recursion

(defn factorial [n]
  (if (or (= n 0) (= n 1))
    1
    (* n (factorial (- n 1)))))

(println (factorial (Integer/parseInt (read-line))))

                                        ; Day 10, Binary Numbers

(use '[clojure.string :only (split triml)])

(
 let [
      n_t (read-line)
      n (Integer/parseInt n_t)
      ]
 (println (str (Integer/toBinaryString n))))
