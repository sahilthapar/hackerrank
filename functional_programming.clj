                                        ; Pascal's Triangle

(defn factorial [n]
  (if (or (= n 0) (= n 1))
    1
    (* n (factorial (dec n)))
    )
  )

(defn getCell [i j]
  (/ (factorial i) (* (factorial j) (factorial (- i j)))))

(defn get_row [n]
  (map #(getCell n %) (range (+ 1 n))))

(let
    [n (Integer/parseInt (read-line))]
  (doseq [x (range n)]
    (println
     (apply str
       (interpose " " (get_row x))))))

                                        ; String mingling
(let [p (read-line)
      q (read-line)]
 (println (apply str (interleave p q))))

                                        ; String-o-Permute


(defn permute [s]
  (map #(nth s %)
       (interleave
        (filter odd? (range (count s)))
        (filter even? (range (count s))))))


(let [n (Integer/parseInt (read-line))]
  (doseq [x (range n)]
    (println (apply str (permute (read-line))))))

                                        ; String compression

(defn compress
  ([[f & r] n]
   (if (= (count r) 0)
     (if (= n 1)
       (cons f [])
       (cons f [n]))
     (if (= f (first r))
       (compress r (+ n 1))
       (if (= n 1)
         (cons f (compress r 1))
         (cons [f n] (compress r 1) )
         ))))
  ([s] (compress s 1)))

(print (apply str (flatten (compress (read-line)))))

                                        ; Prefix compression

(defn prefixCompress
  [[f1 & r1] [f2 & r2] n]
  (if (not= f1 f2)
    n
    (if (and (nil? r1) (nil? r2))
      (inc n)
      (prefixCompress r1 r2 (inc n)))))

(let [s1 (read-line)
      s2 (read-line)
      l  (prefixCompress s1 s2 0)]
  (doseq [x [
             [l (subs s1 0 l)]
             [(- (count s1) l) (subs s1 l)]
             [(- (count s2) l) (subs s2 l)]]]

    (println (first x) (second x))))



(defn stringReduce [[f & r] s]
  (if (nil? f)
    s
    (if (some #(= f %) s)
      (stringReduce r s)
      (stringReduce r (conj s f)))))

(print (apply str (stringReduce (read-line) [])))
