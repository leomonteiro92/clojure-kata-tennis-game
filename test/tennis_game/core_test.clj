(ns tennis-game.core-test
  (:require [clojure.test :refer :all]
            [tennis-game.core :refer :all]))

(deftest a-test
  (testing "check All Scores Tennis Game 1"
    (is (= "Love-All" (game 0 0)))
    (is (= "Fifteen-All" (game 1 1)))
    (is (= "Thirty-All" (game 2 2)))
    (is (= "Deuce" (game 3 3)))
    (is (= "Deuce" (game 4 4)))
    
    (is (= "Fifteen-Love" (game 1 0)))
    (is (= "Love-Fifteen" (game 0 1)))
    (is (= "Thirty-Love" (game 2 0)))
    (is (= "Love-Thirty" (game 0 2)))
    (is (= "Forty-Love" (game 3 0)))
    (is (= "Love-Forty" (game 0 3)))
    (is (= "Win for player1" (game 4 0)))
    (is (= "Win for player2" (game 0 4)))

    (is (= "Thirty-Fifteen" (game 2 1)))
    (is (= "Fifteen-Thirty" (game 1 2)))
    (is (= "Forty-Fifteen" (game 3 1)))
    (is (= "Fifteen-Forty" (game 1 3)))
    (is (= "Win for player1" (game 4 1)))
    (is (= "Win for player2" (game 1 4)))

    (is (= "Forty-Thirty" (game 3 2)))
    (is (= "Thirty-Forty" (game 2 3)))
    (is (= "Win for player1" (game 4 2)))
    (is (= "Win for player2" (game 2 4)))

    (is (= "Advantage player1" (game 4 3)))
    (is (= "Advantage player2" (game 3 4)))
    (is (= "Advantage player1" (game 5 4)))
    (is (= "Advantage player2" (game 4 5)))
    (is (= "Advantage player1" (game 15 14)))
    (is (= "Advantage player2" (game 14 15)))

    (is (= "Win for player1" (game 6 4)))
    (is (= "Win for player2" (game 4 6)))
    (is (= "Win for player1" (game 16 14)))
    (is (= "Win for player2" (game 14 16)))))
