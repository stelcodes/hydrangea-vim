(ns util.color-convert
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is run-tests]]))

(comment (run-tests))

(def ansi-colors
  [[0x00 0x00 0x00]
   [0x80 0x00 0x00]
   [0x00 0x80 0x00]
   [0x80 0x80 0x00]
   [0x00 0x00 0x80]
   [0x80 0x00 0x80]
   [0x00 0x80 0x80]
   [0xc0 0xc0 0xc0]
   [0x80 0x80 0x80]
   [0xff 0x00 0x00]
   [0x00 0xff 0x00]
   [0xff 0xff 0x00]
   [0x00 0x00 0xff]
   [0xff 0x00 0xff]
   [0x00 0xff 0xff]
   [0xff 0xff 0xff]])

(def cube-intensities [0x00, 0x5f, 0x87, 0xaf, 0xd7, 0xff])

(defn divmod [x y]
  [(int (/ x y)) (mod x y)])

(deftest divmod-test
  (is (= [1 2] (divmod 5 3))))

(defn index2xtermrgb [i]
  (cond
   (< i 16)
   (nth ansi-colors i)

   (< i 232)
   (let [[tmp b] (divmod (- i 16) 6)
         [tmp g] (divmod tmp 6)
         [tmp r] (divmod tmp 6)]
     (->>
      [r g b]
      (map #(nth cube-intensities %))
      vec))

   :else
   (vec (repeat 3 (+ 8 (* 10 (- i 232)))))))

(deftest index2xtermrgb-test
  (is (= [0 0 0] (index2xtermrgb 0)))
  (is (= [0 255 0] (index2xtermrgb 10)))
  (is (= [0 0 215] (index2xtermrgb 20)))
  (is (= [0 135 135] (index2xtermrgb 30)))
  (is (= [0 215 0] (index2xtermrgb 40)))
  (is (= [0 255 215] (index2xtermrgb 50)))
  (is (= [95 95 135] (index2xtermrgb 60)))
  (is (= [95 175 0] (index2xtermrgb 70)))
  (is (= [95 215 215] (index2xtermrgb 80)))
  (is (= [135 0 135] (index2xtermrgb 90)))
  (is (= [135 135 0] (index2xtermrgb 100)))
  (is (= [135 175 215] (index2xtermrgb 110)))
  (is (= [135 255 135] (index2xtermrgb 120)))
  (is (= [175 95 0] (index2xtermrgb 130)))
  (is (= [175 135 215] (index2xtermrgb 140)))
  (is (= [175 215 135] (index2xtermrgb 150)))
  (is (= [215 0 0] (index2xtermrgb 160)))
  (is (= [215 95 215] (index2xtermrgb 170)))
  (is (= [215 175 135] (index2xtermrgb 180)))
  (is (= [215 255 0] (index2xtermrgb 190)))
  (is (= [255 0 215] (index2xtermrgb 200)))
  (is (= [255 135 135] (index2xtermrgb 210)))
  (is (= [255 215 0] (index2xtermrgb 220)))
  (is (= [255 255 215] (index2xtermrgb 230)))
  (is (= [88 88 88] (index2xtermrgb 240)))
  (is (= [188 188 188] (index2xtermrgb 250))))

;; Euclidean distance
(defn euclidean
  "Returns rounded double with 3 digits of precision"
  [[r1 g1 b1] [r2 g2 b2]]
  (->
   (+ (Math/pow (- r2 r1) 2)
      (Math/pow (- g2 g1) 2)
      (Math/pow (- b2 b1) 2))
   Math/sqrt
   (* 1000)
   Math/round
   (/ 1000)
   double))

(deftest euclidean-test
  (is (= 192.419 (euclidean [255, 95, 0] [175, 95, 175])))
  (is (= 113.137 (euclidean [215, 135, 215] [135, 215, 215])))
  (is (= 56.569 (euclidean [135, 175, 95] [175, 215, 95])))
  (is (= 179.513 (euclidean [175, 135, 95] [0, 95, 95])))
  (is (= 216.852 (euclidean [95, 0, 95] [215, 135, 215]))))

(defn hex->rgb [hex]
  (->> (subs hex 1)
       (partition 2)
       (map str/join)
       (map #(new BigInteger % 16))))

(deftest hex->rgb-test
  (is (= [22 158 196] (hex->rgb "#169ec4")))
  (is (= [136 15 136] (hex->rgb "#880f88"))))

(defn approx [rgb]
  (let [pallette (->> (range 256) (map index2xtermrgb))]))
