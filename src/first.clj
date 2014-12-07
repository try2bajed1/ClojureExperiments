(def my-array [1, 2, 3])

(def hello-world
  (println "Hello world"))

(defn hello [person]
  (println (str "Hello " person "!")))

(def my-graph
  {
    1 [2, 3],
    2 [1, 3],
    3 [1, 4, 2],
    4 [3]
  })

;(def empty-graph {})
;
;(defn add-to-graph
;  [graph, key, values])

(defn print-graph [graph]
  (recur []))



(letfn [(map-vals [m f]
          (into {} (for [[k v] m] [k (f v)])))]
  (map-vals m #(= Integer (type %))))


(def macros-try [first #(= Integer (type %))]
  println (str first " " (str )))


(defn f
  ([m] (f {} m))
  ([res m] (if (empty? m)
             res
             (let [[k v] (first m)]
               (recur (assoc res k (= Integer (type v)))
                 (rest m))))))

; 2 - first - t - 4
; \----------/