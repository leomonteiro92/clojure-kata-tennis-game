(ns tennis-game.core
  (:gen-class))

;; (def player1-score (atom 0))
;; (def player2-score (atom 0))

;; (defn won-point [players player-name]
;;   (when (= (nth players 0) player-name) (swap! player1-score inc))
;;   (when (= (nth players 1) player-name) (swap! player2-score inc)))

(defn is-tied? [sc1 sc2] (= sc1 sc2))

(defn is-advantage? [sc1 sc2]
  (or (>= sc1 4) (>= sc2 4)))

(defn score-name [score]
  (cond (= score 0) "Love"
        (= score 1) "Fifteen"
        (= score 2) "Thirty"
        :else "Forty"))

(defn check-advantage [sc1 sc2]
  (let [minus-result (- sc1 sc2)]
    (cond (= minus-result 1) "Advantage player1"
          (= minus-result -1) "Advantage player2"
          (>= minus-result 2) "Win for player1"
          :else "Win for player2")))

(defn get-score [sc1 sc2]
  (cond (is-tied? sc1 sc2) (if (>= sc1 3) "Deuce" (str (score-name sc1) "-All"))
        (is-advantage? sc1 sc2) (check-advantage sc1 sc2)
        :else (str (score-name sc1) "-" (score-name sc2))))

(defn game [sc1 sc2]
  (let [highest-score (max sc1 sc2)
        player1-score (atom 0)
        player2-score (atom 0)]
    (doseq [x (range highest-score)]
      (when (< x sc1) (swap! player1-score inc))
      (when (< x sc2) (swap! player2-score inc)))
    (get-score @player1-score @player2-score)))
