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

; Enter your code here. Read input from STDIN. Print output to STDOUT
;
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
