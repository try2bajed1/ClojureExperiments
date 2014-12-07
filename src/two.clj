(defn privet [first two three & anothers]
  (/ (+ first (apply * anothers)) (+ two three)))




; POKER

(def players-names [["Mister" "Masta"] ["Senchurin Kolya"] ["Averchuk" "Gleb"] ["Tinkov" "Andry"] ["Nastenko" "Oleg"]])
(def players-ages
  (shuffle [20 30 40 50 60]))
(def suits-names [:spades :diamonds :clubs :hearts])

(defn make-player [name age]
  {:name name :cards [] :age age})

(def players
  (map make-player players-names players-ages))

(def cards-values
  (concat (range 2 11) [:J :Q :K :A]))

(defn make-suit [suit-name]
  (map vector (repeat suit-name) cards-values))

(defn add [& aaa]

  (apply + aaa)
 )

;(defn deck [suits-nms crd-values]
;  (for [name suits-nms
;        value crd-values] [name value]))
(def deck
  (apply concat (map make-suit suits-names)))

(defn shuffled-deck []
  (shuffle deck))

(defn get-card-to [player card]
  (assoc player :cards (conj (:cards player) card)))

(defn get-first-card-to [player deck]
  [(get-card-to player (first deck))
   (rest deck)])

(defn reject [n list]
  (if (== n 0)
    list
    (recur (dec n) (rest list))))
;(defn reject [n list]
;  (take-last (- (count list) n) list))

(defn razdacha-one-time [players deck]
  [(map get-card-to players deck)
   (reject (count players) deck)])

;(defn razdacha [n [players cards]]
;(if (== n 0)
;  [players cards]
;  (recur (dec n) (razdacha-one-time players cards))))
(defn razdacha [n pds]
  (if (== n 0)
    pds
    (recur (dec n) (apply razdacha-one-time pds))))

(def slice rest)

(defn flop [n deck]
  [(take n (slice deck))
   (reject (inc n) deck)])

(defn add-flop [players deck]
  (cons players (flop 3 deck)))

(defn play-game []
  (apply add-flop (razdacha 2 [players (shuffled-deck)])))



(def data (range 2 8))
(map #(apply + %) (map vector data (reverse data) (repeat 1)))




;(defn rds [lambda acc list]
;  (if (empty? list)
;    acc
;    (recur lambda
;           (lambda acc (first list))
;           (rest list))))




;((fn [x f] (+ x (f #(- % (* 2 x))))) 5 #(% 4))